/* 
 * Created on 06.12.2004
 *
 * Copyright (c) 2004/2005, Remo Griesch/Stefan Forstner/Philipp Schneider
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * - Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * - Neither the name of the Remo Griesch/Stefan Forstner/Philipp Schneider nor
 * the names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 */
package de.hsharz.provirent.management.gui;

import java.text.DateFormat;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.cloudgarden.resource.SWTResourceManager;

import de.hsharz.provirent.objects.MovieOrder;
import de.hsharz.provirent.objects.OrderItem;
import de.hsharz.provirent.persistence.Database;

/**
 * @author Stefan Forstner
 *
 */
public class CompositeOrder extends AbstractComposite {

    private final static int MODE_VIEW = 0;

    private final static int MODE_ADD = 1;
    
    private final static int MODE_EDIT = 2;
    
    private Composite parent;
    private StatusLineStyledText statusLine;
    private ResourceBundle l;
    
    
    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }
    
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(CompositeCustomer.class);
    private SashForm sashForm1;

    private Group groupOrder;

    private SashForm sashFormOrder;

    private Group groupOrderOverview;

    private Label labelOrderSearch;

    private Text textOrderSearch;

    private Table tableOrder;

    private TableColumn tableColumn;
    
    private Table tableOrderItems;

    private Group groupOrderDetail;

    private MovieOrder localCustomer;

    private SashForm sashFormOrderDetail;

    private Group groupOrderDetails;

    private Group groupOrderItemDetails;

    private Label labelOrderId;

    private Label labelOrderCustomerName;

    private Text textOrderId;

    private Text textOrderCustomerName;

    private Label labelOrderCustomerLastName;

    private Text textOrderCustomerLastName;

    private Label labelOrderCustomerFirstName;

    private Text textOrderCustomerFirstName;
    
    /**
     * @param p
     * @param style
     * @param status
     * @param l
     */
    public CompositeOrder(Composite p, int style, StatusLineStyledText status, Locale l) {
        super(p, style, status, l);
        parent = p;
        //Statusline wird gestzt
        statusLine = status;

        //sprache wird init
        initLanguage(l);

        initGUI();
    }
    
    public static void showGUI() {
        Display display = Display.getDefault();
        Shell shell = new Shell(display);

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }

    /**
     * 
     */
    private void initGUI() {
        if (logger.isDebugEnabled()) {
            logger.debug("initGUI() - start");
        }

        this.setLayout(new GridLayout());
        this.setSize(816, 540);
        {
            sashForm1 = new SashForm(this, SWT.VERTICAL | SWT.V_SCROLL);
            GridData sashForm1LData1 = new GridData();
            sashForm1LData1.grabExcessHorizontalSpace = true;
            sashForm1LData1.horizontalAlignment = GridData.FILL;
            sashForm1LData1.grabExcessVerticalSpace = true;
            sashForm1LData1.verticalAlignment = GridData.FILL;
            sashForm1.setLayoutData(sashForm1LData1);

            initOrderGroup();
            
            refreshOrderTable(textOrderSearch.getText());

        }
        this.layout();

        if (logger.isDebugEnabled()) {
            logger.debug("initGUI() - end");
        }
    }

    /**
     * @param text
     */
    private void refreshOrderTable(String filter) {
        if (logger.isDebugEnabled()) {
            logger.debug("refreshOrderTable(String) - Versuche nun OrderListe zu refreshen. Filter: "
                            + filter);
        }
        if (tableOrder == null) {
            if (logger.isDebugEnabled()) {
                logger.debug("refreshOrderTable(String) - Konnte Ordertable nicht refreshen, da diese null ist!");
            }
            return;
        }

        tableOrder.removeAll();
        TableItem item;
        java.util.List Orderlist = Database.getOrder(filter);

        for (int i = 0; i < Orderlist.size(); i++) {

            MovieOrder o = (MovieOrder) Orderlist.get(i);

            item = new TableItem(tableOrder, SWT.NONE);
                        
            item.setText(new String[] { o.getMovieOrderId() + "",
                    					o.getCustomer() == null ? "" : o.getCustomer().getUserName(), 
                    					o.getCustomer() == null ? "" : o.getCustomer().getPerson().getLastName(),
                    					o.getCustomer() == null ? "" : o.getCustomer().getPerson().getFirstName()});
        }
    }
    
    /**
     * @param text
     */
    private void refreshOrderItemTable(String id) {
        if (logger.isDebugEnabled()) {
            logger.debug("refreshOrderItemTable(String) - Versuche nun OrderItemListe zu refreshen. Filter: "
                            + id);
        }
        if (tableOrder == null) {
            if (logger.isDebugEnabled()) {
                logger.debug("refreshOrderItemTable(String) - Konnte OrderItemtable nicht refreshen, da diese null ist!");
            }
            return;
        }
        
        if (!id.equals("") && id != null) {
            MovieOrder object;
            try {
                //since we only can get a String value from the table, we
                //need to convert this
                object = Database.getSingleOrder(Integer.parseInt(id));

                if (object == null) {

                    // @TODO Statusbar aktualiseren
                    return;
                }
            } catch (Exception e) {
                //id ist keine Zahl
                return;
            }
            localCustomer = object;            
            
            tableOrderItems.removeAll();
            TableItem item;
            java.util.List OrderItemlist = localCustomer.getMovieOrderItems();

	        for (int i = 0; i < OrderItemlist.size(); i++) {
	
	            OrderItem o = (OrderItem) OrderItemlist.get(i);
	
	            item = new TableItem(tableOrderItems, SWT.NONE);
	           
	            String orderdate = "";
	            if (o.getOrderTime() != null) {
	                orderdate = DateFormat.getDateInstance(DateFormat.SHORT).format(
	                    o.getOrderTime().getTime());
	            }
	           
	            String senddate = "";
	            if (o.getSenderTime() != null) {
	                senddate = DateFormat.getDateInstance(DateFormat.SHORT).format(
	                    o.getSenderTime().getTime());
	            }
	            
	            String receivingdate = "";
	            if (o.getReceivingTime() != null) {
	                receivingdate = DateFormat.getDateInstance(DateFormat.SHORT).format(
	                    o.getReceivingTime().getTime());
	            }
	            
	            item.setText(new String[] { o.getOrderItemId() + "",
	                    o.getDvd().getDvdId().toString(), o.getDvd().getMovie().getTitle(),
	                    orderdate, 
	                    senddate, 
	                    receivingdate,
	                    o.getPayment() == null ? "" : o.getPayment().getPaymentCategory().getName(),
	                    Integer.toString(o.getDuration()),
	                    o.getConditionSend() == null ? "" : o.getConditionSend().getConditionName(),
	                    o.getConditionReceiving() == null ? "" : o.getConditionReceiving().getConditionName()});
	
	        }
        }
    }

    /**
     * 
     */
    private void initOrderGroup() {
        {
            //init a group for the Customer
            groupOrder = new Group(sashForm1, SWT.NONE);
            GridLayout group2Layout = new GridLayout();
            group2Layout.makeColumnsEqualWidth = true;
            groupOrder.setText(l.getString("Order.group.label"));
            groupOrder.setSize(758, 284);
            FormData group2LData = new FormData();
            groupOrder.addFocusListener(new FocusAdapter() {
                private Control buttonOrderCancel;
                private Control buttonOrderDelete;
                private Control buttonOrderEdit;
                private Control buttonOrderNew;
                private Control buttonOrderSave;

                public void focusLost(FocusEvent evt) {
                    if (logger.isDebugEnabled()) {
                        logger
                                .debug("focusLost(FocusEvent) - groupOrder.focusLost, event="
                                        + evt);
                    }
                    buttonOrderCancel.setEnabled(false);
                    buttonOrderDelete.setEnabled(false);
                    buttonOrderEdit.setEnabled(false);
                    buttonOrderNew.setEnabled(false);
                    buttonOrderSave.setEnabled(false);
                }
            });
            groupOrder.setLayout(group2Layout);
            groupOrder.setLayoutData(group2LData);
            {
                sashFormOrder = new SashForm(groupOrder, SWT.NONE);
                FormLayout sashForm2Layout = new FormLayout();
                sashFormOrder.setSize(748, 300);
                GridData sashForm2LData = new GridData();
                sashFormOrder.setLayout(sashForm2Layout);
                sashForm2LData.verticalAlignment = GridData.FILL;
                sashForm2LData.horizontalAlignment = GridData.FILL;
                sashForm2LData.grabExcessHorizontalSpace = true;
                sashForm2LData.grabExcessVerticalSpace = true;
                sashFormOrder.setLayoutData(sashForm2LData);

                //init die Gruppe für Customere Überblick
                initOrderGroupOverview();
                //init die Detailansicht
                initOrderGroupDetail();

            }
        }
    }

    /**
     * 
     */
    private void initOrderGroupDetail() {
        groupOrderDetail = new Group(sashFormOrder, SWT.NONE);
        GridLayout groupOrderDetailLayout = new GridLayout();
        groupOrderDetailLayout.marginHeight = 25;
        groupOrderDetailLayout.numColumns = 4;
        groupOrderDetailLayout.verticalSpacing = 15;
        groupOrderDetail.setText(l.getString("Order.groupdetail.label"));
        FormData formData = new FormData();
        groupOrderDetail.setLayout(groupOrderDetailLayout);
        formData.right = new FormAttachment(100, 100, -5);
        formData.top = new FormAttachment(0, 100, 5);
        formData.bottom = new FormAttachment(100, 100, -5);
        groupOrderDetail.setLayoutData(formData);
        {
            sashFormOrderDetail = new SashForm(groupOrderDetail, SWT.VERTICAL | SWT.V_SCROLL);
            GridData sashForm2LData = new GridData();
            sashForm2LData.verticalAlignment = GridData.FILL;
            sashForm2LData.horizontalAlignment = GridData.FILL;
            sashForm2LData.grabExcessHorizontalSpace = true;
            sashForm2LData.grabExcessVerticalSpace = true;
            sashFormOrderDetail.setLayoutData(sashForm2LData);

        }
        initOrderDetails();
        
        initOrderItemDetails();
    }

    /**
     * 
     */
    private void initOrderItemDetails() {
        groupOrderItemDetails = new Group(sashFormOrderDetail, SWT.NONE);
        GridLayout groupOrderDetailLayout = new GridLayout();
        groupOrderDetailLayout.marginHeight = 25;
        groupOrderDetailLayout.numColumns = 4;
        groupOrderDetailLayout.verticalSpacing = 15;
        groupOrderItemDetails.setText(l.getString("Order.groupdetail.orderitems.label"));
        FormData formData = new FormData();
        groupOrderItemDetails.setLayout(groupOrderDetailLayout);
        groupOrderItemDetails.setLayoutData(formData);
    }

    /**
     * 
     */
    private void initOrderDetails() {
        groupOrderDetails = new Group(sashFormOrderDetail, SWT.NONE);
        GridLayout groupOrderDetailLayout = new GridLayout();
        groupOrderDetailLayout.marginHeight = 25;
        groupOrderDetailLayout.numColumns = 4;
        groupOrderDetailLayout.verticalSpacing = 15;
        groupOrderDetails.setText(l.getString("Order.groupdetail.order.label"));
        FormData formData = new FormData();
        groupOrderDetails.setLayout(groupOrderDetailLayout);
        groupOrderDetails.setLayoutData(formData);
        {
            labelOrderId = new Label(groupOrderDetails, SWT.NONE);
            labelOrderId.setText(l
                    .getString("order.groupdetail.order.idlabel")
                    + ":");
            labelOrderId.setSize(125, 15);
            GridData formData2 = new GridData();
            formData2.widthHint = 125;
            formData2.heightHint = 15;
            formData2.horizontalSpan = 2;
            labelOrderId.setLayoutData(formData2);
        }
        {
            textOrderId = new Text(groupOrderDetails, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData1 = new GridData();
            text1LData1.horizontalAlignment = GridData.FILL;
            text1LData1.heightHint = 13;
            text1LData1.horizontalSpan = 2;
            text1LData1.grabExcessHorizontalSpace = true;
            textOrderId.setLayoutData(text1LData1);
        }
        {
            labelOrderCustomerName = new Label(groupOrderDetails, SWT.NONE);
            labelOrderCustomerName.setText(l
                    .getString("order.groupdetail.order.customernamelabel")
                    + ":");
            labelOrderCustomerName.setSize(125, 15);
            GridData formData2 = new GridData();
            formData2.widthHint = 125;
            formData2.heightHint = 15;
            formData2.horizontalSpan = 2;
            labelOrderCustomerName.setLayoutData(formData2);
        }
        {
            textOrderCustomerName = new Text(groupOrderDetails, SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData1 = new GridData();
            text1LData1.horizontalAlignment = GridData.FILL;
            text1LData1.heightHint = 13;
            text1LData1.horizontalSpan = 2;
            text1LData1.grabExcessHorizontalSpace = true;
            textOrderCustomerName.setLayoutData(text1LData1);
        }
        {
            labelOrderCustomerLastName = new Label(groupOrderDetails, SWT.NONE);
            labelOrderCustomerLastName.setText(l
                    .getString("order.groupdetail.order.customerlastnamelabel")
                    + ":");
            labelOrderCustomerLastName.setSize(125, 15);
            GridData formData2 = new GridData();
            formData2.widthHint = 125;
            formData2.heightHint = 15;
            formData2.horizontalSpan = 2;
            labelOrderCustomerLastName.setLayoutData(formData2);
        }
        {
            textOrderCustomerLastName = new Text(groupOrderDetails, SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData1 = new GridData();
            text1LData1.horizontalAlignment = GridData.FILL;
            text1LData1.heightHint = 13;
            text1LData1.horizontalSpan = 2;
            text1LData1.grabExcessHorizontalSpace = true;
            textOrderCustomerLastName.setLayoutData(text1LData1);
        }
        {
            labelOrderCustomerFirstName = new Label(groupOrderDetails, SWT.NONE);
            labelOrderCustomerFirstName.setText(l
                    .getString("order.groupdetail.order.customerfirstnamelabel")
                    + ":");
            labelOrderCustomerFirstName.setSize(125, 15);
            GridData formData2 = new GridData();
            formData2.widthHint = 125;
            formData2.heightHint = 15;
            formData2.horizontalSpan = 2;
            labelOrderCustomerFirstName.setLayoutData(formData2);
        }
        {
            textOrderCustomerFirstName = new Text(groupOrderDetails, SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData1 = new GridData();
            text1LData1.horizontalAlignment = GridData.FILL;
            text1LData1.heightHint = 13;
            text1LData1.horizontalSpan = 2;
            text1LData1.grabExcessHorizontalSpace = true;
            textOrderCustomerFirstName.setLayoutData(text1LData1);
        }
    }

    /**
     * 
     */
    private void initOrderGroupOverview() {
        if (logger.isDebugEnabled()) {
            logger.debug("initOrderGroupOverview() - start");
        }

        groupOrderOverview = new Group(sashFormOrder, SWT.NONE);
        GridLayout group5Layout = new GridLayout();
        group5Layout.numColumns = 8;
        groupOrderOverview.setText(l
                .getString("Order.groupoverview.label"));
        FormData group5LData = new FormData();
        groupOrderOverview.setLayout(group5Layout);
        group5LData.left = new FormAttachment(0, 100, 0);
        group5LData.top = new FormAttachment(0, 100, 0);
        groupOrderOverview.setLayoutData(group5LData);

        //Tabelle anzeigen
        initTableOrder();
        //Suche darunter anzeigen
        initOrderSearch();
        //Tabelle für Orderitems
        initTableOrderItems();

        if (logger.isDebugEnabled()) {
            logger.debug("initCustomerGroupOverview() - end");
        }

        
    }

    /**
     * 
     */
    private void initTableOrderItems() {
        if (logger.isDebugEnabled()) {
            logger.debug("initTableOrderItems() - start");
        }

        tableOrderItems = new Table(groupOrderOverview, SWT.SINGLE
                | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.BORDER);
        tableOrderItems.setHeaderVisible(true);
        tableOrderItems.setLinesVisible(true);
        GridData table2LData = new GridData();

        tableOrderItems.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {

                int index = tableOrderItems.getSelectionIndex();

                //es wurde ein Element aus Tabelle ausgewaehlt jetzt muss die
                //Detailansicht aktualisiert werden
                refreshOrderItemTable(tableOrderItems.getItem(index).getText(0));

            }
        });
        table2LData.verticalAlignment = GridData.FILL;
        table2LData.horizontalAlignment = GridData.FILL;
        table2LData.horizontalSpan = 8;
        table2LData.grabExcessHorizontalSpace = true;
        table2LData.grabExcessVerticalSpace = true;
        tableOrderItems.setLayoutData(table2LData);

        //einzelne Spalten hinzufügen
        tableColumn = new TableColumn(tableOrderItems, SWT.CENTER);
        tableColumn.setText(l.getString("OrderItems.groupoverview.columnid"));
        tableColumn.setWidth(50);

        tableColumn = new TableColumn(tableOrderItems, SWT.CENTER);
        tableColumn.setText(l
                .getString("OrderItems.groupoverview.columndvdid"));
        tableColumn.setWidth(50);

        tableColumn = new TableColumn(tableOrderItems, SWT.CENTER);
        tableColumn.setText(l
                .getString("OrderItems.groupoverview.columnmoviename"));
        tableColumn.setWidth(70);
        
        tableColumn = new TableColumn(tableOrderItems, SWT.CENTER);
        tableColumn.setText(l
                .getString("OrderItems.groupoverview.columnordertime"));
        tableColumn.setWidth(70);
        
        tableColumn = new TableColumn(tableOrderItems, SWT.CENTER);
        tableColumn.setText(l
                .getString("OrderItems.groupoverview.columnsendertime"));
        tableColumn.setWidth(70);
        
        tableColumn = new TableColumn(tableOrderItems, SWT.CENTER);
        tableColumn.setText(l
                .getString("OrderItems.groupoverview.columnreceivingtime"));
        tableColumn.setWidth(70);
        
        tableColumn = new TableColumn(tableOrderItems, SWT.CENTER);
        tableColumn.setText(l
                .getString("OrderItems.groupoverview.columnpayment"));
        tableColumn.setWidth(70);
        
        tableColumn = new TableColumn(tableOrderItems, SWT.CENTER);
        tableColumn.setText(l
                .getString("OrderItems.groupoverview.columnduration"));
        tableColumn.setWidth(70);
        
        tableColumn = new TableColumn(tableOrderItems, SWT.CENTER);
        tableColumn.setText(l
                .getString("OrderItems.groupoverview.columnconditionsend"));
        tableColumn.setWidth(70);
        
        tableColumn = new TableColumn(tableOrderItems, SWT.CENTER);
        tableColumn.setText(l
                .getString("OrderItems.groupoverview.columnconditionreceiving"));
        tableColumn.setWidth(70);

        if (logger.isDebugEnabled()) {
            logger.debug("initTableOrderItems() - end");
        }
    }

    /**
     * 
     */
    private void initOrderSearch() {
        if (logger.isDebugEnabled()) {
            logger.debug("initOrderSearch() - start");
        }

        //label für die Suche
        labelOrderSearch = new Label(groupOrderOverview, SWT.NONE);
        labelOrderSearch.setText(l
                .getString("Order.groupoverview.searchlabel")
                + ":");
        GridData label2LData = new GridData();
        label2LData.horizontalSpan = 3;
        labelOrderSearch.setLayoutData(label2LData);

        //das Suchfeld
        textOrderSearch = new Text(groupOrderOverview, SWT.BORDER);
        GridData text2LData = new GridData();
        textOrderSearch.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                if (logger.isDebugEnabled()) {
                    logger.debug("focusLost(FocusEvent evt = " + evt + " "
                            + textOrderSearch.getText() + ") - start");
                }
                
                /* TODO
                try {
                    refreshOrderTable(textOrderSearch.getText());
                } catch (DataBaseException e) {
                    logger.error("focusLost(FocusEvent)", e);
                }*/

                if (logger.isDebugEnabled()) {
                    logger.debug("focusLost(FocusEvent) - end");
                }
            }
        });

        textOrderSearch.addListener(SWT.DefaultSelection, new Listener() {
            public void handleEvent(Event e) {
                if (logger.isDebugEnabled()) {
                    logger.debug("handleEvent(Event e = " + e + " "
                            + textOrderSearch.getText() + ") - start");
                }
                
                /* TODO
                try {
                    refreshOrderTable(textOrderSearch.getText());
                } catch (DataBaseException e1) {
                    logger.error("handleEvent(Event)", e1);
                }*/

                if (logger.isDebugEnabled()) {
                    logger.debug("handleEvent(Event) - end");
                }
            }
        });

        text2LData.horizontalAlignment = GridData.FILL;
        text2LData.horizontalSpan = 5;
        text2LData.grabExcessHorizontalSpace = true;
        textOrderSearch.setLayoutData(text2LData);

        if (logger.isDebugEnabled()) {
            logger.debug("initOrderSearch() - end");
        }
    }

    /**
     * 
     */
    private void initTableOrder() {
        if (logger.isDebugEnabled()) {
            logger.debug("initTableOrder() - start");
        }

        tableOrder = new Table(groupOrderOverview, SWT.SINGLE
                | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.BORDER);
        tableOrder.setHeaderVisible(true);
        tableOrder.setLinesVisible(true);
        GridData table2LData = new GridData();

        tableOrder.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {

                int index = tableOrder.getSelectionIndex();

                //es wurde ein Element aus Tabelle ausgewaehlt jetzt muss die
                //Detailansicht aktualisiert werden
                refreshOrderItemTable(tableOrder.getItem(index).getText(0));

            }
        });
        table2LData.verticalAlignment = GridData.FILL;
        table2LData.horizontalAlignment = GridData.FILL;
        table2LData.horizontalSpan = 8;
        table2LData.grabExcessHorizontalSpace = true;
        table2LData.grabExcessVerticalSpace = true;
        tableOrder.setLayoutData(table2LData);

        //einzelne Spalten hinzufügen
        tableColumn = new TableColumn(tableOrder, SWT.CENTER);
        tableColumn.setText(l.getString("Order.groupoverview.columnid"));
        tableColumn.setWidth(50);

        tableColumn = new TableColumn(tableOrder, SWT.CENTER);
        tableColumn.setText(l
                .getString("Order.groupoverview.columnusername"));
        tableColumn.setWidth(50);

        tableColumn = new TableColumn(tableOrder, SWT.CENTER);
        tableColumn.setText(l
                .getString("Order.groupoverview.columnlastname"));
        tableColumn.setWidth(70);
        
        tableColumn = new TableColumn(tableOrder, SWT.CENTER);
        tableColumn.setText(l
                .getString("Order.groupoverview.columnfirstname"));
        tableColumn.setWidth(70);

        if (logger.isDebugEnabled()) {
            logger.debug("initTableOrder() - end");
        }
    }

    /* (non-Javadoc)
     * @see de.hsharz.provirent.management.gui.AbstractComposite#changeLanguage(java.util.Locale)
     */
    public void changeLanguage(Locale l) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see de.hsharz.provirent.management.gui.AbstractComposite#initLanguage(java.util.Locale)
     */
    public void initLanguage(Locale locale) {
        l = PropertyResourceBundle.getBundle(
                "de.hsharz.provirent.management.gui.language.Order", locale);
    }

    public static void main(String[] args) {
    }
}

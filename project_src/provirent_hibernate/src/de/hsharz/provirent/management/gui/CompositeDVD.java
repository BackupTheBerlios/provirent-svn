package de.hsharz.provirent.management.gui;

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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.cloudgarden.resource.SWTResourceManager;


/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
public class CompositeDVD extends AbstractComposite {

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }
    
    private static final Logger logger = Logger
    .getLogger(CompositeDVD.class);
    
    private Group groupDVD;
    
    private Group groupDVDOverview;
    
    private Group groupDVDDetail;
    
    private Table tableDVDOverview;
    
    private TableColumn tableDVDOverview_ColumnID;

    private TableColumn tableDVDOverview_ColumnTitle;

    private TableColumn tableDVDOverview_ColumnStatus;
    
    private TableColumn tableDVDOverview_ColumnCondition;
    
    private Text textDVDSearch;
    
    private Text textDVDID;
    
    private Label labelDVDSearch;
   
    private Label labelDVDID;
    
    private Composite parent;
    
    private SashForm sashForm1;
    
    private int mode_dvd;
    
    private Locale locale;
    
    private StatusLineStyledText statusLine;
    
    private ResourceBundle l;
    
    /*
     * Ändert die Sprache aller Elemente
     * 
     * @see de.hsharz.provirent.managment.gui.AbstractComposite#changeLanguage(java.util.Locale)
     */
    public void changeLanguage(Locale locale) {

    }

    /* 
     * Init die Sprache (properties Datei)
     * @see de.hsharz.provirent.managment.gui.AbstractComposite#initLanguage(java.util.Locale)
     */
    public void initLanguage(Locale locale) {

        l = PropertyResourceBundle.getBundle(
                "de.hsharz.provirent.management.gui.language.dvds", locale);

    }
    
    
    
    /**
     * Auto-generated main method to display this
     * de.hsharz.provirent.management.gui.AbstractComposite inside a new Shell.
     */
    public static void main(String[] args) {
        showGUI();
    }

    /**
     * Auto-generated method to display this
     * de.hsharz.provirent.management.gui.AbstractComposite inside a new Shell.
     */
    /**
     * Auto-generated method to display this org.eclipse.swt.widgets.Composite
     * inside a new Shell.
     */
    public static void showGUI() {
        Display display = Display.getDefault();
        Shell shell = new Shell(display);

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }

    public CompositeDVD(Composite p, int style, StatusLineStyledText status,
            Locale l) {
        super(p, style, status, l);
        parent = p;
        //Statusline wird gestzt
        statusLine = status;

        locale = l;
        //sprache wird init
        initLanguage(locale);

        initGUI();
    }

    private void initGUI() {
        if (logger.isDebugEnabled()) {
            logger.debug("initGUI() - start");
        }

        this.setLayout(new GridLayout());
        this.setSize(830, 650);
        {
            groupDVD = new Group(this, SWT.NONE);
            GridLayout groupDVDLayout = new GridLayout();
            GridData groupDVDLData = new GridData();
            groupDVDLData.grabExcessHorizontalSpace = true;
            groupDVDLData.grabExcessVerticalSpace = true;
            groupDVDLData.horizontalAlignment = GridData.FILL;
            groupDVDLData.verticalAlignment = GridData.FILL;
            groupDVD.setLayoutData(groupDVDLData);
            groupDVDLayout.makeColumnsEqualWidth = true;
            groupDVD.setLayout(groupDVDLayout);
            groupDVD.setText(l.getString("dvd.group.label"));
            {
                sashForm1 = new SashForm(groupDVD, SWT.NONE);
                GridData sashForm1LData = new GridData();
                sashForm1LData.verticalAlignment = GridData.FILL;
                sashForm1LData.horizontalAlignment = GridData.FILL;
                sashForm1LData.grabExcessHorizontalSpace = true;
                sashForm1LData.grabExcessVerticalSpace = true;
                sashForm1.setLayoutData(sashForm1LData);

            }
            // init the rest of the layout
            initDVDOverview();
            initDVDDetail();
            //refreshDVDOverviewTable(textDVDSearch.getText());
        }

        this.layout();

        if (logger.isDebugEnabled()) {
            logger.debug("initGUI() - end");
        }
    }

    /**
     * 
     */
    private void initDVDOverview() {
        //	  Group DVD Overview
        {
            groupDVDOverview = new Group(sashForm1, SWT.NONE);
            GridLayout group1Layout = new GridLayout();
            group1Layout.numColumns = 8;
            groupDVDOverview.setLayout(group1Layout);
            groupDVDOverview.setText(l
                    .getString("dvd.groupoverview.label"));

            {// table Actors Overview
                tableDVDOverview = new Table(groupDVDOverview, SWT.SINGLE
                        | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.BORDER);
                GridData tableDVDOverviewLData = new GridData();
                tableDVDOverview.setHeaderVisible(true);
                tableDVDOverview.setLinesVisible(true);
                tableDVDOverviewLData.horizontalAlignment = GridData.FILL;
                tableDVDOverviewLData.verticalAlignment = GridData.FILL;
                tableDVDOverviewLData.horizontalSpan = 8;
                tableDVDOverviewLData.grabExcessHorizontalSpace = true;
                tableDVDOverviewLData.grabExcessVerticalSpace = true;
                tableDVDOverview.setLayoutData(tableDVDOverviewLData);
                tableDVDOverview
                        .addSelectionListener(new SelectionAdapter() {
                            public void widgetSelected(SelectionEvent evt) {
                                int index = tableDVDOverview
                                        .getSelectionIndex();

                                //es wurde ein Element aus Tabelle ausgewaehlt
                                // jetzt muss die
                                //Detailansicht aktualisiert werden
                                refreshDVDDetail(tableDVDOverview
                                        .getItem(index).getText(0));
                            }
                        });
                {
                    tableDVDOverview_ColumnID = new TableColumn(
                            tableDVDOverview, SWT.CENTER);
                    tableDVDOverview_ColumnID.setText(l
                            .getString("dvd.groupoverview.columnid"));
                    tableDVDOverview_ColumnID.setWidth(40);
                }
                {
                    tableDVDOverview_ColumnTitle = new TableColumn(
                            tableDVDOverview, SWT.CENTER);
                    tableDVDOverview_ColumnTitle.setText(l
                            .getString("dvd.groupoverview.columntitle"));
                    tableDVDOverview_ColumnTitle.setWidth(120);
                }
                {
                    tableDVDOverview_ColumnStatus = new TableColumn(
                            tableDVDOverview, SWT.CENTER);
                    tableDVDOverview_ColumnStatus.setText(l
                            .getString("dvd.groupoverview.columnstatus"));
                    tableDVDOverview_ColumnStatus.setWidth(120);
                }
                {
                    tableDVDOverview_ColumnCondition = new TableColumn(
                            tableDVDOverview, SWT.CENTER);
                    tableDVDOverview_ColumnCondition.setText(l
                            .getString("dvd.groupoverview.columncondition"));
                    tableDVDOverview_ColumnCondition.setWidth(120);
                }
            }// table Movies Overview

            // Search
            {
                //label for Search
                labelDVDSearch = new Label(groupDVDOverview, SWT.NONE);
                labelDVDSearch.setText(l
                        .getString("dvd.groupoverview.searchlabel")
                        + ":");
                GridData label2LData = new GridData();
                label2LData.horizontalSpan = 3;
                labelDVDSearch.setLayoutData(label2LData);

                //text Search
                textDVDSearch = new Text(groupDVDOverview, SWT.BORDER);
                GridData text2LData = new GridData();
                textDVDSearch.addFocusListener(new FocusAdapter() {
                    public void focusLost(FocusEvent evt) {
                        if (logger.isDebugEnabled()) {
                            logger.debug("focusLost(FocusEvent evt = " + evt
                                    + " " + textDVDSearch.getText()
                                    + ") - start");
                        }

                        refreshDVDOverviewTable(textDVDSearch.getText());

                        if (logger.isDebugEnabled()) {
                            logger.debug("focusLost(FocusEvent) - end");
                        }
                    }
                });
                textDVDSearch.addListener(SWT.DefaultSelection,new Listener() {
                            public void handleEvent(Event e) {
                                if (logger.isDebugEnabled()) {
                                    logger.debug("handleEvent(Event e = " + e
                                            + " " + textDVDSearch.getText()
                                            + ") - start");
                                }

                                refreshDVDOverviewTable(textDVDSearch
                                        .getText());

                                if (logger.isDebugEnabled()) {
                                    logger.debug("handleEvent(Event) - end");
                                }
                            }

                        });
                text2LData.horizontalAlignment = GridData.FILL;
                text2LData.horizontalSpan = 5;
                text2LData.grabExcessHorizontalSpace = true;
                textDVDSearch.setLayoutData(text2LData);
            }// Search
        } 
    }
    
 
    /**
     * 
     */
    private void initDVDDetail() {
        // TODO Auto-generated method stub
        //      Group DVD Detail
		{
			groupDVDDetail = new Group(sashForm1, SWT.H_SCROLL);
			GridLayout group2Layout = new GridLayout();
			GridData group2LData = new GridData();
			group2Layout.verticalSpacing = 15;
			group2Layout.numColumns = 6;
			groupDVDDetail.setText(l.getString("dvd.groupdetail.label"));
			FormData formData = new FormData();
			groupDVDDetail.setLayout(group2Layout);
			formData.right = new FormAttachment(100, 100, -5);
			formData.top = new FormAttachment(0, 100, 5);
			formData.bottom = new FormAttachment(100, 100, -5);
			groupDVDDetail.setLayoutData(formData);
		}
		//      labels and text for detail
		{
			labelDVDID = new Label(groupDVDDetail, SWT.NONE);
			labelDVDID.setText(l.getString("dvd.groupdetail.labelid")
					+ ":");
			labelDVDID.setSize(125, 15);
			GridData formData2 = new GridData();
			formData2.heightHint = 15;
			formData2.horizontalAlignment = GridData.FILL;
			formData2.verticalAlignment = GridData.BEGINNING;
			labelDVDID.setLayoutData(formData2);
		}
		{
			textDVDID = new Text(groupDVDDetail, SWT.READ_ONLY
					| SWT.BORDER);
			GridData text1LData1 = new GridData();
			text1LData1.horizontalAlignment = GridData.FILL;
			text1LData1.heightHint = 13;
			text1LData1.grabExcessHorizontalSpace = true;
			text1LData1.horizontalSpan = 5;
			textDVDID.setLayoutData(text1LData1);
		}
    }

    
    /**
     * @param text
     */
    private void refreshDVDOverviewTable(String text) {
        // TODO Auto-generated method stub
        
    }
  
    
    /**
     * @param text
     */
    protected void refreshDVDDetail(String text) {
        // TODO Auto-generated method stub
        
    }

}

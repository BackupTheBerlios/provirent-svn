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
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;


import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.layout.GridData;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
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
public class CompositeActors extends AbstractComposite{

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }


    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(CompositeActors.class);
    
    
    private final static int MODE_VIEW = 0;
    private final static int MODE_ADD = 1;
    private final static int MODE_EDIT = 2;
    
    private Table tableActorsOverview;
    private TableColumn tableActorsOverview_ColumnID;
    private TableColumn tableActorsOverview_ColumnFName;
    private TableColumn tableActorsOverview_ColumnLName;
    
    
    private SashForm sashForm1;
    private SashForm sashForm2;
    
    private Group groupActor;
    private Group groupActorsOverview;
    private Group groupActorsDetail;
    
    private Text textActorsSearch;
    
    private Label labelActorsSearch;
    
    private StatusLineStyledText statusLine;

    private ResourceBundle l;
    
    private Composite parent;
    
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
                "de.hsharz.provirent.managment.gui.language.actors", locale);

    }
    
    
	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void main(String[] args) {
		showGUI();
	}
		
	/**
	* Auto-generated method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
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

	public CompositeActors(Composite p, int style,
            StatusLineStyledText status, Locale l) {
	    super(p, style, status, l);
        parent = p;
        //Statusline wird gestzt
        statusLine = status;
        
        //sprache wird init
        initLanguage(l);
	    
	    
		initGUI();
	}

	private void initGUI() {
        if (logger.isDebugEnabled()) {
            logger.debug("initGUI() - start");
        }

        this.setLayout(new GridLayout());
        this.setSize(816, 540);
        {
            groupActor = new Group(this, SWT.NONE);
            GridLayout groupActorLayout = new GridLayout();
            GridData groupActorLData = new GridData();
            groupActorLData.grabExcessHorizontalSpace = true;
            groupActorLData.grabExcessVerticalSpace = true;
            groupActorLData.horizontalAlignment = GridData.FILL;
            groupActorLData.verticalAlignment = GridData.FILL;
            groupActor.setLayoutData(groupActorLData);
            groupActorLayout.makeColumnsEqualWidth = true;
            groupActor.setLayout(groupActorLayout);
            groupActor.setText(l.getString("actors.group.label"));
            {
                sashForm2 = new SashForm(groupActor, SWT.NONE);
                GridData sashForm2LData = new GridData();
                sashForm2LData.verticalAlignment = GridData.FILL;
                sashForm2LData.horizontalAlignment = GridData.FILL;
                sashForm2LData.grabExcessHorizontalSpace = true;
                sashForm2LData.grabExcessVerticalSpace = true;
                sashForm2.setLayoutData(sashForm2LData);
                // Group Actors Overview 
                {
                    groupActorsOverview = new Group(sashForm2,SWT.NONE);
                    GridLayout group1Layout = new GridLayout();
                    groupActorsOverview.setBounds(0, 0, 781, 487);
                    groupActorsOverview.setBounds(0, 0, 647, 448);
                    group1Layout.makeColumnsEqualWidth = true;
                    GridData group1LData = new GridData();
                    group1Layout.makeColumnsEqualWidth = true;
                    groupActorsOverview.setLayout(group1Layout);
                    groupActorsOverview.setText(l.getString("actors.groupoverview.label"));
                    {
                        tableActorsOverview = new Table(
                            groupActorsOverview,
                            SWT.SINGLE
                                | SWT.FULL_SELECTION
                                | SWT.V_SCROLL | SWT.BORDER);
                        GridData tableActorsOverviewLData = new GridData();
                        tableActorsOverview.setHeaderVisible(true);
                        tableActorsOverview.setLinesVisible(true);
                        tableActorsOverviewLData.horizontalAlignment = GridData.FILL;
                        tableActorsOverviewLData.verticalAlignment = GridData.FILL;
                        tableActorsOverviewLData.horizontalSpan = 8;
                        tableActorsOverviewLData.grabExcessHorizontalSpace = true;
                        tableActorsOverviewLData.grabExcessVerticalSpace = true;
                        tableActorsOverview
                            .setLayoutData(tableActorsOverviewLData);
                        tableActorsOverview
                            .addFocusListener(new FocusAdapter() {
                                public void focusLost(FocusEvent evt) {
                                    System.out
                                        .println("tableActorsOverview.focusLost, event="
                                            + evt);
                                    //TODO add your code for tableVideoFormat.focusLost
                                }
                                public void focusGained(FocusEvent evt) {
                                    System.out
                                        .println("tableActorsOverview.focusGained, event="
                                            + evt);
                                    //TODO add your code for tableVideoFormat.focusGained
                                }
                            });
                        tableActorsOverview
                            .addSelectionListener(new SelectionAdapter() {
                                public void widgetSelected(SelectionEvent evt) {
                                    if (logger.isDebugEnabled()) {
                                        logger
                                            .debug("widgetSelected(SelectionEvent evt = "
                                                + evt
                                                + ") - start");
                                    }

                                    int index = tableActorsOverview
                                        .getSelectionIndex();

                                    System.out.println("Table select. id: "
                                        + index
                                        + " TableItem:"
                                        + tableActorsOverview.getItem(index)
                                        + " id: "
                                        + tableActorsOverview.getItem(index)
                                            .getText(0));

                                    //es wurde ein Element aus Tabelle ausgewaehlt jetzt muss die
                                    //Detailansicht aktualisiert werden
                                    //                               refreshActorsDetail(tableActorsOverview.getItem(index)
                                    //                                   .getText(0));

                                    if (logger.isDebugEnabled()) {
                                        logger
                                            .debug("widgetSelected(SelectionEvent) - end");
                                    }
                                }
                            });

                        {
                            tableActorsOverview_ColumnID = new TableColumn(
                                tableActorsOverview,
                                SWT.CENTER);
                            tableActorsOverview_ColumnID.setText(l
                                .getString("actors.groupoverview.columnid"));
                            tableActorsOverview_ColumnID.setWidth(40);
                        }
                        {
                            tableActorsOverview_ColumnFName = new TableColumn(
                                tableActorsOverview,
                                SWT.CENTER);
                            tableActorsOverview_ColumnFName.setText(l
                                .getString("actors.groupoverview.columnid"));
                            tableActorsOverview_ColumnFName.setWidth(80);
                        }
                        {
                            tableActorsOverview_ColumnLName = new TableColumn(
                                tableActorsOverview,
                                SWT.CENTER);
                            tableActorsOverview_ColumnLName.setText(l
                                .getString("actors.groupoverview.columnid"));
                            tableActorsOverview_ColumnLName.setWidth(80);
                        }
                    }// table Actors Overview
                    // table Actors Overview
                    // Search
                    {
                        //label für die Suche
                        labelActorsSearch = new Label(groupActorsOverview, SWT.NONE);
                        labelActorsSearch.setText(l
                                .getString("actors.groupoverview.searchlabel")
                                + ":");
                        GridData label2LData = new GridData();
                        label2LData.horizontalSpan = 3;
                        labelActorsSearch.setLayoutData(label2LData);

                        //das Suchfeld
                        textActorsSearch = new Text(groupActorsOverview, SWT.BORDER);
                        GridData text2LData = new GridData();
                        textActorsSearch.addFocusListener(new FocusAdapter() {
                            public void focusLost(FocusEvent evt) {
                                if (logger.isDebugEnabled()) {
                                    logger.debug("focusLost(FocusEvent evt = " + evt + " "
                                            + textActorsSearch.getText() + ") - start");
                                }

                   //             refreshVideoFormatTable(textVideoFormatSearch.getText());

                                if (logger.isDebugEnabled()) {
                                    logger.debug("focusLost(FocusEvent) - end");
                                }
                            }
                        });
                        textActorsSearch.addListener(SWT.DefaultSelection, new Listener() {
                            public void handleEvent(Event e) {
                                if (logger.isDebugEnabled()) {
                                    logger.debug("handleEvent(Event e = " + e + " "
                                            + textActorsSearch.getText() + ") - start");
                                }

                //                refreshVideoFormatTable(textActorsSearch.getText());

                                if (logger.isDebugEnabled()) {
                                    logger.debug("handleEvent(Event) - end");
                                }
                            }
                        });
                        text2LData.horizontalAlignment = GridData.FILL;
                        text2LData.horizontalSpan = 5;
                        text2LData.grabExcessHorizontalSpace = true;
                        textActorsSearch.setLayoutData(text2LData);
                    }// Search
                    
                
                }
                // Group Actors Detail
                {
                    groupActorsDetail = new Group(sashForm2, SWT.NONE);
                    GridLayout group2Layout = new GridLayout();
                    groupActorsDetail.setBounds(0, 0, 781, 487);
                    groupActorsDetail.setBounds(0, 0, 647, 448);
                    group2Layout.makeColumnsEqualWidth = true;
                    GridData group2LData = new GridData();
                    group2Layout.makeColumnsEqualWidth = true;
                    groupActorsDetail.setLayout(group2Layout);
                    groupActorsDetail.setText(l.getString("actors.groupdetail.label"));   
                }
            }
            // init the rest of the layout
            initActorsGroup();
        }

        this.layout();


        
        if (logger.isDebugEnabled()) {
            logger.debug("initGUI() - end");
        }
	}

	private void initActorsGroup()  {	    
	}

}

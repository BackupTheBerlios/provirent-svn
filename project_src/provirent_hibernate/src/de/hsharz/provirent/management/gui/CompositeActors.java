package de.hsharz.provirent.management.gui;

import java.text.MessageFormat;
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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
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

import de.hsharz.provirent.objects.Actor;
import de.hsharz.provirent.persistence.DataBaseException;
import de.hsharz.provirent.persistence.Database;
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
    private Text textActorsID;
    private Text textActorsFName;
    private Text textActorsLName;
    
    private Label labelActorsSearch;
    private Label labelActorsID;
    private Label labelActorsFName;
    private Label labelActorsLName;
    
    private Button buttonActorsNew;
    private Button buttonActorsSave;
    private Button buttonActorsEdit;
    private Button buttonActorsCancel;
    private Button buttonActorsDelete;
    private Button buttonActorsFill;
    
    protected int mode_actor;
    
    private StatusLineStyledText statusLine;

    private ResourceBundle l;
    
    private Composite parent;
    private Composite compositeButtons;
    
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
                "de.hsharz.provirent.management.gui.language.actors", locale);

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
                
               
            }
            // init the rest of the layout
            initActorsOverview();
            initActorsDetail();
            refreshActorsOverviewTable(textActorsSearch.getText());
        }

        this.layout();


        
        if (logger.isDebugEnabled()) {
            logger.debug("initGUI() - end");
        }
	}

	
	private void initActorsOverview()  {	    
//	  Group Actors Overview 
        {
            groupActorsOverview = new Group(sashForm2,SWT.NONE);
            GridLayout group1Layout = new GridLayout();
            group1Layout.numColumns = 8;
            groupActorsOverview.setLayout(group1Layout);
            groupActorsOverview.setText(l.getString("actors.groupoverview.label"));
            
            {// table Actors Overview
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
                tableActorsOverview.setLayoutData(tableActorsOverviewLData);
                tableActorsOverview.addFocusListener(new FocusAdapter() {
                        public void focusLost(FocusEvent evt) {
                            System.out
                                .println("tableActorsOverview.focusLost, event="
                                    + evt);
                        }
                        public void focusGained(FocusEvent evt) {
                            System.out
                                .println("tableActorsOverview.focusGained, event="
                                    + evt);
                        }
                    });
                tableActorsOverview.addSelectionListener(new SelectionAdapter() {
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
                            refreshActorsDetail(tableActorsOverview.getItem(index)
                                                              .getText(0));

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
                        .getString("actors.groupoverview.columnfirstname"));
                    tableActorsOverview_ColumnFName.setWidth(80);
                }
                {
                    tableActorsOverview_ColumnLName = new TableColumn(
                        tableActorsOverview,
                        SWT.CENTER);
                    tableActorsOverview_ColumnLName.setText(l
                        .getString("actors.groupoverview.columnlastname"));
                    tableActorsOverview_ColumnLName.setWidth(80);
                }
            }
            // table Actors Overview
            // Search
            {
                //label for Search
                labelActorsSearch = new Label(groupActorsOverview, SWT.NONE);
                labelActorsSearch.setText(l
                        .getString("actors.groupoverview.searchlabel")
                        + ":");
                GridData label2LData = new GridData();
                label2LData.horizontalSpan = 3;
                labelActorsSearch.setLayoutData(label2LData);

                //text Search
                textActorsSearch = new Text(groupActorsOverview, SWT.BORDER);
                GridData text2LData = new GridData();
                textActorsSearch.addFocusListener(new FocusAdapter() {
                    public void focusLost(FocusEvent evt) {
                        if (logger.isDebugEnabled()) {
                            logger.debug("focusLost(FocusEvent evt = " + evt + " "
                                    + textActorsSearch.getText() + ") - start");
                        }

                        refreshActorsOverviewTable(textActorsSearch.getText());

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

                        refreshActorsOverviewTable(textActorsSearch.getText());

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
	}
	
	private void initActorsDetail()  {	    
	    // Group Actors Detail
        {
            groupActorsDetail = new Group(sashForm2, SWT.NONE);
            GridLayout group2Layout = new GridLayout();
            GridData group2LData = new GridData();
            group2Layout.verticalSpacing = 15;
            group2Layout.numColumns = 6;
            groupActorsDetail.setText(l.getString("actors.groupdetail.label"));   
            FormData formData = new FormData();
            groupActorsDetail.setLayout(group2Layout);
            formData.right = new FormAttachment(100, 100, -5);
            formData.top = new FormAttachment(0, 100, 5);
            formData.bottom = new FormAttachment(100, 100, -5);
            groupActorsDetail.setLayoutData(formData);
        }
        	// labels and buttons for detail
        	{
        	    labelActorsID = new Label(groupActorsDetail, SWT.NONE);
        	    labelActorsID.setText(l
        	            .getString("actors.groupdetail.labelid")
        	            + ":");
        	    labelActorsID.setSize(125, 15);
        	    GridData formData2 = new GridData();
        	    formData2.widthHint = 125;
        	    formData2.heightHint = 15;
        	    formData2.horizontalSpan = 2;
        	    labelActorsID.setLayoutData(formData2);
        	}
        	{
        	    textActorsID = new Text(
        	            groupActorsDetail,
        	            SWT.READ_ONLY | SWT.BORDER);
        	    GridData text1LData1 = new GridData();
        	    text1LData1.horizontalAlignment = GridData.FILL;
        	    text1LData1.heightHint = 13;
        	    text1LData1.horizontalSpan = 4;
        	    text1LData1.grabExcessHorizontalSpace = true;
        	    textActorsID.setLayoutData(text1LData1);
        	}
        	{
                labelActorsFName = new Label(
                    groupActorsDetail,
                    SWT.NONE);
                labelActorsFName.setText(l
                    .getString("actors.groupdetail.labelfirstname")
                    + ":");
                labelActorsFName.setSize(125, 15);
                GridData labelActorNameLData = new GridData();
                labelActorNameLData.widthHint = 125;
                labelActorNameLData.heightHint = 15;
                labelActorNameLData.horizontalSpan = 2;
                labelActorsFName
                    .setLayoutData(labelActorNameLData);
            }
            {
        	    textActorsFName = new Text(groupActorsDetail,
        	            SWT.READ_ONLY | SWT.BORDER);
        	    GridData text1LData2 = new GridData();
        	    text1LData2.horizontalAlignment = GridData.FILL;
        	    text1LData2.heightHint = 13;
        	    text1LData2.horizontalSpan = 4;
        	    text1LData2.grabExcessHorizontalSpace = true;
        	    textActorsFName.setLayoutData(text1LData2);
        	}
            {
        	    labelActorsLName = new Label(groupActorsDetail,
        	            SWT.NONE);
        	    labelActorsLName.setText(l
        	            .getString("actors.groupdetail.labellastname")
        	            + ":");
        	    labelActorsLName.setSize(125, 15);
        	    GridData label1LData1 = new GridData();
        	    label1LData1.widthHint = 125;
        	    label1LData1.heightHint = 15;
        	    label1LData1.horizontalSpan = 2;
        	    labelActorsLName.setLayoutData(label1LData1);
        	}
        	{
        	    textActorsLName = new Text(groupActorsDetail,
        	            SWT.READ_ONLY | SWT.BORDER);
        	    GridData text1LData3 = new GridData();
        	    text1LData3.horizontalAlignment = GridData.FILL;
        	    text1LData3.heightHint = 13;
        	    text1LData3.horizontalSpan = 4;
        	    text1LData3.grabExcessHorizontalSpace = true;
        	    textActorsLName.setLayoutData(text1LData3);
        	}// label and buttons for detail      
        	// buttons for detail
        	{
        	    compositeButtons = new Composite(groupActorsDetail, SWT.EMBEDDED);
        	    GridLayout composite2Layout = new GridLayout();
        	    composite2Layout.numColumns = 6;
        	    GridData composite2LData = new GridData();
        	    compositeButtons.setLayout(composite2Layout);
        	    composite2LData.verticalAlignment = GridData.END;
        	    composite2LData.horizontalAlignment = GridData.CENTER;
        	    composite2LData.widthHint = 391;
        	    composite2LData.horizontalSpan = 6;
        	    composite2LData.grabExcessHorizontalSpace = true;
            	composite2LData.grabExcessVerticalSpace = true;
            	composite2LData.heightHint = 35;
            	compositeButtons.setLayoutData(composite2LData);
        	}
        	{
        	    buttonActorsNew = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
        	    buttonActorsNew.setText(l.getString("button.new"));
        	    buttonActorsNew.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent evt) {
                    
                    mode_actor = ManagementGui.MODE_ADD;
                    
                    textActorsID.setText("");
                    textActorsFName.setText("");
                    textActorsLName.setText("");
                    textActorsFName.setEditable(true);
                    textActorsLName.setEditable(true);
                    
                    buttonActorsCancel.setEnabled(true);
                    buttonActorsSave.setEnabled(true);
                    buttonActorsNew.setEnabled(false);
                    buttonActorsEdit.setEnabled(false);
                    buttonActorsDelete.setEnabled(false);
                    
                    textActorsSearch.setEditable(false);
                    tableActorsOverview.setEnabled(false);

                }
            });

        	    buttonActorsEdit = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
        	    buttonActorsEdit.setText(l.getString("button.edit"));
        	    buttonActorsEdit.setEnabled(false);
        	    buttonActorsEdit.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent evt) {

                    mode_actor = ManagementGui.MODE_EDIT;

                    textActorsID.setEditable(false);
                    textActorsFName.setEditable(true);
                    textActorsFName.setFocus();
                    textActorsLName.setEditable(true);
                    
                    buttonActorsCancel.setEnabled(true);
                    buttonActorsSave.setEnabled(true);
                    buttonActorsNew.setEnabled(false);
                    buttonActorsEdit.setEnabled(false);
                    buttonActorsDelete.setEnabled(false);

                    tableActorsOverview.setEnabled(false);
                    textActorsSearch.setEnabled(false);
                    
                }
            });

        	    buttonActorsDelete = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
        	    buttonActorsDelete.setText(l.getString("button.delete"));
        	    buttonActorsDelete.setEnabled(false);
        	    buttonActorsDelete.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent evt) {
                    System.out
                            .println("buttonActorsDelete.widgetSelected, event="
                                    + evt);
                    
                    
                   String msg = MessageFormat.format(
                           l.getString("actors.groupdetail.deletebutton.question.text"),
                                   new Object[]{textActorsFName.getText()+" "+textActorsLName.getText()});
                    
                   int question = showMsg(msg,
                           l.getString("actors.groupdetail.deletebutton.question.header"), 
                           SWT.ICON_QUESTION | SWT.YES | SWT.NO);
                   
                   if (question != SWT.YES){
                       return;
                   }
                    
                    Actor o = new Actor();
                    o.setActorId(new Integer(Integer.parseInt(textActorsID.getText())));
                    o.setFirstName(textActorsFName.getText());
                    o.setLastName(textActorsLName.getText());
                    
                    try {
                        //object speichern
                        // Fehlerbehandlung
                        Database.deleteObject(o);

                        //ÜbersichtsTabelle aktualisieren
                        refreshActorsOverviewTable(textActorsSearch.getText());
                        
                        //Detailansicht leeren
                        textActorsID.setText("");
                        textActorsFName.setText("");
                        textActorsLName.setText("");
                        
                        //in Tabelle nächsten auswählen
                        try {
                            tableActorsOverview.select(0);
                        } catch (Exception ex) {}
                        
                        //Statusline Nachricht sezten
                        statusLine.setStatus(1,l.getString("actors.groupdetail.deletebutton.newok"));

                    } catch (DataBaseException e) {
                        if (e.getMessage().equalsIgnoreCase("1")) {
                            //Fehler beim Speichern des Objectes

                            statusLine.setStatus(3,l.getString("actors.groupdetail.deletebutton.errorsave"));
                            showMsg(l.getString("actors.groupdetail.deletebutton.errorsave"),
                                    l.getString("error"), SWT.ICON_ERROR | SWT.OK);
                            
                        } else if (e.getMessage().equalsIgnoreCase("2")) {
                            //fehler beim db aufbau
                            statusLine.setStatus(3,l.getString("actors.groupdetail.deletebutton.errordb"));
                            showMsg(l.getString("actors.groupdetail.deletebutton.errordb"),
                                    l.getString("error"), SWT.ICON_ERROR | SWT.OK);
                            
                        } else {
                            //@todo
                            e.printStackTrace();
                        }
                        
                    }                
                    

                    }

                }
        	    );

        	    //leerer nicht sichtbarer Button
        	    buttonActorsFill = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
        	    GridData buttonActorFillLData = new GridData();
        	    buttonActorsFill.setVisible(false);
        	    buttonActorsFill.setEnabled(false);
        	    buttonActorFillLData.widthHint = 30;
        	    buttonActorFillLData.heightHint = 23;
        	    buttonActorsFill.setLayoutData(buttonActorFillLData);

        	    buttonActorsSave = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
        	    buttonActorsSave.setText(l.getString("button.save"));
        	    buttonActorsSave.setEnabled(false);
        	    buttonActorsSave.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent evt) {
                    System.out
                            .println("buttonActorsSave.widgetSelected, event="
                                    + evt);

                    
                    //testen ob Name leer ist
                    if (textActorsFName.getText().trim().equalsIgnoreCase("") 
                        ||  textActorsLName.getText().trim().equalsIgnoreCase("")   ) {
                        
                        showMsg(l.getString("actors.groupdetail.savebutton.warn.noname.msg"),
                                l.getString("actors.groupdetail.savebutton.warn.noname.title"),
                                SWT.ICON_WARNING | SWT.YES);

                        	return;
                    }
                    
                    //testen welcher mode
                    
                    if (mode_actor == ManagementGui.MODE_ADD) {
                        
                        /**
                         * @todo eine Exception bekommen wieder leider NOCH nicht mit
                         * d.h. es muss noch ein rückgabewert kommen oder eine Exception 
                         * übermitteln werden (aus der DB Klasse)
                         */
                        //neues Objekt erzeugen
                        Actor tmp = new Actor(textActorsFName.getText(),
                                textActorsLName.getText());
                        
                        try {
                            //object speichern
                            // Fehlerbehandlung
                            Object o = Database.saveObject(
                                    new Actor(textActorsFName.getText(),
                                            textActorsLName.getText()));
                            
                            // in Übersichtstabelle einfügen
                            insertIntoActorsOverviewTable((Actor)o);
                            textActorsID.setText( ((Actor)o).getActorId()+"" );
                            
                            
                            //Statusline Nachricht sezten
                            statusLine.setStatus(1,l.getString("actors.groupdetail.savebutton.newok"));

                        } catch (DataBaseException e) {
                            if (e.getMessage().equalsIgnoreCase("1")) {
                                //Fehler beim Speichern des Objectes

                                statusLine.setStatus(3,l.getString("actors.groupdetail.savebutton.errorsave"));
                                showMsg(l.getString("actors.groupdetail.savebutton.errorsave"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                                
                            } else if (e.getMessage().equalsIgnoreCase("2")) {
                                //fehler beim db aufbau
                                statusLine.setStatus(3,l.getString("actors.groupdetail.savebutton.errordb"));
                                showMsg(l.getString("actors.groupdetail.savebutton.errordb"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                                
                            } else {
                                //@todo
                                e.printStackTrace();
                            }
                            
                        }
                        
                        
                        //alle Buttons auf aktiv setzen
                        setActorsGroupButtonSaveCancel();
                        
                    } else if (mode_actor == ManagementGui.MODE_EDIT) {
                        
                        Actor tmp = new Actor(textActorsFName.getText(),
                                        textActorsLName.getText());
            		tmp.setActorId( new Integer (Integer.parseInt(textActorsID.getText())) );
                    try {
                        //object speichern
                        // Fehlerbehandlung
                        Database.saveObject(tmp);
                        //Übersichtstabelle aktualisieren
                        refreshActorsOverviewTable(textActorsSearch.getText());
                        
                        //Statusline Nachricht sezten
                        statusLine.setStatus(1,l.getString("actors.groupdetail.savebutton.editok"));
                       

                    } catch (DataBaseException e) {
                        if (e.getMessage().equalsIgnoreCase("1")) {
                            //Fehler beim Speichern des Objectes

                            statusLine.setStatus(3,l.getString("actors.groupdetail.savebutton.errorsave"));
                            showMsg(l.getString("actors.groupdetail.savebutton.errorsave"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                            
                        } else if (e.getMessage().equalsIgnoreCase("2")) {
                            //fehler beim db aufbau
                            statusLine.setStatus(3,l.getString("actors.groupdetail.savebutton.errordb"));
                            showMsg(l.getString("actors.groupdetail.savebutton.errordb"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                            
                        } else {
                            //@todo
                            e.printStackTrace();
                        }
                        
                    }
                        
     
                        //alle Buttons auf aktiv setzen
                        setActorsGroupButtonSaveCancel();
                        
                    }
                    
                    
                    
                    /**
                     * @todo Exception werfen, da nur die zwei Modes sein dürfen
                     */
                    
                }
            });

        	    buttonActorsCancel = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
        	    buttonActorsCancel.setText(l.getString("button.cancel"));
        	    buttonActorsCancel.setEnabled(false);
        	    buttonActorsCancel.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent evt) {
                    System.out
                            .println("buttonActorsCancel.widgetSelected, event="
                                    + evt);
                    setActorsGroupButtonSaveCancel();
                }
            });
        }
	}

	 
	
	
	/**
     * @param text
     */
    private void refreshActorsDetail(final String id) {
        Actor object;
        try {
            //since we only can get a String value from the table, we
            //need to convert this
            object = Database.getSingleActor(Integer.parseInt(id));

            if (object == null) {

                /*
                 * 
                 * @TODO Statusbar aktualiseren
                 */
                return;
            }
        } catch (Exception e) {
            //id ist keine Zahl
            return;
        }

        textActorsID.setText(object.getActorId() + "");
        textActorsFName.setText(object.getFirstName());
        textActorsLName.setText(object.getLastName());

        //Buttons zum löschen und editieren aktivieren
        buttonActorsEdit.setEnabled(true);
        buttonActorsDelete.setEnabled(true);

        //Mode auf view setzen
        mode_actor = ManagementGui.MODE_VIEW;
        
    }

    /**
     * 
     */
    protected void setActorsGroupButtonSaveCancel() {
        buttonActorsSave.setEnabled(false);
        buttonActorsCancel.setEnabled(false);
        buttonActorsEdit.setEnabled(true);
        buttonActorsNew.setEnabled(true);
        buttonActorsDelete.setEnabled(true);
        textActorsFName.setEditable(false);
        textActorsLName.setEditable(false);
        textActorsSearch.setEditable(true);

        // ActorTabelle aktivieren
        tableActorsOverview.setEnabled(true);

        //ActorSearch aktivieren
        textActorsSearch.setEnabled(true);        
    }

    protected void insertIntoActorsOverviewTable(Actor actor) {
        TableItem item = new TableItem(tableActorsOverview, SWT.NONE);
        item.setText(new String[] { actor.getActorId() + "", actor.getFirstName(),
                actor.getLastName() });        
    }
    
    protected void refreshActorsOverviewTable(final String filter) {
        if (tableActorsOverview == null) {
            System.out
                    .println("Konnte ActorsOverviewtable nicht refreshen, da diese null ist!");
            return;
        }
        System.out.println("Versuche nun ActorsOverviewtable zu refreshen. Filter: "
                + filter);
        tableActorsOverview.removeAll();
        TableItem item;
        java.util.List Actorlist = Database.getActor(filter);

        for (int i = 0; i < Actorlist.size(); i++) {

            Actor o = (Actor) Actorlist.get(i);
            item = new TableItem(tableActorsOverview, SWT.NONE);
            item.setText(new String[] { o.getActorId() + "", o.getFirstName(),
                    o.getLastName() });

        }
    }
}

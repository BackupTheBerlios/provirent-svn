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

import de.hsharz.provirent.objects.Director;
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
public class CompositeDirectors extends AbstractComposite{
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
    
    private Table tableDirectorsOverview;
    private TableColumn tableDirectorsOverview_ColumnID;
    private TableColumn tableDirectorsOverview_ColumnFName;
    private TableColumn tableDirectorsOverview_ColumnLName;
      
    private SashForm sashForm1;
    
    private Group groupDirector;
    private Group groupDirectorsOverview;
    private Group groupDirectorsDetail;
    
    private Text textDirectorsSearch;
    private Text textDirectorsID;
    private Text textDirectorsFName;
    private Text textDirectorsLName;
    
    private Label labelDirectorsSearch;
    private Label labelDirectorsID;
    private Label labelDirectorsFName;
    private Label labelDirectorsLName;
    
    private Button buttonDirectorsNew;
    private Button buttonDirectorsSave;
    private Button buttonDirectorsEdit;
    private Button buttonDirectorsCancel;
    private Button buttonDirectorsDelete;
    private Button buttonDirectorsFill;
    
    protected int mode_director;
    
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
                "de.hsharz.provirent.management.gui.language.directors", locale);

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

	public CompositeDirectors(Composite p, int style,
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
            groupDirector = new Group(this, SWT.NONE);
            GridLayout groupDirectorLayout = new GridLayout();
            GridData groupDirectorLData = new GridData();
            groupDirectorLData.grabExcessHorizontalSpace = true;
            groupDirectorLData.grabExcessVerticalSpace = true;
            groupDirectorLData.horizontalAlignment = GridData.FILL;
            groupDirectorLData.verticalAlignment = GridData.FILL;
            groupDirector.setLayoutData(groupDirectorLData);
            groupDirectorLayout.makeColumnsEqualWidth = true;
            groupDirector.setLayout(groupDirectorLayout);
            groupDirector.setText(l.getString("directors.group.label"));
            {
                sashForm1 = new SashForm(groupDirector, SWT.NONE);
                GridData sashForm1LData = new GridData();
                sashForm1LData.verticalAlignment = GridData.FILL;
                sashForm1LData.horizontalAlignment = GridData.FILL;
                sashForm1LData.grabExcessHorizontalSpace = true;
                sashForm1LData.grabExcessVerticalSpace = true;
                sashForm1.setLayoutData(sashForm1LData);
                
               
            }
            // init the rest of the layout
            initDirectorsOverview();
            initDirectorsDetail();
            refreshDirectorsOverviewTable(textDirectorsSearch.getText());
        }

        this.layout();


        
        if (logger.isDebugEnabled()) {
            logger.debug("initGUI() - end");
        }
	}

	
	private void initDirectorsOverview()  {	    
//	  Group Actors Overview 
        {
            groupDirectorsOverview = new Group(sashForm1,SWT.NONE);
            GridLayout group1Layout = new GridLayout();
            group1Layout.numColumns = 8;
            groupDirectorsOverview.setLayout(group1Layout);
            groupDirectorsOverview.setText(l.getString("directors.groupoverview.label"));
            
            {// table Actors Overview
                tableDirectorsOverview = new Table(
                    groupDirectorsOverview,
                    SWT.SINGLE
                        | SWT.FULL_SELECTION
                        | SWT.V_SCROLL | SWT.BORDER);
                GridData tableDirectorsOverviewLData = new GridData();
                tableDirectorsOverview.setHeaderVisible(true);
                tableDirectorsOverview.setLinesVisible(true);
                tableDirectorsOverviewLData.horizontalAlignment = GridData.FILL;
                tableDirectorsOverviewLData.verticalAlignment = GridData.FILL;
                tableDirectorsOverviewLData.horizontalSpan = 8;
                tableDirectorsOverviewLData.grabExcessHorizontalSpace = true;
                tableDirectorsOverviewLData.grabExcessVerticalSpace = true;
                tableDirectorsOverview.setLayoutData(tableDirectorsOverviewLData);
                tableDirectorsOverview.addFocusListener(new FocusAdapter() {
                        public void focusLost(FocusEvent evt) {
                            System.out
                                .println("tableDirectorsOverview.focusLost, event="
                                    + evt);
                        }
                        public void focusGained(FocusEvent evt) {
                            System.out
                                .println("tableDirectorsOverview.focusGained, event="
                                    + evt);
                        }
                    });
                tableDirectorsOverview.addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {
                            if (logger.isDebugEnabled()) {
                                logger
                                    .debug("widgetSelected(SelectionEvent evt = "
                                        + evt
                                        + ") - start");
                            }

                            int index = tableDirectorsOverview
                                .getSelectionIndex();

                            System.out.println("Table select. id: "
                                + index
                                + " TableItem:"
                                + tableDirectorsOverview.getItem(index)
                                + " id: "
                                + tableDirectorsOverview.getItem(index)
                                    .getText(0));

                            //es wurde ein Element aus Tabelle ausgewaehlt jetzt muss die
                            //Detailansicht aktualisiert werden
                            refreshDirectorsDetail(tableDirectorsOverview.getItem(index)
                                                              .getText(0));

                            if (logger.isDebugEnabled()) {
                                logger
                                    .debug("widgetSelected(SelectionEvent) - end");
                            }
                        }
                    });
                {
                    tableDirectorsOverview_ColumnID = new TableColumn(
                        tableDirectorsOverview,
                        SWT.CENTER);
                    tableDirectorsOverview_ColumnID.setText(l
                        .getString("directors.groupoverview.columnid"));
                    tableDirectorsOverview_ColumnID.setWidth(40);
                }
                {
                    tableDirectorsOverview_ColumnFName = new TableColumn(
                        tableDirectorsOverview,
                        SWT.CENTER);
                    tableDirectorsOverview_ColumnFName.setText(l
                        .getString("directors.groupoverview.columnfirstname"));
                    tableDirectorsOverview_ColumnFName.setWidth(120);
                }
                {
                    tableDirectorsOverview_ColumnLName = new TableColumn(
                        tableDirectorsOverview,
                        SWT.CENTER);
                    tableDirectorsOverview_ColumnLName.setText(l
                        .getString("directors.groupoverview.columnlastname"));
                    tableDirectorsOverview_ColumnLName.setWidth(120);
                }
            }
            // table Actors Overview
            // Search
            {
                //label for Search
                labelDirectorsSearch = new Label(groupDirectorsOverview, SWT.NONE);
                labelDirectorsSearch.setText(l
                        .getString("directors.groupoverview.searchlabel")
                        + ":");
                GridData label2LData = new GridData();
                label2LData.horizontalSpan = 3;
                labelDirectorsSearch.setLayoutData(label2LData);

                //text Search
                textDirectorsSearch = new Text(groupDirectorsOverview, SWT.BORDER);
                GridData text2LData = new GridData();
                textDirectorsSearch.addFocusListener(new FocusAdapter() {
                    public void focusLost(FocusEvent evt) {
                        if (logger.isDebugEnabled()) {
                            logger.debug("focusLost(FocusEvent evt = " + evt + " "
                                    + textDirectorsSearch.getText() + ") - start");
                        }

                        refreshDirectorsOverviewTable(textDirectorsSearch.getText());

                        if (logger.isDebugEnabled()) {
                            logger.debug("focusLost(FocusEvent) - end");
                        }
                    }
                });
                textDirectorsSearch.addListener(SWT.DefaultSelection, new Listener() {
                    public void handleEvent(Event e) {
                        if (logger.isDebugEnabled()) {
                            logger.debug("handleEvent(Event e = " + e + " "
                                    + textDirectorsSearch.getText() + ") - start");
                        }

                        refreshDirectorsOverviewTable(textDirectorsSearch.getText());

                        if (logger.isDebugEnabled()) {
                            logger.debug("handleEvent(Event) - end");
                        }
                    }
                });
                text2LData.horizontalAlignment = GridData.FILL;
                text2LData.horizontalSpan = 5;
                text2LData.grabExcessHorizontalSpace = true;
                textDirectorsSearch.setLayoutData(text2LData);
            }// Search                    
        }
	}
	
	private void initDirectorsDetail()  {	    
	    // Group Actors Detail
        {
            groupDirectorsDetail = new Group(sashForm1, SWT.NONE);
            GridLayout group2Layout = new GridLayout();
            GridData group2LData = new GridData();
            group2Layout.verticalSpacing = 15;
            group2Layout.numColumns = 6;
            groupDirectorsDetail.setText(l.getString("directors.groupdetail.label"));   
            FormData formData = new FormData();
            groupDirectorsDetail.setLayout(group2Layout);
            formData.right = new FormAttachment(100, 100, -5);
            formData.top = new FormAttachment(0, 100, 5);
            formData.bottom = new FormAttachment(100, 100, -5);
            groupDirectorsDetail.setLayoutData(formData);
        }
        	// labels and buttons for detail
        	{
        	    labelDirectorsID = new Label(groupDirectorsDetail, SWT.NONE);
        	    labelDirectorsID.setText(l
        	            .getString("directors.groupdetail.labelid")
        	            + ":");
        	    labelDirectorsID.setSize(125, 15);
        	    GridData formData2 = new GridData();
        	    formData2.widthHint = 125;
        	    formData2.heightHint = 15;
        	    formData2.horizontalSpan = 2;
        	    labelDirectorsID.setLayoutData(formData2);
        	}
        	{
        	    textDirectorsID = new Text(
        	            groupDirectorsDetail,
        	            SWT.READ_ONLY | SWT.BORDER);
        	    GridData text1LData1 = new GridData();
        	    text1LData1.horizontalAlignment = GridData.FILL;
        	    text1LData1.heightHint = 13;
        	    text1LData1.horizontalSpan = 4;
        	    text1LData1.grabExcessHorizontalSpace = true;
        	    textDirectorsID.setLayoutData(text1LData1);
        	}
        	{
                labelDirectorsFName = new Label(
                    groupDirectorsDetail,
                    SWT.NONE);
                labelDirectorsFName.setText(l
                    .getString("directors.groupdetail.labelfirstname")
                    + ":");
                labelDirectorsFName.setSize(125, 15);
                GridData labelDirectorsFNameLData = new GridData();
                labelDirectorsFNameLData.widthHint = 125;
                labelDirectorsFNameLData.heightHint = 15;
                labelDirectorsFNameLData.horizontalSpan = 2;
                labelDirectorsFName
                    .setLayoutData(labelDirectorsFNameLData);
            }
            {
        	    textDirectorsFName = new Text(groupDirectorsDetail,
        	            SWT.READ_ONLY | SWT.BORDER);
        	    GridData text1LData2 = new GridData();
        	    text1LData2.horizontalAlignment = GridData.FILL;
        	    text1LData2.heightHint = 13;
        	    text1LData2.horizontalSpan = 4;
        	    text1LData2.grabExcessHorizontalSpace = true;
        	    textDirectorsFName.setLayoutData(text1LData2);
        	}
            {
        	    labelDirectorsLName = new Label(groupDirectorsDetail,
        	            SWT.NONE);
        	    labelDirectorsLName.setText(l
        	            .getString("directors.groupdetail.labellastname")
        	            + ":");
        	    labelDirectorsLName.setSize(125, 15);
        	    GridData label1LData1 = new GridData();
        	    label1LData1.widthHint = 125;
        	    label1LData1.heightHint = 15;
        	    label1LData1.horizontalSpan = 2;
        	    labelDirectorsLName.setLayoutData(label1LData1);
        	}
        	{
        	    textDirectorsLName = new Text(groupDirectorsDetail,
        	            SWT.READ_ONLY | SWT.BORDER);
        	    GridData text1LData3 = new GridData();
        	    text1LData3.horizontalAlignment = GridData.FILL;
        	    text1LData3.heightHint = 13;
        	    text1LData3.horizontalSpan = 4;
        	    text1LData3.grabExcessHorizontalSpace = true;
        	    textDirectorsLName.setLayoutData(text1LData3);
        	}// label and buttons for detail      
        	// buttons for detail
        	{
        	    compositeButtons = new Composite(groupDirectorsDetail, SWT.EMBEDDED);
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
        	    buttonDirectorsNew = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
        	    buttonDirectorsNew.setText(l.getString("button.new"));
        	    buttonDirectorsNew.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent evt) {
                    
                    mode_director = ManagementGui.MODE_ADD;
                    
                    textDirectorsID.setText("");
                    textDirectorsFName.setText("");
                    textDirectorsLName.setText("");
                    textDirectorsFName.setEditable(true);
                    textDirectorsLName.setEditable(true);
                    
                    buttonDirectorsCancel.setEnabled(true);
                    buttonDirectorsSave.setEnabled(true);
                    buttonDirectorsNew.setEnabled(false);
                    buttonDirectorsEdit.setEnabled(false);
                    buttonDirectorsDelete.setEnabled(false);
                    
                    textDirectorsSearch.setEditable(false);
                    tableDirectorsOverview.setEnabled(false);

                }
            });

        	    buttonDirectorsEdit = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
        	    buttonDirectorsEdit.setText(l.getString("button.edit"));
        	    buttonDirectorsEdit.setEnabled(false);
        	    buttonDirectorsEdit.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent evt) {

                    mode_director = ManagementGui.MODE_EDIT;

                    textDirectorsID.setEditable(false);
                    textDirectorsFName.setEditable(true);
                    textDirectorsFName.setFocus();
                    textDirectorsLName.setEditable(true);
                    
                    buttonDirectorsCancel.setEnabled(true);
                    buttonDirectorsSave.setEnabled(true);
                    buttonDirectorsNew.setEnabled(false);
                    buttonDirectorsEdit.setEnabled(false);
                    buttonDirectorsDelete.setEnabled(false);

                    tableDirectorsOverview.setEnabled(false);
                    textDirectorsSearch.setEnabled(false);
                    
                }
            });

        	    buttonDirectorsDelete = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
        	    buttonDirectorsDelete.setText(l.getString("button.delete"));
        	    buttonDirectorsDelete.setEnabled(false);
        	    buttonDirectorsDelete.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent evt) {
                    System.out
                            .println("buttonDirectorsDelete.widgetSelected, event="
                                    + evt);
                    
                    
                   String msg = MessageFormat.format(
                           l.getString("directors.groupdetail.deletebutton.question.text"),
                                   new Object[]{textDirectorsFName.getText()+" "+textDirectorsLName.getText()});
                    
                   int question = showMsg(msg,
                           l.getString("directors.groupdetail.deletebutton.question.header"), 
                           SWT.ICON_QUESTION | SWT.YES | SWT.NO);
                   
                   if (question != SWT.YES){
                       return;
                   }
                    
                    Director o = new Director();
                    o.setDirectorId(new Integer(Integer.parseInt(textDirectorsID.getText())));
                    o.setFirstName(textDirectorsFName.getText());
                    o.setLastName(textDirectorsLName.getText());
                    
                    try {
                        //object speichern
                        // Fehlerbehandlung
                        Database.deleteObject(o);

                        //ÜbersichtsTabelle aktualisieren
                        refreshDirectorsOverviewTable(textDirectorsSearch.getText());
                        
                        //Detailansicht leeren
                        textDirectorsID.setText("");
                        textDirectorsFName.setText("");
                        textDirectorsLName.setText("");
                        
                        //in Tabelle nächsten auswählen
                        try {
                            tableDirectorsOverview.select(0);
                        } catch (Exception ex) {}
                        
                        //Statusline Nachricht sezten
                        statusLine.setStatus(1,l.getString("directors.groupdetail.deletebutton.newok"));

                    } catch (DataBaseException e) {
                        if (e.getMessage().equalsIgnoreCase("1")) {
                            //Fehler beim Speichern des Objectes

                            statusLine.setStatus(3,l.getString("directors.groupdetail.deletebutton.errorsave"));
                            showMsg(l.getString("directors.groupdetail.deletebutton.errorsave"),
                                    l.getString("error"), SWT.ICON_ERROR | SWT.OK);
                            
                        } else if (e.getMessage().equalsIgnoreCase("2")) {
                            //fehler beim db aufbau
                            statusLine.setStatus(3,l.getString("directors.groupdetail.deletebutton.errordb"));
                            showMsg(l.getString("directors.groupdetail.deletebutton.errordb"),
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
        	    buttonDirectorsFill = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
        	    GridData buttonActorFillLData = new GridData();
        	    buttonDirectorsFill.setVisible(false);
        	    buttonDirectorsFill.setEnabled(false);
        	    buttonActorFillLData.widthHint = 30;
        	    buttonActorFillLData.heightHint = 23;
        	    buttonDirectorsFill.setLayoutData(buttonActorFillLData);

        	    buttonDirectorsSave = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
        	    buttonDirectorsSave.setText(l.getString("button.save"));
        	    buttonDirectorsSave.setEnabled(false);
        	    buttonDirectorsSave.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent evt) {
                    System.out
                            .println("buttonDirectorsSave.widgetSelected, event="
                                    + evt);

                    
                    //testen ob Name leer ist
                    if (textDirectorsFName.getText().trim().equalsIgnoreCase("") 
                        ||  textDirectorsLName.getText().trim().equalsIgnoreCase("")   ) {
                        
                        showMsg(l.getString("directors.groupdetail.savebutton.warn.noname.msg"),
                                l.getString("directors.groupdetail.savebutton.warn.noname.title"),
                                SWT.ICON_WARNING | SWT.YES);

                        	return;
                    }
                    
                    //testen welcher mode
                    
                    if (mode_director == ManagementGui.MODE_ADD) {
                        
                        /**
                         * @todo eine Exception bekommen wieder leider NOCH nicht mit
                         * d.h. es muss noch ein rückgabewert kommen oder eine Exception 
                         * übermitteln werden (aus der DB Klasse)
                         */
                        //neues Objekt erzeugen
                        Director tmp = new Director(textDirectorsFName.getText(),
                                textDirectorsLName.getText());
                        
                        try {
                            //object speichern
                            // Fehlerbehandlung
                            Object o = Database.saveObject(
                                    new Director(textDirectorsFName.getText(),
                                            textDirectorsLName.getText()));
                            
                            // in Übersichtstabelle einfügen
                            insertIntoDirectorsOverviewTable((Director)o);
                            textDirectorsID.setText( ((Director)o).getDirectorId()+"" );
                            
                            
                            //Statusline Nachricht sezten
                            statusLine.setStatus(1,l.getString("directors.groupdetail.savebutton.newok"));

                        } catch (DataBaseException e) {
                            if (e.getMessage().equalsIgnoreCase("1")) {
                                //Fehler beim Speichern des Objectes

                                statusLine.setStatus(3,l.getString("directors.groupdetail.savebutton.errorsave"));
                                showMsg(l.getString("directors.groupdetail.savebutton.errorsave"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                                
                            } else if (e.getMessage().equalsIgnoreCase("2")) {
                                //fehler beim db aufbau
                                statusLine.setStatus(3,l.getString("directors.groupdetail.savebutton.errordb"));
                                showMsg(l.getString("directors.groupdetail.savebutton.errordb"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                                
                            } else {
                                //@todo
                                e.printStackTrace();
                            }
                            
                        }
                        
                        
                        //alle Buttons auf aktiv setzen
                        setDirectorsGroupButtonSaveCancel();
                        
                    } else if (mode_director == ManagementGui.MODE_EDIT) {
                        
                        Director tmp = new Director(textDirectorsFName.getText(),
                                        textDirectorsLName.getText());
                        tmp.setDirectorId( new Integer (Integer.parseInt(textDirectorsID.getText())) );
                    try {
                        //object speichern
                        // Fehlerbehandlung
                        Database.saveObject(tmp);
                        //Übersichtstabelle aktualisieren
                        refreshDirectorsOverviewTable(textDirectorsSearch.getText());
                        
                        //Statusline Nachricht sezten
                        statusLine.setStatus(1,l.getString("directors.groupdetail.savebutton.editok"));
                       

                    } catch (DataBaseException e) {
                        if (e.getMessage().equalsIgnoreCase("1")) {
                            //Fehler beim Speichern des Objectes

                            statusLine.setStatus(3,l.getString("directors.groupdetail.savebutton.errorsave"));
                            showMsg(l.getString("directors.groupdetail.savebutton.errorsave"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                            
                        } else if (e.getMessage().equalsIgnoreCase("2")) {
                            //fehler beim db aufbau
                            statusLine.setStatus(3,l.getString("directors.groupdetail.savebutton.errordb"));
                            showMsg(l.getString("directors.groupdetail.savebutton.errordb"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                            
                        } else {
                            //@todo
                            e.printStackTrace();
                        }
                        
                    }
                        
     
                        //alle Buttons auf aktiv setzen
                        setDirectorsGroupButtonSaveCancel();
                        
                    }
                    
                    
                    
                    /**
                     * @todo Exception werfen, da nur die zwei Modes sein dürfen
                     */
                    
                }
            });

        	    buttonDirectorsCancel = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
        	    buttonDirectorsCancel.setText(l.getString("button.cancel"));
        	    buttonDirectorsCancel.setEnabled(false);
        	    buttonDirectorsCancel.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent evt) {
                    System.out
                            .println("buttonDirectorsCancel.widgetSelected, event="
                                    + evt);
                    setDirectorsGroupButtonSaveCancel();
                }
            });
        }
	}

	 
	
	
	/**
     * @param text
     */
    private void refreshDirectorsDetail(final String id) {
        Director object;
        try {
            //since we only can get a String value from the table, we
            //need to convert this
            object = Database.getSingleDirector(Integer.parseInt(id));

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

        textDirectorsID.setText(object.getDirectorId() + "");
        textDirectorsFName.setText(object.getFirstName());
        textDirectorsLName.setText(object.getLastName());

        //Buttons zum löschen und editieren aktivieren
        buttonDirectorsEdit.setEnabled(true);
        buttonDirectorsDelete.setEnabled(true);

        //Mode auf view setzen
        mode_director = ManagementGui.MODE_VIEW;
        
    }

    /**
     * 
     */
    protected void setDirectorsGroupButtonSaveCancel() {
        buttonDirectorsSave.setEnabled(false);
        buttonDirectorsCancel.setEnabled(false);
        buttonDirectorsEdit.setEnabled(true);
        buttonDirectorsNew.setEnabled(true);
        buttonDirectorsDelete.setEnabled(true);
        textDirectorsFName.setEditable(false);
        textDirectorsLName.setEditable(false);
        textDirectorsSearch.setEditable(true);

        // ActorTabelle aktivieren
        tableDirectorsOverview.setEnabled(true);

        //ActorSearch aktivieren
        textDirectorsSearch.setEnabled(true);        
    }

    protected void insertIntoDirectorsOverviewTable(Director director) {
        TableItem item = new TableItem(tableDirectorsOverview, SWT.NONE);
        item.setText(new String[] { director.getDirectorId() + "", director.getFirstName(),
                director.getLastName() });        
    }
    
    protected void refreshDirectorsOverviewTable(final String filter) {
        if (tableDirectorsOverview == null) {
            System.out
                    .println("Konnte DirectorsOverviewtable nicht refreshen, da diese null ist!");
            return;
        }
        System.out.println("Versuche nun DirectorsOverviewtable zu refreshen. Filter: "
                + filter);
        tableDirectorsOverview.removeAll();
        TableItem item;
        java.util.List Directorlist = Database.getDirector(filter);

        for (int i = 0; i < Directorlist.size(); i++) {

            Director o = (Director) Directorlist.get(i);
            item = new TableItem(tableDirectorsOverview, SWT.NONE);
            item.setText(new String[] { o.getDirectorId() + "", o.getFirstName(),
                    o.getLastName() });

        }
    }
}


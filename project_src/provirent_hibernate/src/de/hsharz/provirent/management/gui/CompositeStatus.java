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
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.cloudgarden.resource.SWTResourceManager;

import de.hsharz.provirent.objects.Condition;
import de.hsharz.provirent.objects.Status;
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
public class CompositeStatus extends AbstractComposite{

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }


    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(CompositeStatus.class);
    
    
    private final static int MODE_VIEW = 0;

    private final static int MODE_ADD = 1;
    
    private SashForm sashForm1;

    private Group groupStatusOverview;

    private Group groupStatusDetail;

    private Label labelStatusId;

    private Label labelStatusShortname;

    private Text textStatusName;

    private Label labelStatusName;

    private Text textStatusID;
    
    private Button buttonStatusCancel;

    private Button buttonStatusSave;

    private Button buttonStatusFill;

    private Button buttonStatusDelete;

    private Button buttonStatusEdit;

    private Button buttonStatusNew;

    private Text textStatusShortname;

    private Text textStatusSearch;

    private Label labelStatusSearch;

    private Table tableStatus;

    private SashForm sashFormStatus;

    private Group groupStatus;
    
    private Group groupConditionOverview;

    private Group groupConditionDetail;

    private Label labelConditionId;

    private Label labelConditionShortname;

    private Text textConditionName;

    private Label labelConditionName;

    private Text textConditionID;
    
    private Button buttonConditionCancel;

    private Button buttonConditionSave;

    private Button buttonConditionFill;

    private Button buttonConditionDelete;

    private Button buttonConditionEdit;

    private Button buttonConditionNew;

    private Text textConditionShortname;

    private Text textConditionSearch;

    private Label labelConditionSearch;

    private SashForm sashFormCondition;

    private Group groupCondition;
    
    private int mode_Condition = 0;
    
    private List list1;
    
    private Table tableCondition;

    private Group group1Condition;

    private final static int MODE_EDIT = 2;
    
    private StatusLineStyledText statusLine;

    private ResourceBundle l;
    
    private Composite parent;


    private Composite composite2;


    protected int mode_Status;


    private TableColumn tableColumn;
    
    private TableColumn tableColumn1, tableColumn2, tableColumn3;
    
    /*
     * Ändert die Sprache aller Elemente
     * 
     * @see de.hsharz.provirent.managment.gui.AbstractComposite#changeStatus(java.util.Locale)
     */
    public void changeLanguage(Locale locale) {

    }

    /* 
     * Init die Sprache (properties Datei)
     * @see de.hsharz.provirent.managment.gui.AbstractComposite#initStatus(java.util.Locale)
     */
    public void initLanguage(Locale locale) {

        l = PropertyResourceBundle.getBundle(
                "de.hsharz.provirent.management.gui.Language.Status", locale);

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

	public CompositeStatus(Composite p, int style,
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
            sashForm1 = new SashForm(this, SWT.VERTICAL | SWT.V_SCROLL);
            GridData sashForm1LData1 = new GridData();
            sashForm1LData1.grabExcessHorizontalSpace = true;
            sashForm1LData1.horizontalAlignment = GridData.FILL;
            sashForm1LData1.grabExcessVerticalSpace = true;
            sashForm1LData1.verticalAlignment = GridData.FILL;
            sashForm1.setLayoutData(sashForm1LData1);

            initStatusGroup();
            initConditionGroup();
            refreshStatusTable(textStatusSearch.getText());
            refreshConditionTable(textConditionSearch.getText());

        }
        this.layout();

        if (logger.isDebugEnabled()) {
            logger.debug("initGUI() - end");
        }
    } 
	
	/**
     * 
     */
    private void initConditionGroup() {
        {
            //init a group for the Condition
            groupCondition = new Group(sashForm1, SWT.NONE);
            GridLayout group2Layout = new GridLayout();
            group2Layout.makeColumnsEqualWidth = true;
            groupCondition.setText(l.getString("Condition.group.label"));
            groupCondition.setSize(758, 284);
            FormData group2LData = new FormData();
            groupCondition.addFocusListener(new FocusAdapter() {
                public void focusLost(FocusEvent evt) {
                    System.out.println("groupCondition.focusLost, event="
                        + evt);
                    buttonConditionCancel.setEnabled(false);
                    buttonConditionDelete.setEnabled(false);
                    buttonConditionEdit.setEnabled(false);
                    buttonConditionNew.setEnabled(false);
                    buttonConditionSave.setEnabled(false);
                    
                }
            });
            groupCondition.setLayout(group2Layout);
            groupCondition.setLayoutData(group2LData);
            {
                sashFormCondition = new SashForm(groupCondition, SWT.NONE);
                FormLayout sashForm2Layout = new FormLayout();
                sashFormCondition.setSize(748, 300);
                GridData sashForm2LData = new GridData();
                sashFormCondition.setLayout(sashForm2Layout);
                sashForm2LData.verticalAlignment = GridData.FILL;
                sashForm2LData.horizontalAlignment = GridData.FILL;
                sashForm2LData.grabExcessHorizontalSpace = true;
                sashForm2LData.grabExcessVerticalSpace = true;
                sashFormCondition.setLayoutData(sashForm2LData);

                //init die Gruppe für Condition Überblick
                initConditionGroupOverview();
                //init die Detailansicht
                initConditionGroupDetail();

            }
        }

        
    }

    /**
     * 
     */
    private void initConditionGroupDetail() {
        groupConditionDetail = new Group(sashFormCondition, SWT.NONE);
        GridLayout groupConditionDetailLayout = new GridLayout();
        groupConditionDetailLayout.marginHeight = 25;
        groupConditionDetailLayout.numColumns = 6;
        groupConditionDetailLayout.verticalSpacing = 15;
        groupConditionDetail.setText(l
                .getString("Condition.groupdetail.label"));
        FormData formData = new FormData();
        groupConditionDetail.setLayout(groupConditionDetailLayout);
        formData.right = new FormAttachment(100, 100, -5);
        formData.top = new FormAttachment(0, 100, 5);
        formData.bottom = new FormAttachment(100, 100, -5);
        groupConditionDetail.setLayoutData(formData);
        {
            labelConditionId = new Label(groupConditionDetail, SWT.NONE);
            labelConditionId.setText(l
                    .getString("Condition.groupdetail.idlabel")
                    + ":");
            labelConditionId.setSize(125, 15);
            GridData formData2 = new GridData();
            formData2.widthHint = 125;
            formData2.heightHint = 15;
            formData2.horizontalSpan = 2;
            labelConditionId.setLayoutData(formData2);
        }
        {
            textConditionID = new Text(groupConditionDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData1 = new GridData();
            text1LData1.horizontalAlignment = GridData.FILL;
            text1LData1.heightHint = 13;
            text1LData1.horizontalSpan = 4;
            text1LData1.grabExcessHorizontalSpace = true;
            textConditionID.setLayoutData(text1LData1);
        }
        {
            labelConditionName = new Label(groupConditionDetail, SWT.NONE);
            labelConditionName.setText(l
                    .getString("Condition.groupdetail.namelabel")
                    + ":");
            labelConditionName.setSize(125, 15);
            GridData labelConditionNameLData = new GridData();
            labelConditionNameLData.widthHint = 125;
            labelConditionNameLData.heightHint = 15;
            labelConditionNameLData.horizontalSpan = 2;
            labelConditionName.setLayoutData(labelConditionNameLData);
        }
        {
            textConditionName = new Text(groupConditionDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData2 = new GridData();
            text1LData2.horizontalAlignment = GridData.FILL;
            text1LData2.heightHint = 13;
            text1LData2.horizontalSpan = 4;
            text1LData2.grabExcessHorizontalSpace = true;
            textConditionName.setLayoutData(text1LData2);
        }
        {
            labelConditionShortname = new Label(groupConditionDetail,
                    SWT.NONE);
            labelConditionShortname.setText(l
                    .getString("Condition.groupdetail.shortcutlabel")
                    + ":");
            labelConditionShortname.setSize(125, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 125;
            label1LData1.heightHint = 15;
            label1LData1.horizontalSpan = 2;
            labelConditionShortname.setLayoutData(label1LData1);
        }
        {
            textConditionShortname = new Text(groupConditionDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 4;
            text1LData3.grabExcessHorizontalSpace = true;
            textConditionShortname.setLayoutData(text1LData3);
        }
        {

//          die Buttons bekommen ein eigenes Composite
            composite2 = new Composite(groupConditionDetail, SWT.EMBEDDED);
            GridLayout composite2Layout = new GridLayout();
            composite2Layout.numColumns = 6;
            GridData composite2LData = new GridData();
            composite2.setLayout(composite2Layout);
            composite2LData.verticalAlignment = GridData.END;
            composite2LData.horizontalAlignment = GridData.CENTER;
            composite2LData.widthHint = 391;
            composite2LData.horizontalSpan = 6;
            composite2LData.grabExcessHorizontalSpace = true;
            composite2LData.grabExcessVerticalSpace = true;
            composite2LData.heightHint = 35;
            composite2.setLayoutData(composite2LData);

            //init all the Buttons
            initConditionDetailButtons();

        }
        
    }

    /**
     * 
     */
    private void initConditionDetailButtons() {
        buttonConditionNew = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonConditionNew.setText(l.getString("button.new"));
        buttonConditionNew.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {

                textConditionID.setText("");
                textConditionName.setText("");
                textConditionShortname.setText("");
                

                textConditionName.setEditable(true);
                textConditionShortname.setEditable(true);
                buttonConditionCancel.setEnabled(true);
                buttonConditionSave.setEnabled(true);
                buttonConditionNew.setEnabled(false);
                buttonConditionEdit.setEnabled(false);
                buttonConditionDelete.setEnabled(false);
                
                textConditionSearch.setEditable(false);
                tableCondition.setEnabled(false);

                mode_Condition = ManagementGui.MODE_ADD;

            }
        });

        buttonConditionEdit = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonConditionEdit.setText(l.getString("button.edit"));
        buttonConditionEdit.setEnabled(false);
        buttonConditionEdit.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {

                mode_Condition = ManagementGui.MODE_EDIT;


                textConditionID.setEditable(false);

                textConditionName.setEditable(true);
                textConditionName.setFocus();
                textConditionShortname.setEditable(true);
                buttonConditionCancel.setEnabled(true);
                buttonConditionSave.setEnabled(true);
                buttonConditionNew.setEnabled(false);
                buttonConditionEdit.setEnabled(false);
                buttonConditionDelete.setEnabled(false);


                tableCondition.setEnabled(false);
                textConditionSearch.setEnabled(false);
                

            }
        });

        buttonConditionDelete = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonConditionDelete.setText(l.getString("button.delete"));
        buttonConditionDelete.setEnabled(false);
        buttonConditionDelete.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                System.out
                        .println("buttonConditionDelete.widgetSelected, event="
                                + evt);
                
                
               String msg = MessageFormat.format(
                       l.getString("Condition.groupdetail.deletebutton.question.text"),
                               new Object[]{textConditionName.getText()+" "+textConditionShortname.getText()});
                
               int question = showMsg(msg,
                       l.getString("Condition.groupdetail.deletebutton.question.header"), 
                       SWT.ICON_QUESTION | SWT.YES | SWT.NO);
               
               if (question != SWT.YES){
                   return;
               }
                
                Condition o = new Condition();
                o.setConditionId(new Integer(Integer.parseInt(textConditionID.getText())));
                o.setConditionName(textConditionName.getText());
                o.setConditionshortname(textConditionShortname.getText());
                
                try {
                    //object speichern
                    // Fehlerbehandlung
                    Database.deleteObject(o);

                    //ÜbersichtsTabelle aktualisieren
                    refreshConditionTable(textConditionSearch.getText());
                    
                    //Detailansicht leeren
                    textConditionID.setText("");
                    textConditionName.setText("");
                    textConditionShortname.setText("");
                    
                    //in Tabelle nächsten auswählen
                    try {
                        tableCondition.select(0);
                    } catch (Exception ex) {}
                    
                    //Statusline Nachricht sezten
                    statusLine.setStatus(1,l.getString("Condition.groupdetail.deletebutton.newok"));

                } catch (DataBaseException e) {
                    if (e.getMessage().equalsIgnoreCase("1")) {
                        //Fehler beim Speichern des Objectes

                        statusLine.setStatus(3,l.getString("Condition.groupdetail.deletebutton.errorsave"));
                        showMsg(l.getString("Condition.groupdetail.deletebutton.errorsave"),
                                l.getString("error"), SWT.ICON_ERROR | SWT.OK);
                        
                    } else if (e.getMessage().equalsIgnoreCase("2")) {
                        //fehler beim db aufbau
                        statusLine.setStatus(3,l.getString("Condition.groupdetail.deletebutton.errordb"));
                        showMsg(l.getString("Condition.groupdetail.deletebutton.errordb"),
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
        buttonConditionFill = new Button(composite2, SWT.PUSH | SWT.CENTER);
        GridData buttonConditionFillLData = new GridData();
        buttonConditionFill.setVisible(false);
        buttonConditionFill.setEnabled(false);
        buttonConditionFillLData.widthHint = 30;
        buttonConditionFillLData.heightHint = 23;
        buttonConditionFill.setLayoutData(buttonConditionFillLData);

        buttonConditionSave = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonConditionSave.setText(l.getString("button.save"));
        buttonConditionSave.setEnabled(false);
        buttonConditionSave.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                System.out
                        .println("buttonConditionSave.widgetSelected, event="
                                + evt);

                
                //testen ob Name leer ist
                if (textConditionName.getText().trim().equalsIgnoreCase("")) {
                    
                    showMsg(l.getString("Condition.groupdetail.savebutton.warn.noname.msg"),
                            l.getString("Condition.groupdetail.savebutton.warn.noname.title"),
                            SWT.ICON_WARNING | SWT.YES);

                    	return;
                }
                
                //testen welcher mode
                
                if (mode_Condition == ManagementGui.MODE_ADD) {
                    
                    /**
                     * @todo eine Exception bekommen wieder leider NOCH nicht mit
                     * d.h. es muss noch ein rückgabewert kommen oder eine Exception 
                     * übermitteln werden (aus der DB Klasse)
                     */
                    //neues Objekt erzeugen
                    Condition tmp = new Condition(textConditionName.getText(),
                            textConditionShortname.getText());
                    
                    try {
                        //object speichern
                        // Fehlerbehandlung
                        Object o = Database.saveObject(
                                new Condition(textConditionName.getText(),
                                        textConditionShortname.getText()));
                        
                        // in Übersichtstabelle einfügen
                        insertIntoConditionTable((Condition)o);
                        textConditionID.setText( ((Condition)o).getConditionId()+"" );
                        
                        
                        //Statusline Nachricht sezten
                        statusLine.setStatus(1,l.getString("Condition.groupdetail.savebutton.newok"));

                    } catch (DataBaseException e) {
                        if (e.getMessage().equalsIgnoreCase("1")) {
                            //Fehler beim Speichern des Objectes

                            statusLine.setStatus(3,l.getString("Condition.groupdetail.savebutton.errorsave"));
                            showMsg(l.getString("Condition.groupdetail.savebutton.errorsave"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                            
                        } else if (e.getMessage().equalsIgnoreCase("2")) {
                            //fehler beim db aufbau
                            statusLine.setStatus(3,l.getString("Condition.groupdetail.savebutton.errordb"));
                            showMsg(l.getString("Condition.groupdetail.savebutton.errordb"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                            
                        } else {
                            //@todo
                            e.printStackTrace();
                        }
                        
                    }
                    
                    
                    //alle Buttons auf aktiv setzen
                    setVideoGroupButtonSaveCancel();
                    
                } else if (mode_Condition == ManagementGui.MODE_EDIT) {
                    
                    Condition tmp = new Condition(textConditionName.getText(),
                                    textConditionShortname.getText());
        		tmp.setConditionId( new Integer (Integer.parseInt(textConditionID.getText())) );
                try {
                    //object speichern
                    // Fehlerbehandlung
                    Database.updateObject(tmp);
                    //Übersichtstabelle aktualisieren
                    refreshConditionTable(textConditionSearch.getText());
                    
                    //Statusline Nachricht sezten
                    statusLine.setStatus(1,l.getString("Condition.groupdetail.savebutton.editok"));
                   

                } catch (DataBaseException e) {
                    if (e.getMessage().equalsIgnoreCase("1")) {
                        //Fehler beim Speichern des Objectes

                        statusLine.setStatus(3,l.getString("Condition.groupdetail.savebutton.errorsave"));
                        showMsg(l.getString("Condition.groupdetail.savebutton.errorsave"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                        
                    } else if (e.getMessage().equalsIgnoreCase("2")) {
                        //fehler beim db aufbau
                        statusLine.setStatus(3,l.getString("Condition.groupdetail.savebutton.errordb"));
                        showMsg(l.getString("Condition.groupdetail.savebutton.errordb"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                        
                    } else {
                        //@todo
                        e.printStackTrace();
                    }
                    
                }
                    
 
                    //alle Buttons auf aktiv setzen
                    setVideoGroupButtonSaveCancel();
                    
                }
                
                
                
                /**
                 * @todo Exception werfen, da nur die zwei Modes sein dürfen
                 */
                
            }
        });

        buttonConditionCancel = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonConditionCancel.setText(l.getString("button.cancel"));
        buttonConditionCancel.setEnabled(false);
        buttonConditionCancel.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                System.out
                        .println("buttonConditionCancel.widgetSelected, event="
                                + evt);
                setVideoGroupButtonSaveCancel();
            }
        });

        
    }

    /**
     * 
     */
    protected void setVideoGroupButtonSaveCancel() {
        buttonConditionSave.setEnabled(false);
        buttonConditionCancel.setEnabled(false);
        buttonConditionEdit.setEnabled(true);
        buttonConditionNew.setEnabled(true);
        buttonConditionDelete.setEnabled(true);
        textConditionName.setEditable(false);
        textConditionShortname.setEditable(false);
        textConditionSearch.setEditable(true);

        // VideoTabelle aktivieren
        tableCondition.setEnabled(true);

        //VideoSearch aktivieren
        textConditionSearch.setEnabled(true);
        
    }

    /**
     * @param Condition
     */
    protected void insertIntoConditionTable(Condition s) {
        TableItem item = new TableItem(tableCondition, SWT.NONE);
        item.setText(new String[] { s.getConditionId() + "", s.getConditionName(),
                s.getConditionshortname() });
        
    }

    /**
     * 
     */
    protected void refreshConditionTable(final String filter) {
        if (tableCondition == null) {
            System.out
                    .println("Konnte Conditiontable nicht refreshen, da diese null ist!");
            return;
        }
        System.out.println("Versuche nun VideoListe zu refreshen. Filter: "
                + filter);
        tableCondition.removeAll();
        TableItem item;
        java.util.List Conditionlist = Database.getCondition(filter);

        for (int i = 0; i < Conditionlist.size(); i++) {

            Condition o = (Condition) Conditionlist.get(i);
            item = new TableItem(tableCondition, SWT.NONE);
            item.setText(new String[] { o.getConditionId() + "", o.getConditionName(),
                    o.getConditionshortname() });

        }

        
    }

    /**
     * 
     */
    private void initConditionGroupOverview() {
        if (logger.isDebugEnabled()) {
            logger.debug("initConditionGroupOverview() - start");
        }

        groupConditionOverview = new Group(sashFormCondition, SWT.NONE);
        GridLayout group5Layout = new GridLayout();
        group5Layout.numColumns = 8;
        groupConditionOverview.setText(l
                .getString("Condition.groupoverview.label"));
        FormData group5LData = new FormData();
        groupConditionOverview.setLayout(group5Layout);
        group5LData.left = new FormAttachment(0, 100, 0);
        group5LData.top = new FormAttachment(0, 100, 0);
        groupConditionOverview.setLayoutData(group5LData);

        //Tabelle anzeigen
        initTableCondition();
        //Suche darunter anzeigen
        initConditionSearch();

        if (logger.isDebugEnabled()) {
            logger.debug("initConditionGroupOverview() - end");
        }
        
    }

    /**
     * 
     */
    private void initConditionSearch() {
        if (logger.isDebugEnabled()) {
            logger.debug("initConditionSearch() - start");
        }

        //label für die Suche
        labelConditionSearch = new Label(groupConditionOverview, SWT.NONE);
        labelConditionSearch.setText(l
                .getString("Condition.groupoverview.searchlabel")
                + ":");
        GridData label2LData = new GridData();
        label2LData.horizontalSpan = 3;
        labelConditionSearch.setLayoutData(label2LData);

        //das Suchfeld
        textConditionSearch = new Text(groupConditionOverview, SWT.BORDER);
        GridData text2LData = new GridData();
        textConditionSearch.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                if (logger.isDebugEnabled()) {
                    logger.debug("focusLost(FocusEvent evt = " + evt + " "
                            + textConditionSearch.getText() + ") - start");
                }

                refreshConditionTable(textConditionSearch.getText());

                if (logger.isDebugEnabled()) {
                    logger.debug("focusLost(FocusEvent) - end");
                }
            }
        });

        textConditionSearch.addListener(SWT.DefaultSelection, new Listener() {
            public void handleEvent(Event e) {
                if (logger.isDebugEnabled()) {
                    logger.debug("handleEvent(Event e = " + e + " "
                            + textConditionSearch.getText() + ") - start");
                }

                refreshConditionTable(textConditionSearch.getText());

                if (logger.isDebugEnabled()) {
                    logger.debug("handleEvent(Event) - end");
                }
            }
        });

        text2LData.horizontalAlignment = GridData.FILL;
        text2LData.horizontalSpan = 5;
        text2LData.grabExcessHorizontalSpace = true;
        textConditionSearch.setLayoutData(text2LData);



        if (logger.isDebugEnabled()) {
            logger.debug("initConditionSearch() - end");
        }
        
    }

    /**
     * 
     */
    private void initTableCondition() {
        if (logger.isDebugEnabled()) {
            logger.debug("initTableCondition() - start");
        }

        tableCondition = new Table(groupConditionOverview, SWT.SINGLE
                | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.BORDER);
        tableCondition.setHeaderVisible(true);
        tableCondition.setLinesVisible(true);
        GridData table2LData = new GridData();
        tableCondition.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                System.out.println("tableCondition.focusLost, event=" + evt);
                //TODO add your code for tableCondition.focusLost
            }
            public void focusGained(FocusEvent evt) {
                System.out
                    .println("tableCondition.focusGained, event=" + evt);
                //TODO add your code for tableCondition.focusGained
            }
        });
        tableCondition.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                if (logger.isDebugEnabled()) {
                    logger.debug("widgetSelected(SelectionEvent evt = "
                        + evt
                        + ") - start");
                }

                int index = tableCondition.getSelectionIndex();

                System.out.println("Table select. id: "
                    + index
                    + " TableItem:"
                    + tableCondition.getItem(index)
                    + " id: "
                    + tableCondition.getItem(index).getText(0));

                //es wurde ein Element aus Tabelle ausgewaehlt jetzt muss die
                //Detailansicht aktualisiert werden
                refreshConditionDetail(tableCondition.getItem(index)
                    .getText(0));

                if (logger.isDebugEnabled()) {
                    logger.debug("widgetSelected(SelectionEvent) - end");
                }
            }
        });
        table2LData.verticalAlignment = GridData.FILL;
        table2LData.horizontalAlignment = GridData.FILL;
        table2LData.horizontalSpan = 8;
        table2LData.grabExcessHorizontalSpace = true;
        table2LData.grabExcessVerticalSpace = true;
        tableCondition.setLayoutData(table2LData);

        //einzelne Spalten hinzufügen
        tableColumn = new TableColumn(tableCondition, SWT.CENTER);
        tableColumn.setText(l.getString("Condition.groupoverview.columnid"));
        tableColumn.setWidth(50);

        tableColumn = new TableColumn(tableCondition, SWT.CENTER);
        tableColumn.setText(l.getString("Condition.groupoverview.columnname"));
        tableColumn.setWidth(200);

        tableColumn = new TableColumn(tableCondition, SWT.CENTER);
        tableColumn.setText(l.getString("Condition.groupoverview.columnshortname"));
        tableColumn.setWidth(75);

        if (logger.isDebugEnabled()) {
            logger.debug("initTableCondition() - end");
        }
        
    }

    /**
     * @param text
     */
    protected void refreshConditionDetail(final String id) {
        Condition object;
        try {
            //since we only can get a String value from the table, we
            //need to convert this
            object = Database.getSingleCondition(Integer.parseInt(id));

            if (object == null) {

                /*
                 * 
                 * @TODO Statusbar aktualiseren
                 */
                return;
            }
        } catch (Exception e) {
            // TODO: handle exception
            //id ist keine Zahl
            return;
        }

        textConditionID.setText(object.getConditionId() + "");
        textConditionName.setText(object.getConditionName());
        textConditionShortname.setText(object.getConditionshortname());

        //Buttons zum löschen und editieren aktivieren
        buttonConditionEdit.setEnabled(true);
        buttonConditionDelete.setEnabled(true);

        //Mode auf view setzen
        mode_Condition = ManagementGui.MODE_VIEW;

        
    }

    /**
     * 
     */
    private void initStatusGroup() {
        {
            //init a group for the Status
            groupStatus = new Group(sashForm1, SWT.NONE);
            GridLayout group2Layout = new GridLayout();
            group2Layout.makeColumnsEqualWidth = true;
            groupStatus.setText(l.getString("Status.group.label"));
            groupStatus.setSize(758, 284);
            FormData group2LData = new FormData();
            groupStatus.addFocusListener(new FocusAdapter() {
                public void focusLost(FocusEvent evt) {
                    System.out.println("groupStatus.focusLost, event="
                        + evt);
                    buttonStatusCancel.setEnabled(false);
                    buttonStatusDelete.setEnabled(false);
                    buttonStatusEdit.setEnabled(false);
                    buttonStatusNew.setEnabled(false);
                    buttonStatusSave.setEnabled(false);
                    //TODO add your code for groupStatus.focusLost
                }
            });
            groupStatus.setLayout(group2Layout);
            groupStatus.setLayoutData(group2LData);
            {
                sashFormStatus = new SashForm(groupStatus, SWT.NONE);
                FormLayout sashForm2Layout = new FormLayout();
                sashFormStatus.setSize(748, 300);
                GridData sashForm2LData = new GridData();
                sashFormStatus.setLayout(sashForm2Layout);
                sashForm2LData.verticalAlignment = GridData.FILL;
                sashForm2LData.horizontalAlignment = GridData.FILL;
                sashForm2LData.grabExcessHorizontalSpace = true;
                sashForm2LData.grabExcessVerticalSpace = true;
                sashFormStatus.setLayoutData(sashForm2LData);

                //init die Gruppe für Statuse Überblick
                initStatusGroupOverview();
                //init die Detailansicht
                initStatusGroupDetail();

            }
        }

	}

    /**
     * 
     */
    private void initStatusGroupDetail() {
        groupStatusDetail = new Group(sashFormStatus, SWT.NONE);
        GridLayout groupStatusDetailLayout = new GridLayout();
        groupStatusDetailLayout.marginHeight = 25;
        groupStatusDetailLayout.numColumns = 6;
        groupStatusDetailLayout.verticalSpacing = 15;
        groupStatusDetail.setText(l
                .getString("Status.groupdetail.label"));
        FormData formData = new FormData();
        groupStatusDetail.setLayout(groupStatusDetailLayout);
        formData.right = new FormAttachment(100, 100, -5);
        formData.top = new FormAttachment(0, 100, 5);
        formData.bottom = new FormAttachment(100, 100, -5);
        groupStatusDetail.setLayoutData(formData);
        {
            labelStatusId = new Label(groupStatusDetail, SWT.NONE);
            labelStatusId.setText(l
                    .getString("Status.groupdetail.idlabel")
                    + ":");
            labelStatusId.setSize(125, 15);
            GridData formData2 = new GridData();
            formData2.widthHint = 125;
            formData2.heightHint = 15;
            formData2.horizontalSpan = 2;
            labelStatusId.setLayoutData(formData2);
        }
        {
            textStatusID = new Text(groupStatusDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData1 = new GridData();
            text1LData1.horizontalAlignment = GridData.FILL;
            text1LData1.heightHint = 13;
            text1LData1.horizontalSpan = 4;
            text1LData1.grabExcessHorizontalSpace = true;
            textStatusID.setLayoutData(text1LData1);
        }
        {
            labelStatusName = new Label(groupStatusDetail, SWT.NONE);
            labelStatusName.setText(l
                    .getString("Status.groupdetail.namelabel")
                    + ":");
            labelStatusName.setSize(125, 15);
            GridData labelStatusNameLData = new GridData();
            labelStatusNameLData.widthHint = 125;
            labelStatusNameLData.heightHint = 15;
            labelStatusNameLData.horizontalSpan = 2;
            labelStatusName.setLayoutData(labelStatusNameLData);
        }
        {
            textStatusName = new Text(groupStatusDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData2 = new GridData();
            text1LData2.horizontalAlignment = GridData.FILL;
            text1LData2.heightHint = 13;
            text1LData2.horizontalSpan = 4;
            text1LData2.grabExcessHorizontalSpace = true;
            textStatusName.setLayoutData(text1LData2);
        }
        {
            labelStatusShortname = new Label(groupStatusDetail,
                    SWT.NONE);
            labelStatusShortname.setText(l
                    .getString("Status.groupdetail.shortcutlabel")
                    + ":");
            labelStatusShortname.setSize(125, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 125;
            label1LData1.heightHint = 15;
            label1LData1.horizontalSpan = 2;
            labelStatusShortname.setLayoutData(label1LData1);
        }
        {
            textStatusShortname = new Text(groupStatusDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 4;
            text1LData3.grabExcessHorizontalSpace = true;
            textStatusShortname.setLayoutData(text1LData3);
        }
        {

            //die Buttons bekommen ein eigenes Composite
            composite2 = new Composite(groupStatusDetail, SWT.EMBEDDED);
            GridLayout composite2Layout = new GridLayout();
            composite2Layout.numColumns = 6;
            GridData composite2LData = new GridData();
            composite2.setLayout(composite2Layout);
            composite2LData.verticalAlignment = GridData.END;
            composite2LData.horizontalAlignment = GridData.CENTER;
            composite2LData.widthHint = 391;
            composite2LData.horizontalSpan = 6;
            composite2LData.grabExcessHorizontalSpace = true;
            composite2LData.grabExcessVerticalSpace = true;
            composite2LData.heightHint = 35;
            composite2.setLayoutData(composite2LData);

            //init all the Buttons
            initStatusDetailButtons();

        }

        
    }

    /**
     * 
     */
    private void initStatusDetailButtons() {
        buttonStatusNew = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonStatusNew.setText(l.getString("button.new"));
        buttonStatusNew.addSelectionListener(new SelectionAdapter() {
            

            public void widgetSelected(SelectionEvent evt) {

                textStatusID.setText("");
                textStatusName.setText("");
                textStatusShortname.setText("");
                

                textStatusName.setEditable(true);
                textStatusShortname.setEditable(true);
                buttonStatusCancel.setEnabled(true);
                buttonStatusSave.setEnabled(true);
                buttonStatusNew.setEnabled(false);
                buttonStatusEdit.setEnabled(false);
                buttonStatusDelete.setEnabled(false);
                
                textStatusSearch.setEditable(false);
                tableStatus.setEnabled(false);

                mode_Status = ManagementGui.MODE_ADD;

            }
        });

        buttonStatusEdit = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonStatusEdit.setText(l.getString("button.edit"));
        buttonStatusEdit.setEnabled(false);
        buttonStatusEdit.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {

                mode_Status = ManagementGui.MODE_EDIT;


                textStatusID.setEditable(false);

                textStatusName.setEditable(true);
                textStatusName.setFocus();
                textStatusShortname.setEditable(true);
                buttonStatusCancel.setEnabled(true);
                buttonStatusSave.setEnabled(true);
                buttonStatusNew.setEnabled(false);
                buttonStatusEdit.setEnabled(false);
                buttonStatusDelete.setEnabled(false);


                tableStatus.setEnabled(false);
                textStatusSearch.setEnabled(false);
                

            }
        });

        buttonStatusDelete = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonStatusDelete.setText(l.getString("button.delete"));
        buttonStatusDelete.setEnabled(false);
        buttonStatusDelete.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                System.out
                        .println("buttonStatusDelete.widgetSelected, event="
                                + evt);
                
                
               String msg = MessageFormat.format(
                       l.getString("Status.groupdetail.deletebutton.question.text"),
                               new Object[]{textStatusName.getText()+" "+textStatusShortname.getText()});
                
               int question = showMsg(msg,
                       l.getString("Status.groupdetail.deletebutton.question.header"), 
                       SWT.ICON_QUESTION | SWT.YES | SWT.NO);
               
               if (question != SWT.YES){
                   return;
               }
                
                Status o = new Status();
                o.setStatusId(new Integer(Integer.parseInt(textStatusID.getText())));
                o.setStatusName(textStatusName.getText());
                o.setStatusShortname(textStatusShortname.getText());
                
                try {
                    //object speichern
                    // Fehlerbehandlung
                    Database.deleteObject(o);

                    //ÜbersichtsTabelle aktualisieren
                    refreshStatusTable(textStatusSearch.getText());
                    
                    //Detailansicht leeren
                    textStatusID.setText("");
                    textStatusName.setText("");
                    textStatusShortname.setText("");
                    
                    //in Tabelle nächsten auswählen
                    try {
                        tableStatus.select(0);
                    } catch (Exception ex) {}
                    
                    //Statusline Nachricht sezten
                    statusLine.setStatus(1,l.getString("Status.groupdetail.deletebutton.newok"));

                } catch (DataBaseException e) {
                    if (e.getMessage().equalsIgnoreCase("1")) {
                        //Fehler beim Speichern des Objectes

                        statusLine.setStatus(3,l.getString("Status.groupdetail.deletebutton.errorsave"));
                        showMsg(l.getString("Status.groupdetail.deletebutton.errorsave"),
                                l.getString("error"), SWT.ICON_ERROR | SWT.OK);
                        
                    } else if (e.getMessage().equalsIgnoreCase("2")) {
                        //fehler beim db aufbau
                        statusLine.setStatus(3,l.getString("Status.groupdetail.deletebutton.errordb"));
                        showMsg(l.getString("Status.groupdetail.deletebutton.errordb"),
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
        buttonStatusFill = new Button(composite2, SWT.PUSH | SWT.CENTER);
        GridData buttonStatusFillLData = new GridData();
        buttonStatusFill.setVisible(false);
        buttonStatusFill.setEnabled(false);
        buttonStatusFillLData.widthHint = 30;
        buttonStatusFillLData.heightHint = 23;
        buttonStatusFill.setLayoutData(buttonStatusFillLData);

        buttonStatusSave = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonStatusSave.setText(l.getString("button.save"));
        buttonStatusSave.setEnabled(false);
        buttonStatusSave.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                System.out
                        .println("buttonStatusSave.widgetSelected, event="
                                + evt);

                
                //testen ob Name leer ist
                if (textStatusName.getText().trim().equalsIgnoreCase("")) {
                    
                    showMsg(l.getString("Status.groupdetail.savebutton.warn.noname.msg"),
                            l.getString("Status.groupdetail.savebutton.warn.noname.title"),
                            SWT.ICON_WARNING | SWT.YES);

                    	return;
                }
                
                //testen welcher mode
                
                if (mode_Status == ManagementGui.MODE_ADD) {
                    
                    /**
                     * @todo eine Exception bekommen wieder leider NOCH nicht mit
                     * d.h. es muss noch ein rückgabewert kommen oder eine Exception 
                     * übermitteln werden (aus der DB Klasse)
                     */
                    //neues Objekt erzeugen
                    Status tmp = new Status(textStatusName.getText(),
                            textStatusShortname.getText());
                    
                    try {
                        //object speichern
                        // Fehlerbehandlung
                        Object o = Database.saveObject(
                                new Status(textStatusName.getText(),
                                        textStatusShortname.getText()));
                        
                        // in Übersichtstabelle einfügen
                        insertIntoStatusTable((Status)o);
                        textStatusID.setText( ((Status)o).getStatusId()+"" );
                        
                        
                        //Statusline Nachricht sezten
                        statusLine.setStatus(1,l.getString("Status.groupdetail.savebutton.newok"));

                    } catch (DataBaseException e) {
                        if (e.getMessage().equalsIgnoreCase("1")) {
                            //Fehler beim Speichern des Objectes

                            statusLine.setStatus(3,l.getString("Status.groupdetail.savebutton.errorsave"));
                            showMsg(l.getString("Status.groupdetail.savebutton.errorsave"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                            
                        } else if (e.getMessage().equalsIgnoreCase("2")) {
                            //fehler beim db aufbau
                            statusLine.setStatus(3,l.getString("Status.groupdetail.savebutton.errordb"));
                            showMsg(l.getString("Status.groupdetail.savebutton.errordb"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                            
                        } else {
                            //@todo
                            e.printStackTrace();
                        }
                        
                    }
                    
                    
                    //alle Buttons auf aktiv setzen
                    setStatusGroupButtonSaveCancel();
                    
                } else if (mode_Status == ManagementGui.MODE_EDIT) {
                    
                    Status tmp = new Status(textStatusName.getText(),
                                    textStatusShortname.getText());
        		tmp.setStatusId( new Integer (Integer.parseInt(textStatusID.getText())) );
                try {
                    //object speichern
                    // Fehlerbehandlung
                    Database.updateObject(tmp);
                    //Übersichtstabelle aktualisieren
                    refreshStatusTable(textStatusSearch.getText());
                    
                    //Statusline Nachricht sezten
                    statusLine.setStatus(1,l.getString("Status.groupdetail.savebutton.editok"));
                   

                } catch (DataBaseException e) {
                    if (e.getMessage().equalsIgnoreCase("1")) {
                        //Fehler beim Speichern des Objectes

                        statusLine.setStatus(3,l.getString("Status.groupdetail.savebutton.errorsave"));
                        showMsg(l.getString("Status.groupdetail.savebutton.errorsave"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                        
                    } else if (e.getMessage().equalsIgnoreCase("2")) {
                        //fehler beim db aufbau
                        statusLine.setStatus(3,l.getString("Status.groupdetail.savebutton.errordb"));
                        showMsg(l.getString("Status.groupdetail.savebutton.errordb"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                        
                    } else {
                        //@todo
                        e.printStackTrace();
                    }
                    
                }
                    
 
                    //alle Buttons auf aktiv setzen
                    setStatusGroupButtonSaveCancel();
                    
                }
                
                
                
                /**
                 * @todo Exception werfen, da nur die zwei Modes sein dürfen
                 */
                
            }
        });

        buttonStatusCancel = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonStatusCancel.setText(l.getString("button.cancel"));
        buttonStatusCancel.setEnabled(false);
        buttonStatusCancel.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                System.out
                        .println("buttonStatusCancel.widgetSelected, event="
                                + evt);
                setStatusGroupButtonSaveCancel();
            }
        });

        
    }

    /**
     * 
     */
    protected void setStatusGroupButtonSaveCancel() {
        buttonStatusSave.setEnabled(false);
        buttonStatusCancel.setEnabled(false);
        buttonStatusEdit.setEnabled(true);
        buttonStatusNew.setEnabled(true);
        buttonStatusDelete.setEnabled(true);
        textStatusName.setEditable(false);
        textStatusShortname.setEditable(false);
        textStatusSearch.setEditable(true);

        // StatusTabelle aktivieren
        tableStatus.setEnabled(true);

        //StatusSearch aktivieren
        textStatusSearch.setEnabled(true);
        
    }

    /**
     * @param Status
     */
    protected void insertIntoStatusTable(Status Status) {
        TableItem item = new TableItem(tableStatus, SWT.NONE);
        item.setText(new String[] { Status.getStatusId() + "", Status.getStatusName(),
                Status.getStatusShortname() });
        
    }

    /**
     * @param text
     */
    protected void refreshStatusTable(final String filter) {
        if (tableStatus == null) {
            System.out
                    .println("Konnte Statustable nicht refreshen, da diese null ist!");
            return;
        }
        System.out.println("Versuche nun StatusListe zu refreshen. Filter: "
                + filter);
        tableStatus.removeAll();
        TableItem item;
        java.util.List Statuslist = Database.getStatus(filter);

        for (int i = 0; i < Statuslist.size(); i++) {

            Status o = (Status) Statuslist.get(i);
            item = new TableItem(tableStatus, SWT.NONE);
            item.setText(new String[] { o.getStatusId() + "", o.getStatusName(),
                    o.getStatusShortname() });

        }

        
    }

    /**
     * 
     */
    private void initStatusGroupOverview() {
        if (logger.isDebugEnabled()) {
            logger.debug("initStatusGroupOverview() - start");
        }

        groupStatusOverview = new Group(sashFormStatus, SWT.NONE);
        GridLayout group5Layout = new GridLayout();
        group5Layout.numColumns = 8;
        groupStatusOverview.setText(l
                .getString("Status.groupoverview.label"));
        FormData group5LData = new FormData();
        groupStatusOverview.setLayout(group5Layout);
        group5LData.left = new FormAttachment(0, 100, 0);
        group5LData.top = new FormAttachment(0, 100, 0);
        groupStatusOverview.setLayoutData(group5LData);

        //Tabelle anzeigen
        initTableStatus();
        //Suche darunter anzeigen
        initStatusSearch();

        if (logger.isDebugEnabled()) {
            logger.debug("initStatusGroupOverview() - end");
        }
        
    }

    /**
     * 
     */
    private void initStatusSearch() {
        if (logger.isDebugEnabled()) {
            logger.debug("initStatusSearch() - start");
        }

        //label für die Suche
        labelStatusSearch = new Label(groupStatusOverview, SWT.NONE);
        labelStatusSearch.setText(l
                .getString("Status.groupoverview.searchlabel")
                + ":");
        GridData label2LData = new GridData();
        label2LData.horizontalSpan = 3;
        labelStatusSearch.setLayoutData(label2LData);

        //das Suchfeld
        textStatusSearch = new Text(groupStatusOverview, SWT.BORDER);
        GridData text2LData = new GridData();
        textStatusSearch.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                if (logger.isDebugEnabled()) {
                    logger.debug("focusLost(FocusEvent evt = " + evt + " "
                            + textStatusSearch.getText() + ") - start");
                }

                refreshStatusTable(textStatusSearch.getText());

                if (logger.isDebugEnabled()) {
                    logger.debug("focusLost(FocusEvent) - end");
                }
            }
        });

        textStatusSearch.addListener(SWT.DefaultSelection, new Listener() {
            public void handleEvent(Event e) {
                if (logger.isDebugEnabled()) {
                    logger.debug("handleEvent(Event e = " + e + " "
                            + textStatusSearch.getText() + ") - start");
                }

                refreshStatusTable(textStatusSearch.getText());

                if (logger.isDebugEnabled()) {
                    logger.debug("handleEvent(Event) - end");
                }
            }
        });

        text2LData.horizontalAlignment = GridData.FILL;
        text2LData.horizontalSpan = 5;
        text2LData.grabExcessHorizontalSpace = true;
        textStatusSearch.setLayoutData(text2LData);



        if (logger.isDebugEnabled()) {
            logger.debug("initStatusSearch() - end");
        }
        
    }

    /**
     * 
     */
    private void initTableStatus() {
        if (logger.isDebugEnabled()) {
            logger.debug("initTableStatus() - start");
        }

        tableStatus = new Table(groupStatusOverview, SWT.SINGLE
                | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.BORDER);
        tableStatus.setHeaderVisible(true);
        tableStatus.setLinesVisible(true);
        GridData table2LData = new GridData();
        tableStatus.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                System.out.println("tableStatus.focusLost, event=" + evt);
                //TODO add your code for tableStatus.focusLost
            }
            public void focusGained(FocusEvent evt) {
                System.out
                    .println("tableStatus.focusGained, event=" + evt);
                //TODO add your code for tableStatus.focusGained
            }
        });
        tableStatus.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                if (logger.isDebugEnabled()) {
                    logger.debug("widgetSelected(SelectionEvent evt = "
                        + evt
                        + ") - start");
                }

                int index = tableStatus.getSelectionIndex();

                System.out.println("Table select. id: "
                    + index
                    + " TableItem:"
                    + tableStatus.getItem(index)
                    + " id: "
                    + tableStatus.getItem(index).getText(0));

                //es wurde ein Element aus Tabelle ausgewaehlt jetzt muss die
                //Detailansicht aktualisiert werden
                refreshStatusDetail(tableStatus.getItem(index)
                    .getText(0));

                if (logger.isDebugEnabled()) {
                    logger.debug("widgetSelected(SelectionEvent) - end");
                }
            }
        });
        table2LData.verticalAlignment = GridData.FILL;
        table2LData.horizontalAlignment = GridData.FILL;
        table2LData.horizontalSpan = 8;
        table2LData.grabExcessHorizontalSpace = true;
        table2LData.grabExcessVerticalSpace = true;
        tableStatus.setLayoutData(table2LData);

        //einzelne Spalten hinzufügen
        tableColumn = new TableColumn(tableStatus, SWT.CENTER);
        tableColumn.setText(l.getString("Status.groupoverview.columnid"));
        tableColumn.setWidth(50);

        tableColumn = new TableColumn(tableStatus, SWT.CENTER);
        tableColumn.setText(l.getString("Status.groupoverview.columnname"));
        tableColumn.setWidth(200);

        tableColumn = new TableColumn(tableStatus, SWT.CENTER);
        tableColumn.setText(l.getString("Status.groupoverview.columnshortname"));
        tableColumn.setWidth(75);

        if (logger.isDebugEnabled()) {
            logger.debug("initTableStatus() - end");
        }
        
    }

    /**
     * @param text
     */
    protected void refreshStatusDetail(final String id) {
        Status object;
        try {
            //since we only can get a String value from the table, we
            //need to convert this
            object = Database.getSingleStatus(Integer.parseInt(id));

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

        textStatusID.setText(object.getStatusId() + "");
        textStatusName.setText(object.getStatusName());
        textStatusShortname.setText(object.getStatusShortname());

        //Buttons zum löschen und editieren aktivieren
        buttonStatusEdit.setEnabled(true);
        buttonStatusDelete.setEnabled(true);

        //Mode auf view setzen
        mode_Status = ManagementGui.MODE_VIEW;
        
    }

	

}


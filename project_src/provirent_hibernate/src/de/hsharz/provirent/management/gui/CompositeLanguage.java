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

import de.hsharz.provirent.objects.Language;
import de.hsharz.provirent.objects.Subtitle;
import de.hsharz.provirent.objects.Subtitle;
import de.hsharz.provirent.objects.Subtitle;
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
public class CompositeLanguage extends AbstractComposite{

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }


    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(CompositeLanguage.class);
    
    
    private final static int MODE_VIEW = 0;

    private final static int MODE_ADD = 1;
    
    private SashForm sashForm1;

    private Group groupLanguageOverview;

    private Group groupLanguageDetail;

    private Label labelLanguageId;

    private Label labelLanguageShortname;

    private Text textLanguageName;

    private Label labelLanguageName;

    private Text textLanguageID;
    
    private Button buttonLanguageCancel;

    private Button buttonLanguageSave;

    private Button buttonLanguageFill;

    private Button buttonLanguageDelete;

    private Button buttonLanguageEdit;

    private Button buttonLanguageNew;

    private Text textLanguageShortname;

    private Text textLanguageSearch;

    private Label labelLanguageSearch;

    private Table tableLanguage;

    private SashForm sashFormLanguage;

    private Group groupLanguage;
    
    private Group groupSubtitleOverview;

    private Group groupSubtitleDetail;

    private Label labelSubtitleId;

    private Label labelSubtitleShortname;

    private Text textSubtitleName;

    private Label labelSubtitleName;

    private Text textSubtitleID;
    
    private Button buttonSubtitleCancel;

    private Button buttonSubtitleSave;

    private Button buttonSubtitleFill;

    private Button buttonSubtitleDelete;

    private Button buttonSubtitleEdit;

    private Button buttonSubtitleNew;

    private Text textSubtitleShortname;

    private Text textSubtitleSearch;

    private Label labelSubtitleSearch;

    private SashForm sashFormSubtitle;

    private Group groupSubtitle;
    
    private int mode_Subtitle = 0;
    
    private List list1;
    
    private Table tableSubtitle;

    private Group group1Subtitle;

    private final static int MODE_EDIT = 2;
    
    private StatusLineStyledText statusLine;

    private ResourceBundle l;
    
    private Composite parent;


    private Composite composite2;


    protected int mode_Language;


    private TableColumn tableColumn;
    
    private TableColumn tableColumn1, tableColumn2, tableColumn3;
    
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
                "de.hsharz.provirent.management.gui.language.Language", locale);

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

	public CompositeLanguage(Composite p, int style,
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

            initLanguageGroup();
            initSubTitleGroup();

        }
        this.layout();

        if (logger.isDebugEnabled()) {
            logger.debug("initGUI() - end");
        }
    } 
	
	/**
     * 
     */
    private void initSubTitleGroup() {
        {
            //init a group for the Subtitle
            groupSubtitle = new Group(sashForm1, SWT.NONE);
            GridLayout group2Layout = new GridLayout();
            group2Layout.makeColumnsEqualWidth = true;
            groupSubtitle.setText(l.getString("Subtitle.group.label"));
            groupSubtitle.setSize(758, 284);
            FormData group2LData = new FormData();
            groupSubtitle.addFocusListener(new FocusAdapter() {
                public void focusLost(FocusEvent evt) {
                    System.out.println("groupSubtitle.focusLost, event="
                        + evt);
                    buttonSubtitleCancel.setEnabled(false);
                    buttonSubtitleDelete.setEnabled(false);
                    buttonSubtitleEdit.setEnabled(false);
                    buttonSubtitleNew.setEnabled(false);
                    buttonSubtitleSave.setEnabled(false);
                    
                }
            });
            groupSubtitle.setLayout(group2Layout);
            groupSubtitle.setLayoutData(group2LData);
            {
                sashFormSubtitle = new SashForm(groupSubtitle, SWT.NONE);
                FormLayout sashForm2Layout = new FormLayout();
                sashFormSubtitle.setSize(748, 300);
                GridData sashForm2LData = new GridData();
                sashFormSubtitle.setLayout(sashForm2Layout);
                sashForm2LData.verticalAlignment = GridData.FILL;
                sashForm2LData.horizontalAlignment = GridData.FILL;
                sashForm2LData.grabExcessHorizontalSpace = true;
                sashForm2LData.grabExcessVerticalSpace = true;
                sashFormSubtitle.setLayoutData(sashForm2LData);

                //init die Gruppe für Subtitle Überblick
                initSubtitleGroupOverview();
                //init die Detailansicht
                initSubtitleGroupDetail();

            }
        }

        
    }

    /**
     * 
     */
    private void initSubtitleGroupDetail() {
        groupSubtitleDetail = new Group(sashFormSubtitle, SWT.NONE);
        GridLayout groupSubtitleDetailLayout = new GridLayout();
        groupSubtitleDetailLayout.marginHeight = 25;
        groupSubtitleDetailLayout.numColumns = 6;
        groupSubtitleDetailLayout.verticalSpacing = 15;
        groupSubtitleDetail.setText(l
                .getString("Subtitle.groupdetail.label"));
        FormData formData = new FormData();
        groupSubtitleDetail.setLayout(groupSubtitleDetailLayout);
        formData.right = new FormAttachment(100, 100, -5);
        formData.top = new FormAttachment(0, 100, 5);
        formData.bottom = new FormAttachment(100, 100, -5);
        groupSubtitleDetail.setLayoutData(formData);
        {
            labelSubtitleId = new Label(groupSubtitleDetail, SWT.NONE);
            labelSubtitleId.setText(l
                    .getString("Subtitle.groupdetail.idlabel")
                    + ":");
            labelSubtitleId.setSize(125, 15);
            GridData formData2 = new GridData();
            formData2.widthHint = 125;
            formData2.heightHint = 15;
            formData2.horizontalSpan = 2;
            labelSubtitleId.setLayoutData(formData2);
        }
        {
            textSubtitleID = new Text(groupSubtitleDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData1 = new GridData();
            text1LData1.horizontalAlignment = GridData.FILL;
            text1LData1.heightHint = 13;
            text1LData1.horizontalSpan = 4;
            text1LData1.grabExcessHorizontalSpace = true;
            textSubtitleID.setLayoutData(text1LData1);
        }
        {
            labelSubtitleName = new Label(groupSubtitleDetail, SWT.NONE);
            labelSubtitleName.setText(l
                    .getString("Subtitle.groupdetail.namelabel")
                    + ":");
            labelSubtitleName.setSize(125, 15);
            GridData labelSubtitleNameLData = new GridData();
            labelSubtitleNameLData.widthHint = 125;
            labelSubtitleNameLData.heightHint = 15;
            labelSubtitleNameLData.horizontalSpan = 2;
            labelSubtitleName.setLayoutData(labelSubtitleNameLData);
        }
        {
            textSubtitleName = new Text(groupSubtitleDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData2 = new GridData();
            text1LData2.horizontalAlignment = GridData.FILL;
            text1LData2.heightHint = 13;
            text1LData2.horizontalSpan = 4;
            text1LData2.grabExcessHorizontalSpace = true;
            textSubtitleName.setLayoutData(text1LData2);
        }
        {
            labelSubtitleShortname = new Label(groupSubtitleDetail,
                    SWT.NONE);
            labelSubtitleShortname.setText(l
                    .getString("Subtitle.groupdetail.shortcutlabel")
                    + ":");
            labelSubtitleShortname.setSize(125, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 125;
            label1LData1.heightHint = 15;
            label1LData1.horizontalSpan = 2;
            labelSubtitleShortname.setLayoutData(label1LData1);
        }
        {
            textSubtitleShortname = new Text(groupSubtitleDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 4;
            text1LData3.grabExcessHorizontalSpace = true;
            textSubtitleShortname.setLayoutData(text1LData3);
        }
        {

//          die Buttons bekommen ein eigenes Composite
            composite2 = new Composite(groupSubtitleDetail, SWT.EMBEDDED);
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
            initSubtitleDetailButtons();

        }
        
    }

    /**
     * 
     */
    private void initSubtitleDetailButtons() {
        buttonSubtitleNew = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonSubtitleNew.setText(l.getString("button.new"));
        buttonSubtitleNew.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {

                textSubtitleID.setText("");
                textSubtitleName.setText("");
                textSubtitleShortname.setText("");
                

                textSubtitleName.setEditable(true);
                textSubtitleShortname.setEditable(true);
                buttonSubtitleCancel.setEnabled(true);
                buttonSubtitleSave.setEnabled(true);
                buttonSubtitleNew.setEnabled(false);
                buttonSubtitleEdit.setEnabled(false);
                buttonSubtitleDelete.setEnabled(false);
                
                textSubtitleSearch.setEditable(false);
                tableSubtitle.setEnabled(false);

                mode_Subtitle = ManagementGui.MODE_ADD;

            }
        });

        buttonSubtitleEdit = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonSubtitleEdit.setText(l.getString("button.edit"));
        buttonSubtitleEdit.setEnabled(false);
        buttonSubtitleEdit.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {

                mode_Subtitle = ManagementGui.MODE_EDIT;


                textSubtitleID.setEditable(false);

                textSubtitleName.setEditable(true);
                textSubtitleName.setFocus();
                textSubtitleShortname.setEditable(true);
                buttonSubtitleCancel.setEnabled(true);
                buttonSubtitleSave.setEnabled(true);
                buttonSubtitleNew.setEnabled(false);
                buttonSubtitleEdit.setEnabled(false);
                buttonSubtitleDelete.setEnabled(false);


                tableSubtitle.setEnabled(false);
                textSubtitleSearch.setEnabled(false);
                

            }
        });

        buttonSubtitleDelete = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonSubtitleDelete.setText(l.getString("button.delete"));
        buttonSubtitleDelete.setEnabled(false);
        buttonSubtitleDelete.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                System.out
                        .println("buttonSubtitleDelete.widgetSelected, event="
                                + evt);
                
                
               String msg = MessageFormat.format(
                       l.getString("Subtitle.groupdetail.deletebutton.question.text"),
                               new Object[]{textSubtitleName.getText()+" "+textSubtitleShortname.getText()});
                
               int question = showMsg(msg,
                       l.getString("Subtitle.groupdetail.deletebutton.question.header"), 
                       SWT.ICON_QUESTION | SWT.YES | SWT.NO);
               
               if (question != SWT.YES){
                   return;
               }
                
                Subtitle o = new Subtitle();
                o.setSubtitleId(new Integer(Integer.parseInt(textSubtitleID.getText())));
                o.setName(textSubtitleName.getText());
                o.setShortname(textSubtitleShortname.getText());
                
                try {
                    //object speichern
                    // Fehlerbehandlung
                    Database.deleteObject(o);

                    //ÜbersichtsTabelle aktualisieren
                    refreshSubtitleTable(textSubtitleSearch.getText());
                    
                    //Detailansicht leeren
                    textSubtitleID.setText("");
                    textSubtitleName.setText("");
                    textSubtitleShortname.setText("");
                    
                    //in Tabelle nächsten auswählen
                    try {
                        tableSubtitle.select(0);
                    } catch (Exception ex) {}
                    
                    //Statusline Nachricht sezten
                    statusLine.setStatus(1,l.getString("Subtitle.groupdetail.deletebutton.newok"));

                } catch (DataBaseException e) {
                    if (e.getMessage().equalsIgnoreCase("1")) {
                        //Fehler beim Speichern des Objectes

                        statusLine.setStatus(3,l.getString("Subtitle.groupdetail.deletebutton.errorsave"));
                        showMsg(l.getString("Subtitle.groupdetail.deletebutton.errorsave"),
                                l.getString("error"), SWT.ICON_ERROR | SWT.OK);
                        
                    } else if (e.getMessage().equalsIgnoreCase("2")) {
                        //fehler beim db aufbau
                        statusLine.setStatus(3,l.getString("Subtitle.groupdetail.deletebutton.errordb"));
                        showMsg(l.getString("Subtitle.groupdetail.deletebutton.errordb"),
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
        buttonSubtitleFill = new Button(composite2, SWT.PUSH | SWT.CENTER);
        GridData buttonSubtitleFillLData = new GridData();
        buttonSubtitleFill.setVisible(false);
        buttonSubtitleFill.setEnabled(false);
        buttonSubtitleFillLData.widthHint = 30;
        buttonSubtitleFillLData.heightHint = 23;
        buttonSubtitleFill.setLayoutData(buttonSubtitleFillLData);

        buttonSubtitleSave = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonSubtitleSave.setText(l.getString("button.save"));
        buttonSubtitleSave.setEnabled(false);
        buttonSubtitleSave.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                System.out
                        .println("buttonSubtitleSave.widgetSelected, event="
                                + evt);

                
                //testen ob Name leer ist
                if (textSubtitleName.getText().trim().equalsIgnoreCase("")) {
                    
                    showMsg(l.getString("Subtitle.groupdetail.savebutton.warn.noname.msg"),
                            l.getString("Subtitle.groupdetail.savebutton.warn.noname.title"),
                            SWT.ICON_WARNING | SWT.YES);

                    	return;
                }
                
                //testen welcher mode
                
                if (mode_Subtitle == ManagementGui.MODE_ADD) {
                    
                    /**
                     * @todo eine Exception bekommen wieder leider NOCH nicht mit
                     * d.h. es muss noch ein rückgabewert kommen oder eine Exception 
                     * übermitteln werden (aus der DB Klasse)
                     */
                    //neues Objekt erzeugen
                    Subtitle tmp = new Subtitle(textSubtitleName.getText(),
                            textSubtitleShortname.getText());
                    
                    try {
                        //object speichern
                        // Fehlerbehandlung
                        Object o = Database.saveObject(
                                new Subtitle(textSubtitleName.getText(),
                                        textSubtitleShortname.getText()));
                        
                        // in Übersichtstabelle einfügen
                        insertIntoSubtitleTable((Subtitle)o);
                        textSubtitleID.setText( ((Subtitle)o).getSubtitleId()+"" );
                        
                        
                        //Statusline Nachricht sezten
                        statusLine.setStatus(1,l.getString("Subtitle.groupdetail.savebutton.newok"));

                    } catch (DataBaseException e) {
                        if (e.getMessage().equalsIgnoreCase("1")) {
                            //Fehler beim Speichern des Objectes

                            statusLine.setStatus(3,l.getString("Subtitle.groupdetail.savebutton.errorsave"));
                            showMsg(l.getString("Subtitle.groupdetail.savebutton.errorsave"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                            
                        } else if (e.getMessage().equalsIgnoreCase("2")) {
                            //fehler beim db aufbau
                            statusLine.setStatus(3,l.getString("Subtitle.groupdetail.savebutton.errordb"));
                            showMsg(l.getString("Subtitle.groupdetail.savebutton.errordb"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                            
                        } else {
                            //@todo
                            e.printStackTrace();
                        }
                        
                    }
                    
                    
                    //alle Buttons auf aktiv setzen
                    setVideoGroupButtonSaveCancel();
                    
                } else if (mode_Subtitle == ManagementGui.MODE_EDIT) {
                    
                    Subtitle tmp = new Subtitle(textSubtitleName.getText(),
                                    textSubtitleShortname.getText());
        		tmp.setSubtitleId( new Integer (Integer.parseInt(textSubtitleID.getText())) );
                try {
                    //object speichern
                    // Fehlerbehandlung
                    Database.saveObject(tmp);
                    //Übersichtstabelle aktualisieren
                    refreshSubtitleTable(textSubtitleSearch.getText());
                    
                    //Statusline Nachricht sezten
                    statusLine.setStatus(1,l.getString("Subtitle.groupdetail.savebutton.editok"));
                   

                } catch (DataBaseException e) {
                    if (e.getMessage().equalsIgnoreCase("1")) {
                        //Fehler beim Speichern des Objectes

                        statusLine.setStatus(3,l.getString("Subtitle.groupdetail.savebutton.errorsave"));
                        showMsg(l.getString("Subtitle.groupdetail.savebutton.errorsave"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                        
                    } else if (e.getMessage().equalsIgnoreCase("2")) {
                        //fehler beim db aufbau
                        statusLine.setStatus(3,l.getString("Subtitle.groupdetail.savebutton.errordb"));
                        showMsg(l.getString("Subtitle.groupdetail.savebutton.errordb"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                        
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

        buttonSubtitleCancel = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonSubtitleCancel.setText(l.getString("button.cancel"));
        buttonSubtitleCancel.setEnabled(false);
        buttonSubtitleCancel.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                System.out
                        .println("buttonSubtitleCancel.widgetSelected, event="
                                + evt);
                setVideoGroupButtonSaveCancel();
            }
        });

        
    }

    /**
     * 
     */
    protected void setVideoGroupButtonSaveCancel() {
        buttonSubtitleSave.setEnabled(false);
        buttonSubtitleCancel.setEnabled(false);
        buttonSubtitleEdit.setEnabled(true);
        buttonSubtitleNew.setEnabled(true);
        buttonSubtitleDelete.setEnabled(true);
        textSubtitleName.setEditable(false);
        textSubtitleShortname.setEditable(false);
        textSubtitleSearch.setEditable(true);

        // VideoTabelle aktivieren
        tableSubtitle.setEnabled(true);

        //VideoSearch aktivieren
        textSubtitleSearch.setEnabled(true);
        
    }

    /**
     * @param subtitle
     */
    protected void insertIntoSubtitleTable(Subtitle s) {
        TableItem item = new TableItem(tableSubtitle, SWT.NONE);
        item.setText(new String[] { s.getSubtitleId() + "", s.getName(),
                s.getShortname() });
        
    }

    /**
     * 
     */
    protected void refreshSubtitleTable(final String filter) {
        if (tableSubtitle == null) {
            System.out
                    .println("Konnte Subtitletable nicht refreshen, da diese null ist!");
            return;
        }
        System.out.println("Versuche nun VideoListe zu refreshen. Filter: "
                + filter);
        tableSubtitle.removeAll();
        TableItem item;
        java.util.List Subtitlelist = Database.getSubtitle(filter);

        for (int i = 0; i < Subtitlelist.size(); i++) {

            Subtitle o = (Subtitle) Subtitlelist.get(i);
            item = new TableItem(tableSubtitle, SWT.NONE);
            item.setText(new String[] { o.getSubtitleId() + "", o.getName(),
                    o.getShortname() });

        }

        
    }

    /**
     * 
     */
    private void initSubtitleGroupOverview() {
        if (logger.isDebugEnabled()) {
            logger.debug("initSubtitleGroupOverview() - start");
        }

        groupSubtitleOverview = new Group(sashFormSubtitle, SWT.NONE);
        GridLayout group5Layout = new GridLayout();
        group5Layout.numColumns = 8;
        groupSubtitleOverview.setText(l
                .getString("Subtitle.groupoverview.label"));
        FormData group5LData = new FormData();
        groupSubtitleOverview.setLayout(group5Layout);
        group5LData.left = new FormAttachment(0, 100, 0);
        group5LData.top = new FormAttachment(0, 100, 0);
        groupSubtitleOverview.setLayoutData(group5LData);

        //Tabelle anzeigen
        initTableSubtitle();
        //Suche darunter anzeigen
        initSubtitleSearch();

        if (logger.isDebugEnabled()) {
            logger.debug("initSubtitleGroupOverview() - end");
        }
        
    }

    /**
     * 
     */
    private void initSubtitleSearch() {
        if (logger.isDebugEnabled()) {
            logger.debug("initSubtitleSearch() - start");
        }

        //label für die Suche
        labelSubtitleSearch = new Label(groupSubtitleOverview, SWT.NONE);
        labelSubtitleSearch.setText(l
                .getString("Subtitle.groupoverview.searchlabel")
                + ":");
        GridData label2LData = new GridData();
        label2LData.horizontalSpan = 3;
        labelSubtitleSearch.setLayoutData(label2LData);

        //das Suchfeld
        textSubtitleSearch = new Text(groupSubtitleOverview, SWT.BORDER);
        GridData text2LData = new GridData();
        textSubtitleSearch.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                if (logger.isDebugEnabled()) {
                    logger.debug("focusLost(FocusEvent evt = " + evt + " "
                            + textSubtitleSearch.getText() + ") - start");
                }

                refreshSubtitleTable(textSubtitleSearch.getText());

                if (logger.isDebugEnabled()) {
                    logger.debug("focusLost(FocusEvent) - end");
                }
            }
        });

        textSubtitleSearch.addListener(SWT.DefaultSelection, new Listener() {
            public void handleEvent(Event e) {
                if (logger.isDebugEnabled()) {
                    logger.debug("handleEvent(Event e = " + e + " "
                            + textSubtitleSearch.getText() + ") - start");
                }

                refreshSubtitleTable(textSubtitleSearch.getText());

                if (logger.isDebugEnabled()) {
                    logger.debug("handleEvent(Event) - end");
                }
            }
        });

        text2LData.horizontalAlignment = GridData.FILL;
        text2LData.horizontalSpan = 5;
        text2LData.grabExcessHorizontalSpace = true;
        textSubtitleSearch.setLayoutData(text2LData);



        if (logger.isDebugEnabled()) {
            logger.debug("initSubtitleSearch() - end");
        }
        
    }

    /**
     * 
     */
    private void initTableSubtitle() {
        if (logger.isDebugEnabled()) {
            logger.debug("initTableSubtitle() - start");
        }

        tableSubtitle = new Table(groupSubtitleOverview, SWT.SINGLE
                | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.BORDER);
        tableSubtitle.setHeaderVisible(true);
        tableSubtitle.setLinesVisible(true);
        GridData table2LData = new GridData();
        tableSubtitle.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                System.out.println("tableSubtitle.focusLost, event=" + evt);
                //TODO add your code for tableSubtitle.focusLost
            }
            public void focusGained(FocusEvent evt) {
                System.out
                    .println("tableSubtitle.focusGained, event=" + evt);
                //TODO add your code for tableSubtitle.focusGained
            }
        });
        tableSubtitle.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                if (logger.isDebugEnabled()) {
                    logger.debug("widgetSelected(SelectionEvent evt = "
                        + evt
                        + ") - start");
                }

                int index = tableSubtitle.getSelectionIndex();

                System.out.println("Table select. id: "
                    + index
                    + " TableItem:"
                    + tableSubtitle.getItem(index)
                    + " id: "
                    + tableSubtitle.getItem(index).getText(0));

                //es wurde ein Element aus Tabelle ausgewaehlt jetzt muss die
                //Detailansicht aktualisiert werden
                refreshSubtitleDetail(tableSubtitle.getItem(index)
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
        tableSubtitle.setLayoutData(table2LData);

        //einzelne Spalten hinzufügen
        tableColumn = new TableColumn(tableSubtitle, SWT.CENTER);
        tableColumn.setText(l.getString("Subtitle.groupoverview.columnid"));
        tableColumn.setWidth(50);

        tableColumn = new TableColumn(tableSubtitle, SWT.CENTER);
        tableColumn.setText(l.getString("Subtitle.groupoverview.columnname"));
        tableColumn.setWidth(200);

        tableColumn = new TableColumn(tableSubtitle, SWT.CENTER);
        tableColumn.setText(l.getString("Subtitle.groupoverview.columnshortname"));
        tableColumn.setWidth(75);

        if (logger.isDebugEnabled()) {
            logger.debug("initTableSubtitle() - end");
        }
        
    }

    /**
     * @param text
     */
    protected void refreshSubtitleDetail(final String id) {
        Subtitle object;
        try {
            //since we only can get a String value from the table, we
            //need to convert this
            object = Database.getSingleSubtitle(Integer.parseInt(id));

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

        textSubtitleID.setText(object.getSubtitleId() + "");
        textSubtitleName.setText(object.getName());
        textSubtitleShortname.setText(object.getShortname());

        //Buttons zum löschen und editieren aktivieren
        buttonSubtitleEdit.setEnabled(true);
        buttonSubtitleDelete.setEnabled(true);

        //Mode auf view setzen
        mode_Subtitle = ManagementGui.MODE_VIEW;

        
    }

    /**
     * 
     */
    private void initLanguageGroup() {
        {
            //init a group for the Language
            groupLanguage = new Group(sashForm1, SWT.NONE);
            GridLayout group2Layout = new GridLayout();
            group2Layout.makeColumnsEqualWidth = true;
            groupLanguage.setText(l.getString("Language.group.label"));
            groupLanguage.setSize(758, 284);
            FormData group2LData = new FormData();
            groupLanguage.addFocusListener(new FocusAdapter() {
                public void focusLost(FocusEvent evt) {
                    System.out.println("groupLanguage.focusLost, event="
                        + evt);
                    buttonLanguageCancel.setEnabled(false);
                    buttonLanguageDelete.setEnabled(false);
                    buttonLanguageEdit.setEnabled(false);
                    buttonLanguageNew.setEnabled(false);
                    buttonLanguageSave.setEnabled(false);
                    //TODO add your code for groupLanguage.focusLost
                }
            });
            groupLanguage.setLayout(group2Layout);
            groupLanguage.setLayoutData(group2LData);
            {
                sashFormLanguage = new SashForm(groupLanguage, SWT.NONE);
                FormLayout sashForm2Layout = new FormLayout();
                sashFormLanguage.setSize(748, 300);
                GridData sashForm2LData = new GridData();
                sashFormLanguage.setLayout(sashForm2Layout);
                sashForm2LData.verticalAlignment = GridData.FILL;
                sashForm2LData.horizontalAlignment = GridData.FILL;
                sashForm2LData.grabExcessHorizontalSpace = true;
                sashForm2LData.grabExcessVerticalSpace = true;
                sashFormLanguage.setLayoutData(sashForm2LData);

                //init die Gruppe für Languagee Überblick
                initLanguageGroupOverview();
                //init die Detailansicht
                initLanguageGroupDetail();

            }
        }

	}

    /**
     * 
     */
    private void initLanguageGroupDetail() {
        groupLanguageDetail = new Group(sashFormLanguage, SWT.NONE);
        GridLayout groupLanguageDetailLayout = new GridLayout();
        groupLanguageDetailLayout.marginHeight = 25;
        groupLanguageDetailLayout.numColumns = 6;
        groupLanguageDetailLayout.verticalSpacing = 15;
        groupLanguageDetail.setText(l
                .getString("Language.groupdetail.label"));
        FormData formData = new FormData();
        groupLanguageDetail.setLayout(groupLanguageDetailLayout);
        formData.right = new FormAttachment(100, 100, -5);
        formData.top = new FormAttachment(0, 100, 5);
        formData.bottom = new FormAttachment(100, 100, -5);
        groupLanguageDetail.setLayoutData(formData);
        {
            labelLanguageId = new Label(groupLanguageDetail, SWT.NONE);
            labelLanguageId.setText(l
                    .getString("Language.groupdetail.idlabel")
                    + ":");
            labelLanguageId.setSize(125, 15);
            GridData formData2 = new GridData();
            formData2.widthHint = 125;
            formData2.heightHint = 15;
            formData2.horizontalSpan = 2;
            labelLanguageId.setLayoutData(formData2);
        }
        {
            textLanguageID = new Text(groupLanguageDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData1 = new GridData();
            text1LData1.horizontalAlignment = GridData.FILL;
            text1LData1.heightHint = 13;
            text1LData1.horizontalSpan = 4;
            text1LData1.grabExcessHorizontalSpace = true;
            textLanguageID.setLayoutData(text1LData1);
        }
        {
            labelLanguageName = new Label(groupLanguageDetail, SWT.NONE);
            labelLanguageName.setText(l
                    .getString("Language.groupdetail.namelabel")
                    + ":");
            labelLanguageName.setSize(125, 15);
            GridData labelLanguageNameLData = new GridData();
            labelLanguageNameLData.widthHint = 125;
            labelLanguageNameLData.heightHint = 15;
            labelLanguageNameLData.horizontalSpan = 2;
            labelLanguageName.setLayoutData(labelLanguageNameLData);
        }
        {
            textLanguageName = new Text(groupLanguageDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData2 = new GridData();
            text1LData2.horizontalAlignment = GridData.FILL;
            text1LData2.heightHint = 13;
            text1LData2.horizontalSpan = 4;
            text1LData2.grabExcessHorizontalSpace = true;
            textLanguageName.setLayoutData(text1LData2);
        }
        {
            labelLanguageShortname = new Label(groupLanguageDetail,
                    SWT.NONE);
            labelLanguageShortname.setText(l
                    .getString("Language.groupdetail.shortcutlabel")
                    + ":");
            labelLanguageShortname.setSize(125, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 125;
            label1LData1.heightHint = 15;
            label1LData1.horizontalSpan = 2;
            labelLanguageShortname.setLayoutData(label1LData1);
        }
        {
            textLanguageShortname = new Text(groupLanguageDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 4;
            text1LData3.grabExcessHorizontalSpace = true;
            textLanguageShortname.setLayoutData(text1LData3);
        }
        {

            //die Buttons bekommen ein eigenes Composite
            composite2 = new Composite(groupLanguageDetail, SWT.EMBEDDED);
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
            initLanguageDetailButtons();

        }

        
    }

    /**
     * 
     */
    private void initLanguageDetailButtons() {
        buttonLanguageNew = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonLanguageNew.setText(l.getString("button.new"));
        buttonLanguageNew.addSelectionListener(new SelectionAdapter() {
            

            public void widgetSelected(SelectionEvent evt) {

                textLanguageID.setText("");
                textLanguageName.setText("");
                textLanguageShortname.setText("");
                

                textLanguageName.setEditable(true);
                textLanguageShortname.setEditable(true);
                buttonLanguageCancel.setEnabled(true);
                buttonLanguageSave.setEnabled(true);
                buttonLanguageNew.setEnabled(false);
                buttonLanguageEdit.setEnabled(false);
                buttonLanguageDelete.setEnabled(false);
                
                textLanguageSearch.setEditable(false);
                tableLanguage.setEnabled(false);

                mode_Language = ManagementGui.MODE_ADD;

            }
        });

        buttonLanguageEdit = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonLanguageEdit.setText(l.getString("button.edit"));
        buttonLanguageEdit.setEnabled(false);
        buttonLanguageEdit.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {

                mode_Language = ManagementGui.MODE_EDIT;


                textLanguageID.setEditable(false);

                textLanguageName.setEditable(true);
                textLanguageName.setFocus();
                textLanguageShortname.setEditable(true);
                buttonLanguageCancel.setEnabled(true);
                buttonLanguageSave.setEnabled(true);
                buttonLanguageNew.setEnabled(false);
                buttonLanguageEdit.setEnabled(false);
                buttonLanguageDelete.setEnabled(false);


                tableLanguage.setEnabled(false);
                textLanguageSearch.setEnabled(false);
                

            }
        });

        buttonLanguageDelete = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonLanguageDelete.setText(l.getString("button.delete"));
        buttonLanguageDelete.setEnabled(false);
        buttonLanguageDelete.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                System.out
                        .println("buttonLanguageDelete.widgetSelected, event="
                                + evt);
                
                
               String msg = MessageFormat.format(
                       l.getString("Language.groupdetail.deletebutton.question.text"),
                               new Object[]{textLanguageName.getText()+" "+textLanguageShortname.getText()});
                
               int question = showMsg(msg,
                       l.getString("Language.groupdetail.deletebutton.question.header"), 
                       SWT.ICON_QUESTION | SWT.YES | SWT.NO);
               
               if (question != SWT.YES){
                   return;
               }
                
                Language o = new Language();
                o.setLanguageId(new Integer(Integer.parseInt(textLanguageID.getText())));
                o.setName(textLanguageName.getText());
                o.setShortname(textLanguageShortname.getText());
                
                try {
                    //object speichern
                    // Fehlerbehandlung
                    Database.deleteObject(o);

                    //ÜbersichtsTabelle aktualisieren
                    refreshLanguageTable(textLanguageSearch.getText());
                    
                    //Detailansicht leeren
                    textLanguageID.setText("");
                    textLanguageName.setText("");
                    textLanguageShortname.setText("");
                    
                    //in Tabelle nächsten auswählen
                    try {
                        tableLanguage.select(0);
                    } catch (Exception ex) {}
                    
                    //Statusline Nachricht sezten
                    statusLine.setStatus(1,l.getString("Language.groupdetail.deletebutton.newok"));

                } catch (DataBaseException e) {
                    if (e.getMessage().equalsIgnoreCase("1")) {
                        //Fehler beim Speichern des Objectes

                        statusLine.setStatus(3,l.getString("Language.groupdetail.deletebutton.errorsave"));
                        showMsg(l.getString("Language.groupdetail.deletebutton.errorsave"),
                                l.getString("error"), SWT.ICON_ERROR | SWT.OK);
                        
                    } else if (e.getMessage().equalsIgnoreCase("2")) {
                        //fehler beim db aufbau
                        statusLine.setStatus(3,l.getString("Language.groupdetail.deletebutton.errordb"));
                        showMsg(l.getString("Language.groupdetail.deletebutton.errordb"),
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
        buttonLanguageFill = new Button(composite2, SWT.PUSH | SWT.CENTER);
        GridData buttonLanguageFillLData = new GridData();
        buttonLanguageFill.setVisible(false);
        buttonLanguageFill.setEnabled(false);
        buttonLanguageFillLData.widthHint = 30;
        buttonLanguageFillLData.heightHint = 23;
        buttonLanguageFill.setLayoutData(buttonLanguageFillLData);

        buttonLanguageSave = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonLanguageSave.setText(l.getString("button.save"));
        buttonLanguageSave.setEnabled(false);
        buttonLanguageSave.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                System.out
                        .println("buttonLanguageSave.widgetSelected, event="
                                + evt);

                
                //testen ob Name leer ist
                if (textLanguageName.getText().trim().equalsIgnoreCase("")) {
                    
                    showMsg(l.getString("Language.groupdetail.savebutton.warn.noname.msg"),
                            l.getString("Language.groupdetail.savebutton.warn.noname.title"),
                            SWT.ICON_WARNING | SWT.YES);

                    	return;
                }
                
                //testen welcher mode
                
                if (mode_Language == ManagementGui.MODE_ADD) {
                    
                    /**
                     * @todo eine Exception bekommen wieder leider NOCH nicht mit
                     * d.h. es muss noch ein rückgabewert kommen oder eine Exception 
                     * übermitteln werden (aus der DB Klasse)
                     */
                    //neues Objekt erzeugen
                    Language tmp = new Language(textLanguageName.getText(),
                            textLanguageShortname.getText());
                    
                    try {
                        //object speichern
                        // Fehlerbehandlung
                        Object o = Database.saveObject(
                                new Language(textLanguageName.getText(),
                                        textLanguageShortname.getText()));
                        
                        // in Übersichtstabelle einfügen
                        insertIntoLanguageTable((Language)o);
                        textLanguageID.setText( ((Language)o).getLanguageId()+"" );
                        
                        
                        //Statusline Nachricht sezten
                        statusLine.setStatus(1,l.getString("Language.groupdetail.savebutton.newok"));

                    } catch (DataBaseException e) {
                        if (e.getMessage().equalsIgnoreCase("1")) {
                            //Fehler beim Speichern des Objectes

                            statusLine.setStatus(3,l.getString("Language.groupdetail.savebutton.errorsave"));
                            showMsg(l.getString("Language.groupdetail.savebutton.errorsave"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                            
                        } else if (e.getMessage().equalsIgnoreCase("2")) {
                            //fehler beim db aufbau
                            statusLine.setStatus(3,l.getString("Language.groupdetail.savebutton.errordb"));
                            showMsg(l.getString("Language.groupdetail.savebutton.errordb"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                            
                        } else {
                            //@todo
                            e.printStackTrace();
                        }
                        
                    }
                    
                    
                    //alle Buttons auf aktiv setzen
                    setLanguageGroupButtonSaveCancel();
                    
                } else if (mode_Language == ManagementGui.MODE_EDIT) {
                    
                    Language tmp = new Language(textLanguageName.getText(),
                                    textLanguageShortname.getText());
        		tmp.setLanguageId( new Integer (Integer.parseInt(textLanguageID.getText())) );
                try {
                    //object speichern
                    // Fehlerbehandlung
                    Database.saveObject(tmp);
                    //Übersichtstabelle aktualisieren
                    refreshLanguageTable(textLanguageSearch.getText());
                    
                    //Statusline Nachricht sezten
                    statusLine.setStatus(1,l.getString("Language.groupdetail.savebutton.editok"));
                   

                } catch (DataBaseException e) {
                    if (e.getMessage().equalsIgnoreCase("1")) {
                        //Fehler beim Speichern des Objectes

                        statusLine.setStatus(3,l.getString("Language.groupdetail.savebutton.errorsave"));
                        showMsg(l.getString("Language.groupdetail.savebutton.errorsave"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                        
                    } else if (e.getMessage().equalsIgnoreCase("2")) {
                        //fehler beim db aufbau
                        statusLine.setStatus(3,l.getString("Language.groupdetail.savebutton.errordb"));
                        showMsg(l.getString("Language.groupdetail.savebutton.errordb"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                        
                    } else {
                        //@todo
                        e.printStackTrace();
                    }
                    
                }
                    
 
                    //alle Buttons auf aktiv setzen
                    setLanguageGroupButtonSaveCancel();
                    
                }
                
                
                
                /**
                 * @todo Exception werfen, da nur die zwei Modes sein dürfen
                 */
                
            }
        });

        buttonLanguageCancel = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonLanguageCancel.setText(l.getString("button.cancel"));
        buttonLanguageCancel.setEnabled(false);
        buttonLanguageCancel.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                System.out
                        .println("buttonLanguageCancel.widgetSelected, event="
                                + evt);
                setLanguageGroupButtonSaveCancel();
            }
        });

        
    }

    /**
     * 
     */
    protected void setLanguageGroupButtonSaveCancel() {
        buttonLanguageSave.setEnabled(false);
        buttonLanguageCancel.setEnabled(false);
        buttonLanguageEdit.setEnabled(true);
        buttonLanguageNew.setEnabled(true);
        buttonLanguageDelete.setEnabled(true);
        textLanguageName.setEditable(false);
        textLanguageShortname.setEditable(false);
        textLanguageSearch.setEditable(true);

        // LanguageTabelle aktivieren
        tableLanguage.setEnabled(true);

        //LanguageSearch aktivieren
        textLanguageSearch.setEnabled(true);
        
    }

    /**
     * @param Language
     */
    protected void insertIntoLanguageTable(Language Language) {
        TableItem item = new TableItem(tableLanguage, SWT.NONE);
        item.setText(new String[] { Language.getLanguageId() + "", Language.getName(),
                Language.getShortname() });
        
    }

    /**
     * @param text
     */
    protected void refreshLanguageTable(final String filter) {
        if (tableLanguage == null) {
            System.out
                    .println("Konnte Languagetable nicht refreshen, da diese null ist!");
            return;
        }
        System.out.println("Versuche nun LanguageListe zu refreshen. Filter: "
                + filter);
        tableLanguage.removeAll();
        TableItem item;
        java.util.List Languagelist = Database.getLanguage(filter);

        for (int i = 0; i < Languagelist.size(); i++) {

            Language o = (Language) Languagelist.get(i);
            item = new TableItem(tableLanguage, SWT.NONE);
            item.setText(new String[] { o.getLanguageId() + "", o.getName(),
                    o.getShortname() });

        }

        
    }

    /**
     * 
     */
    private void initLanguageGroupOverview() {
        if (logger.isDebugEnabled()) {
            logger.debug("initLanguageGroupOverview() - start");
        }

        groupLanguageOverview = new Group(sashFormLanguage, SWT.NONE);
        GridLayout group5Layout = new GridLayout();
        group5Layout.numColumns = 8;
        groupLanguageOverview.setText(l
                .getString("Language.groupoverview.label"));
        FormData group5LData = new FormData();
        groupLanguageOverview.setLayout(group5Layout);
        group5LData.left = new FormAttachment(0, 100, 0);
        group5LData.top = new FormAttachment(0, 100, 0);
        groupLanguageOverview.setLayoutData(group5LData);

        //Tabelle anzeigen
        initTableLanguage();
        //Suche darunter anzeigen
        initLanguageSearch();

        if (logger.isDebugEnabled()) {
            logger.debug("initLanguageGroupOverview() - end");
        }
        
    }

    /**
     * 
     */
    private void initLanguageSearch() {
        if (logger.isDebugEnabled()) {
            logger.debug("initLanguageSearch() - start");
        }

        //label für die Suche
        labelLanguageSearch = new Label(groupLanguageOverview, SWT.NONE);
        labelLanguageSearch.setText(l
                .getString("Language.groupoverview.searchlabel")
                + ":");
        GridData label2LData = new GridData();
        label2LData.horizontalSpan = 3;
        labelLanguageSearch.setLayoutData(label2LData);

        //das Suchfeld
        textLanguageSearch = new Text(groupLanguageOverview, SWT.BORDER);
        GridData text2LData = new GridData();
        textLanguageSearch.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                if (logger.isDebugEnabled()) {
                    logger.debug("focusLost(FocusEvent evt = " + evt + " "
                            + textLanguageSearch.getText() + ") - start");
                }

                refreshLanguageTable(textLanguageSearch.getText());

                if (logger.isDebugEnabled()) {
                    logger.debug("focusLost(FocusEvent) - end");
                }
            }
        });

        textLanguageSearch.addListener(SWT.DefaultSelection, new Listener() {
            public void handleEvent(Event e) {
                if (logger.isDebugEnabled()) {
                    logger.debug("handleEvent(Event e = " + e + " "
                            + textLanguageSearch.getText() + ") - start");
                }

                refreshLanguageTable(textLanguageSearch.getText());

                if (logger.isDebugEnabled()) {
                    logger.debug("handleEvent(Event) - end");
                }
            }
        });

        text2LData.horizontalAlignment = GridData.FILL;
        text2LData.horizontalSpan = 5;
        text2LData.grabExcessHorizontalSpace = true;
        textLanguageSearch.setLayoutData(text2LData);



        if (logger.isDebugEnabled()) {
            logger.debug("initLanguageSearch() - end");
        }
        
    }

    /**
     * 
     */
    private void initTableLanguage() {
        if (logger.isDebugEnabled()) {
            logger.debug("initTableLanguage() - start");
        }

        tableLanguage = new Table(groupLanguageOverview, SWT.SINGLE
                | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.BORDER);
        tableLanguage.setHeaderVisible(true);
        tableLanguage.setLinesVisible(true);
        GridData table2LData = new GridData();
        tableLanguage.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                System.out.println("tableLanguage.focusLost, event=" + evt);
                //TODO add your code for tableLanguage.focusLost
            }
            public void focusGained(FocusEvent evt) {
                System.out
                    .println("tableLanguage.focusGained, event=" + evt);
                //TODO add your code for tableLanguage.focusGained
            }
        });
        tableLanguage.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                if (logger.isDebugEnabled()) {
                    logger.debug("widgetSelected(SelectionEvent evt = "
                        + evt
                        + ") - start");
                }

                int index = tableLanguage.getSelectionIndex();

                System.out.println("Table select. id: "
                    + index
                    + " TableItem:"
                    + tableLanguage.getItem(index)
                    + " id: "
                    + tableLanguage.getItem(index).getText(0));

                //es wurde ein Element aus Tabelle ausgewaehlt jetzt muss die
                //Detailansicht aktualisiert werden
                refreshLanguageDetail(tableLanguage.getItem(index)
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
        tableLanguage.setLayoutData(table2LData);

        //einzelne Spalten hinzufügen
        tableColumn = new TableColumn(tableLanguage, SWT.CENTER);
        tableColumn.setText(l.getString("Language.groupoverview.columnid"));
        tableColumn.setWidth(50);

        tableColumn = new TableColumn(tableLanguage, SWT.CENTER);
        tableColumn.setText(l.getString("Language.groupoverview.columnname"));
        tableColumn.setWidth(200);

        tableColumn = new TableColumn(tableLanguage, SWT.CENTER);
        tableColumn.setText(l.getString("Language.groupoverview.columnshortname"));
        tableColumn.setWidth(75);

        if (logger.isDebugEnabled()) {
            logger.debug("initTableLanguage() - end");
        }
        
    }

    /**
     * @param text
     */
    protected void refreshLanguageDetail(final String id) {
        Language object;
        try {
            //since we only can get a String value from the table, we
            //need to convert this
            object = Database.getSingleLanguage(Integer.parseInt(id));

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

        textLanguageID.setText(object.getLanguageId() + "");
        textLanguageName.setText(object.getName());
        textLanguageShortname.setText(object.getShortname());

        //Buttons zum löschen und editieren aktivieren
        buttonLanguageEdit.setEnabled(true);
        buttonLanguageDelete.setEnabled(true);

        //Mode auf view setzen
        mode_Language = ManagementGui.MODE_VIEW;
        
    }

	

}

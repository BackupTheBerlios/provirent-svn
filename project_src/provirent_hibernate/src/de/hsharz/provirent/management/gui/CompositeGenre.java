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
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.cloudgarden.resource.SWTResourceManager;

import de.hsharz.provirent.objects.Genre;
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
public class CompositeGenre extends AbstractComposite{

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }


    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(CompositeGenre.class);
    
    
    private final static int MODE_VIEW = 0;

    private final static int MODE_ADD = 1;
    
    private SashForm sashForm1;

    private Group groupGenreOverview;

    private Group groupGenreDetail;

    private Label labelGenreId;

    private Label labelGenreShortname;

    private Text textGenreName;

    private Label labelGenreName;

    private Text textGenreID;
    
    private Button buttonGenreCancel;

    private Button buttonGenreSave;

    private Button buttonGenreFill;

    private Button buttonGenreDelete;

    private Button buttonGenreEdit;

    private Button buttonGenreNew;

    private Text textGenreShortname;

    private Text textGenreSearch;

    private Label labelGenreSearch;

    private Table tableGenre;

    private SashForm sashFormGenre;

    private Group groupGenre;

    private final static int MODE_EDIT = 2;
    
    private StatusLineStyledText statusLine;

    private ResourceBundle l;
    
    private Composite parent;


    private Composite composite2;


    protected int mode_Genre;


    private TableColumn tableColumn;
    
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
                "de.hsharz.provirent.managment.gui.language.genre", locale);

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

	public CompositeGenre(Composite p, int style,
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

            initGenreGroup();

        }
        this.layout();

        if (logger.isDebugEnabled()) {
            logger.debug("initGUI() - end");
        }
    } 
	
	/**
     * 
     */
    private void initGenreGroup() {
        {
            //init a group for the Genre
            groupGenre = new Group(sashForm1, SWT.NONE);
            GridLayout group2Layout = new GridLayout();
            group2Layout.makeColumnsEqualWidth = true;
            groupGenre.setText(l.getString("Genre.group.label"));
            groupGenre.setSize(758, 284);
            FormData group2LData = new FormData();
            groupGenre.addFocusListener(new FocusAdapter() {
                public void focusLost(FocusEvent evt) {
                    System.out.println("groupGenre.focusLost, event="
                        + evt);
                    buttonGenreCancel.setEnabled(false);
                    buttonGenreDelete.setEnabled(false);
                    buttonGenreEdit.setEnabled(false);
                    buttonGenreNew.setEnabled(false);
                    buttonGenreSave.setEnabled(false);
                    //TODO add your code for groupGenre.focusLost
                }
            });
            groupGenre.setLayout(group2Layout);
            groupGenre.setLayoutData(group2LData);
            {
                sashFormGenre = new SashForm(groupGenre, SWT.NONE);
                FormLayout sashForm2Layout = new FormLayout();
                sashFormGenre.setSize(748, 300);
                GridData sashForm2LData = new GridData();
                sashFormGenre.setLayout(sashForm2Layout);
                sashForm2LData.verticalAlignment = GridData.FILL;
                sashForm2LData.horizontalAlignment = GridData.FILL;
                sashForm2LData.grabExcessHorizontalSpace = true;
                sashForm2LData.grabExcessVerticalSpace = true;
                sashFormGenre.setLayoutData(sashForm2LData);

                //init die Gruppe für Genree Überblick
                initGenreGroupOverview();
                //init die Detailansicht
                initGenreGroupDetail();

            }
        }

	}

    /**
     * 
     */
    private void initGenreGroupDetail() {
        groupGenreDetail = new Group(sashFormGenre, SWT.NONE);
        GridLayout groupGenreDetailLayout = new GridLayout();
        groupGenreDetailLayout.marginHeight = 25;
        groupGenreDetailLayout.numColumns = 6;
        groupGenreDetailLayout.verticalSpacing = 15;
        groupGenreDetail.setText(l
                .getString("Genre.groupdetail.label"));
        FormData formData = new FormData();
        groupGenreDetail.setLayout(groupGenreDetailLayout);
        formData.right = new FormAttachment(100, 100, -5);
        formData.top = new FormAttachment(0, 100, 5);
        formData.bottom = new FormAttachment(100, 100, -5);
        groupGenreDetail.setLayoutData(formData);
        {
            labelGenreId = new Label(groupGenreDetail, SWT.NONE);
            labelGenreId.setText(l
                    .getString("Genre.groupdetail.idlabel")
                    + ":");
            labelGenreId.setSize(125, 15);
            GridData formData2 = new GridData();
            formData2.widthHint = 125;
            formData2.heightHint = 15;
            formData2.horizontalSpan = 2;
            labelGenreId.setLayoutData(formData2);
        }
        {
            textGenreID = new Text(groupGenreDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData1 = new GridData();
            text1LData1.horizontalAlignment = GridData.FILL;
            text1LData1.heightHint = 13;
            text1LData1.horizontalSpan = 4;
            text1LData1.grabExcessHorizontalSpace = true;
            textGenreID.setLayoutData(text1LData1);
        }
        {
            labelGenreName = new Label(groupGenreDetail, SWT.NONE);
            labelGenreName.setText(l
                    .getString("Genre.groupdetail.namelabel")
                    + ":");
            labelGenreName.setSize(125, 15);
            GridData labelGenreNameLData = new GridData();
            labelGenreNameLData.widthHint = 125;
            labelGenreNameLData.heightHint = 15;
            labelGenreNameLData.horizontalSpan = 2;
            labelGenreName.setLayoutData(labelGenreNameLData);
        }
        {
            textGenreName = new Text(groupGenreDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData2 = new GridData();
            text1LData2.horizontalAlignment = GridData.FILL;
            text1LData2.heightHint = 13;
            text1LData2.horizontalSpan = 4;
            text1LData2.grabExcessHorizontalSpace = true;
            textGenreName.setLayoutData(text1LData2);
        }
        {
            labelGenreShortname = new Label(groupGenreDetail,
                    SWT.NONE);
            labelGenreShortname.setText(l
                    .getString("Genre.groupdetail.shortcutlabel")
                    + ":");
            labelGenreShortname.setSize(125, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 125;
            label1LData1.heightHint = 15;
            label1LData1.horizontalSpan = 2;
            labelGenreShortname.setLayoutData(label1LData1);
        }
        {
            textGenreShortname = new Text(groupGenreDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 4;
            text1LData3.grabExcessHorizontalSpace = true;
            textGenreShortname.setLayoutData(text1LData3);
        }
        {

            //die Buttons bekommen ein eigenes Composite
            composite2 = new Composite(groupGenreDetail, SWT.EMBEDDED);
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
            initGenreDetailButtons();

        }

        
    }

    /**
     * 
     */
    private void initGenreDetailButtons() {
        buttonGenreNew = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonGenreNew.setText(l.getString("button.new"));
        buttonGenreNew.addSelectionListener(new SelectionAdapter() {
            

            public void widgetSelected(SelectionEvent evt) {

                textGenreID.setText("");
                textGenreName.setText("");
                textGenreShortname.setText("");
                

                textGenreName.setEditable(true);
                textGenreShortname.setEditable(true);
                buttonGenreCancel.setEnabled(true);
                buttonGenreSave.setEnabled(true);
                buttonGenreNew.setEnabled(false);
                buttonGenreEdit.setEnabled(false);
                buttonGenreDelete.setEnabled(false);
                
                textGenreSearch.setEditable(false);
                tableGenre.setEnabled(false);

                mode_Genre = ManagementGui.MODE_ADD;

            }
        });

        buttonGenreEdit = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonGenreEdit.setText(l.getString("button.edit"));
        buttonGenreEdit.setEnabled(false);
        buttonGenreEdit.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {

                mode_Genre = ManagementGui.MODE_EDIT;


                textGenreID.setEditable(false);

                textGenreName.setEditable(true);
                textGenreName.setFocus();
                textGenreShortname.setEditable(true);
                buttonGenreCancel.setEnabled(true);
                buttonGenreSave.setEnabled(true);
                buttonGenreNew.setEnabled(false);
                buttonGenreEdit.setEnabled(false);
                buttonGenreDelete.setEnabled(false);


                tableGenre.setEnabled(false);
                textGenreSearch.setEnabled(false);
                

            }
        });

        buttonGenreDelete = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonGenreDelete.setText(l.getString("button.delete"));
        buttonGenreDelete.setEnabled(false);
        buttonGenreDelete.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                System.out
                        .println("buttonGenreDelete.widgetSelected, event="
                                + evt);
                
                
               String msg = MessageFormat.format(
                       l.getString("Genre.groupdetail.deletebutton.question.text"),
                               new Object[]{textGenreName.getText()+" "+textGenreShortname.getText()});
                
               int question = showMsg(msg,
                       l.getString("Genre.groupdetail.deletebutton.question.header"), 
                       SWT.ICON_QUESTION | SWT.YES | SWT.NO);
               
               if (question != SWT.YES){
                   return;
               }
                
                Genre o = new Genre();
                o.setGenreId(new Integer(Integer.parseInt(textGenreID.getText())));
                o.setName(textGenreName.getText());
                o.setShortname(textGenreShortname.getText());
                
                try {
                    //object speichern
                    // Fehlerbehandlung
                    Database.deleteObject(o);

                    //ÜbersichtsTabelle aktualisieren
                    refreshGenreTable(textGenreSearch.getText());
                    
                    //Detailansicht leeren
                    textGenreID.setText("");
                    textGenreName.setText("");
                    textGenreShortname.setText("");
                    
                    //in Tabelle nächsten auswählen
                    try {
                        tableGenre.select(0);
                    } catch (Exception ex) {}
                    
                    //Statusline Nachricht sezten
                    statusLine.setStatus(1,l.getString("Genre.groupdetail.deletebutton.newok"));

                } catch (DataBaseException e) {
                    if (e.getMessage().equalsIgnoreCase("1")) {
                        //Fehler beim Speichern des Objectes

                        statusLine.setStatus(3,l.getString("Genre.groupdetail.deletebutton.errorsave"));
                        showMsg(l.getString("Genre.groupdetail.deletebutton.errorsave"),
                                l.getString("error"), SWT.ICON_ERROR | SWT.OK);
                        
                    } else if (e.getMessage().equalsIgnoreCase("2")) {
                        //fehler beim db aufbau
                        statusLine.setStatus(3,l.getString("Genre.groupdetail.deletebutton.errordb"));
                        showMsg(l.getString("Genre.groupdetail.deletebutton.errordb"),
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
        buttonGenreFill = new Button(composite2, SWT.PUSH | SWT.CENTER);
        GridData buttonGenreFillLData = new GridData();
        buttonGenreFill.setVisible(false);
        buttonGenreFill.setEnabled(false);
        buttonGenreFillLData.widthHint = 30;
        buttonGenreFillLData.heightHint = 23;
        buttonGenreFill.setLayoutData(buttonGenreFillLData);

        buttonGenreSave = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonGenreSave.setText(l.getString("button.save"));
        buttonGenreSave.setEnabled(false);
        buttonGenreSave.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                System.out
                        .println("buttonGenreSave.widgetSelected, event="
                                + evt);

                
                //testen ob Name leer ist
                if (textGenreName.getText().trim().equalsIgnoreCase("")) {
                    
                    showMsg(l.getString("Genre.groupdetail.savebutton.warn.noname.msg"),
                            l.getString("Genre.groupdetail.savebutton.warn.noname.title"),
                            SWT.ICON_WARNING | SWT.YES);

                    	return;
                }
                
                //testen welcher mode
                
                if (mode_Genre == ManagementGui.MODE_ADD) {
                    
                    /**
                     * @todo eine Exception bekommen wieder leider NOCH nicht mit
                     * d.h. es muss noch ein rückgabewert kommen oder eine Exception 
                     * übermitteln werden (aus der DB Klasse)
                     */
                    //neues Objekt erzeugen
                    Genre tmp = new Genre(textGenreName.getText(),
                            textGenreShortname.getText());
                    
                    try {
                        //object speichern
                        // Fehlerbehandlung
                        Object o = Database.saveObject(
                                new Genre(textGenreName.getText(),
                                        textGenreShortname.getText()));
                        
                        // in Übersichtstabelle einfügen
                        insertIntoGenreTable((Genre)o);
                        textGenreID.setText( ((Genre)o).getGenreId()+"" );
                        
                        
                        //Statusline Nachricht sezten
                        statusLine.setStatus(1,l.getString("Genre.groupdetail.savebutton.newok"));

                    } catch (DataBaseException e) {
                        if (e.getMessage().equalsIgnoreCase("1")) {
                            //Fehler beim Speichern des Objectes

                            statusLine.setStatus(3,l.getString("Genre.groupdetail.savebutton.errorsave"));
                            showMsg(l.getString("Genre.groupdetail.savebutton.errorsave"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                            
                        } else if (e.getMessage().equalsIgnoreCase("2")) {
                            //fehler beim db aufbau
                            statusLine.setStatus(3,l.getString("Genre.groupdetail.savebutton.errordb"));
                            showMsg(l.getString("Genre.groupdetail.savebutton.errordb"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                            
                        } else {
                            //@todo
                            e.printStackTrace();
                        }
                        
                    }
                    
                    
                    //alle Buttons auf aktiv setzen
                    setGenreGroupButtonSaveCancel();
                    
                } else if (mode_Genre == ManagementGui.MODE_EDIT) {
                    
                    Genre tmp = new Genre(textGenreName.getText(),
                                    textGenreShortname.getText());
        		tmp.setGenreId( new Integer (Integer.parseInt(textGenreID.getText())) );
                try {
                    //object speichern
                    // Fehlerbehandlung
                    Database.saveObject(tmp);
                    //Übersichtstabelle aktualisieren
                    refreshGenreTable(textGenreSearch.getText());
                    
                    //Statusline Nachricht sezten
                    statusLine.setStatus(1,l.getString("Genre.groupdetail.savebutton.editok"));
                   

                } catch (DataBaseException e) {
                    if (e.getMessage().equalsIgnoreCase("1")) {
                        //Fehler beim Speichern des Objectes

                        statusLine.setStatus(3,l.getString("Genre.groupdetail.savebutton.errorsave"));
                        showMsg(l.getString("Genre.groupdetail.savebutton.errorsave"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                        
                    } else if (e.getMessage().equalsIgnoreCase("2")) {
                        //fehler beim db aufbau
                        statusLine.setStatus(3,l.getString("Genre.groupdetail.savebutton.errordb"));
                        showMsg(l.getString("Genre.groupdetail.savebutton.errordb"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                        
                    } else {
                        //@todo
                        e.printStackTrace();
                    }
                    
                }
                    
 
                    //alle Buttons auf aktiv setzen
                    setGenreGroupButtonSaveCancel();
                    
                }
                
                
                
                /**
                 * @todo Exception werfen, da nur die zwei Modes sein dürfen
                 */
                
            }
        });

        buttonGenreCancel = new Button(composite2, SWT.PUSH | SWT.CENTER);
        buttonGenreCancel.setText(l.getString("button.cancel"));
        buttonGenreCancel.setEnabled(false);
        buttonGenreCancel.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                System.out
                        .println("buttonGenreCancel.widgetSelected, event="
                                + evt);
                setGenreGroupButtonSaveCancel();
            }
        });

        
    }

    /**
     * 
     */
    protected void setGenreGroupButtonSaveCancel() {
        buttonGenreSave.setEnabled(false);
        buttonGenreCancel.setEnabled(false);
        buttonGenreEdit.setEnabled(true);
        buttonGenreNew.setEnabled(true);
        buttonGenreDelete.setEnabled(true);
        textGenreName.setEditable(false);
        textGenreShortname.setEditable(false);
        textGenreSearch.setEditable(true);

        // GenreTabelle aktivieren
        tableGenre.setEnabled(true);

        //GenreSearch aktivieren
        textGenreSearch.setEnabled(true);
        
    }

    /**
     * @param genre
     */
    protected void insertIntoGenreTable(Genre genre) {
        TableItem item = new TableItem(tableGenre, SWT.NONE);
        item.setText(new String[] { genre.getGenreId() + "", genre.getName(),
                genre.getShortname() });
        
    }

    /**
     * @param text
     */
    protected void refreshGenreTable(final String filter) {
        if (tableGenre == null) {
            System.out
                    .println("Konnte Genretable nicht refreshen, da diese null ist!");
            return;
        }
        System.out.println("Versuche nun VideoListe zu refreshen. Filter: "
                + filter);
        tableGenre.removeAll();
        TableItem item;
        java.util.List Genrelist = Database.getGenre(filter);

        for (int i = 0; i < Genrelist.size(); i++) {

            Genre o = (Genre) Genrelist.get(i);
            item = new TableItem(tableGenre, SWT.NONE);
            item.setText(new String[] { o.getGenreId() + "", o.getName(),
                    o.getShortname() });

        }

        
    }

    /**
     * 
     */
    private void initGenreGroupOverview() {
        if (logger.isDebugEnabled()) {
            logger.debug("initGenreGroupOverview() - start");
        }

        groupGenreOverview = new Group(sashFormGenre, SWT.NONE);
        GridLayout group5Layout = new GridLayout();
        group5Layout.numColumns = 8;
        groupGenreOverview.setText(l
                .getString("Genre.groupoverview.label"));
        FormData group5LData = new FormData();
        groupGenreOverview.setLayout(group5Layout);
        group5LData.left = new FormAttachment(0, 100, 0);
        group5LData.top = new FormAttachment(0, 100, 0);
        groupGenreOverview.setLayoutData(group5LData);

        //Tabelle anzeigen
        initTableGenre();
        //Suche darunter anzeigen
        initGenreSearch();

        if (logger.isDebugEnabled()) {
            logger.debug("initGenreGroupOverview() - end");
        }
        
    }

    /**
     * 
     */
    private void initGenreSearch() {
        if (logger.isDebugEnabled()) {
            logger.debug("initGenreSearch() - start");
        }

        //label für die Suche
        labelGenreSearch = new Label(groupGenreOverview, SWT.NONE);
        labelGenreSearch.setText(l
                .getString("Genre.groupoverview.searchlabel")
                + ":");
        GridData label2LData = new GridData();
        label2LData.horizontalSpan = 3;
        labelGenreSearch.setLayoutData(label2LData);

        //das Suchfeld
        textGenreSearch = new Text(groupGenreOverview, SWT.BORDER);
        GridData text2LData = new GridData();
        textGenreSearch.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                if (logger.isDebugEnabled()) {
                    logger.debug("focusLost(FocusEvent evt = " + evt + " "
                            + textGenreSearch.getText() + ") - start");
                }

                refreshGenreTable(textGenreSearch.getText());

                if (logger.isDebugEnabled()) {
                    logger.debug("focusLost(FocusEvent) - end");
                }
            }
        });

        textGenreSearch.addListener(SWT.DefaultSelection, new Listener() {
            public void handleEvent(Event e) {
                if (logger.isDebugEnabled()) {
                    logger.debug("handleEvent(Event e = " + e + " "
                            + textGenreSearch.getText() + ") - start");
                }

                refreshGenreTable(textGenreSearch.getText());

                if (logger.isDebugEnabled()) {
                    logger.debug("handleEvent(Event) - end");
                }
            }
        });

        text2LData.horizontalAlignment = GridData.FILL;
        text2LData.horizontalSpan = 5;
        text2LData.grabExcessHorizontalSpace = true;
        textGenreSearch.setLayoutData(text2LData);



        if (logger.isDebugEnabled()) {
            logger.debug("initGenreSearch() - end");
        }
        
    }

    /**
     * 
     */
    private void initTableGenre() {
        if (logger.isDebugEnabled()) {
            logger.debug("initTableGenre() - start");
        }

        tableGenre = new Table(groupGenreOverview, SWT.SINGLE
                | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.BORDER);
        tableGenre.setHeaderVisible(true);
        tableGenre.setLinesVisible(true);
        GridData table2LData = new GridData();
        tableGenre.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                System.out.println("tableGenre.focusLost, event=" + evt);
                //TODO add your code for tableGenre.focusLost
            }
            public void focusGained(FocusEvent evt) {
                System.out
                    .println("tableGenre.focusGained, event=" + evt);
                //TODO add your code for tableGenre.focusGained
            }
        });
        tableGenre.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                if (logger.isDebugEnabled()) {
                    logger.debug("widgetSelected(SelectionEvent evt = "
                        + evt
                        + ") - start");
                }

                int index = tableGenre.getSelectionIndex();

                System.out.println("Table select. id: "
                    + index
                    + " TableItem:"
                    + tableGenre.getItem(index)
                    + " id: "
                    + tableGenre.getItem(index).getText(0));

                //es wurde ein Element aus Tabelle ausgewaehlt jetzt muss die
                //Detailansicht aktualisiert werden
                refreshGenreDetail(tableGenre.getItem(index)
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
        tableGenre.setLayoutData(table2LData);

        //einzelne Spalten hinzufügen
        tableColumn = new TableColumn(tableGenre, SWT.CENTER);
        tableColumn.setText(l.getString("Genre.groupoverview.columnid"));
        tableColumn.setWidth(50);

        tableColumn = new TableColumn(tableGenre, SWT.CENTER);
        tableColumn.setText(l.getString("Genre.groupoverview.columnname"));
        tableColumn.setWidth(200);

        tableColumn = new TableColumn(tableGenre, SWT.CENTER);
        tableColumn.setText(l.getString("Genre.groupoverview.columnshortname"));
        tableColumn.setWidth(75);

        if (logger.isDebugEnabled()) {
            logger.debug("initTableGenre() - end");
        }
        
    }

    /**
     * @param text
     */
    protected void refreshGenreDetail(final String id) {
        Genre object;
        try {
            //since we only can get a String value from the table, we
            //need to convert this
            object = Database.getSingleGenre(Integer.parseInt(id));

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

        textGenreID.setText(object.getGenreId() + "");
        textGenreName.setText(object.getName());
        textGenreShortname.setText(object.getShortname());

        //Buttons zum löschen und editieren aktivieren
        buttonGenreEdit.setEnabled(true);
        buttonGenreDelete.setEnabled(true);

        //Mode auf view setzen
        mode_Genre = ManagementGui.MODE_VIEW;
        
    }

	

}

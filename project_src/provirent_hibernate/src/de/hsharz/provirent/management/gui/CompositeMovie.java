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

import de.hsharz.provirent.objects.Movie;
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
public class CompositeMovie extends de.hsharz.provirent.management.gui.AbstractComposite {

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
    
    private Table tableMoviesOverview;
    private Table tableMoviesOverviewDetail;
    private TableColumn tableMoviesOverview_ColumnID;
    private TableColumn tableMoviesOverview_ColumnTitle;
    private TableColumn tableMoviesOverview_ColumnSubtitles;
    private TableColumn tableMoviesOverview_ColumnDate;
    private TableColumn tableMoviesOverviewDetail_ColumnGenres;
    private TableColumn tableMoviesOverviewDetail_ColumnActors;
    private TableColumn tableMoviesOverviewDetail_ColumnVideoformats;
    private TableColumn tableMoviesOverviewDetail_ColumnAudioformats;
    private TableColumn tableMoviesOverviewDetail_ColumnLanguages;   
    private TableColumn tableMoviesOverviewDetail_ColumnDescription;
    private TableColumn tableMoviesOverviewDetail_ColumnImages;
    
    
    
    private Group groupMovie;
    private Group groupMoviesOverview;
    private Group groupMoviesDetail;
    
    private Text textMoviesSearch;
    private Text textMoviesID;
    private Text textMoviesTitle;
    
    private Label labelMoviesSearch;
    private Label labelMoviesID;
    private Label labelMoviesTitle;
    
    private Button buttonMoviesNew;
    private Button buttonMoviesSave;
    private Button buttonMoviesEdit;
    private Button buttonMoviesCancel;
    private Button buttonMoviesDelete;
    private Button buttonMoviesFill;
    
    private SashForm sashForm1;
    
    private Composite parent;
    
    protected int mode_actor;
    
    private StatusLineStyledText statusLine;
    
    private ResourceBundle l;
    
    /*
     * �ndert die Sprache aller Elemente
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
                "de.hsharz.provirent.management.gui.language.movies", locale);

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

	public CompositeMovie(Composite p, int style,
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
            groupMovie = new Group(this, SWT.NONE);
            GridLayout groupMovieLayout = new GridLayout();
            GridData groupMovieLData = new GridData();
            groupMovieLData.grabExcessHorizontalSpace = true;
            groupMovieLData.grabExcessVerticalSpace = true;
            groupMovieLData.horizontalAlignment = GridData.FILL;
            groupMovieLData.verticalAlignment = GridData.FILL;
            groupMovie.setLayoutData(groupMovieLData);
            groupMovieLayout.makeColumnsEqualWidth = true;
            groupMovie.setLayout(groupMovieLayout);
            groupMovie.setText(l.getString("movies.group.label"));
            {
                sashForm1 = new SashForm(groupMovie, SWT.NONE);
                GridData sashForm1LData = new GridData();
                sashForm1LData.verticalAlignment = GridData.FILL;
                sashForm1LData.horizontalAlignment = GridData.FILL;
                sashForm1LData.grabExcessHorizontalSpace = true;
                sashForm1LData.grabExcessVerticalSpace = true;
                sashForm1.setLayoutData(sashForm1LData);
                
               
            }
            // init the rest of the layout
            initMoviesOverview();
            initMoviesDetail();
            refreshMoviesOverviewTable(textMoviesSearch.getText());
        }

        this.layout();


        
        if (logger.isDebugEnabled()) {
            logger.debug("initGUI() - end");
        }
	}

    /**
     * 
     */
    private void initMoviesOverview() {
	    //	  Group Movies Overview 
        {
            groupMoviesOverview = new Group(sashForm1,SWT.NONE);
            GridLayout group1Layout = new GridLayout();
            group1Layout.numColumns = 8;
            groupMoviesOverview.setLayout(group1Layout);
            groupMoviesOverview.setText(l.getString("movies.groupoverview.label"));
            
            {// table Actors Overview
                tableMoviesOverview = new Table(
                    groupMoviesOverview,
                    SWT.SINGLE
                        | SWT.FULL_SELECTION
                        | SWT.V_SCROLL | SWT.BORDER);
                GridData tableMoviesOverviewLData = new GridData();
                tableMoviesOverview.setHeaderVisible(true);
                tableMoviesOverview.setLinesVisible(true);
                tableMoviesOverviewLData.horizontalAlignment = GridData.FILL;
                tableMoviesOverviewLData.verticalAlignment = GridData.FILL;
                tableMoviesOverviewLData.horizontalSpan = 8;
                tableMoviesOverviewLData.grabExcessHorizontalSpace = true;
                tableMoviesOverviewLData.grabExcessVerticalSpace = true;
                tableMoviesOverview.setLayoutData(tableMoviesOverviewLData);
                tableMoviesOverview.addFocusListener(new FocusAdapter() {
                        public void focusLost(FocusEvent evt) {
                            System.out
                                .println("tableMoviesOverview.focusLost, event="
                                    + evt);
                        }
                        public void focusGained(FocusEvent evt) {
                            System.out
                                .println("tableMoviesOverview.focusGained, event="
                                    + evt);
                        }
                    });
                tableMoviesOverview.addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {
                            if (logger.isDebugEnabled()) {
                                logger
                                    .debug("widgetSelected(SelectionEvent evt = "
                                        + evt
                                        + ") - start");
                            }

                            int index = tableMoviesOverview
                                .getSelectionIndex();

                            System.out.println("Table select. id: "
                                + index
                                + " TableItem:"
                                + tableMoviesOverview.getItem(index)
                                + " id: "
                                + tableMoviesOverview.getItem(index)
                                    .getText(0));

                            //es wurde ein Element aus Tabelle ausgewaehlt jetzt muss die
                            //Detailansicht aktualisiert werden
                            refreshMoviesDetail(tableMoviesOverview.getItem(index)
                                                              .getText(0));

                            if (logger.isDebugEnabled()) {
                                logger
                                    .debug("widgetSelected(SelectionEvent) - end");
                            }
                        }
                    });
                {
                    tableMoviesOverview_ColumnID = new TableColumn(
                        tableMoviesOverview,
                        SWT.CENTER);
                    tableMoviesOverview_ColumnID.setText(l
                        .getString("movies.groupoverview.columnid"));
                    tableMoviesOverview_ColumnID.setWidth(40);
                }
                {
                    tableMoviesOverview_ColumnTitle = new TableColumn(
                        tableMoviesOverview,
                        SWT.CENTER);
                    tableMoviesOverview_ColumnTitle.setText(l
                        .getString("movies.groupoverview.columntitle"));
                    tableMoviesOverview_ColumnTitle.setWidth(120);
                }
                {
                    tableMoviesOverview_ColumnSubtitles = new TableColumn(
                        tableMoviesOverview,
                        SWT.CENTER);
                    tableMoviesOverview_ColumnSubtitles.setText(l
                        .getString("movies.groupoverview.columnsubtitles"));
                    tableMoviesOverview_ColumnSubtitles.setWidth(120);
                }
                {
                    tableMoviesOverview_ColumnDate = new TableColumn(
                        tableMoviesOverview,
                        SWT.CENTER);
                    tableMoviesOverview_ColumnDate.setText(l
                        .getString("movies.groupoverview.columndate"));
                    tableMoviesOverview_ColumnDate.setWidth(120);
                }
            }// table Movies Overview
            //Table Movies Overview Detail
            tableMoviesOverviewDetail = new Table(
                    groupMoviesOverview,
                    SWT.SINGLE
                        | SWT.FULL_SELECTION
                        | SWT.V_SCROLL | SWT.BORDER);
                GridData tableMoviesOverviewLData = new GridData();
                tableMoviesOverviewDetail.setHeaderVisible(true);
                tableMoviesOverviewDetail.setLinesVisible(true);
                tableMoviesOverviewLData.horizontalAlignment = GridData.FILL;
                tableMoviesOverviewLData.verticalAlignment = GridData.FILL;
                tableMoviesOverviewLData.horizontalSpan = 8;
                tableMoviesOverviewLData.grabExcessHorizontalSpace = true;
                tableMoviesOverviewLData.grabExcessVerticalSpace = true;
                tableMoviesOverviewDetail.setLayoutData(tableMoviesOverviewLData);
                tableMoviesOverviewDetail.addFocusListener(new FocusAdapter() {
                        public void focusLost(FocusEvent evt) {
                            System.out
                                .println("tableMoviesOverviewDetail.focusLost, event="
                                    + evt);
                        }
                        public void focusGained(FocusEvent evt) {
                            System.out
                                .println("tableMoviesOverviewDetail.focusGained, event="
                                    + evt);
                        }
                    });
                tableMoviesOverviewDetail.addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {
                            if (logger.isDebugEnabled()) {
                                logger
                                    .debug("widgetSelected(SelectionEvent evt = "
                                        + evt
                                        + ") - start");
                            }

                            int index = tableMoviesOverview
                                .getSelectionIndex();

                            System.out.println("Table select. id: "
                                + index
                                + " TableItem:"
                                + tableMoviesOverviewDetail.getItem(index)
                                + " id: "
                                + tableMoviesOverviewDetail.getItem(index)
                                    .getText(0));

                            //es wurde ein Element aus Tabelle ausgewaehlt jetzt muss die
                            //Detailansicht aktualisiert werden
                            //folgende Zeile nicht notwendig
                            //refreshMoviesDetail(tableMoviesOverview.getItem(index).getText(0));

                            if (logger.isDebugEnabled()) {
                                logger
                                    .debug("widgetSelected(SelectionEvent) - end");
                            }
                        }
                    });
                {
                    tableMoviesOverviewDetail_ColumnGenres = new TableColumn(
                        tableMoviesOverviewDetail,
                        SWT.CENTER);
                    tableMoviesOverviewDetail_ColumnGenres.setText(l
                        .getString("movies.groupoverviewdetail.columngenres"));
                    tableMoviesOverviewDetail_ColumnGenres.setWidth(80);
                }
                {
                    tableMoviesOverviewDetail_ColumnActors = new TableColumn(
                        tableMoviesOverviewDetail,
                        SWT.CENTER);
                    tableMoviesOverviewDetail_ColumnActors.setText(l
                        .getString("movies.groupoverviewdetail.columnactors"));
                    tableMoviesOverviewDetail_ColumnActors.setWidth(80);
                }
                {
                    tableMoviesOverviewDetail_ColumnVideoformats = new TableColumn(
                        tableMoviesOverviewDetail,
                        SWT.CENTER);
                    tableMoviesOverviewDetail_ColumnVideoformats.setText(l
                        .getString("movies.groupoverviewdetail.columnvideoformats"));
                    tableMoviesOverviewDetail_ColumnVideoformats.setWidth(80);
                }
                {
                    tableMoviesOverviewDetail_ColumnAudioformats = new TableColumn(
                        tableMoviesOverviewDetail,
                        SWT.CENTER);
                    tableMoviesOverviewDetail_ColumnAudioformats.setText(l
                        .getString("movies.groupoverviewdetail.columnaudioformats"));
                    tableMoviesOverviewDetail_ColumnAudioformats.setWidth(80);
                }
                {
                    tableMoviesOverviewDetail_ColumnLanguages = new TableColumn(
                        tableMoviesOverviewDetail,
                        SWT.CENTER);
                    tableMoviesOverviewDetail_ColumnLanguages.setText(l
                        .getString("movies.groupoverviewdetail.columnlanguages"));
                    tableMoviesOverviewDetail_ColumnLanguages.setWidth(80);
                }
                {
                    tableMoviesOverviewDetail_ColumnDescription = new TableColumn(
                        tableMoviesOverviewDetail,
                        SWT.CENTER);
                    tableMoviesOverviewDetail_ColumnDescription.setText(l
                        .getString("movies.groupoverviewdetail.columndescription"));
                    tableMoviesOverviewDetail_ColumnDescription.setWidth(80);
                }
                {
                    tableMoviesOverviewDetail_ColumnImages = new TableColumn(
                        tableMoviesOverviewDetail,
                        SWT.CENTER);
                    tableMoviesOverviewDetail_ColumnImages.setText(l
                        .getString("movies.groupoverviewdetail.columnimages"));
                    tableMoviesOverviewDetail_ColumnImages.setWidth(80);
                }
            // Search
            {
                //label for Search
                labelMoviesSearch = new Label(groupMoviesOverview, SWT.NONE);
                labelMoviesSearch.setText(l
                        .getString("movies.groupoverview.searchlabel")
                        + ":");
                GridData label2LData = new GridData();
                label2LData.horizontalSpan = 3;
                labelMoviesSearch.setLayoutData(label2LData);

                //text Search
                textMoviesSearch = new Text(groupMoviesOverview, SWT.BORDER);
                GridData text2LData = new GridData();
                textMoviesSearch.addFocusListener(new FocusAdapter() {
                    public void focusLost(FocusEvent evt) {
                        if (logger.isDebugEnabled()) {
                            logger.debug("focusLost(FocusEvent evt = " + evt + " "
                                    + textMoviesSearch.getText() + ") - start");
                        }

                        refreshMoviesOverviewTable(textMoviesSearch.getText());

                        if (logger.isDebugEnabled()) {
                            logger.debug("focusLost(FocusEvent) - end");
                        }
                    }
                });
                textMoviesSearch.addListener(SWT.DefaultSelection, new Listener() {
                    public void handleEvent(Event e) {
                        if (logger.isDebugEnabled()) {
                            logger.debug("handleEvent(Event e = " + e + " "
                                    + textMoviesSearch.getText() + ") - start");
                        }

                        refreshMoviesOverviewTable(textMoviesSearch.getText());

                        if (logger.isDebugEnabled()) {
                            logger.debug("handleEvent(Event) - end");
                        }
                    }
                    
                });
                text2LData.horizontalAlignment = GridData.FILL;
                text2LData.horizontalSpan = 5;
                text2LData.grabExcessHorizontalSpace = true;
                textMoviesSearch.setLayoutData(text2LData);
            }// Search                    
        }
    }


    /**
     * 
     */
    private void initMoviesDetail() {
        // Group Actors Detail
        {
            groupMoviesDetail = new Group(sashForm1, SWT.NONE);
            GridLayout group2Layout = new GridLayout();
            GridData group2LData = new GridData();
            group2Layout.verticalSpacing = 15;
            group2Layout.numColumns = 6;
            groupMoviesDetail.setText(l.getString("movies.groupdetail.label"));   
            FormData formData = new FormData();
            groupMoviesDetail.setLayout(group2Layout);
            formData.right = new FormAttachment(100, 100, -5);
            formData.top = new FormAttachment(0, 100, 5);
            formData.bottom = new FormAttachment(100, 100, -5);
            groupMoviesDetail.setLayoutData(formData);
        }
//      labels and text for detail
    	{
    	    labelMoviesID = new Label(groupMoviesDetail, SWT.NONE);
    	    labelMoviesID.setText(l
    	            .getString("movies.groupdetail.labelid")
    	            + ":");
    	    labelMoviesID.setSize(125, 15);
    	    GridData formData2 = new GridData();
    	    formData2.widthHint = 125;
    	    formData2.heightHint = 15;
    	    formData2.horizontalSpan = 2;
    	    labelMoviesID.setLayoutData(formData2);
    	}
    	{
    	    textMoviesID = new Text(
    	            groupMoviesDetail,
    	            SWT.READ_ONLY | SWT.BORDER);
    	    GridData text1LData1 = new GridData();
    	    text1LData1.horizontalAlignment = GridData.FILL;
    	    text1LData1.heightHint = 13;
    	    text1LData1.horizontalSpan = 4;
    	    text1LData1.grabExcessHorizontalSpace = true;
    	    textMoviesID.setLayoutData(text1LData1);
    	}
    	{
            labelMoviesTitle = new Label(
                groupMoviesDetail,
                SWT.NONE);
            labelMoviesTitle.setText(l
                .getString("movies.groupdetail.labeltitle")
                + ":");
            labelMoviesTitle.setSize(125, 15);
            GridData labelActorNameLData = new GridData();
            labelActorNameLData.widthHint = 125;
            labelActorNameLData.heightHint = 15;
            labelActorNameLData.horizontalSpan = 2;
            labelMoviesTitle
                .setLayoutData(labelActorNameLData);
        }
        {
    	    textMoviesTitle = new Text(groupMoviesDetail,
    	            SWT.READ_ONLY | SWT.BORDER);
    	    GridData text1LData2 = new GridData();
    	    text1LData2.horizontalAlignment = GridData.FILL;
    	    text1LData2.heightHint = 13;
    	    text1LData2.horizontalSpan = 4;
    	    text1LData2.grabExcessHorizontalSpace = true;
    	    textMoviesTitle.setLayoutData(text1LData2);        
    	}// label and buttons for detail      
    }

    /**
     * @param text
     */
    protected void refreshMoviesOverviewTable(String text) {
        // TODO Auto-generated method stub
        
    }

    /**
     * @param text
     */
    protected void refreshMoviesDetail(String text) {
        // TODO Auto-generated method stub
        
    }
}

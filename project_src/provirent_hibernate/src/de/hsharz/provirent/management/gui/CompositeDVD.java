package de.hsharz.provirent.management.gui;

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.List;

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
import org.eclipse.swt.widgets.Combo;
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

import de.hsharz.provirent.objects.Dvd;
import de.hsharz.provirent.objects.Language;
import de.hsharz.provirent.objects.Subtitle;
import de.hsharz.provirent.objects.VideoFormat;
import de.hsharz.provirent.objects.AudioFormat;
import de.hsharz.provirent.objects.Movie;
import de.hsharz.provirent.objects.PaymentCategory;
import de.hsharz.provirent.objects.Condition;
import de.hsharz.provirent.objects.Status;
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
    
    private Table tableDVDLanguagesDetail;
    
    private Table tableDVDSubtitlesDetail;
    
    private Table tableDVDVideoformatDetail;
    
    private Table tableDVDAudioformatDetail;
    
    private TableColumn tableDVDOverview_ColumnID;

    private TableColumn tableDVDOverview_ColumnTitle;

    private TableColumn tableDVDOverview_ColumnStatus;
    
    private TableColumn tableDVDOverview_ColumnCondition;
    
    private TableColumn tableDVDDetail_ColumnID; 
    
    private TableColumn tableDVDDetail_ColumnName;
    
    private Text textDVDSearch;
    
    private Text textDVDID;
    
    private Text textDVDBarcode;
    
    private Combo comboDVDPayment;
    
    private Combo comboDVDStatus;

    private Combo comboDVDCondition;
    
    private Combo comboDVDMovie;
    
    private Label labelDVDStatus;
    
    private Label labelDVDMovie;
    
    private Label labelDVDBarcode;
    
    private Label labelDVDPayment;

    private Label labelDVDCondition;
    
    private Label labelDVDSearch;
   
    private Label labelDVDID;
    
    private Label labelDVDLanguages;
    
    private Label labelDVDSubtitles;
    
    private Label labelDVDVideoformat;
    
    private Label labelDVDAudioformat;
        
    private Composite parent;
    
    private Composite compositeDVDEditLanguages;
    
    private Composite compositeDVDEditSubtitles;
    
    private Composite compositeDVDEditVideoformat;
    
    private Composite compositeDVDEditAudioformat;
    
    private Button buttonDVDAddLanguages;
    
    private Button buttonDVDDeleteLanguages;
    
    private Button buttonDVDAddSubtitles;
    
    private Button buttonDVDDeleteSubtitles;
    
    private Button buttonDVDAddVideoformat;
    
    private Button buttonDVDDeleteVideoformat;
    
    private Button buttonDVDAddAudioformat;
    
    private Button buttonDVDDeleteAudioformat;
    
    private SashForm sashForm1;
    
    private int mode_dvd;

    private Locale locale;
    
    private StatusLineStyledText statusLine;
    
    private ResourceBundle l;
    
    private Dvd localdvd;
    
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
			text1LData1.heightHint = 13;
			text1LData1.grabExcessHorizontalSpace = true;
			text1LData1.horizontalSpan = 2;
			text1LData1.horizontalAlignment = GridData.FILL;
			textDVDID.setLayoutData(text1LData1);
		}
		{
			labelDVDBarcode = new Label(groupDVDDetail, SWT.NONE);
			labelDVDBarcode.setText(l.getString("dvd.groupdetail.labelbarcode")
					+ ":");
			GridData formData2 = new GridData();
			formData2.heightHint = 15;
			formData2.horizontalAlignment = GridData.FILL;
			formData2.verticalAlignment = GridData.BEGINNING;
			labelDVDBarcode.setLayoutData(formData2);
		}
		{
			textDVDBarcode = new Text(groupDVDDetail, SWT.READ_ONLY
					| SWT.BORDER);
			GridData text1LData1 = new GridData();
			text1LData1.heightHint = 13;
			text1LData1.grabExcessHorizontalSpace = true;
			text1LData1.horizontalSpan = 2;
			text1LData1.horizontalAlignment = GridData.FILL;
			textDVDBarcode.setLayoutData(text1LData1);
		}
        {
            labelDVDMovie = new Label(groupDVDDetail, SWT.NONE);
            labelDVDMovie.setText("labelDVDMovie");
            GridData labelDVDMovieLData = new GridData();
            labelDVDMovieLData.horizontalAlignment = GridData.FILL;
            labelDVDMovie.setLayoutData(labelDVDMovieLData);
        }
        {
            comboDVDMovie = new Combo(groupDVDDetail, SWT.NONE);
            comboDVDMovie.setText("comboDVDMovie");
            GridData combo1LData1 = new GridData();
            combo1LData1.horizontalAlignment = GridData.FILL;
            combo1LData1.horizontalSpan = 5;
            comboDVDMovie.setLayoutData(combo1LData1);
            List l=Database.getMovie("");
            for(int i=0;i<l.size();i++)  {
                comboDVDMovie.add(((Movie)l.get(i)).getTitle(),i);
            }
        }
        {
            labelDVDPayment = new Label(groupDVDDetail, SWT.NONE);
            labelDVDPayment.setText("labelDVDPayment");
            GridData labelDVDPaymentLData = new GridData();
            labelDVDPaymentLData.horizontalAlignment = GridData.FILL;
            labelDVDPayment.setLayoutData(labelDVDPaymentLData);
        }
        {
            comboDVDPayment = new Combo(groupDVDDetail, SWT.NONE);
            comboDVDPayment.setText("comboDVDPayment");
            GridData combo1LData = new GridData();
            combo1LData.horizontalAlignment = GridData.FILL;
            combo1LData.horizontalSpan = 5;
            comboDVDPayment.setLayoutData(combo1LData);
            List l=Database.getPaymentCategory();
            for(int i=0;i<l.size();i++)  {
                comboDVDPayment.add(((PaymentCategory)l.get(i)).getName(),i);
            }
        }
        {
            labelDVDStatus = new Label(groupDVDDetail, SWT.NONE);
            labelDVDStatus.setText("labelDVDStatus");
            GridData labelDVDStatusLData = new GridData();
            labelDVDStatusLData.horizontalAlignment = GridData.FILL;
            labelDVDStatus.setLayoutData(labelDVDStatusLData);
        }
        {
            comboDVDStatus = new Combo(groupDVDDetail, SWT.NONE);
            comboDVDStatus.setText("comboDVDStatus");
            GridData combo1LData2 = new GridData();
            combo1LData2.horizontalSpan = 5;
            combo1LData2.grabExcessHorizontalSpace = true;
            combo1LData2.horizontalAlignment = GridData.FILL;
            comboDVDStatus.setLayoutData(combo1LData2);
            List l=Database.getStatus("");
            for(int i=0;i<l.size();i++)  {
                comboDVDStatus.add(((Status)l.get(i)).getStatusName(),i);
            }
        }
        {
            labelDVDCondition = new Label(groupDVDDetail, SWT.NONE);
            labelDVDCondition.setText("labelDVDCondition");
            GridData labelDVDConditionLData = new GridData();
            labelDVDConditionLData.horizontalAlignment = GridData.FILL;
            labelDVDCondition.setLayoutData(labelDVDConditionLData);
        }
        {
            comboDVDCondition = new Combo(groupDVDDetail, SWT.NONE);
            comboDVDCondition.setText("comboDVDCondition");
            GridData combo1LData3 = new GridData();
            combo1LData3.horizontalAlignment = GridData.FILL;
            combo1LData3.grabExcessHorizontalSpace = true;
            combo1LData3.horizontalSpan = 5;
            comboDVDCondition.setLayoutData(combo1LData3);
            List l=Database.getCondition("");
            for(int i=0;i<l.size();i++)  {
                comboDVDCondition.add(((Condition)l.get(i)).getConditionName(),i);
            }
        }
//      EditDirectors
		{

			compositeDVDEditLanguages = new Composite(groupDVDDetail,
					SWT.NONE);
			GridLayout composite1Layout = new GridLayout();
			GridData composite1LData = new GridData();
			composite1LData.horizontalAlignment = GridData.FILL;
			composite1LData.verticalAlignment = GridData.BEGINNING;
			compositeDVDEditLanguages.setLayoutData(composite1LData);
			composite1Layout.numColumns = 2;
			compositeDVDEditLanguages.setLayout(composite1Layout);
		}
		{
			labelDVDLanguages = new Label(compositeDVDEditLanguages,
					SWT.NONE);
			labelDVDLanguages.setText(l
					.getString("dvd.groupdetail.labellanguages"));
			GridData formData2 = new GridData();
			formData2.horizontalSpan = 2;
			formData2.verticalSpan = 1;
			labelDVDLanguages.setLayoutData(formData2);
		}
		{
			buttonDVDAddLanguages = new Button(compositeDVDEditLanguages,
					SWT.NONE);
			buttonDVDAddLanguages.setText(l
					.getString("dvd.button.additem"));
			buttonDVDAddLanguages.setEnabled(false);
			GridData text1LData2 = new GridData();
			text1LData2.heightHint = 20;
			text1LData2.horizontalSpan = 1;
			text1LData2.horizontalAlignment = GridData.BEGINNING;
			buttonDVDAddLanguages.setLayoutData(text1LData2);
			buttonDVDAddLanguages
					.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							//open responsible Dialog and insert objects into
							/* table
							DialogMovie dialog = new DialogMovie(getShell(), 0,
									locale, localmovie,
									DialogMovie.TYPE_DIRECTOR);
							dialog.open();

							tableMoviesDirectorsDetail.removeAll();
							TableItem item;
							for (int i = 0; i < localmovie.getDirector().size(); i++) {
								item = new TableItem(
										tableMoviesDirectorsDetail, SWT.NONE);
								item.setText(new String[] {
										((Director) localmovie.getDirector()
												.get(i)).getDirectorId()
												+ "",
										((Director) localmovie.getDirector()
												.get(i)).getLastName()
												+ " , "
												+ ((Director) localmovie
														.getDirector().get(i))
														.getFirstName() });
							}
							*/
						    // TODO
						}
					});
		}
		{
			buttonDVDDeleteLanguages = new Button(
					compositeDVDEditLanguages, SWT.NONE);
			buttonDVDDeleteLanguages.setText(l
					.getString("dvd.button.deleteitem"));
			buttonDVDDeleteLanguages.setEnabled(false);
			GridData text1LData2 = new GridData();
			text1LData2.horizontalAlignment = GridData.BEGINNING;
			text1LData2.heightHint = 20;
			text1LData2.horizontalSpan = 1;
			buttonDVDDeleteLanguages.setLayoutData(text1LData2);
			buttonDVDDeleteLanguages
					.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							//get selected Item
							//get id from object
							//search for id in list and delete object
							//remove table entry
							int index = tableDVDLanguagesDetail
									.getSelectionIndex();
							if (index >= 0) {
								String strid = tableDVDLanguagesDetail
										.getItem(index).getText(0);
								int id = Integer.parseInt(strid);
								for (int i = 0; i < localdvd.getLanguages()
										.size(); i++) {
									Language o = (Language) localdvd
											.getLanguages().get(i);
									if (o.getLanguageId().intValue() == id) {
										localdvd.getLanguages().remove(o);
										break;
									}
								}
								tableDVDLanguagesDetail.remove(index);
							}
							
						    //TODO
						}
					});
		}
		{
		    tableDVDLanguagesDetail = new Table(groupDVDDetail,
					SWT.SINGLE | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.BORDER);
			//tableMoviesDirectorsDetail.setHeaderVisible(true);
			//tableMoviesDirectorsDetail.setLinesVisible(true);
			GridData tableDVDLanguagesDetailLData = new GridData();
			tableDVDLanguagesDetailLData.horizontalAlignment = GridData.FILL;
			tableDVDLanguagesDetailLData.horizontalSpan = 5;
			tableDVDLanguagesDetailLData.grabExcessVerticalSpace = true;
			tableDVDLanguagesDetailLData.verticalAlignment = GridData.FILL;
			tableDVDLanguagesDetail
					.setLayoutData(tableDVDLanguagesDetailLData);

			{
				tableDVDDetail_ColumnID = new TableColumn(
				        tableDVDLanguagesDetail, SWT.CENTER);
				tableDVDDetail_ColumnID.setWidth(0);
				tableDVDDetail_ColumnID.setResizable(false);
			}
			{
				tableDVDDetail_ColumnName = new TableColumn(
				        tableDVDLanguagesDetail, SWT.LEFT);
				tableDVDDetail_ColumnName
						.setText(l
								.getString("dvd.groupoverviewdetail.columnlanguages"));
				tableDVDDetail_ColumnName.setWidth(200);
			}
		}// EditDirectors
		// Edit Actors
		{
			compositeDVDEditSubtitles = new Composite(groupDVDDetail,
					SWT.NONE);
			GridLayout composite1Layout = new GridLayout();
			GridData composite1LData = new GridData();
			composite1LData.horizontalAlignment = GridData.FILL;
			composite1LData.verticalAlignment = GridData.BEGINNING;
			compositeDVDEditSubtitles.setLayoutData(composite1LData);
			composite1Layout.numColumns = 2;
			compositeDVDEditSubtitles.setLayout(composite1Layout);
		}

		{
			labelDVDSubtitles = new Label(compositeDVDEditSubtitles, SWT.NONE);
			labelDVDSubtitles.setText(l
					.getString("dvd.groupdetail.labelSubtitles"));
			GridData formData2 = new GridData();
			formData2.horizontalSpan = 2;
			formData2.verticalSpan = 1;
			labelDVDSubtitles.setLayoutData(formData2);
		}
		{
			buttonDVDAddSubtitles = new Button(compositeDVDEditSubtitles,
					SWT.NONE);
			buttonDVDAddSubtitles.setText(l.getString("dvd.button.additem"));
			buttonDVDAddSubtitles.setEnabled(false);
			GridData text1LData2 = new GridData();
			text1LData2.heightHint = 20;
			text1LData2.horizontalSpan = 1;
			text1LData2.horizontalAlignment = GridData.BEGINNING;
			buttonDVDAddSubtitles.setLayoutData(text1LData2);
			buttonDVDAddSubtitles.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					//open responsible Dialog and insert objects into table
					/*
				    DialogMovie dialog = new DialogMovie(getShell(), 0, locale,
							localmovie, DialogMovie.TYPE_ACTOR);
					dialog.open();

					tableMoviesActorsDetail.removeAll();
					TableItem item;
					for (int i = 0; i < localmovie.getActors().size(); i++) {
						item = new TableItem(tableMoviesActorsDetail, SWT.NONE);
						item.setText(new String[] {
								((Actor) localmovie.getActors().get(i))
										.getActorId()
										+ "",
								((Actor) localmovie.getActors().get(i))
										.getLastName()
										+ ", "
										+ ((Actor) localmovie.getActors()
												.get(i)).getFirstName() });
					}
				*/
				}
			});
		}
		{
			buttonDVDDeleteSubtitles = new Button(compositeDVDEditSubtitles,
					SWT.NONE);
			buttonDVDDeleteSubtitles.setText(l
					.getString("dvd.button.deleteitem"));
			buttonDVDDeleteSubtitles.setEnabled(false);
			GridData text1LData2 = new GridData();
			text1LData2.horizontalAlignment = GridData.BEGINNING;
			text1LData2.heightHint = 20;
			text1LData2.horizontalSpan = 1;
			buttonDVDDeleteSubtitles.setLayoutData(text1LData2);
			buttonDVDDeleteSubtitles
					.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							//get selected Item
							//get id from object
							//search for id in list and delete object
							//remove table entry
							int index = tableDVDSubtitlesDetail
									.getSelectionIndex();
							if (index >= 0) {
								String strid = tableDVDSubtitlesDetail.getItem(
										index).getText(0);
								int id = Integer.parseInt(strid);
								for (int i = 0; i < localdvd.getSubtitles()
										.size(); i++) {
									Subtitle o = (Subtitle) localdvd.getSubtitles()
											.get(i);
									if (o.getSubtitleId().intValue() == id) {
										localdvd.getSubtitles().remove(o);
										break;
									}
								}
								tableDVDSubtitlesDetail.remove(index);
							}
						}
					});
		}
		{
		    tableDVDSubtitlesDetail = new Table(groupDVDDetail, SWT.SINGLE
					| SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.BORDER);
			//tableMoviesActorsDetail.setHeaderVisible(true);
			//tableMoviesActorsDetail.setLinesVisible(true);
			GridData tableDVDSubtitlesDetailLData = new GridData();
			tableDVDSubtitlesDetailLData.horizontalAlignment = GridData.FILL;
			tableDVDSubtitlesDetailLData.horizontalSpan = 5;
			tableDVDSubtitlesDetailLData.grabExcessVerticalSpace = true;
			tableDVDSubtitlesDetailLData.verticalAlignment = GridData.FILL;
			tableDVDSubtitlesDetail.setLayoutData(tableDVDSubtitlesDetailLData);

			{
				tableDVDDetail_ColumnID = new TableColumn(
				        tableDVDSubtitlesDetail, SWT.CENTER);
				tableDVDDetail_ColumnID.setWidth(0);
				tableDVDDetail_ColumnID.setResizable(false);
			}
			{
				tableDVDDetail_ColumnName = new TableColumn(
				        tableDVDSubtitlesDetail, SWT.LEFT);
				tableDVDDetail_ColumnName.setText(l
						.getString("dvd.groupoverviewdetail.columnsubtitles"));
				tableDVDDetail_ColumnName.setWidth(200);
			}
		}//Edit Actors
		//Edit Genres
		{
			compositeDVDEditVideoformat = new Composite(groupDVDDetail,
					SWT.NONE);
			GridLayout composite1Layout = new GridLayout();
			GridData composite1LData = new GridData();
			composite1LData.horizontalAlignment = GridData.FILL;
			composite1LData.verticalAlignment = GridData.BEGINNING;
			compositeDVDEditVideoformat.setLayoutData(composite1LData);
			composite1Layout.numColumns = 2;
			compositeDVDEditVideoformat.setLayout(composite1Layout);
		}

		{
			labelDVDVideoformat = new Label(compositeDVDEditVideoformat, SWT.NONE);
			labelDVDVideoformat.setText(l
					.getString("dvd.groupdetail.labelvideoformat"));
			GridData formData2 = new GridData();
			formData2.horizontalSpan = 2;
			formData2.verticalSpan = 1;
			labelDVDVideoformat.setLayoutData(formData2);
		}
		{
			buttonDVDAddVideoformat = new Button(compositeDVDEditVideoformat,
					SWT.NONE);
			buttonDVDAddVideoformat.setText(l.getString("dvd.button.additem"));
			buttonDVDAddVideoformat.setEnabled(false);
			GridData text1LData2 = new GridData();
			text1LData2.heightHint = 20;
			text1LData2.horizontalSpan = 1;
			text1LData2.horizontalAlignment = GridData.BEGINNING;
			buttonDVDAddVideoformat.setLayoutData(text1LData2);
			buttonDVDAddVideoformat.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					//open responsible Dialog and insert objects into table
					/*
				    DialogMovie dialog = new DialogMovie(getShell(), 0, locale,
							localmovie, DialogMovie.TYPE_GENRE);
					dialog.open();

					tableMoviesGenresDetail.removeAll();
					TableItem item;
					for (int i = 0; i < localmovie.getGenres().size(); i++) {
						item = new TableItem(tableMoviesGenresDetail, SWT.NONE);
						item.setText(new String[] {
								((Genre) localmovie.getGenres().get(i))
										.getGenreId()
										+ "",
								((Genre) localmovie.getGenres().get(i))
										.getName()
										+ "" });
					}
				*/
				}
			});
		}
		{
			buttonDVDDeleteVideoformat = new Button(compositeDVDEditVideoformat,
					SWT.NONE);
			buttonDVDDeleteVideoformat.setText(l
					.getString("dvd.button.deleteitem"));
			buttonDVDDeleteVideoformat.setEnabled(false);
			GridData text1LData2 = new GridData();
			text1LData2.horizontalAlignment = GridData.BEGINNING;
			text1LData2.heightHint = 20;
			text1LData2.horizontalSpan = 1;
			buttonDVDDeleteVideoformat.setLayoutData(text1LData2);
			buttonDVDDeleteVideoformat
					.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							//get selected Item
							//get id from object
							//search for id in list and delete object
							//remove table entry
							int index = tableDVDVideoformatDetail
									.getSelectionIndex();
							if (index >= 0) {
								String strid = tableDVDVideoformatDetail.getItem(
										index).getText(0);
								int id = Integer.parseInt(strid);
								for (int i = 0; i < localdvd.getVideoFormats()
										.size(); i++) {
									VideoFormat o = (VideoFormat) localdvd.getVideoFormats()
											.get(i);
									if (o.getVideoFormatId().intValue() == id) {
										localdvd.getVideoFormats().remove(o);
										break;
									}
								}
								tableDVDVideoformatDetail.remove(index);
							}
						}
					});
		}
		{
		    tableDVDVideoformatDetail = new Table(groupDVDDetail, SWT.SINGLE
					| SWT.FULL_SELECTION | SWT.BORDER);
			//tableMoviesGenresDetail.setHeaderVisible(true);
			//tableMoviesGenresDetail.setLinesVisible(true);
			GridData tableDVDVideoformatDetailLData = new GridData();
			tableDVDVideoformatDetailLData.horizontalAlignment = GridData.FILL;
			tableDVDVideoformatDetailLData.horizontalSpan = 5;
			tableDVDVideoformatDetailLData.grabExcessVerticalSpace = true;
			tableDVDVideoformatDetailLData.verticalAlignment = GridData.FILL;
			tableDVDVideoformatDetail.setLayoutData(tableDVDVideoformatDetailLData);

			{
				tableDVDDetail_ColumnID = new TableColumn(
						tableDVDVideoformatDetail, SWT.CENTER);
				tableDVDDetail_ColumnID.setWidth(0);
				tableDVDDetail_ColumnID.setResizable(false);
			}
			{
				tableDVDDetail_ColumnName = new TableColumn(
						tableDVDVideoformatDetail, SWT.LEFT);
				tableDVDDetail_ColumnName.setText(l
						.getString("dvd.groupoverviewdetail.columnvideoformat"));
				tableDVDDetail_ColumnName.setWidth(200);
			}
		}// Edit Genre
		// Edit Images
		{
			compositeDVDEditAudioformat = new Composite(groupDVDDetail,
					SWT.NONE);
			GridLayout composite1Layout = new GridLayout();
			GridData composite1LData = new GridData();
			composite1LData.horizontalAlignment = GridData.FILL;
			composite1LData.verticalAlignment = GridData.BEGINNING;
			compositeDVDEditAudioformat.setLayoutData(composite1LData);
			composite1Layout.numColumns = 2;
			compositeDVDEditAudioformat.setLayout(composite1Layout);
		}

		{
		    labelDVDAudioformat = new Label(compositeDVDEditAudioformat, SWT.NONE);
		    labelDVDAudioformat.setText(l
					.getString("dvd.groupdetail.labelaudioformat"));
			GridData formData2 = new GridData();
			formData2.horizontalSpan = 2;
			formData2.verticalSpan = 1;
			labelDVDAudioformat.setLayoutData(formData2);
		}
		{
			buttonDVDAddAudioformat = new Button(compositeDVDEditAudioformat,
					SWT.NONE);
			buttonDVDAddAudioformat.setText(l.getString("dvd.button.additem"));
			buttonDVDAddAudioformat.setEnabled(false);
			GridData text1LData2 = new GridData();
			text1LData2.heightHint = 20;
			text1LData2.horizontalSpan = 1;
			text1LData2.horizontalAlignment = GridData.BEGINNING;
			buttonDVDAddAudioformat.setLayoutData(text1LData2);
			buttonDVDAddAudioformat.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					//open responsible Dialog and insert objects into table
					/*
				    DialogMovie dialog = new DialogMovie(getShell(), 0, locale,
							localmovie, DialogMovie.TYPE_IMAGE);
					dialog.open();

					tableMoviesImagesDetail.removeAll();
					TableItem item;
					for (int i = 0; i < localmovie.getImages().size(); i++) {
						item = new TableItem(tableMoviesImagesDetail, SWT.NONE);
						item.setText(new String[] {
								((Image) localmovie.getImages().get(i))
										.getImageId()
										+ "",
								((Image) localmovie.getImages().get(i))
										.getImageFileName()
										+ "" });
					}
					*/
				    //TODO
				}
			});
		}
		{
			buttonDVDDeleteAudioformat = new Button(compositeDVDEditAudioformat,
					SWT.NONE);
			buttonDVDDeleteAudioformat.setText(l
					.getString("dvd.button.deleteitem"));
			buttonDVDDeleteAudioformat.setEnabled(false);
			GridData text1LData2 = new GridData();
			text1LData2.horizontalAlignment = GridData.BEGINNING;
			text1LData2.heightHint = 20;
			text1LData2.horizontalSpan = 1;
			buttonDVDDeleteAudioformat.setLayoutData(text1LData2);
			buttonDVDDeleteAudioformat
					.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							//get selected Item
							//get id from object
							//search for id in list and delete object
							//remove table entry
							int index = tableDVDAudioformatDetail
									.getSelectionIndex();
							if (index >= 0) {
								String strid = tableDVDAudioformatDetail.getItem(
										index).getText(0);
								int id = Integer.parseInt(strid);
								for (int i = 0; i < localdvd.getAudioFormats()
										.size(); i++) {
									AudioFormat o = (AudioFormat) localdvd.getAudioFormats()
											.get(i);
									if (o.getAudioFormatId().intValue() == id) {
										localdvd.getAudioFormats().remove(o);
										break;
									}
								}
								tableDVDAudioformatDetail.remove(index);
							}

						}
					});
		}
		{
		    tableDVDAudioformatDetail = new Table(groupDVDDetail, SWT.SINGLE
					| SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.BORDER);
			//tableMoviesImagesDetail.setHeaderVisible(true);
			//tableMoviesImagesDetail.setLinesVisible(true);
			GridData tableDVDAudioformatDetailLData = new GridData();
			tableDVDAudioformatDetailLData.horizontalAlignment = GridData.FILL;
			tableDVDAudioformatDetailLData.horizontalSpan = 5;
			tableDVDAudioformatDetailLData.grabExcessVerticalSpace = true;
			tableDVDAudioformatDetailLData.verticalAlignment = GridData.FILL;
			tableDVDAudioformatDetail.setLayoutData(tableDVDAudioformatDetailLData);
			{
				tableDVDDetail_ColumnID = new TableColumn(
				        tableDVDAudioformatDetail, SWT.CENTER);
				tableDVDDetail_ColumnID.setWidth(0);
				tableDVDDetail_ColumnID.setResizable(false);
			}
			{
				tableDVDDetail_ColumnName = new TableColumn(
				        tableDVDAudioformatDetail, SWT.LEFT);
				tableDVDDetail_ColumnName.setText(l
						.getString("dvd.groupoverviewdetail.columnaudioformat"));
				tableDVDDetail_ColumnName.setWidth(200);
			}
		}// Edit Images
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

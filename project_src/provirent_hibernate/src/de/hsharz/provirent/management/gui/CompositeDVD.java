package de.hsharz.provirent.management.gui;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
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

import de.hsharz.provirent.objects.AudioFormat;
import de.hsharz.provirent.objects.Condition;
import de.hsharz.provirent.objects.Dvd;
import de.hsharz.provirent.objects.Language;
import de.hsharz.provirent.objects.Movie;
import de.hsharz.provirent.objects.PaymentCategory;
import de.hsharz.provirent.objects.Status;
import de.hsharz.provirent.objects.Subtitle;
import de.hsharz.provirent.objects.VideoFormat;
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
    
    private Composite compositeButtons;
    
    private Button buttonDVDAddLanguages;
    
    private Button buttonDVDDeleteLanguages;
    
    private Button buttonDVDAddSubtitles;
    
    private Button buttonDVDDeleteSubtitles;
    
    private Button buttonDVDAddVideoformat;
    
    private Button buttonDVDDeleteVideoformat;
    
    private Button buttonDVDAddAudioformat;
    
    private Button buttonDVDDeleteAudioformat;
    
    private Button buttonDVDNew;
    
    private Button buttonDVDDelete;
    
    private Button buttonDVDEdit;
    
    private Button buttonDVDCancel;
    
    private Button buttonDVDSave;
    
    private Button buttonDVDFill;
    
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
            refreshDVDOverviewTable(textDVDSearch.getText());
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
            labelDVDMovie.setText(l.getString("dvd.groupdetail.labelmovie")
					+ ":");
            GridData labelDVDMovieLData = new GridData();
            labelDVDMovieLData.horizontalAlignment = GridData.FILL;
            labelDVDMovie.setLayoutData(labelDVDMovieLData);
        }
        {
            comboDVDMovie = new Combo(groupDVDDetail, SWT.READ_ONLY);
            comboDVDMovie.setText("comboDVDMovie");
            GridData combo1LData1 = new GridData();
            combo1LData1.horizontalAlignment = GridData.FILL;
            combo1LData1.horizontalSpan = 5;
            comboDVDMovie.setLayoutData(combo1LData1);
            List l=Database.getMovie("");
            for(int i=0;i<l.size();i++)  {
                comboDVDMovie.add(((Movie)l.get(i)).getTitle(),i);
            }
            comboDVDMovie.setEnabled(false);
        }
        {
            labelDVDPayment = new Label(groupDVDDetail, SWT.NONE);
            labelDVDPayment.setText(l.getString("dvd.groupdetail.labelpayment")
					+ ":");
            GridData labelDVDPaymentLData = new GridData();
            labelDVDPaymentLData.horizontalAlignment = GridData.FILL;
            labelDVDPayment.setLayoutData(labelDVDPaymentLData);
        }
        {
            comboDVDPayment = new Combo(groupDVDDetail, SWT.READ_ONLY);
            comboDVDPayment.setText("comboDVDPayment");
            GridData combo1LData = new GridData();
            combo1LData.horizontalAlignment = GridData.FILL;
            combo1LData.horizontalSpan = 5;
            comboDVDPayment.setLayoutData(combo1LData);
            List l=Database.getPaymentCategory();
            for(int i=0;i<l.size();i++)  {
                comboDVDPayment.add(((PaymentCategory)l.get(i)).getName(),i);
            }
            comboDVDPayment.setEnabled(false);
        }
        {
            labelDVDStatus = new Label(groupDVDDetail, SWT.NONE);
            labelDVDStatus.setText(l.getString("dvd.groupdetail.labelstatus")
					+ ":");
            GridData labelDVDStatusLData = new GridData();
            labelDVDStatusLData.horizontalAlignment = GridData.FILL;
            labelDVDStatus.setLayoutData(labelDVDStatusLData);
        }
        {
            comboDVDStatus = new Combo(groupDVDDetail, SWT.READ_ONLY);
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
            comboDVDStatus.setEnabled(false);
        }
        {
            labelDVDCondition = new Label(groupDVDDetail, SWT.NONE);
            labelDVDCondition.setText(l.getString("dvd.groupdetail.labelcondition")
					+ ":");
            GridData labelDVDConditionLData = new GridData();
            labelDVDConditionLData.horizontalAlignment = GridData.FILL;
            labelDVDCondition.setLayoutData(labelDVDConditionLData);
        }
        {
            comboDVDCondition = new Combo(groupDVDDetail, SWT.READ_ONLY);
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
            comboDVDCondition.setEnabled(false);
        }
        //      EditLanguages
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
							//table
							DialogDVD dialog = new DialogDVD(getShell(), 0,
									locale, localdvd,
									DialogDVD.TYPE_LANGUAGE);
							dialog.open();

							tableDVDLanguagesDetail.removeAll();
							TableItem item;
							for (int i = 0; i < localdvd.getLanguages().size(); i++) {
								item = new TableItem(
										tableDVDLanguagesDetail, SWT.NONE);
								item.setText(new String[] {
										((Language) localdvd.getLanguages()
												.get(i)).getLanguageId()
												+ "",
										((Language) localdvd.getLanguages()
												.get(i)).getName()
								});
							}
							
						    
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
		}// Edit Languages
		// Edit Subtitles
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
					//
				    DialogDVD dialog = new DialogDVD(getShell(), 0, locale,
							localdvd, DialogDVD.TYPE_SUBTITLE);
					dialog.open();

					tableDVDSubtitlesDetail.removeAll();
					TableItem item;
					for (int i = 0; i < localdvd.getSubtitles().size(); i++) {
						item = new TableItem(tableDVDSubtitlesDetail, SWT.NONE);
						item.setText(new String[] {
								((Subtitle) localdvd.getSubtitles().get(i))
										.getSubtitleId()
										+ "",
								((Subtitle) localdvd.getSubtitles().get(i))
										.getName() 
						});
					}
				
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
		}//Edit Subtitles
		//Edit Videoformat
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
					//
				    DialogDVD dialog = new DialogDVD(getShell(), 0, locale,
							localdvd, DialogDVD.TYPE_VIDEOFORMAT);
					dialog.open();

					tableDVDVideoformatDetail.removeAll();
					TableItem item;
					for (int i = 0; i < localdvd.getVideoFormats().size(); i++) {
						item = new TableItem(tableDVDVideoformatDetail, SWT.NONE);
						item.setText(new String[] {
								((VideoFormat) localdvd.getVideoFormats().get(i))
										.getVideoFormatId()
										+ "",
								((VideoFormat) localdvd.getVideoFormats().get(i))
										.getName() });
					}
				
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
		}// Edit Videoformat
		// Edit Audioformat
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
					//
				    DialogDVD dialog = new DialogDVD(getShell(), 0, locale,
							localdvd, DialogDVD.TYPE_AUDIOFORMAT);
					dialog.open();

					tableDVDAudioformatDetail.removeAll();
					TableItem item;
					for (int i = 0; i < localdvd.getAudioFormats().size(); i++) {
						item = new TableItem(tableDVDAudioformatDetail, SWT.NONE);
						item.setText(new String[] {
								((AudioFormat) localdvd.getAudioFormats().get(i))
										.getAudioFormatId()
										+ "",
								((AudioFormat) localdvd.getAudioFormats().get(i))
										.getName()
										+ "" });
					}
					
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
		}// Edit Audioformat
		{
			compositeButtons = new Composite(groupDVDDetail, SWT.EMBEDDED);
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
			buttonDVDNew = new Button(compositeButtons, SWT.PUSH
					| SWT.CENTER);
			buttonDVDNew.setText(l.getString("button.new"));
			buttonDVDNew.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {

					mode_dvd = ManagementGui.MODE_ADD;

					textDVDID.setText("");
					textDVDBarcode.setText("");
					textDVDBarcode.setEditable(true);
					textDVDSearch.setEditable(false);
					comboDVDMovie.setEnabled(true);
					comboDVDPayment.setEnabled(true);
					comboDVDStatus.setEnabled(true);
					comboDVDCondition.setEnabled(true);
					comboDVDMovie.setText("");
					comboDVDPayment.setText("");
					comboDVDCondition.setText("");
					comboDVDStatus.setText("");
					
					buttonDVDCancel.setEnabled(true);
					buttonDVDSave.setEnabled(true);
					buttonDVDNew.setEnabled(false);
					buttonDVDEdit.setEnabled(false);
					buttonDVDDelete.setEnabled(false);
					buttonDVDAddLanguages.setEnabled(true);
					buttonDVDDeleteLanguages.setEnabled(true);
					buttonDVDAddSubtitles.setEnabled(true);
					buttonDVDDeleteSubtitles.setEnabled(true);
					buttonDVDAddVideoformat.setEnabled(true);
					buttonDVDDeleteVideoformat.setEnabled(true);
					buttonDVDAddAudioformat.setEnabled(true);
					buttonDVDDeleteAudioformat.setEnabled(true);

					tableDVDOverview.setEnabled(false);
					tableDVDLanguagesDetail.removeAll();
					tableDVDSubtitlesDetail.removeAll();
					tableDVDVideoformatDetail.removeAll();
					tableDVDAudioformatDetail.removeAll();

					localdvd = new Dvd();
					localdvd.setLanguages(new ArrayList());
					localdvd.setSubtitles(new ArrayList());
					localdvd.setVideoFormats(new ArrayList());
					localdvd.setAudioFormats(new ArrayList());
				}
			});

			buttonDVDEdit = new Button(compositeButtons, SWT.PUSH
					| SWT.CENTER);
			buttonDVDEdit.setText(l.getString("button.edit"));
			buttonDVDEdit.setEnabled(false);
			buttonDVDEdit.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {

					mode_dvd = ManagementGui.MODE_EDIT;

					textDVDBarcode.setEditable(true);
					textDVDSearch.setEditable(false);
					comboDVDMovie.setEnabled(true);
					comboDVDPayment.setEnabled(true);
					comboDVDStatus.setEnabled(true);
					comboDVDCondition.setEnabled(true);
					
					buttonDVDCancel.setEnabled(true);
					buttonDVDSave.setEnabled(true);
					buttonDVDNew.setEnabled(false);
					buttonDVDEdit.setEnabled(false);
					buttonDVDDelete.setEnabled(false);
					buttonDVDAddLanguages.setEnabled(true);
					buttonDVDDeleteLanguages.setEnabled(true);
					buttonDVDAddSubtitles.setEnabled(true);
					buttonDVDDeleteSubtitles.setEnabled(true);
					buttonDVDAddVideoformat.setEnabled(true);
					buttonDVDDeleteVideoformat.setEnabled(true);
					buttonDVDAddAudioformat.setEnabled(true);
					buttonDVDDeleteAudioformat.setEnabled(true);

					tableDVDOverview.setEnabled(false);

				}
			});

			buttonDVDDelete = new Button(compositeButtons, SWT.PUSH
					| SWT.CENTER);
			buttonDVDDelete.setText(l.getString("button.delete"));
			buttonDVDDelete.setEnabled(false);
			buttonDVDDelete.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					if (logger.isDebugEnabled()) {
						logger.debug("widgetSelected(SelectionEvent) - buttonDVDDelete.widgetSelected, event="
										+ evt);
					}

					String msg = MessageFormat
							.format(l.getString("dvd.groupdetail.deletebutton.question.text"),
									new Object[] { localdvd.getMovie().getTitle()
											+ " " });

					int question = showMsg(
							msg,
							l
									.getString("dvd.groupdetail.deletebutton.question.header"),
							SWT.ICON_QUESTION | SWT.YES | SWT.NO);

					if (question != SWT.YES) {
						return;
					}

					try {
						//object speichern
						// Fehlerbehandlung
						Database.deleteObject(localdvd);

						//ÜbersichtsTabelle aktualisieren
						refreshDVDOverviewTable(textDVDSearch.getText());

						//Detailansicht leeren
						textDVDID.setText("");
						textDVDBarcode.setText("");
						tableDVDLanguagesDetail.removeAll();
						tableDVDSubtitlesDetail.removeAll();
						tableDVDVideoformatDetail.removeAll();
						tableDVDAudioformatDetail.removeAll();
						//in Tabelle nächsten auswählen
						try {
							tableDVDOverview.select(0);
						} catch (Exception ex) {
						}

						//Statusline Nachricht sezten
						statusLine
								.setStatus(
										1,
										l
												.getString("dvd.groupdetail.deletebutton.newok"));

					} catch (DataBaseException e) {
						if (e.getMessage().equalsIgnoreCase("1")) {
							//Fehler beim Speichern des Objectes

							statusLine
									.setStatus(
											3,
											l
													.getString("dvd.groupdetail.deletebutton.errorsave"));
							showMsg(
									l
											.getString("dvd.groupdetail.deletebutton.errorsave"),
									l.getString("error"), SWT.ICON_ERROR
											| SWT.OK);

						} else if (e.getMessage().equalsIgnoreCase("2")) {
							//fehler beim db aufbau
							statusLine
									.setStatus(
											3,
											l
													.getString("dvd.groupdetail.deletebutton.errordb"));
							showMsg(
									l
											.getString("dvd.groupdetail.deletebutton.errordb"),
									l.getString("error"), SWT.ICON_ERROR
											| SWT.OK);

						} else {
							//@todo
							logger.error("widgetSelected(SelectionEvent)", e);
						}

					}

				}

			});

			//leerer nicht sichtbarer Button
			buttonDVDFill = new Button(compositeButtons, SWT.PUSH
					| SWT.CENTER);
			GridData buttonActorFillLData = new GridData();
			buttonDVDFill.setVisible(false);
			buttonDVDFill.setEnabled(false);
			buttonActorFillLData.widthHint = 30;
			buttonActorFillLData.heightHint = 23;
			buttonDVDFill.setLayoutData(buttonActorFillLData);

			buttonDVDSave = new Button(compositeButtons, SWT.PUSH
					| SWT.CENTER);
			buttonDVDSave.setText(l.getString("button.save"));
			buttonDVDSave.setEnabled(false);
			buttonDVDSave.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					if (logger.isDebugEnabled()) {
						logger
								.debug("widgetSelected(SelectionEvent) - buttonDVDSave.widgetSelected, event="
										+ evt);
					}

					List errors = validateInput();

					if (errors.size() > 0) {
						StringBuffer buf = new StringBuffer();

						for (int i = 0; i < errors.size(); i++) {
							buf.append("- ").append(errors.get(i)).append("\n");
						}

						showMsg(
								l
										.getString("dvd.groupdetail.savebutton.warn.noitems.msg")
										+ new String(buf),
								l
										.getString("dvd.groupdetail.savebutton.warn.noitems.title"),
								SWT.ICON_WARNING | SWT.YES);
						return;

					}
					
					
					localdvd.setBarcode(textDVDBarcode.getText());
					
					
					// sehr schlechte Lösung
					//TODO bessere Lösung finden
					List list = Database.getMovie("");
					for(int i=0;i<list.size();i++)  {
					    if(comboDVDMovie.getText().compareTo(((Movie)list.get(i)).getTitle()) == 0)  {
					      localdvd.setMovie((Movie)list.get(i)); 
					      break;
					    }
					}
					list = Database.getPaymentCategory();
					for(int i=0;i<list.size();i++)  {
					    if(comboDVDPayment.getText().compareTo(((PaymentCategory)list.get(i)).getName()) == 0)  {
					      localdvd.setPaymentCategory((PaymentCategory)list.get(i)); 
					      break;
					    }
					}
					list = Database.getCondition("");
					for(int i=0;i<list.size();i++)  {
					    if(comboDVDCondition.getText().compareTo(((Condition)list.get(i)).getConditionName()) == 0)  {
					      localdvd.setCondition((Condition)list.get(i)); 
					      break;
					    }
					}
					list = Database.getStatus("");
					for(int i=0;i<list.size();i++)  {
					    if(comboDVDStatus.getText().compareTo(((Status)list.get(i)).getStatusName()) == 0)  {
					      localdvd.setStatus((Status)list.get(i)); 
					      break;
					    }
					}
					try {
						//object speichern
						// Fehlerbehandlung

						if (mode_dvd == ManagementGui.MODE_ADD) {

							logger.debug("Objektid: " + localdvd.getDvdId()
									+ " vor speichern");
							Database.saveObject(localdvd);
							logger.debug("Objektid: " + localdvd.getDvdId()
									+ " nach speichern");

							// in Übersichtstabelle einfügen
							insertIntoDVDOverviewTable(localdvd);
							textDVDID.setText(localdvd.getDvdId() + "");
						} else if (mode_dvd == ManagementGui.MODE_EDIT) {
							Database.updateObject(localdvd);
						}
						//Statusline Nachricht sezten
						statusLine
								.setStatus(
										1,
										l.getString("dvd.groupdetail.savebutton.newok"));
					} catch (DataBaseException e) {
						logger.debug("DataBaseException: " + e);
						if (e.getMessage().equalsIgnoreCase("1")) {
							//Fehler beim Speichern des Objectes

							statusLine
									.setStatus(
											3,
											l.getString("dvd.groupdetail.savebutton.errorsave"));
							showMsg(
									l.getString("dvd.groupdetail.savebutton.errorsave"),
									"Fehler", SWT.ICON_ERROR | SWT.OK);

						} else if (e.getMessage().equalsIgnoreCase("2")) {
							//fehler beim db aufbau
							statusLine
									.setStatus(
											3,
											l.getString("dvd.groupdetail.savebutton.errordb"));
							showMsg(
									l.getString("dvd.groupdetail.savebutton.errordb"),
									"Fehler", SWT.ICON_ERROR | SWT.OK);

						} else {
							//@todo
							logger.error("widgetSelected(SelectionEvent)", e);
						}

					} catch (Exception ex) {
						logger.debug("Unbekannte Exception: ", ex);
					}

					//activate buttons
					setDVDGroupButtonSaveCancel();
					refreshDVDOverviewTable(textDVDSearch.getText());
				}

			});

			buttonDVDCancel = new Button(compositeButtons, SWT.PUSH
					| SWT.CENTER);
			buttonDVDCancel.setText(l.getString("button.cancel"));
			buttonDVDCancel.setEnabled(false);
			buttonDVDCancel.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					if (logger.isDebugEnabled()) {
						logger
								.debug("widgetSelected(SelectionEvent) - buttonDVDCancel.widgetSelected, event="
										+ evt);
					}
					setDVDGroupButtonSaveCancel();
				}
			});
		}

    }


    /**
     * 
     */
    private void setDVDGroupButtonSaveCancel() {
		textDVDBarcode.setEditable(false);
		textDVDSearch.setEditable(true);
		comboDVDMovie.setEnabled(false);
		comboDVDPayment.setEnabled(false);
		comboDVDStatus.setEnabled(false);
		comboDVDCondition.setEnabled(false);
		
		buttonDVDCancel.setEnabled(false);
		buttonDVDSave.setEnabled(false);
		buttonDVDNew.setEnabled(true);
		buttonDVDEdit.setEnabled(false);
		buttonDVDDelete.setEnabled(false);
		buttonDVDAddLanguages.setEnabled(false);
		buttonDVDDeleteLanguages.setEnabled(false);
		buttonDVDAddSubtitles.setEnabled(false);
		buttonDVDDeleteSubtitles.setEnabled(false);
		buttonDVDAddVideoformat.setEnabled(false);
		buttonDVDDeleteVideoformat.setEnabled(false);
		buttonDVDAddAudioformat.setEnabled(false);
		buttonDVDDeleteAudioformat.setEnabled(false);

		tableDVDOverview.setEnabled(true);
		tableDVDLanguagesDetail.removeAll();
		tableDVDSubtitlesDetail.removeAll();
		tableDVDVideoformatDetail.removeAll();
		tableDVDAudioformatDetail.removeAll();

        
    }

    /**
     * @param localdvd2
     */
    private void insertIntoDVDOverviewTable(Dvd localdvd2) {
//      TODO Auto-generated method stub
		TableItem item = new TableItem(tableDVDOverview, SWT.NONE);
		item.setText(new String[] {
				localdvd2.getDvdId() + " ",
				localdvd2.getMovie().getTitle() + " ",
				localdvd2.getPaymentCategory().getName() + " ",
				localdvd2.getStatus().getStatusName()});
        
    }

    /**
     * @param text
     */
    private void refreshDVDOverviewTable(String filter) {
        if (tableDVDOverview == null) {
			if (logger.isDebugEnabled()) {
				logger
						.debug("refreshDVDOverviewTable(String) - Konnte DVDOverviewtable nicht refreshen, da diese null ist!");
			}
			return;
		}
		if (logger.isDebugEnabled()) {
			logger
					.debug("refreshDVDOverviewTable(String) - Versuche nun DVDOverviewtable zu refreshen. Filter: "
							+ filter);
		}
		tableDVDOverview.removeAll();
		TableItem item;
		java.util.List DVDlist = Database.getDVD(filter);

		for (int i = 0; i < DVDlist.size(); i++) {

			Dvd o = (Dvd) DVDlist.get(i);
			item = new TableItem(tableDVDOverview, SWT.NONE);
			item.setText(new String[] {
					o.getDvdId() + "",
					o.getMovie().getTitle()+"",
					o.getStatus().getStatusName()+"",
					o.getCondition().getConditionName()+""
					 });

		}

    }
  
    
    /**
     * @param text
     */
    protected void refreshDVDDetail(String id) {
        // TODO Auto-generated method stub
        Dvd object;
		try {
			//since we only can get a String value from the table, we
			//need to convert this
			object = Database.getSingleDVD(Integer.parseInt(id));

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
		localdvd = object;
		textDVDID.setText(object.getDvdId() + "");
		textDVDBarcode.setText(object.getBarcode());
		comboDVDMovie.setText(object.getMovie().getTitle());
		comboDVDPayment.setText(object.getPaymentCategory().getName());
		comboDVDStatus.setText(object.getStatus().getStatusName());
		comboDVDCondition.setText(object.getCondition().getConditionName());
		
		TableItem item;
		// Fill Directorstable
		tableDVDLanguagesDetail.removeAll();
		for (int i = 0; i < object.getLanguages().size(); i++) {
			Language o = (Language) object.getLanguages().get(i);
			item = new TableItem(tableDVDLanguagesDetail, SWT.NONE);
			item.setText(new String[] { o.getLanguageId() + "",
					o.getName()});
		}

		//Fill Actorstable
		tableDVDSubtitlesDetail.removeAll();
		for (int i = 0; i < object.getSubtitles().size(); i++) {
			Subtitle o = (Subtitle) object.getSubtitles().get(i);
			item = new TableItem(tableDVDSubtitlesDetail, SWT.NONE);
			item.setText(new String[] { o.getSubtitleId() + "",
					o.getName()  });
		}

		//Fill Genretable
		tableDVDVideoformatDetail.removeAll();
		logger.debug("Anzahl der Videoformate: " + object.getVideoFormats().size());
		for (int i = 0; i < object.getVideoFormats().size(); i++) {
			VideoFormat o = (VideoFormat) object.getVideoFormats().get(i);
			logger.debug(i + " " + o);
			item = new TableItem(tableDVDVideoformatDetail, SWT.NONE);
			item.setText(new String[] { o.getVideoFormatId() + "",
							o.getName() + "" });
		}

		//Fill Imagetable
		tableDVDAudioformatDetail.removeAll();
		logger.debug("Anzahl der Audioformate: " + object.getAudioFormats().size());
		for (int i = 0; i < object.getAudioFormats().size(); i++) {
			AudioFormat o = (AudioFormat) object.getAudioFormats().get(i);
			item = new TableItem(tableDVDAudioformatDetail, SWT.NONE);
			item.setText(new String[] { o.getAudioFormatId() + "",
					o.getName() + "" });
		}

		//Enable Buttons for Delete and Edit
		buttonDVDEdit.setEnabled(true);
		buttonDVDDelete.setEnabled(true);

		//Change mode to view
		mode_dvd = ManagementGui.MODE_VIEW;
    }

	private List validateInput() {
		List errors = new ArrayList();

		if (textDVDBarcode.getText().trim().equalsIgnoreCase("")) {
			errors.add(l
					.getString("dvd.groupdetail.savebutton.warn.nobarcode"));
		}

		if (comboDVDMovie.getText().compareToIgnoreCase("") == 0) {
			errors
					.add(l.getString("dvd.groupdetail.savebutton.warn.nomovie"));
		}

		if (comboDVDPayment.getText().compareToIgnoreCase("") == 0) {
			errors
					.add(l
							.getString("dvd.groupdetail.savebutton.warn.nopayment"));
		}

		if (comboDVDCondition.getText().compareToIgnoreCase("") == 0) {
			errors
					.add(l
							.getString("dvd.groupdetail.savebutton.warn.nocondition"));
		}

		if (comboDVDStatus.getText().compareToIgnoreCase("") == 0) {
			errors.add(l
					.getString("dvd.groupdetail.savebutton.warn.nostatus"));
		}

		if (localdvd.getLanguages().size() == 0) {
			errors.add(l
					.getString("dvd.groupdetail.savebutton.warn.nolanguage"));
		}

		if (localdvd.getSubtitles().size() == 0) {
			errors.add(l
					.getString("dvd.groupdetail.savebutton.warn.nosubtitle"));
		}

		if (localdvd.getVideoFormats().size() == 0) {
			errors.add(l
					.getString("dvd.groupdetail.savebutton.warn.novideoformat"));
		}
		
		if (localdvd.getAudioFormats().size() == 0) {
			errors.add(l
					.getString("dvd.groupdetail.savebutton.warn.noaudioformat"));
		}
		return errors;
	}
    
}


package de.hsharz.provirent.management.gui;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import org.vafada.swtcalendar.SWTCalendarEvent;
import org.vafada.swtcalendar.SWTCalendarListener;

import com.cloudgarden.resource.SWTResourceManager;

import de.hsharz.provirent.objects.Actor;
import de.hsharz.provirent.objects.Director;
import de.hsharz.provirent.objects.Genre;
import de.hsharz.provirent.objects.Image;
import de.hsharz.provirent.objects.Movie;
import de.hsharz.provirent.persistence.DataBaseException;
import de.hsharz.provirent.persistence.Database;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder,
 * which is free for non-commercial use. If Jigloo is being used commercially
 * (ie, by a corporation, company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo. Please visit
 * www.cloudgarden.com for details. Use of Jigloo implies acceptance of these
 * licensing terms. ************************************* A COMMERCIAL LICENSE
 * HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be
 * used legally for any corporate or commercial purpose.
 * *************************************
 */
public class CompositeMovie extends
		de.hsharz.provirent.management.gui.AbstractComposite {

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CompositeMovie.class);

	private final static int MODE_VIEW = 0;

	private final static int MODE_ADD = 1;

	private final static int MODE_EDIT = 2;

	private Table tableMoviesOverview;

	private Table tableMoviesDirectorsDetail;

	private Table tableMoviesActorsDetail;

	private Table tableMoviesGenresDetail;

	private Table tableMoviesImagesDetail;

	private TableColumn tableMoviesDetail_ColumnID;

	private TableColumn tableMoviesDetail_ColumnName;

	private TableColumn tableMoviesOverview_ColumnID;

	private TableColumn tableMoviesOverview_ColumnTitle;

	private TableColumn tableMoviesOverview_ColumnDate;

	private Group groupMovie;

	private Group groupMoviesOverview;

	private Group groupMoviesDetail;

	private Text textMoviesSearch;

	private Text textMoviesID;

	private Text textMoviesTitle;

	private Text textMoviesRuntime;

	private Text textMoviesDescription;

	private Text textMoviesDate;

	private Text textMoviesmainImage;

	private Label labelMoviesSearch;

	private Label labelMoviesID;

	private Label labelMoviesTitle;

	private Label labelMoviesRuntime;

	private Label labelMoviesDate;

	private Label labelMoviesDescription;

	private Label labelMoviesDirectors;

	private Label labelMoviesActors;

	private Label labelMoviesGenres;

	private Label labelMoviesImages;

	private Label labelMoviesmainImage;

	private Button buttonMoviesNew;

	private Button buttonMoviesSave;

	private Button buttonMoviesEdit;

	private Button buttonMoviesCancel;

	private Button buttonMoviesDelete;

	private Button buttonMoviesFill;

	private Button buttonMoviesAddActors;

	private Button buttonMoviesDeleteActors;

	private Button buttonMoviesAddDirectors;

	private Button buttonMoviesDeleteDirectors;

	private Button buttonMoviesAddGenres;

	private Button buttonMoviesDeleteGenres;

	private Button buttonMoviesAddImages;

	private Button buttonMoviesDeleteImages;

	private Button buttonMoviesChangeDate;

	private Button buttonMoviesChangemainImage;

	private SashForm sashForm1;

	private Composite parent;

	private Composite compositeButtons;

	private Composite compositeMoviesEditDirectors;

	private Composite compositeMoviesEditActors;

	private Composite compositeMoviesEditGenres;

	private Composite compositeMoviesEditImages;

	private int mode_movie;

	private StatusLineStyledText statusLine;

	private ResourceBundle l;

	private Locale locale;

	private Movie localmovie;

	/*
	 * Ändert die Sprache aller Elemente
	 * 
	 * @see de.hsharz.provirent.managment.gui.AbstractComposite#changeLanguage(java.util.Locale)
	 */
	public void changeLanguage(Locale locale) {

	}

	/*
	 * Init die Sprache (properties Datei)
	 * 
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

	public CompositeMovie(Composite p, int style, StatusLineStyledText status,
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
		this.setSize(824, 634);
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
			groupMoviesOverview = new Group(sashForm1, SWT.NONE);
			GridLayout group1Layout = new GridLayout();
			group1Layout.numColumns = 8;
			groupMoviesOverview.setLayout(group1Layout);
			groupMoviesOverview.setText(l
					.getString("movies.groupoverview.label"));

			{// table Actors Overview
				tableMoviesOverview = new Table(groupMoviesOverview, SWT.SINGLE
						| SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.BORDER);
				GridData tableMoviesOverviewLData = new GridData();
				tableMoviesOverview.setHeaderVisible(true);
				tableMoviesOverview.setLinesVisible(true);
				tableMoviesOverviewLData.horizontalAlignment = GridData.FILL;
				tableMoviesOverviewLData.verticalAlignment = GridData.FILL;
				tableMoviesOverviewLData.horizontalSpan = 8;
				tableMoviesOverviewLData.grabExcessHorizontalSpace = true;
				tableMoviesOverviewLData.grabExcessVerticalSpace = true;
				tableMoviesOverview.setLayoutData(tableMoviesOverviewLData);
				tableMoviesOverview
						.addSelectionListener(new SelectionAdapter() {
							public void widgetSelected(SelectionEvent evt) {
								int index = tableMoviesOverview
										.getSelectionIndex();

								//es wurde ein Element aus Tabelle ausgewaehlt
								// jetzt muss die
								//Detailansicht aktualisiert werden
								refreshMoviesDetail(tableMoviesOverview
										.getItem(index).getText(0));
							}
						});
				{
					tableMoviesOverview_ColumnID = new TableColumn(
							tableMoviesOverview, SWT.CENTER);
					tableMoviesOverview_ColumnID.setText(l
							.getString("movies.groupoverview.columnid"));
					tableMoviesOverview_ColumnID.setWidth(40);
				}
				{
					tableMoviesOverview_ColumnTitle = new TableColumn(
							tableMoviesOverview, SWT.CENTER);
					tableMoviesOverview_ColumnTitle.setText(l
							.getString("movies.groupoverview.columntitle"));
					tableMoviesOverview_ColumnTitle.setWidth(120);
				}
				{
					tableMoviesOverview_ColumnDate = new TableColumn(
							tableMoviesOverview, SWT.CENTER);
					tableMoviesOverview_ColumnDate.setText(l
							.getString("movies.groupoverview.columndate"));
					tableMoviesOverview_ColumnDate.setWidth(120);
				}
			}// table Movies Overview

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
							logger.debug("focusLost(FocusEvent evt = " + evt
									+ " " + textMoviesSearch.getText()
									+ ") - start");
						}

						refreshMoviesOverviewTable(textMoviesSearch.getText());

						if (logger.isDebugEnabled()) {
							logger.debug("focusLost(FocusEvent) - end");
						}
					}
				});
				textMoviesSearch.addListener(SWT.DefaultSelection,
						new Listener() {
							public void handleEvent(Event e) {
								if (logger.isDebugEnabled()) {
									logger.debug("handleEvent(Event e = " + e
											+ " " + textMoviesSearch.getText()
											+ ") - start");
								}

								refreshMoviesOverviewTable(textMoviesSearch
										.getText());

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
			groupMoviesDetail = new Group(sashForm1, SWT.H_SCROLL);
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
			labelMoviesID.setText(l.getString("movies.groupdetail.labelid")
					+ ":");
			labelMoviesID.setSize(125, 15);
			GridData formData2 = new GridData();
			formData2.heightHint = 15;
			formData2.horizontalAlignment = GridData.FILL;
			formData2.verticalAlignment = GridData.BEGINNING;
			labelMoviesID.setLayoutData(formData2);
		}
		{
			textMoviesID = new Text(groupMoviesDetail, SWT.READ_ONLY
					| SWT.BORDER);
			GridData text1LData1 = new GridData();
			text1LData1.horizontalAlignment = GridData.FILL;
			text1LData1.heightHint = 13;
			text1LData1.horizontalSpan = 5;
			text1LData1.grabExcessHorizontalSpace = true;
			textMoviesID.setLayoutData(text1LData1);
		}
		{
			labelMoviesTitle = new Label(groupMoviesDetail, SWT.NONE);
			labelMoviesTitle.setText(l
					.getString("movies.groupdetail.labeltitle")
					+ ":");
			labelMoviesTitle.setSize(125, 15);
			GridData labelActorNameLData = new GridData();
			labelActorNameLData.heightHint = 15;
			labelActorNameLData.horizontalAlignment = GridData.FILL;
			labelActorNameLData.verticalAlignment = GridData.BEGINNING;
			labelMoviesTitle.setLayoutData(labelActorNameLData);
		}
		{
			textMoviesTitle = new Text(groupMoviesDetail, SWT.READ_ONLY
					| SWT.BORDER);
			GridData text1LData2 = new GridData();
			text1LData2.horizontalAlignment = GridData.FILL;
			text1LData2.heightHint = 13;
			text1LData2.horizontalSpan = 5;
			text1LData2.grabExcessHorizontalSpace = true;
			textMoviesTitle.setLayoutData(text1LData2);
		}
		{
			labelMoviesRuntime = new Label(groupMoviesDetail, SWT.NONE);
			labelMoviesRuntime.setText(l
					.getString("movies.groupdetail.labelruntime")
					+ ":");
			labelMoviesRuntime.setSize(125, 15);
			GridData labelRuntimeLData = new GridData();
			labelRuntimeLData.heightHint = 15;
			labelRuntimeLData.horizontalAlignment = GridData.FILL;
			labelRuntimeLData.verticalAlignment = GridData.BEGINNING;
			labelMoviesRuntime.setLayoutData(labelRuntimeLData);
		}
		{
			textMoviesRuntime = new Text(groupMoviesDetail, SWT.READ_ONLY
					| SWT.BORDER);
			GridData text1LData2 = new GridData();
			text1LData2.horizontalAlignment = GridData.FILL;
			text1LData2.heightHint = 13;
			text1LData2.horizontalSpan = 5;
			text1LData2.grabExcessHorizontalSpace = true;
			textMoviesRuntime.setLayoutData(text1LData2);
		}
		{
			labelMoviesDate = new Label(groupMoviesDetail, SWT.NONE);
			labelMoviesDate.setText(l.getString("movies.groupdetail.labeldate")
					+ ":");
			labelMoviesDate.setSize(125, 15);
			GridData labelMoviesDateLData = new GridData();
			labelMoviesDateLData.heightHint = 15;
			labelMoviesDateLData.horizontalAlignment = GridData.FILL;
			labelMoviesDateLData.verticalAlignment = GridData.BEGINNING;
			labelMoviesDate.setLayoutData(labelMoviesDateLData);
		}
		{
			textMoviesDate = new Text(groupMoviesDetail, SWT.READ_ONLY
					| SWT.BORDER);
			GridData text1LData2 = new GridData();
			text1LData2.horizontalAlignment = GridData.FILL;
			text1LData2.heightHint = 13;
			text1LData2.horizontalSpan = 4;
			text1LData2.grabExcessHorizontalSpace = true;
			textMoviesDate.setLayoutData(text1LData2);
			textMoviesDate.setText(l.getString("movies.groupdetail.textdate"));
		}
		{
			buttonMoviesChangeDate = new Button(groupMoviesDetail, SWT.NONE);
			buttonMoviesChangeDate.setText(l
					.getString("movies.button.changedate"));
			buttonMoviesChangeDate.setEnabled(false);
			GridData text1LData2 = new GridData();
			text1LData2.horizontalAlignment = GridData.FILL;
			text1LData2.heightHint = 20;
			text1LData2.horizontalSpan = 1;
			buttonMoviesChangeDate.setLayoutData(text1LData2);
			buttonMoviesChangeDate.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					//open responsible Dialog and insert text
					final SWTCalendarDialog cal = new SWTCalendarDialog(
							getDisplay(),
							l.getString("movies.groupdetail.datebuttonfinish"),
							l.getString("movies.groupdetail.datedialogtitle"));

					cal.addDateChangedListener(new SWTCalendarListener() {
						public void dateChanged(SWTCalendarEvent calendarEvent) {
							textMoviesDate.setText(DateFormat.getDateInstance(
									DateFormat.LONG).format(
									calendarEvent.getCalendar().getTime()));
						}
					});

					if (textMoviesDate.getText() != null
							&& textMoviesDate.getText().length() > 0) {
						try {
							cal.setDate(DateFormat.getDateInstance(
									DateFormat.LONG).parse(
									textMoviesDate.getText()));
						} catch (ParseException pe) {
							cal.setDate(new Date());
						}
					}
					cal.open();
				}
			});
		}
		//labels and buttons for Detail
		{
			labelMoviesDescription = new Label(groupMoviesDetail, SWT.NONE);
			labelMoviesDescription.setText(l
					.getString("movies.groupdetail.labeldescription"));
			GridData formData2 = new GridData();
			formData2.verticalSpan = 5;
			formData2.verticalAlignment = GridData.BEGINNING;
			labelMoviesDescription.setLayoutData(formData2);
		}
		{
			textMoviesDescription = new Text(groupMoviesDetail, SWT.MULTI
					| SWT.READ_ONLY | SWT.V_SCROLL | SWT.BORDER);
			GridData formData2 = new GridData();
			formData2.horizontalSpan = 5;
			formData2.verticalSpan = 5;
			formData2.verticalAlignment = GridData.FILL;
			formData2.horizontalAlignment = GridData.FILL;
			textMoviesDescription.setLayoutData(formData2);
		}
		//      EditDirectors
		{

			compositeMoviesEditDirectors = new Composite(groupMoviesDetail,
					SWT.NONE);
			GridLayout composite1Layout = new GridLayout();
			GridData composite1LData = new GridData();
			composite1LData.horizontalAlignment = GridData.FILL;
			composite1LData.verticalAlignment = GridData.BEGINNING;
			compositeMoviesEditDirectors.setLayoutData(composite1LData);
			composite1Layout.numColumns = 2;
			compositeMoviesEditDirectors.setLayout(composite1Layout);
		}
		{
			labelMoviesDirectors = new Label(compositeMoviesEditDirectors,
					SWT.NONE);
			labelMoviesDirectors.setText(l
					.getString("movies.groupdetail.labeldirectors"));
			GridData formData2 = new GridData();
			formData2.horizontalSpan = 2;
			formData2.verticalSpan = 1;
			labelMoviesDirectors.setLayoutData(formData2);
		}
		{
			buttonMoviesAddDirectors = new Button(compositeMoviesEditDirectors,
					SWT.NONE);
			buttonMoviesAddDirectors.setText(l
					.getString("movies.button.additem"));
			buttonMoviesAddDirectors.setEnabled(false);
			GridData text1LData2 = new GridData();
			text1LData2.heightHint = 20;
			text1LData2.horizontalSpan = 1;
			text1LData2.horizontalAlignment = GridData.BEGINNING;
			buttonMoviesAddDirectors.setLayoutData(text1LData2);
			buttonMoviesAddDirectors
					.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							//open responsible Dialog and insert objects into
							// table
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

						}
					});
		}
		{
			buttonMoviesDeleteDirectors = new Button(
					compositeMoviesEditDirectors, SWT.NONE);
			buttonMoviesDeleteDirectors.setText(l
					.getString("movies.button.deleteitem"));
			buttonMoviesDeleteDirectors.setEnabled(false);
			GridData text1LData2 = new GridData();
			text1LData2.horizontalAlignment = GridData.BEGINNING;
			text1LData2.heightHint = 20;
			text1LData2.horizontalSpan = 1;
			buttonMoviesDeleteDirectors.setLayoutData(text1LData2);
			buttonMoviesDeleteDirectors
					.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							//get selected Item
							//get id from object
							//search for id in list and delete object
							//remove table entry
							int index = tableMoviesDirectorsDetail
									.getSelectionIndex();
							if (index >= 0) {
								String strid = tableMoviesDirectorsDetail
										.getItem(index).getText(0);
								int id = Integer.parseInt(strid);
								for (int i = 0; i < localmovie.getDirector()
										.size(); i++) {
									Director o = (Director) localmovie
											.getDirector().get(i);
									if (o.getDirectorId().intValue() == id) {
										localmovie.getDirector().remove(o);
										break;
									}
								}
								tableMoviesDirectorsDetail.remove(index);
							}
						}
					});
		}
		{
			tableMoviesDirectorsDetail = new Table(groupMoviesDetail,
					SWT.SINGLE | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.BORDER);
			//tableMoviesDirectorsDetail.setHeaderVisible(true);
			//tableMoviesDirectorsDetail.setLinesVisible(true);
			GridData tableMoviesDirectorsDetailLData = new GridData();
			tableMoviesDirectorsDetailLData.horizontalAlignment = GridData.FILL;
			tableMoviesDirectorsDetailLData.horizontalSpan = 5;
			tableMoviesDirectorsDetailLData.grabExcessVerticalSpace = true;
			tableMoviesDirectorsDetailLData.verticalAlignment = GridData.FILL;
			tableMoviesDirectorsDetail
					.setLayoutData(tableMoviesDirectorsDetailLData);

			{
				tableMoviesDetail_ColumnID = new TableColumn(
						tableMoviesDirectorsDetail, SWT.CENTER);
				tableMoviesDetail_ColumnID.setWidth(0);
				tableMoviesDetail_ColumnID.setResizable(false);
			}
			{
				tableMoviesDetail_ColumnName = new TableColumn(
						tableMoviesDirectorsDetail, SWT.LEFT);
				tableMoviesDetail_ColumnName
						.setText(l
								.getString("movies.groupoverviewdetail.columndirectors"));
				tableMoviesDetail_ColumnName.setWidth(200);
			}
		}// EditDirectors
		// Edit Actors
		{
			compositeMoviesEditActors = new Composite(groupMoviesDetail,
					SWT.NONE);
			GridLayout composite1Layout = new GridLayout();
			GridData composite1LData = new GridData();
			composite1LData.horizontalAlignment = GridData.FILL;
			composite1LData.verticalAlignment = GridData.BEGINNING;
			compositeMoviesEditActors.setLayoutData(composite1LData);
			composite1Layout.numColumns = 2;
			compositeMoviesEditActors.setLayout(composite1Layout);
		}

		{
			labelMoviesActors = new Label(compositeMoviesEditActors, SWT.NONE);
			labelMoviesActors.setText(l
					.getString("movies.groupdetail.labelactors"));
			GridData formData2 = new GridData();
			formData2.horizontalSpan = 2;
			formData2.verticalSpan = 1;
			labelMoviesActors.setLayoutData(formData2);
		}
		{
			buttonMoviesAddActors = new Button(compositeMoviesEditActors,
					SWT.NONE);
			buttonMoviesAddActors.setText(l.getString("movies.button.additem"));
			buttonMoviesAddActors.setEnabled(false);
			GridData text1LData2 = new GridData();
			text1LData2.heightHint = 20;
			text1LData2.horizontalSpan = 1;
			text1LData2.horizontalAlignment = GridData.BEGINNING;
			buttonMoviesAddActors.setLayoutData(text1LData2);
			buttonMoviesAddActors.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					//open responsible Dialog and insert objects into table
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
				}
			});
		}
		{
			buttonMoviesDeleteActors = new Button(compositeMoviesEditActors,
					SWT.NONE);
			buttonMoviesDeleteActors.setText(l
					.getString("movies.button.deleteitem"));
			buttonMoviesDeleteActors.setEnabled(false);
			GridData text1LData2 = new GridData();
			text1LData2.horizontalAlignment = GridData.BEGINNING;
			text1LData2.heightHint = 20;
			text1LData2.horizontalSpan = 1;
			buttonMoviesDeleteActors.setLayoutData(text1LData2);
			buttonMoviesDeleteActors
					.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							//get selected Item
							//get id from object
							//search for id in list and delete object
							//remove table entry
							int index = tableMoviesActorsDetail
									.getSelectionIndex();
							if (index >= 0) {
								String strid = tableMoviesActorsDetail.getItem(
										index).getText(0);
								int id = Integer.parseInt(strid);
								for (int i = 0; i < localmovie.getActors()
										.size(); i++) {
									Actor o = (Actor) localmovie.getActors()
											.get(i);
									if (o.getActorId().intValue() == id) {
										localmovie.getActors().remove(o);
										break;
									}
								}
								tableMoviesActorsDetail.remove(index);
							}
						}
					});
		}
		{
			tableMoviesActorsDetail = new Table(groupMoviesDetail, SWT.SINGLE
					| SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.BORDER);
			//tableMoviesActorsDetail.setHeaderVisible(true);
			//tableMoviesActorsDetail.setLinesVisible(true);
			GridData tableMoviesActorsDetailLData = new GridData();
			tableMoviesActorsDetailLData.horizontalAlignment = GridData.FILL;
			tableMoviesActorsDetailLData.horizontalSpan = 5;
			tableMoviesActorsDetailLData.grabExcessVerticalSpace = true;
			tableMoviesActorsDetailLData.verticalAlignment = GridData.FILL;
			tableMoviesActorsDetail.setLayoutData(tableMoviesActorsDetailLData);

			{
				tableMoviesDetail_ColumnID = new TableColumn(
						tableMoviesActorsDetail, SWT.CENTER);
				tableMoviesDetail_ColumnID.setWidth(0);
				tableMoviesDetail_ColumnID.setResizable(false);
			}
			{
				tableMoviesDetail_ColumnName = new TableColumn(
						tableMoviesActorsDetail, SWT.LEFT);
				tableMoviesDetail_ColumnName.setText(l
						.getString("movies.groupoverviewdetail.columnactors"));
				tableMoviesDetail_ColumnName.setWidth(200);
			}
		}//Edit Actors
		//Edit Genres
		{
			compositeMoviesEditGenres = new Composite(groupMoviesDetail,
					SWT.NONE);
			GridLayout composite1Layout = new GridLayout();
			GridData composite1LData = new GridData();
			composite1LData.horizontalAlignment = GridData.FILL;
			composite1LData.verticalAlignment = GridData.BEGINNING;
			compositeMoviesEditGenres.setLayoutData(composite1LData);
			composite1Layout.numColumns = 2;
			compositeMoviesEditGenres.setLayout(composite1Layout);
		}

		{
			labelMoviesGenres = new Label(compositeMoviesEditGenres, SWT.NONE);
			labelMoviesGenres.setText(l
					.getString("movies.groupdetail.labelgenres"));
			GridData formData2 = new GridData();
			formData2.horizontalSpan = 2;
			formData2.verticalSpan = 1;
			labelMoviesGenres.setLayoutData(formData2);
		}
		{
			buttonMoviesAddGenres = new Button(compositeMoviesEditGenres,
					SWT.NONE);
			buttonMoviesAddGenres.setText(l.getString("movies.button.additem"));
			buttonMoviesAddGenres.setEnabled(false);
			GridData text1LData2 = new GridData();
			text1LData2.heightHint = 20;
			text1LData2.horizontalSpan = 1;
			text1LData2.horizontalAlignment = GridData.BEGINNING;
			buttonMoviesAddGenres.setLayoutData(text1LData2);
			buttonMoviesAddGenres.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					//open responsible Dialog and insert objects into table
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
				}
			});
		}
		{
			buttonMoviesDeleteGenres = new Button(compositeMoviesEditGenres,
					SWT.NONE);
			buttonMoviesDeleteGenres.setText(l
					.getString("movies.button.deleteitem"));
			buttonMoviesDeleteGenres.setEnabled(false);
			GridData text1LData2 = new GridData();
			text1LData2.horizontalAlignment = GridData.BEGINNING;
			text1LData2.heightHint = 20;
			text1LData2.horizontalSpan = 1;
			buttonMoviesDeleteGenres.setLayoutData(text1LData2);
			buttonMoviesDeleteGenres
					.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							//get selected Item
							//get id from object
							//search for id in list and delete object
							//remove table entry
							int index = tableMoviesGenresDetail
									.getSelectionIndex();
							if (index >= 0) {
								String strid = tableMoviesGenresDetail.getItem(
										index).getText(0);
								int id = Integer.parseInt(strid);
								for (int i = 0; i < localmovie.getGenres()
										.size(); i++) {
									Genre o = (Genre) localmovie.getGenres()
											.get(i);
									if (o.getGenreId().intValue() == id) {
										localmovie.getGenres().remove(o);
										break;
									}
								}
								tableMoviesGenresDetail.remove(index);
							}
						}
					});
		}
		{
			tableMoviesGenresDetail = new Table(groupMoviesDetail, SWT.SINGLE
					| SWT.FULL_SELECTION | SWT.BORDER);
			//tableMoviesGenresDetail.setHeaderVisible(true);
			//tableMoviesGenresDetail.setLinesVisible(true);
			GridData tableMoviesGenresDetailLData = new GridData();
			tableMoviesGenresDetailLData.horizontalAlignment = GridData.FILL;
			tableMoviesGenresDetailLData.horizontalSpan = 5;
			tableMoviesGenresDetailLData.grabExcessVerticalSpace = true;
			tableMoviesGenresDetailLData.verticalAlignment = GridData.FILL;
			tableMoviesGenresDetail.setLayoutData(tableMoviesGenresDetailLData);

			{
				tableMoviesDetail_ColumnID = new TableColumn(
						tableMoviesGenresDetail, SWT.CENTER);
				tableMoviesDetail_ColumnID.setWidth(0);
				tableMoviesDetail_ColumnID.setResizable(false);
			}
			{
				tableMoviesDetail_ColumnName = new TableColumn(
						tableMoviesGenresDetail, SWT.LEFT);
				tableMoviesDetail_ColumnName.setText(l
						.getString("movies.groupoverviewdetail.columngenres"));
				tableMoviesDetail_ColumnName.setWidth(200);
			}
		}// Edit Genre
		// Edit Images
		{
			compositeMoviesEditImages = new Composite(groupMoviesDetail,
					SWT.NONE);
			GridLayout composite1Layout = new GridLayout();
			GridData composite1LData = new GridData();
			composite1LData.horizontalAlignment = GridData.FILL;
			composite1LData.verticalAlignment = GridData.BEGINNING;
			compositeMoviesEditImages.setLayoutData(composite1LData);
			composite1Layout.numColumns = 2;
			compositeMoviesEditImages.setLayout(composite1Layout);
		}

		{
			labelMoviesImages = new Label(compositeMoviesEditImages, SWT.NONE);
			labelMoviesImages.setText(l
					.getString("movies.groupdetail.labelimages"));
			GridData formData2 = new GridData();
			formData2.horizontalSpan = 2;
			formData2.verticalSpan = 1;
			labelMoviesImages.setLayoutData(formData2);
		}
		{
			buttonMoviesAddImages = new Button(compositeMoviesEditImages,
					SWT.NONE);
			buttonMoviesAddImages.setText(l.getString("movies.button.additem"));
			buttonMoviesAddImages.setEnabled(false);
			GridData text1LData2 = new GridData();
			text1LData2.heightHint = 20;
			text1LData2.horizontalSpan = 1;
			text1LData2.horizontalAlignment = GridData.BEGINNING;
			buttonMoviesAddImages.setLayoutData(text1LData2);
			buttonMoviesAddImages.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					//open responsible Dialog and insert objects into table
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
				}
			});
		}
		{
			buttonMoviesDeleteImages = new Button(compositeMoviesEditImages,
					SWT.NONE);
			buttonMoviesDeleteImages.setText(l
					.getString("movies.button.deleteitem"));
			buttonMoviesDeleteImages.setEnabled(false);
			GridData text1LData2 = new GridData();
			text1LData2.horizontalAlignment = GridData.BEGINNING;
			text1LData2.heightHint = 20;
			text1LData2.horizontalSpan = 1;
			buttonMoviesDeleteImages.setLayoutData(text1LData2);
			buttonMoviesDeleteImages
					.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							//get selected Item
							//get id from object
							//search for id in list and delete object
							//remove table entry
							int index = tableMoviesImagesDetail
									.getSelectionIndex();
							if (index >= 0) {
								String strid = tableMoviesImagesDetail.getItem(
										index).getText(0);
								int id = Integer.parseInt(strid);
								for (int i = 0; i < localmovie.getImages()
										.size(); i++) {
									Image o = (Image) localmovie.getImages()
											.get(i);
									if (o.getImageId().intValue() == id) {
										localmovie.getImages().remove(o);
										break;
									}
								}
								tableMoviesImagesDetail.remove(index);
							}

						}
					});
		}
		{
			tableMoviesImagesDetail = new Table(groupMoviesDetail, SWT.SINGLE
					| SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.BORDER);
			//tableMoviesImagesDetail.setHeaderVisible(true);
			//tableMoviesImagesDetail.setLinesVisible(true);
			GridData tableMoviesImagesDetailLData = new GridData();
			tableMoviesImagesDetailLData.horizontalAlignment = GridData.FILL;
			tableMoviesImagesDetailLData.horizontalSpan = 5;
			tableMoviesImagesDetailLData.grabExcessVerticalSpace = true;
			tableMoviesImagesDetailLData.verticalAlignment = GridData.FILL;
			tableMoviesImagesDetail.setLayoutData(tableMoviesImagesDetailLData);
			{
				tableMoviesDetail_ColumnID = new TableColumn(
						tableMoviesImagesDetail, SWT.CENTER);
				tableMoviesDetail_ColumnID.setWidth(0);
				tableMoviesDetail_ColumnID.setResizable(false);
			}
			{
				tableMoviesDetail_ColumnName = new TableColumn(
						tableMoviesImagesDetail, SWT.LEFT);
				tableMoviesDetail_ColumnName.setText(l
						.getString("movies.groupoverviewdetail.columnimages"));
				tableMoviesDetail_ColumnName.setWidth(200);
			}
		}// Edit Images
		{
			labelMoviesmainImage = new Label(groupMoviesDetail, SWT.NONE);
			labelMoviesmainImage.setText(l
					.getString("movies.groupdetail.labelmainimage")
					+ ":");
			labelMoviesmainImage.setSize(125, 15);
			GridData labelMoviesImageLData = new GridData();
			labelMoviesImageLData.heightHint = 15;
			labelMoviesImageLData.horizontalAlignment = GridData.FILL;
			labelMoviesImageLData.verticalAlignment = GridData.BEGINNING;
			labelMoviesmainImage.setLayoutData(labelMoviesImageLData);
		}
		{
			textMoviesmainImage = new Text(groupMoviesDetail, SWT.READ_ONLY
					| SWT.BORDER);
			GridData text1LData2 = new GridData();
			text1LData2.horizontalAlignment = GridData.FILL;
			text1LData2.heightHint = 13;
			text1LData2.horizontalSpan = 4;
			text1LData2.grabExcessHorizontalSpace = true;
			textMoviesmainImage.setLayoutData(text1LData2);
			textMoviesmainImage.setText("");
		}
		{
			buttonMoviesChangemainImage = new Button(groupMoviesDetail,
					SWT.NONE);
			buttonMoviesChangemainImage.setText(l
					.getString("movies.button.changedate"));
			buttonMoviesChangemainImage.setEnabled(false);
			GridData text1LData2 = new GridData();
			text1LData2.horizontalAlignment = GridData.FILL;
			text1LData2.heightHint = 20;
			text1LData2.horizontalSpan = 1;
			buttonMoviesChangemainImage.setLayoutData(text1LData2);
			buttonMoviesChangemainImage
					.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							//open responsible Dialog and insert text
							DialogMovie dialog = new DialogMovie(getShell(), 0,
									locale, localmovie,
									DialogMovie.TYPE_MAINIMAGE);
							dialog.open();
							if (localmovie.getMainImage() != null)
								textMoviesmainImage.setText(localmovie
										.getMainImage().getImageFileName());
						}
					});
		}

		{
			compositeButtons = new Composite(groupMoviesDetail, SWT.EMBEDDED);
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
			buttonMoviesNew = new Button(compositeButtons, SWT.PUSH
					| SWT.CENTER);
			buttonMoviesNew.setText(l.getString("button.new"));
			buttonMoviesNew.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {

					mode_movie = ManagementGui.MODE_ADD;

					textMoviesID.setText("");
					textMoviesTitle.setText("");
					textMoviesRuntime.setText("");
					textMoviesDate.setText("");
					textMoviesDescription.setText("");
					textMoviesTitle.setEditable(true);
					textMoviesRuntime.setEditable(true);
					textMoviesDescription.setEditable(true);
					textMoviesSearch.setEditable(false);

					buttonMoviesCancel.setEnabled(true);
					buttonMoviesSave.setEnabled(true);
					buttonMoviesNew.setEnabled(false);
					buttonMoviesEdit.setEnabled(false);
					buttonMoviesDelete.setEnabled(false);
					buttonMoviesAddDirectors.setEnabled(true);
					buttonMoviesDeleteDirectors.setEnabled(true);
					buttonMoviesAddActors.setEnabled(true);
					buttonMoviesDeleteActors.setEnabled(true);
					buttonMoviesAddGenres.setEnabled(true);
					buttonMoviesDeleteGenres.setEnabled(true);
					buttonMoviesAddImages.setEnabled(true);
					buttonMoviesDeleteImages.setEnabled(true);
					buttonMoviesChangeDate.setEnabled(true);
					buttonMoviesChangemainImage.setEnabled(true);

					tableMoviesOverview.setEnabled(false);
					tableMoviesDirectorsDetail.removeAll();
					tableMoviesActorsDetail.removeAll();
					tableMoviesImagesDetail.removeAll();
					tableMoviesGenresDetail.removeAll();

					localmovie = new Movie();
					localmovie.setActors(new ArrayList());
					localmovie.setDirector(new ArrayList());
					localmovie.setGenres(new ArrayList());
					localmovie.setImages(new ArrayList());
				}
			});

			buttonMoviesEdit = new Button(compositeButtons, SWT.PUSH
					| SWT.CENTER);
			buttonMoviesEdit.setText(l.getString("button.edit"));
			buttonMoviesEdit.setEnabled(false);
			buttonMoviesEdit.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {

					mode_movie = ManagementGui.MODE_EDIT;

					textMoviesID.setEditable(false);
					textMoviesTitle.setEditable(true);
					textMoviesRuntime.setEditable(true);
					textMoviesTitle.setFocus();
					textMoviesDescription.setEditable(true);
					textMoviesSearch.setEditable(false);

					buttonMoviesCancel.setEnabled(true);
					buttonMoviesSave.setEnabled(true);
					buttonMoviesNew.setEnabled(false);
					buttonMoviesEdit.setEnabled(false);
					buttonMoviesDelete.setEnabled(false);
					buttonMoviesAddDirectors.setEnabled(true);
					buttonMoviesDeleteDirectors.setEnabled(true);
					buttonMoviesAddActors.setEnabled(true);
					buttonMoviesDeleteActors.setEnabled(true);
					buttonMoviesAddGenres.setEnabled(true);
					buttonMoviesDeleteGenres.setEnabled(true);
					buttonMoviesAddImages.setEnabled(true);
					buttonMoviesDeleteImages.setEnabled(true);
					buttonMoviesChangeDate.setEnabled(true);
					buttonMoviesChangemainImage.setEnabled(true);

					tableMoviesOverview.setEnabled(false);

				}
			});

			buttonMoviesDelete = new Button(compositeButtons, SWT.PUSH
					| SWT.CENTER);
			buttonMoviesDelete.setText(l.getString("button.delete"));
			buttonMoviesDelete.setEnabled(false);
			buttonMoviesDelete.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					if (logger.isDebugEnabled()) {
						logger
								.debug("widgetSelected(SelectionEvent) - buttonMoviesDelete.widgetSelected, event="
										+ evt);
					}

					String msg = MessageFormat
							.format(
									l
											.getString("movies.groupdetail.deletebutton.question.text"),
									new Object[] { textMoviesTitle.getText()
											+ " "
											+ l
													.getString("movies.groupdetail.deletebutton.question.gap")
											+ " " + textMoviesDate.getText() });

					int question = showMsg(
							msg,
							l
									.getString("movies.groupdetail.deletebutton.question.header"),
							SWT.ICON_QUESTION | SWT.YES | SWT.NO);

					if (question != SWT.YES) {
						return;
					}

					try {
						//object speichern
						// Fehlerbehandlung
						Database.deleteObject(localmovie);

						//ÜbersichtsTabelle aktualisieren
						refreshMoviesOverviewTable(textMoviesSearch.getText());

						//Detailansicht leeren
						textMoviesID.setText("");
						textMoviesTitle.setText("");
						textMoviesRuntime.setText("");
						textMoviesDate.setText("");
						textMoviesDescription.setText("");
						tableMoviesDirectorsDetail.removeAll();
						tableMoviesActorsDetail.removeAll();
						tableMoviesGenresDetail.removeAll();
						tableMoviesImagesDetail.removeAll();
						//in Tabelle nächsten auswählen
						try {
							tableMoviesOverview.select(0);
						} catch (Exception ex) {
						}

						//Statusline Nachricht sezten
						statusLine
								.setStatus(
										1,
										l
												.getString("movies.groupdetail.deletebutton.newok"));

					} catch (DataBaseException e) {
						if (e.getMessage().equalsIgnoreCase("1")) {
							//Fehler beim Speichern des Objectes

							statusLine
									.setStatus(
											3,
											l
													.getString("movies.groupdetail.deletebutton.errorsave"));
							showMsg(
									l
											.getString("movies.groupdetail.deletebutton.errorsave"),
									l.getString("error"), SWT.ICON_ERROR
											| SWT.OK);

						} else if (e.getMessage().equalsIgnoreCase("2")) {
							//fehler beim db aufbau
							statusLine
									.setStatus(
											3,
											l
													.getString("movies.groupdetail.deletebutton.errordb"));
							showMsg(
									l
											.getString("movies.groupdetail.deletebutton.errordb"),
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
			buttonMoviesFill = new Button(compositeButtons, SWT.PUSH
					| SWT.CENTER);
			GridData buttonActorFillLData = new GridData();
			buttonMoviesFill.setVisible(false);
			buttonMoviesFill.setEnabled(false);
			buttonActorFillLData.widthHint = 30;
			buttonActorFillLData.heightHint = 23;
			buttonMoviesFill.setLayoutData(buttonActorFillLData);

			buttonMoviesSave = new Button(compositeButtons, SWT.PUSH
					| SWT.CENTER);
			buttonMoviesSave.setText(l.getString("button.save"));
			buttonMoviesSave.setEnabled(false);
			buttonMoviesSave.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					if (logger.isDebugEnabled()) {
						logger
								.debug("widgetSelected(SelectionEvent) - buttonMoviesSave.widgetSelected, event="
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
										.getString("movies.groupdetail.savebutton.warn.noitems.msg")
										+ new String(buf),
								l
										.getString("movies.groupdetail.savebutton.warn.noitems.title"),
								SWT.ICON_WARNING | SWT.YES);
						return;

					}

					//testen welcher mode
					localmovie.setTitle(textMoviesTitle.getText());
					localmovie.setDescription(textMoviesDescription.getText());
					try {
						localmovie.setReleaseDate(Calendar.getInstance());
						localmovie.getReleaseDate().setTime(
								DateFormat.getDateInstance(DateFormat.LONG)
										.parse(textMoviesDate.getText()));
						logger.debug("Datum: " + localmovie.getReleaseDate());
					} catch (ParseException e1) {
						//Hier muss noch was gemacht werden, das Datum konnte
						// nicht geparst werden
						logger.error("widgetSelected(SelectionEvent)", e1);
						return;
					}

					try {
						localmovie.setRuntime(Integer
								.parseInt(textMoviesRuntime.getText()));
					} catch (Exception ex) {
						logger.error("widgetSelected(SelectionEvent)", ex);
						showMsg(
								l
										.getString("movies.groupdetail.savebutton.warn.noname.msg"),
								l
										.getString("movies.groupdetail.savebutton.warn.noname.title"),
								SWT.ICON_WARNING | SWT.YES);
						return;
					}
					/**
					 * @todo eine Exception bekommen wieder leider NOCH nicht
					 *       mit d.h. es muss noch ein rückgabewert kommen oder
					 *       eine Exception übermitteln werden (aus der DB
					 *       Klasse)
					 */
					//neues Objekt erzeugen
					try {
						//object speichern
						// Fehlerbehandlung

						if (mode_movie == ManagementGui.MODE_ADD) {

							logger.debug("Objektid: " + localmovie.getMovieId()
									+ " vor speichern");
							Database.saveObject(localmovie);
							logger.debug("Objektid: " + localmovie.getMovieId()
									+ " nach speichern");

							// in Übersichtstabelle einfügen
							insertIntoMoviesOverviewTable(localmovie);
							textMoviesID.setText(localmovie.getMovieId() + "");
						} else if (mode_movie == ManagementGui.MODE_EDIT) {
							Database.updateObject(localmovie);
						}
						//Statusline Nachricht sezten
						statusLine
								.setStatus(
										1,
										l
												.getString("movies.groupdetail.savebutton.newok"));
					} catch (DataBaseException e) {
						logger.debug("DataBaseException: " + e);
						if (e.getMessage().equalsIgnoreCase("1")) {
							//Fehler beim Speichern des Objectes

							statusLine
									.setStatus(
											3,
											l
													.getString("movies.groupdetail.savebutton.errorsave"));
							showMsg(
									l
											.getString("movies.groupdetail.savebutton.errorsave"),
									"Fehler", SWT.ICON_ERROR | SWT.OK);

						} else if (e.getMessage().equalsIgnoreCase("2")) {
							//fehler beim db aufbau
							statusLine
									.setStatus(
											3,
											l
													.getString("movies.groupdetail.savebutton.errordb"));
							showMsg(
									l
											.getString("movies.groupdetail.savebutton.errordb"),
									"Fehler", SWT.ICON_ERROR | SWT.OK);

						} else {
							//@todo
							logger.error("widgetSelected(SelectionEvent)", e);
						}

					} catch (Exception ex) {
						logger.debug("Unbekannte Exception: ", ex);
					}

					//activate buttons
					setMoviesGroupButtonSaveCancel();

				}

			});

			buttonMoviesCancel = new Button(compositeButtons, SWT.PUSH
					| SWT.CENTER);
			buttonMoviesCancel.setText(l.getString("button.cancel"));
			buttonMoviesCancel.setEnabled(false);
			buttonMoviesCancel.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					if (logger.isDebugEnabled()) {
						logger
								.debug("widgetSelected(SelectionEvent) - buttonMoviesCancel.widgetSelected, event="
										+ evt);
					}
					setMoviesGroupButtonSaveCancel();
				}
			});
		}

	}

	/**
	 * @param movie2
	 */
	private void insertIntoMoviesOverviewTable(Movie movie2) {
		// TODO Auto-generated method stub
		TableItem item = new TableItem(tableMoviesOverview, SWT.NONE);
		item.setText(new String[] {
				movie2.getMovieId() + " ",
				movie2.getTitle() + " ",
				DateFormat.getDateInstance(DateFormat.SHORT).format(
						movie2.getReleaseDate().getTime()) });
	}

	/**
	 *  
	 */
	private void setMoviesGroupButtonSaveCancel() {
		tableMoviesOverview.setEnabled(true);
		buttonMoviesCancel.setEnabled(false);
		buttonMoviesSave.setEnabled(false);
		buttonMoviesNew.setEnabled(true);
		buttonMoviesEdit.setEnabled(false);
		buttonMoviesDelete.setEnabled(false);
		buttonMoviesAddDirectors.setEnabled(false);
		buttonMoviesDeleteDirectors.setEnabled(false);
		buttonMoviesAddActors.setEnabled(false);
		buttonMoviesDeleteActors.setEnabled(false);
		buttonMoviesAddGenres.setEnabled(false);
		buttonMoviesDeleteGenres.setEnabled(false);
		buttonMoviesAddImages.setEnabled(false);
		buttonMoviesDeleteImages.setEnabled(false);
		buttonMoviesChangeDate.setEnabled(false);
		buttonMoviesChangemainImage.setEnabled(false);
		textMoviesTitle.setEditable(false);
		textMoviesDescription.setEditable(false);
		textMoviesSearch.setEditable(true);
		textMoviesRuntime.setEditable(false);
	}

	/**
	 * @param text
	 */
	private void refreshMoviesOverviewTable(String filter) {
		// TODO Auto-generated method stub
		if (tableMoviesOverview == null) {
			if (logger.isDebugEnabled()) {
				logger
						.debug("refreshMoviesOverviewTable(String) - Konnte MoviesOverviewtable nicht refreshen, da diese null ist!");
			}
			return;
		}
		if (logger.isDebugEnabled()) {
			logger
					.debug("refreshMoviesOverviewTable(String) - Versuche nun MoviesOverviewtable zu refreshen. Filter: "
							+ filter);
		}
		tableMoviesOverview.removeAll();
		TableItem item;
		java.util.List Movielist = Database.getMovie(filter);

		for (int i = 0; i < Movielist.size(); i++) {

			Movie o = (Movie) Movielist.get(i);
			item = new TableItem(tableMoviesOverview, SWT.NONE);
			item.setText(new String[] {
					o.getMovieId() + "",
					o.getTitle(),
					DateFormat.getDateInstance(DateFormat.SHORT).format(
							o.getReleaseDate().getTime()) });

		}
	}

	/**
	 * @param text
	 */
	private void refreshMoviesDetail(String id) {
		// TODO Auto-generated method stub
		Movie object;
		try {
			//since we only can get a String value from the table, we
			//need to convert this
			object = Database.getSingleMovie(Integer.parseInt(id));

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
		localmovie = object;
		textMoviesID.setText(object.getMovieId() + "");
		textMoviesTitle.setText(object.getTitle());
		textMoviesDate.setText(DateFormat.getDateInstance(DateFormat.LONG)
				.format(object.getReleaseDate().getTime()));
		textMoviesRuntime.setText(Integer.toString(object.getRuntime()));
		textMoviesDescription.setText(object.getDescription());
		textMoviesmainImage.setText(object.getMainImage().getImageFileName());

		TableItem item;
		// Fill Directorstable
		tableMoviesDirectorsDetail.removeAll();
		for (int i = 0; i < object.getDirector().size(); i++) {
			Director o = (Director) object.getDirector().get(i);
			item = new TableItem(tableMoviesDirectorsDetail, SWT.NONE);
			item.setText(new String[] { o.getDirectorId() + "",
					o.getLastName() + " , " + o.getFirstName() });
		}

		//Fill Actorstable
		tableMoviesActorsDetail.removeAll();
		for (int i = 0; i < object.getActors().size(); i++) {
			Actor o = (Actor) object.getActors().get(i);
			item = new TableItem(tableMoviesActorsDetail, SWT.NONE);
			item.setText(new String[] { o.getActorId() + "",
					o.getLastName() + " , " + o.getFirstName() });
		}

		//Fill Genretable
		tableMoviesGenresDetail.removeAll();
		logger.debug("Anzahl der Genres: " + object.getGenres().size());
		for (int i = 0; i < object.getGenres().size(); i++) {
			Genre o = (Genre) object.getGenres().get(i);
			logger.debug(i + " " + o);
			item = new TableItem(tableMoviesGenresDetail, SWT.NONE);
			item
					.setText(new String[] { o.getGenreId() + "",
							o.getName() + "" });

			//item.setText(new String[] {o.getGenreId() 
			//        + " ",o.getName()});
		}

		//Fill Imagetable
		tableMoviesImagesDetail.removeAll();
		logger.debug("Anzahl der Bilder: " + object.getImages().size());
		for (int i = 0; i < object.getImages().size(); i++) {
			Image o = (Image) object.getImages().get(i);
			item = new TableItem(tableMoviesImagesDetail, SWT.NONE);
			item.setText(new String[] { o.getImageId() + "",
					o.getImageFileName() + "" });
		}

		//Enable Buttons for Delete and Edit
		buttonMoviesEdit.setEnabled(true);
		buttonMoviesDelete.setEnabled(true);

		//Change mode to view
		mode_movie = ManagementGui.MODE_VIEW;

	}

	private List validateInput() {
		List errors = new ArrayList();

		if (textMoviesTitle.getText().trim().equalsIgnoreCase("")) {
			errors.add(l
					.getString("movies.groupdetail.savebutton.warn.notitle"));
		}

		if (textMoviesDescription.getText().trim().equalsIgnoreCase("")) {
			errors
					.add(l
							.getString("movies.groupdetail.savebutton.warn.nodescription"));
		}

		if (textMoviesDate.getText().trim().equalsIgnoreCase("")) {
			errors
					.add(l
							.getString("movies.groupdetail.savebutton.warn.noreleasedate"));
		}

		if (localmovie.getDirector().size() == 0) {
			errors
					.add(l
							.getString("movies.groupdetail.savebutton.warn.nodirector"));
		}

		if (localmovie.getActors().size() == 0) {
			errors.add(l
					.getString("movies.groupdetail.savebutton.warn.noactor"));
		}

		if (localmovie.getGenres().size() == 0) {
			errors.add(l
					.getString("movies.groupdetail.savebutton.warn.nogenres"));
		}

		if (localmovie.getImages().size() == 0) {
			errors.add(l
					.getString("movies.groupdetail.savebutton.warn.noimages"));
		}

		return errors;

	}
}
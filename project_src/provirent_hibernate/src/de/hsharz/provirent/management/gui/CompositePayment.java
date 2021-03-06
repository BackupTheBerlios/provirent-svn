package de.hsharz.provirent.management.gui;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Vector;

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
import org.vafada.swtcalendar.SWTCalendarEvent;
import org.vafada.swtcalendar.SWTCalendarListener;

import com.cloudgarden.resource.SWTResourceManager;

import de.hsharz.provirent.objects.Payment;
import de.hsharz.provirent.objects.PaymentCategory;
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
public class CompositePayment extends AbstractComposite {

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	/** 
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(CompositePayment.class);

	private final static int MODE_VIEW = 0;

	private final static int MODE_ADD = 1;

	private SashForm sashForm1;

	private SashForm sashFormPayment;

	private Composite parent;

	private Composite compositeButtons;
	private Combo ComboPaymentCategory;

	private Button changeStartDateButton;

	private Group groupPayment;

	private Group groupPaymentOverview;

	private Group groupPaymentDetail;

	private Label labelPaymentId;

	private Label labelPaymentName;

	private Label labelduration1;

	private Label labelduration2;

	private Label labelduration3;

	private Label labelstartdate;

	private Text textPaymentID;

	private Text textduration1;

	private Text textduration2;

	private Text textduration3;

	private Text textstartdate;

	private Text textPaymentSearch;

	private Label labelPaymentSearch;

	private Button buttonPaymentCancel;

	private Button buttonPaymentSave;

	private Button buttonPaymentFill;

	private Button buttonPaymentDelete;

	private Button buttonPaymentEdit;

	private Button buttonPaymentNew;

	private Table tablePayment;

	private TableColumn tableColumn;

	private Hashtable list = null;

	private List localCategory = new ArrayList();
	
	private final static int MODE_EDIT = 2;

	private StatusLineStyledText statusLine;

	private ResourceBundle l;

	protected int mode_Payment;

	/*
	 * �ndert die Sprache aller Elemente
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
				"de.hsharz.provirent.management.gui.language.payment", locale);

	}

	/**
	 * Auto-generated main method to display this
	 * org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void main(String[] args) {
		showGUI();
	}

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

	public CompositePayment(Composite p, int style,
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

			initPaymentGroup();
			try {
				refreshPaymentTable(textPaymentSearch.getText());
			} catch (DataBaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		this.layout();

		if (logger.isDebugEnabled()) {
			logger.debug("initGUI() - end");
		}
	}

	/**
	 *  
	 */
	private void initPaymentGroup() {
		{
			//init a group for the Payment
			groupPayment = new Group(sashForm1, SWT.NONE);
			GridLayout group2Layout = new GridLayout();
			group2Layout.makeColumnsEqualWidth = true;
			groupPayment.setText(l.getString("Payment.group.label"));
			groupPayment.setSize(758, 284);
			FormData group2LData = new FormData();
			groupPayment.addFocusListener(new FocusAdapter() {
				public void focusLost(FocusEvent evt) {
					System.out.println("groupPayment.focusLost, event=" + evt);
					buttonPaymentCancel.setEnabled(false);
					buttonPaymentDelete.setEnabled(false);
					buttonPaymentEdit.setEnabled(false);
					buttonPaymentNew.setEnabled(false);
					buttonPaymentSave.setEnabled(false);
				}
			});
			groupPayment.setLayout(group2Layout);
			groupPayment.setLayoutData(group2LData);
			{
				sashFormPayment = new SashForm(groupPayment, SWT.NONE);
				FormLayout sashForm2Layout = new FormLayout();
				sashFormPayment.setSize(748, 300);
				GridData sashForm2LData = new GridData();
				sashFormPayment.setLayout(sashForm2Layout);
				sashForm2LData.verticalAlignment = GridData.FILL;
				sashForm2LData.horizontalAlignment = GridData.FILL;
				sashForm2LData.grabExcessHorizontalSpace = true;
				sashForm2LData.grabExcessVerticalSpace = true;
				sashFormPayment.setLayoutData(sashForm2LData);

				//init die Gruppe f�r Paymente �berblick
				initPaymentGroupOverview();
				//init die Detailansicht
				initPaymentGroupDetail();

			}
		}

	}

	/**
	 *  
	 */
	private void initPaymentGroupDetail() {
		groupPaymentDetail = new Group(sashFormPayment, SWT.NONE);
		GridLayout groupPaymentDetailLayout = new GridLayout();
		groupPaymentDetailLayout.marginHeight = 25;
		groupPaymentDetailLayout.numColumns = 6;
		groupPaymentDetailLayout.verticalSpacing = 15;
		groupPaymentDetail.setText(l.getString("Payment.groupdetail.label"));
		FormData formData = new FormData();
		groupPaymentDetail.setLayout(groupPaymentDetailLayout);
		formData.right = new FormAttachment(100, 100, -5);
		formData.top = new FormAttachment(0, 100, 5);
		formData.bottom = new FormAttachment(100, 100, -5);
		groupPaymentDetail.setLayoutData(formData);
		{
			labelPaymentId = new Label(groupPaymentDetail, SWT.NONE);
			labelPaymentId.setText(l.getString("Payment.groupdetail.idlabel")
					+ ":");
			labelPaymentId.setSize(125, 15);
			GridData formData2 = new GridData();
			formData2.widthHint = 125;
			formData2.heightHint = 15;
			formData2.horizontalSpan = 2;
			labelPaymentId.setLayoutData(formData2);
		}
		{
			textPaymentID = new Text(groupPaymentDetail, SWT.READ_ONLY
					| SWT.BORDER);
			GridData text1LData1 = new GridData();
			text1LData1.horizontalAlignment = GridData.FILL;
			text1LData1.heightHint = 13;
			text1LData1.horizontalSpan = 4;
			text1LData1.grabExcessHorizontalSpace = true;
			textPaymentID.setLayoutData(text1LData1);
		}
		{
			labelPaymentName = new Label(groupPaymentDetail, SWT.NONE);
			labelPaymentName.setText(l
					.getString("Payment.groupdetail.namelabel")
					+ ":");
			labelPaymentName.setSize(125, 15);
			GridData formData2 = new GridData();
			formData2.widthHint = 125;
			formData2.heightHint = 15;
			formData2.horizontalSpan = 2;
			labelPaymentName.setLayoutData(formData2);
		}
		{
			ComboPaymentCategory = new Combo(groupPaymentDetail, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.NO_RADIO_GROUP);
			GridData ComboPaymentCategoryLData = new GridData();
			ComboPaymentCategoryLData.horizontalSpan = 4;
			ComboPaymentCategoryLData.horizontalAlignment = GridData.FILL;
			ComboPaymentCategory.setLayoutData(ComboPaymentCategoryLData);
		}
		{
			labelduration1 = new Label(groupPaymentDetail, SWT.NONE);
			labelduration1.setText(l
					.getString("Payment.groupdetail.duration1label")
					+ ":");
			labelduration1.setSize(125, 15);
			GridData labelduration1LData = new GridData();
			labelduration1LData.widthHint = 125;
			labelduration1LData.heightHint = 15;
			labelduration1LData.horizontalSpan = 2;
			labelduration1.setLayoutData(labelduration1LData);
		}
		{
			textduration1 = new Text(groupPaymentDetail, SWT.READ_ONLY
					| SWT.BORDER);
			GridData text1LData2 = new GridData();
			text1LData2.horizontalAlignment = GridData.FILL;
			text1LData2.heightHint = 13;
			text1LData2.horizontalSpan = 4;
			text1LData2.grabExcessHorizontalSpace = true;
			textduration1.setLayoutData(text1LData2);
		}
		{
			labelduration2 = new Label(groupPaymentDetail, SWT.NONE);
			labelduration2.setText(l
					.getString("Payment.groupdetail.duration2label")
					+ ":");
			labelduration2.setSize(125, 15);
			GridData label2LData1 = new GridData();
			label2LData1.widthHint = 125;
			label2LData1.heightHint = 15;
			label2LData1.horizontalSpan = 2;
			labelduration2.setLayoutData(label2LData1);
		}
		{
			textduration2 = new Text(groupPaymentDetail, SWT.READ_ONLY
					| SWT.BORDER);
			GridData text1LData3 = new GridData();
			text1LData3.horizontalAlignment = GridData.FILL;
			text1LData3.heightHint = 13;
			text1LData3.horizontalSpan = 4;
			text1LData3.grabExcessHorizontalSpace = true;
			textduration2.setLayoutData(text1LData3);
		}
		{
			labelduration3 = new Label(groupPaymentDetail, SWT.NONE);
			labelduration3.setText(l
					.getString("Payment.groupdetail.duration3label")
					+ ":");
			labelduration3.setSize(125, 15);
			GridData label1LData1 = new GridData();
			label1LData1.widthHint = 125;
			label1LData1.heightHint = 15;
			label1LData1.horizontalSpan = 2;
			labelduration3.setLayoutData(label1LData1);
		}
		{
			textduration3 = new Text(groupPaymentDetail, SWT.READ_ONLY
					| SWT.BORDER);
			GridData text1LData3 = new GridData();
			text1LData3.horizontalAlignment = GridData.FILL;
			text1LData3.heightHint = 13;
			text1LData3.horizontalSpan = 4;
			text1LData3.grabExcessHorizontalSpace = true;
			textduration3.setLayoutData(text1LData3);
		}
		{
			labelstartdate = new Label(groupPaymentDetail, SWT.NONE);
			labelstartdate.setText(l
					.getString("Payment.groupdetail.startdatelabel")
					+ ":");
			labelstartdate.setSize(125, 15);
			GridData label1LData1 = new GridData();
			label1LData1.widthHint = 125;
			label1LData1.heightHint = 15;
			label1LData1.horizontalSpan = 2;
			labelstartdate.setLayoutData(label1LData1);
		}
		{
			textstartdate = new Text(groupPaymentDetail, SWT.READ_ONLY
					| SWT.BORDER);
			GridData text1LData3 = new GridData();
			text1LData3.horizontalAlignment = GridData.FILL;
			text1LData3.heightHint = 13;
			text1LData3.horizontalSpan = 3;
			text1LData3.grabExcessHorizontalSpace = true;
			textstartdate.setLayoutData(text1LData3);
			textstartdate.setEditable(false);
		}
		{
			changeStartDateButton = new Button(groupPaymentDetail, SWT.PUSH
					| SWT.CENTER);
			changeStartDateButton.setText(l
					.getString("Payment.groupdetail.startdatebuttonchange"));
			GridData text1LData3 = new GridData();
			changeStartDateButton.setEnabled(false);
			changeStartDateButton.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {

					final SWTCalendarDialog cal = new SWTCalendarDialog(
							getDisplay(),
							l
									.getString("Payment.groupdetail.startdatebuttonfinish"),
							l
									.getString("Payment.groupdetail.startdatedialogtitle"));

					cal.addDateChangedListener(new SWTCalendarListener() {

						public void dateChanged(SWTCalendarEvent calendarEvent) {

							textstartdate.setText(DateFormat.getDateInstance(
									DateFormat.LONG).format(
									calendarEvent.getCalendar().getTime()));

						}

					});

					if (textstartdate.getText() != null
							&& textstartdate.getText().length() > 0) {

						try {
							cal.setDate(DateFormat.getDateInstance(
									DateFormat.LONG).parse(
									textstartdate.getText()));

						} catch (ParseException pe) {

						}

					}

					cal.open();

				}
			});
			text1LData3.horizontalAlignment = GridData.FILL;

			text1LData3.horizontalSpan = 1;
			text1LData3.grabExcessHorizontalSpace = true;
			changeStartDateButton.setLayoutData(text1LData3);
		}
		{

			//die Buttons bekommen ein eigenes Composite
			compositeButtons = new Composite(groupPaymentDetail, SWT.EMBEDDED);
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

			//init all the Buttons
			initPaymentDetailButtons();

		}

	}

	/**
	 *  
	 */
	private void initPaymentDetailButtons() {
		buttonPaymentNew = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
		buttonPaymentNew.setText(l.getString("button.new"));
		buttonPaymentNew.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent evt) {

				textPaymentID.setText("");
				ComboPaymentCategory.setText("");
				textduration1.setText("");
				textduration2.setText("");
				textduration3.setText("");
				textstartdate.setText("");

				ComboPaymentCategory.setEnabled(true);
				textduration1.setEditable(true);
				textduration2.setEditable(true);
				textduration3.setEditable(true);
				//textstartdate.setEditable(true);
				changeStartDateButton.setEnabled(true);

				buttonPaymentCancel.setEnabled(true);
				buttonPaymentSave.setEnabled(true);
				buttonPaymentNew.setEnabled(false);
				buttonPaymentEdit.setEnabled(false);
				buttonPaymentDelete.setEnabled(false);

				textPaymentSearch.setEditable(false);
				tablePayment.setEnabled(false);

				mode_Payment = ManagementGui.MODE_ADD;

			}
		});

		buttonPaymentEdit = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
		buttonPaymentEdit.setText(l.getString("button.edit"));
		buttonPaymentEdit.setEnabled(false);
		buttonPaymentEdit.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {

				mode_Payment = ManagementGui.MODE_EDIT;

				textPaymentID.setEditable(false);
				ComboPaymentCategory.setEnabled(true);
				textduration1.setEditable(true);
				textduration2.setEditable(true);
				textduration3.setEditable(true);
				//textstartdate.setEditable(true);
				changeStartDateButton.setEnabled(true);

				textduration1.setFocus();

				buttonPaymentCancel.setEnabled(true);
				buttonPaymentSave.setEnabled(true);
				buttonPaymentNew.setEnabled(false);
				buttonPaymentEdit.setEnabled(false);
				buttonPaymentDelete.setEnabled(false);

				tablePayment.setEnabled(false);
				textPaymentSearch.setEnabled(false);

			}
		});

		buttonPaymentDelete = new Button(compositeButtons, SWT.PUSH
				| SWT.CENTER);
		buttonPaymentDelete.setText(l.getString("button.delete"));
		buttonPaymentDelete.setEnabled(false);
		buttonPaymentDelete.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				System.out.println("buttonPaymentDelete.widgetSelected, event="
						+ evt);

				String msg = MessageFormat
						.format(
								l
										.getString("Payment.groupdetail.deletebutton.question.text"),
								new Object[] { ComboPaymentCategory.getText() + " "
										+ textduration1.getText() + " "
										+ textduration2.getText() + " "
										+ textduration3.getText() + " "
										+ textstartdate.getText() });

				int question = showMsg(
						msg,
						l
								.getString("Payment.groupdetail.deletebutton.question.header"),
						SWT.ICON_QUESTION | SWT.YES | SWT.NO);

				if (question != SWT.YES) {
					return;
				}
				try {
					Payment o = new Payment();
					o.setPaymentId(new Integer(Integer.parseInt(textPaymentID
							.getText())));
					//o.setName(ComboPaymentCategory.getText());
					o.setDuration1(Float.parseFloat(textduration1.getText()));
					o.setDuration2(Float.parseFloat(textduration2.getText()));
					o.setDuration3(Float.parseFloat(textduration3.getText()));
					o.setStartdate(Calendar.getInstance());
					try {
						o.getStartdate().setTime(
								DateFormat.getDateInstance(DateFormat.LONG)
										.parse(textstartdate.getText()));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						if (logger.isDebugEnabled()) {
							logger
									.debug("Problem mit Date l�schen wird verworfen ");
						}
						return;
					}

					//object speichern
					// Fehlerbehandlung
					Database.deleteObject(o);

					//�bersichtsTabelle aktualisieren
					refreshPaymentTable(textPaymentSearch.getText());

					//Detailansicht leeren
					textPaymentID.setText("");
					ComboPaymentCategory.setText("");
					textduration1.setText("");
					textduration2.setText("");
					textduration3.setText("");
					textstartdate.setText("");
					buttonPaymentEdit.setEnabled(false);
					buttonPaymentDelete.setEnabled(false);
					//in Tabelle n�chsten ausw�hlen
					try {
						tablePayment.deselectAll();
					} catch (Exception ex) {
					}

					//Statusline Nachricht sezten
					statusLine
							.setStatus(
									1,
									l
											.getString("Payment.groupdetail.deletebutton.newok"));

				} catch (DataBaseException e) {
					if (e.getMessage().equalsIgnoreCase("1")) {
						//Fehler beim Speichern des Objectes

						statusLine
								.setStatus(
										3,
										l
												.getString("Payment.groupdetail.deletebutton.errorsave"));
						showMsg(
								l
										.getString("Payment.groupdetail.deletebutton.errorsave"),
								l.getString("error"), SWT.ICON_ERROR | SWT.OK);

					} else if (e.getMessage().equalsIgnoreCase("2")) {
						//fehler beim db aufbau
						statusLine
								.setStatus(
										3,
										l
												.getString("Payment.groupdetail.deletebutton.errordb"));
						showMsg(
								l
										.getString("Payment.groupdetail.deletebutton.errordb"),
								l.getString("error"), SWT.ICON_ERROR | SWT.OK);

					} else {
						//@todo
						e.printStackTrace();
					}

				}

			}

		});

		//leerer nicht sichtbarer Button
		buttonPaymentFill = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
		GridData buttonPaymentFillLData = new GridData();
		buttonPaymentFill.setVisible(false);
		buttonPaymentFill.setEnabled(false);
		buttonPaymentFillLData.widthHint = 30;
		buttonPaymentFillLData.heightHint = 23;
		buttonPaymentFill.setLayoutData(buttonPaymentFillLData);

		buttonPaymentSave = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
		buttonPaymentSave.setText(l.getString("button.save"));
		buttonPaymentSave.setEnabled(false);
		buttonPaymentSave.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {

				//testen ob duration leer ist
				if (ComboPaymentCategory.getText().trim().equalsIgnoreCase("")
						|| textduration1.getText().trim().equalsIgnoreCase("")
						|| textduration2.getText().trim().equalsIgnoreCase("")
						|| textduration3.getText().trim().equalsIgnoreCase("")
						|| textstartdate.getText().trim().equalsIgnoreCase("")) {

					showMsg(
							l
									.getString("Payment.groupdetail.savebutton.warn.noname.msg"),
							l
									.getString("Payment.groupdetail.savebutton.warn.noname.title"),
							SWT.ICON_WARNING | SWT.YES);

					return;
				}

				buttonPaymentEdit.setEnabled(false);
				buttonPaymentDelete.setEnabled(false);

				//testen welcher mode

				if (mode_Payment == ManagementGui.MODE_ADD) {

					/**
					 * @todo eine Exception bekommen wieder leider NOCH nicht
					 *       mit d.h. es muss noch ein r�ckgabewert kommen oder
					 *       eine Exception �bermitteln werden (aus der DB
					 *       Klasse)
					 */

					try {

						Calendar tmp_cal = Calendar.getInstance();
						tmp_cal
								.setTime(DateFormat.getDateInstance(
										DateFormat.LONG).parse(
										textstartdate.getText()));
						//neues Objekt erzeugen
						Payment tmp = null;
						/*
						tmp = new Payment(ComboPaymentCategory.getText(),
								Float.parseFloat(textduration1.getText()),
								Float.parseFloat(textduration2.getText()),
								Float.parseFloat(textduration3.getText()),
								tmp_cal);
								*/
						//object speichern
						// Fehlerbehandlung
						Object o = Database.saveObject(tmp);

						// in �bersichtstabelle einf�gen
						insertIntoPaymentTable((Payment) o);

						//Statusline Nachricht sezten
						statusLine
								.setStatus(
										1,
										l
												.getString("Payment.groupdetail.savebutton.newok"));

					} catch (DataBaseException e) {
						if (e.getMessage().equalsIgnoreCase("1")) {
							//Fehler beim Speichern des Objectes

							statusLine
									.setStatus(
											3,
											l
													.getString("Payment.groupdetail.savebutton.errorsave"));
							showMsg(
									l
											.getString("Payment.groupdetail.savebutton.errorsave"),
									"Fehler", SWT.ICON_ERROR | SWT.OK);

						} else if (e.getMessage().equalsIgnoreCase("2")) {
							//fehler beim db aufbau
							statusLine
									.setStatus(
											3,
											l
													.getString("Payment.groupdetail.savebutton.errordb"));
							showMsg(
									l
											.getString("Payment.groupdetail.savebutton.errordb"),
									"Fehler", SWT.ICON_ERROR | SWT.OK);

						} else {
							//@todo
							e.printStackTrace();
						}

					} catch (ParseException pex) {
						statusLine
								.setStatus(
										3,
										l
												.getString("Payment.groupdetail.savebutton.errorsave"));
						showMsg(
								l
										.getString("Payment.groupdetail.savebutton.errorsave"),
								"Fehler", SWT.ICON_ERROR | SWT.OK);

					}

					//                  alle Buttons auf aktiv setzen
					setPaymentGroupButtonSaveCancel();
					buttonPaymentDelete.setEnabled(false);
					buttonPaymentEdit.setEnabled(false);

				} else if (mode_Payment == ManagementGui.MODE_EDIT) {
					try {

						Calendar tmp_cal = Calendar.getInstance();
						tmp_cal
								.setTime(DateFormat.getDateInstance(
										DateFormat.LONG).parse(
										textstartdate.getText()));

						Payment tmp = null;
						/*
						tmp = new Payment(ComboPaymentCategory.getText(),
								Float.parseFloat(textduration1.getText()),
								Float.parseFloat(textduration2.getText()),
								Float.parseFloat(textduration3.getText()),
								tmp_cal);
						tmp.setPaymentId(new Integer(Integer
								.parseInt(textPaymentID.getText())));
								*/
						//object speichern
						// Fehlerbehandlung
						Database.updateObject(tmp);
						//�bersichtstabelle aktualisieren
						refreshPaymentTable(textPaymentSearch.getText());

						//Statusline Nachricht sezten
						statusLine
								.setStatus(
										1,
										l
												.getString("Payment.groupdetail.savebutton.editok"));

					} catch (DataBaseException e) {
						if (e.getMessage().equalsIgnoreCase("1")) {
							//Fehler beim Speichern des Objectes

							statusLine
									.setStatus(
											3,
											l
													.getString("Payment.groupdetail.savebutton.errorsave"));
							showMsg(
									l
											.getString("Payment.groupdetail.savebutton.errorsave"),
									"Fehler", SWT.ICON_ERROR | SWT.OK);

						} else if (e.getMessage().equalsIgnoreCase("2")) {
							//fehler beim db aufbau
							statusLine
									.setStatus(
											3,
											l
													.getString("Payment.groupdetail.savebutton.errordb"));
							showMsg(
									l
											.getString("Payment.groupdetail.savebutton.errordb"),
									"Fehler", SWT.ICON_ERROR | SWT.OK);

						} else {
							//@todo
							e.printStackTrace();
						}

					} catch (ParseException pex) {
						statusLine
								.setStatus(
										3,
										l
												.getString("Payment.groupdetail.savebutton.errorsave"));
						showMsg(
								l
										.getString("Payment.groupdetail.savebutton.errorsave"),
								"Fehler", SWT.ICON_ERROR | SWT.OK);

					}

					//alle Buttons auf aktiv setzen
					setPaymentGroupButtonSaveCancel();
					buttonPaymentDelete.setEnabled(false);
					buttonPaymentEdit.setEnabled(false);
				}

				/**
				 * @todo Exception werfen, da nur die zwei Modes sein d�rfen
				 */

			}
		});

		buttonPaymentCancel = new Button(compositeButtons, SWT.PUSH
				| SWT.CENTER);
		buttonPaymentCancel.setText(l.getString("button.cancel"));
		buttonPaymentCancel.setEnabled(false);
		buttonPaymentCancel.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				System.out.println("buttonPaymentCancel.widgetSelected, event="
						+ evt);
				setPaymentGroupButtonSaveCancel();
			}
		});

	}

	/**
	 *  
	 */
	protected void setPaymentGroupButtonSaveCancel() {
		buttonPaymentSave.setEnabled(false);
		buttonPaymentCancel.setEnabled(false);
		buttonPaymentEdit.setEnabled(true);
		buttonPaymentNew.setEnabled(true);
		buttonPaymentDelete.setEnabled(true);
		ComboPaymentCategory.setEnabled(false);
		textduration1.setEditable(false);
		textduration2.setEditable(false);
		textduration3.setEditable(false);
		//textstartdate.setEditable(false);
		changeStartDateButton.setEnabled(false);
		textPaymentSearch.setEditable(true);

		// PaymentTabelle aktivieren
		tablePayment.setEnabled(true);

		//PaymentSearch aktivieren
		textPaymentSearch.setEnabled(true);

	}

	/**
	 * @param Payment
	 * @throws DataBaseException
	 */
	protected void insertIntoPaymentTable(Payment payment)
			throws DataBaseException {
		TableItem item = new TableItem(tablePayment, SWT.NONE);
		item.setText(new String[] {
		        payment.getPaymentId() + "",
		        payment.getPaymentCategory().getName(),
				Double.toString(payment.getDuration1()),
				Double.toString(payment.getDuration2()),
				Double.toString(payment.getDuration3()),
				DateFormat.getDateInstance(DateFormat.SHORT).format(
				        payment.getStartdate().getTime()) });

		tablePayment.deselectAll();
		refreshPaymentDetail("");

		try {
			refreshPaymentTable(textPaymentSearch.getText());
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param text
	 * @throws DataBaseException
	 */
	protected void refreshPaymentTable(final String filter)
			throws DataBaseException {
		if (tablePayment == null) {
			System.out
					.println("Konnte Paymenttable nicht refreshen, da diese null ist!");
			return;
		}
		System.out.println("Versuche nun PaymentListe zu refreshen. Filter: "
				+ filter);
		tablePayment.removeAll();
		TableItem item;
		java.util.List Paymentlist = Database.getPayment(filter);
		list = new Hashtable();
		for (int i = 0; i < Paymentlist.size(); i++) {
			Payment paym = (Payment) Paymentlist.get(i);
			String name = paym.getPaymentCategory().getName();

			if (list.containsKey(name)) {
				Vector vec = (Vector) list.get(name);
				vec.add(paym.getStartdate());
			} else {
				Vector vec = new Vector();
				vec.add(paym.getStartdate());

				list.put(paym.getPaymentCategory().getName(), vec);
			}
		}
		Enumeration keys = list.keys();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			Vector vec = (Vector) list.get(key);
			Vector aktDates = new Vector();
			Calendar temp = null;
			for (int i = 0; i < vec.size(); i++) {
				Calendar today = Calendar.getInstance();
				if (temp == null) {
					temp = (Calendar) vec.get(i);
					if (temp.after(today)) {
						aktDates.add(temp);
						temp = null;
						continue;
					} else {
						aktDates.add(0, temp);
						continue;
					}
				}
				Calendar date = (Calendar) vec.get(i);

				if (!date.after(today)) {
					if (date.after(temp)) {
						temp = date;
						aktDates.set(0, date);
					}

				} else {
					aktDates.add(date);
				}

			}
			list.remove(key);
			list.put(key, aktDates);
		}

		for (int i = 0; i < Paymentlist.size(); i++) {

			Payment o = (Payment) Paymentlist.get(i);
			item = new TableItem(tablePayment, SWT.NONE);
			item.setText(new String[] {
					o.getPaymentId() + "",
					o.getPaymentCategory().getName(),
					Double.toString(o.getDuration1()),
					Double.toString(o.getDuration2()),
					Double.toString(o.getDuration3()),
					DateFormat.getDateInstance(DateFormat.SHORT).format(
							o.getStartdate().getTime()) });

		}

	}

	/**
	 *  
	 */
	private void initPaymentGroupOverview() {
		if (logger.isDebugEnabled()) {
			logger.debug("initPaymentGroupOverview() - start");
		}

		groupPaymentOverview = new Group(sashFormPayment, SWT.NONE);
		GridLayout group5Layout = new GridLayout();
		group5Layout.numColumns = 8;
		groupPaymentOverview
				.setText(l.getString("Payment.groupoverview.label"));
		FormData group5LData = new FormData();
		groupPaymentOverview.setLayout(group5Layout);
		group5LData.left = new FormAttachment(0, 100, 0);
		group5LData.top = new FormAttachment(0, 100, 0);
		groupPaymentOverview.setLayoutData(group5LData);

		//Tabelle anzeigen
		initTablePayment();
		//Suche darunter anzeigen
		initPaymentSearch();

		if (logger.isDebugEnabled()) {
			logger.debug("initPaymentGroupOverview() - end");
		}

	}

	/**
	 *  
	 */
	private void initPaymentSearch() {
		if (logger.isDebugEnabled()) {
			logger.debug("initPaymentSearch() - start");
		}

		//label f�r die Suche
		labelPaymentSearch = new Label(groupPaymentOverview, SWT.NONE);
		labelPaymentSearch.setText(l
				.getString("Payment.groupoverview.searchlabel")
				+ ":");
		GridData label2LData = new GridData();
		label2LData.horizontalSpan = 3;
		labelPaymentSearch.setLayoutData(label2LData);

		//das Suchfeld
		textPaymentSearch = new Text(groupPaymentOverview, SWT.BORDER);
		GridData text2LData = new GridData();
		textPaymentSearch.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent evt) {
				if (logger.isDebugEnabled()) {
					logger.debug("focusLost(FocusEvent evt = " + evt + " "
							+ textPaymentSearch.getText() + ") - start");
				}

				try {
					refreshPaymentTable(textPaymentSearch.getText());
				} catch (DataBaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (logger.isDebugEnabled()) {
					logger.debug("focusLost(FocusEvent) - end");
				}
			}
		});

		textPaymentSearch.addListener(SWT.DefaultSelection, new Listener() {
			public void handleEvent(Event e) {
				if (logger.isDebugEnabled()) {
					logger.debug("handleEvent(Event e = " + e + " "
							+ textPaymentSearch.getText() + ") - start");
				}

				try {
					refreshPaymentTable(textPaymentSearch.getText());
				} catch (DataBaseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (logger.isDebugEnabled()) {
					logger.debug("handleEvent(Event) - end");
				}
			}
		});

		text2LData.horizontalAlignment = GridData.FILL;
		text2LData.horizontalSpan = 5;
		text2LData.grabExcessHorizontalSpace = true;
		textPaymentSearch.setLayoutData(text2LData);

		if (logger.isDebugEnabled()) {
			logger.debug("initPaymentSearch() - end");
		}

	}

	/**
	 *  
	 */
	private void initTablePayment() {
		if (logger.isDebugEnabled()) {
			logger.debug("initTablePayment() - start");
		}

		tablePayment = new Table(groupPaymentOverview, SWT.SINGLE
				| SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.BORDER);
		tablePayment.setHeaderVisible(true);
		tablePayment.setLinesVisible(true);
		GridData table2LData = new GridData();
		tablePayment.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent evt) {
				System.out.println("tablePayment.focusLost, event=" + evt);
			}

			public void focusGained(FocusEvent evt) {
				System.out.println("tablePayment.focusGained, event=" + evt);
			}
		});
		tablePayment.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				if (logger.isDebugEnabled()) {
					logger.debug("widgetSelected(SelectionEvent evt = " + evt
							+ ") - start");
				}

				int index = tablePayment.getSelectionIndex();

				System.out.println("Table select. id: " + index + " TableItem:"
						+ tablePayment.getItem(index) + " id: "
						+ tablePayment.getItem(index).getText(0));

				//es wurde ein Element aus Tabelle ausgewaehlt jetzt muss die
				//Detailansicht aktualisiert werden
				refreshPaymentDetail(tablePayment.getItem(index).getText(0));

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
		tablePayment.setLayoutData(table2LData);

		//einzelne Spalten hinzuf�gen
		tableColumn = new TableColumn(tablePayment, SWT.CENTER);
		tableColumn.setText(l.getString("Payment.groupoverview.columnid"));
		tableColumn.setWidth(50);

		tableColumn = new TableColumn(tablePayment, SWT.CENTER);
		tableColumn.setText(l.getString("Payment.groupoverview.columnname"));
		tableColumn.setWidth(50);

		tableColumn = new TableColumn(tablePayment, SWT.CENTER);
		tableColumn.setText(l
				.getString("Payment.groupoverview.columnduration1"));
		tableColumn.setWidth(70);

		tableColumn = new TableColumn(tablePayment, SWT.CENTER);
		tableColumn.setText(l
				.getString("Payment.groupoverview.columnduration2"));
		tableColumn.setWidth(70);

		tableColumn = new TableColumn(tablePayment, SWT.CENTER);
		tableColumn.setText(l
				.getString("Payment.groupoverview.columnduration3"));
		tableColumn.setWidth(70);
		tableColumn = new TableColumn(tablePayment, SWT.CENTER);
		tableColumn.setText(l
				.getString("Payment.groupoverview.columnstartdate"));
		tableColumn.setWidth(70);

		if (logger.isDebugEnabled()) {
			logger.debug("initTablePayment() - end");
		}

	}

	/**
	 * @param text
	 */
	protected void refreshPaymentDetail(final String id) {
		if (id != null && !id.equals("")) {
			Payment object;
			try {
				//since we only can get a String value from the table, we
				//need to convert this
				object = Database.getSinglePayment(Integer.parseInt(id));
				localCategory = Database.getPaymentCategory();
				if (object == null || localCategory == null || localCategory.size() == 0 ) {

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

			textPaymentID.setText(object.getPaymentId() + "");
			ComboPaymentCategory.setText(object.getPaymentCategory().getName());
			textduration1.setText(Double.toString(object.getDuration1()));
			textduration2.setText(Double.toString(object.getDuration2()));
			textduration3.setText(Double.toString(object.getDuration3()));
			textstartdate.setText(DateFormat.getDateInstance(DateFormat.LONG)
					.format(object.getStartdate().getTime()));
			//Buttons zum l�schen und editieren aktivieren

			buttonPaymentEdit.setEnabled(false);
			buttonPaymentDelete.setEnabled(true);
			Vector vec = (Vector) list.get(object.getPaymentCategory().getName());

			for (int i = 0; i < vec.size(); i++) {
				Calendar date = (Calendar) vec.get(i);

				if (DateFormat.getDateInstance(DateFormat.SHORT).format(
						date.getTime()).equals(
						DateFormat.getDateInstance(DateFormat.SHORT).format(
								object.getStartdate().getTime()))) {
					buttonPaymentEdit.setEnabled(true);

				}

			}
			
			logger.debug("PaymentCategory Size: "+localCategory.size());
			
			//ComboBox
			for (int i = 0; i < localCategory.size(); i++) {
				ComboPaymentCategory.add( ((PaymentCategory)localCategory.get(i)).getName(),i  );
				if ( ((PaymentCategory)localCategory.get(i)).equals(object.getPaymentCategory())) {
					ComboPaymentCategory.select(i);
					
				}
			}
		} else {
			textPaymentID.setText("");
			ComboPaymentCategory.setText("");
			textduration1.setText("");
			textduration2.setText("");
			textduration3.setText("");
			textstartdate.setText("");
			buttonPaymentEdit.setEnabled(false);
			buttonPaymentDelete.setEnabled(false);
		}

		//Mode auf view setzen
		mode_Payment = ManagementGui.MODE_VIEW;

	}

}
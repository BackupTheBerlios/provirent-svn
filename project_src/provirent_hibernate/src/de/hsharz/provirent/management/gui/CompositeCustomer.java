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
import org.vafada.swtcalendar.SWTCalendarEvent;
import org.vafada.swtcalendar.SWTCalendarListener;

import com.cloudgarden.resource.SWTResourceManager;

import de.hsharz.provirent.Util;
import de.hsharz.provirent.objects.Customer;
import de.hsharz.provirent.objects.Person;
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
public class CompositeCustomer extends AbstractComposite {

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }

    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(CompositeCustomer.class);

    private final static int MODE_VIEW = 0;

    private final static int MODE_ADD = 1;

    private SashForm sashForm1;

    private SashForm sashFormCustomer;

    private Composite parent;

    private Composite compositeButtons;

    private Button changeStartDateButton;

    private Group groupCustomer;

    private Group groupCustomerOverview;

    private Group groupCustomerDetail;

    private Button buttonCustomerCancel;

    private Button buttonCustomerSave;

    private Button buttonCustomerFill;

    private Button buttonCustomerDelete;

    private Button buttonCustomerEdit;

    private Button buttonCustomerNew;

    private Table tableCustomer;

    private TableColumn tableColumn;

    private final static int MODE_EDIT = 2;

    private StatusLineStyledText statusLine;

    private ResourceBundle l;

    private int mode_Customer;

    private Text textCustomerSearch;

    private Label labelCustomerSearch;

    private Label labelCustomerId;

    private Text textCustomerID;

    private Label labelUserName;

    private Text textUserName;

    private Label labelLastName;

    private Text textLastName;

    private Label labelFirstName;

    private Text textFirstName;

    private Label labelMiddleName;

    private Text textMiddleName;

    private Label labelPassword;

    private Text textPassword;

    private Label labelRegistrationDate;

    private Text textRegistrationDate;

    private Button changeRegistrationDateButton;

    private Label labelBirthday;

    private Text textBirthday;

    private Button changeBirthdayDateButton;

    private Label labelSalutation;

    private Text textSalutation;

    private Label labelTitle;

    private Text textTitle;

    private Label labelStreet;

    private Text textStreet;

    private Text textNumber;

    private Label labelZipCode;

    private Text textZipCode;

    private Label labelCountry;

    private Text textCountry;

    private Label labelCity;

    private Text textCity;

    private Label labelEmail;

    private Text textEmail;

    private Label labelQuestion;

    private Text textQuestion;

    private Label labelAnswer;

    private Text textAnswer;

    private Customer localCustomer;

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
                "de.hsharz.provirent.management.gui.language.Customer", locale);

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

    public CompositeCustomer(Composite p, int style,
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

            initCustomerGroup();
            try {
                refreshCustomerTable(textCustomerSearch.getText());
            } catch (DataBaseException e) {
                logger
                        .error("Databaseerror while refreshing Customer Table",
                                e);
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
    private void initCustomerGroup() {
        {
            //init a group for the Customer
            groupCustomer = new Group(sashForm1, SWT.NONE);
            GridLayout group2Layout = new GridLayout();
            group2Layout.makeColumnsEqualWidth = true;
            groupCustomer.setText(l.getString("Customer.group.label"));
            groupCustomer.setSize(758, 284);
            FormData group2LData = new FormData();
            groupCustomer.addFocusListener(new FocusAdapter() {
                public void focusLost(FocusEvent evt) {
                    if (logger.isDebugEnabled()) {
                        logger
                                .debug("focusLost(FocusEvent) - groupCustomer.focusLost, event="
                                        + evt);
                    }
                    buttonCustomerCancel.setEnabled(false);
                    buttonCustomerDelete.setEnabled(false);
                    buttonCustomerEdit.setEnabled(false);
                    buttonCustomerNew.setEnabled(false);
                    buttonCustomerSave.setEnabled(false);
                }
            });
            groupCustomer.setLayout(group2Layout);
            groupCustomer.setLayoutData(group2LData);
            {
                sashFormCustomer = new SashForm(groupCustomer, SWT.NONE);
                FormLayout sashForm2Layout = new FormLayout();
                sashFormCustomer.setSize(748, 300);
                GridData sashForm2LData = new GridData();
                sashFormCustomer.setLayout(sashForm2Layout);
                sashForm2LData.verticalAlignment = GridData.FILL;
                sashForm2LData.horizontalAlignment = GridData.FILL;
                sashForm2LData.grabExcessHorizontalSpace = true;
                sashForm2LData.grabExcessVerticalSpace = true;
                sashFormCustomer.setLayoutData(sashForm2LData);

                //init die Gruppe für Customere Überblick
                initCustomerGroupOverview();
                //init die Detailansicht
                initCustomerGroupDetail();

            }
        }

    }

    /**
     *  
     */
    private void initCustomerGroupDetail() {
        groupCustomerDetail = new Group(sashFormCustomer, SWT.NONE);
        GridLayout groupCustomerDetailLayout = new GridLayout();
        groupCustomerDetailLayout.marginHeight = 25;
        groupCustomerDetailLayout.numColumns = 4;
        groupCustomerDetailLayout.verticalSpacing = 15;
        groupCustomerDetail.setText(l.getString("Customer.groupdetail.label"));
        FormData formData = new FormData();
        groupCustomerDetail.setLayout(groupCustomerDetailLayout);
        formData.right = new FormAttachment(100, 100, -5);
        formData.top = new FormAttachment(0, 100, 5);
        formData.bottom = new FormAttachment(100, 100, -5);
        groupCustomerDetail.setLayoutData(formData);
        {
            labelCustomerId = new Label(groupCustomerDetail, SWT.NONE);
            labelCustomerId.setText(l.getString("Customer.groupdetail.idlabel")
                    + ":");
            labelCustomerId.setSize(90, 15);
            GridData formData2 = new GridData();
            formData2.widthHint = 90;
            formData2.heightHint = 15;
            labelCustomerId.setLayoutData(formData2);
        }
        {
            textCustomerID = new Text(groupCustomerDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData1 = new GridData();
            text1LData1.horizontalAlignment = GridData.FILL;
            text1LData1.heightHint = 13;
            text1LData1.horizontalSpan = 3;
            text1LData1.grabExcessHorizontalSpace = true;
            textCustomerID.setLayoutData(text1LData1);
        }
        {
            labelUserName = new Label(groupCustomerDetail, SWT.NONE);
            labelUserName.setText(l
                    .getString("Customer.groupdetail.usernamelabel")
                    + ":");
            labelUserName.setSize(90, 15);
            GridData formData2 = new GridData();
            formData2.widthHint = 90;
            formData2.heightHint = 15;
            labelUserName.setLayoutData(formData2);
        }
        {
            textUserName = new Text(groupCustomerDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData1 = new GridData();
            text1LData1.horizontalAlignment = GridData.FILL;
            text1LData1.heightHint = 13;
            text1LData1.horizontalSpan = 3;
            text1LData1.grabExcessHorizontalSpace = true;
            textUserName.setLayoutData(text1LData1);
        }
        {
            labelLastName = new Label(groupCustomerDetail, SWT.NONE);
            labelLastName.setText(l
                    .getString("Customer.groupdetail.lastnamelabel")
                    + ":");
            labelLastName.setSize(90, 15);
            GridData labelLastNameLData = new GridData();
            labelLastNameLData.widthHint = 90;
            labelLastNameLData.heightHint = 15;
            labelLastName.setLayoutData(labelLastNameLData);
        }
        {
            textLastName = new Text(groupCustomerDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData2 = new GridData();
            text1LData2.horizontalAlignment = GridData.FILL;
            text1LData2.heightHint = 13;
            text1LData2.horizontalSpan = 3;
            text1LData2.grabExcessHorizontalSpace = true;
            textLastName.setLayoutData(text1LData2);
        }
        {
            labelFirstName = new Label(groupCustomerDetail, SWT.NONE);
            labelFirstName.setText(l
                    .getString("Customer.groupdetail.firstnamelabel")
                    + ":");
            labelFirstName.setSize(90, 15);
            GridData label2LData1 = new GridData();
            label2LData1.widthHint = 90;
            label2LData1.heightHint = 15;
            labelFirstName.setLayoutData(label2LData1);
        }
        {
            textFirstName = new Text(groupCustomerDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 1;
            textFirstName.setLayoutData(text1LData3);
        }
        {
            labelMiddleName = new Label(groupCustomerDetail, SWT.NONE);
            labelMiddleName.setText(l
                    .getString("Customer.groupdetail.middlenamelabel")
                    + ":");
            labelMiddleName.setSize(70, 15);
            GridData label2LData1 = new GridData();
            label2LData1.widthHint = 70;
            label2LData1.heightHint = 15;
            labelMiddleName.setLayoutData(label2LData1);
        }
        {
            textMiddleName = new Text(groupCustomerDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.heightHint = 13;
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.horizontalSpan = 1;
            textMiddleName.setLayoutData(text1LData3);
        }
        {
            labelSalutation = new Label(groupCustomerDetail, SWT.NONE);
            labelSalutation.setText(l
                    .getString("Customer.groupdetail.salutationlabel")
                    + ":");
            labelSalutation.setSize(90, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 90;
            label1LData1.heightHint = 15;
            labelSalutation.setLayoutData(label1LData1);
        }
        {
            textSalutation = new Text(groupCustomerDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 1;
            textSalutation.setLayoutData(text1LData3);
        }
        {
            labelTitle = new Label(groupCustomerDetail, SWT.NONE);
            labelTitle.setText(l.getString("Customer.groupdetail.titlelabel")
                    + ":");
            labelTitle.setSize(70, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 70;
            label1LData1.heightHint = 15;
            labelTitle.setLayoutData(label1LData1);
        }
        {
            textTitle = new Text(groupCustomerDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 1;
            textTitle.setLayoutData(text1LData3);
        }
        {
            labelBirthday = new Label(groupCustomerDetail, SWT.NONE);
            labelBirthday.setText(l
                    .getString("Customer.groupdetail.birthdaylabel")
                    + ":");
            labelBirthday.setSize(90, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 90;
            label1LData1.heightHint = 15;
            labelBirthday.setLayoutData(label1LData1);
        }
        {
            textBirthday = new Text(groupCustomerDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 2;
            textBirthday.setLayoutData(text1LData3);
            textBirthday.setEnabled(false);
        }
        {
            changeBirthdayDateButton = new Button(groupCustomerDetail, SWT.PUSH
                    | SWT.CENTER);
            changeBirthdayDateButton.setText(l
                    .getString("Customer.groupdetail.birthdaybuttonchange"));
            GridData text1LData3 = new GridData();
            changeBirthdayDateButton.setEnabled(false);
            changeBirthdayDateButton
                    .addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {

                            final SWTCalendarDialog cal = new SWTCalendarDialog(
                                    getDisplay(),
                                    l
                                            .getString("Customer.groupdetail.birthdaybuttonfinish"),
                                            l.getString("Customer.groupdetail.birthday.dialog.title"));

                            cal
                                    .addDateChangedListener(new SWTCalendarListener() {

                                        public void dateChanged(
                                                SWTCalendarEvent cE) {
                                            textBirthday
                                                    .setText(DateFormat
                                                            .getDateInstance(
                                                                    DateFormat.LONG)
                                                            .format(
                                                                    cE
                                                                            .getCalendar()
                                                                            .getTime()));
                                        }
                                    });
                            if (textBirthday.getText() != null
                                    && textBirthday.getText().length() > 0) {

                                try {
                                    cal.setDate(DateFormat.getDateInstance(
                                            DateFormat.LONG).parse(
                                            textBirthday.getText()));
                                } catch (ParseException e) {
                                    cal.setDate(new Date());
                                }
                            }
                            cal.open();
                        }
                    });
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.horizontalSpan = 1;
            changeBirthdayDateButton.setLayoutData(text1LData3);
        }
        {
            labelStreet = new Label(groupCustomerDetail, SWT.NONE);
            labelStreet.setText(l.getString("Customer.groupdetail.streetlabel")
                    + ":");
            labelStreet.setSize(90, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 90;
            label1LData1.heightHint = 15;
            labelStreet.setLayoutData(label1LData1);
        }
        {
            textStreet = new Text(groupCustomerDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 2;
            textStreet.setLayoutData(text1LData3);
        }
        {
            textNumber = new Text(groupCustomerDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.END;
            text1LData3.heightHint = 13;
            text1LData3.widthHint = 20;
            textNumber.setLayoutData(text1LData3);
        }
        {
            labelZipCode = new Label(groupCustomerDetail, SWT.NONE);
            labelZipCode.setText(l
                    .getString("Customer.groupdetail.zipcodelabel")
                    + ":");
            labelZipCode.setSize(90, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 90;
            label1LData1.heightHint = 15;
            labelZipCode.setLayoutData(label1LData1);
        }
        {
            textZipCode = new Text(groupCustomerDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 1;
            textZipCode.setLayoutData(text1LData3);
        }
        {
            labelCity = new Label(groupCustomerDetail, SWT.NONE);
            labelCity.setText(l.getString("Customer.groupdetail.citylabel")
                    + ":");
            labelCity.setSize(70, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 70;
            label1LData1.heightHint = 15;
            labelCity.setLayoutData(label1LData1);
        }
        {
            textCity = new Text(groupCustomerDetail, SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 1;
            textCity.setLayoutData(text1LData3);
        }

        {
            labelCountry = new Label(groupCustomerDetail, SWT.NONE);
            labelCountry.setText(l
                    .getString("Customer.groupdetail.countrylabel")
                    + ":");
            labelCountry.setSize(90, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 90;
            label1LData1.heightHint = 15;
            labelCountry.setLayoutData(label1LData1);
        }
        {
            textCountry = new Text(groupCustomerDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 3;
            textCountry.setLayoutData(text1LData3);
        }
        {
            labelPassword = new Label(groupCustomerDetail, SWT.NONE);
            labelPassword.setText(l
                    .getString("Customer.groupdetail.passwordlabel")
                    + ":");
            labelPassword.setSize(90, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 90;
            label1LData1.heightHint = 15;
            labelPassword.setLayoutData(label1LData1);
        }
        {
            textPassword = new Text(groupCustomerDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 3;
            textPassword.setLayoutData(text1LData3);
        }
        {
            labelEmail = new Label(groupCustomerDetail, SWT.NONE);
            labelEmail.setText(l.getString("Customer.groupdetail.emaillabel")
                    + ":");
            labelEmail.setSize(90, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 90;
            label1LData1.heightHint = 15;
            labelEmail.setLayoutData(label1LData1);
        }
        {
            textEmail = new Text(groupCustomerDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 3;
            textEmail.setLayoutData(text1LData3);
        }
        {
            labelQuestion = new Label(groupCustomerDetail, SWT.NONE);
            labelQuestion.setText(l
                    .getString("Customer.groupdetail.questionlabel")
                    + ":");
            labelQuestion.setSize(90, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 90;
            label1LData1.heightHint = 15;
            labelQuestion.setLayoutData(label1LData1);
        }
        {
            textQuestion = new Text(groupCustomerDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 3;
            textQuestion.setLayoutData(text1LData3);
        }
        {
            labelAnswer = new Label(groupCustomerDetail, SWT.NONE);
            labelAnswer.setText(l.getString("Customer.groupdetail.answerlabel")
                    + ":");
            labelAnswer.setSize(90, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 90;
            label1LData1.heightHint = 15;
            labelAnswer.setLayoutData(label1LData1);
        }
        {
            textAnswer = new Text(groupCustomerDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 3;
            textAnswer.setLayoutData(text1LData3);
        }
        {
            labelRegistrationDate = new Label(groupCustomerDetail, SWT.NONE);
            labelRegistrationDate.setText(l
                    .getString("Customer.groupdetail.regdatelabel")
                    + ":");
            labelRegistrationDate.setSize(125, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 125;
            label1LData1.heightHint = 15;
            label1LData1.horizontalSpan = 1;
            labelRegistrationDate.setLayoutData(label1LData1);
        }
        {
            textRegistrationDate = new Text(groupCustomerDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 2;
            textRegistrationDate.setLayoutData(text1LData3);
            textRegistrationDate.setEnabled(false);
        }
        {
            changeRegistrationDateButton = new Button(groupCustomerDetail,
                    SWT.PUSH | SWT.CENTER);
            changeRegistrationDateButton
                    .setText(l
                            .getString("Customer.groupdetail.registrationdatebuttonchange"));
            GridData text1LData3 = new GridData();
            changeRegistrationDateButton.setEnabled(false);
            changeRegistrationDateButton
                    .addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {

                            final SWTCalendarDialog cal = new SWTCalendarDialog(
                                    getDisplay(),
                                    l
                                            .getString("Customer.groupdetail.registrationdatebuttonfinish"),
                                            l.getString("Customer.groupdetail.registrationdate.dialog.title"));

                            cal
                                    .addDateChangedListener(new SWTCalendarListener() {

                                        public void dateChanged(
                                                SWTCalendarEvent calendarEvent) {
                                            textRegistrationDate
                                                    .setText(DateFormat
                                                            .getDateInstance(
                                                                    DateFormat.LONG)
                                                            .format(
                                                                    calendarEvent
                                                                            .getCalendar()
                                                                            .getTime()));

                                        }
                                    });
                            if (textRegistrationDate.getText() != null
                                    && textRegistrationDate.getText().length() > 0) {

                                try {
                                    cal.setDate(DateFormat.getDateInstance(
                                            DateFormat.LONG).parse(
                                            textRegistrationDate.getText()));
                                } catch (ParseException e) {
                                    cal.setDate(new Date());
                                }
                            }
                            cal.open();
                        }
                    });
            text1LData3.horizontalAlignment = GridData.FILL;

            text1LData3.horizontalSpan = 1;
            changeRegistrationDateButton.setLayoutData(text1LData3);
        }
        {

            //die Buttons bekommen ein eigenes Composite
            compositeButtons = new Composite(groupCustomerDetail, SWT.EMBEDDED);
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
            initCustomerDetailButtons();

        }

    }

    /**
     *  
     */
    private void initCustomerDetailButtons() {
        buttonCustomerNew = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
        buttonCustomerNew.setText(l.getString("button.new"));
        buttonCustomerNew.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent evt) {

                textCustomerID.setText("");
                textUserName.setText("");
                textLastName.setText("");
                textFirstName.setText("");
                textMiddleName.setText("");
                textSalutation.setText("");
                textTitle.setText("");
                textBirthday.setText("");
                textStreet.setText("");
                textNumber.setText("");
                textZipCode.setText("");
                textCity.setText("");
                textCountry.setText("");
                textEmail.setText("");
                textPassword.setText("");
                textQuestion.setText("");
                textAnswer.setText("");
                textRegistrationDate.setText("");

                textUserName.setEditable(true);
                textLastName.setEditable(true);
                textFirstName.setEditable(true);
                textMiddleName.setEditable(true);
                textSalutation.setEditable(true);
                textTitle.setEditable(true);
                changeBirthdayDateButton.setEnabled(true);
                textStreet.setEditable(true);
                textNumber.setEditable(true);
                textZipCode.setEditable(true);
                textCity.setEditable(true);
                textCountry.setEditable(true);
                textEmail.setEditable(true);
                textPassword.setEditable(true);
                textQuestion.setEditable(true);
                textAnswer.setEditable(true);
                changeRegistrationDateButton.setEnabled(true);

                buttonCustomerCancel.setEnabled(true);
                buttonCustomerSave.setEnabled(true);
                buttonCustomerNew.setEnabled(false);
                buttonCustomerEdit.setEnabled(false);
                buttonCustomerDelete.setEnabled(false);

                textCustomerSearch.setEditable(false);
                tableCustomer.setEnabled(false);

                mode_Customer = ManagementGui.MODE_ADD;

            }
        });

        buttonCustomerEdit = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
        buttonCustomerEdit.setText(l.getString("button.edit"));
        buttonCustomerEdit.setEnabled(false);
        buttonCustomerEdit.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {

                mode_Customer = ManagementGui.MODE_EDIT;

                textUserName.setEditable(true);
                textUserName.setFocus();
                textLastName.setEditable(true);
                textFirstName.setEditable(true);
                textMiddleName.setEditable(true);
                textSalutation.setEditable(true);
                textTitle.setEditable(true);
                changeBirthdayDateButton.setEnabled(true);
                textStreet.setEditable(true);
                textNumber.setEditable(true);
                textZipCode.setEditable(true);
                textCity.setEditable(true);
                textCountry.setEditable(true);
                textEmail.setEditable(true);
                textPassword.setEditable(true);
                textQuestion.setEditable(true);
                textAnswer.setEditable(true);
                changeRegistrationDateButton.setEnabled(true);
                buttonCustomerCancel.setEnabled(true);
                buttonCustomerSave.setEnabled(true);
                buttonCustomerDelete.setEnabled(false);
                buttonCustomerEdit.setEnabled(false);

            }
        });

        buttonCustomerDelete = new Button(compositeButtons, SWT.PUSH
                | SWT.CENTER);
        buttonCustomerDelete.setText(l.getString("button.delete"));
        buttonCustomerDelete.setEnabled(false);
        buttonCustomerDelete.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                if (logger.isDebugEnabled()) {
                    logger
                            .debug("widgetSelected(SelectionEvent) - buttonCustomerDelete.widgetSelected, event="
                                    + evt);
                }

                String msg = MessageFormat
                        .format(
                                l
                                        .getString("Customer.groupdetail.deletebutton.question.text"),
                                new Object[] { textUserName.getText() });

                int question = showMsg(
                        msg,
                        l
                                .getString("Customer.groupdetail.deletebutton.question.header"),
                        SWT.ICON_QUESTION | SWT.YES | SWT.NO);

                if (question != SWT.YES) {
                    return;
                }
                try {

                    //object löschen
                    // Fehlerbehandlung

                    Database.deleteObject(localCustomer);

                    //ÜbersichtsTabelle aktualisieren
                    refreshCustomerTable(textCustomerSearch.getText());

                    //Detailansicht leeren
                    textCustomerID.setText("");
                    textUserName.setText("");
                    textLastName.setText("");
                    textFirstName.setText("");
                    textMiddleName.setText("");
                    textSalutation.setText("");
                    textTitle.setText("");
                    textBirthday.setText("");
                    textStreet.setText("");
                    textNumber.setText("");
                    textZipCode.setText("");
                    textCity.setText("");
                    textCountry.setText("");
                    textEmail.setText("");
                    textPassword.setText("");
                    textQuestion.setText("");
                    textAnswer.setText("");
                    textRegistrationDate.setText("");
                    buttonCustomerEdit.setEnabled(false);
                    buttonCustomerDelete.setEnabled(false);

                    try {
                        tableCustomer.deselectAll();
                    } catch (Exception ex) {
                    }

                    //Statusline Nachricht setzen
                    statusLine
                            .setStatus(
                                    1,
                                    l
                                            .getString("Customer.groupdetail.deletebutton.newok"));

                } catch (DataBaseException e) {
                    if (e.getMessage().equalsIgnoreCase("1")) {
                        //Fehler beim Speichern des Objectes

                        statusLine
                                .setStatus(
                                        3,
                                        l
                                                .getString("Customer.groupdetail.deletebutton.errorsave"));
                        showMsg(
                                l
                                        .getString("Customer.groupdetail.deletebutton.errorsave"),
                                l.getString("error"), SWT.ICON_ERROR | SWT.OK);

                    } else if (e.getMessage().equalsIgnoreCase("2")) {
                        //fehler beim db aufbau
                        statusLine
                                .setStatus(
                                        3,
                                        l
                                                .getString("Customer.groupdetail.deletebutton.errordb"));
                        showMsg(
                                l
                                        .getString("Customer.groupdetail.deletebutton.errordb"),
                                l.getString("error"), SWT.ICON_ERROR | SWT.OK);

                    } else {
                        //@todo
                        logger.error("widgetSelected(SelectionEvent)", e);
                    }

                }

            }

        });

        //leerer nicht sichtbarer Button
        buttonCustomerFill = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
        GridData buttonCustomerFillLData = new GridData();
        buttonCustomerFill.setVisible(false);
        buttonCustomerFill.setEnabled(false);
        buttonCustomerFillLData.widthHint = 30;
        buttonCustomerFillLData.heightHint = 23;
        buttonCustomerFill.setLayoutData(buttonCustomerFillLData);

        buttonCustomerSave = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
        buttonCustomerSave.setText(l.getString("button.save"));
        buttonCustomerSave.setEnabled(false);
        buttonCustomerSave.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {

                List errors = validateInput();

                if (errors.size() > 0) {
                    StringBuffer buf = new StringBuffer();

                    for (int i = 0; i < errors.size(); i++) {
                        buf.append("- ").append(errors.get(i)).append("\n");
                    }

                    showMsg(
                            l
                                    .getString("Customer.groupdetail.savebutton.warn.noitems.msg")
                                    + new String(buf),
                            l
                                    .getString("Customer.groupdetail.savebutton.warn.noitems.title"),
                            SWT.ICON_WARNING | SWT.YES);
                    return;

                }

                buttonCustomerEdit.setEnabled(false);
                buttonCustomerDelete.setEnabled(false);

                //testen welcher mode

                if (mode_Customer == ManagementGui.MODE_ADD) {

                    /**
                     * @todo eine Exception bekommen wieder leider NOCH nicht
                     *       mit d.h. es muss noch ein rückgabewert kommen oder
                     *       eine Exception übermitteln werden (aus der DB
                     *       Klasse)
                     */

                    try {

                        //neues Objekt erzeugen
                        Customer o = new Customer();
                        Person p = new Person();

                        o.setUserName(textUserName.getText());
                        Calendar cal = Calendar.getInstance();
                        try {
                            cal.setTime(DateFormat.getDateInstance(
                                    DateFormat.LONG).parse(
                                    textRegistrationDate.getText()));
                        } catch (ParseException pex) {
                            logger
                                    .warn(
                                            "Fehler beim Parsen des RegistrierungsDatum, wurde eigentlich vorher überprüft",
                                            pex);
                            return;
                        }
                        o.setDayOfRegistration(cal);

                        o.setUserPassword(textPassword.getText());
                        o.setHiddenQuestion(textQuestion.getText());
                        o.setHiddenAnswer(textAnswer.getText());
                        p.setLastName(textLastName.getText());
                        p.setFirstName(textFirstName.getText());
                        p.setMiddleName(textMiddleName.getText());
                        p.setSalutation(textSalutation.getText());
                        p.setTitle(textTitle.getText());
                        p.setStreet(textStreet.getText());
                        p.setStreetNumber(textNumber.getText());
                        p.setZipCode(textZipCode.getText());
                        p.setCity(textCity.getText());
                        p.setCountry(textCountry.getText());
                        p.setEmailAddress(textEmail.getText());
                        Calendar birthday = Calendar.getInstance();

                        try {
                            birthday.setTime(DateFormat.getDateInstance(
                                    DateFormat.LONG).parse(
                                    textBirthday.getText()));
                        } catch (ParseException pex) {
                            logger
                                    .warn(
                                            "Fehler beim Parsen des GeburtsDatum, wurde eigentlich vorher überprüft",
                                            pex);
                            return;
                        }
                        p.setDayOfBirth(birthday);
                        o.setPerson(p);

                        //object speichern
                        // Fehlerbehandlung
                        Object newCust = Database.saveObject(o);

                        //  Übersichtstabelle aktualisieren
                        refreshCustomerTable("");

                        //Statusline Nachricht sezten
                        statusLine
                                .setStatus(
                                        1,
                                        l
                                                .getString("Customer.groupdetail.savebutton.newok"));

                    } catch (DataBaseException e) {
                        if (e.getMessage().equalsIgnoreCase("1")) {
                            //Fehler beim Speichern des Objectes

                            statusLine
                                    .setStatus(
                                            3,
                                            l
                                                    .getString("Customer.groupdetail.savebutton.errorsave"));
                            showMsg(
                                    l
                                            .getString("Customer.groupdetail.savebutton.errorsave"),
                                    "Fehler", SWT.ICON_ERROR | SWT.OK);

                        } else if (e.getMessage().equalsIgnoreCase("2")) {
                            //fehler beim db aufbau
                            statusLine
                                    .setStatus(
                                            3,
                                            l
                                                    .getString("Customer.groupdetail.savebutton.errordb"));
                            showMsg(
                                    l
                                            .getString("Customer.groupdetail.savebutton.errordb"),
                                    "Fehler", SWT.ICON_ERROR | SWT.OK);

                        } else {
                            //@todo
                            logger.error("widgetSelected(SelectionEvent)", e);
                        }
                    }

                    // alle Buttons auf aktiv setzen
                    setCustomerGroupButtonSaveCancel();
                    buttonCustomerDelete.setEnabled(false);
                    buttonCustomerEdit.setEnabled(false);

                } else if (mode_Customer == ManagementGui.MODE_EDIT) {
                    try {

                        localCustomer.setUserName(textUserName.getText());

                        Calendar cal = Calendar.getInstance();
                        try {
                            cal.setTime(DateFormat.getDateInstance(
                                    DateFormat.LONG).parse(
                                    textRegistrationDate.getText()));
                        } catch (ParseException pex) {
                            logger
                                    .warn(
                                            "Fehler beim Parsen des RegistrierungsDatum, wurde eigentlich vorher überprüft",
                                            pex);
                            return;
                        }
                        localCustomer.setDayOfRegistration(cal);
                        localCustomer.setUserPassword(textPassword.getText());
                        localCustomer.setHiddenQuestion(textQuestion.getText());
                        localCustomer.setHiddenAnswer(textAnswer.getText());

                        localCustomer.getPerson().setLastName(
                                textLastName.getText());
                        localCustomer.getPerson().setFirstName(
                                textFirstName.getText());
                        localCustomer.getPerson().setMiddleName(
                                textMiddleName.getText());
                        localCustomer.getPerson().setSalutation(
                                textSalutation.getText());
                        localCustomer.getPerson().setTitle(textTitle.getText());
                        localCustomer.getPerson().setStreet(
                                textStreet.getText());
                        localCustomer.getPerson().setStreetNumber(
                                textNumber.getText());
                        localCustomer.getPerson().setZipCode(
                                textZipCode.getText());
                        localCustomer.getPerson().setCity(textCity.getText());
                        localCustomer.getPerson().setCountry(
                                textCountry.getText());
                        localCustomer.getPerson().setEmailAddress(
                                textEmail.getText());
                        Calendar birthday = Calendar.getInstance();

                        try {
                            birthday.setTime(DateFormat.getDateInstance(
                                    DateFormat.LONG).parse(
                                    textBirthday.getText()));
                        } catch (ParseException pex) {
                            logger
                                    .warn(
                                            "Fehler beim Parsen des GeburtsDatum, wurde eigentlich vorher überprüft",
                                            pex);
                            return;
                        }
                        localCustomer.getPerson().setDayOfBirth(birthday);

                        Database.updateObject(localCustomer);
                        //Übersichtstabelle aktualisieren
                        refreshCustomerTable(textCustomerSearch.getText());

                        //Statusline Nachricht sezten
                        statusLine
                                .setStatus(
                                        1,
                                        l
                                                .getString("Customer.groupdetail.savebutton.editok"));

                    } catch (DataBaseException e) {
                        if (e.getMessage().equalsIgnoreCase("1")) {
                            //Fehler beim Speichern des Objectes

                            statusLine
                                    .setStatus(
                                            3,
                                            l
                                                    .getString("Customer.groupdetail.savebutton.errorsave"));
                            showMsg(
                                    l
                                            .getString("Customer.groupdetail.savebutton.errorsave"),
                                    "Fehler", SWT.ICON_ERROR | SWT.OK);

                        } else if (e.getMessage().equalsIgnoreCase("2")) {
                            //fehler beim db aufbau
                            statusLine
                                    .setStatus(
                                            3,
                                            l
                                                    .getString("Customer.groupdetail.savebutton.errordb"));
                            showMsg(
                                    l
                                            .getString("Customer.groupdetail.savebutton.errordb"),
                                    "Fehler", SWT.ICON_ERROR | SWT.OK);

                        } else {
                            //@todo
                            logger.error("widgetSelected(SelectionEvent)", e);
                        }

                    }

                    //alle Buttons auf aktiv setzen
                    setCustomerGroupButtonSaveCancel();
                    buttonCustomerDelete.setEnabled(false);
                    buttonCustomerEdit.setEnabled(false);
                }

                /**
                 * @todo Exception werfen, da nur die zwei Modes sein dürfen
                 */

            }
        });

        buttonCustomerCancel = new Button(compositeButtons, SWT.PUSH
                | SWT.CENTER);
        buttonCustomerCancel.setText(l.getString("button.cancel"));
        buttonCustomerCancel.setEnabled(false);
        buttonCustomerCancel.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                if (logger.isDebugEnabled()) {
                    logger
                            .debug("widgetSelected(SelectionEvent) - buttonCustomerCancel.widgetSelected, event="
                                    + evt);
                }
                setCustomerGroupButtonSaveCancel();
            }
        });

    }

    /**
     *  
     */
    private void setCustomerGroupButtonSaveCancel() {
        buttonCustomerSave.setEnabled(false);
        buttonCustomerCancel.setEnabled(false);
        buttonCustomerEdit.setEnabled(true);
        buttonCustomerNew.setEnabled(true);
        buttonCustomerDelete.setEnabled(true);
        textUserName.setEditable(false);
        textLastName.setEditable(false);
        textFirstName.setEditable(false);
        textMiddleName.setEditable(false);
        textSalutation.setEditable(false);
        textTitle.setEditable(false);
        changeBirthdayDateButton.setEnabled(false);
        textStreet.setEditable(false);
        textNumber.setEditable(false);
        textZipCode.setEditable(false);
        textCity.setEditable(false);
        textCountry.setEditable(false);
        textEmail.setEditable(false);
        textPassword.setEditable(false);
        textQuestion.setEditable(false);
        textAnswer.setEditable(false);
        changeRegistrationDateButton.setEnabled(false);
        textCustomerSearch.setEditable(true);

        // CustomerTabelle aktivieren
        tableCustomer.setEnabled(true);

        //CustomerSearch aktivieren
        textCustomerSearch.setEnabled(true);

    }

    /**
     * @param text
     * @throws DataBaseException
     */
    private void refreshCustomerTable(final String filter)
            throws DataBaseException {
        if (logger.isDebugEnabled()) {
            logger
                    .debug("refreshCustomerTable(String) - Versuche nun CustomerListe zu refreshen. Filter: "
                            + filter);
        }
        if (tableCustomer == null) {
            if (logger.isDebugEnabled()) {
                logger
                        .debug("refreshCustomerTable(String) - Konnte Customertable nicht refreshen, da diese null ist!");
            }
            return;
        }

        tableCustomer.removeAll();
        TableItem item;
        java.util.List Customerlist = Database.getCustomer(filter);

        for (int i = 0; i < Customerlist.size(); i++) {

            Customer o = (Customer) Customerlist.get(i);

            item = new TableItem(tableCustomer, SWT.NONE);
            String birthday = "";
            if (o.getPerson().getDayOfBirth() != null) {
                birthday = DateFormat.getDateInstance(DateFormat.SHORT).format(
                        o.getPerson().getDayOfBirth().getTime());
            }
            String regdate = "";
            if (o.getDayOfRegistration() != null) {
                regdate = DateFormat.getDateInstance(DateFormat.SHORT).format(
                    o.getDayOfRegistration().getTime());
            }
            item.setText(new String[] { o.getCustomerId() + "",
                    o.getUserName(), o.getPerson().getLastName(),
                    o.getPerson().getFirstName(), birthday, regdate });

        }

    }

    /**
     *  
     */
    private void initCustomerGroupOverview() {
        if (logger.isDebugEnabled()) {
            logger.debug("initCustomerGroupOverview() - start");
        }

        groupCustomerOverview = new Group(sashFormCustomer, SWT.NONE);
        GridLayout group5Layout = new GridLayout();
        group5Layout.numColumns = 8;
        groupCustomerOverview.setText(l
                .getString("Customer.groupoverview.label"));
        FormData group5LData = new FormData();
        groupCustomerOverview.setLayout(group5Layout);
        group5LData.left = new FormAttachment(0, 100, 0);
        group5LData.top = new FormAttachment(0, 100, 0);
        groupCustomerOverview.setLayoutData(group5LData);

        //Tabelle anzeigen
        initTableCustomer();
        //Suche darunter anzeigen
        initCustomerSearch();

        if (logger.isDebugEnabled()) {
            logger.debug("initCustomerGroupOverview() - end");
        }

    }

    /**
     *  
     */
    private void initCustomerSearch() {
        if (logger.isDebugEnabled()) {
            logger.debug("initCustomerSearch() - start");
        }

        //label für die Suche
        labelCustomerSearch = new Label(groupCustomerOverview, SWT.NONE);
        labelCustomerSearch.setText(l
                .getString("Customer.groupoverview.searchlabel")
                + ":");
        GridData label2LData = new GridData();
        label2LData.horizontalSpan = 3;
        labelCustomerSearch.setLayoutData(label2LData);

        //das Suchfeld
        textCustomerSearch = new Text(groupCustomerOverview, SWT.BORDER);
        GridData text2LData = new GridData();
        textCustomerSearch.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                if (logger.isDebugEnabled()) {
                    logger.debug("focusLost(FocusEvent evt = " + evt + " "
                            + textCustomerSearch.getText() + ") - start");
                }

                try {
                    refreshCustomerTable(textCustomerSearch.getText());
                } catch (DataBaseException e) {
                    // TODO Auto-generated catch block
                    logger.error("focusLost(FocusEvent)", e);
                }

                if (logger.isDebugEnabled()) {
                    logger.debug("focusLost(FocusEvent) - end");
                }
            }
        });

        textCustomerSearch.addListener(SWT.DefaultSelection, new Listener() {
            public void handleEvent(Event e) {
                if (logger.isDebugEnabled()) {
                    logger.debug("handleEvent(Event e = " + e + " "
                            + textCustomerSearch.getText() + ") - start");
                }

                try {
                    refreshCustomerTable(textCustomerSearch.getText());
                } catch (DataBaseException e1) {
                    // TODO Auto-generated catch block
                    logger.error("handleEvent(Event)", e1);
                }

                if (logger.isDebugEnabled()) {
                    logger.debug("handleEvent(Event) - end");
                }
            }
        });

        text2LData.horizontalAlignment = GridData.FILL;
        text2LData.horizontalSpan = 5;
        text2LData.grabExcessHorizontalSpace = true;
        textCustomerSearch.setLayoutData(text2LData);

        if (logger.isDebugEnabled()) {
            logger.debug("initCustomerSearch() - end");
        }

    }

    /**
     *  
     */
    private void initTableCustomer() {
        if (logger.isDebugEnabled()) {
            logger.debug("initTableCustomer() - start");
        }

        tableCustomer = new Table(groupCustomerOverview, SWT.SINGLE
                | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.BORDER);
        tableCustomer.setHeaderVisible(true);
        tableCustomer.setLinesVisible(true);
        GridData table2LData = new GridData();

        tableCustomer.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {

                int index = tableCustomer.getSelectionIndex();

                //es wurde ein Element aus Tabelle ausgewaehlt jetzt muss die
                //Detailansicht aktualisiert werden
                refreshCustomerDetail(tableCustomer.getItem(index).getText(0));

            }
        });
        table2LData.verticalAlignment = GridData.FILL;
        table2LData.horizontalAlignment = GridData.FILL;
        table2LData.horizontalSpan = 8;
        table2LData.grabExcessHorizontalSpace = true;
        table2LData.grabExcessVerticalSpace = true;
        tableCustomer.setLayoutData(table2LData);

        //einzelne Spalten hinzufügen
        tableColumn = new TableColumn(tableCustomer, SWT.CENTER);
        tableColumn.setText(l.getString("Customer.groupoverview.columnid"));
        tableColumn.setWidth(50);

        tableColumn = new TableColumn(tableCustomer, SWT.CENTER);
        tableColumn.setText(l
                .getString("Customer.groupoverview.columnusername"));
        tableColumn.setWidth(50);

        tableColumn = new TableColumn(tableCustomer, SWT.CENTER);
        tableColumn.setText(l
                .getString("Customer.groupoverview.columnlastname"));
        tableColumn.setWidth(70);

        tableColumn = new TableColumn(tableCustomer, SWT.CENTER);
        tableColumn.setText(l
                .getString("Customer.groupoverview.columnfirstname"));
        tableColumn.setWidth(70);

        tableColumn = new TableColumn(tableCustomer, SWT.CENTER);
        tableColumn.setText(l
                .getString("Customer.groupoverview.columnbirthday"));
        tableColumn.setWidth(70);
        tableColumn = new TableColumn(tableCustomer, SWT.CENTER);
        tableColumn
                .setText(l.getString("Customer.groupoverview.columnregdate"));
        tableColumn.setWidth(70);

        if (logger.isDebugEnabled()) {
            logger.debug("initTableCustomer() - end");
        }

    }

    /**
     * @param text
     */
    private void refreshCustomerDetail(final String id) {
        if (!id.equals("") && id != null) {
            Customer object;
            try {
                //since we only can get a String value from the table, we
                //need to convert this
                object = Database.getSingleCustomer(Integer.parseInt(id));

                if (object == null) {

                    // @TODO Statusbar aktualiseren
                    return;
                }
            } catch (Exception e) {
                //id ist keine Zahl
                return;
            }
            localCustomer = object;

            String temp = null;
            textCustomerID.setText(object.getCustomerId() + "");

            temp = object.getUserName();
            textUserName.setText(temp == null ? "" : temp);
            temp = object.getPerson().getLastName();
            textLastName.setText(temp == null ? "" : temp);
            temp = object.getPerson().getFirstName();
            textFirstName.setText(temp == null ? "" : temp);
            temp = object.getPerson().getMiddleName();
            textMiddleName.setText(temp == null ? "" : temp);
            temp = object.getPerson().getSalutation();
            textSalutation.setText(temp == null ? "" : temp);
            temp = object.getPerson().getTitle();
            textTitle.setText(temp == null ? "" : temp);
            temp = object.getPerson().getStreet();
            textStreet.setText(temp == null ? "" : temp);
            temp = object.getPerson().getStreetNumber();
            textNumber.setText(temp == null ? "" : temp);
            temp = object.getPerson().getCity();
            textCity.setText(temp == null ? "" : temp);
            temp = object.getPerson().getZipCode();
            textZipCode.setText(temp == null ? "" : temp);
            temp = object.getPerson().getCountry();
            textCountry.setText(temp == null ? "" : temp);
            temp = object.getUserPassword();
            textPassword.setText(temp == null ? "" : temp);
            temp = object.getPerson().getEmailAddress();
            textEmail.setText(temp == null ? "" : temp);
            temp = object.getHiddenQuestion();
            textQuestion.setText(temp == null ? "" : temp);
            temp = object.getHiddenAnswer();
            textAnswer.setText(temp == null ? "" : temp);

            if (object.getPerson().getDayOfBirth() == null) {
                textBirthday.setText("");
            } else {

                textBirthday.setText(DateFormat
                        .getDateInstance(DateFormat.LONG).format(
                                object.getPerson().getDayOfBirth().getTime()));

            }

            if (object.getDayOfRegistration() == null) {
                textRegistrationDate.setText("");
            } else {
                textRegistrationDate.setText(DateFormat.getDateInstance(
                        DateFormat.LONG).format(
                        object.getDayOfRegistration().getTime()));

            }

            //Buttons zum löschen und editieren aktivieren

            buttonCustomerEdit.setEnabled(true);
            buttonCustomerDelete.setEnabled(true);

        } else {
            //          Detailansicht leeren
            textCustomerID.setText("");
            textUserName.setText("");
            textLastName.setText("");
            textFirstName.setText("");
            textMiddleName.setText("");
            textSalutation.setText("");
            textTitle.setText("");
            textBirthday.setText("");
            textStreet.setText("");
            textNumber.setText("");
            textZipCode.setText("");
            textCity.setText("");
            textCountry.setText("");
            textEmail.setText("");
            textPassword.setText("");
            textQuestion.setText("");
            textAnswer.setText("");
            textRegistrationDate.setText("");

            buttonCustomerEdit.setEnabled(false);
            buttonCustomerDelete.setEnabled(false);
        }

        //Mode auf view setzen
        mode_Customer = ManagementGui.MODE_VIEW;

    }

    private List validateInput() {

        List errors = new ArrayList();

        //testen ob duration leer ist;
        if (textUserName.getText().trim().equalsIgnoreCase("")) {
            errors
                    .add(l
                            .getString("Customer.groupdetail.savebutton.warn.nousername"));
        }
        if (textLastName.getText().trim().equalsIgnoreCase("")) {
            errors
                    .add(l
                            .getString("Customer.groupdetail.savebutton.warn.nolastname"));
        }
        if (textFirstName.getText().trim().equalsIgnoreCase("")) {
            errors
                    .add(l
                            .getString("Customer.groupdetail.savebutton.warn.nofirstname"));
        }
        if (textStreet.getText().trim().equalsIgnoreCase("")) {
            errors
                    .add(l
                            .getString("Customer.groupdetail.savebutton.warn.nostreet"));
        }
        if (textNumber.getText().trim().equalsIgnoreCase("")) {
            errors
                    .add(l
                            .getString("Customer.groupdetail.savebutton.warn.nonumber"));
        }
        if (textZipCode.getText().trim().equalsIgnoreCase("")) {
            errors
                    .add(l
                            .getString("Customer.groupdetail.savebutton.warn.nozipcode"));
        }
        if (textCity.getText().trim().equalsIgnoreCase("")) {
            errors.add(l
                    .getString("Customer.groupdetail.savebutton.warn.nocity"));
        }
        if (textCountry.getText().trim().equalsIgnoreCase("")) {
            errors
                    .add(l
                            .getString("Customer.groupdetail.savebutton.warn.nocountry"));
        }
        if (textEmail.getText().trim().equalsIgnoreCase("")) {
            errors.add(l
                    .getString("Customer.groupdetail.savebutton.warn.noemail"));
        }
        if (textQuestion.getText().trim().equalsIgnoreCase("")) {
            errors
                    .add(l
                            .getString("Customer.groupdetail.savebutton.warn.noquestion"));
        }
        if (textAnswer.getText().trim().equalsIgnoreCase("")) {
            errors
                    .add(l
                            .getString("Customer.groupdetail.savebutton.warn.noanswer"));
        }
        if (textRegistrationDate.getText().trim().equalsIgnoreCase("")) {
            errors
                    .add(l
                            .getString("Customer.groupdetail.savebutton.warn.noregistrationdate"));
        } else {

            try {
                DateFormat.getDateInstance(DateFormat.LONG).parse(
                        textRegistrationDate.getText());
            } catch (ParseException e) {
                //konnte Datum nicht parsen,also falsches Format = Fehlereingabe
                errors
                        .add(l
                                .getString("Customer.groupdetail.savebutton.warn.noregistrationdate"));
            }

        }
        if (textBirthday.getText().trim().equalsIgnoreCase("")) {
            errors
                    .add(l
                            .getString("Customer.groupdetail.savebutton.warn.nobirthday"));
        } else {

            try {
                DateFormat.getDateInstance(DateFormat.LONG).parse(
                        textBirthday.getText());
            } catch (ParseException e) {
                //konnte Datum nicht parsen,also falsches Format = Fehlereingabe
                errors
                        .add(l
                                .getString("Customer.groupdetail.savebutton.warn.nobirthday"));
            }

        }

        return errors;
    }

}
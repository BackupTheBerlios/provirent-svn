package de.hsharz.provirent.management.gui;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Hashtable;
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
public class CompositeCustomer extends AbstractComposite{

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

    private Label labelCustomerId;   
    private Label labelCustomerName;
    private Label labelduration1;
    private Label labelduration2;
    private Label labelduration3;
    private Label labelstartdate;
    
    private Text textCustomerID;
    private Text textCustomerName;
    private Text textduration1;
    private Text textduration2;
    private Text textduration3;
    private Text textstartdate;
    
    private Text textCustomerSearch;
    private Label labelCustomerSearch;
    
    private Button buttonCustomerCancel;
    private Button buttonCustomerSave;
    private Button buttonCustomerFill;
    private Button buttonCustomerDelete;
    private Button buttonCustomerEdit;
    private Button buttonCustomerNew;
           
    private Table tableCustomer;
    private TableColumn tableColumn;

    Hashtable list = null;

    private final static int MODE_EDIT = 2;
    
    private StatusLineStyledText statusLine;

    private ResourceBundle l;
    
    protected int mode_Customer;


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


    private Label labelSalutation;


    private Text textSalutation;


    private Label labelTitle;


    private Text textTitle;


    private Label labelStreet;


    private Text textStreet;


    private Label labelNumber;


    private Text textNumber;


    private Label labelZipCode;


    private Text textZipCode;


    private Label labelCountry;


    private Text textCountry;


    private Label labelCityr;


    private Label labelCity;


    private Text textCity;


    private Label labelEmail;


    private Text textEmail;


    private Label labelQuestion;


    private Text textQuestion;


    private Label labelAnswer;


    private Text textAnswer;
 
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
                    System.out.println("groupCustomer.focusLost, event="
                        + evt);
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
        groupCustomerDetailLayout.numColumns = 6;
        groupCustomerDetailLayout.verticalSpacing = 15;
        groupCustomerDetail.setText(l
                .getString("Customer.groupdetail.label"));
        FormData formData = new FormData();
        groupCustomerDetail.setLayout(groupCustomerDetailLayout);
        formData.right = new FormAttachment(100, 100, -5);
        formData.top = new FormAttachment(0, 100, 5);
        formData.bottom = new FormAttachment(100, 100, -5);
        groupCustomerDetail.setLayoutData(formData);
        {
            labelCustomerId = new Label(groupCustomerDetail, SWT.NONE);
            labelCustomerId.setText(l
                    .getString("Customer.groupdetail.idlabel")
                    + ":");
            labelCustomerId.setSize(125, 15);
            GridData formData2 = new GridData();
            formData2.widthHint = 125;
            formData2.heightHint = 15;
            formData2.horizontalSpan = 2;
            labelCustomerId.setLayoutData(formData2);
        }        
        {
            textCustomerID = new Text(groupCustomerDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData1 = new GridData();
            text1LData1.horizontalAlignment = GridData.FILL;
            text1LData1.heightHint = 13;
            text1LData1.horizontalSpan = 4;
            text1LData1.grabExcessHorizontalSpace = true;
            textCustomerID.setLayoutData(text1LData1);
        }
        {
            labelUserName = new Label(groupCustomerDetail, SWT.NONE);
            labelUserName.setText(l
                    .getString("Customer.groupdetail.usernamelabel")
                    + ":");
            labelUserName.setSize(125, 15);
            GridData formData2 = new GridData();
            formData2.widthHint = 125;
            formData2.heightHint = 15;
            formData2.horizontalSpan = 2;
            labelUserName.setLayoutData(formData2);
        }
        {
            textUserName = new Text(groupCustomerDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData1 = new GridData();
            text1LData1.horizontalAlignment = GridData.FILL;
            text1LData1.heightHint = 13;
            text1LData1.horizontalSpan = 4;
            text1LData1.grabExcessHorizontalSpace = true;
            textUserName.setLayoutData(text1LData1);
        }
        {
            labelLastName = new Label(groupCustomerDetail, SWT.NONE);
            labelLastName.setText(l
                    .getString("Customer.groupdetail.lastnamelabel")
                    + ":");
            labelLastName.setSize(125, 15);
            GridData labelLastNameLData = new GridData();
            labelLastNameLData.widthHint = 125;
            labelLastNameLData.heightHint = 15;
            labelLastNameLData.horizontalSpan = 2;
            labelLastName.setLayoutData(labelLastNameLData);
        }
        {
            textLastName = new Text(groupCustomerDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData2 = new GridData();
            text1LData2.horizontalAlignment = GridData.FILL;
            text1LData2.heightHint = 13;
            text1LData2.horizontalSpan = 4;
            text1LData2.grabExcessHorizontalSpace = true;
            textLastName.setLayoutData(text1LData2);
        }
        {
            labelFirstName = new Label(groupCustomerDetail,
                    SWT.NONE);
            labelFirstName.setText(l
                    .getString("Customer.groupdetail.firstnamelabel")
                    + ":");
            labelFirstName.setSize(125, 15);
            GridData label2LData1 = new GridData();
            label2LData1.widthHint = 125;
            label2LData1.heightHint = 15;
            label2LData1.horizontalSpan = 2;
            labelFirstName.setLayoutData(label2LData1);
        }
        {
            textFirstName = new Text(groupCustomerDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 4;
            text1LData3.grabExcessHorizontalSpace = true;
            textFirstName.setLayoutData(text1LData3);
        }
        {
            labelMiddleName = new Label(groupCustomerDetail,
                    SWT.NONE);
            labelMiddleName.setText(l
                    .getString("Customer.groupdetail.middlenamelabel")
                    + ":");
            labelMiddleName.setSize(125, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 125;
            label1LData1.heightHint = 15;
            label1LData1.horizontalSpan = 2;
            labelMiddleName.setLayoutData(label1LData1);
        }
        {
            textMiddleName = new Text(groupCustomerDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 4;
            text1LData3.grabExcessHorizontalSpace = true;
            textMiddleName.setLayoutData(text1LData3);
        }
        {
            labelSalutation = new Label(groupCustomerDetail,
                    SWT.NONE);
            labelSalutation.setText(l
                    .getString("Customer.groupdetail.salutationlabel")
                    + ":");
            labelSalutation.setSize(125, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 125;
            label1LData1.heightHint = 15;
            label1LData1.horizontalSpan = 2;
            labelSalutation.setLayoutData(label1LData1);
        }
        {
            textSalutation = new Text(groupCustomerDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 4;
            text1LData3.grabExcessHorizontalSpace = true;
            textSalutation.setLayoutData(text1LData3);
        }
        {
            labelTitle = new Label(groupCustomerDetail,
                    SWT.NONE);
            labelTitle.setText(l
                    .getString("Customer.groupdetail.titlelabel")
                    + ":");
            labelTitle.setSize(125, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 125;
            label1LData1.heightHint = 15;
            label1LData1.horizontalSpan = 2;
            labelTitle.setLayoutData(label1LData1);
        }
        {
            textTitle = new Text(groupCustomerDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 4;
            text1LData3.grabExcessHorizontalSpace = true;
            textTitle.setLayoutData(text1LData3);
        }
        {
            labelStreet = new Label(groupCustomerDetail,
                    SWT.NONE);
            labelStreet.setText(l
                    .getString("Customer.groupdetail.streetlabel")
                    + ":");
            labelStreet.setSize(125, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 125;
            label1LData1.heightHint = 15;
            label1LData1.horizontalSpan = 2;
            labelStreet.setLayoutData(label1LData1);
        }
        {
            textStreet = new Text(groupCustomerDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 4;
            text1LData3.grabExcessHorizontalSpace = true;
            textStreet.setLayoutData(text1LData3);
        }
        {
            labelNumber = new Label(groupCustomerDetail,
                    SWT.NONE);
            labelNumber.setText(l
                    .getString("Customer.groupdetail.numberlabel")
                    + ":");
            labelNumber.setSize(125, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 125;
            label1LData1.heightHint = 15;
            label1LData1.horizontalSpan = 2;
            labelNumber.setLayoutData(label1LData1);
        }
        {
            textNumber = new Text(groupCustomerDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 4;
            text1LData3.grabExcessHorizontalSpace = true;
            textNumber.setLayoutData(text1LData3);
        }
        {
            labelCity = new Label(groupCustomerDetail,
                    SWT.NONE);
            labelCity.setText(l
                    .getString("Customer.groupdetail.citylabel")
                    + ":");
            labelCity.setSize(125, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 125;
            label1LData1.heightHint = 15;
            label1LData1.horizontalSpan = 2;
            labelCity.setLayoutData(label1LData1);
        }
        {
            textCity = new Text(groupCustomerDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 4;
            text1LData3.grabExcessHorizontalSpace = true;
            textCity.setLayoutData(text1LData3);
        }
        {
            labelZipCode = new Label(groupCustomerDetail,
                    SWT.NONE);
            labelZipCode.setText(l
                    .getString("Customer.groupdetail.zipcodelabel")
                    + ":");
            labelZipCode.setSize(125, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 125;
            label1LData1.heightHint = 15;
            label1LData1.horizontalSpan = 2;
            labelZipCode.setLayoutData(label1LData1);
        }
        {
            textZipCode = new Text(groupCustomerDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 4;
            text1LData3.grabExcessHorizontalSpace = true;
            textZipCode.setLayoutData(text1LData3);
        }
        {
            labelCountry = new Label(groupCustomerDetail,
                    SWT.NONE);
            labelCountry.setText(l
                    .getString("Customer.groupdetail.countrylabel")
                    + ":");
            labelCountry.setSize(125, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 125;
            label1LData1.heightHint = 15;
            label1LData1.horizontalSpan = 2;
            labelCountry.setLayoutData(label1LData1);
        }
        {
            textCountry = new Text(groupCustomerDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 4;
            text1LData3.grabExcessHorizontalSpace = true;
            textCountry.setLayoutData(text1LData3);
        }
        {
            labelPassword = new Label(groupCustomerDetail,
                    SWT.NONE);
            labelPassword.setText(l
                    .getString("Customer.groupdetail.passwordlabel")
                    + ":");
            labelPassword.setSize(125, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 125;
            label1LData1.heightHint = 15;
            label1LData1.horizontalSpan = 2;
            labelPassword.setLayoutData(label1LData1);
        }
        {
            textPassword = new Text(groupCustomerDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 3;
            text1LData3.grabExcessHorizontalSpace = true;
            textPassword.setLayoutData(text1LData3);
        }
        {
            labelEmail = new Label(groupCustomerDetail,
                    SWT.NONE);
            labelEmail.setText(l
                    .getString("Customer.groupdetail.emaillabel")
                    + ":");
            labelEmail.setSize(125, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 125;
            label1LData1.heightHint = 15;
            label1LData1.horizontalSpan = 2;
            labelEmail.setLayoutData(label1LData1);
        }
        {
            textEmail = new Text(groupCustomerDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 3;
            text1LData3.grabExcessHorizontalSpace = true;
            textEmail.setLayoutData(text1LData3);
        }
        {
            labelQuestion = new Label(groupCustomerDetail,
                    SWT.NONE);
            labelQuestion.setText(l
                    .getString("Customer.groupdetail.questionlabel")
                    + ":");
            labelQuestion.setSize(125, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 125;
            label1LData1.heightHint = 15;
            label1LData1.horizontalSpan = 2;
            labelQuestion.setLayoutData(label1LData1);
        }
        {
            textQuestion = new Text(groupCustomerDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 3;
            text1LData3.grabExcessHorizontalSpace = true;
            textQuestion.setLayoutData(text1LData3);
        }
        {
            labelAnswer = new Label(groupCustomerDetail,
                    SWT.NONE);
            labelAnswer.setText(l
                    .getString("Customer.groupdetail.answerlabel")
                    + ":");
            labelAnswer.setSize(125, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 125;
            label1LData1.heightHint = 15;
            label1LData1.horizontalSpan = 2;
            labelAnswer.setLayoutData(label1LData1);
        }
        {
            textAnswer = new Text(groupCustomerDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 3;
            text1LData3.grabExcessHorizontalSpace = true;
            textAnswer.setLayoutData(text1LData3);
        }
        {
            labelBirthday = new Label(groupCustomerDetail,
                    SWT.NONE);
            labelBirthday.setText(l
                    .getString("Customer.groupdetail.birthdaylabel")
                    + ":");
            labelBirthday.setSize(125, 15);
            GridData label1LData1 = new GridData();
            label1LData1.widthHint = 125;
            label1LData1.heightHint = 15;
            label1LData1.horizontalSpan = 2;
            labelBirthday.setLayoutData(label1LData1);
        }
        {
            textBirthday = new Text(groupCustomerDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 3;
            text1LData3.grabExcessHorizontalSpace = true;
            textBirthday.setLayoutData(text1LData3);
            textBirthday.setEnabled(false);
        }
        {
            textRegistrationDate = new Text(groupCustomerDetail,
                    SWT.READ_ONLY | SWT.BORDER);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 13;
            text1LData3.horizontalSpan = 3;
            text1LData3.grabExcessHorizontalSpace = true;
            textRegistrationDate.setLayoutData(text1LData3);
            textRegistrationDate.setEnabled(false);
        }
        {
            changeRegistrationDateButton = new Button(groupCustomerDetail, SWT.PUSH
                | SWT.CENTER);
            changeRegistrationDateButton.setText(l.getString("Customer.groupdetail.registrationdatebuttonchange"));
            GridData text1LData3 = new GridData();
            changeRegistrationDateButton.setEnabled(false);
            changeRegistrationDateButton.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent evt) {

                    final SWTCalendarDialog cal = new SWTCalendarDialog(getDisplay(),l.getString("Customer.groupdetail.registrationdatebuttonfinish"));

                    cal.addDateChangedListener(new SWTCalendarListener() {

                        public void dateChanged(SWTCalendarEvent calendarEvent) {

                            textRegistrationDate.setText( DateFormat.getDateInstance(DateFormat.LONG).format(calendarEvent.getCalendar().getTime()));

                        }

                    });



                    if (textRegistrationDate.getText() != null && textRegistrationDate.getText().length() > 0) {

                        try {
                               cal.setDate(DateFormat.getDateInstance(DateFormat.LONG).parse(textRegistrationDate.getText()));

                        } catch (ParseException pe) {



                        }

                    }

                    cal.open();                    
                    
                    
                }
            });
            text1LData3.horizontalAlignment = GridData.FILL;
            
            text1LData3.horizontalSpan = 1;
            text1LData3.grabExcessHorizontalSpace = true;
            changeRegistrationDateButton.setLayoutData(text1LData3);
        }
        /*{

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

        }*/

        
    }

    /**
     * 
     */
    /*private void initCustomerDetailButtons() {
        buttonCustomerNew = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
        buttonCustomerNew.setText(l.getString("button.new"));
        buttonCustomerNew.addSelectionListener(new SelectionAdapter() {
            

            public void widgetSelected(SelectionEvent evt) {

                textCustomerID.setText("");
                textCustomerName.setText("");
                textduration1.setText("");
                textduration2.setText("");
                textduration3.setText("");
                textstartdate.setText("");

                textCustomerName.setEditable(true);
                textduration1.setEditable(true);
                textduration2.setEditable(true);
                textduration3.setEditable(true);
                //textstartdate.setEditable(true);
                changeStartDateButton.setEnabled(true);
                
                
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

                textCustomerID.setEditable(false);
                textCustomerName.setEditable(true);
                textduration1.setEditable(true);
                textduration2.setEditable(true);                
                textduration3.setEditable(true);
                //textstartdate.setEditable(true);
                changeStartDateButton.setEnabled(true);
                
                textduration1.setFocus();
                
                buttonCustomerCancel.setEnabled(true);
                buttonCustomerSave.setEnabled(true);
                buttonCustomerNew.setEnabled(false);
                buttonCustomerEdit.setEnabled(false);
                buttonCustomerDelete.setEnabled(false);


                tableCustomer.setEnabled(false);
                textCustomerSearch.setEnabled(false);
                

            }
        });

        buttonCustomerDelete = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
        buttonCustomerDelete.setText(l.getString("button.delete"));
        buttonCustomerDelete.setEnabled(false);
        buttonCustomerDelete.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                System.out
                        .println("buttonCustomerDelete.widgetSelected, event="
                                + evt);
                
                
               String msg = MessageFormat.format(
                       l.getString("Customer.groupdetail.deletebutton.question.text"),
                               new Object[]{textCustomerName.getText() + " " + 
                               				textduration1.getText() + " " + 
                               				textduration2.getText() + " " + 
                               				textduration3.getText() + " " +
                               				textstartdate.getText()});
                
               int question = showMsg(msg,
                       l.getString("Customer.groupdetail.deletebutton.question.header"), 
                       SWT.ICON_QUESTION | SWT.YES | SWT.NO);
               
               if (question != SWT.YES){
                   return;
               }
                try {
	                Customer o = new Customer();
	                o.setCustomerId(new Integer(Integer.parseInt(textCustomerID.getText())));
	                o.setUserName(textCustomerName.getText());
	                o.setDuration1(Float.parseFloat(textduration1.getText()));
	                o.setDuration2(Float.parseFloat(textduration2.getText()));
	                o.setDuration3(Float.parseFloat(textduration3.getText()));                
	                o.setStartdate(Util.getDateByText(textstartdate.getText()));

                    //object speichern
                    // Fehlerbehandlung
                    Database.deleteObject(o);

                    //ÜbersichtsTabelle aktualisieren
                    refreshCustomerTable(textCustomerSearch.getText());
                    
                    //Detailansicht leeren
                    textCustomerID.setText("");
                    textCustomerName.setText("");
                    textduration1.setText("");
                    textduration2.setText("");
                    textduration3.setText("");
                    textstartdate.setText("");
                    buttonCustomerEdit.setEnabled(false);
                    buttonCustomerDelete.setEnabled(false);
                    //in Tabelle nächsten auswählen
                    try {
                        tableCustomer.deselectAll();
                    } catch (Exception ex) {}
                    
                    //Statusline Nachricht sezten
                    statusLine.setStatus(1,l.getString("Customer.groupdetail.deletebutton.newok"));

                } catch (DataBaseException e) {
                    if (e.getMessage().equalsIgnoreCase("1")) {
                        //Fehler beim Speichern des Objectes

                        statusLine.setStatus(3,l.getString("Customer.groupdetail.deletebutton.errorsave"));
                        showMsg(l.getString("Customer.groupdetail.deletebutton.errorsave"),
                                l.getString("error"), SWT.ICON_ERROR | SWT.OK);
                        
                    } else if (e.getMessage().equalsIgnoreCase("2")) {
                        //fehler beim db aufbau
                        statusLine.setStatus(3,l.getString("Customer.groupdetail.deletebutton.errordb"));
                        showMsg(l.getString("Customer.groupdetail.deletebutton.errordb"),
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
    
                //testen ob duration leer ist
                if (   textCustomerName.getText().trim().equalsIgnoreCase("") ||
                       textduration1.getText().trim().equalsIgnoreCase("") || 
                       textduration2.getText().trim().equalsIgnoreCase("") || 
                       textduration3.getText().trim().equalsIgnoreCase("") ||
                       textstartdate.getText().trim().equalsIgnoreCase("")) {
                    
                    showMsg(l.getString("Customer.groupdetail.savebutton.warn.noname.msg"),
                            l.getString("Customer.groupdetail.savebutton.warn.noname.title"),
                            SWT.ICON_WARNING | SWT.YES);

                    	return;
                }
                
                buttonCustomerEdit.setEnabled(false);
                buttonCustomerDelete.setEnabled(false);
                
                //testen welcher mode
                
                if (mode_Customer == ManagementGui.MODE_ADD) {
                    
                    /**
                     * @todo eine Exception bekommen wieder leider NOCH nicht mit
                     * d.h. es muss noch ein rückgabewert kommen oder eine Exception 
                     * übermitteln werden (aus der DB Klasse)
                     /
	                    
                    try {	
                        
                        Calendar tmp_cal = Calendar.getInstance();
                        tmp_cal.setTime(DateFormat.getDateInstance(DateFormat.LONG).parse(textstartdate.getText()));
                    	//neues Objekt erzeugen
	                    Customer tmp = new Customer(textCustomerName.getText(), 
                            			Float.parseFloat(textduration1.getText()),
                            			Float.parseFloat(textduration2.getText()), 
                            			Float.parseFloat(textduration3.getText()),
                            			tmp_cal);
                                        
                        //object speichern
                        // Fehlerbehandlung
                        Object o = Database.saveObject(tmp);
                        
                        // in Übersichtstabelle einfügen
                        insertIntoCustomerTable((Customer)o);                        
                                                
                        //Statusline Nachricht sezten
                        statusLine.setStatus(1,l.getString("Customer.groupdetail.savebutton.newok"));

                    } catch (DataBaseException e) {
                        if (e.getMessage().equalsIgnoreCase("1")) {
                            //Fehler beim Speichern des Objectes

                            statusLine.setStatus(3,l.getString("Customer.groupdetail.savebutton.errorsave"));
                            showMsg(l.getString("Customer.groupdetail.savebutton.errorsave"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                            
                        } else if (e.getMessage().equalsIgnoreCase("2")) {
                            //fehler beim db aufbau
                            statusLine.setStatus(3,l.getString("Customer.groupdetail.savebutton.errordb"));
                            showMsg(l.getString("Customer.groupdetail.savebutton.errordb"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                            
                        } else {
                            //@todo
                            e.printStackTrace();
                        }
                        
                    } catch (ParseException pex){
                        statusLine.setStatus(3,l.getString("Customer.groupdetail.savebutton.errorsave"));
                        showMsg(l.getString("Customer.groupdetail.savebutton.errorsave"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                        
                    }
                    
                    
//                  alle Buttons auf aktiv setzen
                    setCustomerGroupButtonSaveCancel();
                    buttonCustomerDelete.setEnabled(false);
                    buttonCustomerEdit.setEnabled(false);
                    
                } else if (mode_Customer == ManagementGui.MODE_EDIT) {
                    try {
                        
                        Calendar tmp_cal = Calendar.getInstance();
                        tmp_cal.setTime(DateFormat.getDateInstance(DateFormat.LONG).parse(textstartdate.getText()));
                        
	                    Customer tmp = new Customer(textCustomerName.getText(), 
	                            Float.parseFloat(textduration1.getText()),
	                            Float.parseFloat(textduration2.getText()), 
	                            Float.parseFloat(textduration3.getText()),
	                            tmp_cal);
	                    tmp.setCustomerId(new Integer(Integer.parseInt(textCustomerID.getText())));
	                
	                    //object speichern
	                    // Fehlerbehandlung
	                    Database.saveObject(tmp);
	                    //Übersichtstabelle aktualisieren
	                    refreshCustomerTable(textCustomerSearch.getText());
	                    
	                    //Statusline Nachricht sezten
	                    statusLine.setStatus(1,l.getString("Customer.groupdetail.savebutton.editok"));
	                   
	
	                } catch (DataBaseException e) {
	                    if (e.getMessage().equalsIgnoreCase("1")) {
	                        //Fehler beim Speichern des Objectes
	
	                        statusLine.setStatus(3,l.getString("Customer.groupdetail.savebutton.errorsave"));
	                        showMsg(l.getString("Customer.groupdetail.savebutton.errorsave"),"Fehler", SWT.ICON_ERROR | SWT.OK);
	                        
	                    } else if (e.getMessage().equalsIgnoreCase("2")) {
	                        //fehler beim db aufbau
	                        statusLine.setStatus(3,l.getString("Customer.groupdetail.savebutton.errordb"));
	                        showMsg(l.getString("Customer.groupdetail.savebutton.errordb"),"Fehler", SWT.ICON_ERROR | SWT.OK);
	                        
	                    } else {
	                        //@todo
	                        e.printStackTrace();
	                    }
                    
                    } catch (ParseException pex){
                        statusLine.setStatus(3,l.getString("Customer.groupdetail.savebutton.errorsave"));
                        showMsg(l.getString("Customer.groupdetail.savebutton.errorsave"),"Fehler", SWT.ICON_ERROR | SWT.OK);
                        
                    }
                    
                    //alle Buttons auf aktiv setzen
                    setCustomerGroupButtonSaveCancel();
                    buttonCustomerDelete.setEnabled(false);
                    buttonCustomerEdit.setEnabled(false);
                }
                
                
                
                /**
                 * @todo Exception werfen, da nur die zwei Modes sein dürfen
                 /
                
            }
        });

        buttonCustomerCancel = new Button(compositeButtons, SWT.PUSH | SWT.CENTER);
        buttonCustomerCancel.setText(l.getString("button.cancel"));
        buttonCustomerCancel.setEnabled(false);
        buttonCustomerCancel.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                System.out
                        .println("buttonCustomerCancel.widgetSelected, event="
                                + evt);
                setCustomerGroupButtonSaveCancel();
            }
        });
       
    }*/

    /**
     * 
     */
    /*protected void setCustomerGroupButtonSaveCancel() {
        buttonCustomerSave.setEnabled(false);
        buttonCustomerCancel.setEnabled(false);
        buttonCustomerEdit.setEnabled(true);
        buttonCustomerNew.setEnabled(true);
        buttonCustomerDelete.setEnabled(true);
        textCustomerName.setEditable(false);
        textduration1.setEditable(false);
        textduration2.setEditable(false);
        textduration3.setEditable(false);
        //textstartdate.setEditable(false);
        changeStartDateButton.setEnabled(false);
        textCustomerSearch.setEditable(true);

        // CustomerTabelle aktivieren
        tableCustomer.setEnabled(true);

        //CustomerSearch aktivieren
        textCustomerSearch.setEnabled(true);
        
    }*/

    /**
     * @param Customer
     * @throws DataBaseException
     */
    protected void insertIntoCustomerTable(Customer Customer) throws DataBaseException {
        TableItem item = new TableItem(tableCustomer, SWT.NONE);
        Calendar regdate = Calendar.getInstance();
        regdate.setTime(Customer.getDayOfRegistration());
        item.setText(new String[] { Customer.getCustomerId() + "", 
                					Customer.getUserName(), 
                					Customer.getPerson().getLastName(),
                					Customer.getPerson().getFirstName(),
                					Util.getTextByDate(Customer.getPerson().getDayOfBirth()),
                					Util.getTextByDate(regdate),              					
                					});
        
        tableCustomer.deselectAll();
        refreshCustomerDetail("");
        
        try {
            refreshCustomerTable(textCustomerSearch.getText());
        } catch (DataBaseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @param text
     * @throws DataBaseException
     */
    protected void refreshCustomerTable(final String filter) throws DataBaseException {
        if (tableCustomer == null) {
            System.out
                    .println("Konnte Customertable nicht refreshen, da diese null ist!");
            return;
        }
        System.out.println("Versuche nun CustomerListe zu refreshen. Filter: "
                + filter);
        tableCustomer.removeAll();
        TableItem item;
        java.util.List Customerlist = Database.getCustomer(filter);
        
        for (int i = 0; i < Customerlist.size(); i++) {

            Customer o = (Customer) Customerlist.get(i);
            item = new TableItem(tableCustomer, SWT.NONE);
            Calendar regdate = Calendar.getInstance();
            regdate.setTime(o.getDayOfRegistration());
            item.setText(new String[] { o.getCustomerId() + "", 
                    					o.getUserName(), 
                    					o.getPerson().getLastName(),
                    					o.getPerson().getFirstName(),
                    					Util.getTextByDate(o.getPerson().getDayOfBirth()),
                    					Util.getTextByDate(regdate),              					
                    					});

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
                    e.printStackTrace();
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
        tableCustomer.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                System.out.println("tableCustomer.focusLost, event=" + evt);
            }
            public void focusGained(FocusEvent evt) {
                System.out
                    .println("tableCustomer.focusGained, event=" + evt);
            }
        });
        tableCustomer.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                if (logger.isDebugEnabled()) {
                    logger.debug("widgetSelected(SelectionEvent evt = "
                        + evt
                        + ") - start");
                }

                int index = tableCustomer.getSelectionIndex();

                System.out.println("Table select. id: "
                    + index
                    + " TableItem:"
                    + tableCustomer.getItem(index)
                    + " id: "
                    + tableCustomer.getItem(index).getText(0));

                //es wurde ein Element aus Tabelle ausgewaehlt jetzt muss die
                //Detailansicht aktualisiert werden
                refreshCustomerDetail(tableCustomer.getItem(index)
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
        tableCustomer.setLayoutData(table2LData);

        //einzelne Spalten hinzufügen
        tableColumn = new TableColumn(tableCustomer, SWT.CENTER);
        tableColumn.setText(l.getString("Customer.groupoverview.columnid"));
        tableColumn.setWidth(50);
        
        tableColumn = new TableColumn(tableCustomer, SWT.CENTER);
        tableColumn.setText(l.getString("Customer.groupoverview.columnusername"));
        tableColumn.setWidth(50);

        tableColumn = new TableColumn(tableCustomer, SWT.CENTER);
        tableColumn.setText(l.getString("Customer.groupoverview.columnlastname"));
        tableColumn.setWidth(70);

        tableColumn = new TableColumn(tableCustomer, SWT.CENTER);
        tableColumn.setText(l.getString("Customer.groupoverview.columnfirstname"));
        tableColumn.setWidth(70);
        
        tableColumn = new TableColumn(tableCustomer, SWT.CENTER);
        tableColumn.setText(l.getString("Customer.groupoverview.columnbirthday"));
        tableColumn.setWidth(70);
        tableColumn = new TableColumn(tableCustomer, SWT.CENTER);
        tableColumn.setText(l.getString("Customer.groupoverview.columnregdate"));
        tableColumn.setWidth(70);

        if (logger.isDebugEnabled()) {
            logger.debug("initTableCustomer() - end");
        }
        
    }

    /**
     * @param text
     */
    protected void refreshCustomerDetail(final String id) {
        if (!id.equals("") && id != null) {
	        Customer object;
	        try {
	            //since we only can get a String value from the table, we
	            //need to convert this
	            object = Database.getSingleCustomer(Integer.parseInt(id));
	
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
	
	        textCustomerID.setText(object.getCustomerId() + "");
	        textUserName.setText(object.getUserName());
	        textLastName.setText(object.getPerson().getLastName());
	        textFirstName.setText(object.getPerson().getFirstName());
	        textMiddleName.setText(object.getPerson().getMiddleName());
	        textSalutation.setText(object.getPerson().getSalutation());
	        textTitle.setText(object.getPerson().getTitle());
	        textStreet.setText(object.getPerson().getStreet());
	        textNumber.setText(object.getPerson().getStreetNumber());
	        textCity.setText(object.getPerson().getCity());
	        textZipCode.setText(object.getPerson().getZipCode());
	        textCountry.setText(object.getPerson().getCountry());
	        textPassword.setText(object.getUserPassword());
	        textEmail.setText(object.getPerson().getEmailAddress());
	        textQuestion.setText(object.getHiddenQuestion());
	        textAnswer.setText(object.getHiddenAnswer());
	        Calendar regdate = Calendar.getInstance();
	        regdate.setTime(object.getDayOfRegistration());
	        try {
                textBirthday.setText(Util.getTextByDate(object.getPerson().getDayOfBirth()));
            } catch (DataBaseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
	        
	        //Buttons zum löschen und editieren aktivieren
	        /*
	        buttonCustomerEdit.setEnabled(false);
	        buttonCustomerDelete.setEnabled(true);
	        Vector vec = (Vector) list.get(object.getName());
	        
	        for (int i = 0; i < vec.size(); i++) {
	            Calendar date = (Calendar) vec.get(i);
	            try {
	                if (Util.getTextByDate(date).equals(Util.getTextByDate(object.getStartdate()))) {
	                    buttonCustomerEdit.setEnabled(true);
	                    
	                }
	            } catch (DataBaseException e1) {
	                // TODO Auto-generated catch block
	                e1.printStackTrace();
	            }
	        }*/
        } else {
            textCustomerID.setText("");
            textCustomerName.setText("");
            textduration1.setText("");
            textduration2.setText("");
            textduration3.setText("");
            textstartdate.setText("");
            buttonCustomerEdit.setEnabled(false);
            buttonCustomerDelete.setEnabled(false);
        }

        //Mode auf view setzen
        mode_Customer = ManagementGui.MODE_VIEW;
        
    }

	

}

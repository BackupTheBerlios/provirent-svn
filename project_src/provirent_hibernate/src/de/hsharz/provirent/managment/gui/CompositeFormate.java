package de.hsharz.provirent.managment.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import de.hsharz.provirent.objects.VideoFormat;
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
public class CompositeFormate extends org.eclipse.swt.widgets.Composite {
	private SashForm sashForm1;
	private Group groupVideoFormatOverview;
	private Group groupVideoFormatDetail;
	private Label labelVideoFormatId;
	private Label labelVideoFormatShortname;
	private Text textVideoFormatName;
	private Label labelVideoFormatName;
	private Text textVideoFormatID;
	private Composite composite2;
	private Group groupAudioFormatOverview;
	private List list1;
	private Group groupAudioFormatDetail;
	private Text textAudioFormatSearch;
	private Label labelAudioFormatSearch;
	private TableColumn tableColumn;
	private TableColumn tableColumn1, tableColumn2, tableColumn3 ;
	private Table tableAudioFormat;
	private SashForm sashFormAudioFormat;
	private Group groupAudioFormat;
	private Button buttonVideoFormatCancel;
	private Button buttonVideoFormatSave;
	private Button buttonVideoFormatFill;
	private Button buttonVideoFormatDelete;
	private Button buttonVideoFormatEdit;
	private Button buttonVideoFormatNew;
	private Text textVideoFormatShortname;
	private Text textVideoFormatSearch;
	private Label labelVideoFormatSearch;
	private Table tableVideoFormat;
	private SashForm sashFormVideoFormat;
	private Group groupVideoFormat;
	   private Table tableDirector;

	    private Group group1Director;

	
	
    private final static int MODE_VIEW = 0;

    private final static int MODE_ADD = 1;

    private final static int MODE_EDIT = 2;

    private int mode_VideoFormat = 0;

    private int mode_AudioFormat = 0;
	
	
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
		CompositeFormate inst = new CompositeFormate(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if(size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public CompositeFormate(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
            {
                sashForm1 = new SashForm(this, SWT.VERTICAL | SWT.V_SCROLL);
                GridData sashForm1LData1 = new GridData();
                sashForm1LData1.grabExcessHorizontalSpace = true;
                sashForm1LData1.horizontalAlignment = GridData.FILL;
                sashForm1LData1.grabExcessVerticalSpace = true;
                sashForm1LData1.verticalAlignment = GridData.FILL;
                sashForm1.setLayoutData(sashForm1LData1);
                {
                    groupVideoFormat = new Group(sashForm1, SWT.NONE);
                    GridLayout group2Layout = new GridLayout();
                    group2Layout.makeColumnsEqualWidth = true;
                    groupVideoFormat.setText("VideoFormat");
                    groupVideoFormat.setSize(758, 284);
                    FormData group2LData = new FormData();
                    groupVideoFormat.setLayout(group2Layout);
                    groupVideoFormat.setLayoutData(group2LData);
                    {
                        sashFormVideoFormat = new SashForm(groupVideoFormat, SWT.NONE);
                        FormLayout sashForm2Layout = new FormLayout();
                        sashFormVideoFormat.setSize(748, 300);
                        GridData sashForm2LData = new GridData();
                        sashFormVideoFormat.setLayout(sashForm2Layout);
                        sashForm2LData.verticalAlignment = GridData.FILL;
                        sashForm2LData.horizontalAlignment = GridData.FILL;
                        sashForm2LData.grabExcessHorizontalSpace = true;
                        sashForm2LData.grabExcessVerticalSpace = true;
                        sashFormVideoFormat.setLayoutData(sashForm2LData);
                        {
                            groupVideoFormatOverview = new Group(sashFormVideoFormat, SWT.NONE);
                            GridLayout group5Layout = new GridLayout();
                            group5Layout.numColumns = 6;
                            groupVideoFormatOverview.setText("Übersicht");
                            FormData group5LData = new FormData();
                            groupVideoFormatOverview.setLayout(group5Layout);
                            group5LData.left =  new FormAttachment(0, 100, 0);
                            group5LData.top =  new FormAttachment(0, 100, 0);
                            groupVideoFormatOverview.setLayoutData(group5LData);
                            {
                                tableVideoFormat = new Table(groupVideoFormatOverview, SWT.SINGLE | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.BORDER);
                                tableVideoFormat.setHeaderVisible(true);
                                tableVideoFormat.setLinesVisible(true);
                                GridData table2LData = new GridData();
                                tableVideoFormat
                                    .addSelectionListener(new SelectionAdapter() {
                                    public void widgetSelected(
                                        SelectionEvent evt) {

                                        int index = tableVideoFormat
                                            .getSelectionIndex();

                                        System.out.println("Table select. id: "
                                            + index
                                            + " TableItem:"
                                            + tableVideoFormat.getItem(index)
                                            + " id: "
                                            + tableVideoFormat.getItem(index)
                                                .getText(0));

                                        //es wurde ein Element aus Tabelle ausgewaehlt jetzt muss die 
                                        //Detailansicht aktualisiert werden
                                        refreshVideoFormatDetail(tableVideoFormat
                                            .getItem(index).getText(0));
                                    }
                                    });
                                table2LData.verticalAlignment = GridData.FILL;
                                table2LData.horizontalAlignment = GridData.FILL;
                                table2LData.horizontalSpan = 6;
                                table2LData.grabExcessHorizontalSpace = true;
                                table2LData.grabExcessVerticalSpace = true;
                                tableVideoFormat.setLayoutData(table2LData);
                            }
                            {
                                labelVideoFormatSearch = new Label(groupVideoFormatOverview, SWT.NONE);
                                labelVideoFormatSearch.setText("Suche nach:");
                                GridData label2LData = new GridData();
                                label2LData.horizontalSpan = 2;
                                labelVideoFormatSearch.setLayoutData(label2LData);
                            }
                            {
                                textVideoFormatSearch = new Text(groupVideoFormatOverview, SWT.BORDER);
                                GridData text2LData = new GridData();
                                textVideoFormatSearch
                                    .addFocusListener(new FocusAdapter() {
                                    public void focusLost(FocusEvent evt) {
                                        System.out.println("Focus Verloren: "
                                            + textVideoFormatSearch.getText());
                                        refreshVideoFormatTable(textVideoFormatSearch
                                            .getText());
                                    }
                                    });
                                text2LData.horizontalAlignment = GridData.FILL;
                                text2LData.horizontalSpan = 4;
                                text2LData.grabExcessHorizontalSpace = true;
                                textVideoFormatSearch.setLayoutData(text2LData);
                            }
                        }
                        {
                            groupVideoFormatDetail = new Group(sashFormVideoFormat, SWT.NONE);
                            GridLayout groupVideoFormatDetailLayout = new GridLayout();
                            groupVideoFormatDetailLayout.marginHeight = 25;
                            groupVideoFormatDetailLayout.numColumns = 6;
                            groupVideoFormatDetailLayout.verticalSpacing = 15;
                            groupVideoFormatDetail.setText("Detail");
                            FormData formData = new FormData();
                            groupVideoFormatDetail.setLayout(groupVideoFormatDetailLayout);
                            formData.right =  new FormAttachment(100, 100, -5);
                            formData.top =  new FormAttachment(0, 100, 5);
                            formData.bottom =  new FormAttachment(100, 100, -5);
                            groupVideoFormatDetail.setLayoutData(formData);
                            {
                                labelVideoFormatId = new Label(groupVideoFormatDetail, SWT.NONE);
                                labelVideoFormatId.setText("VideoFormat ID:");
                                labelVideoFormatId.setSize(125, 15);
                                GridData formData2 = new GridData();
                                formData2.widthHint = 125;
                                formData2.heightHint = 15;
                                formData2.horizontalSpan = 2;
                                labelVideoFormatId.setLayoutData(formData2);
                            }
                            {
                                textVideoFormatID = new Text(groupVideoFormatDetail, SWT.READ_ONLY | SWT.BORDER);
                                GridData text1LData1 = new GridData();
                                text1LData1.horizontalAlignment = GridData.FILL;
                                text1LData1.heightHint = 13;
                                text1LData1.horizontalSpan = 4;
                                text1LData1.grabExcessHorizontalSpace = true;
                                textVideoFormatID.setLayoutData(text1LData1);
                            }
                            {
                                labelVideoFormatName = new Label(groupVideoFormatDetail, SWT.NONE);
                                labelVideoFormatName
                                    .setText("VideoFormat Name:");
                                labelVideoFormatName.setSize(125, 15);
                                GridData labelVideoFormatNameLData = new GridData();
                                labelVideoFormatNameLData.widthHint = 125;
                                labelVideoFormatNameLData.heightHint = 15;
                                labelVideoFormatNameLData.horizontalSpan = 2;
                                labelVideoFormatName.setLayoutData(labelVideoFormatNameLData);
                            }
                            {
                                textVideoFormatName = new Text(groupVideoFormatDetail, SWT.READ_ONLY | SWT.BORDER);
                                GridData text1LData2 = new GridData();
                                text1LData2.horizontalAlignment = GridData.FILL;
                                text1LData2.heightHint = 13;
                                text1LData2.horizontalSpan = 4;
                                text1LData2.grabExcessHorizontalSpace = true;
                                textVideoFormatName.setLayoutData(text1LData2);
                            }
                            {
                                labelVideoFormatShortname = new Label(groupVideoFormatDetail, SWT.NONE);
                                labelVideoFormatShortname
                                    .setText("VideoFormat Kurzname:");
                                labelVideoFormatShortname.setSize(125, 15);
                                GridData label1LData1 = new GridData();
                                label1LData1.widthHint = 125;
                                label1LData1.heightHint = 15;
                                label1LData1.horizontalSpan = 2;
                                labelVideoFormatShortname.setLayoutData(label1LData1);
                            }
                            {
                                textVideoFormatShortname = new Text(groupVideoFormatDetail, SWT.READ_ONLY | SWT.BORDER);
                                GridData text1LData3 = new GridData();
                                text1LData3.horizontalAlignment = GridData.FILL;
                                text1LData3.heightHint = 13;
                                text1LData3.horizontalSpan = 4;
                                text1LData3.grabExcessHorizontalSpace = true;
                                textVideoFormatShortname.setLayoutData(text1LData3);
                            }
                            {
                                composite2 = new Composite(groupVideoFormatDetail, SWT.EMBEDDED);
                                GridLayout composite2Layout = new GridLayout();
                                composite2Layout.numColumns = 6;
                                GridData composite2LData = new GridData();
                                composite2.setLayout(composite2Layout);
                                composite2LData.verticalAlignment = GridData.END;
                                composite2LData.horizontalAlignment = GridData.CENTER;
                                composite2LData.widthHint = 322;
                                composite2LData.horizontalSpan = 6;
                                composite2LData.grabExcessHorizontalSpace = true;
                                composite2LData.grabExcessVerticalSpace = true;
                                composite2.setLayoutData(composite2LData);
                                {
                                    buttonVideoFormatNew = new Button(composite2, SWT.PUSH | SWT.CENTER);
                                    buttonVideoFormatNew.setText("Neu");
                                    buttonVideoFormatNew
                                        .addSelectionListener(new SelectionAdapter() {
                                        public void widgetSelected(
                                            SelectionEvent evt) {
                                            System.out
                                                .println("buttonVideoFormatNew.widgetSelected, event="
                                                    + evt);
                                            //TODO add your
                                            // code for
                                            // buttonVideoFormatNew.widgetSelected
                                        }
                                        });
                                }
                                {
                                    buttonVideoFormatEdit = new Button(composite2, SWT.PUSH | SWT.CENTER);
                                    buttonVideoFormatEdit.setText("Bearbeiten");
                                    buttonVideoFormatEdit.setEnabled(false);
                                    buttonVideoFormatEdit
                                        .addSelectionListener(new SelectionAdapter() {
                                        public void widgetSelected(
                                            SelectionEvent evt) {
                                            //Edit Button
                                            // wurde
                                            // gedrückt;
                                            mode_VideoFormat = ManagmentGui.MODE_EDIT;

                                            //Felder zum
                                            // bearbeiten
                                            // zulassen
                                            textVideoFormatID
                                                .setEditable(false); //primary
                                            // key
                                            textVideoFormatName
                                                .setEditable(true);
                                            textVideoFormatShortname
                                                .setEditable(true);

                                            //Speichern und
                                            // abbruch
                                            // Button
                                            // aktivieren
                                            buttonVideoFormatCancel
                                                .setEnabled(true);
                                            buttonVideoFormatSave
                                                .setEnabled(true);

                                            //Neu, Edit und
                                            // Delete
                                            // DEaktivieren
                                            buttonVideoFormatNew
                                                .setEnabled(false);
                                            buttonVideoFormatEdit
                                                .setEnabled(false);
                                            buttonVideoFormatDelete
                                                .setEnabled(false);
                                            //VideoTabelle
                                            // deaktivieren
                                            tableVideoFormat.setEnabled(false);

                                            //VideoSearch
                                            // deaktivieren
                                            textVideoFormatSearch
                                                .setEnabled(false);

                                            System.out
                                                .println("buttonVideoFormatEdit.widgetSelected, event="
                                                    + evt);
                                            //TODO add your
                                            // code for
                                            // buttonVideoFormatEdit.widgetSelected
                                        }
                                        });
                                }
                                {
                                    buttonVideoFormatDelete = new Button(composite2, SWT.PUSH | SWT.CENTER);
                                    buttonVideoFormatDelete.setText("Löschen");
                                    buttonVideoFormatDelete.setEnabled(false);
                                    buttonVideoFormatDelete
                                        .addSelectionListener(new SelectionAdapter() {
                                        public void widgetSelected(
                                            SelectionEvent evt) {
                                            System.out
                                                .println("buttonVideoFormatDelete.widgetSelected, event="
                                                    + evt);
                                            //TODO add your
                                            // code for
                                            // buttonVideoFormatDelete.widgetSelected
                                        }
                                        });
                                }
                                {
                                    buttonVideoFormatFill = new Button(composite2, SWT.PUSH | SWT.CENTER);
                                    GridData buttonVideoFormatFillLData = new GridData();
                                    buttonVideoFormatFill.setVisible(false);
                                    buttonVideoFormatFill.setEnabled(false);
                                    buttonVideoFormatFillLData.widthHint = 30;
                                    buttonVideoFormatFillLData.heightHint = 23;
                                    buttonVideoFormatFill.setLayoutData(buttonVideoFormatFillLData);
                                }
                                {
                                    buttonVideoFormatSave = new Button(composite2, SWT.PUSH | SWT.CENTER);
                                    buttonVideoFormatSave.setText("Speichern");
                                    buttonVideoFormatSave.setEnabled(false);
                                    buttonVideoFormatSave
                                        .addSelectionListener(new SelectionAdapter() {
                                        public void widgetSelected(
                                            SelectionEvent evt) {
                                            System.out
                                                .println("buttonVideoFormatSave.widgetSelected, event="
                                                    + evt);
                                            //TODO add your
                                            // code for
                                            // buttonVideoFormatSave.widgetSelected
                                        }
                                        });
                                }
                                {
                                    buttonVideoFormatCancel = new Button(composite2, SWT.PUSH | SWT.CENTER);
                                    buttonVideoFormatCancel.setText("Abbruch");
                                    buttonVideoFormatCancel.setEnabled(false);
                                    buttonVideoFormatCancel
                                        .addSelectionListener(new SelectionAdapter() {
                                        public void widgetSelected(
                                            SelectionEvent evt) {
                                            System.out
                                                .println("buttonVideoFormatCancel.widgetSelected, event="
                                                    + evt);
                                            //TODO add your
                                            // code for
                                            // buttonVideoFormatCancel.widgetSelected
                                        }
                                        });
                                }
                            }
                        }
                    }
                }
                {
                    groupAudioFormat = new Group(sashForm1, SWT.NONE);
                    GridLayout group1Layout = new GridLayout();
                    group1Layout.makeColumnsEqualWidth = true;
                    groupAudioFormat.setText("AudioFormat");
                    FormData group1LData = new FormData();
                    groupAudioFormat.setLayout(group1Layout);
                    group1LData.height = 240;
                    group1LData.width = 750;
                    groupAudioFormat.setLayoutData(group1LData);
                    {
                        sashFormAudioFormat = new SashForm(groupAudioFormat, SWT.NONE);
                        FormLayout sashForm1Layout = new FormLayout();
                        GridData sashForm1LData = new GridData();
                        sashFormAudioFormat.setLayout(sashForm1Layout);
                        sashForm1LData.verticalAlignment = GridData.FILL;
                        sashForm1LData.horizontalAlignment = GridData.FILL;
                        sashForm1LData.horizontalSpan = 6;
                        sashForm1LData.grabExcessHorizontalSpace = true;
                        sashForm1LData.grabExcessVerticalSpace = true;
                        sashFormAudioFormat.setLayoutData(sashForm1LData);
                        {
                            groupAudioFormatOverview = new Group(sashFormAudioFormat, SWT.NONE);
                            GridLayout group3Layout = new GridLayout();
                            group3Layout.numColumns = 6;
                            groupAudioFormatOverview.setText("Übersicht");
                            FormData group3LData = new FormData();
                            groupAudioFormatOverview.setLayout(group3Layout);
                            group3LData.right =  new FormAttachment(100, 100, -5);
                            group3LData.top =  new FormAttachment(0, 100, 5);
                            group3LData.bottom =  new FormAttachment(100, 100, -5);
                            groupAudioFormatOverview.setLayoutData(group3LData);
                            {
                                tableAudioFormat = new Table(groupAudioFormatOverview, SWT.SINGLE | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.BORDER);
                                tableAudioFormat.setHeaderVisible(true);
                                tableAudioFormat.setLinesVisible(true);
                                GridData table1LData = new GridData();
                                tableAudioFormat
                                    .addSelectionListener(new SelectionAdapter() {
                                    public void widgetSelected(
                                        SelectionEvent evt) {

                                        int index = tableDirector
                                            .getSelectionIndex();
                                        System.out.println("Table select. id: "
                                            + index
                                            + " TableItem:"
                                            + tableDirector.getItem(index)
                                            + " id: "
                                            + tableDirector.getItem(index)
                                                .getText(0));
                                    }
                                    });
                                table1LData.verticalAlignment = GridData.FILL;
                                table1LData.horizontalAlignment = GridData.FILL;
                                table1LData.horizontalSpan = 6;
                                table1LData.grabExcessHorizontalSpace = true;
                                table1LData.grabExcessVerticalSpace = true;
                                tableAudioFormat.setLayoutData(table1LData);
                                {
                                    tableColumn1 = new TableColumn(
                                        tableAudioFormat,
                                        SWT.CENTER);
                                    tableColumn1.setText("id");
                                    tableColumn1.setWidth(100);
                                }
                                {
                                    tableColumn2 = new TableColumn(
                                        tableAudioFormat,
                                        SWT.CENTER);
                                    tableColumn2.setText("Name");
                                    tableColumn2.setWidth(100);
                                }
                                {
                                    tableColumn3 = new TableColumn(
                                        tableAudioFormat,
                                        SWT.CENTER);
                                    tableColumn3.setText("vorname");
                                    tableColumn3.setWidth(100);
                                }
                            }
                            {
                                labelAudioFormatSearch = new Label(groupAudioFormatOverview, SWT.NONE);
                                labelAudioFormatSearch.setText("Suche nach:");
                                GridData label1LData = new GridData();
                                label1LData.horizontalSpan = 2;
                                labelAudioFormatSearch.setLayoutData(label1LData);
                            }
                            {
                                textAudioFormatSearch = new Text(groupAudioFormatOverview, SWT.BORDER);
                                GridData text1LData = new GridData();
                                text1LData.horizontalAlignment = GridData.FILL;
                                text1LData.horizontalSpan = 4;
                                text1LData.grabExcessHorizontalSpace = true;
                                textAudioFormatSearch.setLayoutData(text1LData);
                            }
                        }
                        {
                            groupAudioFormatDetail = new Group(sashFormAudioFormat, SWT.NONE);
                            GridLayout group4Layout = new GridLayout();
                            group4Layout.numColumns = 2;
                            groupAudioFormatDetail.setText("Detail");
                            FormData group4LData = new FormData();
                            groupAudioFormatDetail.setLayout(group4Layout);
                            group4LData.left =  new FormAttachment(0, 100, 5);
                            group4LData.top =  new FormAttachment(0, 100, 5);
                            group4LData.bottom =  new FormAttachment(100, 100, -5);
                            groupAudioFormatDetail.setLayoutData(group4LData);
                            {
                                list1 = new List(groupAudioFormatDetail, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
                                GridData list1LData = new GridData();
                                list1
                                    .addSelectionListener(new SelectionAdapter() {
                                    public void widgetSelected(
                                        SelectionEvent evt) {
                                        System.out
                                            .println("list1.widgetSelected, event="
                                                + evt);

                                        //TODO add your
                                        // code for
                                        // list1.widgetSelected
                                    }
                                    });
                                list1LData.verticalAlignment = GridData.FILL;
                                list1LData.horizontalAlignment = GridData.FILL;
                                list1LData.grabExcessHorizontalSpace = true;
                                list1LData.grabExcessVerticalSpace = true;
                                list1.setLayoutData(list1LData);
                            }
                        }
                    }
                }
            }
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    private void refreshVideoFormatTable(final String filter) {
        if (tableVideoFormat == null) {
            System.out
                    .println("Konnte VideoFormattable nicht refreshen, da diese null ist!");
            return;
        }
        System.out.println("Versuche nun VideoListe zu refreshen. Filter: "
                + filter);
        tableVideoFormat.removeAll();
        TableItem item;
        java.util.List videoformatlist = Database.getVideoFormat(filter);
    
        for (int i = 0; i < videoformatlist.size(); i++) {
    
            VideoFormat o = (VideoFormat) videoformatlist.get(i);
            item = new TableItem(tableVideoFormat, SWT.NONE);
            item.setText(new String[] { o.getVideoFormatId() + "", o.getName(),
                    o.getShortname() });
    
        }
    
    }

    /**
     * Refreshes the Videoformat Detail view the id is needed to know which
     * VideoFormat to refresh
     * 
     * @param id
     */
    private void refreshVideoFormatDetail(final String id) {
        VideoFormat object;
        try {
            //since we only can get a String value from the table, we
            //need to convert this
            object = Database.getSingleVideoFormat(Integer.parseInt(id));
    
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
    
        textVideoFormatID.setText(object.getVideoFormatId() + "");
        textVideoFormatName.setText(object.getName());
        textVideoFormatShortname.setText(object.getShortname());
    
        //Buttons zum löschen und editieren aktivieren
        buttonVideoFormatEdit.setEnabled(true);
        buttonVideoFormatDelete.setEnabled(true);
    
        //Mode auf view setzen
        mode_VideoFormat = ManagmentGui.MODE_VIEW;
    
    }
    
    
    private void initVideoFormatTable() {

        initTableColumn(tableVideoFormat, SWT.CENTER, "id", 50);
        initTableColumn(tableVideoFormat, SWT.CENTER, "Name", 75);
        initTableColumn(tableVideoFormat, SWT.CENTER, "Shortname", 75);

    }
    

    private void initTableColumn(final Table table, final int align,
            final String name, final int width) {

        tableColumn = new TableColumn(table, align);
        tableColumn.setText(name);
        tableColumn.setWidth(width);

    }

}

/*
 * Created on 11.10.2004
 *
 * Copyright (c) 2004/2005, Remo Griesch/Stefan Forstner/Philipp Schneider
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * - Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * - Neither the name of the Remo Griesch/Stefan Forstner/Philipp Schneider nor
 * the names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 */

package de.hsharz.provirent.managment.gui;

import java.io.IOException;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
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
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.cloudgarden.resource.SWTResourceManager;

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
/**
 * @author Philipp Schneider
 *  
 */
public class ManagmentGui {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(ManagmentGui.class);

    private final static int MODE_VIEW = 0;

    private final static int MODE_ADD = 1;

    private final static int MODE_EDIT = 2;

    private int mode_VideoFormat = 0;

    private int mode_AudioFormat = 0;

    private CTabFolder cTabFolder1;

    private CTabItem tabItemFormat;

    private List list3;

    private Group group2Director;

    private Text filterTextVideoFormat;

    private Label filterLabelVideoFormat;

    private TableColumn tableColumnDirectorFirstname;

    private TableColumn tableColumnDirectorLastname;

    private TableColumn tableColumnDirectorId;

    private MenuItem aboutMenuItem;

    private MenuItem contentsMenuItem;

    private Menu helpMenu;

    private MenuItem helpMenuItem;

    private MenuItem viewDirectorMenuItem;

    private Table tableDirector;

    private Group group1Director;

    private SashForm sashFormDirector;

    private CTabItem cTabItem2;

    private Shell shell;

    private Display display;

    private MenuItem viewVideoFormatMenuItem;

    private Menu viewMenu;

    private MenuItem viewMenuItem;

    private MenuItem exitMenuItem;

    private MenuItem closeFileMenuItem;

    private MenuItem saveFileMenuItem;

    private MenuItem newFileMenuItem;

    private MenuItem openFileMenuItem;

    private Menu fileMenu;

    private MenuItem fileMenuItem;

    private Menu roomMenu;

    private Group groupVideoFormatDetail;

    private Text textVideoFormatSearch;

    private Label labelVideoFormatSearch;

    private TableColumn tableColumn6;

    private TableColumn tableColumn5;

    private TableColumn tableColumn4;

    private Table tableVideoFormat;

    private Group groupVideoFormatOverview;

    private SashForm sashFormVideoFormat;

    private List list1;

    private Group groupAudioFormatDetail;

    private Text textAudioFormatSearch;

    private Label labelAudioFormatSearch;

    private TableColumn tableColumn3;

    private TableColumn tableColumn2;

    private TableColumn tableColumn1;

    private Table tableAudioFormat;

    private Group groupAudioFormatOverview;

    private StyledText statusLine;

    private Composite compositeStatusLine;

    private Composite compositeMain;

    private Composite compositeRoot;

    private SashForm sashForm1;

    private Button buttonVideoFormatCancel;

    private Button buttonVideoFormatSave;

    private Button buttonVideoFormatFill;

    private Button buttonVideoFormatDelete;

    private Button buttonVideoFormatEdit;

    private Button buttonVideoFormatNew;

    private Composite composite2;

    private Text textVideoFormatShortname;

    private Label labelVideoFormatShortname;

    private Text textVideoFormatName;

    private Label labelVideoFormatName;

    private Text textVideoFormatID;

    private Label labelVideoFormatId;

    private SashForm sashFormAudioFormat;

    private Group groupVideoFormat;

    private Group groupAudioFormat;

    private Text textVideoFormatId;

    
    /**
     * Bundle for multilanguage
     */
    private ResourceBundle l ;
    
    /**
     * Auto-generated main method to display this
     * org.eclipse.swt.widgets.Composite inside a new Shell.
     */
    public static void main(String[] args) {
        ManagmentGui inst = new ManagmentGui();
        inst.showGUI();
        inst.run();
    }

    /**
     * Auto-generated method to display this org.eclipse.swt.widgets.Composite
     * inside a new Shell.
     */
    public void showGUI() {

    }

    public void run() {
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }

    public ManagmentGui() {
        
        System.out.println(Locale.getDefault());
            l = PropertyResourceBundle.getBundle(
                    "de.hsharz.provirent.managment.gui.language", 
                    Locale.getDefault());

            if (l == null){
                System.exit(-1586);
            }
            
        display = Display.getDefault();

        shell = new Shell(display);
        shell.setText(l.getString("mainwindow.title"));

        {
            //Register as a resource user - SWTResourceManager will
            //handle the obtaining and disposing of resources
            SWTResourceManager.registerResourceUser(shell);
        }

        //shell.setLayout(new FormLayout());
        shell.setLayout(new FillLayout());

        {
            //set't the menu
            roomMenu = new Menu(shell, SWT.BAR);
            shell.setMenuBar(roomMenu);

            //init the other menu's
            initFileMenu();
            initViewMenu();
            initHelpMenu();

        }
        shell.layout();
        initGUI();

    }

    /**
     *  init the File menu
     */
    private void initFileMenu() {
        if (roomMenu == null) {
            return;
            /**
             * @todo hier muesste eigentlich eine Exception geworfen werden, da
             *       null nich ein darf
             */
        }
        fileMenuItem = new MenuItem(roomMenu, SWT.CASCADE);
        fileMenuItem.setText("Datei");
        fileMenu = new Menu(fileMenuItem);
        fileMenuItem.setMenu(fileMenu);

        openFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
        openFileMenuItem.setText("Öffnen");

        newFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
        newFileMenuItem.setText("Neu");

        saveFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
        saveFileMenuItem.setText("Speichern");

        closeFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
        closeFileMenuItem.setText("Schließen");

        exitMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
        exitMenuItem.setText("Beenden");

    }

    /**
     * init the View Menu
     */
    private void initViewMenu() {
        if (roomMenu == null) {
            return;
            /**
             * @todo hier muesste eigentlich eine Exception geworfen werden, da
             *       null nich ein darf
             */
        }

        viewMenuItem = new MenuItem(roomMenu, SWT.CASCADE);
        viewMenuItem.setText("Ansicht");

        viewMenu = new Menu(viewMenuItem);
        viewMenuItem.setMenu(viewMenu);

        viewVideoFormatMenuItem = new MenuItem(viewMenu, SWT.CHECK);
        viewVideoFormatMenuItem.setText("VideoFormat");
        viewVideoFormatMenuItem.setSelection(false);
        viewVideoFormatMenuItem.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                System.out
                        .println("viewVideoFormatMenuItem.widgetSelected, event="
                                + evt);
                setStatus(3, "Fehler aufgetreten");
                //TODO add your code for
                // viewVideoFormatMenuItem.widgetSelected
            }
        });

        viewDirectorMenuItem = new MenuItem(viewMenu, SWT.CHECK);
        viewDirectorMenuItem.setText("Director");
        viewDirectorMenuItem.setSelection(false);

    }

    /**
     * init the help menu
     */
    private void initHelpMenu() {
        if (roomMenu == null) {
            return;
            /**
             * @todo hier muesste eigentlich eine Exception geworfen werden, da
             *       null nich ein darf
             */
        }
        helpMenuItem = new MenuItem(roomMenu, SWT.CASCADE);
        {
            helpMenu = new Menu(helpMenuItem);
            helpMenuItem.setMenu(helpMenu);
            {
                contentsMenuItem = new MenuItem(helpMenu, SWT.CASCADE);
            }
            {
                aboutMenuItem = new MenuItem(helpMenu, SWT.CASCADE);
            }
        }

    }

    private void initGUI() {
        try {
            FillLayout thisLayout = new FillLayout(
                    org.eclipse.swt.SWT.HORIZONTAL);
            shell.setLayout(thisLayout);
            shell.setSize(700, 500);
            {
                compositeRoot = new Composite(shell, SWT.NONE);
                GridLayout composite1Layout = new GridLayout();
                composite1Layout.marginWidth = 0;
                composite1Layout.marginHeight = 0;
                composite1Layout.horizontalSpacing = 0;
                composite1Layout.verticalSpacing = 0;
                GridData composite1LData = new GridData();
                compositeRoot.setLayout(composite1Layout);
                composite1LData.verticalAlignment = GridData.FILL;
                composite1LData.horizontalAlignment = GridData.FILL;
                composite1LData.grabExcessHorizontalSpace = true;
                composite1LData.grabExcessVerticalSpace = true;
                compositeRoot.setLayoutData(composite1LData);
                {
                    compositeMain = new Composite(compositeRoot, SWT.EMBEDDED);
                    GridLayout composite3Layout = new GridLayout();
                    composite3Layout.makeColumnsEqualWidth = true;
                    composite3Layout.horizontalSpacing = 0;
                    composite3Layout.marginHeight = 0;
                    composite3Layout.marginWidth = 0;
                    composite3Layout.verticalSpacing = 0;
                    GridData composite3LData = new GridData();
                    compositeMain.setLayout(composite3Layout);
                    compositeMain.setForeground(SWTResourceManager.getColor(0,
                            255, 0));
                    composite3LData.verticalAlignment = GridData.FILL;
                    composite3LData.horizontalAlignment = GridData.FILL;
                    composite3LData.grabExcessHorizontalSpace = true;
                    composite3LData.grabExcessVerticalSpace = true;
                    compositeMain.setLayoutData(composite3LData);
                    {
                        cTabFolder1 = new CTabFolder(compositeMain, SWT.NONE);
                        //cTabFolder1.setSelection(null);
                        GridData cTabFolder1LData = new GridData();
                        cTabFolder1LData.grabExcessHorizontalSpace = true;
                        cTabFolder1LData.horizontalAlignment = GridData.FILL;
                        cTabFolder1LData.grabExcessVerticalSpace = true;
                        cTabFolder1LData.verticalAlignment = GridData.FILL;
                        cTabFolder1.setLayoutData(cTabFolder1LData);
                        {
                            tabItemFormat = new CTabItem(cTabFolder1, SWT.NONE);
                            tabItemFormat.setText("Formate");
                            {
                                sashForm1 = new SashForm(cTabFolder1,
                                        SWT.VERTICAL | SWT.V_SCROLL);
                                tabItemFormat.setControl(sashForm1);
                                {
                                    groupVideoFormat = new Group(sashForm1,
                                            SWT.NONE);
                                    GridLayout group2Layout = new GridLayout();
                                    FormData group2LData = new FormData();
                                    groupVideoFormat.setSize(758, 284);
                                    group2LData.height = 222;
                                    group2LData.width = 758;
                                    group2LData.left = new FormAttachment(0,
                                            1000, 0);
                                    group2LData.right = new FormAttachment(
                                            1000, 1000, 0);
                                    group2LData.top = new FormAttachment(0,
                                            1000, 0);
                                    group2LData.bottom = new FormAttachment(
                                            500, 1000, 0);
                                    groupVideoFormat.setLayoutData(group2LData);
                                    group2Layout.makeColumnsEqualWidth = true;
                                    groupVideoFormat.setLayout(group2Layout);
                                    groupVideoFormat.setText("VideoFormat");
                                    {
                                        sashFormVideoFormat = new SashForm(
                                                groupVideoFormat, SWT.NONE);
                                        FormLayout sashForm2Layout = new FormLayout();
                                        GridData sashForm2LData = new GridData();
                                        sashFormVideoFormat.setSize(748, 300);
                                        sashForm2LData.grabExcessHorizontalSpace = true;
                                        sashForm2LData.horizontalAlignment = GridData.FILL;
                                        sashForm2LData.verticalAlignment = GridData.FILL;
                                        sashForm2LData.grabExcessVerticalSpace = true;
                                        sashFormVideoFormat
                                                .setLayoutData(sashForm2LData);
                                        sashFormVideoFormat
                                                .setLayout(sashForm2Layout);
                                        {
                                            groupVideoFormatOverview = new Group(
                                                    sashFormVideoFormat,
                                                    SWT.NONE);
                                            GridLayout group5Layout = new GridLayout();
                                            group5Layout.numColumns = 6;
                                            groupVideoFormatOverview
                                                    .setText("Übersicht");
                                            FormData group5LData = new FormData();
                                            groupVideoFormatOverview
                                                    .setLayout(group5Layout);
                                            group5LData.top = new FormAttachment(
                                                    0, 100, 0);
                                            group5LData.left = new FormAttachment(
                                                    0, 100, 0);
                                            groupVideoFormatOverview
                                                    .setLayoutData(group5LData);
                                            {
                                                tableVideoFormat = new Table(
                                                        groupVideoFormatOverview,
                                                        SWT.SINGLE
                                                                | SWT.FULL_SELECTION
                                                                | SWT.V_SCROLL
                                                                | SWT.BORDER);
                                                tableVideoFormat
                                                        .setHeaderVisible(true);
                                                tableVideoFormat
                                                        .setLinesVisible(true);
                                                GridData table2LData = new GridData();
                                                tableVideoFormat
                                                        .addSelectionListener(new SelectionAdapter() {
                                                            public void widgetSelected(
                                                                    SelectionEvent evt) {

                                                                int index = tableVideoFormat
                                                                        .getSelectionIndex();
                                                                System.out
                                                                        .println("Table select. id: "
                                                                                + index
                                                                                + " TableItem:"
                                                                                + tableVideoFormat
                                                                                        .getItem(index)
                                                                                + " id: "
                                                                                + tableVideoFormat
                                                                                        .getItem(
                                                                                                index)
                                                                                        .getText(
                                                                                                0));

                                                                //es wurde ein
                                                                // Element aus
                                                                // Tabelle
                                                                // ausgewaehlt
                                                                // jetzt muss die
                                                                // Detailansicht
                                                                // aktualisiert
                                                                // werden
                                                                refreshVideoFormatDetail(tableVideoFormat
                                                                        .getItem(
                                                                                index)
                                                                        .getText(
                                                                                0));
                                                            }
                                                        });
                                                table2LData.verticalAlignment = GridData.FILL;
                                                table2LData.horizontalAlignment = GridData.FILL;
                                                table2LData.horizontalSpan = 6;
                                                table2LData.grabExcessHorizontalSpace = true;
                                                table2LData.grabExcessVerticalSpace = true;
                                                tableVideoFormat
                                                        .setLayoutData(table2LData);
                                                {
                                                    tableColumn4 = new TableColumn(
                                                            tableVideoFormat,
                                                            SWT.CENTER);
                                                    tableColumn4.setText("id");
                                                    tableColumn4
                                                            .setAlignment(SWT.LEAD);
                                                    tableColumn4.setWidth(50);

                                                }
                                                {
                                                    tableColumn5 = new TableColumn(
                                                            tableVideoFormat,
                                                            SWT.CENTER);
                                                    tableColumn5
                                                            .setText("Name");
                                                    tableColumn5.setWidth(100);
                                                }
                                                {
                                                    tableColumn6 = new TableColumn(
                                                            tableVideoFormat,
                                                            SWT.CENTER);
                                                    tableColumn6
                                                            .setText("Shortname");
                                                    tableColumn6.setWidth(100);
                                                }

                                            }
                                            {
                                                labelVideoFormatSearch = new Label(
                                                        groupVideoFormatOverview,
                                                        SWT.NONE);
                                                labelVideoFormatSearch
                                                        .setText("Suche nach:");
                                                GridData label2LData = new GridData();
                                                label2LData.horizontalSpan = 2;
                                                labelVideoFormatSearch
                                                        .setLayoutData(label2LData);
                                            }
                                            {
                                                textVideoFormatSearch = new Text(
                                                        groupVideoFormatOverview,
                                                        SWT.BORDER);
                                                GridData text2LData = new GridData();
                                                text2LData.horizontalAlignment = GridData.FILL;
                                                text2LData.horizontalSpan = 4;
                                                text2LData.grabExcessHorizontalSpace = true;
                                                textVideoFormatSearch
                                                        .setLayoutData(text2LData);

                                                textVideoFormatSearch
                                                        .addFocusListener(new FocusAdapter() {
                                                            public void focusLost(
                                                                    FocusEvent arg0) {
                                                                System.out
                                                                        .println("Focus Verloren: "
                                                                                + textVideoFormatSearch
                                                                                        .getText());
                                                                refreshVideoFormatTable(textVideoFormatSearch
                                                                        .getText());
                                                            }
                                                        });

                                                textVideoFormatSearch
                                                        .addListener(
                                                                SWT.DefaultSelection,
                                                                new Listener() {
                                                                    public void handleEvent(
                                                                            Event e) { //check
                                                                        // for
                                                                        // "enter"
                                                                        // key
                                                                        System.out
                                                                                .println("Enter key: "
                                                                                        + textVideoFormatSearch
                                                                                                .getText());
                                                                        refreshVideoFormatTable(textVideoFormatSearch
                                                                                .getText());

                                                                    }
                                                                });

                                            }

                                        }
                                        {
                                            groupVideoFormatDetail = new Group(
                                                    sashFormVideoFormat,
                                                    SWT.NONE);

                                            GridLayout groupVideoFormatDetailLayout = new GridLayout();
                                            groupVideoFormatDetailLayout.numColumns = 6;
                                            groupVideoFormatDetailLayout.verticalSpacing = 15;
                                            groupVideoFormatDetailLayout.marginHeight = 25;
                                            groupVideoFormatDetail
                                                    .setLayout(groupVideoFormatDetailLayout);
                                            groupVideoFormatDetail
                                                    .setText("Detail");

                                            FormData formData = new FormData();
                                            formData.left = new FormAttachment(
                                                    33, 5);
                                            formData.right = new FormAttachment(
                                                    100, -5);
                                            formData.top = new FormAttachment(
                                                    0, 5);
                                            formData.bottom = new FormAttachment(
                                                    100, -5);
                                            groupVideoFormatDetail
                                                    .setLayoutData(formData);
                                            {
                                                labelVideoFormatId = new Label(
                                                        groupVideoFormatDetail,
                                                        SWT.NONE);
                                                labelVideoFormatId
                                                        .setText("VideoFormat ID:");
                                                GridData formData2 = new GridData();
                                                labelVideoFormatId.setSize(125,
                                                        15);
                                                formData2.widthHint = 125;
                                                formData2.heightHint = 15;
                                                formData2.horizontalSpan = 2;
                                                labelVideoFormatId
                                                        .setLayoutData(formData2);
                                            }
                                            {
                                                textVideoFormatID = new Text(
                                                        groupVideoFormatDetail,
                                                        SWT.READ_ONLY
                                                                | SWT.BORDER);
                                                textVideoFormatID.setText("");
                                                GridData text1LData1 = new GridData();
                                                text1LData1.horizontalSpan = 4;
                                                text1LData1.grabExcessHorizontalSpace = true;
                                                text1LData1.horizontalAlignment = GridData.FILL;
                                                text1LData1.heightHint = 13;
                                                textVideoFormatID
                                                        .setLayoutData(text1LData1);
                                            }
                                            {
                                                labelVideoFormatName = new Label(
                                                        groupVideoFormatDetail,
                                                        SWT.NONE);
                                                labelVideoFormatName
                                                        .setText("VideoFormat Name:");
                                                GridData labelVideoFormatNameLData = new GridData();
                                                labelVideoFormatName.setSize(
                                                        125, 15);
                                                labelVideoFormatNameLData.heightHint = 15;
                                                labelVideoFormatNameLData.horizontalSpan = 2;
                                                labelVideoFormatNameLData.widthHint = 125;
                                                labelVideoFormatName
                                                        .setLayoutData(labelVideoFormatNameLData);
                                            }
                                            {
                                                textVideoFormatName = new Text(
                                                        groupVideoFormatDetail,
                                                        SWT.READ_ONLY
                                                                | SWT.BORDER);
                                                textVideoFormatName.setText("");
                                                GridData text1LData2 = new GridData();
                                                text1LData2.horizontalAlignment = GridData.FILL;
                                                text1LData2.horizontalSpan = 4;
                                                text1LData2.grabExcessHorizontalSpace = true;
                                                text1LData2.heightHint = 13;
                                                textVideoFormatName
                                                        .setLayoutData(text1LData2);
                                            }
                                            {
                                                labelVideoFormatShortname = new Label(
                                                        groupVideoFormatDetail,
                                                        SWT.NONE);
                                                labelVideoFormatShortname
                                                        .setText("VideoFormat Kurzname:");
                                                GridData label1LData1 = new GridData();
                                                labelVideoFormatShortname
                                                        .setSize(125, 15);
                                                label1LData1.widthHint = 125;
                                                label1LData1.heightHint = 15;
                                                label1LData1.horizontalSpan = 2;
                                                labelVideoFormatShortname
                                                        .setLayoutData(label1LData1);
                                            }
                                            {
                                                textVideoFormatShortname = new Text(
                                                        groupVideoFormatDetail,
                                                        SWT.READ_ONLY
                                                                | SWT.BORDER);
                                                textVideoFormatShortname
                                                        .setText("");
                                                GridData text1LData3 = new GridData();
                                                text1LData3.horizontalAlignment = GridData.FILL;
                                                text1LData3.horizontalSpan = 4;
                                                text1LData3.grabExcessHorizontalSpace = true;
                                                text1LData3.heightHint = 13;
                                                textVideoFormatShortname
                                                        .setLayoutData(text1LData3);
                                            }
                                            {
                                                composite2 = new Composite(
                                                        groupVideoFormatDetail,
                                                        SWT.EMBEDDED);
                                                GridLayout composite2Layout = new GridLayout();
                                                composite2Layout.numColumns = 6;
                                                GridData composite2LData = new GridData();
                                                composite2LData.horizontalSpan = 6;
                                                composite2LData.grabExcessHorizontalSpace = true;
                                                composite2LData.horizontalAlignment = GridData.CENTER;
                                                composite2LData.grabExcessVerticalSpace = true;
                                                composite2LData.widthHint = 322;
                                                composite2LData.verticalAlignment = GridData.END;
                                                composite2
                                                        .setLayoutData(composite2LData);
                                                composite2
                                                        .setLayout(composite2Layout);
                                                {
                                                    buttonVideoFormatNew = new Button(
                                                            composite2,
                                                            SWT.PUSH
                                                                    | SWT.CENTER);
                                                    buttonVideoFormatNew
                                                            .setText("Neu");
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
                                                    buttonVideoFormatEdit = new Button(
                                                            composite2,
                                                            SWT.PUSH
                                                                    | SWT.CENTER);
                                                    buttonVideoFormatEdit
                                                            .setText("Bearbeiten");
                                                    buttonVideoFormatEdit
                                                            .setEnabled(false);
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
                                                                    tableVideoFormat
                                                                            .setEnabled(false);

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
                                                    buttonVideoFormatDelete = new Button(
                                                            composite2,
                                                            SWT.PUSH
                                                                    | SWT.CENTER);
                                                    buttonVideoFormatDelete
                                                            .setText("Löschen");
                                                    buttonVideoFormatDelete
                                                            .setEnabled(false);
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
                                                    buttonVideoFormatFill = new Button(
                                                            composite2,
                                                            SWT.PUSH
                                                                    | SWT.CENTER);
                                                    buttonVideoFormatFill
                                                            .setText("");
                                                    GridData buttonVideoFormatFillLData = new GridData();
                                                    buttonVideoFormatFill
                                                            .setVisible(false);
                                                    buttonVideoFormatFill
                                                            .setEnabled(false);
                                                    buttonVideoFormatFillLData.widthHint = 30;
                                                    buttonVideoFormatFillLData.heightHint = 23;
                                                    buttonVideoFormatFill
                                                            .setLayoutData(buttonVideoFormatFillLData);
                                                }
                                                {
                                                    buttonVideoFormatSave = new Button(
                                                            composite2,
                                                            SWT.PUSH
                                                                    | SWT.CENTER);
                                                    buttonVideoFormatSave
                                                            .setText("Speichern");
                                                    buttonVideoFormatSave
                                                            .setEnabled(false);
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
                                                    buttonVideoFormatCancel = new Button(
                                                            composite2,
                                                            SWT.PUSH
                                                                    | SWT.CENTER);
                                                    buttonVideoFormatCancel
                                                            .setText("Abbruch");
                                                    buttonVideoFormatCancel
                                                            .setEnabled(false);
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
                                    groupAudioFormat = new Group(sashForm1,
                                            SWT.NONE);
                                    GridLayout group1Layout = new GridLayout();
                                    FormData group1LData = new FormData();
                                    group1LData.height = 240;
                                    group1LData.width = 750;
                                    group1LData.left = new FormAttachment(0,
                                            1000, 0);
                                    group1LData.right = new FormAttachment(
                                            1000, 1000, 0);
                                    group1LData.top = new FormAttachment(500,
                                            1000, 0);
                                    group1LData.bottom = new FormAttachment(
                                            1000, 1000, 0);
                                    groupAudioFormat.setLayoutData(group1LData);
                                    group1Layout.makeColumnsEqualWidth = true;
                                    groupAudioFormat.setLayout(group1Layout);
                                    groupAudioFormat.setText("AudioFormat");
                                    {
                                        sashFormAudioFormat = new SashForm(
                                                groupAudioFormat, SWT.NONE);
                                        FormLayout sashForm1Layout = new FormLayout();
                                        GridData sashForm1LData = new GridData();
                                        sashForm1LData.grabExcessHorizontalSpace = true;
                                        sashForm1LData.horizontalSpan = 6;
                                        sashForm1LData.horizontalAlignment = GridData.FILL;
                                        sashForm1LData.verticalAlignment = GridData.FILL;
                                        sashForm1LData.grabExcessVerticalSpace = true;
                                        sashFormAudioFormat
                                                .setLayoutData(sashForm1LData);
                                        sashFormAudioFormat
                                                .setLayout(sashForm1Layout);
                                        {
                                            groupAudioFormatOverview = new Group(
                                                    sashFormAudioFormat,
                                                    SWT.NONE);
                                            GridLayout group3Layout = new GridLayout();
                                            group3Layout.numColumns = 6;
                                            groupAudioFormatOverview
                                                    .setText("Übersicht");
                                            FormData group3LData = new FormData();
                                            groupAudioFormatOverview
                                                    .setLayout(group3Layout);
                                            group3LData.right = new FormAttachment(
                                                    100, 100, -5);
                                            group3LData.top = new FormAttachment(
                                                    0, 100, 5);
                                            group3LData.bottom = new FormAttachment(
                                                    100, 100, -5);
                                            groupAudioFormatOverview
                                                    .setLayoutData(group3LData);
                                            {
                                                tableAudioFormat = new Table(
                                                        groupAudioFormatOverview,
                                                        SWT.SINGLE
                                                                | SWT.FULL_SELECTION
                                                                | SWT.V_SCROLL
                                                                | SWT.BORDER);
                                                tableAudioFormat
                                                        .setHeaderVisible(true);
                                                tableAudioFormat
                                                        .setLinesVisible(true);
                                                GridData table1LData = new GridData();
                                                tableAudioFormat
                                                        .addSelectionListener(new SelectionAdapter() {
                                                            public void widgetSelected(
                                                                    SelectionEvent evt) {

                                                                int index = tableDirector
                                                                        .getSelectionIndex();
                                                                System.out
                                                                        .println("Table select. id: "
                                                                                + index
                                                                                + " TableItem:"
                                                                                + tableDirector
                                                                                        .getItem(index)
                                                                                + " id: "
                                                                                + tableDirector
                                                                                        .getItem(
                                                                                                index)
                                                                                        .getText(
                                                                                                0));
                                                            }
                                                        });
                                                table1LData.verticalAlignment = GridData.FILL;
                                                table1LData.horizontalAlignment = GridData.FILL;
                                                table1LData.horizontalSpan = 6;
                                                table1LData.grabExcessHorizontalSpace = true;
                                                table1LData.grabExcessVerticalSpace = true;
                                                tableAudioFormat
                                                        .setLayoutData(table1LData);
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
                                                    tableColumn2
                                                            .setText("Name");
                                                    tableColumn2.setWidth(100);
                                                }
                                                {
                                                    tableColumn3 = new TableColumn(
                                                            tableAudioFormat,
                                                            SWT.CENTER);
                                                    tableColumn3
                                                            .setText("vorname");
                                                    tableColumn3.setWidth(100);
                                                }
                                            }
                                            {
                                                labelAudioFormatSearch = new Label(
                                                        groupAudioFormatOverview,
                                                        SWT.NONE);
                                                labelAudioFormatSearch
                                                        .setText("Suche nach:");
                                                GridData label1LData = new GridData();
                                                label1LData.horizontalSpan = 2;
                                                labelAudioFormatSearch
                                                        .setLayoutData(label1LData);
                                            }
                                            {
                                                textAudioFormatSearch = new Text(
                                                        groupAudioFormatOverview,
                                                        SWT.BORDER);
                                                GridData text1LData = new GridData();
                                                text1LData.horizontalAlignment = GridData.FILL;
                                                text1LData.horizontalSpan = 4;
                                                text1LData.grabExcessHorizontalSpace = true;
                                                textAudioFormatSearch
                                                        .setLayoutData(text1LData);
                                            }
                                        }
                                        {
                                            groupAudioFormatDetail = new Group(
                                                    sashFormAudioFormat,
                                                    SWT.NONE);
                                            GridLayout group4Layout = new GridLayout();
                                            group4Layout.numColumns = 2;
                                            groupAudioFormatDetail
                                                    .setText("Detail");
                                            FormData group4LData = new FormData();
                                            groupAudioFormatDetail
                                                    .setLayout(group4Layout);
                                            group4LData.left = new FormAttachment(
                                                    0, 100, 5);
                                            group4LData.top = new FormAttachment(
                                                    0, 100, 5);
                                            group4LData.bottom = new FormAttachment(
                                                    100, 100, -5);
                                            groupAudioFormatDetail
                                                    .setLayoutData(group4LData);
                                            {
                                                list1 = new List(
                                                        groupAudioFormatDetail,
                                                        SWT.SINGLE
                                                                | SWT.H_SCROLL
                                                                | SWT.V_SCROLL
                                                                | SWT.BORDER);
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
                        }
                        {
                            cTabItem2 = new CTabItem(cTabFolder1, SWT.NONE);
                            cTabItem2.setText("cTabItem2");
                            {
                                sashFormDirector = new SashForm(cTabFolder1,
                                        SWT.NONE);
                                cTabItem2.setControl(sashFormDirector);
                                FormLayout sashFormDirectorLayout = new FormLayout();
                                sashFormDirector
                                        .setLayout(sashFormDirectorLayout);
                                {
                                    group1Director = new Group(
                                            sashFormDirector, SWT.NONE);
                                    GridLayout gridLayout = new GridLayout();
                                    gridLayout.numColumns = 6;
                                    group1Director
                                            .setText("Directors Übersicht");
                                    FormData formData = new FormData();
                                    group1Director.setLayout(gridLayout);
                                    formData.right = new FormAttachment(100,
                                            100, -5);
                                    formData.top = new FormAttachment(0, 100, 5);
                                    formData.bottom = new FormAttachment(100,
                                            100, -5);
                                    group1Director.setLayoutData(formData);
                                    {
                                        tableDirector = new Table(
                                                group1Director, SWT.SINGLE
                                                        | SWT.FULL_SELECTION
                                                        | SWT.V_SCROLL
                                                        | SWT.BORDER);
                                        tableDirector.setHeaderVisible(true);
                                        tableDirector.setLinesVisible(true);
                                        GridData griddata = new GridData();
                                        tableDirector
                                                .addSelectionListener(new SelectionAdapter() {
                                                    public void widgetSelected(
                                                            SelectionEvent evt) {

                                                        int index = tableDirector
                                                                .getSelectionIndex();
                                                        System.out
                                                                .println("Table select. id: "
                                                                        + index
                                                                        + " TableItem:"
                                                                        + tableDirector
                                                                                .getItem(index)
                                                                        + " id: "
                                                                        + tableDirector
                                                                                .getItem(
                                                                                        index)
                                                                                .getText(
                                                                                        0));
                                                    }
                                                });
                                        griddata.verticalAlignment = GridData.FILL;
                                        griddata.horizontalAlignment = GridData.FILL;
                                        griddata.horizontalSpan = 6;
                                        griddata.grabExcessHorizontalSpace = true;
                                        griddata.grabExcessVerticalSpace = true;
                                        tableDirector.setLayoutData(griddata);
                                        {
                                            tableColumnDirectorId = new TableColumn(
                                                    tableDirector, SWT.CENTER);
                                            tableColumnDirectorId.setText("id");
                                            tableColumnDirectorId.setWidth(100);
                                        }
                                        {
                                            tableColumnDirectorLastname = new TableColumn(
                                                    tableDirector, SWT.CENTER);
                                            tableColumnDirectorLastname
                                                    .setText("Name");
                                            tableColumnDirectorLastname
                                                    .setWidth(100);

                                        }
                                        {
                                            tableColumnDirectorFirstname = new TableColumn(
                                                    tableDirector, SWT.CENTER);
                                            tableColumnDirectorFirstname
                                                    .setText("Short");
                                            tableColumnDirectorFirstname
                                                    .setWidth(100);

                                        }
                                    }
                                    {
                                        filterLabelVideoFormat = new Label(
                                                group1Director, SWT.NONE);
                                        filterLabelVideoFormat
                                                .setText("Suche nach:");
                                        GridData data1 = new GridData();
                                        data1.horizontalSpan = 2;
                                        filterLabelVideoFormat
                                                .setLayoutData(data1);
                                    }
                                    {
                                        filterTextVideoFormat = new Text(
                                                group1Director, SWT.BORDER);
                                        GridData data2 = new GridData();

                                        data2.horizontalAlignment = GridData.FILL;
                                        data2.horizontalSpan = 4;
                                        data2.grabExcessHorizontalSpace = true;
                                        filterTextVideoFormat
                                                .setLayoutData(data2);
                                    }
                                }
                                {
                                    group2Director = new Group(
                                            sashFormDirector, SWT.NONE);
                                    GridLayout gridLayout = new GridLayout();
                                    gridLayout.numColumns = 2;
                                    group2Director.setText("Filmliste");
                                    FormData formData = new FormData();
                                    group2Director.setLayout(gridLayout);
                                    formData.left = new FormAttachment(0, 100,
                                            5);
                                    formData.top = new FormAttachment(0, 100, 5);
                                    formData.bottom = new FormAttachment(100,
                                            100, -5);
                                    group2Director.setLayoutData(formData);
                                    {
                                        list3 = new List(group2Director,
                                                SWT.SINGLE | SWT.H_SCROLL
                                                        | SWT.V_SCROLL
                                                        | SWT.BORDER);
                                        GridData list3LData = new GridData();
                                        list3
                                                .addSelectionListener(new SelectionAdapter() {
                                                    public void widgetSelected(
                                                            SelectionEvent evt) {
                                                        System.out
                                                                .println("list1.widgetSelected, event="
                                                                        + evt);

                                                        //TODO add your code for
                                                        // list1.widgetSelected
                                                    }
                                                });
                                        list3LData.verticalAlignment = GridData.FILL;
                                        list3LData.horizontalAlignment = GridData.FILL;
                                        list3LData.grabExcessHorizontalSpace = true;
                                        list3LData.grabExcessVerticalSpace = true;
                                        list3.setLayoutData(list3LData);
                                    }
                                }
                            }
                        }
                    }
                }
                {
                    compositeStatusLine = new Composite(compositeRoot,
                            SWT.EMBEDDED);
                    GridLayout composite2Layout = new GridLayout();
                    composite2Layout.marginWidth = 0;
                    composite2Layout.marginHeight = 0;
                    composite2Layout.makeColumnsEqualWidth = true;
                    composite2Layout.horizontalSpacing = 0;
                    composite2Layout.verticalSpacing = 0;
                    GridData composite2LData = new GridData();
                    compositeStatusLine.setLayout(composite2Layout);
                    composite2LData.horizontalAlignment = GridData.FILL;
                    composite2LData.heightHint = 14;
                    composite2LData.grabExcessHorizontalSpace = true;
                    compositeStatusLine.setLayoutData(composite2LData);
                    {
                        initStatusLine();
                    }
                }
            }
            shell.layout();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initStatusLine() {
        statusLine = new StyledText(compositeStatusLine, SWT.READ_ONLY);
        statusLine.setText("");
        statusLine
                .setToolTipText("Hier finden Sie wichtige Statusinformationen");
        statusLine.setBackground(ColorDef.STATUS_B_STANDARD);
        statusLine.setForeground(ColorDef.STATUS_F_STANDARD);
        statusLine.setDoubleClickEnabled(false);
        statusLine.setEditable(false);
        statusLine.setEnabled(true);
        GridData styledText1LData = new GridData();

        styledText1LData.horizontalAlignment = GridData.FILL;
        styledText1LData.grabExcessHorizontalSpace = true;
        statusLine.setLayoutData(styledText1LData);
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

    /**
     * Sets a message for the Statusline
     * 
     * @param mode
     * @param message
     */
    private void setStatus(final int mode, final String message) {
        /**
         * mode values 0 normal message 1 information message 2 warn message 3
         * error message
         *  
         */
        if (mode == 0) {
            statusLine.setBackground(ColorDef.STATUS_B_STANDARD);
            statusLine.setForeground(ColorDef.STATUS_F_STANDARD);
        } else if (mode == 1) {
            statusLine.setBackground(ColorDef.STATUS_B_INFO);
            statusLine.setForeground(ColorDef.STATUS_F_INFO);
        } else if (mode == 2) {
            statusLine.setBackground(ColorDef.STATUS_B_WARN);
            statusLine.setForeground(ColorDef.STATUS_F_WARN);
        } else if (mode == 3) {
            statusLine.setBackground(ColorDef.STATUS_B_ERROR);
            statusLine.setForeground(ColorDef.STATUS_F_ERROR);
        }

        statusLine.setText(message);

        /**
         * @todo hier jetzt nach ca. 10 sec. wieder normale Farbe einblenden
         */

    }

}
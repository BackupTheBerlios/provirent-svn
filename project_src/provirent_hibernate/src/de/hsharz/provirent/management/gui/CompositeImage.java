package de.hsharz.provirent.management.gui;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.cloudgarden.resource.SWTResourceManager;

import de.hsharz.provirent.objects.Actor;
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
public class CompositeImage extends AbstractComposite {

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }

    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(CompositeImage.class);

    byte[] imagebytedata;

    private Label labelImagesResize;

    private Scale scaleResize;

    private Text textFileUrl;

    private Button buttonSelectFile;

    private Label labelImagesFile;

    private SashForm sashForm1;

    private SashForm sashForm2;

    private Image ideaImage, scaledImage;

    int iy, ix = 0;

    private String currentDir = "";

    private Canvas canvasImg;

    private final static int MODE_VIEW = 0;

    private final static int MODE_ADD = 1;

    private Composite compositeButtons;

    private Button buttonImageCancel;

    private Button buttonImageSave;

    private Button buttonImageFill;

    private Button buttonImageDelete;

    private Button buttonImageEdit;

    private Button buttonImageNew;

    private final static int MODE_EDIT = 2;

    private Table tableImagesOverview;

    private TableColumn tableImagesOverview_ColumnID;

    private TableColumn tableImagesOverview_ColumnName;

    private TableColumn tableImagesOverview_ColumnDescription;

    private Group groupImage;

    private Group groupImagesOverview;

    private Group groupImagesDetail;

    private Text textImagesSearch;

    private Text textImagesID;

    private Text textImagesName;

    private Text textImagesDescription;

    private Label labelImagesSearch;

    private Label labelImagesID;

    private Label labelImagesFName;

    private Label labelImagesDescription;

    protected int mode_image;

    private StatusLineStyledText statusLine;

    private ResourceBundle l;

    private Composite parent;

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
                "de.hsharz.provirent.management.gui.language.images", locale);

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

        CompositeImage p = new CompositeImage(shell, SWT.NONE, null, Locale
                .getDefault());

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }

    public CompositeImage(Composite p, int style, StatusLineStyledText status,
            Locale l) {
        super(p, style, status, l);
        parent = p;
        //Statusline wird gestzt
        statusLine = status;

        //sprache wird init
        initLanguage(l);

        initGUI();
    }

    private void initGUI() {
        {
        }
        if (logger.isDebugEnabled()) {
            logger.debug("initGUI() - start");
        }

        this.setLayout(new GridLayout());
        this.setSize(816, 540);
        {
            groupImage = new Group(this, SWT.NONE);
            GridLayout groupActorLayout = new GridLayout();
            GridData groupActorLData = new GridData();
            groupActorLData.grabExcessHorizontalSpace = true;
            groupActorLData.grabExcessVerticalSpace = true;
            groupActorLData.horizontalAlignment = GridData.FILL;
            groupActorLData.verticalAlignment = GridData.FILL;
            groupImage.setLayoutData(groupActorLData);
            groupActorLayout.makeColumnsEqualWidth = true;
            groupImage.setLayout(groupActorLayout);
            groupImage.setText(l.getString("images.group.label"));
            {
                sashForm2 = new SashForm(groupImage, SWT.NONE);
                GridData sashForm2LData = new GridData();
                sashForm2LData.verticalAlignment = GridData.FILL;
                sashForm2LData.horizontalAlignment = GridData.FILL;
                sashForm2LData.grabExcessHorizontalSpace = true;
                sashForm2LData.grabExcessVerticalSpace = true;
                sashForm2.setLayoutData(sashForm2LData);

            }
            // init the rest of the layout
            initImagesOverview();
            initImagesDetail();
            refreshImageOverviewTable(textImagesSearch.getText());
        }

        this.layout();

        if (logger.isDebugEnabled()) {
            logger.debug("initGUI() - end");
        }
    }

    private void initImagesOverview() {
        //	  Group Images Overview 

        groupImagesOverview = new Group(sashForm2, SWT.NONE);
        GridLayout group1Layout = new GridLayout();
        group1Layout.numColumns = 8;
        groupImagesOverview.setLayout(group1Layout);
        groupImagesOverview.setText(l.getString("images.groupoverview.label"));

        {// table Images Overview
            tableImagesOverview = new Table(groupImagesOverview, SWT.SINGLE
                    | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.BORDER);
            GridData tableImagesOverviewLData = new GridData();
            tableImagesOverview.setHeaderVisible(true);
            tableImagesOverview.setLinesVisible(true);
            tableImagesOverviewLData.horizontalAlignment = GridData.FILL;
            tableImagesOverviewLData.verticalAlignment = GridData.FILL;
            tableImagesOverviewLData.horizontalSpan = 8;
            tableImagesOverviewLData.grabExcessHorizontalSpace = true;
            tableImagesOverviewLData.grabExcessVerticalSpace = true;
            tableImagesOverview.setLayoutData(tableImagesOverviewLData);
            tableImagesOverview.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent evt) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("widgetSelected(SelectionEvent evt = "
                                + evt + ") - start");
                    }

                    int index = tableImagesOverview.getSelectionIndex();

                    //es wurde ein Element aus Tabelle ausgewaehlt jetzt muss die
                    //Detailansicht aktualisiert werden
                    refreshImagesDetail(tableImagesOverview.getItem(index)
                            .getText(0));

                    if (logger.isDebugEnabled()) {
                        logger.debug("widgetSelected(SelectionEvent) - end");
                    }
                }
            });
            {
                tableImagesOverview_ColumnID = new TableColumn(
                        tableImagesOverview, SWT.CENTER);
                tableImagesOverview_ColumnID.setText(l
                        .getString("images.groupoverview.columnid"));
                tableImagesOverview_ColumnID.setWidth(40);

                tableImagesOverview_ColumnName = new TableColumn(
                        tableImagesOverview, SWT.CENTER);
                tableImagesOverview_ColumnName.setText(l
                        .getString("images.groupoverview.name"));
                tableImagesOverview_ColumnName.setWidth(80);

                tableImagesOverview_ColumnDescription = new TableColumn(
                        tableImagesOverview, SWT.CENTER);
                tableImagesOverview_ColumnDescription.setText(l
                        .getString("images.groupoverview.description"));
                tableImagesOverview_ColumnDescription.setWidth(80);

            }
        }
        // table Images Overview
        // Search
        {
            //label for Search
            labelImagesSearch = new Label(groupImagesOverview, SWT.NONE);
            labelImagesSearch.setText(l
                    .getString("images.groupoverview.searchlabel")
                    + ":");
            GridData labelImagesResizeLData = new GridData();
            labelImagesResizeLData.horizontalSpan = 3;
            labelImagesSearch.setLayoutData(labelImagesResizeLData);

            //text Search
            textImagesSearch = new Text(groupImagesOverview, SWT.BORDER);
            GridData text2LData = new GridData();
            textImagesSearch.addFocusListener(new FocusAdapter() {
                public void focusLost(FocusEvent evt) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("focusLost(FocusEvent evt = " + evt + " "
                                + textImagesSearch.getText() + ") - start");
                    }

                    refreshImageOverviewTable(textImagesSearch.getText());

                    if (logger.isDebugEnabled()) {
                        logger.debug("focusLost(FocusEvent) - end");
                    }
                }
            });
            textImagesSearch.addListener(SWT.DefaultSelection, new Listener() {
                public void handleEvent(Event e) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("handleEvent(Event e = " + e + " "
                                + textImagesSearch.getText() + ") - start");
                    }

                    refreshImageOverviewTable(textImagesSearch.getText());

                    if (logger.isDebugEnabled()) {
                        logger.debug("handleEvent(Event) - end");
                    }
                }
            });
            text2LData.horizontalAlignment = GridData.FILL;
            text2LData.horizontalSpan = 5;
            text2LData.grabExcessHorizontalSpace = true;
            textImagesSearch.setLayoutData(text2LData);
        }// Search                    

    }

    private void initImagesDetail() {
        // Group Images Detail
        {
            groupImagesDetail = new Group(sashForm2, SWT.NONE);
            GridLayout group2Layout = new GridLayout();
            GridData group2LData = new GridData();
            group2Layout.verticalSpacing = 15;
            group2Layout.numColumns = 6;
            groupImagesDetail.setText(l.getString("images.groupdetail.label"));
            FormData formData = new FormData();
            groupImagesDetail.setLayout(group2Layout);
            formData.right = new FormAttachment(100, 100, -5);
            formData.top = new FormAttachment(0, 100, 5);
            formData.bottom = new FormAttachment(100, 100, -5);
            groupImagesDetail.setLayoutData(formData);

            // labels and buttons for detail

            labelImagesID = new Label(groupImagesDetail, SWT.NONE);
            labelImagesID.setText(l.getString("images.groupdetail.labelid")
                    + ":");
            labelImagesID.setSize(125, 15);
            GridData formData2 = new GridData();
            formData2.widthHint = 125;
            formData2.heightHint = 15;
            formData2.horizontalSpan = 2;
            labelImagesID.setLayoutData(formData2);
        }
        {
            textImagesID = new Text(groupImagesDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData1 = new GridData();
            text1LData1.horizontalAlignment = GridData.FILL;
            text1LData1.heightHint = 13;
            text1LData1.horizontalSpan = 4;
            text1LData1.grabExcessHorizontalSpace = true;
            textImagesID.setLayoutData(text1LData1);
        }
        {
            labelImagesFName = new Label(groupImagesDetail, SWT.NONE);
            labelImagesFName.setText(l
                    .getString("images.groupdetail.labelname")
                    + ":");
            labelImagesFName.setSize(125, 15);
            GridData labelActorNameLData = new GridData();
            labelActorNameLData.widthHint = 125;
            labelActorNameLData.heightHint = 15;
            labelActorNameLData.horizontalSpan = 2;
            labelImagesFName.setLayoutData(labelActorNameLData);
        }
        {
            textImagesName = new Text(groupImagesDetail, SWT.READ_ONLY
                    | SWT.BORDER);
            GridData text1LData2 = new GridData();
            text1LData2.horizontalAlignment = GridData.FILL;
            text1LData2.heightHint = 13;
            text1LData2.horizontalSpan = 4;
            text1LData2.grabExcessHorizontalSpace = true;
            textImagesName.setLayoutData(text1LData2);
        }
        {
            labelImagesDescription = new Label(groupImagesDetail, SWT.NONE);
            labelImagesDescription.setText(l
                    .getString("images.groupdetail.labeldescription")
                    + ":");
            labelImagesDescription.setSize(125, 15);
            GridData labelImagesFileLData1 = new GridData();
            labelImagesFileLData1.widthHint = 125;
            labelImagesFileLData1.heightHint = 15;
            labelImagesFileLData1.horizontalSpan = 2;
            labelImagesFileLData1.verticalAlignment = GridData.BEGINNING;
            labelImagesDescription.setLayoutData(labelImagesFileLData1);
        }
        {
            textImagesDescription = new Text(groupImagesDetail, SWT.MULTI
                    | SWT.V_SCROLL | SWT.BORDER);
            textImagesDescription.setEnabled(false);
            GridData text1LData3 = new GridData();
            text1LData3.horizontalAlignment = GridData.FILL;
            text1LData3.heightHint = 36;
            text1LData3.horizontalSpan = 4;
            text1LData3.grabExcessHorizontalSpace = true;
            textImagesDescription.setLayoutData(text1LData3);
        }// label and buttons for detail      
        {
            labelImagesFile = new Label(groupImagesDetail, SWT.NONE);
            labelImagesFile.setText(l
                    .getString("images.groupdetail.labelselectfile")
                    + ":");
            labelImagesFile.setSize(125, 15);
            GridData labelImagesFileLData = new GridData();
            labelImagesFileLData.widthHint = 125;
            labelImagesFileLData.heightHint = 15;
            labelImagesFileLData.horizontalSpan = 2;
            labelImagesFile.setLayoutData(labelImagesFileLData);
        }
        {
            textFileUrl = new Text(groupImagesDetail, SWT.NONE);
            textFileUrl.setEditable(false);
            GridData text1LData = new GridData();
            text1LData.widthHint = 105;
            text1LData.heightHint = 15;
            text1LData.horizontalSpan = 2;
            textFileUrl.setLayoutData(text1LData);
        }
        {
            //Button for selecting a new image file from filesystem
            buttonSelectFile = new Button(groupImagesDetail, SWT.PUSH
                    | SWT.CENTER);
            buttonSelectFile.setText(l
                    .getString("images.groupdetail.buttonselectfile"));
            currentDir = l.getString("images.groupdetail.fileselect.title");
            buttonSelectFile.setEnabled(false);

            GridData buttonSelectFileLData = new GridData();
            buttonSelectFile.addSelectionListener(new SelectionAdapter() {
                //if button is pressed
                public void widgetSelected(SelectionEvent evt) {

                    String[] filterExtensions = { "*.gif", "*.jpg", "*.*" };
                    FileDialog fileDialog = new FileDialog(getShell(), SWT.OPEN);
                    fileDialog.setText(currentDir);
                    fileDialog
                            .setFilterPath(l
                                    .getString("images.groupdetail.fileselect.filterpath"));

                    fileDialog.setFilterExtensions(filterExtensions);
                    //open the dialog and get the returnvalue
                    String selectedFile = fileDialog.open();
                    if (selectedFile != null) {

                        scaledImage = ideaImage = new Image(getDisplay(),
                                selectedFile);

                        canvasImg.redraw();
                        textFileUrl.setText(fileDialog.getFilterPath()
                                + System.getProperty("file.separator")
                                + fileDialog.getFileName());

                        //save the selected dir 
                        currentDir = fileDialog.getFilterPath();

                        //set the resizescale enable
                        scaleResize.setEnabled(true);
                        scaleResize.setSelection(100);
                        scaleResize.setToolTipText(l
                                .getString("images.groupdetail.resize.size")
                                + ": 100%");

                        //reset and resize the scrollbars
                        resetScrollBars();
                        resizeScrollBars();
                    }
                }
            });
            buttonSelectFileLData.horizontalAlignment = GridData.FILL;
            buttonSelectFileLData.grabExcessHorizontalSpace = true;
            buttonSelectFileLData.horizontalSpan = 2;
            buttonSelectFile.setLayoutData(buttonSelectFileLData);

            canvasImg = new Canvas(groupImagesDetail, SWT.NO_REDRAW_RESIZE
                    | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
            GridData canvasImgLData = new GridData();
            canvasImgLData.grabExcessHorizontalSpace = true;
            canvasImgLData.horizontalAlignment = GridData.FILL;
            canvasImgLData.horizontalSpan = 6;
            canvasImgLData.grabExcessVerticalSpace = true;
            canvasImgLData.verticalAlignment = GridData.FILL;
            canvasImg.setLayoutData(canvasImgLData);
            canvasImg.addPaintListener(new PaintListener() {
                public void paintControl(PaintEvent e) {
                    if (ideaImage != null && !ideaImage.isDisposed()) {
                        paintImage(e);
                        //e.gc.drawImage(scaledImage, 0, 0);
                    }
                }
            });

            // Set up the image canvas scroll bars.
            ScrollBar horizontal = canvasImg.getHorizontalBar();
            horizontal.setVisible(true);
            horizontal.setMinimum(0);
            horizontal.setEnabled(false);
            horizontal.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent event) {
                    scrollHorizontally((ScrollBar) event.widget);
                }
            });
            ScrollBar vertical = canvasImg.getVerticalBar();
            vertical.setVisible(true);
            vertical.setMinimum(0);
            vertical.setEnabled(false);
            vertical.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent event) {
                    scrollVertically((ScrollBar) event.widget);
                }
            });

        }
        {
            labelImagesResize = new Label(groupImagesDetail, SWT.NONE);
            labelImagesResize.setText(l
                    .getString("images.groupdetail.labelresize")
                    + ":");
            labelImagesResize.setSize(125, 15);
            GridData labelImagesResizeLData1 = new GridData();
            labelImagesResizeLData1.widthHint = 125;
            labelImagesResizeLData1.heightHint = 15;
            labelImagesResizeLData1.horizontalSpan = 2;
            labelImagesResize.setLayoutData(labelImagesResizeLData1);
        }
        {
            scaleResize = new Scale(groupImagesDetail, SWT.NONE);
            GridData scaleResizeLData = new GridData();
            scaleResize.setEnabled(false);
            scaleResize.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent evt) {

                    //set new tooltip, so User can see the current size
                    scaleResize.setToolTipText(l
                            .getString("images.groupdetail.resize.size")
                            + ": " + scaleResize.getSelection() + "%");

                    //skale the image
                    float scaleFaktor = (float) scaleResize.getSelection() / 100;
                    if (scaleFaktor < 0.01)
                        scaleFaktor = (float) 0.01;
                    int newwidth = (int) (ideaImage.getBounds().width * scaleFaktor);
                    int newheight = (int) (ideaImage.getBounds().height * scaleFaktor);

                    ImageData newdata = ideaImage.getImageData().scaledTo(
                            newwidth, newheight);

                    scaledImage = new Image(getDisplay(), newdata);

                    //redraw the image
                    canvasImg.redraw();
                    resizeScrollBars();
                }
            });
            scaleResizeLData.grabExcessHorizontalSpace = true;
            scaleResizeLData.horizontalAlignment = GridData.FILL;
            scaleResizeLData.horizontalSpan = 4;
            scaleResize.setLayoutData(scaleResizeLData);

            scaleResize.setMaximum(200);
            scaleResize.setMinimum(1);
            scaleResize.setIncrement(5);
            scaleResize.setPageIncrement(5);
        }
        {
            compositeButtons = new Composite(groupImagesDetail, SWT.EMBEDDED);
            GridLayout composite2Layout = new GridLayout();
            composite2Layout.numColumns = 6;
            GridData composite2LData = new GridData();
            compositeButtons.setLayout(composite2Layout);
            composite2LData.verticalAlignment = GridData.END;
            composite2LData.horizontalAlignment = GridData.CENTER;
            composite2LData.widthHint = 391;
            composite2LData.heightHint = 35;
            composite2LData.horizontalSpan = 6;
            composite2LData.grabExcessHorizontalSpace = true;
            compositeButtons.setLayoutData(composite2LData);
            {
                buttonImageNew = new Button(compositeButtons, SWT.PUSH
                        | SWT.CENTER);
                buttonImageNew.setText(l.getString("button.new"));
                buttonImageNew.addSelectionListener(new SelectionAdapter() {
                    public void widgetSelected(SelectionEvent evt) {

                        mode_image = ManagementGui.MODE_ADD;

                        textImagesID.setText("");
                        textImagesName.setText("");
                        textImagesDescription.setText("");
                        
                        textImagesName.setEditable(true);
                        textImagesDescription.setEditable(true);
                        buttonSelectFile.setEnabled(true);
                        
                        ideaImage=scaledImage = null;
                        canvasImg.redraw();
                        
                        buttonImageCancel.setEnabled(true);
                        buttonImageSave.setEnabled(true);
                        buttonImageNew.setEnabled(false);
                        buttonImageEdit.setEnabled(false);
                        buttonImageDelete.setEnabled(false);

                        textImagesSearch.setEditable(false);
                        tableImagesOverview.setEnabled(false);

                    }
                });

                buttonImageEdit = new Button(compositeButtons, SWT.PUSH
                        | SWT.CENTER);
                buttonImageEdit.setText(l.getString("button.edit"));
                buttonImageEdit.setEnabled(false);
                buttonImageEdit.addSelectionListener(new SelectionAdapter() {
                    public void widgetSelected(SelectionEvent evt) {

                        mode_image = ManagementGui.MODE_EDIT;

                        textImagesID.setEditable(false);
                        textImagesName.setEditable(true);
                        
                        textImagesDescription.setEditable(true);
                        textImagesName.setFocus();

                        buttonImageCancel.setEnabled(true);
                        buttonImageSave.setEnabled(true);
                        
                        buttonImageNew.setEnabled(false);
                        buttonImageEdit.setEnabled(false);
                        buttonImageDelete.setEnabled(false);

                        tableImagesOverview.setEnabled(false);
                        textImagesSearch.setEnabled(false);

                    }
                });

                buttonImageDelete = new Button(compositeButtons, SWT.PUSH
                        | SWT.CENTER);
                buttonImageDelete.setText(l.getString("button.delete"));
                buttonImageDelete.setEnabled(false);
                buttonImageDelete.addSelectionListener(new SelectionAdapter() {
                    public void widgetSelected(SelectionEvent evt) {
                        logger.debug("buttonImageDelete.widgetSelected, event="
                                + evt);

                        String msg = MessageFormat
                                .format(
                                        l
                                                .getString("images.groupdetail.deletebutton.question.text"),
                                        new Object[] { textImagesName.getText() });

                        int question = showMsg(
                                msg,
                                l
                                        .getString("images.groupdetail.deletebutton.question.header"),
                                SWT.ICON_QUESTION | SWT.YES | SWT.NO);

                        if (question != SWT.YES) {
                            return;
                        }

                        de.hsharz.provirent.objects.Image o = new de.hsharz.provirent.objects.Image();
                        o.setImageId(new Integer(Integer.parseInt(textImagesID
                                .getText())));
                        o.setImageFileName(textImagesName.getText());
                        o.setImageFileDescription(textImagesDescription
                                .getText());

                        /**@todo BildDatei holen */
                        /*
                         try {
                         //object speichern
                         // Fehlerbehandlung
                         Database.deleteObject(o);

                         //ÜbersichtsTabelle aktualisieren
                         refreshImageOverviewTable(textImageSearch
                         .getText());

                         //Detailansicht leeren
                         textImageID.setText("");
                         textImageFName.setText("");
                         textImageLName.setText("");

                         //in Tabelle nächsten auswählen
                         try {
                         tableImageOverview.select(0);
                         } catch (Exception ex) {
                         }

                         //Statusline Nachricht sezten
                         statusLine
                         .setStatus(
                         1,
                         l
                         .getString("images.groupdetail.deletebutton.newok"));

                         } catch (DataBaseException e) {
                         if (e.getMessage().equalsIgnoreCase("1")) {
                         //Fehler beim Speichern des Objectes

                         statusLine
                         .setStatus(
                         3,
                         l
                         .getString("images.groupdetail.deletebutton.errorsave"));
                         showMsg(
                         l
                         .getString("images.groupdetail.deletebutton.errorsave"),
                         l.getString("error"),
                         SWT.ICON_ERROR | SWT.OK);

                         } else if (e.getMessage().equalsIgnoreCase("2")) {
                         //fehler beim db aufbau
                         statusLine
                         .setStatus(
                         3,
                         l
                         .getString("images.groupdetail.deletebutton.errordb"));
                         showMsg(
                         l
                         .getString("images.groupdetail.deletebutton.errordb"),
                         l.getString("error"),
                         SWT.ICON_ERROR | SWT.OK);

                         } else {
                         //@todo
                         e.printStackTrace();
                         }

                         }
                         */

                    }
                });
            }
            {
                buttonImageFill = new Button(compositeButtons, SWT.PUSH
                        | SWT.CENTER);
                GridData buttonActorFillLData = new GridData();
                buttonImageFill.setVisible(false);
                buttonImageFill.setEnabled(false);
                buttonActorFillLData.widthHint = 30;
                buttonActorFillLData.heightHint = 23;
                buttonImageFill.setLayoutData(buttonActorFillLData);
            }
            {
                buttonImageSave = new Button(compositeButtons, SWT.PUSH
                        | SWT.CENTER);
                buttonImageSave.setText(l.getString("button.save"));
                buttonImageSave.setEnabled(false);
                buttonImageSave.addSelectionListener(new SelectionAdapter() {
                    public void widgetSelected(SelectionEvent evt) {
                        logger.warn("buttonImageSave.widgetSelected, event="
                                + evt);

                        if (scaledImage == null) {
                            statusLine
                                    .setStatus(
                                            StatusLineStyledText.STATUS_WARN,
                                            l
                                                    .getString("images.groupdetail.savebutton.warnnoimage"));
                            return;
                        }

                        //testen ob Name leer ist
                        if (textImagesName.getText().trim()
                                .equalsIgnoreCase("")
                                || textImagesDescription.getText().trim()
                                        .equalsIgnoreCase("")) {

                            showMsg(
                                    l
                                            .getString("images.groupdetail.savebutton.warn.noname.msg"),
                                    l
                                            .getString("images.groupdetail.savebutton.warn.noname.title"),
                                    SWT.ICON_WARNING | SWT.YES);

                            return;
                        }

                        //testen welcher mode

                        if (mode_image == ManagementGui.MODE_ADD) {

                            /**
                             * @todo eine Exception bekommen wieder leider NOCH nicht mit
                             * d.h. es muss noch ein rückgabewert kommen oder eine Exception 
                             * übermitteln werden (aus der DB Klasse)
                             */
                            //neues Objekt erzeugen
                            de.hsharz.provirent.objects.Image tmp = new de.hsharz.provirent.objects.Image();
                            tmp.setImageFileName(textImagesName.getText());
                            tmp.setImageFileDescription(textImagesDescription
                                    .getText());

                            ImageLoader imageLoader = new ImageLoader();
                            imageLoader.data = new ImageData[] { scaledImage
                                    .getImageData() };
                            ByteArrayOutputStream bos = new ByteArrayOutputStream();
                            imageLoader.save(bos, SWT.IMAGE_GIF);

                            tmp.setImageFile(bos.toByteArray());

                            try {
                                bos.close();
                            } catch (IOException e1) {
                                logger
                                        .warn(
                                                "Fehler beim schließen des BytearrayOutputstream",
                                                e1);
                            }

                            try {
                                //object speichern
                                // Fehlerbehandlung
                                Object o = Database.saveObject(tmp);

                                // in Übersichtstabelle einfügen
                                insertIntoImagesOverviewTable((de.hsharz.provirent.objects.Image) o);
                                textImagesID
                                        .setText(((de.hsharz.provirent.objects.Image) o)
                                                .getImageId()
                                                + "");

                                //Statusline Nachricht sezten
                                statusLine
                                        .setStatus(
                                                StatusLineStyledText.STATUS_INFO,
                                                l
                                                        .getString("images.groupdetail.savebutton.newok"));

                            } catch (DataBaseException e) {
                                if (e.getMessage().equalsIgnoreCase("1")) {
                                    //Fehler beim Speichern des Objectes

                                    statusLine
                                            .setStatus(
                                                    3,
                                                    l
                                                            .getString("images.groupdetail.savebutton.errorsave"));
                                    showMsg(
                                            l
                                                    .getString("images.groupdetail.savebutton.errorsave"),
                                            "Fehler", SWT.ICON_ERROR | SWT.OK);

                                } else if (e.getMessage().equalsIgnoreCase("2")) {
                                    //fehler beim db aufbau
                                    statusLine
                                            .setStatus(
                                                    3,
                                                    l
                                                            .getString("images.groupdetail.savebutton.errordb"));
                                    showMsg(
                                            l
                                                    .getString("images.groupdetail.savebutton.errordb"),
                                            "Fehler", SWT.ICON_ERROR | SWT.OK);

                                } else {
                                    //@todo
                                    e.printStackTrace();
                                }

                            }

                            //alle Buttons auf aktiv setzen
                            //setImagesGroupButtonSaveCancel();

                        } else if (mode_image == ManagementGui.MODE_EDIT) {
                            /*
                             Actor tmp = new Actor(
                             textImageFName.getText(),
                             textImageLName.getText());
                             tmp.setActorId(new Integer(Integer
                             .parseInt(textImageID.getText())));
                             try {
                             //object speichern
                             // Fehlerbehandlung
                             Database.saveObject(tmp);
                             //Übersichtstabelle aktualisieren
                             refreshImageOverviewTable(textImageSearch
                             .getText());

                             //Statusline Nachricht sezten
                             statusLine
                             .setStatus(
                             1,
                             l
                             .getString("images.groupdetail.savebutton.editok"));

                             } catch (DataBaseException e) {
                             if (e.getMessage().equalsIgnoreCase("1")) {
                             //Fehler beim Speichern des Objectes

                             statusLine
                             .setStatus(
                             3,
                             l
                             .getString("images.groupdetail.savebutton.errorsave"));
                             showMsg(
                             l
                             .getString("images.groupdetail.savebutton.errorsave"),
                             "Fehler",
                             SWT.ICON_ERROR | SWT.OK);

                             } else if (e.getMessage().equalsIgnoreCase(
                             "2")) {
                             //fehler beim db aufbau
                             statusLine
                             .setStatus(
                             3,
                             l
                             .getString("images.groupdetail.savebutton.errordb"));
                             showMsg(
                             l
                             .getString("images.groupdetail.savebutton.errordb"),
                             "Fehler",
                             SWT.ICON_ERROR | SWT.OK);

                             } else {
                             //@todo
                             e.printStackTrace();
                             }

                             }

                             //alle Buttons auf aktiv setzen
                             setImageGroupButtonSaveCancel();

                             }
                             */
                            /**
                             * @todo Exception werfen, da nur die zwei Modes sein dürfen
                             */
                        }
                    }
                });
            }
            {
                buttonImageCancel = new Button(compositeButtons, SWT.PUSH
                        | SWT.CENTER);
                buttonImageCancel.setText(l.getString("button.cancel"));
                buttonImageCancel.setEnabled(false);
                buttonImageCancel.addSelectionListener(new SelectionAdapter() {
                    public void widgetSelected(SelectionEvent evt) {
                        System.out
                                .println("buttonImageCancel.widgetSelected, event="
                                        + evt);
                        //setImageGroupButtonSaveCancel();
                    }
                });
            }
        }

        // buttons for detail
    }

    void resizeScrollBars() {
        // Set the max and thumb for the image canvas scroll bars.
        ScrollBar horizontal = canvasImg.getHorizontalBar();
        ScrollBar vertical = canvasImg.getVerticalBar();
        Rectangle canvasBounds = canvasImg.getClientArea();
        int width = Math.round(scaledImage.getImageData().width);
        if (width > canvasBounds.width) {
            // The image is wider than the canvas.
            horizontal.setEnabled(true);
            horizontal.setMaximum(width);
            horizontal.setThumb(canvasBounds.width);
            horizontal.setPageIncrement(canvasBounds.width);
        } else {
            // The canvas is wider than the image.
            horizontal.setEnabled(false);

            canvasImg.redraw();
        }
        int height = Math.round(scaledImage.getImageData().height);
        if (height > canvasBounds.height) {
            // The image is taller than the canvas.
            vertical.setEnabled(true);
            vertical.setMaximum(height);
            vertical.setThumb(canvasBounds.height);
            vertical.setPageIncrement(canvasBounds.height);
        } else {
            // The canvas is taller than the image.
            vertical.setEnabled(false);
            canvasImg.redraw();

        }
    }

    void scrollHorizontally(ScrollBar scrollBar) {
        if (scaledImage == null)
            return;
        Rectangle canvasBounds = canvasImg.getClientArea();
        int width = Math.round(scaledImage.getImageData().width);
        int height = Math.round(scaledImage.getImageData().height);
        if (width > canvasBounds.width) {
            // Only scroll if the image is bigger than the canvas.
            int x = -scrollBar.getSelection();
            if (x + width < canvasBounds.width) {
                // Don't scroll past the end of the image.
                x = canvasBounds.width - width;
            }
            canvasImg.scroll(x, iy, ix, iy, width, height, false);
            ix = x;

        }
    }

    void scrollVertically(ScrollBar scrollBar) {
        if (scaledImage == null)
            return;
        Rectangle canvasBounds = canvasImg.getClientArea();
        int width = Math.round(scaledImage.getImageData().width);
        int height = Math.round(scaledImage.getImageData().height);
        if (height > canvasBounds.height) {
            // Only scroll if the image is bigger than the canvas.
            int y = -scrollBar.getSelection();
            if (y + height < canvasBounds.height) {
                // Don't scroll past the end of the image.
                y = canvasBounds.height - height;
            }
            canvasImg.scroll(ix, y, ix, iy, width, height, false);
            iy = y;
        }
    }

    // Reset the scroll bars to 0.
    void resetScrollBars() {
        if (scaledImage == null)
            return;
        ix = 0;
        iy = 0;
        resizeScrollBars();
        canvasImg.getHorizontalBar().setSelection(0);
        canvasImg.getVerticalBar().setSelection(0);

    }

    void paintImage(PaintEvent event) {
        Image paintImage = scaledImage;

        int w = Math.round(scaledImage.getImageData().width);
        int h = Math.round(scaledImage.getImageData().height);
        event.gc.drawImage(paintImage, 0, 0, scaledImage.getImageData().width,
                scaledImage.getImageData().height, ix
                        + scaledImage.getImageData().x, iy
                        + scaledImage.getImageData().y, w, h);
    }

    /**
     * @param text
     */
    private void refreshImagesDetail(final String id) {
        de.hsharz.provirent.objects.Image object = null;
        try {
            //since we only can get a String value from the table, we
            //need to convert this
            object = (de.hsharz.provirent.objects.Image) Database
                    .getSingleObject(new de.hsharz.provirent.objects.Image()
                            .getClass(), Integer.parseInt(id));

            if (object == null) {
                logger.error("Es wurde null von der Datenbank zurückgegeben");
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

        textImagesID.setText(object.getImageId() + "");
        textImagesName.setText(object.getImageFileName());
        textImagesDescription.setText(object.getImageFileDescription());
        
        textFileUrl.setText(l
                .getString("images.groupdetail.labelselecteddatabase"));
        
        if (object.getImageFile() != null && object.getImageFile().length > 0) {
            System.out.println("Versuche zu zeichnen");
            scaledImage = ideaImage = new Image(getDisplay(),
                    new ByteArrayInputStream(object.getImageFile()));
            canvasImg.redraw();
        }else{
            statusLine.setStatus(StatusLineStyledText.STATUS_WARN,"Bilddaten können für Bild "+ object.getImageFileName() +"nicht geladen werden.");
            scaledImage = ideaImage = null;
            canvasImg.redraw();
        }

        canvasImg.redraw();

        //Buttons zum löschen und editieren aktivieren

        //Mode auf view setzen
        mode_image = ManagementGui.MODE_VIEW;

    }

    /**
     * 
     */

    protected void insertIntoImagesOverviewTable(
            final de.hsharz.provirent.objects.Image image) {
        TableItem item = new TableItem(tableImagesOverview, SWT.NONE);
        item.setText(new String[] { image.getImageId() + "",
                image.getImageFileName(), image.getImageFileDescription() });
        if (image.getImageFile() != null && image.getImageFile().length > 0) {
            item.setImage(0, new Image(getDisplay(), new ByteArrayInputStream(
                    image.getImageFile())));
        }

    }

    protected void refreshImageOverviewTable(final String filter) {

        if (tableImagesOverview == null) {
            logger
                    .error("Konnte ImagesOverviewtable nicht refreshen, da diese null ist!");
            return;
        }
        logger.debug("Versuche nun ImagesOverviewtable zu refreshen. Filter: "
                + filter);
        tableImagesOverview.removeAll();
        TableItem item;
        java.util.List Imagelist = Database.getImages(filter);

        for (int i = 0; i < Imagelist.size(); i++) {

            de.hsharz.provirent.objects.Image o = (de.hsharz.provirent.objects.Image) Imagelist
                    .get(i);
            item = new TableItem(tableImagesOverview, SWT.NONE);
            
            
            if (o.getImageFile() != null && o.getImageFile().length > 0) {
                System.out.println("id"+o.getImageId()+" byte:"+o.getImageFile().toString());
                
            
                item.setImage(0, createThumbnailImage(o.getImageFile()));
            }            
            
            item.setText(new String[] { o.getImageId() + "",
                    o.getImageFileName(), o.getImageFileDescription() });

        }
    }
    
    private Image createThumbnailImage(byte[] data){
        
        int maxheight = 75;
        int maxwidth = 75;

        final Image image = new Image(getDisplay(),new ByteArrayInputStream(data));
        final int width = image.getBounds().width;
        final int height = image.getBounds().height;
        float scalefactor = 1;
        
        if (width > maxwidth) {
            scalefactor = (float)maxwidth/width;
        }
        if (height > maxheight) {
            if ( ((float)maxheight/height)< scalefactor ){
                scalefactor = ((float)maxheight/height);
            }
            
        }
        
        final Image scaledtemp = new Image(getDisplay(),
                image.getImageData().scaledTo((int)(width*scalefactor),(int)(height*scalefactor)));
        

        System.out.println("Größe: "+scaledtemp.getBounds());
        
        
        return scaledtemp;
        
    }
}
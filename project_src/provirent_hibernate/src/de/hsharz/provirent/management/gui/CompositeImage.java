package de.hsharz.provirent.management.gui;

import java.io.ByteArrayOutputStream;
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
import de.hsharz.provirent.persistence.Database;
import org.eclipse.swt.widgets.Slider;
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
public class CompositeImage extends AbstractComposite{

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }


    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(CompositeImage.class);
    
    byte[] imagebytedata;
    private final static int MODE_VIEW = 0;
    private final static int MODE_ADD = 1;
    private Label label2;
    private Scale scale1;
    private Canvas canvas1;
    private Text text1;
    private Button button1;
    private Label label1;
    private final static int MODE_EDIT = 2;
    
    private Table tableActorsOverview;
    private TableColumn tableActorsOverview_ColumnID;
    private TableColumn tableActorsOverview_ColumnFName;
    private TableColumn tableActorsOverview_ColumnLName;
    
    
    private SashForm sashForm1;
    private SashForm sashForm2;
    
    private Group groupActor;
    private Group groupActorsOverview;
    private Group groupActorsDetail;
    
    private Text textActorsSearch;
    private Text textActorsID;
    private Text textActorsFName;
    private Text textActorsLName;
    
    private Label labelActorsSearch;
    private Label labelActorsID;
    private Label labelActorsFName;
    private Label labelActorsLName;

    protected int mode_actor;
    
    private Image ideaImage,scaledImage;
    int iy,ix = 0;
    
    private StatusLineStyledText statusLine;

    private ResourceBundle l;
    
    private Composite parent;

    private String currentDir = "C:/";
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
                "de.hsharz.provirent.management.gui.language.actors", locale);

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

		CompositeImage p = new CompositeImage(shell,SWT.NONE,null,Locale.getDefault());
		
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public CompositeImage(Composite p, int style,
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
		{
		}
        if (logger.isDebugEnabled()) {
            logger.debug("initGUI() - start");
        }

        this.setLayout(new GridLayout());
        this.setSize(816, 540);
        {
            groupActor = new Group(this, SWT.NONE);
            GridLayout groupActorLayout = new GridLayout();
            GridData groupActorLData = new GridData();
            groupActorLData.grabExcessHorizontalSpace = true;
            groupActorLData.grabExcessVerticalSpace = true;
            groupActorLData.horizontalAlignment = GridData.FILL;
            groupActorLData.verticalAlignment = GridData.FILL;
            groupActor.setLayoutData(groupActorLData);
            groupActorLayout.makeColumnsEqualWidth = true;
            groupActor.setLayout(groupActorLayout);
            groupActor.setText(l.getString("actors.group.label"));
            {
                sashForm2 = new SashForm(groupActor, SWT.NONE);
                GridData sashForm2LData = new GridData();
                sashForm2LData.verticalAlignment = GridData.FILL;
                sashForm2LData.horizontalAlignment = GridData.FILL;
                sashForm2LData.grabExcessHorizontalSpace = true;
                sashForm2LData.grabExcessVerticalSpace = true;
                sashForm2.setLayoutData(sashForm2LData);
                
               
            }
            // init the rest of the layout
            initActorsOverview();
            initActorsDetail();
            refreshActorsOverviewTable(textActorsSearch.getText());
        }

        this.layout();


        
        if (logger.isDebugEnabled()) {
            logger.debug("initGUI() - end");
        }
	}

	
	private void initActorsOverview()  {	    
//	  Group Actors Overview 
        {
            groupActorsOverview = new Group(sashForm2,SWT.NONE);
            GridLayout group1Layout = new GridLayout();
            group1Layout.numColumns = 8;
            groupActorsOverview.setLayout(group1Layout);
            groupActorsOverview.setText(l.getString("actors.groupoverview.label"));
            
            {// table Actors Overview
                tableActorsOverview = new Table(
                    groupActorsOverview,
                    SWT.SINGLE
                        | SWT.FULL_SELECTION
                        | SWT.V_SCROLL | SWT.BORDER);
                GridData tableActorsOverviewLData = new GridData();
                tableActorsOverview.setHeaderVisible(true);
                tableActorsOverview.setLinesVisible(true);
                tableActorsOverviewLData.horizontalAlignment = GridData.FILL;
                tableActorsOverviewLData.verticalAlignment = GridData.FILL;
                tableActorsOverviewLData.horizontalSpan = 8;
                tableActorsOverviewLData.grabExcessHorizontalSpace = true;
                tableActorsOverviewLData.grabExcessVerticalSpace = true;
                tableActorsOverview.setLayoutData(tableActorsOverviewLData);
                tableActorsOverview.addFocusListener(new FocusAdapter() {
                        public void focusLost(FocusEvent evt) {
                            System.out
                                .println("tableActorsOverview.focusLost, event="
                                    + evt);
                        }
                        public void focusGained(FocusEvent evt) {
                            System.out
                                .println("tableActorsOverview.focusGained, event="
                                    + evt);
                        }
                    });
                tableActorsOverview.addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {
                            if (logger.isDebugEnabled()) {
                                logger
                                    .debug("widgetSelected(SelectionEvent evt = "
                                        + evt
                                        + ") - start");
                            }

                            int index = tableActorsOverview
                                .getSelectionIndex();

                            System.out.println("Table select. id: "
                                + index
                                + " TableItem:"
                                + tableActorsOverview.getItem(index)
                                + " id: "
                                + tableActorsOverview.getItem(index)
                                    .getText(0));

                            //es wurde ein Element aus Tabelle ausgewaehlt jetzt muss die
                            //Detailansicht aktualisiert werden
                            refreshActorsDetail(tableActorsOverview.getItem(index)
                                                              .getText(0));

                            if (logger.isDebugEnabled()) {
                                logger
                                    .debug("widgetSelected(SelectionEvent) - end");
                            }
                        }
                    });
                {
                    tableActorsOverview_ColumnID = new TableColumn(
                        tableActorsOverview,
                        SWT.CENTER);
                    tableActorsOverview_ColumnID.setText(l
                        .getString("actors.groupoverview.columnid"));
                    tableActorsOverview_ColumnID.setWidth(40);
                }
                {
                    tableActorsOverview_ColumnFName = new TableColumn(
                        tableActorsOverview,
                        SWT.CENTER);
                    tableActorsOverview_ColumnFName.setText(l
                        .getString("actors.groupoverview.columnfirstname"));
                    tableActorsOverview_ColumnFName.setWidth(80);
                }
                {
                    tableActorsOverview_ColumnLName = new TableColumn(
                        tableActorsOverview,
                        SWT.CENTER);
                    tableActorsOverview_ColumnLName.setText(l
                        .getString("actors.groupoverview.columnlastname"));
                    tableActorsOverview_ColumnLName.setWidth(80);
                }
            }
            // table Actors Overview
            // Search
            {
                //label for Search
                labelActorsSearch = new Label(groupActorsOverview, SWT.NONE);
                labelActorsSearch.setText(l
                        .getString("actors.groupoverview.searchlabel")
                        + ":");
                GridData label2LData = new GridData();
                label2LData.horizontalSpan = 3;
                labelActorsSearch.setLayoutData(label2LData);

                //text Search
                textActorsSearch = new Text(groupActorsOverview, SWT.BORDER);
                GridData text2LData = new GridData();
                textActorsSearch.addFocusListener(new FocusAdapter() {
                    public void focusLost(FocusEvent evt) {
                        if (logger.isDebugEnabled()) {
                            logger.debug("focusLost(FocusEvent evt = " + evt + " "
                                    + textActorsSearch.getText() + ") - start");
                        }

                        refreshActorsOverviewTable(textActorsSearch.getText());

                        if (logger.isDebugEnabled()) {
                            logger.debug("focusLost(FocusEvent) - end");
                        }
                    }
                });
                textActorsSearch.addListener(SWT.DefaultSelection, new Listener() {
                    public void handleEvent(Event e) {
                        if (logger.isDebugEnabled()) {
                            logger.debug("handleEvent(Event e = " + e + " "
                                    + textActorsSearch.getText() + ") - start");
                        }

                        refreshActorsOverviewTable(textActorsSearch.getText());

                        if (logger.isDebugEnabled()) {
                            logger.debug("handleEvent(Event) - end");
                        }
                    }
                });
                text2LData.horizontalAlignment = GridData.FILL;
                text2LData.horizontalSpan = 5;
                text2LData.grabExcessHorizontalSpace = true;
                textActorsSearch.setLayoutData(text2LData);
            }// Search                    
        }
	}
	
	private void initActorsDetail()  {	    
	    // Group Actors Detail
        {
            groupActorsDetail = new Group(sashForm2, SWT.NONE);
            GridLayout group2Layout = new GridLayout();
            GridData group2LData = new GridData();
            group2Layout.verticalSpacing = 15;
            group2Layout.numColumns = 6;
            groupActorsDetail.setText(l.getString("actors.groupdetail.label"));   
            FormData formData = new FormData();
            groupActorsDetail.setLayout(group2Layout);
            formData.right = new FormAttachment(100, 100, -5);
            formData.top = new FormAttachment(0, 100, 5);
            formData.bottom = new FormAttachment(100, 100, -5);
            groupActorsDetail.setLayoutData(formData);
        }
        	// labels and buttons for detail
        	{
        	    labelActorsID = new Label(groupActorsDetail, SWT.NONE);
        	    labelActorsID.setText(l
        	            .getString("actors.groupdetail.labelid")
        	            + ":");
        	    labelActorsID.setSize(125, 15);
        	    GridData formData2 = new GridData();
        	    formData2.widthHint = 125;
        	    formData2.heightHint = 15;
        	    formData2.horizontalSpan = 2;
        	    labelActorsID.setLayoutData(formData2);
        	}
        	{
        	    textActorsID = new Text(
        	            groupActorsDetail,
        	            SWT.READ_ONLY | SWT.BORDER);
        	    GridData text1LData1 = new GridData();
        	    text1LData1.horizontalAlignment = GridData.FILL;
        	    text1LData1.heightHint = 13;
        	    text1LData1.horizontalSpan = 4;
        	    text1LData1.grabExcessHorizontalSpace = true;
        	    textActorsID.setLayoutData(text1LData1);
        	}
        	{
                labelActorsFName = new Label(
                    groupActorsDetail,
                    SWT.NONE);
                labelActorsFName.setText(l
                    .getString("actors.groupdetail.labelfirstname")
                    + ":");
                labelActorsFName.setSize(125, 15);
                GridData labelActorNameLData = new GridData();
                labelActorNameLData.widthHint = 125;
                labelActorNameLData.heightHint = 15;
                labelActorNameLData.horizontalSpan = 2;
                labelActorsFName
                    .setLayoutData(labelActorNameLData);
            }
            {
        	    textActorsFName = new Text(groupActorsDetail,
        	            SWT.READ_ONLY | SWT.BORDER);
        	    GridData text1LData2 = new GridData();
        	    text1LData2.horizontalAlignment = GridData.FILL;
        	    text1LData2.heightHint = 13;
        	    text1LData2.horizontalSpan = 4;
        	    text1LData2.grabExcessHorizontalSpace = true;
        	    textActorsFName.setLayoutData(text1LData2);
        	}
            {
        	    labelActorsLName = new Label(groupActorsDetail,
        	            SWT.NONE);
        	    labelActorsLName.setText(l
        	            .getString("actors.groupdetail.labellastname")
        	            + ":");
        	    labelActorsLName.setSize(125, 15);
        	    GridData label1LData1 = new GridData();
        	    label1LData1.widthHint = 125;
        	    label1LData1.heightHint = 15;
        	    label1LData1.horizontalSpan = 2;
        	    labelActorsLName.setLayoutData(label1LData1);
        	}
        	{
        	    textActorsLName = new Text(groupActorsDetail,
        	            SWT.READ_ONLY | SWT.BORDER);
        	    GridData text1LData3 = new GridData();
        	    text1LData3.horizontalAlignment = GridData.FILL;
        	    text1LData3.heightHint = 13;
        	    text1LData3.horizontalSpan = 4;
        	    text1LData3.grabExcessHorizontalSpace = true;
        	    textActorsLName.setLayoutData(text1LData3);
        	}// label and buttons for detail      
            {
                label1 = new Label(groupActorsDetail, SWT.NONE);
                label1.setText(l.getString("actors.groupdetail.labellastname")
                    + ":");
                label1.setSize(125, 15);
                GridData label1LData = new GridData();
                label1LData.widthHint = 125;
                label1LData.heightHint = 15;
                label1LData.horizontalSpan = 2;
                label1.setLayoutData(label1LData);
            }
            {
                text1 = new Text(groupActorsDetail, SWT.NONE);
                text1.setText("text1");
                text1.setEditable(false);
                GridData text1LData = new GridData();
                text1LData.widthHint = 105;
                text1LData.heightHint = 15;
                text1LData.horizontalSpan = 2;
                text1.setLayoutData(text1LData);
            }
            {
                button1 = new Button(groupActorsDetail, SWT.PUSH | SWT.CENTER);
                button1.setText("Datei");
                GridData button1LData = new GridData();
                button1.addSelectionListener(new SelectionAdapter() {
                    public void widgetSelected(SelectionEvent evt) {
                        String[] filterExtensions = { "*.gif", "*.jpg", "*.*" };
                        FileDialog fileDialog = new FileDialog(
                            getShell(),
                            SWT.OPEN);
                        fileDialog.setText("FileDialog Demo");
                        fileDialog.setFilterPath("C:/");

                        fileDialog.setFilterExtensions(filterExtensions);
                        String selectedFile = fileDialog.open();
                        if (selectedFile != null) {
                            scaledImage = ideaImage = new Image(
                                getDisplay(),
                                selectedFile);
                            canvas1.redraw();
                            text1.setText(fileDialog.getFileName());
                            scale1.setEnabled(true);
                            resetScrollBars();
                            resizeScrollBars();
                        }
                    }
                });
                button1LData.horizontalAlignment = GridData.FILL;
                button1LData.grabExcessHorizontalSpace = true;
                button1LData.horizontalSpan = 2;
                button1.setLayoutData(button1LData);

                canvas1 = new Canvas(groupActorsDetail, SWT.NO_REDRAW_RESIZE
                    | SWT.H_SCROLL
                    | SWT.V_SCROLL
                    | SWT.BORDER);
                GridData canvas1LData = new GridData();
                canvas1LData.grabExcessHorizontalSpace = true;
                canvas1LData.horizontalAlignment = GridData.FILL;
                canvas1LData.horizontalSpan = 6;
                canvas1LData.grabExcessVerticalSpace = true;
                canvas1LData.verticalAlignment = GridData.FILL;
                canvas1.setLayoutData(canvas1LData);
                canvas1.addPaintListener(new PaintListener() {
                    public void paintControl(PaintEvent e) {
                        if (ideaImage != null && !ideaImage.isDisposed()) {
                            paintImage(e);
                            //e.gc.drawImage(scaledImage, 0, 0);
                        }
                    }
                });

                // Set up the image canvas scroll bars.
                ScrollBar horizontal = canvas1.getHorizontalBar();
                horizontal.setVisible(true);
                horizontal.setMinimum(0);
                horizontal.setEnabled(false);
                horizontal.addSelectionListener(new SelectionAdapter() {
                    public void widgetSelected(SelectionEvent event) {
                        scrollHorizontally((ScrollBar)event.widget);
                    }
                });
                ScrollBar vertical = canvas1.getVerticalBar();
                vertical.setVisible(true);
                vertical.setMinimum(0);
                vertical.setEnabled(false);
                vertical.addSelectionListener(new SelectionAdapter() {
                    public void widgetSelected(SelectionEvent event) {
                        scrollVertically((ScrollBar)event.widget);
                    }
                });

            }
            {
                label2 = new Label(groupActorsDetail, SWT.NONE);
                label2.setText(l.getString("actors.groupdetail.labellastname")
                    + ":");
                label2.setSize(125, 15);
                GridData label2LData1 = new GridData();
                label2LData1.widthHint = 125;
                label2LData1.heightHint = 15;
                label2LData1.horizontalSpan = 2;
                label2.setLayoutData(label2LData1);
            }
            {
                scale1 = new Scale(groupActorsDetail, SWT.NONE);
                GridData scale1LData = new GridData();
                scale1.setEnabled(false);
                scale1.addSelectionListener(new SelectionAdapter() {
                    public void widgetSelected(SelectionEvent evt) {
                        //System.out.println("scale1.widgetSelected, event="
                        //    + evt);

                        float scaleFaktor = (float) scale1.getSelection() / 100;
                        int newwidth = (int) (ideaImage.getBounds().width * scaleFaktor);
                        int newheight = (int) (ideaImage.getBounds().height * scaleFaktor);

                        ImageData newdata = ideaImage.getImageData().scaledTo(
                            newwidth,
                            newheight);

                        scaledImage = new Image(getDisplay(), newdata);
                        canvas1.redraw();

                        ImageLoader imageLoader = new ImageLoader();
                        imageLoader.data = new ImageData[] { newdata };
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        imageLoader.save(bos, SWT.IMAGE_GIF);

                        imagebytedata = bos.toByteArray();
                        resizeScrollBars();
                    }
                });
                scale1LData.grabExcessHorizontalSpace = true;
                scale1LData.horizontalAlignment = GridData.FILL;
                scale1LData.horizontalSpan = 4;
                scale1.setLayoutData(scale1LData);
                scale1.setMaximum(100);
                scale1.setMinimum(0);
                scale1.setIncrement(10);
                scale1.setSelection(100);

            }

        	// buttons for detail
	}

	void resizeScrollBars() {
		// Set the max and thumb for the image canvas scroll bars.
		ScrollBar horizontal = canvas1.getHorizontalBar();
		ScrollBar vertical = canvas1.getVerticalBar();
		Rectangle canvasBounds = canvas1.getClientArea();
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

			canvas1.redraw();
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
				canvas1.redraw();
			
		}
	}
	
	
	void scrollHorizontally(ScrollBar scrollBar) {
		if (scaledImage == null) return;
		Rectangle canvasBounds = canvas1.getClientArea();
		int width = Math.round(scaledImage.getImageData().width );
		int height = Math.round(scaledImage.getImageData().height );
		if (width > canvasBounds.width) {
			// Only scroll if the image is bigger than the canvas.
			int x = -scrollBar.getSelection();
			if (x + width < canvasBounds.width) {
				// Don't scroll past the end of the image.
				x = canvasBounds.width - width;
			}
			canvas1.scroll(x, iy, ix, iy, width, height, false);
			ix = x;
			
		}
	}
	
	void scrollVertically(ScrollBar scrollBar) {
		if (scaledImage == null) return;
		Rectangle canvasBounds = canvas1.getClientArea();
		int width = Math.round(scaledImage.getImageData().width);
		int height = Math.round(scaledImage.getImageData().height);
		if (height > canvasBounds.height) {
			// Only scroll if the image is bigger than the canvas.
			int y = -scrollBar.getSelection();
			if (y + height < canvasBounds.height) {
				// Don't scroll past the end of the image.
				y = canvasBounds.height - height;
			}
			canvas1.scroll(ix, y, ix, iy, width, height, false);
			iy = y;
		}
	}	
	
	// Reset the scroll bars to 0.
	void resetScrollBars() {
		if (scaledImage == null) return;
		ix = 0; iy = 0;
		resizeScrollBars();
		canvas1.getHorizontalBar().setSelection(0);
		canvas1.getVerticalBar().setSelection(0);
		
	}
	
	
	void paintImage(PaintEvent event) {
		Image paintImage = scaledImage;

		int w = Math.round(scaledImage.getImageData().width);
		int h = Math.round(scaledImage.getImageData().height);
		event.gc.drawImage(
			paintImage,
			0,
			0,
			scaledImage.getImageData().width,
			scaledImage.getImageData().height,
			ix + scaledImage.getImageData().x,
			iy + scaledImage.getImageData().y,
			w,
			h);
	}


	
	/**
     * @param text
     */
    private void refreshActorsDetail(final String id) {
        Actor object;
        try {
            //since we only can get a String value from the table, we
            //need to convert this
            object = Database.getSingleActor(Integer.parseInt(id));

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

        textActorsID.setText(object.getActorId() + "");
        textActorsFName.setText(object.getFirstName());
        textActorsLName.setText(object.getLastName());

        //Buttons zum löschen und editieren aktivieren

        //Mode auf view setzen
        mode_actor = ManagementGui.MODE_VIEW;
        
    }

    /**
     * 
     */

    protected void insertIntoActorsOverviewTable(Actor actor) {
        TableItem item = new TableItem(tableActorsOverview, SWT.NONE);
        item.setText(new String[] { actor.getActorId() + "", actor.getFirstName(),
                actor.getLastName() });        
    }
    
    protected void refreshActorsOverviewTable(final String filter) {
        /*
        if (tableActorsOverview == null) {
            System.out
                    .println("Konnte ActorsOverviewtable nicht refreshen, da diese null ist!");
            return;
        }
        System.out.println("Versuche nun ActorsOverviewtable zu refreshen. Filter: "
                + filter);
        tableActorsOverview.removeAll();
        TableItem item;
        java.util.List Actorlist = Database.getActor(filter);

        for (int i = 0; i < Actorlist.size(); i++) {

            Actor o = (Actor) Actorlist.get(i);
            item = new TableItem(tableActorsOverview, SWT.NONE);
            item.setText(new String[] { o.getActorId() + "", o.getFirstName(),
                    o.getLastName() });

        }
        */
    }
}

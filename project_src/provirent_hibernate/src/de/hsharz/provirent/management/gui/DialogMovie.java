package de.hsharz.provirent.management.gui;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import de.hsharz.provirent.objects.Actor;
import de.hsharz.provirent.objects.Director;
import de.hsharz.provirent.objects.Genre;
import de.hsharz.provirent.objects.Image;
import de.hsharz.provirent.objects.Movie;
import de.hsharz.provirent.persistence.Database;

public class DialogMovie extends org.eclipse.swt.widgets.Dialog {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(DialogMovie.class);

    public final static int TYPE_GENRE = 1;

    public final static int TYPE_IMAGE = 2;

    public final static int TYPE_ACTOR = 3;

    public final static int TYPE_DIRECTOR = 4;

    public final static int TYPE_MAINIMAGE = 5;
    
    private int type = 0;

    private Shell dialogShell;

    private Group groupDialogDescription;

    private Button buttonDescriptionAbort;

    private Button buttonDescriptionAccept;

    private Label labelDescriptionAdvice;

    private Button button1;

    private Table table1;

    private Button button2;

    private Text text1;

    private Movie movie;

    private List valuelist;

    private ResourceBundle l;

    private Shell shell;
    
    private int size_width = 200;
    private int size_height = 210;
    private int start_x = 50;
    private int start_y = 50;

    /**
     * Auto-generated main method to display this org.eclipse.swt.widgets.Dialog
     * inside a new Shell.
     */
    public static void main(String[] args) {

        try {

            Display display = Display.getDefault();
            Movie film = new Movie();
            film.setActors(new ArrayList());
            film.setImages(new ArrayList());
            film.setGenres(new ArrayList());
            film.setDirector(new ArrayList());

            Shell shell = new Shell(display);
            DialogMovie inst = new DialogMovie(shell, SWT.NULL, Locale.GERMAN,
                    film, TYPE_ACTOR);
            inst.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
    private void initLanguage(Locale locale) {
        l = PropertyResourceBundle.getBundle(
                "de.hsharz.provirent.management.gui.language.movies", locale);

    }

    public DialogMovie(Shell parent, int style, Locale locale, Movie movie,
            int type) {
        super(parent, style);
        shell = parent;

        this.movie = movie;
        initLanguage(locale);
        this.type = type;
    }

    public DialogMovie(Shell parent, int style, Locale locale, Movie movie,
            int type, int x, int y, int width, int height) {
        super(parent, style);
        shell = parent;
        this.movie = movie;
        initLanguage(locale);
        this.type = type;
        start_x = x;
        start_y = y;
        size_height = height;
        size_width = width;
    }
    
    
    public void open() {

        Shell parent = getParent();
        dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
        dialogShell.setSize(size_width, size_height);
        dialogShell.setBounds(start_x,start_y,size_width,size_height);
        dialogShell.setLayout(new GridLayout());

        groupDialogDescription = new Group(dialogShell, SWT.NONE);
        GridLayout groupDialogDescriptionLayout = new GridLayout();
        groupDialogDescriptionLayout.numColumns = 5;
        groupDialogDescriptionLayout.makeColumnsEqualWidth = true;

        groupDialogDescription.setLayout(groupDialogDescriptionLayout);

        if (type == TYPE_ACTOR) {
            groupDialogDescription.setText(l
                    .getString("movies.dialog.title.actor"));
        } else if (type == TYPE_DIRECTOR) {
            groupDialogDescription.setText(l
                    .getString("movies.dialog.title.director"));
        } else if (type == TYPE_GENRE) {
            groupDialogDescription.setText(l
                    .getString("movies.dialog.title.genre"));
        } else if (type == TYPE_IMAGE) {
            groupDialogDescription.setText(l
                    .getString("movies.dialog.title.image"));
        }
        else if (type == TYPE_MAINIMAGE) {
            groupDialogDescription.setText(l
                    .getString("movies.dialog.title.mainimage"));
        }
        
        GridData groupForm1LData = new GridData();
        groupForm1LData.widthHint = 300;
        groupForm1LData.heightHint = 200;
        groupDialogDescription.setLayoutData(groupForm1LData);

        text1 = new Text(groupDialogDescription, SWT.BORDER);
        text1.setToolTipText(l.getString("movies.dialog.search.tooltip"));

        GridData text1LData = new GridData();
        text1LData.horizontalSpan = 4;
        text1LData.horizontalAlignment = GridData.FILL;
        text1LData.grabExcessHorizontalSpace = true;
        text1.setLayoutData(text1LData);

        {
            button1 = new Button(groupDialogDescription, SWT.PUSH | SWT.CENTER);
            button1.setText(l.getString("movies.dialog.search.buttonname"));

            button1.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent evt) {
                    refreshList(text1.getText());
                }
            });
        }
        {
            labelDescriptionAdvice = new Label(groupDialogDescription, SWT.NONE);

            if (type == TYPE_ACTOR) {
                labelDescriptionAdvice.setText(l
                        .getString("movies.dialog.labeltable.actor"));
            } else if (type == TYPE_DIRECTOR) {
                labelDescriptionAdvice.setText(l
                        .getString("movies.dialog.labeltable.director"));
            } else if (type == TYPE_GENRE) {
                labelDescriptionAdvice.setText(l
                        .getString("movies.dialog.labeltable.genre"));
            } else if (type == TYPE_IMAGE) {
                labelDescriptionAdvice.setText(l
                        .getString("movies.dialog.labeltable.image"));
            } else if  (type == TYPE_MAINIMAGE) {
                labelDescriptionAdvice.setText(l
                        .getString("movies.dialog.labeltable.mainimage"));
            }
            
            
            table1 = new Table(groupDialogDescription, SWT.SINGLE
                    | SWT.FULL_SELECTION);
            GridData table1LData = new GridData();
            table1LData.horizontalAlignment = GridData.FILL;
            table1LData.horizontalSpan = 5;
            table1LData.grabExcessHorizontalSpace = true;
            table1LData.verticalAlignment = GridData.FILL;
            table1LData.grabExcessVerticalSpace = true;
            table1.setLayoutData(table1LData);
            table1.setLinesVisible(true);
            table1.setHeaderVisible(true);
            {
                TableColumn item = new TableColumn(table1, SWT.CENTER);
                item.setText(l.getString("movies.dialog.column.id"));
                item.setWidth(0);
                item.setResizable(false);
            }

            if (type == TYPE_IMAGE || type == TYPE_MAINIMAGE) {
                TableColumn item = new TableColumn(table1, SWT.CENTER);
                item.setAlignment(SWT.LEFT);
                item.setWidth(100);
                item.setText(l.getString("movies.dialog.column.thumb.image"));
            }

            {
                TableColumn item = new TableColumn(table1, SWT.CENTER);
                item.setAlignment(SWT.LEFT);
                item.setWidth(100);

                if (type == TYPE_ACTOR) {
                    item.setText(l
                            .getString("movies.dialog.column.lastname.actor"));
                } else if (type == TYPE_DIRECTOR) {
                    item
                            .setText(l
                                    .getString("movies.dialog.column.lastname.director"));
                } else if (type == TYPE_GENRE) {
                    item
                            .setText(l
                                    .getString("movies.dialog.column.name.genre"));
                } else if (type == TYPE_IMAGE || type == TYPE_MAINIMAGE) {
                    item
                            .setText(l
                                    .getString("movies.dialog.column.name.image"));
                }

            }
            {
                TableColumn item = new TableColumn(table1, SWT.CENTER);
                item.setAlignment(SWT.LEFT);
                item.setWidth(100);
                if (type == TYPE_ACTOR) {
                    item.setText(l
                            .getString("movies.dialog.column.firstname.actor"));
                } else if (type == TYPE_DIRECTOR) {
                    item
                            .setText(l
                                    .getString("movies.dialog.column.firstname.director"));
                } else if (type == TYPE_GENRE) {
                    item.setText(l
                            .getString("movies.dialog.column.shortname.genre"));
                } else if (type == TYPE_IMAGE || type == TYPE_MAINIMAGE) {
                    item
                            .setText(l
                                    .getString("movies.dialog.column.description.image"));
                    item.setWidth(150);
                }
            }

            buttonDescriptionAccept = new Button(groupDialogDescription,
                    SWT.PUSH | SWT.CENTER);
            if(type == TYPE_MAINIMAGE)  {            
                buttonDescriptionAccept.setText(l
                        .getString("movies.dialog.buttonadd.mainimage"));
            } else  {
                buttonDescriptionAccept.setText(l
                        .getString("movies.dialog.buttonadd"));
            }                
            GridData buttonDescriptionAcceptLData2 = new GridData();
            buttonDescriptionAcceptLData2.horizontalSpan = 2;
            buttonDescriptionAcceptLData2.horizontalAlignment = GridData.FILL;
            buttonDescriptionAccept
                    .setLayoutData(buttonDescriptionAcceptLData2);

            buttonDescriptionAccept
                    .addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {

                            int[] sel = table1.getSelectionIndices();
                            for (int i = 0; i < sel.length; i++) {


                                for (int j = 0; j < valuelist.size(); j++) {
                                    if (type == TYPE_ACTOR) {
                                        if ((table1.getItem(sel[i]).getText(0))
                                                .equalsIgnoreCase(((Actor) valuelist
                                                        .get(j)).getActorId()
                                                        + "")) {
                                            movie.getActors().add(
                                                    (Actor) valuelist.get(j));
                                            break;
                                        }
                                    } else if (type == TYPE_DIRECTOR) {
                                        if ((table1.getItem(sel[i]).getText(0))
                                                .equalsIgnoreCase(((Director) valuelist
                                                        .get(j))
                                                        .getDirectorId()
                                                        + "")) {
                                            movie
                                                    .getDirector()
                                                    .add(
                                                            (Director) valuelist
                                                                    .get(j));
                                            break;
                                        }
                                    } else if (type == TYPE_GENRE) {
                                        if ((table1.getItem(sel[i]).getText(0))
                                                .equalsIgnoreCase(((Genre) valuelist
                                                        .get(j)).getGenreId()
                                                        + "")) {
                                            movie.getGenres().add(
                                                    (Genre) valuelist.get(j));
                                            break;
                                        }
                                    } else if (type == TYPE_IMAGE) {
                                        if ((table1.getItem(sel[i]).getText(0))
                                                .equalsIgnoreCase(((Image) valuelist
                                                        .get(j)).getImageId()
                                                        + "")) {

                                            movie.getImages().add(
                                                    (Image) valuelist.get(j));
                                            break;
                                        }
                                    } else if (type == TYPE_MAINIMAGE)  {
                                        if ((table1.getItem(sel[i]).getText(0))
                                                .equalsIgnoreCase(((Image) valuelist
                                                        .get(j)).getImageId()
                                                        + "")) {
    
                                            movie.setMainImage((Image) valuelist.get(j));
                                            dialogShell.close();
                                        }
                                    }
                                }

                                table1.remove(sel[i]);
                            }

                        }
                    });

        }
        {
            button2 = new Button(groupDialogDescription, SWT.FLAT | SWT.CENTER);
            button2.setEnabled(false);
            button2.setVisible(false);
        }

        buttonDescriptionAbort = new Button(groupDialogDescription, SWT.PUSH
                | SWT.CENTER);
        buttonDescriptionAbort.setText(l
                .getString("movies.dialog.buttonfinish"));
        GridData buttonDescriptionAbortLData = new GridData();
        buttonDescriptionAbortLData.horizontalAlignment = GridData.FILL;
        buttonDescriptionAbortLData.horizontalSpan = 2;
        buttonDescriptionAbort.setLayoutData(buttonDescriptionAbortLData);
        buttonDescriptionAbort.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                dialogShell.close();
            }
        });

        //Liste füllen
        refreshList("");
        
        dialogShell.layout();
        dialogShell.pack();
        dialogShell.open();
        Display display = dialogShell.getDisplay();
        while (!dialogShell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }

    }

    private void refreshList(final String filter) {
        if (table1 == null || table1.isDisposed()) {
            logger
                    .warn("Konnte DialogMovie List nicht refreshen, da diese null ist!");
            return;
        }
        table1.removeAll();
        table1.clearAll();
        if (type == TYPE_ACTOR) {
            valuelist = Database.getActorExcept(filter, this.movie.getActors());
            for (int i = 0; i < valuelist.size(); i++) {
                Actor o = (Actor) valuelist.get(i);
                TableItem item = new TableItem(table1, SWT.NONE);
                item.setText(new String[] { o.getActorId() + "",
                        o.getLastName(), o.getFirstName() });
            }
        } else if (type == TYPE_DIRECTOR) {
            valuelist = Database.getDirectorExcept(filter, this.movie
                    .getDirector());
            for (int i = 0; i < valuelist.size(); i++) {
                Director o = (Director) valuelist.get(i);
                TableItem item = new TableItem(table1, SWT.NONE);
                item.setText(new String[] { o.getDirectorId() + "",
                        o.getLastName(), o.getFirstName() });
            }
        } else if (type == TYPE_GENRE) {
            valuelist = Database.getGenreExcept(filter, this.movie.getGenres());
            for (int i = 0; i < valuelist.size(); i++) {
                Genre o = (Genre) valuelist.get(i);
                TableItem item = new TableItem(table1, SWT.NONE);
                item.setText(new String[] { o.getGenreId() + "", o.getName(),
                        o.getShortname() });
            }
        } else if (type == TYPE_IMAGE || type == TYPE_MAINIMAGE) {
            valuelist = Database
                    .getImagesExcept(filter, this.movie.getImages());
            for (int i = 0; i < valuelist.size(); i++) {
                Image o = (Image) valuelist.get(i);
                TableItem item = new TableItem(table1, SWT.NONE);

                //Scale the image
                int maxheight = 75;
                int maxwidth = 75;

                final org.eclipse.swt.graphics.Image image = new org.eclipse.swt.graphics.Image(
                        shell.getDisplay(), new ByteArrayInputStream(o
                                .getImageFile()));
                final int width = image.getBounds().width;
                final int height = image.getBounds().height;
                float scalefactor = 1;

                if (width > maxwidth) {
                    scalefactor = (float) maxwidth / width;
                }
                if (height > maxheight) {
                    if (((float) maxheight / height) < scalefactor) {
                        scalefactor = ((float) maxheight / height);
                    }

                }

                final org.eclipse.swt.graphics.Image scaledtemp = new org.eclipse.swt.graphics.Image(
                        shell.getDisplay(), image.getImageData().scaledTo(
                                (int) (width * scalefactor),
                                (int) (height * scalefactor)));

                item.setImage(1, scaledtemp);
                item.setText(new String[] { o.getImageId() + "", "",
                        o.getImageFileName(), o.getImageFileDescription() });

                //image.dispose();
                //scaledtemp.dispose();

            }
        }

    }
}
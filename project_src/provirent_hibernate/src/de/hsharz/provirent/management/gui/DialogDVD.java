package de.hsharz.provirent.management.gui;

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

import de.hsharz.provirent.objects.AudioFormat;
import de.hsharz.provirent.objects.Dvd;
import de.hsharz.provirent.objects.Language;
import de.hsharz.provirent.objects.Subtitle;
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
public class DialogDVD extends org.eclipse.swt.widgets.Dialog {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(DialogMovie.class);

    public final static int TYPE_LANGUAGE = 1;

    public final static int TYPE_SUBTITLE = 2;

    public final static int TYPE_VIDEOFORMAT = 3;

    public final static int TYPE_AUDIOFORMAT = 4;
    
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

    private Dvd dvd;

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
            Dvd dvd = new Dvd();
            dvd.setLanguages(new ArrayList());
            dvd.setSubtitles(new ArrayList());
            dvd.setVideoFormats(new ArrayList());
            dvd.setAudioFormats(new ArrayList());

            Shell shell = new Shell(display);
            DialogDVD inst = new DialogDVD(shell, SWT.NULL, Locale.GERMAN,
                    dvd, TYPE_LANGUAGE);
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
                "de.hsharz.provirent.management.gui.language.dvds", locale);

    }

    public DialogDVD(Shell parent, int style, Locale locale, Dvd dvd,
            int type) {
        super(parent, style);
        shell = parent;

        this.dvd = dvd;
        initLanguage(locale);
        this.type = type;
    }

    public DialogDVD(Shell parent, int style, Locale locale, Dvd dvd,
            int type, int x, int y, int width, int height) {
        super(parent, style);
        shell = parent;
        this.dvd = dvd;
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

        if (type == TYPE_LANGUAGE) {
            groupDialogDescription.setText(l
                    .getString("dvd.dialog.title.language"));
        } else if (type == TYPE_SUBTITLE) {
            groupDialogDescription.setText(l
                    .getString("dvd.dialog.title.subtitle"));
        } else if (type == TYPE_VIDEOFORMAT) {
            groupDialogDescription.setText(l
                    .getString("dvd.dialog.title.videoformat"));
        } else if (type == TYPE_AUDIOFORMAT) {
            groupDialogDescription.setText(l
                    .getString("dvd.dialog.title.audioformat"));
        }
        
        GridData groupForm1LData = new GridData();
        groupForm1LData.widthHint = 300;
        groupForm1LData.heightHint = 200;
        groupDialogDescription.setLayoutData(groupForm1LData);

        text1 = new Text(groupDialogDescription, SWT.BORDER);
        text1.setToolTipText(l.getString("dvd.dialog.search.tooltip"));

        GridData text1LData = new GridData();
        text1LData.horizontalSpan = 4;
        text1LData.horizontalAlignment = GridData.FILL;
        text1LData.grabExcessHorizontalSpace = true;
        text1.setLayoutData(text1LData);

        {
            button1 = new Button(groupDialogDescription, SWT.PUSH | SWT.CENTER);
            button1.setText(l.getString("dvd.dialog.search.buttonname"));

            button1.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent evt) {
                    refreshList(text1.getText());
                }
            });
        }
        {
            labelDescriptionAdvice = new Label(groupDialogDescription, SWT.NONE);

            if (type == TYPE_LANGUAGE) {
                labelDescriptionAdvice.setText(l
                        .getString("dvd.dialog.labeltable.language"));
            } else if (type == TYPE_SUBTITLE) {
                labelDescriptionAdvice.setText(l
                        .getString("dvd.dialog.labeltable.subtitle"));
            } else if (type == TYPE_VIDEOFORMAT) {
                labelDescriptionAdvice.setText(l
                        .getString("dvd.dialog.labeltable.videoformat"));
            } else if (type == TYPE_AUDIOFORMAT) {
                labelDescriptionAdvice.setText(l
                        .getString("dvd.dialog.labeltable.audioformat"));
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
                item.setText(l.getString("dvd.dialog.column.id"));
                item.setWidth(0);
                item.setResizable(false);
            }
            {
                TableColumn item = new TableColumn(table1, SWT.CENTER);
                item.setAlignment(SWT.LEFT);
                item.setWidth(100);

                if (type == TYPE_LANGUAGE) {
                    item.setText(l
                            .getString("dvd.dialog.column.language"));
                } else if (type == TYPE_SUBTITLE) {
                    item.setText(l
                             .getString("dvd.dialog.column.subtitle"));
                } else if (type == TYPE_VIDEOFORMAT) {
                    item.setText(l
                             .getString("dvd.dialog.column.videoformat"));
                } else if (type == TYPE_AUDIOFORMAT) {
                    item.setText(l
                             .getString("dvd.dialog.column.audioformat"));
                }

            }
            {
                TableColumn item = new TableColumn(table1, SWT.CENTER);
                item.setAlignment(SWT.LEFT);
                item.setWidth(100);
                item.setText(l
                            .getString("dvd.dialog.column.short"));
                    item.setWidth(150);
            }
            
            buttonDescriptionAccept = new Button(groupDialogDescription,
                    SWT.PUSH | SWT.CENTER);
            buttonDescriptionAccept.setText(l
                        .getString("dvd.dialog.buttonadd"));                
            GridData buttonDescriptionAcceptLData2 = new GridData();
            buttonDescriptionAcceptLData2.horizontalSpan = 2;
            buttonDescriptionAcceptLData2.horizontalAlignment = GridData.FILL;
            buttonDescriptionAccept
                    .setLayoutData(buttonDescriptionAcceptLData2);

            buttonDescriptionAccept.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                            int[] sel = table1.getSelectionIndices();
                            for (int i = 0; i < sel.length; i++) {
                                for (int j = 0; j < valuelist.size(); j++) {
                                    if (type == TYPE_LANGUAGE) {
                                        if ((table1.getItem(sel[i]).getText(0))
                                                .equalsIgnoreCase(((Language) valuelist
                                                        .get(j)).getLanguageId()
                                                        + "")) {
                                            dvd.getLanguages().add(
                                                    (Language) valuelist.get(j));
                                            break;
                                        }
                                    } else if (type == TYPE_SUBTITLE) {
                                        if ((table1.getItem(sel[i]).getText(0))
                                                .equalsIgnoreCase(((Subtitle) valuelist
                                                        .get(j))
                                                        .getSubtitleId()
                                                        + "")) {
                                            dvd.getSubtitles().add(
                                                     (Subtitle) valuelist.get(j));
                                            break;
                                        }
                                    } else if (type == TYPE_VIDEOFORMAT) {
                                        if ((table1.getItem(sel[i]).getText(0))
                                                .equalsIgnoreCase(((VideoFormat) valuelist
                                                        .get(j)).getVideoFormatId()
                                                        + "")) {
                                            dvd.getVideoFormats().add(
                                                    (VideoFormat) valuelist.get(j));
                                            break;
                                        }
                                    } else if (type == TYPE_AUDIOFORMAT) {
                                        if ((table1.getItem(sel[i]).getText(0))
                                                .equalsIgnoreCase(((AudioFormat) valuelist
                                                        .get(j)).getAudioFormatId()
                                                        + "")) {

                                            dvd.getAudioFormats().add(
                                                    (AudioFormat) valuelist.get(j));
                                            break;
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
                .getString("dvd.dialog.buttonfinish"));
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
            logger.warn("Konnte DialogDVD List nicht refreshen, da diese null ist!");
            return;
        }
        table1.removeAll();
        table1.clearAll();
        if (type == TYPE_LANGUAGE) {
            valuelist = Database.getLanguageExcept(filter, this.dvd.getLanguages());
            for (int i = 0; i < valuelist.size(); i++) {
                Language o = (Language) valuelist.get(i);
                TableItem item = new TableItem(table1, SWT.NONE);
                item.setText(new String[] { o.getLanguageId() + "",
                        o.getName(), o.getShortname() });
            }
        } else if (type == TYPE_SUBTITLE) {
            valuelist = Database.getSubtitleExcept(filter, this.dvd
                    .getSubtitles());
            for (int i = 0; i < valuelist.size(); i++) {
                Subtitle o = (Subtitle) valuelist.get(i);
                TableItem item = new TableItem(table1, SWT.NONE);
                item.setText(new String[] { o.getSubtitleId() + "",
                        o.getName(), o.getShortname() });
            }
        } else if (type == TYPE_VIDEOFORMAT) {
            valuelist = Database.getVideoformatExcept(filter, this.dvd.getVideoFormats());
            for (int i = 0; i < valuelist.size(); i++) {
                VideoFormat o = (VideoFormat) valuelist.get(i);
                TableItem item = new TableItem(table1, SWT.NONE);
                item.setText(new String[] { o.getVideoFormatId() + "", o.getName(),
                        o.getShortname() });
            }
       } else if (type == TYPE_AUDIOFORMAT) {
           valuelist = Database.getAudioformatExcept(filter, this.dvd.getAudioFormats());
           for (int i = 0; i < valuelist.size(); i++) {
               AudioFormat o = (AudioFormat) valuelist.get(i);
               TableItem item = new TableItem(table1, SWT.NONE);
               item.setText(new String[] { o.getAudioFormatId() + "", o.getName(),
                    o.getShortname() });
           }
       } 
    }
}
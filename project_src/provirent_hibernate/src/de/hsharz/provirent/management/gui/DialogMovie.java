package de.hsharz.provirent.management.gui;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

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
import de.hsharz.provirent.objects.Movie;
import de.hsharz.provirent.persistence.Database;
public class DialogMovie extends org.eclipse.swt.widgets.Dialog {
    
    public final static int TYPE_GENRE = 1;
    public final static int TYPE_IMAGE = 2;
    public final static int TYPE_ACTOR = 3;
    public final static int TYPE_DIRECTOR = 4;
    
	private Shell dialogShell;
    
	private Group groupDialogDescription;
	
	private Button buttonDescriptionAbort;
	private Button buttonDescriptionAccept;
	
	private Label labelDescriptionAdvice;

	private Button button1;
	private Table table1 ;
	private Button button2;
	private Text text1;

	private Movie movie ;
	private List valuelist;

	private ResourceBundle l;
	
	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
	public static void main(String[] args) {

		try {


			Display display = Display.getDefault();
			Movie film = new Movie();
			film.setActors(new ArrayList());
			Shell shell = new Shell(display);
			DialogMovie inst = new DialogMovie(shell, SWT.NULL, Locale.GERMAN,film);
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
     * @see de.hsharz.provirent.managment.gui.AbstractComposite#initLanguage(java.util.Locale)
     */
    private void initLanguage(Locale locale) {
        l = PropertyResourceBundle.getBundle(
                "de.hsharz.provirent.management.gui.language.movies", locale);

    }
	
	
    
	public DialogMovie(Shell parent, int style, Locale locale, Movie movie) {
		super(parent, style);
		this.movie = movie;
		initLanguage(locale);
	}


	
	private void open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			dialogShell.setSize(200,210);
			dialogShell.setLayout(new GridLayout());
            {

                    groupDialogDescription = new Group(dialogShell, SWT.NONE);
                    GridLayout groupDialogDescriptionLayout = new GridLayout();
                    groupDialogDescriptionLayout.numColumns = 5;
                    groupDialogDescriptionLayout.makeColumnsEqualWidth = true;
                    groupDialogDescription.setBounds(0, 0, 316, 178);
                    groupDialogDescription.setLayout(groupDialogDescriptionLayout);
                    groupDialogDescription.setText("Schauspieler");
                    
                    GridData groupForm1LData = new GridData();
                    groupForm1LData.widthHint = 300;
                    groupForm1LData.heightHint = 200;
                    groupDialogDescription.setLayoutData(groupForm1LData);                    

                    
                    {
                        text1 = new Text(groupDialogDescription, SWT.BORDER);
                        text1.setText("");
                        text1.setToolTipText("Geben Sie hier einen Suchbegriff ein");
                        GridData text1LData = new GridData();
                        text1LData.horizontalSpan = 4;
                        text1LData.horizontalAlignment = GridData.FILL;
                        text1LData.grabExcessHorizontalSpace = true;
                        text1.setLayoutData(text1LData);
                       
                        
                    }
                    {
                        button1 = new Button(groupDialogDescription, SWT.PUSH
                            | SWT.CENTER);
                        button1.setText("Suchen");
                        button1.addSelectionListener(new SelectionAdapter() {
                            public void widgetSelected(SelectionEvent evt) {
                                refreshActorsList(text1.getText());
                                
                               
                            }
                        });                         
                    }
                    {
                        labelDescriptionAdvice = new Label(groupDialogDescription, SWT.NONE);
                        labelDescriptionAdvice.setText("Beschreibung ins Textfeld schreiben oder ändern");
        
                    }
                    {
                        table1 =  new Table(groupDialogDescription, SWT.MULTI | SWT.FULL_SELECTION);
                        GridData table1LData = new GridData();
                        table1LData.horizontalAlignment = GridData.FILL;
                        table1LData.horizontalSpan = 5;
                        table1LData.grabExcessHorizontalSpace = true;
                        table1LData.verticalAlignment = GridData.FILL;
                        table1LData.grabExcessVerticalSpace = true;
                        table1.setLayoutData(table1LData);
                        {
                            TableColumn item = new TableColumn(
                                    table1,
                                SWT.CENTER);
                            item.setText("id");
                            item.setWidth(0);
                            item.setResizable(false);
                        }                        
                        {
                            TableColumn item = new TableColumn(
                                    table1,
                                SWT.CENTER);
                            item.setText("nachname");
                            item.setAlignment(SWT.LEFT);
                            item.setWidth(100);
                            
                        }                        
                        {
                            TableColumn item = new TableColumn(
                                    table1,
                                SWT.CENTER);
                            item.setText("Vorname");
                            item.setAlignment(SWT.LEFT);
                            item.setWidth(100);
                            
                        }                        
                        
                        
                    }
                    {
                        buttonDescriptionAccept = new Button(groupDialogDescription, SWT.PUSH | SWT.CENTER);
                        buttonDescriptionAccept.setText("Hinzufügen");
                        GridData buttonDescriptionAcceptLData2 = new GridData();
                        buttonDescriptionAcceptLData2.horizontalSpan = 2;
                        buttonDescriptionAcceptLData2.horizontalAlignment = GridData.FILL;
                        buttonDescriptionAccept.setLayoutData(buttonDescriptionAcceptLData2);
                        
            			{
                            buttonDescriptionAccept
                                .addSelectionListener(new SelectionAdapter() {
                                public void widgetSelected(SelectionEvent evt) {
                                    System.out
                                        .println("buttonDescriptionAccept.widgetSelected, event="
                                            + evt);
                                    
                                    int[] sel = table1.getSelectionIndices();
                                    for (int i = 0; i < sel.length; i++) {
                                        System.out.println("Auswahl:"+i+" "+table1.getItem(sel[i]));
                                        
                                        System.out.println("ID: "+table1.getItem(sel[i]).getText(0));
                                        for (int j = 0; j < valuelist.size(); j++) {
                                            System.out.println("Listid:"+((Actor)valuelist.get(j)).getActorId()+"");
                                            if ( (table1.getItem(sel[i]).getText(0)).equalsIgnoreCase(((Actor)valuelist.get(j)).getActorId()+"") ){
                                                System.out.println("gefunden");
                                                movie.getActors().add((Actor)valuelist.get(j));
                                            }
                                        }
                                        //movie.getActors().add()
                                        table1.remove(sel[i]);
                                    }
                                    
                                    //TODO add your code for buttonDescriptionAccept.widgetSelected
                                }
                                });
            			}                        
                        
                    }
                    {
                        button2 = new Button(groupDialogDescription, SWT.FLAT | SWT.CENTER);
                        button2.setEnabled(false);
                        button2.setVisible(false);
                    }
                    {
                        buttonDescriptionAbort = new Button(groupDialogDescription, SWT.PUSH | SWT.CENTER);
                        buttonDescriptionAbort.setText("Fertig");
                        GridData buttonDescriptionAbortLData = new GridData();
                        buttonDescriptionAbortLData.horizontalAlignment = GridData.FILL;
                        buttonDescriptionAbortLData.horizontalSpan = 2;
                        buttonDescriptionAbort.setLayoutData(buttonDescriptionAbortLData);
                        buttonDescriptionAbort.addSelectionListener(new SelectionAdapter() {
                            public void widgetSelected(SelectionEvent evt) {
                               // TODO
                               dialogShell.close();
                            }
                        });  
                    }

            }
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	  private void refreshActorsList(final String filter) {
	        if (table1 == null || table1.isDisposed()) {
	            System.out
	                    .println("Konnte DialogMovie List nicht refreshen, da diese null ist!");
	            return;
	        }
	        System.out.println("Versuche nun DialogMovie List zu refreshen. Filter: "
	                + filter);
	        table1.removeAll();
	        
	        valuelist = Database.getActorExcept(filter, this.movie.getActors());

	        for (int i = 0; i < valuelist.size(); i++) {
	            Actor o = (Actor)valuelist.get(i);
	            TableItem item = new TableItem(table1, SWT.NONE);
	            item.setText(new String[] {o.getActorId()+"",o.getLastName(), o.getFirstName() });
	        }
	  }
}

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

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;



public class DialogDescription extends org.eclipse.swt.widgets.Dialog {
    
	private Shell dialogShell;
    
	private Group groupDialogDescription;
	
	private Button buttonDescriptionAbort;
	private Button buttonDescriptionAccept;
	
	private Label labelDescriptionAdvice;
	
	private StyledText styledTextDescritpion;
	
	private SashForm sashForm1;

	private ResourceBundle l;
	
	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
	public static void main(String[] args) {
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			DialogDescription inst = new DialogDescription(shell, SWT.NULL, Locale.GERMAN);
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
    public void initLanguage(Locale locale) {
        l = PropertyResourceBundle.getBundle(
                "de.hsharz.provirent.management.gui.language.dialogmovies", locale);

    }
	
	
    
	public DialogDescription(Shell parent, int style, Locale locale) {
		super(parent, style);
		
		initLanguage(locale);
	}


	
	public void open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

			dialogShell.setLayout(new GridLayout());
            {
                sashForm1 = new SashForm(dialogShell, SWT.NONE);
                GridData sashForm1LData = new GridData();
                sashForm1LData.widthHint = 300;
                sashForm1LData.heightHint = 200;
                sashForm1.setLayoutData(sashForm1LData);
                {
                    groupDialogDescription = new Group(sashForm1, SWT.NONE);
                    GridLayout groupDialogDescriptionLayout = new GridLayout();
                    groupDialogDescriptionLayout.numColumns = 5;
                    groupDialogDescriptionLayout.makeColumnsEqualWidth = true;
                    groupDialogDescription.setBounds(0, 0, 316, 178);
                    groupDialogDescription.setLayout(groupDialogDescriptionLayout);
                    groupDialogDescription.setText("Beschreibung");
                    {
                        labelDescriptionAdvice = new Label(groupDialogDescription, SWT.NONE);
                        labelDescriptionAdvice.setText("Beschreibung ins Textfeld schreiben oder ändern");
        
                    }
                    {
                        styledTextDescritpion = new StyledText(groupDialogDescription, SWT.NONE);
                        styledTextDescritpion.setText("");
                        GridData styledTextDescritpionLData = new GridData();
                        styledTextDescritpionLData.horizontalSpan = 5;
                        styledTextDescritpionLData.horizontalAlignment = GridData.FILL;
                        styledTextDescritpionLData.verticalAlignment = GridData.FILL;
                        styledTextDescritpionLData.verticalSpan = 3;
                        styledTextDescritpionLData.grabExcessHorizontalSpace = true;
                        styledTextDescritpionLData.grabExcessVerticalSpace = true;
                        styledTextDescritpion.setLayoutData(styledTextDescritpionLData);
                    }
                    {
                        buttonDescriptionAccept = new Button(groupDialogDescription, SWT.PUSH | SWT.CENTER);
                        buttonDescriptionAccept.setText("Übernehmen");
                        GridData buttonDescriptionAcceptLData2 = new GridData();
                        buttonDescriptionAcceptLData2.horizontalSpan = 2;
                        buttonDescriptionAcceptLData2.grabExcessHorizontalSpace = true;
                        buttonDescriptionAcceptLData2.horizontalAlignment = GridData.FILL;
                        buttonDescriptionAccept.setLayoutData(buttonDescriptionAcceptLData2);
                    }
                    {
                        buttonDescriptionAbort = new Button(groupDialogDescription, SWT.PUSH | SWT.CENTER);
                        buttonDescriptionAbort.setText("Abbruch");
                        GridData buttonDescriptionAbortLData = new GridData();
                        buttonDescriptionAbortLData.grabExcessHorizontalSpace = true;
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
	
}

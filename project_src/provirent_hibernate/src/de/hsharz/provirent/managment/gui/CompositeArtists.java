package de.hsharz.provirent.managment.gui;

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


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
public class CompositeArtists extends AbstractComposite{

    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(CompositeArtists.class);
    
    
    private final static int MODE_VIEW = 0;

    private final static int MODE_ADD = 1;

    private final static int MODE_EDIT = 2;
    
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
                "de.hsharz.provirent.managment.gui.language.artists", locale);

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

	public CompositeArtists(Composite p, int style,
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
		try {
			this.setLayout(new GridLayout());
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package de.hsharz.provirent.management.gui;

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.cloudgarden.resource.SWTResourceManager;
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
public class CompositeDirectors extends AbstractComposite{

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }


    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(CompositeDirectors.class);
    
    
    private final static int MODE_VIEW = 0;

    private final static int MODE_ADD = 1;
    private Text text1;
    private Group groupDirector;

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
                "de.hsharz.provirent.management.gui.language.directors", locale);

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

	public CompositeDirectors(Composite p, int style,
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
            groupDirector = new Group(this, SWT.NONE);
            GridLayout groupDirectorLayout = new GridLayout();
            GridData groupDirectorLData = new GridData();
            groupDirectorLData.grabExcessHorizontalSpace = true;
            groupDirectorLData.grabExcessVerticalSpace = true;
            groupDirectorLData.horizontalAlignment = GridData.FILL;
            groupDirectorLData.verticalAlignment = GridData.FILL;
            groupDirector.setLayoutData(groupDirectorLData);
            groupDirectorLayout.makeColumnsEqualWidth = true;
            groupDirector.setLayout(groupDirectorLayout);
            groupDirector.setText("Director");
            {
                text1 = new Text(groupDirector, SWT.MULTI | SWT.WRAP);
                text1.setText("text1");
                GridData text1LData = new GridData();
                text1.setBackground(SWTResourceManager.getColor(0, 255, 0));
                text1LData.widthHint = 227;
                text1LData.heightHint = 132;
                text1.setLayoutData(text1LData);
            }
        }

        this.layout();


        
        if (logger.isDebugEnabled()) {
            logger.debug("initGUI() - end");
        }
	}

	

}

package de.hsharz.provirent.managment.gui;

import java.util.Locale;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridLayout;


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
abstract public class AbstractComposite extends org.eclipse.swt.widgets.Composite {

    abstract public void changeLanguage(Locale l);
    abstract public void setStatusLine(StatusLineStyledText status);


	public AbstractComposite(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
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

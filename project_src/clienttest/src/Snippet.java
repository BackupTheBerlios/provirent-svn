/*
 */
import org.eclipse.swt.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
/**
 * @author Philipp Schneider
 *
 */
public class Snippet {

    public static void main(String[] args) {
    	Display display = new Display();
    	Shell shell = new Shell(display);
    	
    	shell.setLayout(new FillLayout());
    	CTabFolder folder = new CTabFolder(shell, SWT.CLOSE);
    	for (int i = 0; i < 4; i++) {
    		CTabItem item = new CTabItem(folder, SWT.NONE);
    		item.setText("Item "+i);
    		Text text = new Text(folder, SWT.BORDER | SWT.MULTI);
    		text.setText("Content for Item "+i);
    		item.setControl(text);
    	}
    	
    	final CTabItem specialItem = new CTabItem(folder, SWT.NONE);
    	specialItem.setText("Don't Close Me");
    	Text text = new Text(folder, SWT.BORDER | SWT.MULTI);
    	text.setText("This tab can never be closed");
    	specialItem.setControl(text);
    		
    	folder.addCTabFolder2Listener(new CTabFolder2Adapter() {
    		public void close(CTabFolderEvent event) {
    			if (event.item.equals(specialItem)) {
    				event.doit = false;
    			}
    		}
    	});
    	shell.setSize(400, 400);
    	shell.open();
    	while (!shell.isDisposed()) {
    		if (!display.readAndDispatch())
    			display.sleep();
    	}
    	display.dispose();
    }
}

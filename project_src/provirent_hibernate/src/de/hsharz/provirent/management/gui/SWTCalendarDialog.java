package de.hsharz.provirent.management.gui;

import java.util.Calendar;import java.util.Date;import org.eclipse.swt.SWT;import org.eclipse.swt.events.SelectionAdapter;import org.eclipse.swt.events.SelectionEvent;import org.eclipse.swt.layout.GridData;import org.eclipse.swt.layout.GridLayout;import org.eclipse.swt.widgets.Button;import org.eclipse.swt.widgets.Display;import org.eclipse.swt.widgets.Shell;import org.vafada.swtcalendar.SWTCalendar;import org.vafada.swtcalendar.SWTCalendarListener;

/*** This code was generated using CloudGarden's Jigloo* SWT/Swing GUI Builder, which is free for non-commercial* use. If Jigloo is being used commercially (ie, by a corporation,* company or business for any purpose whatever) then you* should purchase a license for each developer using Jigloo.* Please visit www.cloudgarden.com for details.* Use of Jigloo implies acceptance of these licensing terms.* ************************************** A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED* for this machine, so Jigloo or this code cannot be used legally* for any corporate or commercial purpose.* **************************************/public class SWTCalendarDialog {
    private Shell shell;
    private SWTCalendar swtcal;
    private Display display;    

    public SWTCalendarDialog(Display display, String finishbut) {
        this.display = display;
        shell = new Shell(display, SWT.APPLICATION_MODAL | SWT.CLOSE);        GridLayout grid = new GridLayout();        grid.numColumns = 1;        shell.setLayout(grid);
        swtcal = new SWTCalendar(shell);        Button finish = new Button(shell, SWT.PUSH                | SWT.CENTER);        finish.setText(finishbut);        GridData text1LData3 = new GridData();
        text1LData3.horizontalAlignment = GridData.FILL;        text1LData3.horizontalSpan = 1;        text1LData3.grabExcessHorizontalSpace = true;        finish.setLayoutData(text1LData3);                finish.addSelectionListener(new SelectionAdapter() {            public void widgetSelected(SelectionEvent evt) {                shell.close();                }});                        }

    public void open() {
        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
    }

    public Calendar getCalendar() {
        return swtcal.getCalendar();
    }

    public void setDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        swtcal.setCalendar(calendar);
    }    public void setCalendar(Calendar cal){        swtcal.setCalendar(cal);    }

    public void addDateChangedListener(SWTCalendarListener listener) {
        swtcal.addSWTCalendarListener(listener);
    }
}

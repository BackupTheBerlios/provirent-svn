package de.hsharz.provirent.management.gui;

import java.text.DateFormat;


    private Shell shell;
    private SWTCalendar swtcal;
    private Display display;

    public SWTCalendarDialog(Display display, String finishbut) {
        this.display = display;
        shell = new Shell(display, SWT.APPLICATION_MODAL | SWT.CLOSE);
        swtcal = new SWTCalendar(shell);
        text1LData3.horizontalAlignment = GridData.FILL;

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
    }

    public void addDateChangedListener(SWTCalendarListener listener) {
        swtcal.addSWTCalendarListener(listener);
    }
}
package de.hsharz.provirent.managment.gui;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabFolder2Adapter;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import de.hsharz.provirent.objects.Director;
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
public class ManagmentGui {
    private Text employeeFilterText;

	private Menu menu1;

	private MenuItem aboutMenuItem;

	private MenuItem viewMenuItem;

	private MenuItem contentsMenuItem;

	private MenuItem viewVideoFormatMenuItem;
	private MenuItem viewDirectorMenuItem;
	private Menu helpMenu;

	private Menu viewMenu;

	private MenuItem helpMenuItem,exitMenuItem,closeFileMenuItem;

	private MenuItem saveFileMenuItem,newFileMenuItem;

	private MenuItem openFileMenuItem;

	private CTabItem tabItem1;

	private CTabFolder tabFolder1;

	private Composite composite2;

	private Group group1, group2, group1Director, group2Director, group1Actor, group2Actor;

	private CTabItem tabItemVideoFormat;

	private CTabItem tabItemLanguage;

	private CTabItem tabItemDVD;

	private CTabItem tabItemGenre;

	private CTabItem tabItemDirector;

	private CTabItem tabItemAudioFormat;

	private CTabItem tabItemActor;

	private TableColumn tableColumnDirectorId,tableColumnDirectorLastname,tableColumnDirectorFirstname;
	private TableColumn tableColumnActorId,tableColumnActorLastname,tableColumnActorFirstname;
	
	private TableColumn tableColumnlastname;

	private TableColumn tableColumnfirstname;

	private TableColumn tableColumnid;

	private Table table1, tableDirector, tableActor;

	private List list2;

	private SashForm sashForm1, sashFormDirector;

	private Menu fileMenu;

	private MenuItem fileMenuItem;

	private Shell shell;

	public ManagmentGui() {
		Display display = Display.getDefault();
		shell = new Shell(display);
		shell.setSize(400, 300);
		shell.setLayout(new FormLayout());


		initGUI();
		refreshList();
		//refreshTable();

		
		
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

	}

	private void refreshDirectorTable(final String filter) {
	    if (tableDirector == null){
	        return;
	    }
	    tableDirector.removeAll();
		TableItem item;
		java.util.List directorlist = Database.getDirectors(filter);
		
		for (int i = 0; i < directorlist.size(); i++) {
		    Director d = (Director)directorlist.get(i);
		    item = new TableItem(tableDirector, SWT.NONE);
			item.setText(new String[] {d.getDirectorId()+"", d.getLastName(), d.getFirstName() });

		}
		
		
		
	}

	private void refreshList() {
		String[] data = new String[] { "1 - Max Meier", "2 - Stefan Forstner",
				"3 - Remo Griesch", "4 - Philipp Schneider" };

		//Load the Employee list
		list2.removeAll();

		for (int i = 0; i < data.length; i++)
			list2.add(data[i]);
	}

	private void initTabFolder() {
		tabFolder1 = new CTabFolder(shell, SWT.NONE);

		//sets the layout
		FormLayout folderLayout = new FormLayout();
		folderLayout.marginHeight = 0;
		folderLayout.marginWidth = 0;
		tabFolder1.setLayout(folderLayout);

		//spec. where the tabfolders should be
		FormData data = new FormData();
		data.top = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, 0);
		data.left = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(100, 0);
		tabFolder1.setLayoutData(data);

		//tabFolder1.setBackground(new Color (null,255,255,4));
		tabFolder1.setBorderVisible(true);
		tabFolder1.setForeground(new Color(null, 255, 255, 255));
		tabFolder1.setSelectionBackground(new Color(null, 55, 205, 205));
		tabFolder1.setSelectionForeground(new Color(null, 55, 55, 55));

		tabFolder1.addCTabFolder2Listener(new CTabFolder2Adapter() {
			public void close(CTabFolderEvent event) {
				System.out.println("Es wurde ein Tab geschlossen: "
						+ event.item);
			}
		});

	}

	private void initTabItemVideoFormat() {
		if (tabFolder1 == null) {
			initTabFolder();
		}

			tabItemVideoFormat = new CTabItem(tabFolder1, SWT.NONE);
			tabItemVideoFormat.setText("VideoFormat");


	}
	
	private void initTabItemLanguage() {
		if (tabFolder1 == null) {
			initTabFolder();
		}

		tabItemLanguage = new CTabItem(tabFolder1, SWT.NONE);
		tabItemLanguage.setText("Sprache");

	}
	
	private void initTabItemGenre() {
		if (tabFolder1 == null) {
			initTabFolder();
		}

		tabItemGenre = new CTabItem(tabFolder1, SWT.NONE);
		tabItemGenre.setText("Genre");

	}	
	
	private void initTabItemDirector() {
		if (tabFolder1 == null) {
			initTabFolder();
		}

		tabItemDirector = new CTabItem(tabFolder1, SWT.NONE);
		tabItemDirector.setText("Director");
		
		
		{
			sashFormDirector = new SashForm(tabFolder1, SWT.NONE);
			FormLayout sashFormDirectorLayout = new FormLayout();
			sashFormDirector.setLayout(sashFormDirectorLayout);
			tabItemDirector.setControl(sashFormDirector);
			{
				group1Director = new Group(sashFormDirector, SWT.NONE);
				group1Director.setText("Directors Übersicht");
				GridLayout gridLayout = new GridLayout();
				gridLayout.numColumns = 6;
				
				group1Director.setLayout(gridLayout);

				FormData formData = new FormData();
				formData.right =  new FormAttachment(100, 100, -5);
				formData.top =  new FormAttachment(0, 100, 5);
				formData.bottom =  new FormAttachment(100, 100, -5);
				group1Director.setLayoutData(formData);

				{
					tableDirector = new Table(group1Director, SWT.V_SCROLL
							| SWT.SINGLE | SWT.FULL_SELECTION
							| SWT.BORDER);
					GridData griddata = new GridData(
							GridData.FILL_BOTH);
					griddata.horizontalSpan = 6;
					griddata.heightHint = 160;
					tableDirector.setLayoutData(griddata);

					tableDirector.setLinesVisible(true);
					tableDirector.setHeaderVisible(true);

					tableDirector
							.addSelectionListener(new SelectionAdapter() {

								public void widgetSelected(
										SelectionEvent arg0) {

									int index = tableDirector
											.getSelectionIndex();
									System.out
											.println("Table select. id: "
													+ index
													+ " TableItem:"
													+ tableDirector
															.getItem(index)
													+ " id: "
													+ tableDirector
															.getItem(
																	index)
															.getText(
																	0));
								}
							});
					ColumnDirectorSelectionListener sortListener = new ColumnDirectorSelectionListener();
					{
						tableColumnDirectorId = new TableColumn(tableDirector,
								SWT.CENTER);
						tableColumnDirectorId.setText("id");
						tableColumnDirectorId.setWidth(100);
						tableColumnDirectorId.addSelectionListener(sortListener);
						
					}
					{
						tableColumnDirectorLastname = new TableColumn(
								tableDirector, SWT.CENTER);
						tableColumnDirectorLastname.setText("Name");
						tableColumnDirectorLastname.setWidth(100);
						tableColumnDirectorLastname.addSelectionListener(sortListener);
					}
					{
						tableColumnDirectorFirstname = new TableColumn(
								tableDirector, SWT.CENTER);
						tableColumnDirectorFirstname.setText("vorname");
						tableColumnDirectorFirstname.setWidth(100);
						tableColumnDirectorFirstname.addSelectionListener(sortListener);
					}

					
					//Filter ######
					Label filterLabel = new Label(group1Director, SWT.NONE);
					filterLabel.setText("Suche nach:");
					employeeFilterText = new Text(group1Director, SWT.BORDER);
					GridData data1 = new GridData();
					data1.horizontalSpan = 2;
					//data1.widthHint = 60;
					filterLabel.setLayoutData(data1);
					//GridData data2 = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
					GridData data2 = new GridData(GridData.FILL_HORIZONTAL);
					data2.horizontalSpan = 4;
					//data2.widthHint = 60;
					employeeFilterText.setLayoutData(data2);

					employeeFilterText.addFocusListener(new FocusAdapter() {
						public void focusLost(FocusEvent arg0) {
							System.out.println("Enter key: " + employeeFilterText.getText());
							refreshDirectorTable(employeeFilterText.getText());
						}
					});

					employeeFilterText.addListener(SWT.DefaultSelection, new Listener() {
						public void handleEvent(Event e) { //check for "enter" key
							System.out.println("Enter key: " + employeeFilterText.getText());
							refreshDirectorTable(employeeFilterText.getText());
							
						}
					});

			
					
				}
			}
			{
				group2Director = new Group(sashFormDirector, SWT.NONE);
				group2Director.setText("Filmliste");

				FormData formData = new FormData();
				formData.top =  new FormAttachment(0, 100, 5);
				formData.left =  new FormAttachment(0, 100, 5);
				formData.bottom =  new FormAttachment(100, 100, -5);
				group2Director.setLayoutData(formData);

				//Composite has a grid layout
				GridLayout gridLayout = new GridLayout();
				gridLayout.numColumns = 2;
				group2Director.setLayout(gridLayout);

				{
					list2 = new List(group2Director, SWT.SINGLE
							| SWT.H_SCROLL | SWT.V_SCROLL
							| SWT.BORDER);
					GridData list2LData = new GridData();
					list2
							.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(
										SelectionEvent evt) {
									System.out
											.println("list1.widgetSelected, event="
													+ evt);
									System.out
											.println("Selected: "
													+ list2
															.getSelectionIndex());

									//TODO add your code for list1.widgetSelected
								}
							});
					list2LData.verticalAlignment = GridData.FILL;
					list2LData.horizontalAlignment = GridData.FILL;
					list2LData.grabExcessHorizontalSpace = true;
					list2LData.grabExcessVerticalSpace = true;
					list2.setLayoutData(list2LData);
				}
			}
		}		
		
		refreshDirectorTable("");

	}	
	
	private void initTabItemAudioFormat() {
		if (tabFolder1 == null) {
			initTabFolder();
		}

		tabItemAudioFormat = new CTabItem(tabFolder1, SWT.NONE);
		tabItemAudioFormat.setText("AudioFormat");

	}	
	private void initTabItemActor(){
		if (tabFolder1 == null) {
			initTabFolder();
		}

		
		tabItemActor = new CTabItem(tabFolder1, SWT.NONE);
		tabItemActor.setText("Darsteller");
	}
	
	
	private void initTabItemMovie(){
		

		tabItem1 = new CTabItem(tabFolder1, SWT.NONE);
		tabItem1.setText("Filme");
		{
			sashForm1 = new SashForm(tabFolder1, SWT.NONE);
			FormLayout sashForm1Layout = new FormLayout();
			sashForm1.setLayout(sashForm1Layout);
			tabItem1.setControl(sashForm1);
			{
				group1 = new Group(sashForm1, SWT.NONE);
				group1.setText("group1");
				GridLayout gridLayout = new GridLayout();
				gridLayout.numColumns = 4;
				group1.setLayout(gridLayout);

				FormData formData = new FormData();
				formData.right = new FormAttachment(100, 100, -5);
				formData.top = new FormAttachment(0, 100, 5);
				formData.bottom = new FormAttachment(100, 100, -5);
				group1.setLayoutData(formData);

				{
					table1 = new Table(group1, SWT.V_SCROLL
							| SWT.SINGLE | SWT.FULL_SELECTION
							| SWT.BORDER);
					GridData griddata = new GridData(
							GridData.FILL_BOTH);
					griddata.horizontalSpan = 4;
					griddata.heightHint = 160;
					table1.setLayoutData(griddata);

					table1.setLinesVisible(true);
					table1.setHeaderVisible(true);

					table1
							.addSelectionListener(new SelectionAdapter() {

								public void widgetSelected(
										SelectionEvent arg0) {

									int index = table1
											.getSelectionIndex();
									System.out
											.println("Table select. id: "
													+ index
													+ " TableItem:"
													+ table1
															.getItem(index)
													+ " id: "
													+ table1
															.getItem(
																	index)
															.getText(
																	0));
								}
							});
					{
						tableColumnid = new TableColumn(table1,
								SWT.CENTER);
						tableColumnid.setText("id");
						tableColumnid.setWidth(100);
					}
					{
						tableColumnfirstname = new TableColumn(
								table1, SWT.CENTER);
						tableColumnfirstname.setText("vorname");
						tableColumnfirstname.setWidth(100);
					}
					{
						tableColumnlastname = new TableColumn(
								table1, SWT.CENTER);
						tableColumnlastname.setText("Name");
						tableColumnlastname.setWidth(100);
					}
					
					//Filter ######
					Label filterLabel = new Label(group1, SWT.NONE);
					filterLabel.setText("Filter:");
					employeeFilterText = new Text(group1, SWT.BORDER);
					GridData data1 = new GridData();
					data1.widthHint = 26;
					filterLabel.setLayoutData(data1);
					GridData data2 = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
					data2.widthHint = 48;
					employeeFilterText.setLayoutData(data2);

					employeeFilterText.addFocusListener(new FocusAdapter() {
						public void focusLost(FocusEvent arg0) {
							//processor.setEmployeeFilter(employeeFilterText.getText());
							//refreshEmployeeData();
						}
					});

					employeeFilterText.addListener(SWT.DefaultSelection, new Listener() {
						public void handleEvent(Event e) { //check for "enter" key
							//processor.setEmployeeFilter(employeeFilterText.getText());
							//System.out.println("Enter key: " + employeeFilterText.getText());
							//refreshEmployeeData();
						}
					});

					//Create radio buttons to switch viewing mode.
					employeeNameRadio = new Button(group1, SWT.RADIO);
					employeeNameRadio.setText("View by name");
					GridData data = new GridData();
					data.horizontalSpan = 2;
					employeeNameRadio.setLayoutData(data);

					employeeNumRadio = new Button(group1, SWT.RADIO);
					employeeNumRadio.setText("View by ID");
					data = new GridData();
					data.horizontalSpan = 2;
					employeeNumRadio.setLayoutData(data);

					employeeNameRadio.setSelection(true);
					employeeNameRadio.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent arg0) {
							//processor.setEmployeeView(TimeTrackerProc.VIEW_BY_NAME);
							//refreshEmployeeData();
						}
					});

					employeeNumRadio.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent arg0) {
							//processor.setEmployeeView(TimeTrackerProc.VIEW_BY_ID);
							//refreshEmployeeData();
						}
					});

					
					
				}
			}
			{
				group2 = new Group(sashForm1, SWT.NONE);
				group2.setText("Filmliste");

				FormData formData = new FormData();
				formData.top = new FormAttachment(0, 5);
				formData.left = new FormAttachment(0, 5);
				formData.bottom = new FormAttachment(100, -5);
				formData.right = new FormAttachment(33, -5);
				group2.setLayoutData(formData);

				//Composite has a grid layout
				GridLayout gridLayout = new GridLayout();
				gridLayout.numColumns = 2;
				group2.setLayout(gridLayout);

				{
					list2 = new List(group2, SWT.SINGLE
							| SWT.H_SCROLL | SWT.V_SCROLL
							| SWT.BORDER);
					GridData list2LData = new GridData();
					list2
							.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(
										SelectionEvent evt) {
									System.out
											.println("list1.widgetSelected, event="
													+ evt);
									System.out
											.println("Selected: "
													+ list2
															.getSelectionIndex());

									//TODO add your code for list1.widgetSelected
								}
							});
					list2LData.verticalAlignment = GridData.FILL;
					list2LData.horizontalAlignment = GridData.FILL;
					list2LData.grabExcessHorizontalSpace = true;
					list2LData.grabExcessVerticalSpace = true;
					list2.setLayoutData(list2LData);
				}
			}
		}
			
		
	}
	
	
	private void initMenuItemVideoFormat(){
		
		
		//VideoFormatMenuItem
		viewVideoFormatMenuItem = new MenuItem(viewMenu,
				SWT.CHECK);
		viewVideoFormatMenuItem.setText("VideoFormat\tStrg+V");
		viewVideoFormatMenuItem.setAccelerator(SWT.CTRL + 'V');
		
		
		//Häckchen setzen
		viewVideoFormatMenuItem.setSelection(false);
		
		viewVideoFormatMenuItem.addListener(SWT.Selection,
				new Listener() {
					public void handleEvent(Event e) {
						if(tabItemVideoFormat == null){
							initTabItemVideoFormat();
							return;
						}
						
						if (tabItemVideoFormat.isDisposed()) {
							System.out
									.println("Tab tabItemVideoFormat ist Disposed.(nicht mehr vorhanden?)");
							initTabItemVideoFormat();
							return;
						}
						if (tabItemVideoFormat.isShowing()) {
							System.out
									.println("Tab tabItemVideoFormat ist vorhanden.");
							tabItemVideoFormat.dispose();
						}

					}
				});		
		
	}

	private void initMenuItemDirector(){
		
		
		//VideoFormatMenuItem
		viewDirectorMenuItem = new MenuItem(viewMenu,
				SWT.CHECK);
		viewDirectorMenuItem.setText("Director");
		
		//Häckchen setzen
		viewDirectorMenuItem.setSelection(false);
		
		viewDirectorMenuItem.addListener(SWT.Selection,
				new Listener() {
					public void handleEvent(Event e) {
						if(tabItemDirector == null){
							initTabItemDirector();
							return;
						}
						
						if (tabItemDirector.isDisposed()) {
							System.out
									.println("Tab tabItemDirector ist Disposed.(nicht mehr vorhanden?)");
							initTabItemDirector();
							return;
						}
						if (tabItemDirector.isShowing()) {
							System.out
									.println("Tab tabItemDirector ist vorhanden.");
							tabItemDirector.dispose();
						}

					}
				});		
		
	}

	
	/**
	 * Initializes the GUI.
	 */
	private void initGUI() {
		try {

			FormLayout thisLayout = new FormLayout();
			shell.setLayout(thisLayout);
			{
				//inits the Tabfolder
				initTabFolder();

				
				initTabItemDirector();
				
				//initTabItemVideoFormat();
				//initTabItemMovie();
				


			}
			{
				menu1 = new Menu(shell, SWT.BAR);
				shell.setMenuBar(menu1);
				{
					fileMenuItem = new MenuItem(menu1, SWT.CASCADE);
					fileMenuItem.setText("Datei");
					{
						fileMenu = new Menu(fileMenuItem);
						{
							openFileMenuItem = new MenuItem(fileMenu,
									SWT.CASCADE);
							openFileMenuItem.setText("Open");
						}
						{
							newFileMenuItem = new MenuItem(fileMenu,
									SWT.CASCADE);
							newFileMenuItem.setText("New");
							
						}
						{
							saveFileMenuItem = new MenuItem(fileMenu,
									SWT.CASCADE);
							saveFileMenuItem.setText("Save");
						}
						{
							closeFileMenuItem = new MenuItem(fileMenu,
									SWT.CASCADE);
							closeFileMenuItem.setText("Close");
						}
						{
							exitMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
							exitMenuItem.setText("Exit");
						}
						fileMenuItem.setMenu(fileMenu);
					}
				}

				{
					viewMenuItem = new MenuItem(menu1, SWT.CASCADE);
					viewMenuItem.setText("Ansicht");
					
					{
						viewMenu = new Menu(viewMenuItem);
						
						initMenuItemVideoFormat();
						initMenuItemDirector();

						

						viewMenuItem.setMenu(viewMenu);
					}
				}

				{
					helpMenuItem = new MenuItem(menu1, SWT.CASCADE);
					helpMenuItem.setText("Help");
					{
						helpMenu = new Menu(helpMenuItem);
						{
							contentsMenuItem = new MenuItem(helpMenu,
									SWT.CASCADE);
							contentsMenuItem.setText("Contents");
						}
						{
							aboutMenuItem = new MenuItem(helpMenu, SWT.CASCADE);
							aboutMenuItem.setText("About");
						}
						helpMenuItem.setMenu(helpMenu);
					}
				}
			}
			shell.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Auto-generated main method to display this 
	 * org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void main(String[] args) {
		ManagmentGui app = new ManagmentGui();
	}

	private void sortDirectors(int criteria) {
	    
		TableItem[] items = tableDirector.getItems();

		Arrays.sort(items, new DirectorsComparator(criteria));
		for (int i = 0; i < items.length; i++) {
		    
			TableItem t = new TableItem(tableDirector, SWT.NONE);
			String[] data = new String[tableDirector.getColumnCount()];

			for (int j = 0; j < data.length; j++)
				data[j] = items[i].getText(j);

			items[i].dispose();
			t.setText(data);
		}
	}
	
	
	class DirectorsComparator implements java.util.Comparator {
		private int criteria;

		DirectorsComparator(int c) {
			criteria = c;
		}

		public int compare(Object arg0, Object arg1) {
			//boolean numeric = criteria == SORT_BY_AMT || criteria == SORT_BY_ID;
			TableItem first = (TableItem) arg0;
			TableItem second = (TableItem) arg1;
			System.out.println("Vergleiche first: "+first+" mit: "+second);
			if (criteria == 0) {
			    System.out.println("First.getText: "+first.getText(0));
				int f = Integer.parseInt(first.getText(criteria));
				int s = Integer.parseInt(second.getText(criteria));
				return f - s;
			}
			else if (criteria ==1 || criteria == 2) {
			   System.out.println("First.getText: "+first.getText(criteria));
			    return first.getText(criteria).compareTo(
					second.getText(criteria))
					< 0
					? -1
					: 1;
			}
			else
				throw new RuntimeException("Unexpected Internal Error.");
		}
	}

	
	
	
	class ColumnDirectorSelectionListener extends SelectionAdapter {

		public void widgetSelected(SelectionEvent arg0) {
			int criteria = -1;

			if (arg0.getSource() == tableColumnDirectorId) {
			    System.out.println("Tabelle Director nach id sortieren");
			    criteria = 0;
				//criteria = SORT_BY_ID;
			}
			else if (arg0.getSource() == tableColumnDirectorLastname) {
				//criteria = SORT_BY_DATE;
			    System.out.println("Tabelle Director nach lastname sortieren");
			    criteria = 1;
			}
			else if (arg0.getSource() == tableColumnDirectorFirstname) {
				//criteria = SORT_BY_DESC;
			    System.out.println("Tabelle Director nach firstname sortieren");
			    criteria = 2;
			}
			else {
				throw new RuntimeException("Es wurde in der Tabelle Director auf eine Spalte geklickt fuer die es keinen Sortierer gibt.");
			}

			sortDirectors(criteria);
		}
	}
}
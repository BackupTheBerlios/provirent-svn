package de.hsharz.provirent.storehouse.gui;

import java.text.DateFormat;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.cloudgarden.resource.SWTResourceManager;

import de.hsharz.provirent.objects.MovieOrder;
import de.hsharz.provirent.objects.OrderItem;
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
public class NewSWTApp extends org.eclipse.swt.widgets.Composite {

	private Menu menu1;

	private MenuItem aboutMenuItem;

	private MenuItem contentsMenuItem;

	private Menu helpMenu;

	private MenuItem helpMenuItem;

	private MenuItem exitMenuItem;

	private MenuItem closeFileMenuItem;

	private MenuItem saveFileMenuItem;

	private MenuItem newFileMenuItem;

	private MenuItem openFileMenuItem;

	private Menu fileMenu;

	private MenuItem fileMenuItem;

	//private Button button1;
	private Label labelMainHead, labelSendStartHead, labelStartHeader;

	private Button buttonMainMenue;

	private Label labelMainHeader;

	//private Composite composite1 ;
	//private Composite composite2;
	private Button buttonReceive, buttonSend;

	//private Composite composite3;
	private Table tableOrders;

	private TableColumn tableStart_ColumnID, tableStart_ColumnDate,
			tableStart_ColumnQuantity;

	
	StackLayout stacklayout;
	Group[] groups;
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	public NewSWTApp(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	/**
	 * Initializes the GUI.
	 */
	private void initGUI() {
		try {
			this.setSize(new org.eclipse.swt.graphics.Point(400, 300));
			this.setBackground(SWTResourceManager.getColor(192, 192, 192));

			this.setLayout(new GridLayout());
			{
				menu1 = new Menu(getShell(), SWT.BAR);
				getShell().setMenuBar(menu1);
				{
					fileMenuItem = new MenuItem(menu1, SWT.CASCADE);
					fileMenuItem.setText("File");
					{
						fileMenu = new Menu(fileMenuItem);
						{
							openFileMenuItem = new MenuItem(fileMenu,
									SWT.CASCADE);
							openFileMenuItem.setText("Open");
							openFileMenuItem.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									System.out.println("buttonSend .widgetSelected, event="
										+ evt);
									
									stacklayout.topControl = groups[1];
								}
							});
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

			final Composite parent = new Composite(this, SWT.NONE);
			GridData parentLData = new GridData();
			
		
			
			parentLData.grabExcessHorizontalSpace = true;
			parentLData.horizontalAlignment = GridData.FILL;
			parentLData.grabExcessVerticalSpace = true;
			parentLData.verticalAlignment = GridData.FILL;
			parentLData.horizontalSpan = 1;
			parent.setLayoutData(parentLData);

			
			
			
			stacklayout = new StackLayout();
			parent.setLayout(stacklayout);

			groups = new Group[2];

			{
				groups[0] = new Group(parent, SWT.NONE);

				GridLayout gridLayout = new GridLayout();
				gridLayout.numColumns = 2;
				groups[0].setLayout(gridLayout);

				
				labelMainHeader = new Label(groups[0], SWT.NONE);
				labelMainHeader.setText("Bitte wählen Sie aus:");
				labelMainHeader.setFont(SWTResourceManager.getFont("Tahoma",
						20, 0, false, true));
				GridData labelLData = new GridData();
				labelLData.grabExcessHorizontalSpace = true;
				labelLData.horizontalAlignment = GridData.FILL;
				labelLData.horizontalSpan = 2;
				labelMainHeader.setLayoutData(labelLData);
				
				
				
				
				buttonSend = new Button(groups[0], SWT.PUSH | SWT.CENTER);
				buttonSend.setFont(SWTResourceManager.getFont("Tahoma", 20, 0,
						false, false));
				buttonSend.setText("send");
				GridData button1LData = new GridData();
				button1LData.widthHint = 273;
				button1LData.heightHint = 170;
				button1LData.horizontalAlignment = GridData.CENTER;
				button1LData.grabExcessHorizontalSpace = true;
				buttonSend.setLayoutData(button1LData);

				buttonSend.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						System.out.println("buttonSend .widgetSelected, event="
							+ evt);
						
						stacklayout.topControl = groups[1];
						parent.layout();
						
						Thread thread = new Thread(){
							public void run(){
							
							
								getDisplay().asyncExec(new Runnable(){
									public void run(){
										refreshOrderTable();
									}
								});

								
							}
						};
						getDisplay().asyncExec(thread);
						
					}
				});
				
				
				
				buttonReceive = new Button(groups[0], SWT.PUSH | SWT.CENTER);
				buttonReceive.setFont(SWTResourceManager.getFont("Tahoma", 20,
						0, false, false));
				buttonReceive.setText("receive");
				GridData button2LData = new GridData();
				button2LData.widthHint = 273;
				button2LData.heightHint = 170;
				button2LData.horizontalAlignment = GridData.CENTER;
				button2LData.grabExcessHorizontalSpace = true;
				buttonReceive.setLayoutData(button2LData);

			}
			{
				groups[1] = new Group(parent, SWT.NONE);
				GridLayout gridLayout = new GridLayout();
				gridLayout.numColumns = 2;
				groups[1].setLayout(gridLayout);
				
				
				labelStartHeader = new Label(groups[1], SWT.NONE);
				labelStartHeader.setText("Bestellungen:");
				labelStartHeader.setFont(SWTResourceManager.getFont("Tahoma", 20, 0, false, true));
				GridData label1LData = new GridData();
				label1LData.horizontalSpan = 2;
				labelStartHeader.setLayoutData(label1LData);
				
				
				tableOrders =  new Table(groups[1], SWT.SINGLE | SWT.FULL_SELECTION);
				tableOrders.setLinesVisible(true);
				tableOrders.setHeaderVisible(true);
				
				
				tableOrders.setFont(SWTResourceManager.getFont("Tahoma", 20, 0, false, false));
				
				GridData table1LData = new GridData();
				table1LData.horizontalAlignment = GridData.FILL;
				table1LData.grabExcessHorizontalSpace = true;
				table1LData.grabExcessVerticalSpace = true;
				table1LData.horizontalSpan = 2;
				table1LData.verticalAlignment = GridData.FILL;
				tableOrders.setLayoutData(table1LData);
				
				
				tableOrders.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						System.out.println("table1.widgetSelected, event="
							+ evt);
						
					}
				});

				
				
				{
                    tableStart_ColumnID = new TableColumn(
                    		tableOrders,
                            SWT.CENTER);
                    tableStart_ColumnID.setText("ID");
                    tableStart_ColumnID.setWidth(50);
				}
				{
                    tableStart_ColumnDate = new TableColumn(
                    		tableOrders,
                            SWT.CENTER);
                    tableStart_ColumnDate.setText("Datum");
                    tableStart_ColumnDate.setWidth(250);
				}
				{
                    tableStart_ColumnQuantity = new TableColumn(
                    		tableOrders,
                            SWT.CENTER);
                    tableStart_ColumnQuantity .setText("Anzahl");
                    tableStart_ColumnQuantity .setWidth(100);
				}
				
				buttonMainMenue = new Button(groups[1], SWT.PUSH | SWT.CENTER);
				buttonMainMenue.setFont(SWTResourceManager.getFont("Tahoma", 20, 0,
						false, false));
				buttonMainMenue.setText("Hauptmenü");
				GridData button1LData = new GridData();
				button1LData.widthHint = 273;
				button1LData.heightHint = 50;
				button1LData.horizontalSpan = 2;
				button1LData.horizontalAlignment = GridData.CENTER;
				button1LData.grabExcessHorizontalSpace = true;
				buttonMainMenue.setLayoutData(button1LData);

				buttonMainMenue.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						System.out.println("buttonSend .widgetSelected, event="
							+ evt);
						
						stacklayout.topControl = groups[0];
						parent.layout();
						
					}
				});
				
				
			}
			stacklayout.topControl = groups[0];

			
			
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Auto-generated main method to display this 
	 * org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		NewSWTApp inst = new NewSWTApp(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if (size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			if (shell.getMenuBar() != null)
				shellBounds.height -= 22;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	
	private void refreshOrderTable(){
		List orders = Database.getOrder("");
		System.out.println("List: "+orders);
		
		TableItem item;
		for (int i = 0; i < orders.size(); i++) {
			MovieOrder o = (MovieOrder)orders.get(i);
			
			if(o.getMovieOrderItems().size() > 0){
				item = new TableItem(tableOrders, SWT.NONE);
				String date = DateFormat.getDateInstance(DateFormat.LONG).format(((OrderItem)o.getMovieOrderItems().get(0)).getOrderTime().getTime());
				item.setText(new String[]{o.getMovieOrderId()+"",date,o.getMovieOrderItems().size()+""  });
			}else {
				continue;
			}
			
			
		}
		


		
	}
	
}
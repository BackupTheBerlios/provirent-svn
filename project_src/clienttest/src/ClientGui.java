/*
 * Created on 12.10.2004
 *
 * Copyright (c) 2004/2005, Remo Griesch/Stefan Forstner/Philipp Schneider
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * - Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * - Neither the name of the Remo Griesch/Stefan Forstner/Philipp Schneider nor
 * the names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 */

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
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
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;





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
/**
 * @author Philipp Schneider
 *
 */
public class ClientGui {
    
	//Size constants
	private static final int SHELL_HEIGHT = 480;
	private static final int SHELL_WIDTH = 640;

	private Display display;
	private Shell shell;
    
	private TabFolder folder;
	private TabItem administrationItem, employeeItem, movieItem;
	private Composite administrationPane, employeePane, moviePane;
	private Group employeeListComp, projectListComp, currentEmployeeComp;
	private Group administrationInfo, employeeInfo, movieInfo;

	//Employee modification buttons
	private Button newEmployeeButton;
	private Button editEmployeeButton;
	private Button delEmployeeButton;
	private Button saveEmployeeButton;
	private Button cancelEmployeeButton;
	private Button printTransButton;

	
	//Employee page widgets
	private Text acctIDText;
	private Text addressText;
	private Text fnameText;
	private Text snameText;
	private Text dobText;
	private Text phoneText;
	private Text miscInfoText;
	private Text emailText;
	
	
	//Employee List
	private List employeeList;
	private Text employeeFilterText;
	private Button employeeNameRadio;
	private Button employeeNumRadio;
	
    public ClientGui(){
        display = new Display();
        shell = new Shell(display);
     
        shell.setSize(400, 300);
        /**
         * @todo Dynamisch mit Resourcenbundle
         */
		shell.setText("ProViRent Managment Tool");
		Image image1 = new Image(null, "video2.gif");

		shell.setImage(image1);
		shell.setLayout(new FormLayout());

		setupFolders();
		setupFileMenu();
    }
	
	private void setupFolders() {

	    //creates a new TabFolder with no Border
		folder = new TabFolder(shell, SWT.NONE);
		
		//sets the layout
		FormLayout folderLayout = new FormLayout();
		folderLayout.marginHeight = 0;
		folderLayout.marginWidth = 0;
		folder.setLayout(folderLayout);
		
		//spec. where the tabfolders should be
		FormData data = new FormData();
		data.top = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, 0);
		data.left = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(100, 0);
		folder.setLayoutData(data);

		

		

		setupAdministrationPane();
		setupMoviePane();


	
		
		
		
		//setupProjectManagerPane();
	}
    
	private void refreshEmployeeList(){
	
		String[] data = new String[]{"1 - Max Meier","2 - Stefan Forstner",
		        "3 - Remo Griesch","4 - Philipp Schneider"};

		//Load the Employee list
		employeeList.removeAll();

		for (int i = 0; i < data.length; i++)
			employeeList.add(data[i]);
	}
	
	
	
	private void setupEmployeeList() {
		//Create employee list.
		employeeListComp = new Group(administrationPane, SWT.NONE);
		employeeListComp.setText("Employees:");

		//Form layout data for composite
		FormData formData = new FormData();
		formData.top = new FormAttachment(0, 5);
		formData.left = new FormAttachment(0, 5);
		formData.bottom = new FormAttachment(100, -5);
		formData.right = new FormAttachment(33, -5);
		employeeListComp.setLayoutData(formData);

		//Composite has a grid layout
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		employeeListComp.setLayout(gridLayout);

		employeeList =
			new List(
				employeeListComp,
				SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 2;
		employeeList.setLayoutData(data);

		employeeList.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				//setTransMode(VIEW_MODE);
				//setEmployeeMode(VIEW_MODE);
				//processor.setActiveEmployee(employeeList.getSelectionIndex());
				System.out.println("Es wurde gerade einer ausgewaehlt: " + employeeList.getSelectionIndex());
				 refreshEmployeeList();
			}
		});

		//Create the filter text field and its listeners.
		Label filterLabel = new Label(employeeListComp, SWT.NONE);
		filterLabel.setText("Filter:");
		employeeFilterText = new Text(employeeListComp, SWT.BORDER);
		GridData data1 = new GridData();
		data1.widthHint = 26;
		filterLabel.setLayoutData(data1);
		GridData data2 = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		data2.widthHint = 48;
		employeeFilterText.setLayoutData(data2);

		employeeFilterText.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent arg0) {
			    System.out.println("Focus verloren: " + employeeFilterText.getText());
				//processor.setEmployeeFilter(employeeFilterText.getText());
				//refreshEmployeeData();
			}
		});

		employeeFilterText.addListener(SWT.DefaultSelection, new Listener() {
			public void handleEvent(Event e) { //check for "enter" key
			    System.out.println("Enter key: " + employeeFilterText.getText());
				//processor.setEmployeeFilter(employeeFilterText.getText());
				//refreshEmployeeData();
			}
		});

		//Create radio buttons to switch viewing mode.
		employeeNameRadio = new Button(employeeListComp, SWT.RADIO);
		employeeNameRadio.setText("View by Name");
		data = new GridData();
		data.horizontalSpan = 2;
		employeeNameRadio.setLayoutData(data);

		employeeNumRadio = new Button(employeeListComp, SWT.RADIO);
		employeeNumRadio.setText("View by KundenID");
		data = new GridData();
		data.horizontalSpan = 2;
		employeeNumRadio.setLayoutData(data);

		employeeNameRadio.setSelection(true);
		employeeNameRadio.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
			    System.out.println("Nur Namen anschauen");
			    System.out.println(employeeFilterText.getText());
				//processor.setEmployeeView(TimeTrackerProc.VIEW_BY_NAME);
				//refreshEmployeeData();
			}
		});

		employeeNumRadio.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
			    System.out.println("Nur kundennummer anschauen ");
				//processor.setEmployeeView(TimeTrackerProc.VIEW_BY_ID);
				//refreshEmployeeData();
			}
		});
	}


	
	private void setupAdministrationPane() {

		administrationItem = new TabItem(folder, SWT.NONE);
		administrationItem.setText("&Kunden");
		administrationPane = new Composite(folder, SWT.NONE);
		administrationItem.setControl(administrationPane);
		administrationItem.setToolTipText("Ihre Kunden");
		
		
		
		//administrationPane has a FormLayout
		administrationPane.setLayout(new FormLayout());

		setupEmployeeList();
		refreshEmployeeList();
		
		//administrationInfo has a FormLayout
		administrationInfo = new Group(administrationPane, SWT.NONE);
		administrationInfo.setText("Employee Information:");

		FormLayout administrationLayout = new FormLayout();
		administrationLayout.marginHeight = 10;
		administrationLayout.marginWidth = 10;
		administrationInfo.setLayout(administrationLayout);

		FormData formData = new FormData();
		formData.left = new FormAttachment(33, 5);
		formData.right = new FormAttachment(100, -5);
		formData.top = new FormAttachment(0, 5);
		formData.bottom = new FormAttachment(100, -5);
		administrationInfo.setLayoutData(formData);

		Label acctIDLabel = new Label(administrationInfo, SWT.NONE);
		acctIDLabel.setText("Employee ID:");
		acctIDText = new Text(administrationInfo, SWT.BORDER);
		acctIDText.setEditable(false);

		FormData formData2 = new FormData();
		formData2.left = new FormAttachment(0, 5);
		formData2.right = new FormAttachment(0, 135);
		formData2.top = new FormAttachment(0, 10);
		formData2.height = 15;
		acctIDLabel.setLayoutData(formData2);

		FormData formData2b = new FormData();
		formData2b.left = new FormAttachment(acctIDLabel, 10, SWT.DEFAULT);
		formData2b.right = new FormAttachment(100, -5);
		formData2b.top = new FormAttachment(acctIDLabel, -5, SWT.TOP);
		formData2b.height = 15;
		acctIDText.setLayoutData(formData2b);

		Label fnameLabel = new Label(administrationInfo, SWT.NONE);
		fnameLabel.setText("First name:");
		fnameText = new Text(administrationInfo, SWT.BORDER);
		fnameText.setEditable(false);

		FormData formData3 = new FormData();
		formData3.left = new FormAttachment(0, 5);
		formData3.right = new FormAttachment(0, 135);
		formData3.top = new FormAttachment(0, 35);
		formData3.height = 15;
		fnameLabel.setLayoutData(formData3);

		FormData formData3b = new FormData();
		formData3b.left = new FormAttachment(fnameLabel, 10, SWT.DEFAULT);
		formData3b.right = new FormAttachment(100, -5);
		formData3b.top = new FormAttachment(fnameLabel, -5, SWT.TOP);
		formData3b.height = 15;
		fnameText.setLayoutData(formData3b);

		Label snameLabel = new Label(administrationInfo, SWT.NONE);
		snameLabel.setText("Surname:");
		snameText = new Text(administrationInfo, SWT.BORDER);
		snameText.setEditable(false);

		FormData formData4 = new FormData();
		formData4.left = new FormAttachment(0, 5);
		formData4.right = new FormAttachment(0, 135);
		formData4.top = new FormAttachment(0, 60);
		formData4.height = 15;
		snameLabel.setLayoutData(formData4);

		FormData formData4b = new FormData();
		formData4b.left = new FormAttachment(snameLabel, 10, SWT.DEFAULT);
		formData4b.right = new FormAttachment(100, -5);
		formData4b.top = new FormAttachment(snameLabel, -5, SWT.TOP);
		formData4b.height = 15;
		snameText.setLayoutData(formData4b);

		Label dobLabel = new Label(administrationInfo, SWT.NONE);
		dobLabel.setText("Date of birth:");
		dobText = new Text(administrationInfo, SWT.BORDER);
		dobText.setEditable(false);

		FormData formData5 = new FormData();
		formData5.left = new FormAttachment(0, 5);
		formData5.right = new FormAttachment(0, 135);
		formData5.top = new FormAttachment(0, 85);
		formData5.height = 15;
		dobLabel.setLayoutData(formData5);

		FormData formData5b = new FormData();
		formData5b.left = new FormAttachment(dobLabel, 10, SWT.DEFAULT);
		formData5b.right = new FormAttachment(100, -5);
		formData5b.top = new FormAttachment(dobLabel, -5, SWT.TOP);
		formData5b.height = 15;
		dobText.setLayoutData(formData5b);

		Label phoneLabel = new Label(administrationInfo, SWT.NONE);
		phoneLabel.setText("Phone number:");
		phoneText = new Text(administrationInfo, SWT.BORDER);
		phoneText.setEditable(false);

		FormData formData6 = new FormData();
		formData6.left = new FormAttachment(0, 5);
		formData6.right = new FormAttachment(0, 135);
		formData6.top = new FormAttachment(0, 110);
		formData6.height = 15;
		phoneLabel.setLayoutData(formData6);

		FormData formData6b = new FormData();
		formData6b.left = new FormAttachment(phoneLabel, 10, SWT.DEFAULT);
		formData6b.right = new FormAttachment(100, -5);
		formData6b.top = new FormAttachment(phoneLabel, -5, SWT.TOP);
		formData6b.height = 15;
		phoneText.setLayoutData(formData6b);

		Label emailLabel = new Label(administrationInfo, SWT.NONE);
		emailLabel.setText("Email address:");
		emailText = new Text(administrationInfo, SWT.BORDER);
		emailText.setEditable(false);

		FormData formData7 = new FormData();
		formData7.left = new FormAttachment(0, 5);
		formData7.right = new FormAttachment(0, 135);
		formData7.top = new FormAttachment(0, 135);
		formData7.height = 15;
		emailLabel.setLayoutData(formData7);

		FormData formData7b = new FormData();
		formData7b.left = new FormAttachment(emailLabel, 10, SWT.DEFAULT);
		formData7b.right = new FormAttachment(100, -5);
		formData7b.top = new FormAttachment(emailLabel, -5, SWT.TOP);
		formData7b.height = 15;
		emailText.setLayoutData(formData7b);

		Label addressLabel = new Label(administrationInfo, SWT.NONE);
		addressLabel.setText("Address:");
		addressText =
			new Text(
				administrationInfo,
				SWT.WRAP | SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		addressText.setEditable(false);

		FormData formData8 = new FormData();
		formData8.left = new FormAttachment(0, 8);
		formData8.right = new FormAttachment(0, 135);
		formData8.top = new FormAttachment(0, 180);
		formData8.height = 15;
		addressLabel.setLayoutData(formData8);

		FormData formData8b = new FormData();
		formData8b.bottom = new FormAttachment(0, 230);
		formData8b.left = new FormAttachment(addressLabel, 10, SWT.DEFAULT);
		formData8b.right = new FormAttachment(100, -5);
		formData8b.top = new FormAttachment(emailLabel, 5, SWT.BOTTOM);
		formData8b.height = 15;
		addressText.setLayoutData(formData8b);

		Label miscInfoLabel = new Label(administrationInfo, SWT.NONE);
		miscInfoLabel.setText("Miscellaneous information:");
		miscInfoText =
			new Text(
				administrationInfo,
				SWT.WRAP | SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		miscInfoText.setEditable(false);

		FormData formData9 = new FormData();
		formData9.left = new FormAttachment(0, 8);
		formData9.right = new FormAttachment(0, 135);
		formData9.top = new FormAttachment(0, 260);
		formData9.height = 15;
		miscInfoLabel.setLayoutData(formData9);

		FormData formData9b = new FormData();
		formData9b.bottom = new FormAttachment(0, 310);
		formData9b.left = new FormAttachment(miscInfoLabel, 10, SWT.DEFAULT);
		formData9b.right = new FormAttachment(100, -5);
		formData9b.top = new FormAttachment(addressText, 5, SWT.BOTTOM);
		formData9b.height = 15;
		miscInfoText.setLayoutData(formData9b);

		//buttonGrp has a FillLayout
		Composite buttonGrp = new Composite(administrationInfo, SWT.NONE);
		buttonGrp.setLayout(new FillLayout());

		FormData data3 = new FormData();
		data3.bottom = new FormAttachment(100, 0);
		data3.left = new FormAttachment(0, 0);
		data3.right = new FormAttachment(100, 0);
		data3.top = new FormAttachment(100, -25);
		buttonGrp.setLayoutData(data3);

		newEmployeeButton = new Button(buttonGrp, SWT.PUSH);
		newEmployeeButton.setText("&New");
		newEmployeeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				//setEmployeeMode(ADD_MODE);
			}
		});

		delEmployeeButton = new Button(buttonGrp, SWT.PUSH);
		delEmployeeButton.setText("&Delete");
		delEmployeeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				/*
			    Employee c = processor.getActiveEmployee();
				
				//Can't delete an employee if it is the manager of a project.
				for (int i = 0; i < processor.getNumAllProjects(); i++) {
					if (processor.getAllProjectByIndex(i).managerID == c.employeeID) {
						MessageBox msgBox =
								new MessageBox(shell, SWT.APPLICATION_MODAL | SWT.OK);
							msgBox.setText("Error");
							msgBox.setMessage(
								"Cannot delete selected employee because selected "
								+ "employee is the manager of a project.");
							msgBox.open();
							return;
					}
				}
				
				MessageBox msgBox =
					new MessageBox(
						shell,
						SWT.APPLICATION_MODAL | SWT.YES | SWT.NO);
				msgBox.setText("Confirm Deletion");
				msgBox.setMessage(
					"Are you certain you wish to delete the selected employee?\n"
						+ "(All related transactions will also  be deleted.)");

				if (msgBox.open() == SWT.YES) {
					processor.deleteEmployee(employeeList.getSelectionIndex());
					refreshEmployeeData();
					setEmployeeMode(VIEW_MODE);
				}
				*/
			}
		});

		editEmployeeButton = new Button(buttonGrp, SWT.PUSH);
		editEmployeeButton.setText("&Edit");
		editEmployeeButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				//setEmployeeMode(EDIT_MODE);
			}
		});

		//filler
		Label fill = new Label(buttonGrp, SWT.NONE);

		saveEmployeeButton = new Button(buttonGrp, SWT.PUSH);
		saveEmployeeButton.setText("&Save");
		saveEmployeeButton.setEnabled(false);
		//saveEmployeeButton.addSelectionListener(new SaveEmployeeButtonListener());

		cancelEmployeeButton = new Button(buttonGrp, SWT.PUSH);
		cancelEmployeeButton.setText("&Cancel");
		cancelEmployeeButton.setEnabled(false);
		cancelEmployeeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				//setEmployeeMode(VIEW_MODE);
				//refreshEmployeeData();
			}
		});


	}

	private void setupMoviePane() {

		movieItem = new TabItem(folder, SWT.NONE);
		movieItem.setText("&Filme");
		moviePane = new Composite(folder, SWT.NONE);
		movieItem.setControl(moviePane);
		
		
		
		
		//administrationPane has a FormLayout
		moviePane.setLayout(new FormLayout());

		setupEmployeeList();
		
		//administrationInfo has a FormLayout
		movieInfo = new Group(moviePane, SWT.NONE);
		movieInfo.setText("Employee Information:");

		movieInfo.setBackground(new Color(null,250,100,200));
		
		FormLayout movieLayout = new FormLayout();
		movieLayout.marginHeight = 10;
		movieLayout.marginWidth = 10;
		movieInfo.setLayout(movieLayout);

		FormData formData = new FormData();
		formData.left = new FormAttachment(33, 5);
		formData.right = new FormAttachment(100, -5);
		formData.top = new FormAttachment(0, 5);
		formData.bottom = new FormAttachment(100, -5);
		movieInfo.setLayoutData(formData);

		Label acctIDLabel = new Label(movieInfo, SWT.NONE);
		acctIDLabel.setText("Employee ID:");
		acctIDText = new Text(movieInfo, SWT.BORDER);
		acctIDText.setEditable(false);

		FormData formData2 = new FormData();
		formData2.left = new FormAttachment(0, 5);
		formData2.right = new FormAttachment(0, 135);
		formData2.top = new FormAttachment(0, 10);
		formData2.height = 15;
		acctIDLabel.setLayoutData(formData2);

		FormData formData2b = new FormData();
		formData2b.left = new FormAttachment(acctIDLabel, 10, SWT.DEFAULT);
		formData2b.right = new FormAttachment(100, -5);
		formData2b.top = new FormAttachment(acctIDLabel, -5, SWT.TOP);
		formData2b.height = 15;
		acctIDText.setLayoutData(formData2b);

		Label fnameLabel = new Label(movieInfo, SWT.NONE);
		fnameLabel.setText("First name:");
		fnameText = new Text(movieInfo, SWT.BORDER);
		fnameText.setEditable(false);

		FormData formData3 = new FormData();
		formData3.left = new FormAttachment(0, 5);
		formData3.right = new FormAttachment(0, 135);
		formData3.top = new FormAttachment(0, 35);
		formData3.height = 15;
		fnameLabel.setLayoutData(formData3);

		FormData formData3b = new FormData();
		formData3b.left = new FormAttachment(fnameLabel, 10, SWT.DEFAULT);
		formData3b.right = new FormAttachment(100, -5);
		formData3b.top = new FormAttachment(fnameLabel, -5, SWT.TOP);
		formData3b.height = 15;
		fnameText.setLayoutData(formData3b);

		Label snameLabel = new Label(movieInfo, SWT.NONE);
		snameLabel.setText("Surname:");
		snameText = new Text(movieInfo, SWT.BORDER);
		snameText.setEditable(false);

		FormData formData4 = new FormData();
		formData4.left = new FormAttachment(0, 5);
		formData4.right = new FormAttachment(0, 135);
		formData4.top = new FormAttachment(0, 60);
		formData4.height = 15;
		snameLabel.setLayoutData(formData4);

		FormData formData4b = new FormData();
		formData4b.left = new FormAttachment(snameLabel, 10, SWT.DEFAULT);
		formData4b.right = new FormAttachment(100, -5);
		formData4b.top = new FormAttachment(snameLabel, -5, SWT.TOP);
		formData4b.height = 15;
		snameText.setLayoutData(formData4b);

		Label dobLabel = new Label(movieInfo, SWT.NONE);
		dobLabel.setText("Date of birth:");
		dobText = new Text(movieInfo, SWT.BORDER);
		dobText.setEditable(false);

		FormData formData5 = new FormData();
		formData5.left = new FormAttachment(0, 5);
		formData5.right = new FormAttachment(0, 135);
		formData5.top = new FormAttachment(0, 85);
		formData5.height = 15;
		dobLabel.setLayoutData(formData5);

		FormData formData5b = new FormData();
		formData5b.left = new FormAttachment(dobLabel, 10, SWT.DEFAULT);
		formData5b.right = new FormAttachment(100, -5);
		formData5b.top = new FormAttachment(dobLabel, -5, SWT.TOP);
		formData5b.height = 15;
		dobText.setLayoutData(formData5b);

		Label phoneLabel = new Label(movieInfo, SWT.NONE);
		phoneLabel.setText("Phone number:");
		phoneText = new Text(movieInfo, SWT.BORDER);
		phoneText.setEditable(false);

		FormData formData6 = new FormData();
		formData6.left = new FormAttachment(0, 5);
		formData6.right = new FormAttachment(0, 135);
		formData6.top = new FormAttachment(0, 110);
		formData6.height = 15;
		phoneLabel.setLayoutData(formData6);

		FormData formData6b = new FormData();
		formData6b.left = new FormAttachment(phoneLabel, 10, SWT.DEFAULT);
		formData6b.right = new FormAttachment(100, -5);
		formData6b.top = new FormAttachment(phoneLabel, -5, SWT.TOP);
		formData6b.height = 15;
		phoneText.setLayoutData(formData6b);

		Label emailLabel = new Label(movieInfo, SWT.NONE);
		emailLabel.setText("Email address:");
		emailText = new Text(movieInfo, SWT.BORDER);
		emailText.setEditable(false);

		FormData formData7 = new FormData();
		formData7.left = new FormAttachment(0, 5);
		formData7.right = new FormAttachment(0, 135);
		formData7.top = new FormAttachment(0, 135);
		formData7.height = 15;
		emailLabel.setLayoutData(formData7);

		FormData formData7b = new FormData();
		formData7b.left = new FormAttachment(emailLabel, 10, SWT.DEFAULT);
		formData7b.right = new FormAttachment(100, -5);
		formData7b.top = new FormAttachment(emailLabel, -5, SWT.TOP);
		formData7b.height = 15;
		emailText.setLayoutData(formData7b);

		Label addressLabel = new Label(movieInfo, SWT.NONE);
		addressLabel.setText("Address:");
		addressText =
			new Text(
			        movieInfo,
				SWT.WRAP | SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		addressText.setEditable(false);

		FormData formData8 = new FormData();
		formData8.left = new FormAttachment(0, 8);
		formData8.right = new FormAttachment(0, 135);
		formData8.top = new FormAttachment(0, 180);
		formData8.height = 15;
		addressLabel.setLayoutData(formData8);

		FormData formData8b = new FormData();
		formData8b.bottom = new FormAttachment(0, 230);
		formData8b.left = new FormAttachment(addressLabel, 10, SWT.DEFAULT);
		formData8b.right = new FormAttachment(100, -5);
		formData8b.top = new FormAttachment(emailLabel, 5, SWT.BOTTOM);
		formData8b.height = 15;
		addressText.setLayoutData(formData8b);

		Label miscInfoLabel = new Label(movieInfo, SWT.NONE);
		miscInfoLabel.setText("Miscellaneous information:");
		miscInfoText =
			new Text(
			        movieInfo,
				SWT.WRAP | SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		miscInfoText.setEditable(false);

		FormData formData9 = new FormData();
		formData9.left = new FormAttachment(0, 8);
		formData9.right = new FormAttachment(0, 135);
		formData9.top = new FormAttachment(0, 260);
		formData9.height = 15;
		miscInfoLabel.setLayoutData(formData9);

		FormData formData9b = new FormData();
		formData9b.bottom = new FormAttachment(0, 310);
		formData9b.left = new FormAttachment(miscInfoLabel, 10, SWT.DEFAULT);
		formData9b.right = new FormAttachment(100, -5);
		formData9b.top = new FormAttachment(addressText, 5, SWT.BOTTOM);
		formData9b.height = 15;
		miscInfoText.setLayoutData(formData9b);

		//buttonGrp has a FillLayout
		Composite buttonGrp = new Composite(movieInfo, SWT.NONE);
		buttonGrp.setLayout(new FillLayout());

		FormData data3 = new FormData();
		data3.bottom = new FormAttachment(100, 0);
		data3.left = new FormAttachment(0, 0);
		data3.right = new FormAttachment(100, 0);
		data3.top = new FormAttachment(100, -25);
		buttonGrp.setLayoutData(data3);

		newEmployeeButton = new Button(buttonGrp, SWT.PUSH);
		newEmployeeButton.setText("&New");
		newEmployeeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				//setEmployeeMode(ADD_MODE);
			}
		});

		delEmployeeButton = new Button(buttonGrp, SWT.PUSH);
		delEmployeeButton.setText("&Delete");
		delEmployeeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				/*
			    Employee c = processor.getActiveEmployee();
				
				//Can't delete an employee if it is the manager of a project.
				for (int i = 0; i < processor.getNumAllProjects(); i++) {
					if (processor.getAllProjectByIndex(i).managerID == c.employeeID) {
						MessageBox msgBox =
								new MessageBox(shell, SWT.APPLICATION_MODAL | SWT.OK);
							msgBox.setText("Error");
							msgBox.setMessage(
								"Cannot delete selected employee because selected "
								+ "employee is the manager of a project.");
							msgBox.open();
							return;
					}
				}
				
				MessageBox msgBox =
					new MessageBox(
						shell,
						SWT.APPLICATION_MODAL | SWT.YES | SWT.NO);
				msgBox.setText("Confirm Deletion");
				msgBox.setMessage(
					"Are you certain you wish to delete the selected employee?\n"
						+ "(All related transactions will also  be deleted.)");

				if (msgBox.open() == SWT.YES) {
					processor.deleteEmployee(employeeList.getSelectionIndex());
					refreshEmployeeData();
					setEmployeeMode(VIEW_MODE);
				}
				*/
			}
		});

		editEmployeeButton = new Button(buttonGrp, SWT.PUSH);
		editEmployeeButton.setText("&Edit");
		editEmployeeButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				//setEmployeeMode(EDIT_MODE);
			}
		});

		//filler
		Label fill = new Label(buttonGrp, SWT.NONE);

		saveEmployeeButton = new Button(buttonGrp, SWT.PUSH);
		saveEmployeeButton.setText("&Save");
		saveEmployeeButton.setEnabled(false);
		//saveEmployeeButton.addSelectionListener(new SaveEmployeeButtonListener());

		cancelEmployeeButton = new Button(buttonGrp, SWT.PUSH);
		cancelEmployeeButton.setText("&Cancel");
		cancelEmployeeButton.setEnabled(false);
		cancelEmployeeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				//setEmployeeMode(VIEW_MODE);
				//refreshEmployeeData();
			}
		});


	}



	/**
	 * Creates the FileMenu
	 */
	private void setupFileMenu() {
		//create the menu bar
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		//add the File option to it
		MenuItem file = new MenuItem(menu, SWT.CASCADE);
		file.setText("File");

		//create a menu for the File option
		Menu filemenu = new Menu(shell, SWT.DROP_DOWN);
		file.setMenu(filemenu);



		MenuItem quitItem = new MenuItem(filemenu, SWT.PUSH);
		quitItem.setText("Quit");


		//add the View option to it
		MenuItem view = new MenuItem(menu, SWT.CASCADE);
		view.setText("Ansicht");
		//create a menu for the View option
		Menu viewmenu = new Menu(shell, SWT.DROP_DOWN);
		view.setMenu(viewmenu);
		//add MenuItems to the View menu
		MenuItem customerItem = new MenuItem(viewmenu, SWT.PUSH);
		customerItem.setText("Kunden");		
		//add a listener for the action
		customerItem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				folder.setSelection(0);
			}
		});
		MenuItem movieItem = new MenuItem(viewmenu, SWT.PUSH);
		movieItem.setText("Filme");		
		//add a listener for the action
		movieItem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				folder.setSelection(1);
			}
		});
		
		
		//add the Help option to it
		MenuItem help = new MenuItem(menu, SWT.CASCADE);
		help.setText("?");
		//create a menu for the Help option
		Menu helpmenu = new Menu(shell, SWT.DROP_DOWN);
		help.setMenu(helpmenu);		
		//add MenuItems to the Help menu
		MenuItem helpItem = new MenuItem(helpmenu, SWT.PUSH);
		helpItem.setText("Help");		
		MenuItem hpItem = new MenuItem(helpmenu, SWT.PUSH);
		hpItem.setText("Homepage");
		MenuItem versionItem = new MenuItem(helpmenu, SWT.PUSH);
		versionItem.setText("Versionshinweis");				
		MenuItem aboutItem = new MenuItem(helpmenu, SWT.PUSH);
		aboutItem.setText("About...");		
		
		
		
		//add a listener for the action
		quitItem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				shell.dispose();
			}
		});

		aboutItem.addListener(SWT.Selection, new Listener() {
			private Image aboutImage;
			private Shell aboutShell;

			public void handleEvent(Event e) {

				aboutShell = new Shell(shell, SWT.DIALOG_TRIM);
				aboutShell.setSize(200, 250);
				aboutShell.setText("About...");

				//load an Image
				aboutImage = new Image(display, "video2.gif");
				
				aboutShell.addPaintListener(new PaintListener() {
					public void paintControl(PaintEvent e) {
						//Get the graphics context
						GC gc = new GC(aboutShell);
						//Write a string to the shell
						gc.drawString(
							"TimeTracker Application " ,
							30,
							10);

						//draw a blue rectangle
						Color blue = display.getSystemColor(SWT.COLOR_BLUE);
						gc.setForeground(blue);
						gc.drawRectangle(30, 30, 135, 165);

						//draw an image
						gc.drawImage(aboutImage, 70, 70);
					}
				});

				aboutShell.addDisposeListener(new DisposeListener() {
					public void widgetDisposed(DisposeEvent e) {
						//when the shell is closed, dispose of the Image
						aboutImage.dispose();
						shell.setEnabled(true);
					}
				});

				shell.setEnabled(false);
				aboutShell.open();
			}
		});
	}
    
	     
    public void run(){
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		display.dispose();
    }
}


/*
 * Created on 11.10.2004
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

package de.hsharz.provirent.managment.gui;


import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.cloudgarden.resource.SWTResourceManager;

import de.hsharz.provirent.managment.exceptions.GuiInitException;
import de.hsharz.provirent.objects.VideoFormat;
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
 import de.hsharz.provirent.managment.gui.CompositeFormate;
/**
 * @author Philipp Schneider
 *  
 */
public class ManagmentGui {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(ManagmentGui.class);

    public final static int MODE_VIEW = 0;

    public final static int MODE_ADD = 1;

    public final static int MODE_EDIT = 2;

    private int mode_VideoFormat = 0;

    private int mode_AudioFormat = 0;

    private static final int MAIN_WINDOW_WIDTH = 700;

    private static final int MAIN_WINDOW_HEIGHT = 500;

    private CTabFolder cTabFolderMain;

    private CTabItem tabItemFormat;

    private CompositeFormate compositeFormate;

    private MenuItem aboutMenuItem;

    private MenuItem contentsMenuItem;

    private Menu helpMenu;

    private MenuItem helpMenuItem;

    private MenuItem viewDirectorMenuItem;
    
    private MenuItem viewFormatMenuItem,viewActorMenuItem,viewGenreMenuItem;
    private MenuItem viewSubtitleMenuItem,viewLanguageMenuItem,viewStatusMenuItem;
    private MenuItem viewConditionMenuItem,viewMovieMenuItem,viewDvdMenuItem, viewBillMenuItem;
    

    private Shell shell;

    private Display display;

    private MenuItem viewVideoFormatMenuItem;

    private Menu viewMenu;

    private MenuItem viewMenuItem;

    private MenuItem exitMenuItem;

    private MenuItem closeFileMenuItem;

    private MenuItem saveFileMenuItem;

    private MenuItem newFileMenuItem;

    private MenuItem openFileMenuItem;

    private Menu fileMenu;

    private MenuItem fileMenuItem;

    private Menu rootMenu;

    private TableColumn tableColumn6;

    private TableColumn tableColumn5;

    private TableColumn tableColumn4;

    private StatusLineStyledText statusLine;

    private Composite compositeStatusLine;

    private Composite compositeMain;

    private Composite compositeRoot;

    private Text textVideoFormatId;

    /**
     * Bundle for multilanguage
     */
    private ResourceBundle l;
    
    private Locale locale ;

    /**
     * Auto-generated main method to display this
     * org.eclipse.swt.widgets.Composite inside a new Shell.
     */
    public static void main(String[] args) {
        ManagmentGui inst = new ManagmentGui();
        inst.showGUI();
        inst.run();
    }

    /**
     * Auto-generated method to display this org.eclipse.swt.widgets.Composite
     * inside a new Shell.
     */
    public void showGUI() {

    }

    public void run() {
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }

    public ManagmentGui() {

        if (logger.isDebugEnabled()) {
            logger.debug("ManagmentGui() Locale: " + Locale.getDefault());
        }

        
        locale = Locale.getDefault();
        
        
        l = PropertyResourceBundle.getBundle(
                "de.hsharz.provirent.managment.gui.language.main", locale);

        //hier muss noch was gemacht werden
        if (l == null) {
            System.exit(-1586);
        }

        display = Display.getDefault();

        shell = new Shell(display);
        shell.setText(l.getString("mainwindow.title"));

        {
            //Register as a resource user - SWTResourceManager will
            //handle the obtaining and disposing of resources
            SWTResourceManager.registerResourceUser(shell);
        }

        //shell.setLayout(new FormLayout());
        shell.setLayout(new FillLayout());

        shell.layout();

        //init the db, so it saves time later
        //does that in a new Thread
        initDB();
        
        //init the rest
        initGUI();

    }

    /**
     *  init the File menu
     */
    private void initFileMenu() {
        if (rootMenu == null) {
            return;
            /**
             * @todo hier muesste eigentlich eine Exception geworfen werden, da
             *       null nich ein darf
             */
        }
        fileMenuItem = new MenuItem(rootMenu, SWT.CASCADE);
        fileMenuItem.setText(l.getString("menu.file"));
        fileMenu = new Menu(fileMenuItem);
        fileMenuItem.setMenu(fileMenu);

        openFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
        openFileMenuItem.setText(l.getString("menu.file.open"));

        newFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
        newFileMenuItem.setText(l.getString("menu.file.new"));

        saveFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
        saveFileMenuItem.setText(l.getString("menu.file.save"));

        closeFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
        closeFileMenuItem.setText(l.getString("menu.file.close"));

        exitMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
        exitMenuItem.setText(l.getString("menu.file.exit"));

    }

    /**
     * init the View Menu
     */
    private void initViewMenu() {
        if (rootMenu == null) {
            return;
            /**
             * @todo hier muesste eigentlich eine Exception geworfen werden, da
             *       null nich ein darf
             */
        }

        viewMenuItem = new MenuItem(rootMenu, SWT.CASCADE);
        viewMenuItem.setText(l.getString("menu.view"));

        viewMenu = new Menu(viewMenuItem);
        viewMenuItem.setMenu(viewMenu);

        viewVideoFormatMenuItem = new MenuItem(viewMenu, SWT.CHECK);
        viewVideoFormatMenuItem.setText(l.getString("menu.view.format"));
        viewVideoFormatMenuItem.setSelection(true);
        viewVideoFormatMenuItem.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
				if(tabItemFormat == null || tabItemFormat.isDisposed()){
				    initFormatTab();
				 return;   
				}
				
				cTabFolderMain.setSelection(tabItemFormat);
				viewVideoFormatMenuItem.setSelection(true);
            
            }
        });

        viewDirectorMenuItem = new MenuItem(viewMenu, SWT.CHECK);
        viewDirectorMenuItem.setText(l.getString("menu.view.director"));
        viewDirectorMenuItem.setSelection(false);

        viewActorMenuItem = new MenuItem(viewMenu, SWT.CHECK);
        viewActorMenuItem.setText(l.getString("menu.view.actor"));
        viewActorMenuItem.setSelection(false);
        
        viewGenreMenuItem = new MenuItem(viewMenu, SWT.CHECK);
        viewGenreMenuItem.setText(l.getString("menu.view.genre"));
        viewActorMenuItem.setSelection(false);

        viewSubtitleMenuItem = new MenuItem(viewMenu, SWT.CHECK);
        viewSubtitleMenuItem.setText(l.getString("menu.view.subtitle"));
        viewSubtitleMenuItem.setSelection(false);
        
        viewLanguageMenuItem = new MenuItem(viewMenu, SWT.CHECK);
        viewLanguageMenuItem.setText(l.getString("menu.view.language"));
        viewLanguageMenuItem.setSelection(false);

        viewStatusMenuItem = new MenuItem(viewMenu, SWT.CHECK);
        viewStatusMenuItem.setText(l.getString("menu.view.status"));
        viewStatusMenuItem.setSelection(false);

        viewConditionMenuItem = new MenuItem(viewMenu, SWT.CHECK);
        viewConditionMenuItem.setText(l.getString("menu.view.condition"));
        viewConditionMenuItem.setSelection(false);

        viewMovieMenuItem = new MenuItem(viewMenu, SWT.CHECK);
        viewMovieMenuItem.setText(l.getString("menu.view.movie"));
        viewMovieMenuItem.setSelection(false);

        viewDvdMenuItem = new MenuItem(viewMenu, SWT.CHECK);
        viewDvdMenuItem.setText(l.getString("menu.view.dvd"));
        viewDvdMenuItem.setSelection(false);

        viewBillMenuItem = new MenuItem(viewMenu, SWT.CHECK);
        viewBillMenuItem.setText(l.getString("menu.view.bill"));
        viewBillMenuItem.setSelection(false);

    }

    /**
     * init the help menu
     */
    private void initHelpMenu() {
        if (rootMenu == null) {
            throw new GuiInitException();
        }
        helpMenuItem = new MenuItem(rootMenu, SWT.CASCADE);
        helpMenuItem.setText(l.getString("menu.help"));
        {
            helpMenu = new Menu(helpMenuItem);
            helpMenuItem.setMenu(helpMenu);
            {
                contentsMenuItem = new MenuItem(helpMenu, SWT.CASCADE);
            }
            {
                aboutMenuItem = new MenuItem(helpMenu, SWT.CASCADE);
            }
        }

    }

    
    private void initFormatTab() {
        tabItemFormat = new CTabItem(cTabFolderMain, SWT.NONE);
        tabItemFormat.setText(l.getString("tab.format.title"));
        {
            compositeFormate = new CompositeFormate(
                cTabFolderMain,
                SWT.NONE, statusLine, locale);
            
            tabItemFormat.setControl(compositeFormate);
        }
    }
    
    private void initRootComposite() {

        //set up the root composite incl. layout
        compositeRoot = new Composite(shell, SWT.NONE);
        GridLayout composite1Layout = new GridLayout();
        composite1Layout.marginWidth = 0;
        composite1Layout.marginHeight = 0;
        composite1Layout.horizontalSpacing = 0;
        composite1Layout.verticalSpacing = 0;
        GridData composite1LData = new GridData();
        compositeRoot.setLayout(composite1Layout);

        composite1LData.verticalAlignment = GridData.FILL;
        composite1LData.horizontalAlignment = GridData.FILL;
        composite1LData.grabExcessHorizontalSpace = true;
        composite1LData.grabExcessVerticalSpace = true;
        compositeRoot.setLayoutData(composite1LData);

        //init the MainComposite
        initMainComposite();
    }
    


    private void initMainComposite(){
        compositeMain = new Composite(compositeRoot, SWT.EMBEDDED);
        GridLayout composite3Layout = new GridLayout();
        composite3Layout.makeColumnsEqualWidth = true;
        composite3Layout.horizontalSpacing = 0;
        composite3Layout.marginHeight = 0;
        composite3Layout.marginWidth = 0;
        composite3Layout.verticalSpacing = 0;
        GridData composite3LData = new GridData();
        compositeMain.setLayout(composite3Layout);
        compositeMain.setForeground(SWTResourceManager.getColor(0,
                255, 0));
        composite3LData.verticalAlignment = GridData.FILL;
        composite3LData.horizontalAlignment = GridData.FILL;
        composite3LData.grabExcessHorizontalSpace = true;
        composite3LData.grabExcessVerticalSpace = true;
        compositeMain.setLayoutData(composite3LData);
    
        //init the MainTabFolder
    }
    
    private void initMainTabFolder() {
        
    }
    
    private void initGUI() {
        try {

            //set't the menu
            rootMenu = new Menu(shell, SWT.BAR);
            shell.setMenuBar(rootMenu);

            //init the other menu's
            initFileMenu();
            initViewMenu();
            initHelpMenu();

            //set the layout for the shell
            FillLayout thisLayout = new FillLayout(SWT.HORIZONTAL);
            shell.setLayout(thisLayout);

            //set the Site
            shell.setSize(MAIN_WINDOW_WIDTH, MAIN_WINDOW_HEIGHT);
            {
                //the root composite
                //this init's the maincomposite
                initRootComposite();
                initStatusComposite();

                {
                    {
                        cTabFolderMain = new CTabFolder(compositeMain, SWT.CLOSE);
                        //cTabFolderMain.setSelection(null);
                        GridData cTabFolder1LData = new GridData();
                        cTabFolder1LData.grabExcessHorizontalSpace = true;
                        cTabFolder1LData.horizontalAlignment = GridData.FILL;
                        cTabFolder1LData.grabExcessVerticalSpace = true;
                        cTabFolder1LData.verticalAlignment = GridData.FILL;
                        cTabFolderMain.setLayoutData(cTabFolder1LData);
                        {
                            initFormatTab();
                            /*
                            tabItemFormat = new CTabItem(cTabFolderMain, SWT.NONE);
                            tabItemFormat.setText("Formate");
                            {
                                compositeFormate = new CompositeFormate(
                                    cTabFolderMain,
                                    SWT.NONE, statusLine, locale);
                                
                                tabItemFormat.setControl(compositeFormate);
                            }
                            */
                        }
                    }
                }
                {
                    //init the Composite for statusline
                    
                    //compositeFormate.setStatusLine(statusLine);

                }
            }
            shell.layout();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    private void initStatusComposite() {
        compositeStatusLine = new Composite(compositeRoot, SWT.EMBEDDED);
        GridLayout composite2Layout = new GridLayout();
        composite2Layout.marginWidth = 0;
        composite2Layout.marginHeight = 0;
        composite2Layout.makeColumnsEqualWidth = true;
        composite2Layout.horizontalSpacing = 0;
        composite2Layout.verticalSpacing = 0;
        GridData composite2LData = new GridData();
        compositeStatusLine.setLayout(composite2Layout);
        composite2LData.horizontalAlignment = GridData.FILL;
        composite2LData.heightHint = 14;
        composite2LData.grabExcessHorizontalSpace = true;
        compositeStatusLine.setLayoutData(composite2LData);

        initStatusLine();

    }

    private void initStatusLine() {
        statusLine = new StatusLineStyledText(compositeStatusLine, SWT.READ_ONLY);
        statusLine.setText("");
        statusLine
                .setToolTipText("Hier finden Sie wichtige Statusinformationen");
        statusLine.setBackground(ColorDef.STATUS_B_STANDARD);
        statusLine.setForeground(ColorDef.STATUS_F_STANDARD);
        statusLine.setDoubleClickEnabled(false);
        statusLine.setEditable(false);
        statusLine.setEnabled(true);
        GridData styledText1LData = new GridData();

        styledText1LData.horizontalAlignment = GridData.FILL;
        styledText1LData.grabExcessHorizontalSpace = true;
        statusLine.setLayoutData(styledText1LData);
    }

    /**
     * Sets a message for the Statusline
     * 
     * @param mode
     * @param message
     */
    private void setStatus(final int mode, final String message) {
        /**
         * mode values 0 normal message 1 information message 2 warn message 3
         * error message
         *  
         */
        if (mode == 0) {
            statusLine.setBackground(ColorDef.STATUS_B_STANDARD);
            statusLine.setForeground(ColorDef.STATUS_F_STANDARD);
        } else if (mode == 1) {
            statusLine.setBackground(ColorDef.STATUS_B_INFO);
            statusLine.setForeground(ColorDef.STATUS_F_INFO);
        } else if (mode == 2) {
            statusLine.setBackground(ColorDef.STATUS_B_WARN);
            statusLine.setForeground(ColorDef.STATUS_F_WARN);
        } else if (mode == 3) {
            statusLine.setBackground(ColorDef.STATUS_B_ERROR);
            statusLine.setForeground(ColorDef.STATUS_F_ERROR);
        }

        statusLine.setText(message);

		new Thread() {
			public void run() {
				
				try {Thread.sleep (1000 *5);} catch (Throwable th) {}
					if (display.isDisposed()) return;
					display.asyncExec(new Runnable() {
						public void run() {
				            statusLine.setBackground(ColorDef.STATUS_B_STANDARD);
				            statusLine.setForeground(ColorDef.STATUS_F_STANDARD);
						}
					});
				
			}
		}.start();

    }

    private void initDB(){
        
		new Thread() {
			public void run() {
			    Database.initDB();
			}
		}.start();

    }
        
    
    
}
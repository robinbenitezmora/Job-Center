import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.Component;
import java.awt.Toolkit;

public class AdminPanel extends JFrame implements ActionListener {

 private static final long serialVersionUID = 1L;

 public static int W_FRAME = 960;

 public static int H_FRAME = 2 * W_FRAME / 3;

 public static java.awt.Insets INSETS;

 private JMenuBar menuBar_menubar;
 private JMenu homePagMenu, recordMenu, viewMenu, billMenu, systemMenu;
 private JMenuItem addEmployerItem, addWorkerItem, addRecordItem, viewRecordItem;
 private JMenuItem viewEmployerItem, viewWorkerItem, billEmployerItem, billWorkerItem;
 private JMenuItem settingItem, resetItem, logoutItem;
 private ArrayList<JPanel> components = new ArrayList<>();
 private int currentComponent = 6;

 public AdminPanel() {
  super("Registration System");
  setIconImage(Toolkit.getDefaultToolkit().getImage("src\\icons\\admin_user.png"));
  setSize(W_FRAME, H_FRAME);
  setResizable(false);
  setLayout(null);
  setLocationRelativeTo(null);
  setLocation(getX() - 40, getY() - 20);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setVisible(true);
  INSETS = getInsets();
  GUI();
 }

 private void GUI() {
  createMenus();
  createComponents();
  init();
 }

 private void createComponents() {
  HomePage homepage = new HomePage();

  AddWorker addWorker = new AddWorker();
  AddRecord addRecord = new AddRecord();
  AddEmployer addEmployer = new AddEmployer();

  ViewWorker viewWorker = new ViewWorker();
  ViewRecord viewRecord = new ViewRecord();
  ViewEmployer viewEmployer = new ViewEmployer();

  BillWorker billWorker = new BillWorker();
  BillEmployer billEmployer = new BillEmployer();

  Setting setting = new Setting();
  Reset reset = new Reset();
  Logout logout = new Logout();

  components.add(homepage);

  components.add(addWorker);
  components.add(addRecord);
  components.add(addEmployer);

  components.add(viewWorker);
  components.add(viewRecord);
  components.add(viewEmployer);

  components.add(billWorker);
  components.add(billEmployer);

  components.add(setting);
  components.add(reset);
  components.add(logout);

  for (Component component : components) {
   add(component);
   component.setVisible(false);
  }

  addWorkerItem.setActionCommand("addWorker");
  addRecordItem.setActionCommand("addRecord");
  addEmployerItem.setActionCommand("addEmployer");

  viewWorkerItem.setActionCommand("viewWorker");
  viewRecordItem.setActionCommand("viewRecord");
  viewEmployerItem.setActionCommand("viewEmployer");

  billWorkerItem.setActionCommand("billWorker");
  billEmployerItem.setActionCommand("billEmployer");

  settingItem.setActionCommand("setting");
  resetItem.setActionCommand("reset");
  logoutItem.setActionCommand("logout");
 }

 private void createMenus() {
  menuBar_menubar = new JMenuBar();
  recordMenu = new JMenu("Record");
  viewMenu = new JMenu("View");
  billMenu = new JMenu("Bill");
  systemMenu = new JMenu("System");

  addWorkerItem = new JMenuItem("New Worker");
  recordMenu.add(addWorkerItem);
  addWorkerItem.addActionListener((java.awt.event.ActionListener) this);

  addRecordItem = new JMenuItem("New Record");
  recordMenu.add(addRecordItem);
  addRecordItem.addActionListener((java.awt.event.ActionListener) this);

  addEmployerItem = new JMenuItem("New Employer");
  recordMenu.add(addEmployerItem);
  addEmployerItem.addActionListener((java.awt.event.ActionListener) this);

  viewWorkerItem = new JMenuItem("View Worker");
  viewMenu.add(viewWorkerItem);
  viewWorkerItem.addActionListener((java.awt.event.ActionListener) this);

  viewRecordItem = new JMenuItem("View Record");
  viewMenu.add(viewRecordItem);
  viewRecordItem.addActionListener((java.awt.event.ActionListener) this);

  viewEmployerItem = new JMenuItem("View Employer");
  viewMenu.add(viewEmployerItem);
  viewEmployerItem.addActionListener((java.awt.event.ActionListener) this);

  billWorkerItem = new JMenuItem("Bill Worker");
  billMenu.add(billWorkerItem);
  billWorkerItem.addActionListener((java.awt.event.ActionListener) this);

  billEmployerItem = new JMenuItem("Bill Employer");
  billMenu.add(billEmployerItem);
  billEmployerItem.addActionListener((java.awt.event.ActionListener) this);

  settingItem = new JMenuItem("Setting");
  systemMenu.add(settingItem);
  settingItem.addActionListener((java.awt.event.ActionListener) this);

  resetItem = new JMenuItem("Reset");
  systemMenu.add(resetItem);
  resetItem.addActionListener((java.awt.event.ActionListener) this);

  logoutItem = new JMenuItem("Logout");
  systemMenu.add(logoutItem);
  logoutItem.addActionListener((java.awt.event.ActionListener) this);

  menuBar_menubar.add(homePagMenu);
  menuBar_menubar.add(recordMenu);
  menuBar_menubar.add(viewMenu);

  menuBar_menubar.add(billMenu);
  menuBar_menubar.add(systemMenu);

  setJMenuBar(menuBar_menubar);
 }

}

 private void init() {
  setContentPane(components.get(currentComponent));
 }

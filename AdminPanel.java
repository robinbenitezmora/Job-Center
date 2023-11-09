import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import javafx.geometry.Insets;
import java.awt.Toolkit;
import javafx.geometry.Insets;

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
 private HomePage homepage;

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

 private void init() {
 }

 private void createComponents() {
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

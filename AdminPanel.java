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
 }
}

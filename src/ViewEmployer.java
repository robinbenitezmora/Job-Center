package src;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import javafx.event.ActionEvent;

public class ViewEmployer extends JPanel {
  JButton newSearchButton, searchButton;
  JTextField searchBoxText;
  JPanel searchButtoPanel;
  JLabel serchBoxInfoMessageLabel, searchBoxTitleLabel;

  private String[][] employers;

  public ViewEmployer() {
    setLayout(null);

    newSearchButton = new JButton("New Search");
    newSearchButton.setFocusPainted(false);
    newSearchButton.setBounds(10, 535, 150, 30);
    newSearchButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
      }
    });
    this.add(newSearchButton);

    this.removeAll();
    searchBoxText = new JTextField();
    searchBoxText.setBounds(250, 150, 420, 30);
    searchBoxText.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
    searchBoxText.setHorizontalAlignment(SwingConstants.CENTER);
    searchBoxText.addCaretListener(new CaretListener() {
      @Override
      public void caretUpdate(CaretEvent e) {
        if (searchBoxText.getText().length() > 0) {
          updateButtonPanel(((JTextField) e.getSource()).getText());
        } else {
          searchButtoPanel.setVisible(false);
        }
      }
    });

    searchBoxText.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        searchButton.doClick();
      }

      public void actionPerformed(ActionEvent e) {
        // TODO: Implement the action to be performed when the searchBoxText is updated
      }
    });

    this.add(searchBoxText);

    searchButton = new JButton("Search");
    searchButton.setBounds(searchBoxText.getX() + searchBoxText.getWidth() + 1, searchBoxText.getY(), 80, 30);
    searchButton.setBackground(new Color(212, 212, 212));
    searchButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        searchResultsGUI(searchBoxText.getText().toUpperCase());
      }

      public void actionPerformed(ActionEvent e) {
        // TODO: Implement the action to be performed when the search button is clicked
      }
    });
    this.add(searchButton);

    JLabel searchBoxInfoMessageLabel = new JLabel(
        "If you want to see all employers, leave the field blank and press the Search button");
    searchBoxInfoMessageLabel.setFont(new Font(Font.DIALOG, Font.ITALIC, 9));
    searchBoxInfoMessageLabel.setBounds(searchBoxText.getX(), searchBoxText.getY() + searchBoxText.getHeight() + 1, 420,
        10);
    serchBoxInfoMessageLabel.setForeground(new Color(0, 190, 0));
    searchBoxInfoMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
    this.add(searchBoxInfoMessageLabel);

    searchBoxTitleLabel = new JLabel("Search for an employer");
    searchBoxTitleLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
    searchBoxTitleLabel.setBounds(searchBoxText.getX(), searchBoxText.getY() - 20, 420, 20);
    searchBoxTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    searchBoxInfoMessageLabel.setForeground(new Color(38, 38, 38));
    this.add(searchBoxTitleLabel);

    searchButtoPanel = new JPanel();
    searchButtoPanel.setBounds(searchBoxText.getX(), searchBoxText.getY() + searchBoxText.getHeight() + 1, 420, 30);
    searchButtoPanel.setBackground(new Color(255, 255, 255));
    searchButtoPanel.setLayout(null);
    searchButtoPanel.setVisible(true);
    this.add(searchButtoPanel);

    this.revalidate();
    this.repaint();
  }

  void viewGUI(String employer) {
    this.removeAll();
    JTable t_isTable;
    String[] columNames = { "ID", "Employer", "Date", "Number of worker", "paid" };
    String[][] rows = { { "r1c1", "r1c2", "sdf", "r1c3", "r1c4" }, { "r2c1", "r2c2", "r2c3", "r2c4" },
        { "r3c1", "r3c2", "r3c3", "r3c4" },
        { "r4c1", "r4c2", "r4c3", "r4c4" }, { "r5c1", "r5c2", "r5c3", "r5c4" }, { "r6c1", "r6c2", "r6c3", "r1c6n" },
        { "r4c1", "r4c2", "r4c3", "r4c4" }, { "r5c1", "r5c2", "r5c3", "r5c4" }, { "r6c1", "r6c2", "r6c3", "r1c6n" },
        { "r4c1", "r4c2", "r4c3", "r4c4" }, { "r5c1", "r5c2", "r5c3", "r5c4" }, { "r6c1", "r6c2", "r6c3", "r1c6n" } };
    t_isTable = new JTable(rows, columNames) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }

      DefaultTableCellRenderer render = new DefaultTableCellRenderer();
      {
        render.setHorizontalAlignment(SwingConstants.CENTER);
      }

      public TableCellRenderer gTableCellRenderer(int row, int column) {
        return render;
      }
    };

    t_isTable.getColumnModel().getColumn(0).setPreferredWidth(5);
    t_isTable.getColumnModel().getColumn(1).setPreferredWidth(100);
    t_isTable.getColumnModel().getColumn(2).setPreferredWidth(50);
    t_isTable.getColumnModel().getColumn(3).setPreferredWidth(5);
    t_isTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

    t_isTable.setRowHeight(30);

    JScrollPane js_isTable = new JScrollPane(t_isTable);
    js_isTable.setBounds(175, 30, 600, 200);
    this.add(js_isTable);

    this.revalidate();
    this.repaint();
  }

  void searchResultsGUI(String searchText) {
    this.removeAll();
    this.add(newSearchButton);

    DefaultListModel<String> searchResultsListModel = new DefaultListModel<String>();
    for (int i = 0; i < employers.length; i++) {
      searchResultsListModel.addElement(employers[i][1]);
    }

    String[] temp = new String[searchResultsListModel.getSize()];
    searchResultsListModel.copyInto(temp);
    Arrays.sort(temp);

    searchResultsListModel = new DefaultListModel<String>();
    for (int i = 0; i < temp.length; i++) {
      searchResultsListModel.addElement(temp[i]);
    }

    JList<String> searchResultsList = new JList<String>(searchResultsListModel);
    searchResultsList.setBackground(new Color(220, 220, 220));

    DefaultListCellRenderer renderer = (DefaultListCellRenderer) searchResultsList.getCellRenderer();
    renderer.setHorizontalAlignment(SwingConstants.CENTER);

    searchResultsList.setFixedCellHeight(35);
    searchResultsList.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
          viewGUI(searchResultsList.getSelectedValue());
        }
      }
    });

    MyScrollPane searchResultsScroll = new MyScrollPane(searchResultsList);
    searchResultsScroll.setBounds(0, 40, 800, 200);
    this.add(searchResultsScroll);

    JLabel scrollBottomInfo = new JLabel("Double click on the person you want to select");
    scrollBottomInfo.setBounds(searchResultsScroll.getX(), searchResultsScroll.getY() + searchResultsScroll.getHeight(),
        searchResultsScroll.getWidth(), 12);
    scrollBottomInfo.setFont(new Font(Font.DIALOG, Font.ITALIC, 10));
    scrollBottomInfo.setForeground(new Color(0, 180, 0));

    this.add(scrollBottomInfo);

    this.revalidate();
    this.repaint();
  }

  protected void updateButtonPanel(String text) {
    searchButtoPanel.removeAll();

    int pos = 0;
    for (int i = 0; i < (employers == null ? 0 : employers.length); i++) {
      if (employers[i][1].contains(text.toUpperCase())) {
        searchButtoPanel.add(getBottomComponent(employers[i][1].toUpperCase(), pos));
        searchButtoPanel.add(new JButton());
        pos++;
      }
    }

    searchButtoPanel.setSize(500, (pos > 10 ? 10 : pos) * 30);
    searchButtoPanel.setVisible(true);

    this.repaint();
  }

  private Component getBottomComponent(String string, int position) {
    Component comp = null;

    if (string.equals("")) {

      JButton button = new JButton("Choose");
      button.setBounds(421, position * 29, 80, 28);
      button.setName(string + position);
      button.setFocusPainted(false);
      button.setBackground(new Color(214, 214, 214));
      button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
          // TODO Auto-generated method stub
          throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
          int compIndex = Integer.parseInt(((JButton) e.getSource()).getName());
          viewGUI(((JTextField) searchButtoPanel.getComponent(compIndex * 2)).getText());
        }

      });

      comp = button;

    } else {

      JTextField tf = new JTextField(string);
      tf.setHorizontalAlignment(SwingConstants.CENTER);
      tf.setEditable(false);
      tf.setBackground(new Color(238, 238, 238));
      tf.setBorder(new LineBorder(Color.white));
      tf.setBounds(0, position * 29, 420, 28);
      tf.addMouseListener(new MouseAdapter() {
        public void mouseExited(MouseEvent e) {
          tf.setBackground(new Color(238, 238, 238));
        }

        public void mouseEntered(MouseEvent e) {
          tf.setBackground(Color.WHITE);
        }

        public void mouseClicked(MouseEvent e) {
          viewGUI(((JTextField) e.getSource()).getText());
        }
      });

      comp = tf;

    }

    return comp;
  }

  public void setEmployers(String[][] employers) {
    this.employers = employers;
  }
}

package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

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
  newSearchButton.setBackground(new Color(255, 255, 255));
  newSearchButton.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    GUI();
   }
  });
  GUI();

 void GUI() {
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
}

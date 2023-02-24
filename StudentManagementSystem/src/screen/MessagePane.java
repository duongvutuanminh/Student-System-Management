package screen;

import javax.swing.JOptionPane;

public class MessagePane {
  public static void displayMessage(String[] args) {
    JOptionPane optionPane = new JOptionPane("Connnection Succeed!", JOptionPane.INFORMATION_MESSAGE);
    optionPane.createDialog("Redirecting").setVisible(true);
    optionPane.getTopLevelAncestor().setVisible(false);
  }
}

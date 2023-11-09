package test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HiddenItemListApp {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel[] itemList;
    private JTextField textField;
    private JButton showButton;

    public HiddenItemListApp() {
        frame = new JFrame("Hidden Item List App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 1));

        itemList = new JPanel[20];
        for (int i = 0; i < itemList.length; i++) {
            itemList[i] = createHiddenItemPanel("Item " + (i + 1));
            itemList[i].setVisible(false);
            mainPanel.add(itemList[i]);
        }

        textField = new JTextField(15);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    showItem();
                }
            }
        });

        showButton = new JButton("Show Item");
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showItem();
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Text: "));
        inputPanel.add(textField);
        inputPanel.add(showButton);

        frame.getContentPane().add(BorderLayout.NORTH, inputPanel);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        frame.setVisible(true);
    }

    private JPanel createHiddenItemPanel(String itemName) {
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BorderLayout());
        itemPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel nameLabel = new JLabel(itemName);
        itemPanel.add(nameLabel, BorderLayout.CENTER);

        return itemPanel;
    }

    private void showItem() {
        String enteredText = textField.getText();

        for (JPanel itemPanel : itemList) {
            if (!itemPanel.isVisible()) {
                JLabel nameLabel = (JLabel) itemPanel.getComponent(0);
                nameLabel.setText(enteredText);
                itemPanel.setVisible(true);
                break;  // Show only the first hidden item
            }
        }

        textField.setText("");  // Clear the text field
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HiddenItemListApp();
            }
        });
    }
}

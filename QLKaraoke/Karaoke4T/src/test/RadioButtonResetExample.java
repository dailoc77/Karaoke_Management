package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonResetExample {
	private ButtonGroup bg;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("RadioButton Reset Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        ButtonGroup bg = new ButtonGroup();
        JRadioButton radioButton1 = new JRadioButton("Option 1");
        JRadioButton radioButton2 = new JRadioButton("Option 2");
        bg.add(radioButton2);
        bg.add(radioButton1);
        JButton resetButton = new JButton("Reset");

        // Thêm ActionListener cho nút reset
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Đặt lại lựa chọn của các JRadioButton về trạng thái mặc định
                bg.clearSelection();
            }
        });

        panel.add(radioButton1);
        panel.add(radioButton2);
        panel.add(resetButton);

        frame.add(panel);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

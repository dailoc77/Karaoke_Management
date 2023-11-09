package test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class CustomerCodeGenerator extends JFrame {
    private int customerCount = 0;
    private JTextField customerCodeField;
    private JButton generateButton;
    private Set<String> generatedCodes = new HashSet<>();

    public CustomerCodeGenerator() {
        setTitle("Generate Customer Code");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        customerCodeField = new JTextField(12);
        customerCodeField.setEditable(false);
        generateButton = new JButton("Generate Customer Code");

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerCount++;
                String customerCode = generateCustomerCode(customerCount);

                if (!generatedCodes.contains(customerCode)) {
                    generatedCodes.add(customerCode);
                    customerCodeField.setText(customerCode);
                } else {
                    JOptionPane.showMessageDialog(CustomerCodeGenerator.this, "Mã khách hàng đã tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(customerCodeField);
        panel.add(generateButton);

        add(panel);
    }

    private String generateCustomerCode(int count) {
        return "KHAA" + String.format("%03d", count);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CustomerCodeGenerator().setVisible(true);
            }
        });
    }
}


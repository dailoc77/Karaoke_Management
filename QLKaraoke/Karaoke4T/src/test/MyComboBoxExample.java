package test;

import javax.swing.*;

import org.w3c.dom.Entity;

import Entity.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyComboBoxExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JComboBox Example");

        // Tạo một mảng chứa dữ liệu cho JComboBox
        String[] data = {"Option 1", "Option 2", "Option 3", "Option 4"};

        // Tạo một DefaultComboBoxModel với dữ liệu từ mảng
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(data);

        // Tạo JComboBox và thiết lập mô hình dữ liệu cho nó
        JComboBox<String> comboBox = new JComboBox<>(model);

        // Tạo một nút để thêm dữ liệu mới vào JComboBox
        JButton addButton = new JButton("Add Item");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy dữ liệu từ người dùng (có thể thay đổi thành cách khác tùy thuộc vào yêu cầu của bạn)
                String newItem = JOptionPane.showInputDialog(frame, "Enter new item:");

                // Thêm mục mới vào mô hình dữ liệu của JComboBox
                model.addElement(newItem);
            }
        });

        // Tạo panel và thêm JComboBox và JButton vào panel
        JPanel panel = new JPanel();
        panel.add(comboBox);
        panel.add(addButton);

        // Thêm panel vào frame
        frame.add(panel);

        // Cấu hình frame
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

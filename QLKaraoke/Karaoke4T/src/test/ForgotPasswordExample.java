package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgotPasswordExample extends JFrame {

    public ForgotPasswordExample() {
        setTitle("Quên mật khẩu");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);
        JButton submitButton = new JButton("Gửi yêu cầu đặt lại mật khẩu");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                if (isValidEmail(email)) {
                    // Gửi email chứa liên kết đặt lại mật khẩu
                    // Ở đây, bạn có thể triển khai việc gửi email bằng JavaMail hoặc sử dụng dịch vụ của bên thứ ba
                    // ...

                    // Hiển thị thông báo rằng yêu cầu đã được gửi
                    JOptionPane.showMessageDialog(ForgotPasswordExample.this, "Yêu cầu đặt lại mật khẩu đã được gửi đến " + email);
                } else {
                    JOptionPane.showMessageDialog(ForgotPasswordExample.this, "Vui lòng nhập một địa chỉ email hợp lệ.");
                }
            }
        });

        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(submitButton);

        add(panel);
        setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hình
        setVisible(true);
    }

    private boolean isValidEmail(String email) {
        // Kiểm tra xem địa chỉ email có hợp lệ không (đơn giản, chỉ kiểm tra có chứa '@')
        return email.contains("@");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ForgotPasswordExample());
    }
}


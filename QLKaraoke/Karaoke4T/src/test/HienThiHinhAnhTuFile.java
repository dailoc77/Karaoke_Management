package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

public class HienThiHinhAnhTuFile extends JFrame {
    private JLabel label;

    public HienThiHinhAnhTuFile() {
        // Tạo JLabel để hiển thị hình ảnh
        label = new JLabel();
        
        // Tạo nút để mở hộp thoại chọn tệp
        JButton openButton = new JButton("Chọn ảnh");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tạo một hộp thoại chọn tệp
                JFileChooser fileChooser = new JFileChooser("C:\\HOCTAP\\PhatTrienUngDung\\GIT_DUAN\\PTUD_2023_Nhom07_DHKTPM17ATT\\QLKaraoke\\Karaoke4T\\src\\Imgs");
                fileChooser.setFileFilter(new FileNameExtensionFilter("Hình ảnh", "jpg", "png", "gif", "bmp"));

                // Hiển thị hộp thoại chọn tệp và lấy đường dẫn tệp đã chọn
                int result = fileChooser.showOpenDialog(HienThiHinhAnhTuFile.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    hienThiHinhAnh(selectedFile);
                }
            }
        });

        // Tạo JPanel để chứa JLabel và JButton
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);
        panel.add(openButton, BorderLayout.SOUTH);

        // Thêm JPanel vào JFrame
        add(panel);

        // Cài đặt kích thước của JFrame và chế độ đóng
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        // Hiển thị JFrame
        setVisible(true);
    }

    private void hienThiHinhAnh(File file) {
        // Tạo một đối tượng ImageIcon từ tệp hình ảnh đã chọn
        ImageIcon icon = new ImageIcon(file.getAbsolutePath());
        // Cài đặt hình ảnh cho JLabel
        label.setIcon(icon);
    }

    public static void main(String[] args) {
        // Chạy ứng dụng trong luồng EDT (Event Dispatch Thread)
        SwingUtilities.invokeLater(() -> new HienThiHinhAnhTuFile());
    }
}

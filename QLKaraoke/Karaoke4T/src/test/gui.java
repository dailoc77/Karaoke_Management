package test;

import javax.swing.*;
import java.util.List;

public class gui {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JComboBox Example");

        // Tạo một DefaultComboBoxModel để chứa dữ liệu từ DAO
        DefaultComboBoxModel<en> model = new DefaultComboBoxModel<>();

        // Sử dụng DAO để lấy dữ liệu từ cơ sở dữ liệu
        dao loaiNhanVienDAO = new dao();
        List<en> danhSachLoaiNV = loaiNhanVienDAO.getAllLoaiNhanVien();
        for (en loaiNhanVien : danhSachLoaiNV) {
            model.addElement(loaiNhanVien);
        }

        // Tạo JComboBox và thiết lập mô hình dữ liệu cho nó
        JComboBox<en> comboBox = new JComboBox<>(model);

        // Tạo panel và thêm JComboBox vào panel
        JPanel panel = new JPanel();
        panel.add(comboBox);

        // Thêm panel vào frame
        frame.add(panel);

        // Cấu hình frame
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

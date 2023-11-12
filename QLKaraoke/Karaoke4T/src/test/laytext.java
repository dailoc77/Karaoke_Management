package test;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Entity.LoaiPhong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

public class laytext extends JFrame{
	private LoaiPhong loaiPhong;
	private JComboBox<String> comboBox;
	private JTextField txtten;
	private JTextField textField;
	
	public laytext() {
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(70, 145, 134, 45);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(70, 74, 134, 37);
		
		getContentPane().add(comboBox);
		loadComBoBoxLoaiPhong();
		
		
	}
	public static void main(String[] args) {
		laytext lx = new laytext();
		lx.setVisible(true);
		
	}
	public void loadComBoBoxLoaiPhong() {

		// Thông tin kết nối đến cơ sở dữ liệu
        String url = "jdbc:sqlserver://localhost:1433;databasename=Karaoke4T";
        String username = "sa";
        String password = "123";

        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DriverManager.getConnection(url, username, password);

            // Truy vấn SQL để lấy dữ liệu
            String sql = "SELECT * FROM LoaiPhong";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Lặp qua các dòng kết quả và thêm vào JComboBox
            while (resultSet.next()) {
            	comboBox = new JComboBox<String>();
                String columnName = resultSet.getString("tenLoaiPhong");
                comboBox.addItem(columnName);
            }

            // Đóng các tài nguyên
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}

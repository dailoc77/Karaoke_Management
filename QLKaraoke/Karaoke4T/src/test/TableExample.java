//package test;
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableCellEditor;
//import javax.swing.table.TableCellRenderer;
//import javax.swing.text.DefaultFormatterFactory;
//import javax.swing.text.NumberFormatter;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class TableExample extends JFrame {
//    private DefaultTableModel model;
//    private JTable table;
//
//    public TableExample() {
//        // Tạo model cho JTable
//        model = new DefaultTableModel();
//        model.addColumn("Mã DV");
//        model.addColumn("Tên DV");
//        model.addColumn("Giá DV");
//        model.addColumn("Số lượng");
//
//        // Tạo JTable với model và cột kiểu JSpinner cho cột số lượng
//        table = new JTable(model) {
//            @Override
//            public Class<?> getColumnClass(int column) {
//                return column == 3 ? Integer.class : Object.class;
//            }
//
//            @Override
//            public TableCellRenderer getCellRenderer(int row, int column) {
//                if (column == 3) {
//                    return getDefaultRenderer(Integer.class);
//                }
//                return super.getCellRenderer(row, column);
//            }
//
//            @Override
//            public TableCellEditor getCellEditor(int row, int column) {
//                if (column == 3) {
//                    return new DefaultCellEditor(new JSpinner());
//                }
//                return super.getCellEditor(row, column);
//            }
//        };
//
//        // Tạo JScrollPane để hiển thị JTable nếu có quá nhiều dữ liệu
//        JScrollPane scrollPane = new JScrollPane(table);
//        getContentPane().add(scrollPane);
//
//        // Tạo JPanel chứa nút "Thêm" và "Bớt"
//        JPanel buttonPanel = new JPanel();
//        JButton addButton = new JButton("Thêm");
//        JButton removeButton = new JButton("Bớt");
//
//        addButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Thêm một hàng mới vào bảng với số lượng mặc định là 1
//                model.addRow(new Object[]{"Mã mới", "Tên mới", "Giá mới", 1});
//            }
//        });
//
//        removeButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Kiểm tra xem có hàng được chọn không
//                int selectedRow = table.getSelectedRow();
//                if (selectedRow != -1) {
//                    // Giảm số lượng và cập nhật lại giá trị trong bảng
//                    int quantity = (int) model.getValueAt(selectedRow, 3);
//                    if (quantity > 1) {
//                        model.setValueAt(quantity - 1, selectedRow, 3);
//                    } else {
//                        // Nếu số lượng là 1, xóa dòng khỏi bảng
//                        model.removeRow(selectedRow);
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(null, "Chọn một hàng để bớt!");
//                }
//            }
//        });
//
//        buttonPanel.add(addButton);
//        buttonPanel.add(removeButton);
//
//        // Thêm JPanel chứa nút "Thêm" và "Bớt" vào JFrame
//        getContentPane().add(BorderLayout.SOUTH, buttonPanel);
//
//        // Cài đặt các thuộc tính của JFrame
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setTitle("Quản lý dịch vụ");
//        pack();
//        setLocationRelativeTo(null);
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new TableExample();
//            }
//        });
//    }
//}

package test;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonIconInTableExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Button Icon In Table Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            DefaultTableModel model = new DefaultTableModel(new Object[][]{
                {1, "Thêm"},
                {2, "Thêm"},
        }, new Object[]{"số Lượng", "Thêm", "Bớt", "Xóa"});

        JTable table = new JTable(model);
        table.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(1).setCellEditor(new ButtonEditor(table));
        table.getColumnModel().getColumn(2).setCellRenderer(new BotoRenderer());
        table.getColumnModel().getColumn(2).setCellEditor(new BotoEditor(table));
        table.getColumnModel().getColumn(3).setCellRenderer(new XoaRenderer());
        table.getColumnModel().getColumn(3).setCellEditor(new XoaEditor(table));

            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane, BorderLayout.CENTER);

            frame.setSize(500, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    static class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    static class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private JTable table;

        public ButtonEditor(JTable table) {
            super(new JCheckBox());
            this.table = table;
            button = new JButton(new ImageIcon("plus.png"));
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = table.getSelectedRow();
                    int currentValue = (int) table.getValueAt(row, 0);
                    table.setValueAt(currentValue + 1, row, 0);
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return button;
        }
    }

    static class ThemRenderer extends JButton implements TableCellRenderer {
        public ThemRenderer() {
            setOpaque(true);
            setIcon(new ImageIcon("plus.png"));
            setToolTipText("Thêm");
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    static class ThemEditor extends DefaultCellEditor {
        private JButton button;
        private JTable table;

        public ThemEditor(JTable table) {
            super(new JCheckBox());
            this.table = table;
            button = new JButton(new ImageIcon("plus.png"));
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = table.getSelectedRow();
                    int currentValue = (int) table.getValueAt(row, 0);
                    table.setValueAt(currentValue + 1, row, 0);
                    
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return button;
        }
    }

    static class BotoRenderer extends JButton implements TableCellRenderer {
        public BotoRenderer() {
            setOpaque(true);
            setIcon(new ImageIcon("remove"));
            setToolTipText("Bớt");
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    static class BotoEditor extends DefaultCellEditor {
        private JButton button;
        private JTable table;

        public BotoEditor(JTable table) {
            super(new JCheckBox());
            this.table = table;
            button = new JButton(new ImageIcon("remove.png"));
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = table.getSelectedRow();
                    int currentValue = (int) table.getValueAt(row, 0);
                    table.setValueAt(currentValue - 1, row, 0);
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return button;
        }
    }

    static class XoaRenderer extends JButton implements TableCellRenderer {
        public XoaRenderer() {
            setOpaque(true);
            setIcon(new ImageIcon("delete.png"));
            setToolTipText("Xóa");
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    static class XoaEditor extends DefaultCellEditor {
        private JButton button;
        private JTable table;

        public XoaEditor(JTable table) {
            super(new JCheckBox());
            this.table = table;
            button = new JButton(new ImageIcon("delete.png"));
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = table.getSelectedRow();
                    if (row != -1) {
                        ((DefaultTableModel) table.getModel()).removeRow(row);
                    }
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return button;
        }
    }
}
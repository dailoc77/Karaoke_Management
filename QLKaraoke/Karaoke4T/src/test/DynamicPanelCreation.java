package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DynamicPanelCreation extends JFrame implements Serializable {
    private int panelCount = 0;
    private JPanel panel;

    public DynamicPanelCreation() {
        setTitle("Dynamic Panel Creation");
        setSize(983, 413);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo nút để tạo một panel mới
        JButton createPanelButton = new JButton("Tạo Panel Mới");
        createPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewPanel();
            }
        });
        getContentPane().setLayout(null);

        // Thêm nút vào frame
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 0, 969, 31);
        buttonPanel.add(createPanelButton);

        // Thêm panel chứa nút vào frame
        getContentPane().add(buttonPanel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(162, 72, 680, 261);
        getContentPane().add(scrollPane);
        
        panel = new JPanel();
        scrollPane.setViewportView(panel);
        panel.setLayout(new GridLayout(0, 3, 0, 0));
        // Load panels when the application starts
        loadPanels();

        // Save panels when the application is closed
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                savePanels();
            }
        });
    }

    private void createNewPanel() {
        panelCount++;

        // Tạo một JPanel mới
        JPanel newPanel = new JPanel();
        newPanel.setBackground(Color.LIGHT_GRAY);
        newPanel.setLayout(null);
        newPanel.setPreferredSize(new Dimension(100,100));
        newPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        newPanel.add(new JLabel("Panel #" + panelCount));

        // Thêm panel mới vào frame
       	panel.add(newPanel);

        // Cập nhật giao diện
        revalidate();
        repaint();
    }
    private void savePanels() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("panels.ser"))) {
            oos.writeObject(panelCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPanels() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("panels.ser"))) {
            panelCount = (int) ois.readObject();

            for (int i = 1; i <= panelCount; i++) {
                createNewPanel();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DynamicPanelCreation().setVisible(true);
            }
        });
    }
}
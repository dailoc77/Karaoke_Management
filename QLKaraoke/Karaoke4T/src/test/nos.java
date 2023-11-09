package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class nos extends JFrame implements Serializable {
    private static final long serialVersionUID = 1L;

    private int panelCount = 0;
    private JPanel panel;

    public nos() {
        setTitle("Dynamic Panel Creation");
        setSize(983, 413);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton createPanelButton = new JButton("Create New Panel");
        createPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewPanel();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createPanelButton);

        JScrollPane scrollPane = new JScrollPane();
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        scrollPane.setViewportView(panel);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

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

        JPanel newPanel = new JPanel();
        newPanel.setBackground(Color.LIGHT_GRAY);
        newPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        newPanel.add(new JLabel("Panel #" + panelCount));

        panel.add(newPanel);
        pack();
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
            @Override
            public void run() {
                new nos().setVisible(true);
            }
        });
    }
}

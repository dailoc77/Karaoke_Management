package GiaoDien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.RenderingHints;

import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.border.LineBorder;


public class GD_Main_QL extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblClock;
	private Timer timer;
	private JButton jButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_Main_QL frame = new GD_Main_QL();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public GD_Main_QL() {
		setBackground(Color.WHITE);
		setTitle("Giao Diện Quản Lý");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1175, 650);
		
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel box_clock = new JPanel();
        box_clock.setBounds(34, 10, 260, 50);
        box_clock.setBorder(new LineBorder(Color.BLACK));
        contentPane.add(box_clock);
        box_clock.setLayout(null);

        lblClock = new JLabel();
        lblClock.setHorizontalAlignment(SwingConstants.CENTER);
        lblClock.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblClock.setBounds(0, 0, 260, 50);
        lblClock.setOpaque(true);
        lblClock.setBackground(Color.WHITE);
        box_clock.add(lblClock);

        timer = new Timer(0, this);
        timer.start();
		
		JPanel phonghat = new JPanel();
		phonghat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		phonghat.setBorder(null);
		phonghat.setBackground(new Color(0, 0, 0, 150));
		phonghat.setBounds(0, 70, 232, 80);
		contentPane.add(phonghat);
		phonghat.setLayout(null);
		
		JLabel lblphonghat = new JLabel("Phòng Hát");
		lblphonghat.setForeground(Color.WHITE);
		lblphonghat.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblphonghat.setHorizontalAlignment(SwingConstants.CENTER);
		lblphonghat.setBounds(0, 0, 232, 80);
		phonghat.add(lblphonghat);
		
		JPanel dichvu = new JPanel();
		dichvu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dichvu.setLayout(null);
		dichvu.setBorder(null);
		dichvu.setBackground(new Color(0, 0, 0, 150));
		dichvu.setBounds(229, 70, 232, 80);
		contentPane.add(dichvu);
		
		JLabel lbldichvu = new JLabel("Dịch Vụ");
		lbldichvu.setHorizontalAlignment(SwingConstants.CENTER);
		lbldichvu.setForeground(Color.WHITE);
		lbldichvu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbldichvu.setBounds(0, 0, 232, 80);
		dichvu.add(lbldichvu);
		
		JPanel nhanvien = new JPanel();
		nhanvien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		nhanvien.setLayout(null);
		nhanvien.setBorder(null);
		nhanvien.setBackground(new Color(0, 0, 0, 150));
		nhanvien.setBounds(462, 70, 232, 80);
		contentPane.add(nhanvien);
		
		JLabel lblnhanvien = new JLabel("Nhân Viên");
		lblnhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		lblnhanvien.setForeground(Color.WHITE);
		lblnhanvien.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblnhanvien.setBounds(0, 0, 232, 80);
		nhanvien.add(lblnhanvien);
		
		JPanel taikhoan = new JPanel();
		taikhoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		taikhoan.setLayout(null);
		taikhoan.setBorder(null);
		taikhoan.setBackground(new Color(0, 0, 0, 150));
		taikhoan.setBounds(695, 70, 232, 80);
		contentPane.add(taikhoan);
		
		JLabel lbltaikhoan = new JLabel("Tài Khoản");
		lbltaikhoan.setHorizontalAlignment(SwingConstants.CENTER);
		lbltaikhoan.setForeground(Color.WHITE);
		lbltaikhoan.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbltaikhoan.setBounds(0, 0, 232, 80);
		taikhoan.add(lbltaikhoan);
		
		JPanel thongke = new JPanel();
		thongke.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		thongke.setLayout(null);
		thongke.setBorder(null);
		thongke.setBackground(new Color(0, 0, 0, 150));
		thongke.setBounds(928, 70, 233, 80);
		contentPane.add(thongke);
		
		JLabel lblthongke = new JLabel("Thống Kê");
		lblthongke.setHorizontalAlignment(SwingConstants.CENTER);
		lblthongke.setForeground(Color.WHITE);
		lblthongke.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblthongke.setBounds(0, 0, 232, 80);
		thongke.add(lblthongke);
		
		JLabel lblquanly = new JLabel("QL:");
		lblquanly.setForeground(Color.WHITE);
		lblquanly.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblquanly.setBounds(878, -20, 232, 80);
		contentPane.add(lblquanly);
		
		JLabel lbltenql = new JLabel("Nguyễn Văn A");
		lbltenql.setForeground(Color.WHITE);
		lbltenql.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbltenql.setBounds(833, 6, 232, 80);
		contentPane.add(lbltenql);
		
		JLabel lblavatar = new JLabel("");
		lblavatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblavatar.setIcon(new ImageIcon(GD_Main_QL.class.getResource("/Imgs/t1 1.png")));
		lblavatar.setBounds(90, -444, 1333, 957);
		contentPane.add(lblavatar);
	
		JLabel lblhinhnen = new JLabel("");
		lblhinhnen.setHorizontalAlignment(SwingConstants.CENTER);
		lblhinhnen.setIcon(new ImageIcon(GD_Main_NV.class.getResource("/Imgs/370.png")));
		lblhinhnen.setBounds(-95, -176, 1333, 957);
		contentPane.add(lblhinhnen);
		
		JButton jButton = new JButton("Đăng Xuất");
		jButton.setBounds(980, 13, 135, 42);
		jButton.setFont(new Font("Tahoma ", Font.BOLD, 14));
		jButton.setBackground(new Color(255, 0, 0));
		jButton.setForeground(Color.WHITE);
	
		jButton.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
        jButton.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
        jButton.setContentAreaFilled(false);
        jButton.setFocusPainted(false);
        jButton.setOpaque(true);
		contentPane.add(jButton);

		jButton.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        jButton.setBackground(Color.BLACK);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        jButton.setBackground(new Color(255, 0, 0));
		    }
		});

		jButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất!", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		            GD_Login lg = new GD_Login();
		            lg.setVisible(true);
		            lg.setLocationRelativeTo(null);
		            dispose();
		        }
		    }
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
            // Cập nhật thời gian
            updateClock();
        }
	}
	//dong ho
    private void updateClock() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH)+1;
        int year = cal.get(Calendar.YEAR);
        
        String ampm;
        if (hour >= 12) {
            ampm = "PM";
            if (hour > 24) {
                hour -= 12;
            }
        } else {
            ampm = "AM";
            if (hour == 0) {
                hour = 12;
            }
        }
        
        String time = String.format("%02d:%02d:%02d %s  %02d/%02d/%04d", hour, minute, second, ampm, day, month, year);
        lblClock.setText(time);
    }
}


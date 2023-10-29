package GiaoDien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import javax.swing.JButton;

public class GD_Main_NV extends JFrame implements ActionListener{
	private JLabel time = new JLabel ();
    private SimpleDateFormat sdf = new SimpleDateFormat ("hh:mm:ss dd/MM/yyyy");
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_Main_NV frame = new GD_Main_NV();
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
	
	public GD_Main_NV() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1175, 650);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel dangxuat = new JPanel();
		LineBorder lineBorder =new LineBorder(Color.RED, 10, true);
		dangxuat.setBorder(lineBorder );
		dangxuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dangxuat.setBorder(null);
		dangxuat.setBackground(new Color(255, 0, 0));
		dangxuat.setBounds(1011, 10, 140, 50);
		contentPane.add(dangxuat);
		dangxuat.setLayout(null);
		
		JLabel lblDangXuat = new JLabel("Đăng Xuất");
		lblDangXuat.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDangXuat.setForeground(new Color(255, 255, 255));
		lblDangXuat.setBounds(0, 0, 140, 50);
		lblDangXuat.setHorizontalAlignment(SwingConstants.CENTER);
		dangxuat.add(lblDangXuat);
		
		JPanel box_clock = new JPanel();
		box_clock.setBorder(null);
		box_clock.setBackground(new Color(0, 0, 0));
		box_clock.setBounds(34, 10, 260, 50);
		contentPane.add(box_clock);
		box_clock.setLayout(null);
		start ();
		
		
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setFont(new Font("Tahoma", Font.PLAIN, 20));
		time.setForeground(new Color(255, 255, 255));
		time.setBounds(10, 0, 240, 50);
		box_clock.add(time);
		
		
		JPanel datphong = new JPanel();
		datphong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		datphong.setBorder(null);
		datphong.setBackground(new Color(0, 0, 0, 150));
		datphong.setBounds(0, 70, 232, 80);
		contentPane.add(datphong);
		datphong.setLayout(null);
		
		JLabel lbldatphong = new JLabel("Đặt Phòng");
		lbldatphong.setForeground(Color.WHITE);
		lbldatphong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbldatphong.setHorizontalAlignment(SwingConstants.CENTER);
		lbldatphong.setBounds(0, 0, 232, 80);
		datphong.add(lbldatphong);
		
		JPanel thuephong = new JPanel();
		thuephong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		thuephong.setLayout(null);
		thuephong.setBorder(null);
		thuephong.setBackground(new Color(0, 0, 0, 150));
		thuephong.setBounds(229, 70, 232, 80);
		contentPane.add(thuephong);
		
		JLabel lblthuephong = new JLabel("Thuê Phòng");
		lblthuephong.setHorizontalAlignment(SwingConstants.CENTER);
		lblthuephong.setForeground(Color.WHITE);
		lblthuephong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblthuephong.setBounds(0, 0, 232, 80);
		thuephong.add(lblthuephong);
		
		JPanel datdichvu = new JPanel();
		datdichvu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		datdichvu.setLayout(null);
		datdichvu.setBorder(null);
		datdichvu.setBackground(new Color(0, 0, 0, 150));
		datdichvu.setBounds(462, 70, 232, 80);
		contentPane.add(datdichvu);
		
		JLabel lbltdatdichvu = new JLabel("Đặt Dịch Vụ");
		lbltdatdichvu.setHorizontalAlignment(SwingConstants.CENTER);
		lbltdatdichvu.setForeground(Color.WHITE);
		lbltdatdichvu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbltdatdichvu.setBounds(0, 0, 232, 80);
		datdichvu.add(lbltdatdichvu);
		
		JPanel khachhang = new JPanel();
		khachhang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		khachhang.setLayout(null);
		khachhang.setBorder(null);
		khachhang.setBackground(new Color(0, 0, 0, 150));
		khachhang.setBounds(695, 70, 232, 80);
		contentPane.add(khachhang);
		
		JLabel lbltkhachhang = new JLabel("Khách Hàng");
		lbltkhachhang.setHorizontalAlignment(SwingConstants.CENTER);
		lbltkhachhang.setForeground(Color.WHITE);
		lbltkhachhang.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbltkhachhang.setBounds(0, 0, 232, 80);
		khachhang.add(lbltkhachhang);
		
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(GD_Main_NV.class.getResource("/Imgs/370.png")));
		lblNewLabel.setBounds(-95, -176, 1333, 957);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void start () {
        Timer timer = new Timer ();
        timer.scheduleAtFixedRate ( new TimerTask () {
            public void run () {
                time.setText ( sdf.format (new Date ()) );
            }
        }, 0, 1000 );
    }
}

package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JOptionPane;

import Entity.*;
import connectDB.connectDB;

public class QLPH_DAO {
	ArrayList<Phong> dsph;
	Connection con = connectDB.getInstance().getConnection();
    private HashSet<String> existingMaPhongs = new HashSet<>();

    
	public QLPH_DAO() {
		dsph = new ArrayList<Phong>();
//		updateExistingMaPhongs();
		
		
	}
	public String sinhMaPhong() {
        // Lấy số cuối cùng từ mã phòng đã tồn tại trong CSDL
        int currentNumber = getCurrentNumber();

        // Tăng số cuối cùng lên 1 đơn vị
        currentNumber++;

        // Tạo mã phòng mới
        String newMaPhong = "P" + String.format("%03d", currentNumber);

        // Kiểm tra và tăng tiếp nếu mã đã tồn tại
        while (existingMaPhongs.contains(newMaPhong)) {
            currentNumber++;
            newMaPhong = "P" + String.format("%03d", currentNumber);
        }

        // Sau khi tìm được mã mới không trùng lặp, cập nhật danh sách và trả về
        existingMaPhongs.add(newMaPhong);
        return newMaPhong;
    }

    private int getCurrentNumber() {
        int maxNumber = 0;
        for (String maPhong : existingMaPhongs) {
            int number = Integer.parseInt(maPhong.substring(1));
            if (number > maxNumber) {
                maxNumber = number;
            }
        }
        return maxNumber;
    }
	private void updateExistingMaPhongs() {
        String sql = "SELECT maPhong FROM Phong";        
        try {
        	PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                existingMaPhongs.add(resultSet.getString("maPhong"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public ArrayList<Phong> docbang(){
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "select maPhong , soNguoi , tenPhong , giaTien,tenLoaiPhong , ttp.maTTP from Phong p inner join LoaiPhong lp on p.maLP = lp.maLP inner join TrangThaiPhong ttp on p.maTTP = ttp.maTTP";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				String maPhong = rs.getString(1);
				String soNguoi = rs.getString(2);
				String tenPhong = rs.getString(3);
				String tinhTrang = rs.getString(4);
				LoaiPhong tenLoaiPhong = new LoaiPhong(rs.getString(5), 0);
				TrangThaiPhong maTrangThaiPhong = new TrangThaiPhong(rs.getString(6),null );
				Phong ph = new Phong(maPhong, soNguoi, tenPhong, tinhTrang, tenLoaiPhong, maTrangThaiPhong);
				dsph.add(ph);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return dsph;
	}
	
	
	
	public boolean create(Phong ph) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement smt = null;
		int n = 0;
		try {
			smt = con.prepareStatement("insert into Phong(maPhong, soNguoi, tenPhong, tinhTrangPhong, maLP, maTTP) values(?, ?, ?, ?, ?, ?)");
			smt.setString(1, ph.getMaPhong());
			smt.setString(2, ph.getSoNguoi());
			smt.setString(3, ph.getTenPhong());
			smt.setString(4, ph.getTinTrangPhong());
			smt.setString(5, ph.getLoaiPhong().getMaLoaiPhong());
			smt.setString(6, ph.getTrangThaiPhong().getMaTrangThai());
			n = smt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public void remove(int index) {
		Phong nv = dsph.get(index);
		String sql = "delete from Phong where maPhong = ?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, nv.getMaPhong());
			statement.execute();
			dsph.remove(index);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int size() {
		return dsph.size();
	}
	
	public static void deleteCustomerByCustomerId(String maKH) {
        // Chuyển đổi maKH từ String sang int
//        int customerId = Integer.parseInt(maKH);

        try (Connection con = connectDB.getInstance().getConnection()) {
            String sql = "DELETE FROM Phong WHERE maPhong = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, maKH);
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Xoa thanh cong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public int getIndex(String maPH) {
		Phong temp = new Phong(maPH);
		return dsph.indexOf(temp);
	}
	
	public ArrayList<Phong> layttphongfrommaph(String maPhong){
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "select * from Phong where maPhong = ?";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String soNguoi = rs.getString(2);
				String tenPhong = rs.getString(3);
				String tinhTrang = rs.getString(4);
				LoaiPhong tenLoaiPhong = new LoaiPhong(null, rs.getString(5), 0);
				TrangThaiPhong maTrangThaiPhong = new TrangThaiPhong(rs.getString(6),null );
				Phong ph = new Phong(maPhong, soNguoi, tenPhong, tinhTrang, tenLoaiPhong, maTrangThaiPhong);
				dsph.add(ph);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return dsph;
	}
	public boolean update(Phong kh) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement smt = null;
		int n = 0;
		try {
			smt = con.prepareStatement("UPDATE Phong SET soNguoi = ?, tenPhong = ?, tinhTrangPhong = ?, maLP = ? , maTTP = ? where maPhong = ?");

			smt.setString(1, kh.getSoNguoi());
			smt.setString(2, kh.getTenPhong());
			smt.setString(3, kh.getTinTrangPhong());
			smt.setString(4, kh.getLoaiPhong().getMaLoaiPhong());
			smt.setString(5, kh.getTrangThaiPhong().getMaTrangThai());
			smt.setString(6, kh.getMaPhong());
			
			n = smt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public void suaThongTinPhong(Phong p) {
        String sql = "UPDATE Phong SET soNguoi = ?, tenPhong = ?, tinhTrangPhong = ?, maLP = ? , maTTP = ? where maPhong = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, p.getSoNguoi());
            preparedStatement.setString(2, p.getTenPhong());
            preparedStatement.setString(3, p.getTinTrangPhong());
            preparedStatement.setString(4, p.getLoaiPhong().getMaLoaiPhong());
          
            preparedStatement.setString(5, p.getTrangThaiPhong().getMaTrangThai());
            preparedStatement.setString(6, p.getMaPhong());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public int getMaxMaPH() {
        int maxMaKH = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = connectDB.getInstance().getConnection();
            String query = "SELECT MAX(CONVERT(INT, SUBSTRING(maPhong, 2, LEN(maPhong)))) FROM Phong";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	maxMaKH = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxMaKH;
    }
    private boolean isMaKHExist(String maPH) {
        String sql = "SELECT COUNT(*) FROM Phong WHERE maPhong = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, maPH);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public String kiemTraMaTrungLap(String maPH) {
        String newMaKH = maPH;
        boolean isDuplicate = true;

        while (isDuplicate) {
            // Kiểm tra xem mã khách hàng có trùng lặp không
            if (!isMaKHExist(newMaKH)) {
                isDuplicate = false; // Nếu không trùng lặp, thoát khỏi vòng lặp
            } else {
                // Nếu trùng lặp, tăng thêm 1 đơn vị và kiểm tra lại
                int currentNumber = Integer.parseInt(newMaKH.substring(1));
                currentNumber++;
                newMaKH = newMaKH.substring(0, 1) + currentNumber;
            }
        }

        return newMaKH;
    }
    


}

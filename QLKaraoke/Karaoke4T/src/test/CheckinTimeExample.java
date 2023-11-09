package test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckinTimeExample {

    public static String getCheckinTime() {
        // Lấy thời gian hiện tại
        LocalDateTime currentTime = LocalDateTime.now();

        // Định dạng thời gian theo yêu cầu (vd: "dd/MM/yyyy HH:mm:ss")
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        // Chuyển đổi thời gian thành chuỗi với định dạng đã chỉ định
        String checkinTime = currentTime.format(formatter);

        return checkinTime;
    }

    public static void main(String[] args) {
        // Gọi hàm để lấy thời gian check-in
        String checkinTime = getCheckinTime();

        // In ra thời gian check-in
        System.out.println("Check-in time: " + checkinTime);
    }
}

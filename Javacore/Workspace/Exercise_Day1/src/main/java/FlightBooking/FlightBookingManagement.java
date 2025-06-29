package FlightBooking;

import FlightBooking.entity.Booking;
import FlightBooking.entity.Flight;
import FlightBooking.entity.Passenger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FlightBookingManagement {
    private Scanner sc = new Scanner(System.in);
    private List<Flight> flights = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public FlightBookingManagement() {
        Passenger passenger1 = new Passenger("P01", "Nguyễn Văn A");
        Passenger passenger2 = new Passenger("BIG01", "Trần Thị B");
        passengers.add(passenger1);
        passengers.add(passenger2);

        Flight flight1 = new Flight("F01", "Hà Nội", "TP.HCM", LocalDateTime.now().plusDays(1), 100);
        Flight flight2 = new Flight("F02", "Hà Nội", "Đà Nẵng", LocalDateTime.now().plusDays(2), 50);
        Flight flight3 = new Flight("F03", "Hà Nội", "TP.HCM", LocalDateTime.now().plusHours(12), 80);
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);

        Booking booking1 = new Booking(passenger1, flight1, LocalDateTime.now());
        Booking booking2 = new Booking(passenger1, flight3, LocalDateTime.now());
        Booking booking3 = new Booking(passenger2, flight1, LocalDateTime.now());
        bookings.add(booking1);
        bookings.add(booking2);
        bookings.add(booking3);

        flight1.getBookings().add(booking1);
        flight3.getBookings().add(booking2);
        flight1.getBookings().add(booking3);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n===== QUẢN LÝ ĐẶT VÉ MÁY BAY =====");
            System.out.println("1. Hiển thị danh sách chuyến bay");
            System.out.println("2. Hiển thị danh sách hành khách");
            System.out.println("3. Thêm chuyến bay");
            System.out.println("4. Thêm hành khách");
            System.out.println("5. Đặt vé");
            System.out.println("6. In danh sách hành khách trong chuyến bay");
            System.out.println("7. In danh sách chuyến bay của hành khách");
            System.out.println("8. Tìm chuyến bay có nhiều lượt đặt nhất");
            System.out.println("9. Tìm hành khách bay nhiều nhất");
            System.out.println("10. In chuyến bay từ Hà Nội đến TP.HCM trong 3 ngày tới");
            System.out.println("11. Quay lại menu chính");
            System.out.print("Chọn chức năng: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    printFlightList();
                    break;
                case 2:
                    printPassengerList();
                    break;
                case 3:
                    addFlight();
                    break;
                case 4:
                    addPassenger();
                    break;
                case 5:
                    bookFlight();
                    break;
                case 6:
                    printPassengersInFlight();
                    break;
                case 7:
                    printFlightsOfPassenger();
                    break;
                case 8:
                    findMostBookedFlight();
                    break;
                case 9:
                    findMostFrequentPassenger();
                    break;
                case 10:
                    printFlightsFromHanoiToHCM();
                    break;
                case 11:
                    System.out.println("Quay lại menu chính.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private void printFlightList() {
        System.out.println("Danh sách chuyến bay:");
        for (Flight flight : flights) {
            System.out.println("- " + flight.getFlightId() + ": " + flight.getOrigin() + " -> " +
                    flight.getDestination() + ", Cất cánh: " + flight.getDepartureTime().format(formatter) +
                    ", Sức chứa: " + flight.getCapacity() + ", Đã đặt: " + flight.getBookings().size());
        }
    }

    private void printPassengerList() {
        System.out.println("Danh sách hành khách:");
        for (Passenger passenger : passengers) {
            System.out.println("- " + passenger.getName() + " (" + passenger.getId() + ")");
        }
    }

    private void addFlight() {
        while (true) {
            System.out.print("Nhập ID chuyến bay: ");
            String id = sc.nextLine();
            boolean exists = flights.stream().anyMatch(f -> f.getFlightId().equals(id));
            if (exists) {
                System.out.println("Chuyến bay đã tồn tại. Vui lòng nhập lại!");
            } else {
                System.out.print("Nhập điểm xuất phát: ");
                String origin = sc.nextLine();
                System.out.print("Nhập điểm đến: ");
                String destination = sc.nextLine();
                System.out.print("Nhập thời gian cất cánh (yyyy-MM-dd HH:mm): ");
                String timeStr = sc.nextLine();
                LocalDateTime departureTime;
                try {
                    departureTime = LocalDateTime.parse(timeStr, formatter);
                } catch (Exception e) {
                    System.out.println("Định dạng thời gian không hợp lệ!");
                    continue;
                }
                System.out.print("Nhập sức chứa: ");
                int capacity = sc.nextInt();
                sc.nextLine();
                Flight flight = new Flight(id, origin, destination, departureTime, capacity);
                flights.add(flight);
                System.out.println("Thêm chuyến bay thành công!");
                break;
            }
        }
    }

    private void addPassenger() {
        while (true) {
            System.out.print("Nhập ID hành khách: ");
            String id = sc.nextLine();
            boolean exists = passengers.stream().anyMatch(p -> p.getId().equals(id));
            if (exists) {
                System.out.println("Hành khách đã tồn tại. Vui lòng nhập lại!");
            } else {
                System.out.print("Nhập tên hành khách: ");
                String name = sc.nextLine();
                Passenger passenger = new Passenger(id, name);
                passengers.add(passenger);
                System.out.println("Thêm hành khách thành công!");
                break;
            }
        }
    }

    private void bookFlight() {
        System.out.print("Nhập ID hành khách: ");
        String passengerId = sc.nextLine();
        Passenger passenger = passengers.stream()
                .filter(p -> p.getId().equals(passengerId))
                .findFirst()
                .orElse(null);

        if (passenger == null) {
            System.out.println("Hành khách không tồn tại!");
            return;
        }

        System.out.print("Nhập ID chuyến bay: ");
        String flightId = sc.nextLine();
        Flight flight = flights.stream()
                .filter(f -> f.getFlightId().equals(flightId))
                .findFirst()
                .orElse(null);

        if (flight == null) {
            System.out.println("Chuyến bay không tồn tại!");
            return;
        }

        if (flight.isFull()) {
            System.out.println("Chuyến bay đã đầy!");
            return;
        }

        boolean alreadyBooked = bookings.stream()
                .anyMatch(b -> b.getPassenger().getId().equals(passengerId) && b.getFlight().getFlightId().equals(flightId));
        if (alreadyBooked) {
            System.out.println("Hành khách đã đặt chuyến bay này!");
            return;
        }

        Booking booking = new Booking(passenger, flight, LocalDateTime.now());
        bookings.add(booking);
        flight.getBookings().add(booking);
        System.out.println("Hành khách " + passenger.getName() + " đã đặt vé chuyến bay " + flight.getFlightId() + " thành công!");
    }

    private void printPassengersInFlight() {
        System.out.print("Nhập ID chuyến bay: ");
        String flightId = sc.nextLine();
        Flight flight = flights.stream()
                .filter(f -> f.getFlightId().equals(flightId))
                .findFirst()
                .orElse(null);

        if (flight == null) {
            System.out.println("Chuyến bay không tồn tại!");
            return;
        }

        if (flight.getBookings().isEmpty()) {
            System.out.println("Chuyến bay chưa có hành khách nào!");
            return;
        }

        flight.getBookings().sort(Comparator.comparing(Booking::getBookingTime));
        System.out.println("Danh sách hành khách trong chuyến bay " + flight.getFlightId() + ":");
        for (Booking booking : flight.getBookings()) {
            System.out.println("- " + booking.getPassenger().getName() + " (" + booking.getPassenger().getId() +
                    "), Thời gian đặt: " + booking.getBookingTime().format(formatter));
        }
    }

    private void printFlightsOfPassenger() {
        System.out.print("Nhập ID hành khách: ");
        String passengerId = sc.nextLine();
        Passenger passenger = passengers.stream()
                .filter(p -> p.getId().equals(passengerId))
                .findFirst()
                .orElse(null);

        if (passenger == null) {
            System.out.println("Hành khách không tồn tại!");
            return;
        }

        List<Flight> passengerFlights = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getPassenger().getId().equals(passengerId)) {
                passengerFlights.add(booking.getFlight());
            }
        }

        if (passengerFlights.isEmpty()) {
            System.out.println("Hành khách này chưa đặt chuyến bay nào!");
        } else {
            System.out.println("Danh sách chuyến bay đã đặt của hành khách " + passenger.getName() + ":");
            for (Flight flight : passengerFlights) {
                System.out.println("- " + flight.getFlightId() + ": " + flight.getOrigin() + " -> " +
                        flight.getDestination() + ", Cất cánh: " + flight.getDepartureTime().format(formatter));
            }
        }
    }

    private void findMostBookedFlight() {
        if (flights.isEmpty()) {
            System.out.println("Không có chuyến bay nào!");
            return;
        }

        Flight mostBooked = null;
        int maxBookings = 0;
        for (Flight flight : flights) {
            int bookingCount = flight.getBookings().size();
            if (bookingCount > maxBookings) {
                maxBookings = bookingCount;
                mostBooked = flight;
            }
        }

        if (mostBooked != null && maxBookings > 0) {
            System.out.println("Chuyến bay có số lượt đặt nhiều nhất: " + mostBooked.getFlightId() +
                    " (" + mostBooked.getOrigin() + " -> " + mostBooked.getDestination() +
                    "), Số lượt đặt: " + maxBookings);
        } else {
            System.out.println("Không có chuyến bay nào được đặt!");
        }
    }

    private void findMostFrequentPassenger() {
        if (passengers.isEmpty()) {
            System.out.println("Không có hành khách nào!");
            return;
        }

        Passenger mostFrequent = null;
        int maxFlights = 0;
        for (Passenger passenger : passengers) {
            int flightCount = (int) bookings.stream()
                    .filter(b -> b.getPassenger().getId().equals(passenger.getId()))
                    .count();
            if (flightCount > maxFlights) {
                maxFlights = flightCount;
                mostFrequent = passenger;
            }
        }

        if (mostFrequent != null && maxFlights > 0) {
            System.out.println("Hành khách bay nhiều nhất: " + mostFrequent.getName() +
                    " (" + mostFrequent.getId() + "), Số chuyến bay: " + maxFlights);
        } else {
            System.out.println("Không có hành khách nào đã đặt vé!");
        }
    }

    private void printFlightsFromHanoiToHCM() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Danh sách chuyến bay từ Hà Nội đến TP.HCM trong 3 ngày tới:");
        for (Flight flight : flights) {
            if (flight.getOrigin().equals("Hà Nội") && flight.getDestination().equals("TP.HCM") &&
                    flight.getDepartureTime().isAfter(now) &&
                    flight.getDepartureTime().isBefore(now.plusDays(3))) {
                System.out.println("- " + flight.getFlightId() + ": " + flight.getOrigin() + " -> " +
                        flight.getDestination() + ", Cất cánh: " + flight.getDepartureTime().format(formatter));
            }
        }
    }
}


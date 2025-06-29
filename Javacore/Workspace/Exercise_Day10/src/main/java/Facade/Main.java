package Facade;

public class Main {
    public static void main(String[] args) {
        TicketBookingFacade bookingSystem = new TicketBookingFacade();

        bookingSystem.bookTicket("Avengers: Endgame", "A5", 120000, "user1@example.com");
        bookingSystem.bookTicket("Doraemon", "B2", 100000, "user2@example.com");
    }
}

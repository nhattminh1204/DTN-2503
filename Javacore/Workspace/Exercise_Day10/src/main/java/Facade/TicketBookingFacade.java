package Facade;

public class TicketBookingFacade {
    private MovieSelector movieSelector;
    private SeatSelector seatSelector;
    private PaymentSystem paymentSystem;
    private EmailService emailService;

    public TicketBookingFacade() {
        movieSelector = new MovieSelector();
        seatSelector = new SeatSelector();
        paymentSystem = new PaymentSystem();
        emailService = new EmailService();
    }

    public void bookTicket(String movie, String seat, double amount, String email) {
        movieSelector.selectMovie(movie);
        seatSelector.selectSeat(seat);
        paymentSystem.makePayment(amount);
        emailService.sendConfirmation(email);
        System.out.println("Đặt vé thành công!\n");
    }
}

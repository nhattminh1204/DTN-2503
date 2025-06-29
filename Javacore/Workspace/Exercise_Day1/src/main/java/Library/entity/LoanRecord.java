package Library.entity;

import java.time.LocalDate;

public class LoanRecord {
    User user;
    Book book;
    LocalDate loanDate;
    LocalDate returnDate;

    public LoanRecord(User user, Book book, LocalDate loanDate, LocalDate returnDate) {
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
        this.returnDate = null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return returnDate != null;
    }

    @Override
    public String toString() {
        return user.getName() + " borrowed '" + book.getTitle() + "' on " + loanDate +
                (isReturned() ? " and returned on " + returnDate : " (not yet returned)");
    }
}

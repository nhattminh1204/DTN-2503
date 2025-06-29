package Facade_1;

public class Program {
    public static void main(String[] args) {
        DVDPlayer dvd = new DVDPlayer();
        Projector mayChieu = new Projector();
        SoundSystem loa = new SoundSystem();

        HomeTheaterFacade home = new HomeTheaterFacade(dvd, mayChieu, loa);

        home.watchMovie("Avengers: Endgame");
        home.endMovie();
    }
}

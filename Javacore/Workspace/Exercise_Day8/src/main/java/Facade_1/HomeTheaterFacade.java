package Facade_1;

public class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private SoundSystem soundSystem;

    public HomeTheaterFacade(DVDPlayer dvd, Projector proj, SoundSystem sound) {
        this.dvdPlayer = dvd;
        this.projector = proj;
        this.soundSystem = sound;
    }

    public void watchMovie(String movie) {
        System.out.println("\n--- Preparing to watch a movie ---");
        soundSystem.on();
        soundSystem.setVolume(7);

        projector.on();
        projector.setInput("DVD");

        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("\n--- Shutting down movie system ---");
        dvdPlayer.off();
        projector.off();
        soundSystem.off();
    }
}


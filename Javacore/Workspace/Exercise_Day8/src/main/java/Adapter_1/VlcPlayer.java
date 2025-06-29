package Adapter_1;

public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Đang phát file vlc: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Không hỗ trợ file mp4");
    }
}

package Adapter_1;

public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Không hỗ trợ file vlc");
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Đang phát file mp4: " + fileName);
    }
}

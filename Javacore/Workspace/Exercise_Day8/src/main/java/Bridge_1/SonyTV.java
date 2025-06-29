package Bridge_1;

public class SonyTV implements TV {
    @Override
    public void turnOn() {
        System.out.println("Sony TV bật lên");
    }

    @Override
    public void turnOff() {
        System.out.println("Sony TV tắt");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Sony TV chuyển đến kênh " + channel);
    }
}

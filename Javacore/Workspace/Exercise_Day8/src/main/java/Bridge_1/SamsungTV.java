package Bridge_1;

public class SamsungTV implements TV {
    @Override
    public void turnOn() {
        System.out.println("Samsung TV bật lên");
    }

    @Override
    public void turnOff() {
        System.out.println("Samsung TV tắt");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Samsung TV chuyển đến kênh " + channel);
    }
}

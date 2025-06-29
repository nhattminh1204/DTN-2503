package Bridge_1;

public class Program {
    public static void main(String[] args) {
        TV samsungTV = new SamsungTV();
        RemoteControl remote1 = new RemoteControl(samsungTV);
        remote1.turnOn();
        remote1.setChannel(5);
        remote1.turnOff();

        System.out.println("-----------");

        TV sonyTV = new SonyTV();
        RemoteControl remote2 = new RemoteControl(sonyTV);
        remote2.turnOn();
        remote2.setChannel(10);
        remote2.turnOff();
    }
}

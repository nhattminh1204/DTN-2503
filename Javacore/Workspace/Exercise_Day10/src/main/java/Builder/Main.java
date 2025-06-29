package Builder;

public class Main {
    public static void main(String[] args) {
        Computer comp1 = new Computer.ComputerBuilder()
                .setCPU("Intel Core i7")
                .setRAM(16)
                .build();

        System.out.println(comp1);

        Computer comp2 = new Computer.ComputerBuilder()
                .setCPU("AMD Ryzen 9")
                .setRAM(32)
                .setStorage(1000)
                .setGPU("NVIDIA RTX 3080")
                .build();

        System.out.println(comp2);

        Computer comp3 = new Computer.ComputerBuilder()
                .setCPU("Intel Core i5")
                .setRAM(8)
                .setStorage(512)
                .build();

        System.out.println(comp3);

        try {
            Computer compFail = new Computer.ComputerBuilder()
                    .setRAM(8)
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Lỗi tạo máy: " + e.getMessage());
        }
    }
}


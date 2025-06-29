package Builder;

public class Computer {
    private final String CPU;
    private final int RAM;
    private final int storage;
    private final String GPU;

    private Computer(ComputerBuilder builder) {
        this.CPU = builder.getCPU();
        this.RAM = builder.getRAM();
        this.storage = builder.getStorage();
        this.GPU = builder.getGPU();
    }

    public String getCPU() {
        return CPU;
    }

    public int getRAM() {
        return RAM;
    }

    public int getStorage() {
        return storage;
    }

    public String getGPU() {
        return GPU;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", RAM=" + RAM + "GB" +
                ", storage=" + storage + "GB" +
                ", GPU='" + (GPU == null ? "None" : GPU) + '\'' +
                '}';
    }


    public static class ComputerBuilder {
        private String CPU;
        private int RAM;
        private int storage = 0;
        private String GPU;

        public ComputerBuilder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public ComputerBuilder setRAM(int RAM) {
            this.RAM = RAM;
            return this;
        }

        public ComputerBuilder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public String getCPU() { return CPU; }
        public int getRAM() { return RAM; }
        public int getStorage() { return storage; }
        public String getGPU() { return GPU; }

        public Computer build() {
            if (CPU == null || CPU.isEmpty()) {
                throw new IllegalStateException("CPU must be set");
            }
            if (RAM <= 0) {
                throw new IllegalStateException("RAM must be greater than 0");
            }
            return new Computer(this);
        }
    }
}


/*
The Facade Pattern is a structural design pattern that provides a streamlined interface to a complex system of classes,
a library, or a framework. It defines a higher-level interface that facilitates the subsystem's use but does not prevent
you from using the complex system directly. The Facade Pattern is also known as the Interface Pattern.
*/

class CPU {
    void initialize() {
        System.out.println("CPU initialized");
    }
}

class Memory {
    void load(long position, String data) {
        System.out.println("Loading data into memory at position " + position + ".");
    }
}

class HardDrive {
    String readBootSector() {
        return "Boot sector data";
    }
}

class OperatingSystem {
    String loadKernel() {
        return "OS kernel data";
    }
}

class ComputerFacade {
    private CPU cpu = new CPU();
    private Memory memory = new Memory();
    private HardDrive hardDrive = new HardDrive();
    private OperatingSystem operatingSystem = new OperatingSystem();

    void startComputer() {
        String bootSector = hardDrive.readBootSector();
        String osData = operatingSystem.loadKernel();
        memory.load(0, bootSector);
        memory.load(1024, osData);
        cpu.initialize();
    }
}
public class Facade {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
    }
}

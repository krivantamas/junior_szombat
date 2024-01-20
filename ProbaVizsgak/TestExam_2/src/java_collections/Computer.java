package java_collections;

import java.util.Objects;

public class Computer {

    private final String name;
    private final String CPU;
    private final String GPU;
    private final int ramCapacity;
    private final int storageCapacity;
    private final StorageType storageType;


    public Computer(String name, String cpu, String gpu, int ramCapacity, int storageCapacity, StorageType storageType) {
        this.name = name;
        CPU = cpu;
        GPU = gpu;
        this.ramCapacity = ramCapacity;
        this.storageCapacity = storageCapacity;
        this.storageType = storageType;
    }


    public String getName() {
        return name;
    }

    public String getCPU() {
        return CPU;
    }

    public String getGPU() {
        return GPU;
    }

    public int getRamCapacity() {
        return ramCapacity;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public StorageType getStorageType() {
        return storageType;
    }

    @Override
    public String toString() {
        return String.format("new Computer(\"%s\",\"%s\",\"%s\",%d,%d,StorageType.%s)", getName(), getCPU(), getGPU(), getRamCapacity(), getStorageCapacity(), getStorageType());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return ramCapacity == computer.ramCapacity && storageCapacity == computer.storageCapacity && name.equals(computer.name) && CPU.equals(computer.CPU) && GPU.equals(computer.GPU) && storageType == computer.storageType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, CPU, GPU, ramCapacity, storageCapacity, storageType);
    }
}

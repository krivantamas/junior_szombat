package java_collections;

import java.util.HashMap;
import java.util.List;

public class ComputerStorageSystem {

    private final List<Computer> computerList = ComputerDatabase.getComputers();


    public final List<Computer> getAllComputer() {
        return computerList;
    }

    public final List<Computer> getAllComputersWithIntelCPU() {
        return computerList.stream().filter(computer -> computer.getCPU().startsWith("Intel")).toList();
    }

    public final List<Computer> getAllComputersWithAmdCPU() {
        return computerList.stream().filter(computer -> computer.getCPU().startsWith("AMD")).toList();
    }

    public final List<Computer> getAllComputersWithGeForceGPU() {
        return computerList.stream().filter(computer -> computer.getCPU().startsWith("GeForce")).toList();
    }

    public final List<Computer> getAllComputersWithRadeonGPU() {
        return computerList.stream().filter(computer -> computer.getGPU().startsWith("Radon")).toList();
    }

    public final List<Computer> getAllComputersWithMoreThan16GBRam() {
        return computerList.stream().filter(computer -> computer.getRamCapacity() >= 16).toList();
    }

    public final HashMap<StorageType, Computer> getAllComputersGroupedByStorageType() {
        throw new UnsupportedOperationException();
    }

    public final HashMap<Integer, Computer> getAllComputersGroupedByMemoryCapacity() {
        throw new UnsupportedOperationException();
    }

    public final HashMap<Integer, Computer> getAllComputersGroupedByStorageCapacity() {
        throw new UnsupportedOperationException();
    }


}



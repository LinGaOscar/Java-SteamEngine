package com.worldline.interview;

public class InternalCombustionEngine implements Engine {

    private boolean running;
    private int fuelLevel;
    private FuelType requiredFuelType;
    private FuelType fuelType;
    private static final int BATCH_SIZE = 8;

    public InternalCombustionEngine(FuelType requiredFuelType) {
        if (requiredFuelType != FuelType.PETROL && requiredFuelType != FuelType.DIESEL) {
            throw new IllegalArgumentException("Internal combustion engine only supports PETROL and DIESEL");
        }
        this.requiredFuelType = requiredFuelType;
        running = false;
        fuelLevel = 0;
    }

    @Override
    public void start() {
        if (fuelLevel > 0 && requiredFuelType.equals(fuelType)) {
            running = true;
        } else {
            throw new IllegalStateException("Not able to start engine.");
        }
    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public void fill(FuelType fuelType, int fuelLevel) {
        if (fuelLevel >= 0 && fuelLevel <= 100) {
            this.fuelLevel = fuelLevel;
        } else if (fuelLevel > 100) {
            this.fuelLevel = 100;
        } else {
            this.fuelLevel = 0;
        }

        this.fuelType = fuelType;
    }

    @Override
    public FuelType getFuelType() {
        return requiredFuelType;
    }

    @Override
    public int getBatchSize() {
        return BATCH_SIZE;
    }

    @Override
    public double getCostPerBatch() {
        switch (requiredFuelType) {
            case PETROL:
                return 9.00;
            case DIESEL:
                return 12.00;
            default:
                throw new IllegalStateException("Unexpected fuel type.");
        }
    }
}

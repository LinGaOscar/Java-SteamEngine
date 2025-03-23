package com.worldline.interview;

public class SteamEngine implements Engine {

    private boolean running;
    private int fuelLevel;
    private FuelType requiredFuelType;
    private FuelType fuelType;
    private static final int BATCH_SIZE = 2;

    public SteamEngine(FuelType requiredFuelType) {
        if (requiredFuelType != FuelType.WOOD && requiredFuelType != FuelType.COAL) {
            throw new IllegalArgumentException("Steam engine only supports WOOD and COAL");
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
    public FuelType getFuelType() {
        return requiredFuelType;
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
    public int getBatchSize() {
        return BATCH_SIZE;
    }

    @Override
    public double getCostPerBatch() {
        switch (requiredFuelType) {
            case WOOD:
                return 4.35;
            case COAL:
                return 5.65;
            default:
                throw new IllegalStateException("Unexpected fuel type.");
        }
    }
}

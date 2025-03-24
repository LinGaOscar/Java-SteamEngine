package com.worldline.interview;

public class SteamEngine extends EngineObject {

    private static final int batchSize = 2;

    public SteamEngine(FuelType requiredFuelType) {
        if (requiredFuelType != FuelType.WOOD && requiredFuelType != FuelType.COAL) {
            throw new IllegalArgumentException("Steam engine only supports WOOD and COAL");
        }
        this.requiredFuelType = requiredFuelType;
        running = false;
        fuelLevel = 0;
    }

    @Override
    public int getBatchSize() {
        return batchSize;
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

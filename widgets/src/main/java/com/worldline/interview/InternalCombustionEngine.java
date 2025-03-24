package com.worldline.interview;

public class InternalCombustionEngine extends EngineObject {

    private static final int batchSize = 8;

    public InternalCombustionEngine(FuelType requiredFuelType) {
        if (requiredFuelType != FuelType.PETROL && requiredFuelType != FuelType.DIESEL) {
            throw new IllegalArgumentException("Internal combustion engine only supports PETROL and DIESEL");
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
            case PETROL:
                return 9.00;
            case DIESEL:
                return 12.00;
            default:
                throw new IllegalStateException("Unexpected fuel type.");
        }
    }
}

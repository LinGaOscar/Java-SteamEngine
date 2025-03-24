package com.worldline.interview;

public interface EngineInterface {
    void start();

    void stop();

    boolean isRunning();

    FuelType getFuelType();

    void fill(FuelType fuelType, int fuelLevel);

    int getBatchSize();

    double getCostPerBatch();
}

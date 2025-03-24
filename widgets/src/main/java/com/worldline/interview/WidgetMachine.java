package com.worldline.interview;

public class WidgetMachine {
    private Engine engine;
   
    public WidgetMachine(Engine engine) {
        this.engine = engine;
    }

    public int produceWidgets(int quantity) {
        engine.start();
        int cost = 0;

        if (engine.isRunning()) {
            cost = produce(quantity);
        }

        engine.stop();

        return cost;
    }

    private int produce(int quantity) {
        int batch = 0;
        int batchCount = 0;
        double costPerBatch = engine.getCostPerBatch();
        int batchSize = engine.getBatchSize();

        while (batch < quantity) {
            batch = batch + batchSize;
            batchCount++;
        }

        return (int) Math.ceil(batchCount * costPerBatch);
    }
    
}

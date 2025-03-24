
import static org.junit.Assert.assertFalse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.worldline.interview.FuelType;
import com.worldline.interview.InternalCombustionEngine;
import com.worldline.interview.SteamEngine;
import com.worldline.interview.WidgetMachine;

public class WidgetMachineTest {
    private InternalCombustionEngine petrolEngine;
    private InternalCombustionEngine dieselEngine;
    private SteamEngine woodEngine;
    private SteamEngine coalEngine;

    private WidgetMachine widgetMachine;

    @Before
    public void setUP() {
        petrolEngine = new InternalCombustionEngine(FuelType.PETROL);
        dieselEngine = new InternalCombustionEngine(FuelType.DIESEL);
        woodEngine = new SteamEngine(FuelType.WOOD);
        coalEngine = new SteamEngine(FuelType.COAL);
    }

    @Test
    public void testProduceWidgetsWithPetrolEngine() {
        widgetMachine = new WidgetMachine(petrolEngine);
        petrolEngine.fill(FuelType.PETROL, 50);
        int cost = widgetMachine.produceWidgets(15);
        // 15 / 8 = 1.875 -> 2 * 9 = 18
        Assert.assertEquals(18, cost);
        assertFalse(petrolEngine.isRunning());
    }

    @Test
    public void testProduceWidgetsWithDieselEngine() {
        widgetMachine = new WidgetMachine(dieselEngine);
        dieselEngine.fill(FuelType.DIESEL, 100);
        int cost = widgetMachine.produceWidgets(15);
        // 15 / 8 = 1.875 -> 2 * 12 = 24
        Assert.assertEquals(24, cost);
        assertFalse(petrolEngine.isRunning());
    }

    @Test
    public void testProduceWidgetsWithWoodEngine() {
        widgetMachine = new WidgetMachine(woodEngine);
        woodEngine.fill(FuelType.WOOD, 50);
        int cost = widgetMachine.produceWidgets(15);
        // 15 /2 = 7.5 -> 8 * 4.35 = 34.8 -> 35
        Assert.assertEquals(35, cost);
        assertFalse(petrolEngine.isRunning());
    }

    @Test
    public void testProduceWidgetsWithCoalEngine() {
        widgetMachine = new WidgetMachine(coalEngine);
        coalEngine.fill(FuelType.COAL, 50);
        int cost = widgetMachine.produceWidgets(15);
        // 15 /2 = 7.5 -> 8 * 5.75 = 46
        Assert.assertEquals(46, cost);
        assertFalse(petrolEngine.isRunning());
    }
}

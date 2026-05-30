package se.kth.iv1350.progexe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.progexe.integration.BikeDTO;
import se.kth.iv1350.progexe.integration.CustomerDTO;
import se.kth.iv1350.progexe.integration.OrderDTO;
import se.kth.iv1350.progexe.integration.RepairOrderRegistry;
import se.kth.iv1350.progexe.integration.RepairTaskDTO;
import se.kth.iv1350.progexe.model.RepairManager;

/**
 * Verifierar funktionalitet i RepairManager.
 */
public class RepairManagerTest {
    private RepairOrderRegistry registry;
    private RepairManager repairManager;
    private CustomerDTO customer;

    /**
     * Skapar testdata innan varje test.
     */
    @BeforeEach
    public void setUp() {
        registry = new RepairOrderRegistry();

        BikeDTO bike = new BikeDTO("Trek", "Mountain Bike", "ABC123");
        customer = new CustomerDTO("Jima Khadrou", "jima@gmail.com", "0761234567", bike);

        repairManager = new RepairManager(null, registry, null);
    }

    /**
     * Verifierar att en reparationsåtgärd läggs till i orderns lista
     * och att åtgärdens data är korrekt.
     */
    @Test
    public void testAddRepairTask() {
        OrderDTO order = registry.createRepairOrder("Däcken har punkterats", customer);
        RepairTaskDTO task = new RepairTaskDTO("Byta slang fram", 250.0);

        order = repairManager.addRepairTask(order, task.getDescription(), task.getCost());

        assertEquals(1, order.getRepairTasks().size(), "En åtgärd borde ha lagts till.");
        assertEquals(task.getDescription(), order.getRepairTasks().get(0).getDescription(), "Fel åtgärdsbeskrivning.");
        assertEquals(task.getCost(), order.getRepairTasks().get(0).getCost(), "Fel kostnad.");
    }

/**
 * Testar att diagnosresultat kan läggas till i en order.
 */
@Test
public void testAddDiagnosticResult() {
    OrderDTO order = registry.createRepairOrder("Däcken har punkterats", customer);

    OrderDTO updatedOrder = repairManager.addDiagnosticResult(order, "Punktering på båda däcken");

    assertEquals("Punktering på båda däcken", updatedOrder.getDiagnosticResult(), "Diagnosen lades inte till.");

    assertNull(order.getDiagnosticResult(),"Den gamla DTO:n ska inte ändras.");
}
}
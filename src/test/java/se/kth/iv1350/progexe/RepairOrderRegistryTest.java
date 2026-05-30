package se.kth.iv1350.progexe;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.progexe.integration.BikeDTO;
import se.kth.iv1350.progexe.integration.CustomerDTO;
import se.kth.iv1350.progexe.integration.OrderDTO;
import se.kth.iv1350.progexe.integration.RepairOrderRegistry;

/**
 * Verifierar att RepairOrderRegistry kan skapa reparationsordrar
 */
public class RepairOrderRegistryTest {
    private RepairOrderRegistry registry;
    private CustomerDTO customer;
    /**
     * Skapar testdata innan varje test.
     */
    @BeforeEach
    public void setUp() {
        registry = new RepairOrderRegistry();

        BikeDTO bike = new BikeDTO("Trek", "Mountain Bike", "ABC123");
        customer = new CustomerDTO("Jima Khadrou", "jima@gmail.com", "0761234567", bike);
    }

    /**
     * Testar att en reparationsorder skapas med rätt problembeskrivning och kund.
     */
    @Test
    public void testCreateRepairOrder() {
        OrderDTO order = registry.createRepairOrder("Däcken har punkterats", customer);

        assertNotNull(order, "Ordern borde skapas.");
        assertEquals("Däcken har punkterats", order.getProblemDescr(), "Fel problembeskrivning.");
        assertEquals(customer, order.getCustomer(), "Fel kund i ordern.");
    }

}
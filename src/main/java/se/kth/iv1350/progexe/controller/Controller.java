package se.kth.iv1350.progexe.controller;

import se.kth.iv1350.progexe.integration.CustomerDTO;
import se.kth.iv1350.progexe.integration.OrderDTO;
import se.kth.iv1350.progexe.model.RepairManager;

/**
 * Controller ansvarar för kommunikationen mellan vyn och modellagret.
 */
public class Controller {
    private RepairManager repairManager;
    /**
     * Skapar en ny instans av Controller.
     * @param repairManager Den specifika RepairManager som hanterar systemets logik.
     */

    public Controller(RepairManager repairManager) {
        this.repairManager = repairManager;
        
    }
    
    /**
     * Söker efter en kund via telefonnummer
     * @param phoneNumber Telefonnumret till kunden som söks
     * @return kunden om telefonnumret matchar, annar null
     */
    public CustomerDTO findCustomer(String phoneNumber){
        return repairManager.findCustomer(phoneNumber);
    }


    /**
    * Skapar en reparationsorder.
    *
    * @param problemDescription Kundens beskrivning av problemet.
    * @param phoneNumber Telefonnummer till kunden.
    * @return Den skapade reparationsordern.
    */
    public OrderDTO createRepairOrder(String problemDescription, String phoneNumber){
        return repairManager.createRepairOrder(problemDescription, phoneNumber);
}
    /**
    * Lägger till diagnos på en order.
    */
    public OrderDTO addDiagnosticResult(OrderDTO order, String diagnosticResult){
        return repairManager.addDiagnosticResult(order, diagnosticResult);
    }
/**
 * Lägger till en reparationsåtgärd på en order.
 *
 * @param order Den order som ska uppdateras
 * @param description Beskrivning av reparationsåtgärden
 * @param cost Kostnaden för reparationsåtgärden
 * @return Den uppdaterade ordern
 */
public OrderDTO addRepairTask(OrderDTO order,String description, double cost) {

    return repairManager.addRepairTask(order, description, cost);
}


    /**
     * Markerar en reparationsorder som accepterad.
     * @param order Ordern som ska accepteras.
     */
    public OrderDTO acceptRepairOrder(OrderDTO order){
        return repairManager.acceptRepairOrder(order);
    }
    /**
    * Skriver ut ett kvitto.
    *
    * @param formattedOrder Den formaterade ordertexten.
    * @param totalCost Den totala kostnaden för ordern.
    */
    public void printReceipt(String formattedOrder, double totalCost){
        repairManager.printReceipt(formattedOrder, totalCost);
}

    /**
    * Beräknar den totala kostnaden för en order.
    * @param order Reparationsordern.
    * @return Den totala kostnaden.
    */
    public double calculateTotalCost(OrderDTO order) {
        return repairManager.calculateTotalCost(order);
    }

    

}

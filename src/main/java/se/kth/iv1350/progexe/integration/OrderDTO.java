package se.kth.iv1350.progexe.integration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 * Innehåller data om en reparationsorder
 */
public class OrderDTO {
    private String id;
    private LocalDateTime dateCreated;
    private String problemDescr;
    private CustomerDTO customer;
    private String diagnosticResult;
    private boolean accepted;
    private List<RepairTaskDTO> repairTasks;
    /**
     * Skapar en ny instans av OrderDTO
     * @param id Unikt id för reparationsordern
     * @param dateCreated Datum och tid då ordern skapades
     * @param problemDescr Kundens beskrivning av problemet
     * @param customer Kunden som lämnat in sin cykel
     * @param diagnosticResult Resultatet av diagnosen
     */
    public OrderDTO(String id, 
        LocalDateTime dateCreated, 
        String problemDescr, 
        CustomerDTO customer,
        String diagnosticResult){
            this.id = id;
            this.dateCreated = dateCreated;
            this.problemDescr = problemDescr;
            this.customer = customer;
            this.diagnosticResult = diagnosticResult;
            this.repairTasks = new ArrayList<RepairTaskDTO>();
    }

    /**
    * Skapar en ny och fullständig instans av OrderDTO.
    *
    * @param id Unikt id för reparationsordern
    * @param dateCreated Datum och tid då ordern skapades
    * @param problemDescr Kundens beskrivning av problemet
    * @param customer Kunden som lämnat in cykeln
    * @param diagnosticResult Resultatet av diagnosen
    * @param repairTasks Lista över reparationsåtgärder
    * @param accepted Om ordern är accepterad eller inte
    */
    public OrderDTO(String id,
        LocalDateTime dateCreated,
        String problemDescr,
        CustomerDTO customer,
        String diagnosticResult,
        List<RepairTaskDTO> repairTasks,
        boolean accepted) {

            this.id = id;
            this.dateCreated = dateCreated;
            this.problemDescr = problemDescr;
            this.customer = customer;
            this.diagnosticResult = diagnosticResult;
            this.repairTasks = new ArrayList<RepairTaskDTO>(repairTasks);
            this.accepted = accepted;
}
    
    /**
     * @return Reparationsorderns Id
     */
    public String getId(){
        return id;
    }
    /**
     * @return Datum och tid ordern skapades
     */
    public LocalDateTime getDateCreated(){
        return dateCreated;
    } 
    /**
     * @return Kundens problembeskrivning
     */
    public String getProblemDescr(){
        return problemDescr;
    }
    /**
     * @return Kunden som lämnat in sin cykel
     */
    public CustomerDTO getCustomer(){
        return customer;
    } 
    /**
     * @return Resultatet av diagnosen
     */
    public String getDiagnosticResult(){
        return diagnosticResult;
    }
    /**
     * @return Lista över reparationsåtgärderna
     */
    public List<RepairTaskDTO> getRepairTasks(){
        return new ArrayList<>(repairTasks);
    }
  
    /**
    * @return true om ordern är accepterad, annars false.
    */
    public boolean isAccepted(){
    return accepted;
}

   
   
}

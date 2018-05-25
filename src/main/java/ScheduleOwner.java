public class ScheduleOwner {
    public int id;
    public int numberOfTheSchemaId;
    public String userOwnerId;
    public boolean main;

    public ScheduleOwner(int id, int numberOfTheSchemaId, String userOwnerId, boolean main) {
        this.id = id;
        this.numberOfTheSchemaId = numberOfTheSchemaId;
        this.userOwnerId = userOwnerId;
        this.main = main;
    }
}

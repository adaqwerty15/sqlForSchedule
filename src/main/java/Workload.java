public class Workload {
    public int id;
    public int studentClassId;
    public int subjectId;
    public int userId;

    public Workload(int id, int studentClassId, int subjectId, int userId) {
        this.id = id;
        this.studentClassId = studentClassId;
        this.subjectId = subjectId;
        this.userId = userId;
    }
}

public class Schedule {
    public int id;
    public int subjectId;
    public int studentClassId;
    public int cabinetId;
    public int dayId;
    public int numberOfTheSchema;
    public int numberOfTheLesson;

    public Schedule(int id, int subjectId, int studentClassId, int cabinetId, int dayId, int numberOfTheSchema,
                    int numberOfTheLesson) {
        this.id = id;
        this.subjectId = subjectId;
        this.studentClassId = studentClassId;
        this.cabinetId = cabinetId;
        this.dayId = dayId;
        this.numberOfTheSchema = numberOfTheSchema;
        this.numberOfTheLesson = numberOfTheLesson;
    }
}

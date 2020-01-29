public class Schedule {
    public int id;
    public int subjectId;
    public int studentClassId;
    public int cabinetId;
    public int dayId;
    public int numberOfTheSchema;
    public int numberOfTheLesson;
    int errorCode;

    public Schedule(int id, int subjectId, int studentClassId, int cabinetId, int dayId, int numberOfTheSchema,
                    int numberOfTheLesson, int errorCode) {
        this.id = id;
        this.subjectId = subjectId;
        this.studentClassId = studentClassId;
        this.cabinetId = cabinetId;
        this.dayId = dayId;
        this.numberOfTheSchema = numberOfTheSchema;
        this.numberOfTheLesson = numberOfTheLesson;
        this.errorCode = errorCode;
    }

    public Schedule() {
        this.errorCode = 1;
    }

    public Schedule(int errorCode) {
        this.errorCode = 0;
    }
}

public class StudentsClass {
    public int id;
    public int shiftId;
    public String code;
    public int  course;
    public int errorCode;

    public StudentsClass(int id, int shiftId, String code, int course, int errorCode) {
        this.id = id;
        this.shiftId = shiftId;
        this.code = code;
        this.course = course;
        this.errorCode = errorCode;
    }

    public StudentsClass() {
        this.errorCode = 1;
    }

    public StudentsClass(int errorCode) {
        this.errorCode = 0;
    }
}

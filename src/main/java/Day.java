public class Day {
    public int id;
    public String name;
    int errorCode;

    public Day(int id, String name, int errorCode) {
        this.id = id;
        this.name = name;
        this.errorCode = errorCode;
    }

    public Day() {
        this.errorCode = 1;
    }

    public Day(int errorCode) {
        this.errorCode = 0;
    }
}

public class Cabinet {
    public int id;
    public String name;
    int errorCode;

    public Cabinet(int id, String name, int errorCode) {
        this.id = id;
        this.name = name;
        this.errorCode = errorCode;
    }

    public Cabinet() {
        this.errorCode = 1;
    }

    public Cabinet(int errorCode) {
        this.errorCode = 0;
    }
}

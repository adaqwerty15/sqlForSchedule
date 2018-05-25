public class User {
    public int id;
    public int roleId;
    public String name;
    public String surname;
    public String fathername;
    public String login;
    public String password;
    public int errorCode;

    public User(int id, int roleId, String name, String surname, String fathername, String login,
                String password, int errorCode) {
        this.id = id;
        this.roleId = roleId;
        this.name = name;
        this.surname = surname;
        this.fathername = fathername;
        this.login = login;
        this.password = password;
        this.errorCode = errorCode;
    }

    public User() {
        this.errorCode = 1;
    }

    public User(int errorCode) {
        this.errorCode = 0;
    }

}

public class Role {
    public int id;
    public String name;
    public boolean classAccess;
    public boolean scheduleAccess;
    public boolean usersAccess;

    public Role(int id, String name, boolean classAccess, boolean scheduleAccess, boolean usersAccess) {
        this.id = id;
        this.name = name;
        this.classAccess = classAccess;
        this.scheduleAccess = scheduleAccess;
        this.usersAccess = usersAccess;
    }
}

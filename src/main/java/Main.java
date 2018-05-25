import com.google.gson.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import static spark.Spark.*;


public class Main {

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        ProcessBuilder process = new ProcessBuilder();
        if (process.environment().get("PORT") != null) {
            port(Integer.parseInt(process.environment().get("PORT")));
        } else {
            port(8080);
        }


        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:db.sqlite");
        Gson gson = new GsonBuilder().create();

        Statement stmt2 = conn.createStatement();
        stmt2.execute("CREATE TABLE if not exists `users` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `roleId` integer, `name` text," +
                " `surname` text, `fathername` text, `login` text,  `password` text, `errorCode` integer);");

        Statement stmt3 = conn.createStatement();
        stmt3.execute("CREATE TABLE if not exists `studentsClass` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `shiftId` integer, `code` text," +
                " `course` integer, `errorCode` integer);");



        get("/users", (request,response) -> {
            response.type("application/json");
            PreparedStatement stmnt = conn.prepareStatement(
                    "SELECT * FROM `users`"
            );
            ResultSet rs = stmnt.executeQuery();
            List<User> users = new ArrayList<>();
            while (rs.next()){
                users.add(new User(
                        rs.getInt("id"),
                        rs.getInt("roleId"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("fathername"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getInt("errorCode")));
            }
            return users;
        }, gson::toJson);

        get("/studentsClass", (request,response) -> {
            response.type("application/json");
            PreparedStatement stmnt = conn.prepareStatement(
                    "SELECT * FROM `studentsClass`"
            );
            ResultSet rs = stmnt.executeQuery();
            List<StudentsClass> studentsClasses = new ArrayList<>();
            while (rs.next()){
                studentsClasses.add(new StudentsClass(
                        rs.getInt("id"),
                        rs.getInt("shiftId"),
                        rs.getString("code"),
                        rs.getInt("course"),
                        rs.getInt("errorCode")));
            }
            return studentsClasses;
        }, gson::toJson);

        get("/users/:id", (request,response) -> {
            response.type("application/json");
            int userID = Integer.parseInt(request.params("id"));
            PreparedStatement stmnt = conn.prepareStatement(
                    "SELECT * FROM `users` WHERE `id` = ?"
            );
            stmnt.setInt(1,userID);
            ResultSet rs = stmnt.executeQuery();
            User user = new User();
            while (rs.next()){

                 user = (new User(
                        rs.getInt("id"),
                        rs.getInt("roleId"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("fathername"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getInt("errorCode")));
            }

            return user;
        }, gson::toJson);

        get("/studentsClass/:id", (request,response) -> {
            response.type("application/json");
            int classID = Integer.parseInt(request.params("id"));
            PreparedStatement stmnt = conn.prepareStatement(
                    "SELECT * FROM `studentsClass` WHERE `id` = ?"
            );
            stmnt.setInt(1,classID);
            ResultSet rs = stmnt.executeQuery();

            StudentsClass studentsClass = new StudentsClass();

            while (rs.next()){
                studentsClass = (new StudentsClass(
                        rs.getInt("id"),
                        rs.getInt("shiftId"),
                        rs.getString("code"),
                        rs.getInt("course"),
                        rs.getInt("errorCode")));
            }
            return studentsClass;
        }, gson::toJson);

        delete("/users/:id",(request,response)->{
            int userID = Integer.parseInt(request.params("id"));
            PreparedStatement stmnt = conn.prepareStatement(
                    "DELETE FROM `users` WHERE `id` = ?"
            );
            stmnt.setInt(1,userID);
            stmnt.executeUpdate();
            return new User(0);
        }, gson::toJson);

        delete("/studentsClass/:id",(request,response)->{
            int classID = Integer.parseInt(request.params("id"));
            PreparedStatement stmnt = conn.prepareStatement(
                    "DELETE FROM `studentsClass` WHERE `id` = ?"
            );
            stmnt.setInt(1,classID);
            stmnt.executeUpdate();
            return new StudentsClass(0);
        }, gson::toJson);

        post("/users",(request,response)->{
            User user = gson.fromJson(request.body(), User.class);
            PreparedStatement stmnt = conn.prepareStatement(
                    "INSERT INTO `users` (roleId, name, surname, fathername, " +
                            "login, password, errorCode) VALUES (?,?,?,?,?,?,?)"
            );

            stmnt.setInt(1,user.roleId);
            stmnt.setString(2,user.name);
            stmnt.setString(3,user.surname);
            stmnt.setString(4,user.fathername);
            stmnt.setString(5,user.login);
            stmnt.setString(6,user.password);
            stmnt.setInt(7,0);
            stmnt.executeUpdate();

            return user;
        }, gson::toJson);

        post("/studentsClass",(request,response)->{
            StudentsClass studentsClass = gson.fromJson(request.body(), StudentsClass.class);
            PreparedStatement stmnt = conn.prepareStatement(
                    "INSERT INTO `studentsClass` (shiftId, code, course, errorCode) VALUES (?,?,?,?)"
            );

            stmnt.setInt(1,studentsClass.shiftId);
            stmnt.setString(2,studentsClass.code);
            stmnt.setInt(3,studentsClass.course);
            stmnt.setInt(4,0);
            stmnt.executeUpdate();

            return studentsClass;
        }, gson::toJson);

        put("/users/:id",(request,response)->{
            int userID = Integer.parseInt(request.params("id"));
            User user = gson.fromJson(request.body(), User.class);
            PreparedStatement stmnt = conn.prepareStatement(
                    "UPDATE `users` SET `roleId`=?,`name`=?, `surname`=?, " +
                            "`fathername`=?, `login`=?, `password`=?, `errorCode`=? WHERE `id`=?"

            );

            stmnt.setInt(1,user.roleId);
            stmnt.setString(2,user.name);
            stmnt.setString(3,user.surname);
            stmnt.setString(4,user.fathername);
            stmnt.setString(5,user.login);
            stmnt.setString(6,user.password);
            stmnt.setInt(7,0);
            stmnt.setInt(8,userID);
            stmnt.executeUpdate();
            return user;
        }, gson::toJson);

        put("/studentsClass/:id",(request,response)->{
            int classID = Integer.parseInt(request.params("id"));
            StudentsClass studentsClass = gson.fromJson(request.body(), StudentsClass.class);
            PreparedStatement stmnt = conn.prepareStatement(
                    "UPDATE `studentsClass` SET `shiftId`=?,`code`=?, `course`=?, `errorCode`=? WHERE `id`=?");

            stmnt.setInt(1,studentsClass.shiftId);
            stmnt.setString(2,studentsClass.code);
            stmnt.setInt(3,studentsClass.course);
            stmnt.setInt(4,0);
            stmnt.setInt(5,classID);
            stmnt.executeUpdate();
            return studentsClass;
        }, gson::toJson);

    }
}

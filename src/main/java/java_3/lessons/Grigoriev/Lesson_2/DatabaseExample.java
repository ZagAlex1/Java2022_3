package java_3.lessons.Grigoriev.Lesson_2;

import java.sql.*;

public class DatabaseExample {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement ps;
    private static String insertStatement = "insert into students (name, score) values (?, ?);";
    private static final String EXAMPLE_CALL = "{call do_something_prc(?,?,?)}";
    private static final String DB_CONNECTION_STRING = "jdbc:sqlite:db/example.db";
    public static final String CREATE_REQUEST = "create table if not exists students " +
            "(id integer primary key autoincrement, name text, score integer);";
    public static final String DROP_REQUEST = "drop table if exists students;";
    public static final String SIMPLE_INSERT_REQUEST =
            "insert into students (name, score) values ('Vasya Pupkin', 80), ('Kolya Morzhov', 90), " +
                    "('Vitaly Petrov', 100);";

    public static void main(String[] args) {
        try {
            connect();
            statement = connection.createStatement();
            createTable();
//            simpleInsertExample();
//            simpleDropTable();
//            simpleUpdate();
//            simpleRead();
//            simpleDelete();
//            notReallyCorrectInsert("Pavel', 200); drop table students;", 200); //- нехороший Павел удалит таблицу
//            var name = "Pavel";
//            var score = 200;
            ps = connection.prepareStatement(insertStatement);
//            preparedInsert(name, score);
//            var evilName = "Pavel', 200); drop table students;";
//            preparedInsert(evilName, score);
//            massInsert();
//            massInsertTransactions();
//            massInsertWithBatch();

            CallableStatement cs = connection.prepareCall(EXAMPLE_CALL);  //Вызов функций и процедур
            cs.setObject(1, "asdads");
            cs.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }
    private static void massInsertWithBatch() throws SQLException {
        var start= System.currentTimeMillis();
        connection.setAutoCommit(false);
        for (int i = 0; i < 5000; i++) {
            ps.setString(1, "Student #" + i);
            ps.setInt(2, i);
            ps.addBatch();
        }
        ps.executeBatch();
//        connection.commit();
        connection.setAutoCommit(true);
        System.out.println(System.currentTimeMillis() - start);
    }
    private static void massInsertTransactions() throws SQLException {
        var start= System.currentTimeMillis();
        connection.setAutoCommit(false);
        for (int i = 0; i < 5000; i++) {
            preparedInsert("Student #" + i, i);
        }
//        connection.commit();
        connection.setAutoCommit(true);
        System.out.println(System.currentTimeMillis() - start);
    }
    private static void massInsert() throws SQLException {
        var start= System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedInsert("Student #" + i, i);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void preparedInsert(String name, int score) throws SQLException {
        ps.setString(1, name);
        ps.setInt(2, score);
        ps.executeUpdate();
    }

    private static void notReallyCorrectInsert(String name, int score) throws SQLException {
        var count = statement.executeUpdate("insert into students (name, score) " +
                "values ('" + name + "', " + score + ");");
        System.out.printf("Update %d rows\n", count);
    }

    private static void simpleDelete() throws SQLException {
        statement.executeUpdate("delete from students where score < 100;");
    }

    private static void simpleRead() throws SQLException {
        try (ResultSet rs = statement.executeQuery("select name, id, score from students order by score desc;")) {
            while (rs.next()) {
                System.out.printf("Student:\n  ID: %d\n  name: %s\n  score: %d\n\n",
                        rs.getInt(2),
                        rs.getString("name"),
                        rs.getInt("score"));
            }
        }
    }

    private static void simpleUpdate() throws SQLException {
        var count = statement.executeUpdate("update students set name = 'looser' where score < 100");
        System.out.printf("Update %d rows\n", count);
    }

    private static void simpleDropTable() throws SQLException {
        statement.execute(DROP_REQUEST);
    }

    private static void simpleInsertExample() throws SQLException {
        var count = statement.executeUpdate(SIMPLE_INSERT_REQUEST);
        System.out.printf("Inserted %d rows\n", count);
    }

    private static void createTable() throws SQLException {
        statement.execute(CREATE_REQUEST);
    }

    public static void connect() throws SQLException {
//        try {
//            Class.forName("org.sqlite.JDBC");            // Сейчас это не обязательно
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        connection = DriverManager.getConnection(DB_CONNECTION_STRING);
    }

    private static void disconnect() {
        try {
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null) ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

package testing.database;

import java.sql.SQLException;

public class DataBase implements DbInt {
    @Override
    public String find(int id) {
        System.out.println("Find " + id);
        if (id < 100) return "Test name";
        else return null;
    }

    @Override
    public int save(int id, String name) throws SQLException {
        System.out.println("Saving " + id);
        if (id < 10) return 1;
        else throw new java.sql.SQLException("SQL Error");
    }
}

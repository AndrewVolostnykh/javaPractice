package testing.database;

import java.sql.SQLException;

public interface DbInt {
    String find(int id);
    int save(int id, String name) throws SQLException;
}

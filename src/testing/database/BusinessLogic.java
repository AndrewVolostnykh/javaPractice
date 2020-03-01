package testing.database;

public class BusinessLogic {
    public int editItem(int id, String newName, DbInt db) throws java.sql.SQLException
    {
        System.out.println("Editing item " + id);
        String itemName = db.find(id);
        if (itemName != null)
        {
            itemName = newName;
            int res = db.save(id, itemName);
            if (res == 2) System.out.println("res = 2 !!!");
        }
        else throw new IllegalArgumentException("record with id = " + id + " not normal");
        return 1;
    }
}

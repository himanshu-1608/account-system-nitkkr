package account.system.dao;

public class DbDAOFactory {
    public static DbDAO dbDAO = null;
    public static DbDAO getInstance() {
        if(dbDAO == null) {
            dbDAO = new DbDAOImpl();
        }
        return dbDAO;
    }
}
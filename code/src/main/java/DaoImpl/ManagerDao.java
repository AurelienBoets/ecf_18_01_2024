package DaoImpl;

import Dao.Dao;
import Model.Manager;

import java.util.List;

public class ManagerDao implements Dao<Manager> {

    @Override
    public Class<Manager> getEntityClass() {
        return Manager.class;
    }
}

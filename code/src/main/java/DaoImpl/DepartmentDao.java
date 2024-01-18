package DaoImpl;

import Dao.Dao;
import Model.Department;

import java.util.List;

public class DepartmentDao implements Dao<Department> {

    @Override
    public Class<Department> getEntityClass() {
        return Department.class;
    }
}

package DaoImpl;

import Dao.Dao;
import Model.Teacher;

public class TeacherDao implements Dao<Teacher> {
    @Override
    public Class<Teacher> getEntityClass() {
        return Teacher.class;
    }
}

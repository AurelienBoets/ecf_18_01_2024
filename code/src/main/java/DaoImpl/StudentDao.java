package DaoImpl;

import Dao.Dao;
import Model.Student;

public class StudentDao implements Dao<Student> {
    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }
}

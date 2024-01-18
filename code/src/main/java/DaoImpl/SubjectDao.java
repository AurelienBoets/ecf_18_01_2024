package DaoImpl;

import Dao.Dao;
import Model.Subject;

public class SubjectDao implements Dao<Subject> {
    @Override
    public Class<Subject> getEntityClass() {
        return Subject.class;
    }
}

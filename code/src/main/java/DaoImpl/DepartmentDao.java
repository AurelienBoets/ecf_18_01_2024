package DaoImpl;

import Dao.Dao;
import Model.Department;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DepartmentDao implements Dao<Department> {

    @Override
    public Class<Department> getEntityClass() {
        return Department.class;
    }

    public long countStudent(long idDepartment){
        Session session= sessionFactory.openSession();
        String hql="SELECT count (s) FROM Student s JOIN s.classRoom c JOIN c.mainTeacher t JOIN t.department d WHERE d.id=:d";
        Query<Long> query= session.createQuery(hql, Long.class);
        query.setParameter("d",idDepartment);
        long count=query.uniqueResult();
        session.close();
        return count;
    }
}

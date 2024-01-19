package DaoImpl;

import Dao.Dao;
import Model.Note;
import Model.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDao implements Dao<Student> {
    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    public long countSubject(Student student) {
        Session session = sessionFactory.openSession();
        String hql = "SELECT COUNT(DISTINCT n.subject) FROM Note n WHERE n.student= :student";
        Query<Long> query = session.createQuery(hql, Long.class);
        query.setParameter("student", student);
        long count = query.uniqueResult();
        session.close();
        return count;
    }

    public List<Note> getNote(Student student) {
        Session session = sessionFactory.openSession();
        Query<Note> query = session.createQuery("FROM Note n WHERE n.student=:student", Note.class);
        query.setParameter("student", student);
        List<Note> notes = query.getResultList();
        session.close();
        return notes;
    }

    public float getAverage(Student student) {
        Session session = sessionFactory.openSession();
        Query<Float> query=session.createQuery("SELECT avg(n.value) from Note n where n.student=:student", Float.class);
        query.setParameter("student",student);
        float average=query.uniqueResult();
        session.close();
        return average;
    }

    public List<Student> getByLevel(String level){
        Session session= sessionFactory.openSession();
        String hql="FROM Student s JOIN s.classRoom c WHERE c.level=:level";
        Query<Student> query= session.createQuery(hql, Student.class);
        query.setParameter("level",level);
        List<Student> students=query.getResultList();
        session.close();
        return students;
    }
}

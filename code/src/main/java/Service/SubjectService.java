package Service;

import DaoImpl.SubjectDao;
import Model.Subject;

public class SubjectService {

    private final SubjectDao subjectDao=new SubjectDao();

    public void create(String title,String description,int duration,float coefficient){
        Subject subject=new Subject(title,description,duration,coefficient);
        subjectDao.create(subject);
    }
}

package Service;

import DaoImpl.TeacherDao;
import Model.Teacher;

import java.util.Random;

public class TeacherService {
    private final TeacherDao teacherDao=new TeacherDao();

    public boolean create(String lastname,String firstname,int year){
        if(lastname.length()<3)
            return false;
        if(year<18)
            return false;
        String letter="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random rand=new Random();
        StringBuilder serialNumber=new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int position=rand.nextInt(letter.length());
            serialNumber.append(letter.charAt(position));
        }
        Teacher teacher=new Teacher(serialNumber.toString(),lastname,firstname,year);
        teacherDao.create(teacher);
        return true;
    }

}

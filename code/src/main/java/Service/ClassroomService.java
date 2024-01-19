package Service;

import DaoImpl.*;
import Model.*;
import Model.Class;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ClassroomService {
    private final StudentDao studentDao=new StudentDao();
    private final ClassDao classDao=new ClassDao();
    private final NoteDao noteDao=new NoteDao();
    private final SubjectDao subjectDao=new SubjectDao();
    private final TeacherDao teacherDao=new TeacherDao();

    private final ScheduleDao scheduleDao=new ScheduleDao();

    public boolean createStudent(String lastname,String firstname,String birthday,String mail,long idClass){
        if(!mail.endsWith("@gmail.com"))
            return false;
        if(lastname.length()<3)
            return false;
        DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate=LocalDate.parse(birthday,format);
        Class classroom= classDao.getById(idClass);
        if(classroom==null)
            return false;
        Student student=new Student(lastname,firstname,localDate,mail,classroom);
        studentDao.create(student);
        return true;
    }

    public boolean createNote(float value,String comment,long idSubject,long idStudent){
        if(value>20 || value<0)
            return false;
        Subject subject=subjectDao.getById(idSubject);
        Student student=studentDao.getById(idStudent);
        if(student ==null || subject==null)
            return false;
        Note note=new Note(value,comment,subject,student);
        noteDao.create(note);
        return true;
    }

    public boolean createClass(String name,String level,long idMainTeacher){
        Teacher teacher=teacherDao.getById(idMainTeacher);
        if(teacher==null)
            return false;
        Class classroom=new Class(name,level,teacher);
        return true;
    }

    public boolean createSchedule(String date,String time,long idClass,long idSubject,long idTeacher){
        Class classroom=classDao.getById(idClass);
        Subject subject=subjectDao.getById(idSubject);
        Teacher teacher=teacherDao.getById(idTeacher);
        if(classroom==null || subject==null || teacher==null)
            return false;
        String dateTime=date+" "+time;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime=LocalDateTime.parse(dateTime,formatter);
        Schedule schedule=new Schedule(localDateTime,classroom,subject,teacher);
        scheduleDao.create(schedule);
        return true;
    }

    public List<Class> getAllClass(){
        return classDao.getAll();
    }

    public long getCountSubject(long idStudent){
        Student student=studentDao.getById(idStudent);
        if(student==null)
            return 0;
        return studentDao.countSubject(student);
    }

    public List<Note> getNote(long idStudent){
        Student student=studentDao.getById(idStudent);
        if(student==null)
            return null;
        return studentDao.getNote(student);
    }

    public List<Student> getByLevel(String level){
        return studentDao.getByLevel(level);
    }

    public boolean deleteStudent(long idStudent){
        Student student=studentDao.getById(idStudent);
        if(student==null)
            return false;
        studentDao.remove(idStudent);
        return true;
    }

    public boolean deleteClass(long idClass){
        Class classroom=classDao.getById(idClass);
        if(classroom==null)
            return false;
        studentDao.remove(idClass);
        return true;
    }
}

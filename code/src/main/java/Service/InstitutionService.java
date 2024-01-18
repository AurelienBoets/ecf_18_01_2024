package Service;

import DaoImpl.DepartmentDao;
import DaoImpl.InstitutionDao;
import Model.Department;
import Model.Institution;

public class InstitutionService {
    private final DepartmentDao departmentDao=new DepartmentDao();
    private final InstitutionDao institutionDao=new InstitutionDao();

    public boolean create(String name,long idInstitution){
        Institution institution=institutionDao.getById(idInstitution);
        if(institution==null)
            return false;
        Department department=new Department(name,institution);
        departmentDao.create(department);
        return true;
    }

    public void create(String name){
        Institution institution=new Institution(name);
        institutionDao.create(institution);
    }

    public Institution getInstitution(long idInstitution){
        return institutionDao.getById(idInstitution);
    }

    public Department getDepartment(long idDepartment){
        return departmentDao.getById(idDepartment)
    }
}

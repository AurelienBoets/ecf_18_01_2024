package DaoImpl;

import Dao.Dao;
import Model.Schedule;

public class ScheduleDao implements Dao<Schedule> {
    @Override
    public Class<Schedule> getEntityClass() {
        return null;
    }
}

package DaoImpl;

import Dao.Dao;

import java.util.List;

public class ClassDao implements Dao<Model.Class> {

    @Override
    public Class<Model.Class> getEntityClass() {
        return Model.Class.class;
    }
}

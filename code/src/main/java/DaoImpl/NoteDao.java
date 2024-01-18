package DaoImpl;

import Dao.Dao;
import Model.Note;

public class NoteDao implements Dao<Note> {
    @Override
    public Class<Note> getEntityClass() {
        return Note.class;
    }
}

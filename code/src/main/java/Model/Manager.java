package Model;

import javax.persistence.*;

@Entity
@Table(name = "managers")
public class Manager {
    @EmbeddedId
    private ManagerKey id;

    public Manager() {
    }

    public Manager(ManagerKey id) {
        this.id = id;
    }

    public ManagerKey getId() {
        return id;
    }

    public void setId(ManagerKey id) {
        this.id = id;
    }
}

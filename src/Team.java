import javax.persistence.*;

@Entity
public class Team {
    @Id
    @GeneratedValue(generator = "increment")
    private int id;
    @Basic
    @Column(nullable = false)
    private String name;

    public Team(){

    }
    public Team(String name){

        this.name = name;
    }
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

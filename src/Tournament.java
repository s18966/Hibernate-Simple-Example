import javax.persistence.*;

@Entity
public class Tournament {
    @Id
    @GeneratedValue(generator = "increment")
    private int id;
    @Basic
    @Column(nullable = false)
    private String name;
    @Basic
    @Column(nullable = false)
    private double prizePool;


    public Tournament(){

    }
    public Tournament(String name, double prizePool){
        this.name = name;
        this.prizePool = prizePool;
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

    public double getPrizePool() {
        return prizePool;
    }

    public void setPrizePool(double prizePool) {
        this.prizePool = prizePool;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prizePool=" + prizePool +
                '}';
    }
}

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "player")
public class Player extends Person {
    @Basic
    @Column(nullable = false)
    private double salary;
    @Enumerated
    @Column(nullable = false)
    private Role role;
    @ManyToOne
    private Team team;
    public enum Role{
        CARRY, SUPPORT, MIDLANE, OFFLANE, HARD_SUPPORT
    }
    public Player(){}

    public Player(String name, String surname, String middleName, LocalDate birthDate, double salary, Role role, Team team) {
        super(name, surname, middleName, birthDate);
        this.salary = salary;
        this.role = role;
        this.team = team;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    @Override
    public String toString() {
        String p = super.toString();
        return p + "Player{" +
                "salary=" + salary +
                ", role=" + role +
                '}';
    }
}

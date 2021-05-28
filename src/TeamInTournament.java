import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class TeamInTournament {
    @Id
    @GeneratedValue(generator = "increment")
    private int id;

    @Basic
    private int place;
    @ManyToOne
    private Tournament tournament;
    @ManyToOne
    private Team team;
    public int getId() {
        return id;
    }
    public TeamInTournament(){}

    public TeamInTournament(int place,  Team team, Tournament tournament) {

        this.place = place;
        this.team = team;
        this.tournament=tournament;
    }

    private void setId(int id) {
        this.id = id;
    }


    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "TeamInTournament{" +
                "id=" + id +
                ", place=" + place +
                ", tournament=" + tournament +
                ", team=" + team +
                '}';
    }
}

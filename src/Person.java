import javax.persistence.*;
import java.time.LocalDate;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "person")

public abstract class Person {
    @Id
    @GeneratedValue(generator = "increment")
    private int id;
    @Basic
    @Column(nullable = false)
    private String name;
    @Basic
    @Column(nullable = false)
    private String surname;
    @Basic
    @Column(nullable = false)
    private String middleName;
    @Basic
    @Column(nullable = false)
    private LocalDate birthDate;


    public Person(){

    }
    public Person(String name, String surname, String middleName,LocalDate birthDate){
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.birthDate = birthDate;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }



    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthDate=" + birthDate.toString() +
                '}';
    }
}

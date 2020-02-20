import javax.persistence.*;

@Entity
public class Type {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer typeId;
    String name;

    @ManyToOne
    @JoinColumn (name = "typeId")
    Item idStatusItem;

    @Override
    public String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", name='" + name + '\'' +
                ", idStatusItem=" + idStatusItem +
                '}';
    }
}

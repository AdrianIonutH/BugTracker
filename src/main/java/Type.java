import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Type {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer typeId;
    String name;

    @Override
    public String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", name='" + name + '\'' +
                '}';
    }
}

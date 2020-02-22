import javax.persistence.*;

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

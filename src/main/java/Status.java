import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer typeId;
    String statusName;

    @Override
    public String toString() {
        return "Status{" +
                "typeId=" + typeId +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}

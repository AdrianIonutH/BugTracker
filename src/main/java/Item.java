import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer itemId;
    String title;
    String description;
    Integer statusId;
    Integer typeId;

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", statusId=" + statusId +
                ", typeId=" + typeId +
                '}';
    }
}

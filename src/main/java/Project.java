import javax.persistence.*;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer projectId;

    String name;
    String shortName;
    String description;


@ManyToOne
@JoinColumn (name = "statusId")
Status statusIdForeignKey;

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", description='" + description + '\'' +
                ", statusIdForeignKey=" + statusIdForeignKey.statusId +
                '}';
    }
//    @Override
//    public String toString() {
//        return "Project{" +
//                "projectId=" + projectId +
//                ", name='" + name + '\'' +
//                ", shortName='" + shortName + '\'' +
//                ", description='" + description + '\'' +
//                ", statusId=" + statusId +
//                '}';
//    }
}

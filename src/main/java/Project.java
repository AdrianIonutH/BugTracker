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
    Integer statusId;

@OneToMany
        (mappedBy = "idStatusProject")
List<Status> Status;

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", description='" + description + '\'' +
                ", statusId=" + statusId +
                ", Status=" + Status +
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

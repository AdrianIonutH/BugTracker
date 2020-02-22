import javax.persistence.*;
import java.util.List;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer statusId;

    String statusName;

    @OneToMany (mappedBy = "statusIdForeignKey")
    List<Project> projectList;


    @Override
    public String toString() {
        return "Status{" +
                "statusId=" + statusId +
                ", statusName='" + statusName + '\'' +
                ", projectList=" + projectList +
                '}';
    }
    //    @Override
//    public String toString() {
//        return "Status{" +
//                "typeId=" + statusId +
//                ", statusName='" + statusName + '\'' +
//                '}';
//    }
}

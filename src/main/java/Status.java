import javax.persistence.*;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer statusId;
    String statusName;

    @ManyToOne
    @JoinColumn (name = "statusId")
    Project idStatusProject;

    @ManyToOne
    @JoinColumn (name = "statusId")
    Item idStatusItem;

    @Override
    public String toString() {
        return "Status{" +
                "statusId=" + statusId +
                ", statusName='" + statusName + '\'' +
                ", idStatusProject=" + idStatusProject +
                ", idStatusItem=" + idStatusItem +
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

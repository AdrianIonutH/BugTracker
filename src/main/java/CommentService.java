import org.hibernate.Session;
import org.hibernate.Transaction;

public class CommentService {
    private static CommentService instance;
    private CommentService(){

    }
    public static CommentService getInstance(){
        if (instance == null){
            instance = new CommentService();
        }
        return instance;
    }
    public Comment getComment(Integer id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Comment commentById = session.find(Comment.class, id);
            System.out.println(commentById);
            return commentById;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public void createComment(int itemId, Comment createComment){
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(createComment);
            transaction.commit();
            session.close();
        }catch (Exception ex){
            if (transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
    public void updateComment(int id, String updateComment) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Comment commentById = getComment(id);
            commentById.text = updateComment;
            session.update(commentById);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
    public void deleteComment(int id) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Comment commentById = getComment(id);
            session.delete(commentById);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}

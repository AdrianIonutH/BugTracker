public class HibernateRunner {
    public static void main(String[] args) {
        CommentService commentService = CommentService.getInstance();
        //commentService.updateComment(1,"macarena");
        //commentService.createComment(1,"mdmdmm");
        commentService.deleteComment(2);
    }
}

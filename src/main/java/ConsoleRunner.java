import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        ProjectService projectService = ProjectService.getInstance();
        System.out.println("Bine ai venit!");
        Scanner in = new Scanner(System.in);
        System.out.println("Alege optiunea: ");

        System.out.println("1. Vezi proiect");
        System.out.println("2. Introdu proiect");
        System.out.println("3. Iesire");

        ConsoleRunnerService proiect = new ConsoleRunnerService();

        while (true) {
            Integer option = in.nextInt();
            if (option == 1) {
                proiect.veziProiecte();
                System.out.println("Apasa 0 pentru a te intoarce!");

                while (true){
                    int option2 = in.nextInt();
                    proiect.vizualizareProiectId(option2);
                    proiect.meniuEditareStergere();

                        int option3 = in.nextInt();
                        if (option3 == 1){
                            Project projectById = projectService.getProject(option2);
                            Scanner upd = new Scanner(System.in);
                            System.out.println("Introduceti un text nou: ");
                            String update = upd.nextLine();
                            projectById.description = update;
                            projectService.updateProject(projectById);
                        } else if (option3 == 2){
                            projectService.deleteProject(option2);
                        } else if (option3 == 0){
                            proiect.veziProiecte();
                        }
                }
            }
//            else if (option == 0){
//                System.out.println("Alege optiunea: ");
//                System.out.println("1. Vezi proiect");
//                System.out.println("2. Introdu proiect");
//                System.out.println("3. Iesire");
//            }
        }
    }
}

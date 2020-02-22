import java.util.Scanner;

public class ConsoleRunnerService {
    public void veziProiecte(){
        ProjectService projectService = ProjectService.getInstance();
        projectService.selectAllProject();
    }


    public void vizualizareProiectId(int idProiect){
        ProjectService projectService = ProjectService.getInstance();
        projectService.getProject(idProiect);

    }
    public void meniuEditareStergere(){
        System.out.println("1. Editeaza");
        System.out.println("2. Sterge");
        System.out.println("0. Inapoi");
    }
}

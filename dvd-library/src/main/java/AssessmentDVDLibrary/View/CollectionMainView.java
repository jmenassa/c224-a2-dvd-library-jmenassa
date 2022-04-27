package AssessmentDVDLibrary.View;

import java.util.Scanner;

public class CollectionMainView extends ViewUtility {

    private Scanner sc;

    public String showMenu(){
        sc = new Scanner(System.in);
        format('=', 50);
        System.out.println("\nMain Menu: Chose one option");
                format('=', 50) ;
        System.out.println("\n1. Add a DVD to the Collection." +
                "\n2. Remove a DVD from the Collection." +
                "\n3. Edit a DVD informations." +
                "\n4. List all DVD from the collection." +
                "\n5. Display the information of a specific DVD." +
                "\n6. Search for a DVD by title." +
                "\n7. Exit.");
        return sc.next();
    }

    public String getInput(String action){
        sc = new Scanner(System.in);
        System.out.print("What is the id of the DVD you want to " + action + "? ");
        return sc.next();
    }
}

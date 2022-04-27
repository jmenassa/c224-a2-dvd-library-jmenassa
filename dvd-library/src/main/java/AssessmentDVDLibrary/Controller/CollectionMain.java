package AssessmentDVDLibrary.Controller;

import AssessmentDVDLibrary.View.CollectionMainView;

import java.io.File;

public class CollectionMain {
    private static final String fileName = "DVDCollection.json";
    private static final File file = new File(CollectionMain.class.getClassLoader()
            .getResource(fileName).getFile());

    private static final CollectionMainView view = new CollectionMainView();
    private static final DVDController dvdCont = new DVDController();

    public static void main(String[] args) {
        dvdCont.readFile(file);
        mainMenu();

    }

    private static void mainMenu() {
        String input = view.showMenu();

        switch (input){
            //Add dvd
            case "1":
                dvdCont.addDvdToCollection();
                break;

            //Remove a dvd with id
            case "2":
                String idInput = view.getInput("delete");
                try{
                    int id = Integer.parseInt(idInput);
                    boolean success = dvdCont.removeDvdFromCollection(id);
                    if(success){
                        view.showSuccessMsg();
                    }else{
                        view.showErrorMsg("The selected id is not valid.");
                    }
                }catch (NumberFormatException ex){
                    view.showExceptionMsg(ex);
                }
                break;

            //Edit DVD with id
            case "3":
                idInput = view.getInput("edit");
                try{
                    int id = Integer.parseInt(idInput);
                    boolean success = dvdCont.editDVD(id);
                    if(success){
                        view.showSuccessMsg();
                    }else{
                        view.showErrorMsg("The selected id is not valid.");
                    }
                }catch (NumberFormatException ex){
                    view.showExceptionMsg(ex);
                }
                break;

            //List DVD
            case "4":
                dvdCont.showCollection();
                break;

            //Display info of a DVD with id
            case "5":
                idInput = view.getInput("see");
                try{
                    int id = Integer.parseInt(idInput);
                    boolean success = dvdCont.showDVDWithID(id);
                    if(success){
                        view.showSuccessMsg();
                    }else{
                        view.showErrorMsg("The selected id is not valid.");
                    }
                }catch (NumberFormatException ex){
                    view.showExceptionMsg(ex);
                }
                break;

            //Search for a DVD by title
            case "6":
                input = view.getInput("see (search with title name)");
                boolean success = dvdCont.showDVDWithTitle(input);
                if(success){
                    view.showSuccessMsg();
                }else {
                    view.showErrorMsg("The selected title was not found.");
                }
                break;

            //Exit
            case "7":
                System.exit(0);
                break;
            default:
                view.showErrorMsg("Please enter a number: 1, 2, 3, 4, 5, 6, 7");
                break;
        }
        mainMenu();
    }
}

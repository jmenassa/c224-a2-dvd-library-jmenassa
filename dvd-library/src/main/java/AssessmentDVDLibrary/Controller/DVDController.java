package AssessmentDVDLibrary.Controller;

import AssessmentDVDLibrary.Model.DVD;
import AssessmentDVDLibrary.Utility.FileTreatment;
import AssessmentDVDLibrary.View.DVDView;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class DVDController implements Collection{

    private final DVDView view;
    private static List<DVD> DVDCollectionList = new LinkedList<>();
    private int idCount;
    private FileTreatment ft;

    public DVDController(){
        this.view = new DVDView();
    }
    public void readFile(File file){

        ft = new FileTreatment(file);

        try {
            DVDCollectionList = ft.readFile();
            idCount = DVDCollectionList.get(DVDCollectionList.size() - 1).getId() + 1;
        } catch (IOException e) {
            view.showExceptionMsg(e);
        }
    }
    public void addDvdToCollection(){
        DVD dvd = view.createDvd(idCount);
        idCount++;
        //Add dvd to the list
        DVDCollectionList.add(dvd);

        //Add dvd to the json file
        try{
            ft.addToFile(DVDCollectionList);
        }catch (IOException io){
            view.showExceptionMsg(io);
        }
    }
    public void showCollection(){
        for (DVD d: DVDCollectionList) {
            view.showDVD(d);
        }
    }
    public boolean showDVDWithID(int id){
        boolean success = false;
        for (DVD d: DVDCollectionList) {
            if(d.getId() == id){
                view.showDVDDetails(d);
                success = true;
            }
        }
        return success;
    }
    public boolean showDVDWithTitle(String title){
        boolean success = false;
        for (DVD d: DVDCollectionList) {
            if(d.getTitle().compareToIgnoreCase(title) == 0){
                view.showDVDDetails(d);
                success = true;
            }
        }
        return success;
    }
    public boolean removeDvdFromCollection(int id){

        boolean success = false;

        for (DVD dvd: DVDCollectionList) {
            if(dvd.getId() == id){
                DVDCollectionList.remove(dvd);
                success = true;
                try{
                    ft.addToFile(DVDCollectionList);
                    break;
                }catch (IOException e){
                    view.showExceptionMsg(e);
                    success = false;
                }
            }
        }
        return success;
    }

    public boolean editDVD(int id) {
        boolean success = false;

        for (DVD dvd: DVDCollectionList) {
            if(dvd.getId() == id){
                DVDCollectionList.remove(dvd);
                DVDCollectionList.add(view.createDvd(dvd.getId()));
                success = true;
                try{
                    ft.addToFile(DVDCollectionList);
                    break;
                }catch (IOException e){
                    view.showExceptionMsg(e);
                    success = false;
                }
            }
        }
        return success;
    }
}

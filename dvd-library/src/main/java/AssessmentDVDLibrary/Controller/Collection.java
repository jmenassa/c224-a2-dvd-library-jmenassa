package AssessmentDVDLibrary.Controller;

import java.io.File;

public interface Collection {

    void readFile(File file);
    void addDvdToCollection();
    void showCollection();
    boolean showDVDWithID(int id);
    boolean removeDvdFromCollection(int id);
    boolean editDVD(int id);


}

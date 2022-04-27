package AssessmentDVDLibrary.View;

import AssessmentDVDLibrary.Model.DVD;

import java.util.Scanner;

public class DVDView extends ViewUtility {

    Scanner sc;

    public DVD createDvd(int id){
        sc = new Scanner(System.in);
        DVD dvd = new DVD();
        dvd.setId(id);
        format('-',25);
        System.out.print("\nTitle: ");
        dvd.setTitle(sc.nextLine());
        System.out.print("\nRelease date: ");
        dvd.setReleaseDate(sc.nextLine());
        System.out.print("\nMPAA Rating: ");
        dvd.setmPAARating(sc.nextLine());
        System.out.print("\nDirector: ");
        dvd.setDirector(sc.nextLine());
        System.out.print("\nStudio: ");
        dvd.setStudio(sc.nextLine());
        System.out.print("\nRating: ");
        dvd.setUserRating(sc.nextLine());
        System.out.println();
        format('-', 25);
        System.out.println("\nDVD: " + dvd.toString()
                + " was successfully added to the collection.");
        return dvd;
    }

    public void showDVD(DVD dvd){
        format('-', 100);
        System.out.println("\n" + dvd.toString());
        format('-', 100);
        System.out.println();
    }

    public void showDVDDetails(DVD dvd){
        format('-', 30);
        System.out.println("\n" + dvd.DVDInfoFormated());
        format('-', 30);
        System.out.println();
    }
}

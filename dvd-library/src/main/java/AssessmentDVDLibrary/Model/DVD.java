package AssessmentDVDLibrary.Model;

public class DVD {

    private int id;
    private String title;
    private String releaseDate;
    private String mPAARating;
    private String director;
    private String studio;
    private String userRating;

    public DVD(){}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public DVD(int id, String title, String releaseDate, String mPAARating,
               String director, String studio,
               String userRating){
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.mPAARating = mPAARating;
        this.director = director;
        this.studio = studio;
        this.userRating = userRating;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getmPAARating() {
        return mPAARating;
    }

    public String getDirector() {
        return director;
    }

    public String getStudio() {
        return studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setmPAARating(String mPAARating) {
        this.mPAARating = mPAARating;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public String DVDInfoFormated(){
        return "id: " + id +
                "\ntitle: " + title +
                "\nRelease Date: " + releaseDate +
                "\nMPAA Rating: " + mPAARating +
                "\nDirector: " + director +
                "\nStudio: " + studio +
                "\nRating: " + userRating;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", mPAARating='" + mPAARating + '\'' +
                ", director='" + director + '\'' +
                ", studio='" + studio + '\'' +
                ", userRating='" + userRating + '\'' +
                '}';
    }
}

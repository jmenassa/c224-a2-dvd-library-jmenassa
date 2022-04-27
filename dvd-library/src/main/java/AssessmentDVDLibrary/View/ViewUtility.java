package AssessmentDVDLibrary.View;

public class ViewUtility {

    public void format(char c, int count) {

        for(int i = 0; i < count; i++){
            System.out.print(c);
        }
    }
    public void showErrorMsg(String err){
        format('*',25);
        System.out.print(err);
        format('*', 25);
        System.out.println();
    }

    public void showExceptionMsg (Exception ex){
        System.out.println("Error: " + ex.getMessage());
    }

    public void showSuccessMsg(){
        System.out.println("Action successfully completed.");
    }

}

import java.util.Scanner;

public class LinearEquationLogic {
    private Scanner scan;
    private String firstCoordinate = "";
    private String secondCoordinate = "";
    private int x1 = 0;
    private int x2 = 0;
    private int y1 = 0;
    private int y2 = 0;

    public void start() {
    LinearEquation newEquation = new LinearEquation(x1, y1, x2, y2);
    System.out.println(newEquation.lineInfo());
    }

    private void getData() {
        System.out.println("Welcome!");
        System.out.print("Enter your first coordinate point: ");
        firstCoordinate = scan.nextLine();
        System.out.println(firstCoordinate);
        System.out.print("Enter your second coordinate point: ");
        secondCoordinate = scan.nextLine();
        System.out.println(secondCoordinate);
    }

    private void parseData(){
        int firstComma = firstCoordinate.indexOf(",");
        int secondComma = secondCoordinate.indexOf(",");
        x1 = Integer.parseInt(firstCoordinate.substring(1,firstComma));
        x2 = Integer.parseInt(secondCoordinate.substring(1,secondComma));
        y1 = Integer.parseInt(firstCoordinate.substring(firstComma,4));
        y2 = Integer.parseInt(secondCoordinate.substring(secondComma,4));
    }

    LinearEquation equation1 = new LinearEquation(x1, y1, x2, y2);
}

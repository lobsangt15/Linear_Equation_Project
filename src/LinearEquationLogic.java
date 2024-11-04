import java.util.Scanner;

public class LinearEquationLogic {
    Scanner scan = new Scanner(System.in);
    private String firstCoordinate = "";
    private String secondCoordinate = "";
    private int x1 = 0;
    private int x2 = 0;
    private int y1 = 0;
    private int y2 = 0;

    public void start() {
        String answer = "y";
        while (answer.equals("y")) {
            getData();
            parseData();
            if (x1 == x2) {
                System.out.println();
                System.out.println("These points are on a vertical line: x = " + x1);
            } else {
                LinearEquation newEquation = new LinearEquation(x1, y1, x2, y2);
                System.out.println(newEquation.lineInfo());
                System.out.println();
                System.out.print("Enter a value for x: ");
                double searchX = scan.nextDouble();
                scan.nextLine();
                System.out.println("\nThe point on the line is " + newEquation.coordinateForX(searchX));
            }
            System.out.println();
            System.out.print("Would you like to enter another pair of coordinates? y/n: ");
            answer = scan.nextLine();
            System.out.println();
        }
        System.out.println("Thank you for using the linear equation calculator!");
    }

    private void getData() {
        System.out.println("Welcome to the linear equation calculator!");
        System.out.print("Enter your first coordinate point: ");
        firstCoordinate = scan.nextLine();
        System.out.print("Enter your second coordinate point: ");
        secondCoordinate = scan.nextLine();
    }

    private void parseData(){
        int firstComma = firstCoordinate.indexOf(",");
        int secondComma = secondCoordinate.indexOf(",");
        x1 = Integer.parseInt(firstCoordinate.substring(1,firstComma));
        x2 = Integer.parseInt(secondCoordinate.substring(1,secondComma));
        y1 = Integer.parseInt(firstCoordinate.substring(firstComma + 2, firstCoordinate.length() - 1));
        y2 = Integer.parseInt(secondCoordinate.substring(secondComma + 2, secondCoordinate.length() - 1));
    }

    LinearEquation equation1 = new LinearEquation(x1, y1, x2, y2);
}

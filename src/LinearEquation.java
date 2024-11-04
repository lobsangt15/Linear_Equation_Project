public class LinearEquation {
    private int x1 = 0;
    private int x2 = 0;
    private int y1 = 0;
    private int y2 = 0;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    private double distance() {
        double d = Math.sqrt((Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
        return roundedToHundredth(d);
    }

    private double yIntercept() {
        double slope = slope();
        double yIntercept = (y1 - (x1 * slope));
        return roundedToHundredth(yIntercept);
    }

    private double slope() {
        double slope = ((double)y2 - y1) / (x2 - x1);
        return roundedToHundredth(slope);
    }

    private String equation() {
        String slopeSign = "";
        String interceptSign = " + ";
        int numerator = y2 - y1;
        int absNumerator = Math.abs(y2 - y1);
        int denominator = x2 - x1;
        int absDenominator = Math.abs(x2 - x1);
        String slope = absNumerator + "/" + absDenominator;
        if (numerator % denominator == 0) {
                slope = Integer.toString(Math.abs(numerator / denominator));
        }
        if (Math.abs((double) numerator / denominator) == 1) {
            slope = "";
        }
        if (yIntercept() < 0) {
            interceptSign = " - ";
        }
        if ((double) numerator / denominator < 0) {
            slopeSign = "-";
        }
        if (yIntercept() == 0) {
            if (numerator / denominator == 0) {
                return ("y = 0");
            }
            return ("y = " + slopeSign + slope + "x");
        }
        if (y2 - y1 == 0) {
            return "y = " + yIntercept();
        } else {
            return ("y = " + slopeSign + slope + "x" + interceptSign + Math.abs(yIntercept()));
        }
    }

    public String coordinateForX(double X) {
        double yCoordinate = (slope() * X) + yIntercept();
        yCoordinate = roundedToHundredth(yCoordinate);
        return "(" + X + ", " + yCoordinate + ")";
    }

    public String lineInfo() {
        return "\nThe two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ") \n" +
                "The equation of the line between these points is: " + equation() +
                "\nThe y-intercept of this line is: " + yIntercept() + "\nThe slope of this line is: " +
                slope() + "\nThe distance between these points is " + distance();
    }

    private double roundedToHundredth (double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
}


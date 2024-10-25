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
        return d;
    }


    private double yIntercept() {
        double slope = slope();
        return (y1 - (x1 * slope));
    }


    private double slope() {
        return ((double)y2 - y1) / (x2 - x1);
    }


    private String equation() {
        String sign = "";
        int numerator = Math.abs(y2 - y1);
        int denominator = Math.abs(x2 - x1);
        String slope = numerator + "/" + denominator;
        if (slope() < 0) {
            sign = "-";
        }
        if (y2 - y1 == 0) {
            return "y = " + yIntercept();
        }
        if (yIntercept() > 0) {
            return ("y = " + sign + slope + "x " + " " + yIntercept());
        } else if (yIntercept() == 0) {
            return ("y = " + sign + slope + "x" + " + 0");
        }
        return ("y = " + sign + slope + "x" + yIntercept());
    }
}


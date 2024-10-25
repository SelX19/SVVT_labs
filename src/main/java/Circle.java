public class Circle {

    private int radius;
    private final double pi = 3.14159;

    Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double circleArea(int radius){
        double result = pi * radius * radius;
        //or : pi * Math.pow(radius,2)

        //P.S.: result has to be formatted to be exactly matching with the expected result (rounded to 2 decimals) from "radii.csv" file
        String formattedResult = String.format("%.2f", result);
        double finalArea = Double.parseDouble(formattedResult);
        return finalArea;
    }
}

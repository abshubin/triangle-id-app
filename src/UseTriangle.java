/*
 * TriangleIDApp.java
 *
 * Version 2.0.0
 *
 * Created 9/11/16 by Andrew Shubin
 */

import java.util.InputMismatchException;

public class UseTriangle {
    static Triangle currentTriangle = null;
    static TriangleUI gui = null;

    public static void main(String[] args) {
        gui = new TriangleUI();
    }

    public static String idTriangle(double a, double b, double c) {
        // Test for triangle validity
        if (Triangle.notATriangle(a, b, c)) {
            return "This is not a valid triangle.";
        }
        else {
            try {
                currentTriangle = new Triangle(a, b, c);
            }
            /*
             *  The notATriangle() method should prevent
             *  negative inputs from being accepted, so
             *  this is not the primary negativity tester,
             *  but rather a backup in case some negatives
             *  slip through notATriangle().
             */
            catch (InputMismatchException e) {
                return "This is not a valid triangle.";
            }
        }

        // If the triangle is valid, identify type
        String type = null;
        if (currentTriangle.isEquilateral()) {
            type = "equilateral";
        }
        else if (currentTriangle.isIsosceles()) {
            type = "isosceles";
        }
        else {
            type = "scalene";
        }
        return "This triangle is " + type + ".";
    }

    public static boolean inputIsValid(String a, String b, String c) {
        return isDouble(a) && isDouble(b) && isDouble(c);
    }

    private static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

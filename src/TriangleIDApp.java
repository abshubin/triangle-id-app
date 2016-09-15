/*
 * TriangleIDApp.java
 *
 * Version 1.0.0
 *
 * Created 9/11/16 by Andrew Shubin
 */

import java.util.*;

public class TriangleIDApp {
    static Triangle currentTriangle = null;
    static TriangleUI gui = null;

    public static void main(String[] args) {
        gui = new TriangleUI();
    }

    public static String idTriangle(double aRaw, double bRaw, double cRaw) {
        double a = Math.abs(aRaw);
        double b = Math.abs(bRaw);
        double c = Math.abs(cRaw);

        // Test for triangle validity
        if (invalidTriangle(a, b, c)) {
            return "This is not a valid triangle.";
        }
        else {
            currentTriangle = new Triangle(a, b, c);
        }

        // If the triangle is valid, identify type
        String type = "scalene"; // Scalene unless proven otherwise
        if (currentTriangle.isEqualateral()) {
            type = "equilateral";
        }
        else if (currentTriangle.isIsosceles()) {
            type = "isosceles";
        }
        return "This triangle is " + type + ".";
    }

    public static boolean inputIsValid(String a, String b, String c) {
        return isDouble(a) && isDouble(b) && isDouble(c);
    }

    private static boolean invalidTriangle(double a, double b, double c) {
        double max = Math.max(a, Math.max(b, c));
        return max >= (a + b + c - max); // Triangle if longest side is shorter
                                        // than the sum of the other two sides
    }

    // isDouble method from... http://stackoverflow.com/questions/3133770/how-to-find-out-if-the-value-contained-in-a-string-is-double-or-not
    private static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

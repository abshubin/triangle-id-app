/*
 * TriangleIDApp.java
 *
 * Version 1.0
 *
 * Created 9/11/16 by Andrew Shubin
 */

import com.sun.xml.internal.bind.v2.model.util.ArrayInfoUtil;

import java.util.*;

public class TriangleIDApp {
    static Triangle currentTriangle = null;
    static TriangleUI gui = null;

    public static void main(String[] args) {
        gui = new TriangleUI();
    }

    public static String idTriangle(double a, double b, double c) {
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

    private static boolean invalidTriangle(double a, double b, double c) {
        double max = Math.max(a, Math.max(b, c));
        return max < (a + b + c - max); // Triangle if longest side is shorter
                                        // than the sum of the other two sides
    }
}

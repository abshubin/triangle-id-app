/*
 * Triangle.java
 *
 * Version 2.0.0
 *
 * Created 9/9/16 by Andrew Shubin
 */

import java.util.InputMismatchException;

public class Triangle {
    private double sideA = 0;
    private double sideB = 0;
    private double sideC = 0;
    
    public Triangle(double a, double b, double c)
            throws InputMismatchException {

        if ((a <= 0) || (b <= 0) || (c <= 0)) { // Merely backup in
                                                // case notATriangle() is
                                                // not used before
                                                // instantiating a Triangle
            throw new InputMismatchException("Negative numbers not accepted.");
        }
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
    }
    
    public boolean isEquilateral() {
        return sideA == sideB && sideB == sideC;
    }
    
    public boolean isIsosceles() {
        return sideA == sideB || sideB == sideC || sideC == sideA;
    }
    
    public static boolean notATriangle(double a, double b, double c) {
        double max = Math.max(a, Math.max(b, c));
        return max >= (a + b + c - max); // Triangle if longest side
                                         // is shorter than the sum of the
                                         // other two sides. This also
                                         // prevents negative inputs.
    }

}

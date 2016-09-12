/*
 * Triangle.java
 *
 * Version 1.0
 *
 * Created 9/9/16 by Andrew Shubin
 */
public class Triangle {
    private double sideA = 0;
    private double sideB = 0;
    private double sideC = 0;
    
    public Triangle(double a, double b, double c) {
        this.sideA = Math.abs(a);
        this.sideB = Math.abs(b);
        this.sideC = Math.abs(c);
    }
    
    public boolean isEqualateral() {
        return sideA == sideB && sideB == sideC;
    }
    
    public boolean isIsosceles() {
        return sideA == sideB || sideB == sideC || sideC == sideA;
    }
    
    public boolean isScalene() {
        return sideA != sideB && sideB != sideC && sideC != sideA;
    }

}

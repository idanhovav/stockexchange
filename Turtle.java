/******************************************************************************
 *  Compilation:  javac Turtle.java
 *  Execution:    java Turtle
 *
 *  Data type for turtle graphics using standard draw.
 *
 ******************************************************************************/

import java.awt.Color;
import java.util.*;

public class Turtle {
    public double x, y;     // turtle's coordinates.
    public double angle;    // facing this many degrees counterclockwise from the x-axis

    // start at (x0, y0), facing a0 degrees counterclockwise from the x-axis
    public Turtle(double x0, double y0, double a0) {
        x = x0;
        y = y0;
        angle = a0;
    }

    // rotate orientation delta degrees counterclockwise
    public void turnLeft(double delta) {
        angle += delta;
    }
    public void turnRight(double delta) {
        angle -= delta;
    }

    // move forward the given amount, with the pen down
    public void goForward(double step) {
        double oldx = x;
        double oldy = y;
        x += step * Math.cos(Math.toRadians(angle));
        y += step * Math.sin(Math.toRadians(angle));
        StdDraw.line(oldx, oldy, x, y);
    }

    // pause t milliseconds
    public void pause(int t) {
        StdDraw.show(t);
    }


    public void setPenColor(Color color) {
        StdDraw.setPenColor(color);
    }

    public void setPenRadius(double radius) {
        StdDraw.setPenRadius(radius);
    }

    public void setCanvasSize(int width, int height) {
        StdDraw.setCanvasSize(width, height);
    }

    public void setXscale(double min, double max) {
        StdDraw.setXscale(min, max);
    }

    public void setYscale(double min, double max) {
        StdDraw.setYscale(min, max);
    }
    public void drawDesign(double length, int sides){
        for(int i = 0; i < sides; i++){
            this.goForward(length);
            this.turnLeft(360.0/((double)(sides)));
        }
    }
    public void drawDesignOpp(double length, int sides){
        for(int i = 0; i < sides; i++){
            this.goForward(length);
            this.turnRight(360.0/((double)(sides)));
        }
    }
    public void move(double x, double y){
        this.x = x;
        this.y = y;
    }
    public void turn(double a){
        this.angle = a;
    }


    // sample client for testing
    /*public static void main(String[] args) {
        double x0 = 0.5;
        double y0 = 0.0;
        double a0 = 60.0;
        double step = Math.sqrt(3)/2;
        Turtle turtle  = new Turtle(x0, y0, a0);

        double cheese;
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 3; i++){
            System.out.print("Enter: ");
            cheese = (double) Integer.parseInt(sc.next());
            turtle.goForward(step);
            turtle.turnLeft(120.0 + cheese);
        }
    }*/

}
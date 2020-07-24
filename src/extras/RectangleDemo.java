package extras;

/*
 * Demo of Java Rectangle class used for geometry problems involving 2-3 rectangles or squares.
 */

import java.awt.*;

public class RectangleDemo {
    public static void main(String[] args) {
        int x = 5; int y = 7; int width = 8; int height = 3;

        // creates a rectangle with upper-left corner at (x,y) with a specified width and height
        Rectangle rect1 = new Rectangle(x, y, width, height);
        Rectangle rect2 = new Rectangle(y, x, height, width);

        rect1.intersects(rect2); // checks if two rectangles intersect
        rect1.union(rect2); // returns a rectangle representing the union of the two rectangles
        rect1.contains(6, 8); // checks whether the integer point (x,y)(x,y) exists in firstRect
        rect1.intersection(rect2); // returns a rectangle representing the intersection of two rectangles.
    }
}

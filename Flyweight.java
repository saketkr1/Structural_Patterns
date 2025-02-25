
/*
Flyweight pattern is primarily used to reduce the number of objects created, to decrease memory footprint and increase performance.
This type of design pattern comes under structural pattern as this pattern provides ways to decrease object count thus improving the
object structure of application.
 */

import java.util.HashMap;

interface Shape1 {
    void draw(int x, int y);
}

class Circle1 implements Shape1 {
    private String color;
    public Circle1(String color) {
        this.color = color;
    }

    String getColor() {
        return color;
    }

    public void draw(int x, int y) {
        System.out.println("Drawing circle with color: " + color + " at (" + x + ", " + y + ")");
    }
}

class ShapeFactory {
    private static final HashMap<String, Shape1> circleMap = new HashMap<>();

    public static Shape1 getCircle(String color) {
        Circle1 circle = (Circle1) circleMap.get(color);

        if (circle == null) {
            circle = new Circle1(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color: " + color);
        }
        return circle;
    }
}

public class Flyweight {
    private static final String[] colors = {"Red", "Blue", "Green", "Yellow", "Red"};

    public static void main(String[] args) {
        for (int i = 0; i < colors.length; i++) {
            Shape1 circle = ShapeFactory.getCircle(colors[i]);  // Reuse objects
            circle.draw(i * 10, i * 20);  // Different positions
        }
    }

}

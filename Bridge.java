
/*
What is the Bridge Pattern?
- The bridge pattern is a design pattern used in software engineering that is meant to
 "decouple an abstraction from its implementation so that the two can vary independently".
- The bridge uses encapsulation, aggregation, and can use inheritance to separate responsibilities into different classes.
- The bridge pattern is useful when both the class and what it does vary often.
 */

// Example
/*
We have different Shapes (Circle, Square) and different Colors (Red, Blue).
Instead of creating separate subclasses for every combination like RedCircle,
 BlueCircle, RedSquare, BlueSquare, etc., we use the Bridge Pattern to separate Shape from Color.
 */

interface Color {
    void applyColor();
}

class RedColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying red color");
    }
}

class BlueColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying blue color");
    }
}

abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}

class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle");
        color.applyColor();
    }
}

class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a square");
        color.applyColor();
    }
}


public class Bridge {
    public static void main(String[] args) {
      Shape redCircle = new Circle(new RedColor());
      redCircle.draw();
      Shape blueSquare = new Square(new BlueColor());
      blueSquare.draw();
    }
}

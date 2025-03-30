public class ShapeMain {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(5, 8);
        triangle.computeArea();
        triangle.displayArea();

        Square square = new Square(7);
        square.computeArea();
        square.displayArea();

        Circle circle = new Circle(6);
        circle.computeArea();
        circle.displayArea();
    }
}


abstract class Shape {
    String shape;
    double area;

    abstract void computeArea();

    void displayArea() {
        System.out.println("Shape: " + shape);
        System.out.printf("Area: %.2f\n\n", area);
        System.out.println();
    }
}


class Triangle extends Shape {
    double base;
    double height;

    Triangle(double base, double height) {
        this.shape = "Triangle";
        this.base = base;
        this.height = height;
    }

    void computeArea() {
        area = 0.5 * base * height;
    }
}


class Square extends Shape {
    double side;

    Square(double side) {
        this.shape = "Square";
        this.side = side;
    }

    void computeArea() {
        area = side * side;
    }
}


class Circle extends Shape {
    double radius;
    final double PI = 3.14159;

    Circle(double radius) {
        this.shape = "Circle";
        this.radius = radius;
    }

    void computeArea() {
        area = PI * radius * radius;
    }
}



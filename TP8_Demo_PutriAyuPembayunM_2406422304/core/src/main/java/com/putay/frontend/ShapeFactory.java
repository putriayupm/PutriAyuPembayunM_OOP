package com.putay.frontend;

public class ShapeFactory {
    private ShapePool shapePool;

    public ShapeFactory(ShapePool shapePool) {
        this.shapePool = shapePool;
    }

    public Shape createShape(String type) {
        Shape shape = shapePool.obtain(type);
        if (shape == null) {
            if (type.equalsIgnoreCase("Circle")) {
                System.out.println("New Circle created");
                return new Circle();
            } else if (type.equalsIgnoreCase("Square")) {
                System.out.println("New Square created");
                return new Square();
            }
        }
        return shape;
    }
}

package com.divashchenko;

import javafx.scene.canvas.GraphicsContext;

import java.util.List;
import java.util.Random;

public abstract class Figure implements Shape {

    protected double diameter;

    protected GraphicsContext gc;
    protected double x;
    protected double y;
    protected List<Shape> shapes;

    private double xSpeed;
    private double ySpeed;

    protected Figure(GraphicsContext gc, double x, double y, List<Shape> shapes) {
        this.gc = gc;
        this.x = x;
        this.y = y;
        this.shapes = shapes;

        Random random = new Random();
        xSpeed = 2 + random.nextInt(5);
        ySpeed = 2 + random.nextInt(5);
    }

    @Override
    public void move() {
        x += xSpeed;
        y += ySpeed;

        if (x + diameter > gc.getCanvas().getWidth()) {
            xSpeed = -xSpeed;
        }

        if (y + diameter > gc.getCanvas().getHeight()) {
            ySpeed = -ySpeed;
        }

        if (x < 0) {
            xSpeed = -xSpeed;
        }

        if (y < 0) {
            ySpeed = -ySpeed;
        }

        checkDistance();
    }

    private void checkDistance() {
        for (int i = 0; i < shapes.size(); i++) {
            Figure figure = (Figure) shapes.get(i);

            double x1 = x + diameter / 2;
            double y1 = y + diameter / 2;
            double x2 = figure.x + figure.diameter / 2;
            double y2 = figure.y + figure.diameter / 2;

            double distanceBetweenFigures = Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));

            if (distanceBetweenFigures < ((diameter + figure.diameter) / 2)) {
                xSpeed = -xSpeed;
                ySpeed = -ySpeed;
                figure.xSpeed = -figure.xSpeed;
                figure.ySpeed = -figure.ySpeed;
            }
        }
    }

    @Override
    public abstract void draw();
}

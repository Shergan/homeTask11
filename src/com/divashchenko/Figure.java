package com.divashchenko;

import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

public abstract class Figure implements Shape {

    protected static double diameter;

    protected GraphicsContext gc;
    protected double x;
    protected double y;

    private double xSpeed;
    private double ySpeed;

    protected Figure(GraphicsContext gc, double x, double y) {
        this.gc = gc;
        this.x = x;
        this.y = y;

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

    }

    @Override
    public abstract void draw();
}

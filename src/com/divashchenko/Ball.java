package com.divashchenko;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball extends Figure {

    protected Ball(GraphicsContext gc, double x, double y) {
        super(gc, x, y);
    }

    @Override
    public void draw() {
        diameter = 30;

        gc.setFill(Color.RED);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        gc.fillOval(x, y, diameter, diameter);
        gc.strokeOval(x, y, diameter, diameter);
    }

}
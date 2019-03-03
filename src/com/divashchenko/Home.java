package com.divashchenko;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Home extends Figure {
    public Home(GraphicsContext gc, double x, double y) {
        super(gc, x, y);
    }

    @Override
    public void draw() {
        diameter = 60;

        gc.setFill(Color.BROWN);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        double[] xDouble = {x + 30, x + 60, x + 50, x + 50, x + 10, x + 10, x};
        double[] yDouble = {y, y + 30, y + 30, y + 60, y + 60, y + 30, y + 30};

        gc.fillPolygon(xDouble, yDouble, 7);

        gc.setFill(Color.BLUE);
        gc.fillRect(x + 18, y + 40, 7, 7);
        gc.fillRect(x + 38, y + 40, 7, 7);
        gc.fillOval(x + 27, y + 15, 7, 7);
    }
}

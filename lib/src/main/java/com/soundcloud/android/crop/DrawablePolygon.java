package com.soundcloud.android.crop;

/**
 * Created by keriackus on 8/26/2015.
 */

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Matrix;

/**
 * Simple implementation for a drawable polygon
 */
public class DrawablePolygon {
    /**
     * The polygon itself, represented as a Path object
     */
    protected Path path = new Path();

    /**
     * Matrix to help moving the polgon
     */
    protected Matrix matrix = new Matrix();

    /**
     * Paint object to help define the colour of the polygon
     */
    protected Paint paint = new Paint();

    /**
     * Hidden position co-ordinates for the polygon
     */
    protected float positionX, positionY;


    /**
     * Automatically creates a drawable polygon from a radius and number of
     * vertices supplied
     */
    public DrawablePolygon(float x, float y, int noOfVertices, float radius, int colour) {
        //set the position of the polygon
        positionX = x;
        positionY = y;

        //degrees of separation between each vertex
        float degrees = 360.0f / noOfVertices;

        //initial position of the first vertex
        float vx = (float)(Math.sin(0) + radius);
        float vy = (float) (Math.cos(0) - radius);

        //move vertex into position and set as starting vertex
        path.moveTo(vx + x, vy + y);

        //calculate other vertices and add them accordingly
        for (int i = 1; i < noOfVertices; i++) {
            vx =(float) (Math.sin(degrees * i) + radius);
            vy = (float)(Math.cos(degrees * i) - radius);
            path.lineTo(vx + x, vy + y);
        }

        //close polygon
        path.close();

        //set polygon's colour
        paint.setColor(colour);
    }

    /**
     * Sets the position of the polygon and its vertices
     */
    public void setPosition(float x, float y) {
        //calculate difference
        float deltaX = x - positionX;
        float deltaY = y - positionY;

        //update actual position
        positionX = x;
        positionY = y;

        //build matrix
        matrix.reset();
        matrix.postTranslate(deltaX, deltaY);

        //update path
        path.transform(matrix);
    }

    /**
     * Sets the colour of the polygon
     */
    public void setColor(int colour) {
        paint.setColor(colour);
    }

    /**
     * Sets the polygon to be drawn as an outline
     */
    public void outline() {
        paint.setStyle(Paint.Style.STROKE);
    }

    /**
     * Sets the polygon to be filled as a solid polygon
     */
    public void fill() {
        paint.setStyle(Paint.Style.FILL);
    }

    /**
     * Draws the polygon to the given canvas
     */
    public void draw(Canvas canvas) {
        canvas.drawPath(path, paint);
    }

}

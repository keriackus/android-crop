package com.soundcloud.android.crop.example;

/**
 * Created by keriackus on 8/25/2015.
 */

import android.graphics.Path;

public class HexagonUtils {
    public enum HexagonType {VERTICAL, HORIZONTAL}

    public static Path createPath(float x, float y, HexagonType type, int width, int height, int contentWidth) {
        final float centerX = x;
        final float centerY = y;

        Path path = new Path();

        // See http://www.had2know.com/academics/hexagon-measurement-calculator.html for reference
        if (type == HexagonType.VERTICAL) {
            /*
            (Note that you need un-italicized comments for this ascii art)
                    +
                  /   \
                 +     +
                 |  +  |
                 +     +
                  \   /
                    +
            */

            // The diagonal is the height, and s = d / 2
            final float s = height / 2.0f;
            final float h = (float) Math.sqrt(3) * s;
            final float halfHeight = h / 2.0f;

            path.moveTo(centerX, centerY + s);                     // bottom
            path.lineTo(centerX - halfHeight, centerY + s / 2.0f); // bottom left
            path.lineTo(centerX - halfHeight, centerY - s / 2.0f); // top left
            path.lineTo(centerX, centerY - s);                     // top
            path.lineTo(centerX + halfHeight, centerY - s / 2.0f); // top right
            path.lineTo(centerX + halfHeight, centerY + s / 2.0f); // bottom right
            path.lineTo(centerX, centerY + s);                     // back to bottom
            path.close();
        } else {
            /*
            (Note that you need un-italicized comments for this ascii art)

                +-----+
               /       \
              +    +    +
               \       /
                +-----+
            */

            // The diagonal is the content width, and s = d / 2
            final float s = contentWidth / 2.0f;
            final float h = (float) Math.sqrt(3) * s;
            final float halfHeight = h / 2.0f;

            path.moveTo(centerX - s / 2.0f, centerY - halfHeight); // top left
            path.lineTo(centerX + s / 2.0f, centerY - halfHeight); // top right
            path.lineTo(centerX + s, centerY);                       // right
            path.lineTo(centerX + s / 2.0f, centerY + halfHeight); // bottom right
            path.lineTo(centerX - s / 2.0f, centerY + halfHeight); // bottom left
            path.lineTo(centerX - s, centerY);                       // left
            path.moveTo(centerX - s / 2.0f, centerY - halfHeight); // back to top left
        }

        return path;
    }
}

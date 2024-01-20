package feladatok;

import java.util.Arrays;

class Point
{
    final int x;
    final int y;

    Point(final double x, final double y)
    {
        this.x = (int) x;
        this.y = (int) y;
    }

    @Override
    public String toString()
    {
        return "{" + x + ", " + y + "}";
    }
}

public class asd {



    public static void main(String... args){
        final int NUM_POINTS = 1000;
        final double RADIUS = 100d;

        final Point[] points = new Point[NUM_POINTS];

        for (int i = 0; i < NUM_POINTS; ++i)
        {
            final double angle = Math.toRadians(((double) i / NUM_POINTS) * 360d);

            points[i] = new Point(
                    Math.cos(angle) * RADIUS,
                    Math.sin(angle) * RADIUS
            );
        }

        System.out.println(Arrays.toString(points));
    }

}

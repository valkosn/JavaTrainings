package gof.structure.bridge;

/**
 * Created by Valko Serhii on 31-May-16.
 */
public class Circle extends Shape
{

    private int x;
    private int y;
    private int radius;

    protected Circle(int x, int y, int radius, Drawer drawer) {
    super(drawer);
        this.x = x;
        this.y = y;
        this.radius = radius;
}

    @Override
    public void draw() {
        drawer.draw(x, y, radius);
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}

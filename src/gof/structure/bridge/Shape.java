package gof.structure.bridge;

/**
 * Created by Valko Serhii on 31-May-16.
 */
public abstract class Shape {

    protected Drawer drawer;

    protected Shape(Drawer drawer) {
        this.drawer = drawer;
    }

    public abstract void draw();

}

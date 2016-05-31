package gof.structure.bridge;

/**
 * Created by Valko Serhii on 31-May-16.
 */
public class SmallCircleDrawer implements Drawer {

    private final double radiusMultiplier = 0.25;

    @Override
    public void draw(int x, int y, double radius) {
        System.out.println(x + " " + y + " " + radius * radiusMultiplier);
    }
}

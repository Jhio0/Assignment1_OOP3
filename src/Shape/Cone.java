package Shape;
import dev.GeometricShape;

public class Cone extends GeometricShape implements Comparable<GeometricShape> {
	private double radius;

    public Cone(String name, double height, double radius) {
        super(name);
        this.radius = radius;
        this.setHeight(height);
        // Calculate base area and volume
        this.setBaseArea(Math.PI * radius * radius);
        this.setVolume((1.0 / 3.0) * Math.PI * radius * radius * height);
    }
   
}

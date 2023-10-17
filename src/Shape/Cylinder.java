package Shape;
import dev.GeometricShape;

public class Cylinder extends GeometricShape implements Comparable<GeometricShape> {
	
	private double radius;

    public Cylinder(String name, double height, double radius) {
        super(name);
        this.radius = radius;
        this.setHeight(height);
        // Calculate base area and volume
        this.setBaseArea(Math.PI * radius * radius);
        this.setVolume(Math.PI * radius * radius * height);
    }
    
}

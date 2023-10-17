package Shape;
import dev.GeometricShape;

public class Pyramid extends GeometricShape implements Comparable<GeometricShape> {
	private double edgeLength;

    public Pyramid(String name, double height, double edgeLength) {
        super(name);
        this.edgeLength = edgeLength;
        this.setHeight(height);
        // Calculate base area and volume
        this.setBaseArea(0.25 * edgeLength * edgeLength * Math.sqrt(3.0));
        this.setVolume((1.0 / 3.0) * this.getBaseArea() * height);
    }


}

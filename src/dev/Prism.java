package dev;

import Shape.Cone;

public class Prism extends GeometricShape implements Comparable<GeometricShape> {
	private String baseType;

    public Prism(String name, double height, double edgeLength, String baseType) {
        super(name);
        this.baseType = baseType;
        this.setHeight(height);
        // Calculate base area and volume based on the type of base polygon
        if (baseType.equals("Square")) {
            this.setBaseArea(edgeLength * edgeLength);
        } else if (baseType.equals("Triangular")) {
            this.setBaseArea(0.25 * edgeLength * edgeLength * Math.sqrt(3.0));
        } else if (baseType.equals("Pentagonal")) {
            this.setBaseArea(0.25 * edgeLength * edgeLength * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))));
        } else if (baseType.equals("Octagonal")) {
            this.setBaseArea(2.0 * (1 + Math.sqrt(2.0)) * edgeLength * edgeLength);
        }
        this.setVolume(this.getBaseArea() * height);
    }

   
}

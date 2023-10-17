package dev;

import java.util.Comparator;


public abstract class GeometricShape implements Comparable<GeometricShape> {
	
	private String name;
	private double height;
	private double baseArea;
	private double volume;
	
	public GeometricShape(String name) {
        this.name = name;
    }
	
	public String getName() {
		return name;
	}
	public double getHeight() {
		return height;
	}
	public double getBaseArea() {
		return baseArea;
	}
	public double getVolume() {
		return volume;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public void setBaseArea(double baseArea) {
        this.baseArea = baseArea;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
    

    @Override
    public int compareTo(GeometricShape other) {
        // Compare by height
        return Double.compare(other.getHeight(), this.getHeight());
    }
    
    public static class VolumeComparator implements Comparator<GeometricShape> {
        @Override
        public int compare(GeometricShape shape1, GeometricShape shape2) {
            // Compare by volume
            return Double.compare(shape2.getVolume(), shape1.getVolume());
        }
    }
    
 // Create a Comparator for comparing shapes by base area
    public static class AreaComparator implements Comparator<GeometricShape> {
        @Override
        public int compare(GeometricShape shape1, GeometricShape shape2) {
            // Compare by base area
            return Double.compare(shape2.getBaseArea(), shape1.getBaseArea());
        }
    }

	@Override
	public String toString() {
		return "GeometricShape [name=" + name + ", height=" + getHeight() + ", baseArea=" + baseArea + ", volume=" + volume
				+ "]";
	}
    
    
    
    

}

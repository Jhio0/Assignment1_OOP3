import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import dev.GeometricShape;
import dev.Prism;
import Sorting.Bubble;
import Sorting.Insertion;
import Sorting.Selection;
import Sorting.Quick;
import Sorting.SortingUtility;
import Shape.Cone;
import Shape.Cylinder;
import Shape.Pyramid;

public class Driver {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (!args[0].startsWith("-f") || !args[1].startsWith("-t") || !args[2].startsWith("-s")) {
		    System.out.println("Usage: java SortProgram -f <input_file> -t <comparison_type> -s <sorting_algorithm>");
		    System.exit(1);
		}
	
		String inputFile = args[0].substring(2);
		String comparisonType = args[1].substring(2).toLowerCase();
		String sortingType = args[2].substring(2).toLowerCase();
		GeometricShape[] shapes = null;
       
      //#4
		long startTime, endTime;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line = reader.readLine();

            if (line != null) {
                String[] data = line.split(" ");
                int numShapes = Integer.parseInt(data[0]);
                shapes = new GeometricShape[numShapes];
               
                

                if (data.length == numShapes * 3 + 1) {
                    for (int i = 0; i < numShapes; i++) {
                        String shapeType = data[i * 3 + 1];
                        double height = Double.parseDouble(data[i * 3 + 2]);
                        double value = Double.parseDouble(data[i * 3 + 3]);

                        // Create shape objects based on shapeType
                        if (shapeType.contains("Prism")) {
                        	String baseShapeType = shapeType.replaceAll("Prism$", "");
                        	String baseType = data[i * 3 + 1];
                        	shapes[i] = new Prism(baseType, height, value, baseShapeType);
                        }else {
                        	 try {
                                 Class<?> shapeClass = Class.forName("Shape."+shapeType);
                                 Constructor<?> constructor = shapeClass.getConstructor(String.class, double.class, double.class);
                                 shapes[i] = (GeometricShape) constructor.newInstance(shapeType, height, value);
                             } catch (ClassNotFoundException | NoSuchMethodException e) {
                                 System.out.println("Error creating shape: " + e.getMessage());
                             }
                        }
                                       
                    }

                    if (comparisonType.equalsIgnoreCase("h")) {
                        Arrays.sort(shapes); // Sort by height using compareTo
                    } else if (comparisonType.equals("v")) {
                        Arrays.sort(shapes, new GeometricShape.VolumeComparator()); // Sort by volume
                    } else if (comparisonType.equals("a")) {
                        Arrays.sort(shapes, new GeometricShape.AreaComparator()); // Sort by base area
                    } else {
                        System.out.println("Invalid comparison type. Use 'h' for height, 'v' for volume, or 'a' for area.");
                        System.exit(1);
                    }
                    
                    System.out.println("------------------------------------decending Order------------------------------------");
                    for (GeometricShape shape : shapes) {
                        if (shape != null) {
                            System.out.println(shape);
                        }
                    }
                    System.out.println("------------------------------------------------------------------------");
                    
                    
                    
                 // Time measurement for sorting
                    startTime = System.nanoTime();
                    switch(sortingType) {
        			case "s":
        				SortingUtility.selectionSort(shapes);
        				System.out.println("---------SelectionSort-------");
        				break;
        			case "b":
        				SortingUtility.bubbleSort(shapes);
        				System.out.println("---------BubbleSort-------");
        				break;
        			case "i":
        				SortingUtility.insertionSort(shapes);
        				System.out.println("---------InsertionSort-------");
        				break;
        			case "q":
        				SortingUtility.quickSort(shapes, 0, shapes.length -1);
        				System.out.println("---------QuickSort-------");
        				break;
        			case "m":
        				SortingUtility.mergeSort(shapes);
        				System.out.println("---------MergeSort-------");
        				break;
        			case "h":
        				SortingUtility.heapSort(shapes);
        				System.out.println("---------HeapSort-------");
        				break;
        			default: 
        				System.out.println("Invalid Choice");
        				break;
        			
                    }
                    
                    System.out.println("-----------------------------------------------------------------------------");
                 // Time measurement for sorting
                    endTime = System.nanoTime();
                    long sortingTimeInMilliseconds = (endTime - startTime) / 1_000_000;
                    System.out.println("Sorting Time: " + sortingTimeInMilliseconds + " milliseconds");
                    System.out.println("-----------------------------------------------------------------------------");
                    
                    // Print the first, last, and every thousandth value
                    System.out.println("-----------------------------------------------------------------------------");
                    printValues(shapes);
                    System.out.println("-----------------------------------------------------------------------------");

                    
                } else {
                    System.out.println("Invalid input format: Incorrect number of elements.");
                }
            } else {
                System.out.println("Empty input file.");
            }

            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in input.");
        }
    }
    
    private static void printValues(GeometricShape[] shapes) {
        int n = shapes.length;
        System.out.println("First sorted value: " + shapes[0]);
        System.out.println("Last sorted value: " + shapes[n - 1]);

        for (int i = 1000; i < n; i += 1000) {
            System.out.println("Every thousandth value: " + shapes[i]);
        }
    }

}



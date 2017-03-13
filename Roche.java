import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Roche {
	
	
	/**
	 * Quadratic equation solver
	 * @param a : Double
	 * @param b : Double
	 * @param c : Double
	 * @return an array of Roots for the quadratic equation
	 * Algorithm:
	 * If complex roots, then return null
	 */
	public static double [] qaSolver(double a, double b, double c){
		if(a==0){
			return null;
		}
		
		double[] result = new double[2];
		result[0] = Double.MIN_VALUE;
		result[1] = Double.MIN_VALUE;
			
		double discrimant = Math.pow(b, 2) - 4*a*c;
		if(discrimant < 0){
			result = null;
		} else if(discrimant == 0) {
			result[0] = b==0? 0 : -b/2*a;
		} else {
			result[0] = (-b + Math.sqrt(discrimant))/(2*a);
			result[1] = (-b - Math.sqrt(discrimant))/(2*a);
		}
		System.out.println(result[0] + " and " + result[1]);
		return result;
	}
	
	
	/**
	 * Method to print the customized output for the roots of the Quadratic equation
	 * @param result : roots of the quadratic equation
	 * Algorithm:
	 * If null return null
	 * If other double roots then print empty
	 * if one root then print only that root
	 * if two roots then print both the roots
	 */
	private static void printResult(double[] result){
		StringBuffer sb = new StringBuffer();
		
		if(result == null){
			sb.append("null");
		} else {
			if(result[0] != Double.MIN_VALUE){
				if(result[0] == Math.floor(result[0])){
					sb.append(String.valueOf(result[0]));
				}
			}
			if(result[1] != Double.MIN_VALUE){
				if(result[0] == Math.floor(result[0])){
					sb.append(", ").append(String.valueOf(result[1]));
				}
			}
		}
		
		System.out.println(sb.toString());
		
	}
	
	
	/**
	 * Parse the input from the Filename provided
	 * @param args
	 */
	public static void parseInput(String args[]){
		Scanner sc = null;
		if(args.length != 0){
			try {
				sc = new Scanner(new FileReader(args[0]));
				//Assumption: Input file has valid data i.e. triplets of double values in each line
					while(sc.hasNextLine()){
						double a = Double.parseDouble(sc.next());
						double b = Double.parseDouble(sc.next());
						double c = Double.parseDouble(sc.next());
						printResult(Roche.qaSolver(a, b, c));
					}
			} catch (FileNotFoundException e) {
				System.out.println("Please Enter the correct  file name" + e.getMessage());
				e.printStackTrace();
			} finally {
				sc.close();
			}
		}else {
			System.out.println("Enter the correct File name");
		}
		
	}
	
	/**
	 * Entry point for the Quadratic Equation solver
	 * @param args
	 */
	public static void main(String args[]){
		parseInput(args);
	}

}

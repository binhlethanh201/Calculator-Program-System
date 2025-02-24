import java.util.Scanner;

public class bmi {
	private static final Scanner sc = new Scanner(System.in);
	
	public static int menu() {
		System.out.println();
		System.out.println("===== Calculator Program =====");
		System.out.println("1. Normal Calculator");
		System.out.println("2. BMI Calculator");
		System.out.println("3. Exist");
		System.out.println();
		System.out.print("Please choice one option:");
		int choice = checkInputLimit(1,3);
				return choice;
	}
	public static void normalCalculator() {
	    System.out.println("\n------ Normal Calculator -----");
	    System.out.print("Enter Number: ");
	    double memory = checkInputDouble();

	    while (true) {
	        System.out.print("Enter operator: ");
	        String operator = checkInputOp();
	        
	        if (operator.equals("=")) { // Kiểm tra trước khi nhập số
	            System.out.println("Result: " + memory);
	            return;
	        }
	        
	        double number = inputNumber();

	        switch (operator) {
	            case "+":
	                memory += number;
	                break;
	            case "-":
	                memory -= number;
	                break;
	            case "*":
	                memory *= number;
	                break;
	            case "/":
	                if (number == 0) {
	                    System.err.println("Cannot divide by 0");
	                    continue;
	                }
	                memory /= number;
	                break;
	            case "^":
	                memory = Math.pow(memory, number);
	                break;
	            default:
	                System.err.println("Invalid operator!");
	                continue;
	        }
	        System.out.println("Memory: " + memory);
	    }
	}

	public static void bmiCalculator(){
        System.out.println();
        System.out.println("----- BMI Calculator -----");
        System.out.print("Enter Weight (kg): ");
        double w = checkInputDouble();
        System.out.print("Enter Height (cm): ");
        double h = checkInputDouble();
        double result = (w*10000)/(h*h);
        System.out.printf("BMI number: %.2f\n", result);
        String status;
        if(result < 19) {status = "UNDER-STANDARD";}
        else if( result <=25) {status = "STANDARD";} 
        else if (result <=30) {status = "OVERWEIGHT";} 
        else if(result <=40) {status = "FAT - SHOULD LOSE WEIGHT";} 
        else {status = "VERY FAT - SHOULD LOSE WEIGHT IMMEDIATELY";}
        System.out.println("BMI Status: " + status);
        System.out.println();
    }

	private static double inputNumber() {
		System.out.print("Enter Number: ");
		double number = checkInputDouble();
		return number;
	}
	
	private static double checkInputDouble() {
		while(true) {
			try {
				double in = Double.parseDouble(sc.nextLine().trim());
			return in;
			} catch(NumberFormatException e) {
				System.err.println("Must be digit");
				System.out.print("Enter again: ");
			}
		}
	}
	private static String checkInputOp() {
		while(true) {	
				String in = sc.nextLine().trim();
				if(in.isEmpty()) System.err.println("Can not Empty!");
				else if(in.equals("+") || in.equals("-") || in.equals("*") || in.equals("/") || in.equals("^") || in.equals("=")) return in;
				else System.err.println("Please input (+, -, *, /, ^)");
				System.out.print("Enter again:");
		}
	}
	
	private static int checkInputLimit(int min, int max) {
		while(true) {
			try {
				int in = Integer.parseInt(sc.nextLine().trim());
				if(in< min || in > max) {
					throw new NumberFormatException();
				}
				return in;
			} catch(NumberFormatException e) {
				System.err.println("Please input in the range " +min+ " to " +max);
				System.out.print("Enter again: ");
			}
		}
	}
}

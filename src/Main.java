
public class Main {
	public static void main(String[] args) {
		while(true) {
			int choice = bmi.menu();
		
			switch(choice) {
			case 1: 
				bmi.normalCalculator();
				break;
			case 2:
				bmi.bmiCalculator();
				break;
			case 3:
				System.out.println("Existing Program...");
				return;
			}
		
		}
		
	}
		
}

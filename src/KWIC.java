import design2.MasterControl;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class KWIC {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		while (true){
			System.out.println("------------------------------------------------");
			System.out.println("Choose any one of the design architecture below");
			System.out.println("------------------------------------------------");
			System.out.println("1) Abstract Data Type");
			System.out.println("2) Pipe and Filter");
			System.out.println("3) Exit from program");
			System.out.println("------------------------------------------------");
			if (sc.hasNextInt()) {
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					MasterControl.execute();
					break;
				case 2:
					break;
				case 3:
					System.out.println("Successfully exited from program");
					System.exit(0);
				default:
					System.out.println("Available option to choose from are 1-3");
				}
			} 
		}
	}
}
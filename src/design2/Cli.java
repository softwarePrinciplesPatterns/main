package design2;

import java.util.Scanner;


public class Cli {
	private static Cli mCli = null;
			
	public Cli(){
	}
	
	public Cli getInstance(){
		if(mCli == null){
			mCli = new Cli();
		}
		return mCli;
	}
	public static String[] start(){
		String[] savedLocation = new String[2];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name of input list at " +System.getProperty("user.dir"));
		savedLocation[0] = sc.nextLine();
		System.out.println("Enter name of ignore list at " +System.getProperty("user.dir"));
		savedLocation[1] = sc.nextLine();
		return savedLocation;
	}
}

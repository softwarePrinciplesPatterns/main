package design2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Input {
	Storage storage;
	private static Input mInput = null;
	
	public Input(){
		this.storage = Storage.getInstance();
	}
	
	public static Input getInstance(){
		if (mInput == null){
			mInput = new Input();
		}
		return mInput;
	}
	
	public void setup(String inputLoc, String ignoreLoc) throws FileNotFoundException, IOException{
		storage.loadInputFile(System.getProperty("user.dir") + "\\" + inputLoc + ".txt", "input");
		storage.loadInputFile(System.getProperty("user.dir") + "\\" + ignoreLoc + ".txt", "ignore");
	}
	
	
	
}

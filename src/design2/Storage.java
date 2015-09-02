package design2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Storage {
	private ArrayList<String> inputList;;
	private ArrayList<String> ignoreList;
	private static Storage mStorage = new Storage();
	
	public Storage(){
		this.inputList = new ArrayList<String>();
		this.ignoreList = new ArrayList<String>();
	}
	
	/*
	 * This method returns the size of the inputList which stores titles 
	 * Parameters: none
	 * Return:		int
	 * 
	 */
	public int getLengthInputData(){
		return inputList.size();
	}
	
	/*
	 * This method returns the size of the ignoreList which stores ignore words 
	 * Parameters: none
	 * Return:		int
	 * 
	 */
	public int getLengthIgnoreList(){
		return ignoreList.size();
	}
	
	/*
	 * This method adds line to an arraylist
	 * Parameters: string, arraylist
	 * Return:		none
	 * 
	 */
	public void addLine(String inputLine, ArrayList<String> al){
		al.add(inputLine);
	}
	
	/*
	 * This method returns a string from the defined line number in the inputList arraylist 
	 * Parameters: int
	 * Return:		string
	 * 
	 */
	public String getLineAtPos(int posNo){
		return inputList.get(posNo);
	}
	
	public void reset(){
		inputList.clear();
		ignoreList.clear();
	}
	
	public static Storage getInstance(){ 
		if(mStorage == null){
			mStorage = new Storage();
		}
		return mStorage;
	}
	
	/*
	 * This method returns either the inputList or the ignoreList
	 * Parameters: string
	 * Return:		arraylist
	 * 
	 */
	public ArrayList<String> getActualList(String listType){
		if(listType.equalsIgnoreCase("input")){
			return inputList;
		}else if(listType.equalsIgnoreCase("ignore")){
			return ignoreList;
		}
		return null;
	}
	
	/*
	 * This method loads contents in a file into an defined arraylist
	 * Parameters: string
	 * Return:		none
	 * 
	 */
	public void loadInputFile(String inputFileLocation, String listType) throws FileNotFoundException, IOException{
		ArrayList<String> myList = getActualList(listType);
		try (BufferedReader br = new BufferedReader(new FileReader(inputFileLocation))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	addLine(line, myList);
		    }
		}
	}
	
	/*
	 * This method returns true if a word is found in the ignoreList 
	 * Parameters: string
	 * Return:		boolean
	 * 
	 */
	public boolean isIgnoredWordPresent(String word){
		for (int i = 0; i < ignoreList.size(); i++) {
			if(word.equalsIgnoreCase(ignoreList.get(i))){
				return true;
			}
		}
		return false;
	}
	
}

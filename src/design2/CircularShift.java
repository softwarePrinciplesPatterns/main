package design2;

import java.util.ArrayList;
import java.util.Vector;


public class CircularShift {
	Storage storage;
	private static CircularShift mCircularShift = null;
	private ArrayList<String> shiftedLineList;
	
	public CircularShift(){
		this.storage = Storage.getInstance();
		this.shiftedLineList = new ArrayList<String>();
	}
	
	public void execute(){
		int inputListLength = storage.getLengthInputData();
		for (int i = 0; i < inputListLength; i++) {
			String line = storage.getLineAtPos(i);
			shiftedLineList.addAll(shiftLineInList(line));
		}
	}
	
	public void reset(){
		shiftedLineList.clear();
	}
	
	public static CircularShift getInstance(){ 
		if(mCircularShift == null){
			mCircularShift = new CircularShift();
		}
		return mCircularShift;
	}
	
	/*
	 * This method returns shiftedLinelist that is ready to be processed for alphabetic sorting
	 * Parameters: none
	 * Return:		arraylist
	 * 
	 */
	public ArrayList<String> getShiftedList(){
		return mCircularShift.shiftedLineList;
	}
	
	/*
	 * This method returns an arraylist with lines that has already been circular shifted.
	 * Lines in the list do not start with any of the ignored words 
	 * Parameters: string
	 * Return:		arraylist
	 * 
	 */
	private ArrayList<String> shiftLineInList(String extractedLine){
		String[] spaceDelimitedArray = tokenizeLine(extractedLine);
		ArrayList<String> completedList = new ArrayList<String>();
		for (int i = 0; i < spaceDelimitedArray.length; i++) {
			String firstWord = spaceDelimitedArray[i];
			if(storage.isIgnoredWordPresent(firstWord)){
				continue;
			}else{
				completedList.add(joinLine(i, spaceDelimitedArray));
			}
		}
		return completedList;
	}
	
	/*
	 * This method returns a string with all words in the array being joined. 
	 * Parameters: int, string[]
	 * Return:		string
	 * 
	 */
	private String joinLine(int posNo, String[] arr){
		StringBuffer sb = new StringBuffer();
		for (int i = posNo; i < arr.length; i++) {
			sb.append(arr[i]);
			sb.append(" ");
		}
		if(posNo != 0){
			for (int i = 0; i < posNo; i++) {
				sb.append(arr[i]);
				sb.append(" ");
			}
		}
		String outputString = sb.toString().trim();
		outputString = capitalizeFirstWord(outputString);
		return outputString;
	}
	
	/*
	 * This method returns a string that has it's first letter of the first word capitalized 
	 * Parameters: string
	 * Return:		string
	 * 
	 */
	private String capitalizeFirstWord(String line){
		return line.substring(0, 1).toUpperCase() + line.substring(1);
	}
	
	/*
	 * This method returns a string[] which has spaces removed
	 * Parameters: string
	 * Return:		string[]
	 * 
	 */
	private String[] tokenizeLine(String line){
		String[] delimitedArray = line.split("\\s+");
		return delimitedArray;
	}
}

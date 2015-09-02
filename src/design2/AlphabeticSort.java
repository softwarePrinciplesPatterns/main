package design2;

import java.util.ArrayList;
import java.util.Collections;


public class AlphabeticSort {
	CircularShift circularShift;
	private static AlphabeticSort mAlphabeticSort = null;
	private ArrayList<String> sortedList = new ArrayList<String>();

	public AlphabeticSort(){
		this.circularShift = CircularShift.getInstance();
	}
	
	public void execute(){
		this.sortedList = circularShift.getShiftedList();
		sort();
	}

	public void reset(){
		sortedList.clear();
	}
	
	public static AlphabeticSort getInstance(){ 
		if(mAlphabeticSort == null) {
			mAlphabeticSort = new AlphabeticSort();
		}
		return mAlphabeticSort;
	}

	/*
	 * This method returns an arraylist that has already been sorted and ready for display at output class
	 * Parameters: none
	 * Return:		arraylist
	 * 
	 */
	public ArrayList<String> getSortedList(){
		return sortedList;
	}
	
	/*
	 * This method sorts the arraylist in alphabetical order
	 * Parameters: none
	 * Return:		none
	 * 
	 */
	public void sort(){
		Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);;
	}

}

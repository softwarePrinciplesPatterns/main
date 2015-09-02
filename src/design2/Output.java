package design2;

import java.util.ArrayList;


public class Output {
	private AlphabeticSort alphabeticSort;
	private ArrayList<String> completeList;
	private static Output mOutput = null;
	
	public Output(){
		this.alphabeticSort = AlphabeticSort.getInstance();
		this.completeList = alphabeticSort.getSortedList();
	}
	
	public static Output getInstance(){
		if (mOutput == null){
			mOutput = new Output();
		}
		return mOutput;
	}
	
	public void print(){
		System.out.println("-----Completed-----");
		for (int i = 0; i < completeList.size(); i++) {
			System.out.println(completeList.get(i));
		}
	}
}

package design2;

import java.io.FileNotFoundException;
import java.io.IOException;



public class MasterControl {
	static Input input;
	static CircularShift circularShift;
	static Storage storage;
	static AlphabeticSort alphabeticSort;
	static Output output;
	private static MasterControl mMasterControl = null;
	
	public MasterControl(){
	}
	
	public static MasterControl getInstance(){
		if (mMasterControl == null){
			mMasterControl = new MasterControl();
		}
		return mMasterControl;
	}
	
	public static void execute() throws FileNotFoundException, IOException {
		storage = Storage.getInstance();
		input = Input.getInstance();
		String[] fileNameArr = Cli.start();
		input.setup(fileNameArr[0], fileNameArr[1]);
		circularShift = CircularShift.getInstance();
		circularShift.execute();
		alphabeticSort = AlphabeticSort.getInstance();
		alphabeticSort.execute();
		output = Output.getInstance();
		output.print();
		reset();
	}
	
	public static void reset(){
		storage.reset();
		circularShift.reset();
		alphabeticSort.reset();
	}
}
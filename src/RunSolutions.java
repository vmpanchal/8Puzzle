/**
 * @author VPanchal
 *
 */
public class RunSolutions {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int[] testState = { 1, 1, 0, 1, 1, 1, 1, 1, 1 };
		int[] easyState = { 1, 3, 4, 8, 6, 2, 7, 0, 5 };
		int[] mediumState = { 2, 8, 1, 0, 4, 3, 7, 6, 5 };
		int[] hardState = { 5, 6, 7, 4, 0, 8, 3, 2, 1 };
		String testState2 = "00000000";
		String easyState2 = "134862705";
		String mediumState2 = "281043765";
		String hardState2 = "567408321";
		BFSolution.search(hardState2);
		// DFSolution.search(hardState2);
	}

}

import java.util.ArrayList;

/**
 * @author VPanchal
 *
 */
public class BoardState {
	private String board;
	private String dirMoved;
	private int pieceMoved;
	private int cost;
	private static final String UP = "UP";
	private static final String RIGHT = "RIGHT";
	private static final String DOWN = "DOWN";
	private static final String LEFT = "LEFT";
	private final String GOAL = "123804765";

	public BoardState(String boardPositions, String dirMoved, int pieceMoved, int cost) {
		this.board = boardPositions;
		this.dirMoved = dirMoved;
		this.cost = cost;
		this.pieceMoved = pieceMoved;
	}

	public ArrayList<BoardState> generateChildren() {
		ArrayList<BoardState> potentialChildren = new ArrayList<BoardState>();
		int zero = getZeroIndex();
		if (zero != 0 && zero != 3 && zero != 6)
			slidePiece(zero - 1, zero, potentialChildren, LEFT);
		if (zero != 6 && zero != 7 && zero != 8)
			slidePiece(zero + 3, zero, potentialChildren, UP);
		if (zero != 0 && zero != 1 && zero != 2)
			slidePiece(zero - 3, zero, potentialChildren, DOWN);
		if (zero != 2 && zero != 5 && zero != 8)
			slidePiece(zero + 1, zero, potentialChildren, RIGHT);
		return potentialChildren;
	}

	private void slidePiece(int d1, int d2, ArrayList<BoardState> s, String direction) {
		StringBuilder sb = new StringBuilder(board);
		sb.setCharAt(d1, board.charAt(d2));
		sb.setCharAt(d2, board.charAt(d1));
		s.add((new BoardState(sb.toString(), direction, Character.getNumericValue(board.charAt(d1)),
				Character.getNumericValue(sb.charAt(d1)) + Character.getNumericValue(sb.charAt(d2)))));
	}

	public boolean isGoal() {
		return this.equals(GOAL);
	}

	public boolean equals(BoardState that) {
		return this.board.equals(that.board);
	}

	public boolean equals(String that) {
		return this.board.equals(that);
	}

	public int getVal(int index) {
		return board.charAt(index);
	}

	public int getZeroIndex() {
		return board.indexOf('0');
	}

	/**
	 * @return the board
	 */
	public String getBoard() {
		return board;
	}

	/**
	 * @return the dirMoved
	 */
	public String getDirMoved() {
		return dirMoved;
	}

	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}

	public void printState() {
		System.out.println("| " + board.charAt(0) + " | " + board.charAt(1) + " | " + board.charAt(2) + " |");
		System.out.println(" ----------- ");
		System.out.println("| " + board.charAt(3) + " | " + board.charAt(4) + " | " + board.charAt(5) + " |");
		System.out.println(" ----------- ");
		System.out.println("| " + board.charAt(6) + " | " + board.charAt(7) + " | " + board.charAt(8) + " |");
		System.out.println("Move: " + pieceMoved + " moved " + dirMoved + " for cost: " + cost);
	}
}

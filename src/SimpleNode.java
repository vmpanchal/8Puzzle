import java.util.ArrayList;

import javafx.util.Pair;

/**
 * @author VPanchal
 *
 */
public class SimpleNode {
	private BoardState board;
	private SimpleNode parent;
	private ArrayList<SimpleNode> children;
	private int cost;
	private int depth;

	public SimpleNode(BoardState board, SimpleNode parent, int cost, int depth) {
		this.board = board;
		this.parent = parent;
		this.cost = cost;
		this.depth = depth;
		this.children=new ArrayList<SimpleNode>();
	}

	/**
	 * @return the children
	 */
	public ArrayList<SimpleNode> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void addChild(SimpleNode child) {
		this.children.add(child);
	}

	/**
	 * @return the board
	 */
	public BoardState getBoard() {
		return board;
	}

	/**
	 * @return the parent
	 */
	public SimpleNode getParent() {
		return parent;
	}

	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}
}

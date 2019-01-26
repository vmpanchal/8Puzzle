import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

/**
 * BFS Solution of 8 Puzzle
 */

/**
 * @author VPanchal
 *
 */

public class BFSolution {
	public static void search(String board) {
		SimpleNode root = new SimpleNode(new BoardState(board, "NULL", 0, 0), null, 0, 0);
		LinkedList<SimpleNode> queue = new LinkedList<SimpleNode>();
		HashSet<String> viewedBoards = new HashSet<String>();
		SimpleNode currNode = root;
		queue.add(root);
		while(!queue.isEmpty()) {
			currNode=queue.poll();
			if(!currNode.getBoard().isGoal()) {
				viewedBoards.add(currNode.getBoard().getBoard());
				ArrayList<BoardState> tempChildren = currNode.getBoard().generateChildren();
				for(BoardState bs : tempChildren) {
					if(!viewedBoards.contains(bs.getBoard())) {
						viewedBoards.add(bs.getBoard());
						SimpleNode newChild = new SimpleNode(bs, currNode, currNode.getCost() + bs.getCost(), 0);
						currNode.addChild(newChild);
						queue.add(newChild);
					}
				}
			}
			else {
				Stack<SimpleNode> solutionPath = new Stack<SimpleNode>();
				solutionPath.push(currNode);
				currNode = currNode.getParent();

				while (currNode.getParent() != null) {
					solutionPath.push(currNode);
					currNode = currNode.getParent();
				}
				solutionPath.push(currNode);

				int loopSize = solutionPath.size();

				for (int i = 0; i < loopSize; i++) {
					currNode = solutionPath.pop();
					currNode.getBoard().printState();
					System.out.println();
					System.out.println();
				}
				System.out.println("The cost was: " + currNode.getCost());
				System.exit(0);
			}
		}
	}
}

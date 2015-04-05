
public class Tree {

	private Node<Venue> root;
	
	public Tree(Venue root) {
		this.root = new Node<Venue>(root);
	}
	
	public Tree() {
		root = null;
	}
	
	/**
	 * Adds venue to tree based on score
	 * @param venue
	 * @param node
	 */
	public void add(Venue venue) {
		add(venue, root);
	}
	
	public void add(Venue venue, Node<Venue> node) {
		if (root == null) {
			venue.venueNode = node;
			root = new Node<Venue>(venue);
		}
		else if (venue.scoreCalc() < node.getData().scoreCalc() && node.getLeft() == null) {
			venue.venueNode = node;
			node.setLeft(venue);
		}
		else if (venue.scoreCalc() >= node.getData().scoreCalc() && node.getRight() == null) {
			venue.venueNode = node;
			node.setRight(venue);
		}
		else {
			if (venue.scoreCalc() < node.getData().scoreCalc()) add(venue, node.getLeft());
			else add(venue, node.getRight());
		}
	}
	
	/**
	 * Retrieves right-most element from a tree.
	 * @return Maximum element
	 */
	public Node<Venue> getMaxNode() {
		return getMaxNode(root);
	}
	
	public Node<Venue> getMaxNode(Node<Venue> node) {
		if (node.getRight() == null) return node;
		else return getMaxNode(node.getRight());
	}
	
	/**
	 * Checks if tree is empty 
	 * @return Boolean
	 */
	public boolean isEmpty() {
		return (root == null);
	}
	
	public void setRoot(Venue venue) {
		root = new Node<Venue>(venue);
	}
}

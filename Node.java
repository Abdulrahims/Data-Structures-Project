
@SuppressWarnings("hiding")
public class Node<Venue> {

	private Venue data;
	private Node<Venue> parent;
	private Node<Venue> left;
	private Node<Venue> right;
		
	public Node(Venue venue) {
		data = venue;
		left = null;
		right = null;
	}
	
	public Node(Venue venue, Node<Venue> left, Node<Venue> right) {
		data = venue;
		this.left = left;
		this.right = right;
	}
	
	public Node<Venue> nextBest() {
		
		if (this.hasLeftChild()) return this.left.getRightMostElement();
		else if (this.isRightChild()) return parent;
		else if (this.isMin()) return getRightMostElement(getRoot());
		else return specialNext();
	}
	
	public Node<Venue> specialNext() {
		if (parent.isLeftChild()) return parent.specialNext();
		if (parent.isRoot()) return getRightMostElement(getRoot());
		return parent.parent;
	}
	
	public Venue getData() {
		return data;
	}
	
	public Node<Venue> getLeft() {
		return left;
	}
	
	public Node<Venue> getRight() {
		return right;
	}
	
	public boolean isLeaf( )
	   {
	      return (left == null) && (right == null);                                               
	   } 
	
	public void setLeft(Venue venue) {
		left = new Node<Venue>(venue);
		left.parent = this;
	}
	
	public void setRight(Venue venue) {
		right = new Node<Venue>(venue);
		right.parent = this;
	}
	
	public boolean isLeftChild() {
		if (this.isRoot()) return false;
		else return this.equals(parent.left);
	}
	
	public boolean isRightChild() {
		if (this.isRoot()) return false;
		else return this.equals(parent.right);
	}
	
	public boolean hasLeftChild() {
		return left != null;
	}
	
	public boolean hasRightChild() {
		return right != null;
	}
	
	public boolean isRoot() {
		return parent == null;
	}
	
	public Node<Venue> getRightMostElement() {
		return getRightMostElement(this);
	}
	
	public Node<Venue> getRightMostElement(Node<Venue> node) {
		while (node.hasRightChild()) return getRightMostElement(node.right);
		return node;
	}
	
	public Node<Venue> getLeftMostElement(Node<Venue> node) {
		if (node.hasLeftChild()) return getLeftMostElement(node.left);
		return node;
	}
	
	public Node<Venue> getRoot() {
		if (!this.isRoot()) return parent.getRoot();
		return this;
	}
	
	public boolean isMin() { 
		return this.equals(getLeftMostElement(getRoot()));
	}
}


public class Node {
	public int child;
	public int parent;
	public int n;
	
	public Node(int child, int parent, int n) {
		this.child = child;
		this.parent = parent;
		this.n = n;
	}
	
	public Node getLeftChild() {
		return new Node(child+1, parent, n*2 + 1);
	}
	
	public Node getRightChild() {
		return new Node(child+1, parent, n*2 + 2);
	}
	
	public Node getParent() {
		return new Node(child, parent+1, (int)Math.floor((double)(n-1)/2));
	}
}

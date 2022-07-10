package List;
public class Node {

	private String value;
	private Node next;
	public int pos = -1;

	public Node(String value) {
		super();
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	public void setIndex(int pos){
		this.pos = pos;
	}

	public int getIndex(){
		return pos;
	}
}

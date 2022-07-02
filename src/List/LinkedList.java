package List;



public class LinkedList implements List {

    private Node list;

    @Override
    public boolean insert(String value) {
        Node newNode = new Node(value);
        newNode.setNext(list);
        list = newNode;

        return true;
    }

    @Override
    public boolean insert(String value, int pos) {
        

        return false;
    }

    @Override
    public boolean delete(String value) {
        
        return false;
    }

    @Override
    public Node searchElement(String value) {
        
        return null;
    }

    @Override
    public Node modifyElementByConsole(String toModifyValue) {
        
        return null;
    }

    @Override
    public void printElements() {
        
        
    }
    
}

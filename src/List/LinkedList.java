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
       

        Node salida = null;
		
		if(list != null) {
			
			Node aux = list;
			while(aux != null) {
				
				if(aux.getValue().equals(toModifyValue)) {
					salida = aux;
                    salida.setValue("H");
				}
				aux = aux.getNext();
			}
		}

		
		return salida;
       
    }

    @Override
    public void printElements() {
        
        if(list == null) {
			System.out.println("-");
		} else {
			
			Node aux = list;
			while(aux != null) {
				
				System.out.print(aux.getValue() + " ");
				aux = aux.getNext();
			}
			System.out.println();
		}
    }
    
}

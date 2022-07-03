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
    public boolean delete(String value)  {
        Node aux = list;
        Node temp = null;


        if (aux != null) {
            while (aux != null) {
                
                if (aux.getNext() == null) {
                    aux = aux.getNext();
                    
                    return true;
                }

                if(aux.getValue().equals(value)){
                    
                    temp = aux.getNext();
                    aux.setNext(temp.getNext());
                    System.out.println("dwaddw");
                    return true;
                }
                
                aux = aux.getNext();
            }
        }

        
        return false;
    }

    @Override
    public Node searchElement(String value) {
        while (list != null) {
            if (list.getValue() == value) {
                System.out.println("Elemento encontrado.");
                return list;
            }else 
                list = list.getNext();   
        }
        System.out.println("Elemento no encontrado.");
        return list;
    }

    @Override
    public Node modifyElementByConsole(String toModifyValue) {
        Node salida = null;
		
		if(list != null) {
			
			Node aux = list;
			while(aux != null) {
				
				if(aux.getValue().equals(toModifyValue)) {
					salida = aux;
                    salida.setValue("holanda");
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

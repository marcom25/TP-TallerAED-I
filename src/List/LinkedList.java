package List;

import java.util.Objects;



public class LinkedList implements List {
    private Node first, end;

    @Override
    public boolean insert(String value) {
        Node newNode = new Node(value);
        
        newNode.setNext(first);
        first = newNode;
        
        return true;
    }

    // @Override
    public boolean insert(String value, int pos) {
        Node aux = first;
        int count = 1;

        if (aux != null) {
            Node newNode = new Node(value);

            while (count < pos-1 && aux.getNext() != null) {
                aux = aux.getNext();
                count++;
            }

            if (count == pos-1) {
                newNode.setNext(aux.getNext());
                aux.setNext(newNode);
            } else if (count == pos) {
                newNode.setNext(aux);
                first = newNode;
            }
            else {
                if (count != pos - 1)
                    System.out.println("No hay suficientes elementos para insertar en la posicion deseada. Se insertara al final de la firsta");
                aux.setNext(newNode);
            }

            return true;
        }
        else {
            insert(value);
        }
        return false;
    }

    @Override
    public boolean delete(String value)  {
        Node aux = first;
        if (aux != null) {
            if (first==end && !Objects.equals(value, first.getValue())) {
                first=end=null;
            }else if (Objects.equals(value, first.getValue())) {
                first = aux.getNext();
            }else {
                Node prev, current;
                prev = first;
                current = first.getNext();
                
                while (current != null && !Objects.equals(current.getValue(), value)) {                    
                    prev = prev.getNext();
                    current = current.getNext();
                }

                if (current != null) {
                    prev.setNext(current.getNext());
                    if (current==end) {
                        end = prev;
                        return true;
                    }
                }
            }
        }

        return false; 
    }

    @Override
    public Node searchElement(String value) {
        Node aux = first;
        int count = 1;
        while (aux != null) {
            if (aux.getValue() == value) {
                System.out.println("Elemento encontrado en la posicion " + count);
                return aux;
            }else {
                aux = aux.getNext();
                count++;
            }
        }
        System.out.println("Elemento no encontrado.");
        return aux;
    }

    @Override
    public Node modifyElementByConsole(String toModifyValue) {
        Node salida = null;
		
		if(first != null) {
			
			Node aux = first;
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
        if(first == null) {
			System.out.println("-");
		} else {
			
			Node aux = first;
			while(aux != null) {
				
				System.out.println(aux.getValue() + " " );
				aux = aux.getNext();
			}
			System.out.println();
		}
    }

    // @Override
    // public void orderElements() {

    // }
}
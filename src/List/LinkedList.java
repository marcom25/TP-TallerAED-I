package List;

import java.util.Objects;



public class LinkedList implements List {
    private Node list;
    private Node first, end;

    @Override
    public boolean insert(String value) {
        Node newNode = new Node(value);
        if (list == null) {
            newNode.pos = 0;
            first=end=newNode;
        }else {
            end.pos++;
        }
        
        newNode.setNext(list);
        first = newNode;
        list = newNode;
        
        return true;
    }

    @Override
    public boolean insert(String value, int pos) {
    //     Node prev, current;
    //     prev = first;
    //     current = first.getNext();
    //     Node aux = list;
    //     if(aux != null){
    //         if(aux.pos == first.pos){
    //             aux.setNext(first.getNext());
    //             first = aux;
    //         }else if() {

    //         }

    //         // if (aux.pos == pos) {
    //         //     newNode.pos = 0;
    //         //     first=end=newNode;
    //         // }else 
    //         //     end.pos++;
            
    //     }

        return false;
    }

    @Override
    public boolean delete(String value)  {
        Node aux = list;
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
        Node aux = list;
        while (aux != null) {
            if (aux.getValue() == value) {
                System.out.println("Elemento encontrado.");
                return aux;
            }else 
                aux = aux.getNext();   
        }
        System.out.println("Elemento no encontrado.");
        return aux;
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
			
			Node aux = first;
			while(aux != null) {
				
				System.out.print(aux.getValue() + " ");
				aux = aux.getNext();
			}
			System.out.println();
		}
    }

    
}

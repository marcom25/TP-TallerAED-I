package List;

import java.util.Objects;



public class LinkedList implements List {
    private Node list;
    private Node first, end;

    @Override
    public boolean insert(String value) {
        Node newNode = new Node(value);
        if (list == null) {
            newNode.pos = -1;
            first=end=newNode;
            end.pos = 1;
        }else {
            newNode.pos = end.pos++;
        }
        
        newNode.setNext(list);
        first = newNode;
        list = newNode;
        
        return true;
    }

    // @Override
    public boolean insert(String value, int pos) {
    //     Node newNode = new Node(value);
    //     newNode.pos = pos;
    //     Node aux = list;

    //     if (aux == null && pos >= 0) {
    //         System.out.println("Entra a meter el primer nodo");
    //         first = newNode;
    //         return true;
    //     }else if (aux.pos > pos && pos >= 0 || aux.pos == pos) {
    //         newNode.setNext(aux);
    //         aux = newNode;
    //         return true;
    //     }else if (pos >= 0) {
    //         System.out.println("Entra a meter uno");
    //         Node current = first;
    //         Node prev = first;

    //         while (current != null) {
    //             System.out.println("Entro, valor actual de la posicion: " + current.pos);
    //             System.out.println("Valor del nodo: " + current.getValue());
    //             if(pos != current.pos){
    //                 System.out.println("No encontró uno igual");
    //                 prev = prev.getNext();
    //                 current = current.getNext();
    //                 if (current != null) {
    //                     System.out.println("current: " + current.getValue());
    //                 }
    //             }else if(current.pos > pos ){
    //                 prev.setNext(newNode);
    //                 newNode.setNext(current);  
    //                 System.out.println("Nodo nuevo agregado a la posición " + pos + " correctamente!.");
    //                 return true;
    //             }else if (current.pos == pos) {
    //                 System.out.println("Encontró uno igual");
    //                 prev.setNext(newNode);
    //                 newNode.setNext(current); 
    //                 System.out.println("Nodo agregado a una posición ya ocupada.");
    //                 while (current != null) {
    //                     System.out.println("Entra al while chico");
    //                     current.pos++;
    //                     current = current.getNext();
    //                 }
    //                 return true;
    //             }
    //         }
    //         // prev.setNext(newNode);
    //         // end = prev.getNext();
    //     }else 
    //         System.out.println("Posición indicada menor a 0. Por favor, indique una posición desde 0 en adelante.");

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
				
				System.out.print(aux.getValue() + " " );
                System.out.println("index: " + aux.pos);
				aux = aux.getNext();
			}
			System.out.println();
		}
    }

    
}

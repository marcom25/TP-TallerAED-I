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
    public boolean delete(String value /*<-- esto debe ser 'Node value'*/)  {
        Node aux = list;
        Node last;

        while (aux != null) {
            last = aux;
            if(aux.getValue().equals(value)){
                last.setNext(aux.getNext()/*.getValue()*/); /* <-- aca no se puede referenciar al siguiente nodo ya que tenemos
                                                que aplicar aux.getNext().getValue() <-- no se puede en este
                                                caso ya que los valores de getValue() son de tipo String, y el método 
                                                setNext() solo permite insertar objetos tipo 'Node'. Hay que cambiar 
                                                el tipo de parámetro que recibe este método. *Yo lo cambiaría pero 
                                                marquinhos es un salame y quiere dejar el código como nos lo dio el profe*
                                            */
                // System.out.println("aux.getValue(): " + aux.getValue());
                return true;
            }
            aux = aux.getNext();
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

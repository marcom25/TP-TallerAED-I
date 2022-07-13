package List;

import java.util.Objects;
import java.util.Scanner;

public class LinkedList implements List, Sortable {
    private Node first, end;

    @Override
    public boolean insert(String value) {
        Node newNode = new Node(value);

        newNode.setNext(first);
        first = newNode;

        return true;
    }

    @Override
    public boolean insert(String value, int pos) {
        Node aux = first;
        int count = 1;

        if (aux != null) {
            Node newNode = new Node(value);

            while (count < pos - 1 && aux.getNext() != null) {
                aux = aux.getNext();
                count++;
            }

            if (count == pos - 1) {
                newNode.setNext(aux.getNext());
                aux.setNext(newNode);
            } else if (count == pos) {
                newNode.setNext(aux);
                first = newNode;
            } else {
                if (count != pos - 1)
                    System.out.println(
                            "No hay suficientes elementos para insertar en la posicion deseada. Se insertara al final de la firsta");
                aux.setNext(newNode);
            }

            return true;
        } else {
            insert(value);
        }
        return false;
    }

    @Override
    public boolean delete(String value) {
        Node aux = first;
        if (aux != null) {
            if (first == end && !Objects.equals(value, first.getValue())) {
                first = end = null;
            } else if (Objects.equals(value, first.getValue())) {
                first = aux.getNext();
            } else {
                Node prev, current;
                prev = first;
                current = first.getNext();

                while (current != null && !Objects.equals(current.getValue(), value)) {
                    prev = prev.getNext();
                    current = current.getNext();
                }

                if (current != null) {
                    prev.setNext(current.getNext());
                    if (current == end) {
                        end = prev;
                        return true;
                    }
                }
            }
        }
        System.out.println("No se encontro el elemento a eliminar.");
        return false;
    }

    @Override
    public Node searchElement(String value) {
        Node aux = first;
        int count = 1;
        while (aux != null) {
            if (Objects.equals(aux.getValue(), value)) {
                System.out.println("Elemento encontrado en la posicion " + count);
                return aux;
            } else {
                aux = aux.getNext();
                count++;
            }
        }
        System.out.println("Elemento no encontrado.");
        return aux;
    }

    @Override
    public Node modifyElementByConsole(String toModifyValue) {
        Scanner input = new Scanner(System.in);
        String newValue;
        Node output = null;

        if (first != null) {

            Node aux = first;
            while (aux != null) {

                if (aux.getValue().equals(toModifyValue)) {
                    output = aux;
                    System.out.println("Por favor, ingrese el nuevo valor.");
                    newValue = input.nextLine();
                    output.setValue(newValue);
                }
                aux = aux.getNext();
            }
        }

        return output;

    }

    @Override
    public void printElements() {
        if (first == null) {
            System.out.println("-");
        } else {

            Node aux = first;
            while (aux != null) {

                System.out.print("[" + aux.getValue() + "]-->");
                aux = aux.getNext();
            }
            System.out.println();
        }
    }

    @Override
    public void sort() {
        sortList(first);
    }

    private Node sortList(Node head) {

        if (head == null || head.getNext() == null) {
            return head;
        }

        Node aux = head;
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.getNext() != null) {
            aux = slow;
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        aux.setNext(null);

        Node leftSide = sortList(head);
        Node rightSide = sortList(slow);

        return merge(leftSide, rightSide);
    }

    private Node merge(Node l1, Node l2) {

        Node sortedTemp = new Node("");
        Node currentNode = sortedTemp;

        while (l1 != null && l2 != null) {
            System.out.println("l1:"+l1.getValue() + "l2:" + l2.getValue());
            int key = l1.getValue().compareToIgnoreCase(l2.getValue());
            System.out.println(key);
            if (key < 0) {
                currentNode.setNext(l1);
                l1 = l1.getNext();
            } else if (key == 0) {
                currentNode.setNext(l1);
                l1 = l1.getNext();
            } else if (key > 0) {
                currentNode.setNext(l2);
                l2 = l2.getNext();
            }

            currentNode = currentNode.getNext();
        }

        currentNode.setNext((l1 == null) ? l2 : l1); 

        return sortedTemp.getNext();
    }

}
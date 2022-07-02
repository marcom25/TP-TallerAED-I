import List.LinkedList;

public class App {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert("hola");
        list.insert("como");
        list.insert("estas");
        // list.modifyElementByConsole("hola");
        list.delete("como");
        // list.searchElement("hola");
        list.printElements();
        

    }
}

import List.LinkedList;

public class App {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert("10");
        list.insert("9");
        list.insert("8");
        list.insert("7");
        list.insert("6");
        list.insert("5");
        list.insert("4");
        list.insert("3");
        list.insert("2");
        list.insert("1");
        
        
        // list.modifyElementByConsole("hola");
        list.delete("10");
        System.out.println(list.delete("10"));
        // list.searchElement("hola");
        list.printElements();
        

    }
}

import java.util.ArrayList;
import java.util.List;

public class ListManager {

    // add element to list
    public void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    // remove element from list
    public void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }

    // to get list size
    public int getSize(List<Integer> list) {
        return list.size();
    }

    public static void main(String[] args) {
        ListManager manager = new ListManager();
        List<Integer> list = new ArrayList<>();

        manager.addElement(list, 10);
        manager.addElement(list, 20);
        manager.addElement(list, 30);

        System.out.println("List after adding elements: " + list);
        System.out.println("List size: " + manager.getSize(list));

        manager.removeElement(list, 20);
        System.out.println("List after removal: " + list);
        System.out.println("Updated size: " + manager.getSize(list));
    }
}

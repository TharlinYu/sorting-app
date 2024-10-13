package th.yu;

import java.util.*;

public class SortingApp {
    public static void main(String[] args) {
        new SortingApp().sortingApp();
    }

    public void sortingApp() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            if (!scanner.hasNextInt()) break;
            list.add(scanner.nextInt());
        }
        list.sort(Integer::compare);
        System.out.println(list);
    }
}
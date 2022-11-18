package day19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Neil Alishev
 */
public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {
        // „ичиков - 601 (Chichikov)

        File textError = new File("src\\main\\resources\\dushi.txt"); //кодировка (encoding)
        File text = new File("test19.txt"); //copy of dushi.txt


        Scanner scanner = new Scanner(text);
        scanner.useDelimiter("[.,:;()?!\"\\sЦ]+");

        List<String> list = new ArrayList();
        while (scanner.hasNext())
            list.add(scanner.next());

        String[] words = list.toArray(new String[0]);
        Map<String, Integer> map = new HashMap<String, Integer>();
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            count = 0;
            for (int j = 0; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count++;
                }
            }
            map.put(words[i], count);
        }

        //can be displayed on the screen "Chichikov"
        System.out.println(map.get("„ичиков") + "  раз в произведении было использовано слово У„ичиковФ (фамили€ главного геро€)."); // „ичиков - 601
        //System.out.println(entriesSortedByValues(map));

        Object[] words100 = entriesSortedByValues(map).toArray();
        for (int i = 0; i < 100; i++) {
            System.out.println(words100[i]);
        }
    }


    static <K, V extends Comparable<? super V>>
    SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
        SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<Map.Entry<K, V>>(
                new Comparator<Map.Entry<K, V>>() {
                    @Override
                    public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                        int res = e2.getValue().compareTo(e1.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}

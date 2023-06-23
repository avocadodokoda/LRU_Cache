import java.util.Scanner;

import lruPackage.LRU_Cache;

public class Test {
    public static void main(String[] args){
        Object value;
        Scanner scanner = new Scanner(System.in);
        System.out.print("key:");
        Object key = scanner.next();

        LRU_Cache lru = new LRU_Cache();
        lru.put("a", "apple");
        lru.put("b", "banana");
        lru.put("c", "cherry");
        value = lru.get(key);
        System.out.println("lru.get(" + key + ") => " + value);
        scanner.close();
    }
}

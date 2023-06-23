import lruPackage.LRU_Cache;

public class Test {
    public static void main(String[] args){
        Object value;
        LRU_Cache lru = new LRU_Cache();
        lru.put("a", "apple");
        lru.put("b", "banana");
        lru.put("c", "cherry");
        lru.put("b", "berry");
        value = lru.get("a");
        System.out.println("value: " + value);
    }
}

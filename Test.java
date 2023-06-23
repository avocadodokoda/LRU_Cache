import lruPackage.LRU_Cache;

public class Test {
    public static void main(String[] args){
        Object value;
        LRU_Cache lru = new LRU_Cache();
        lru.put("a", "apple");
        lru.put("b", "banana");
        lru.put("c", "cherry");
        String[] allay = {"a", "b", "c"};
        for (int i = 0; i < allay.length; i++){
            value = lru.get(allay[i]);
            System.out.println("key:" + i);
            System.out.println("value:" + value);
        }

        lru.test2();
    }
}

import java.util.HashMap;
import java.util.Map;

import LRU_Cache.lru;

public class Test {
    Package LRU;
    public static void main(String[] args){
        LRU_Cache lru_Cache = new LRU_Cache();
        lru
        Object result;
        LRU_Cache.lru.put("a", "apple");
        LRU_Cache.lru.put("b", "banana");
        result = LRU_Cache.lru.get("a");
        System.out.println(result);
        LRU_Cache.lru.put("c", "cherry");
        result = LRU_Cache.lru.get("c");
        System.out.println(result);

        Map<String, String> testMap = new HashMap<>();
        testMap.put("a", "apple");
        String aa = testMap.get("a");
        System.out.println(aa);
        
    }
}

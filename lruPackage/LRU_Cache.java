package lruPackage;

import java.util.HashMap;
import java.util.Map;

public class LRU_Cache{
    public int size;
    public Map<Object, Object> map1 = new HashMap<>();
    public void put(Object key, Object value){
        map1.put(key, value);
        System.out.println("put!");
    }

    public Object get(Object key){
        Object value = map1.get(key);
        return value;
    }
}
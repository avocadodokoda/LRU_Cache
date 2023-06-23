package lruPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRU_Cache{
    public int size = 2;
    public Map<Object, Object> map = new HashMap<>();
    public List<Object> list = new ArrayList<>();

    public void put(Object key, Object value){
        if(map.containsKey(key)){
            //mapにそのkeyが存在するとき
            int index = list.indexOf(key);
            removeOne(index);
        }
        map.put(key, value);
        addFront(key);
        rmBottom();

    }

    public Object get(Object key){
        Object value = map.get(key);
        if(map.containsKey(key)){
            //mapにそのkeyが存在するとき
            int index = list.indexOf(key);
            removeOne(index);
            addFront(key);
            rmBottom();
        }
        return value;
    }
    //一個消す
    private void removeOne(int index){
        list.remove(index);
    }
    //一番上に追加
    private void addFront(Object key){
        list.add(0, key);
    }
    //一番下を消す
    private void rmBottom(){
        //listの要素数がサイズより大きかったらサイズ番目の要素を消す。
        int length = list.size();
        while(length > size){
            Object key = list.get(size);
            map.remove(key);
            list.remove(size);
            length = list.size();
        }
    }



}
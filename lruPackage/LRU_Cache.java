package lruPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRU_Cache{
    public int size = 4;
    public Map<Object, Object> map = new HashMap<>();
    public List<Object> list = new ArrayList<>();

    public void put(Object key, Object value){
        map.put(key, value);
        System.out.println("put!");
        int num = size;
        int length = list.toArray().length;//リストの要素数
        if(map.containsKey(key)){
            for(int i = 0; i < length; i++){
                if(list.get(i) == key){
                    num = i;
                }
            }
            slide(num);
        }else {
            slide(size);
        }
        addFront(key);
        rmBottom();

    }

    public Object get(Object key){
        Object value = map.get(key);
        int num = size;
        int length = list.toArray().length;
        if(map.containsKey(key)){
            for(int i = 0; i < length; i++){
                if(list.get(i) == key){
                    num = i;
                }
            }
            slide(num);
            addFront(key);
            rmBottom();
        }
        return value;
    }
    //下にずらす
    private void slide(int num){

        for( int i = num; i > 0; i--){
            list.set(i, list.get(i - 1));
        }
    }
    //一番上に追加
    private void addFront(Object key){
        list.add(0, key);
    }
    //一番下を消す
    private void rmBottom(){
        int length = list.toArray().length;
        if(size <= length){
            for(int i = size; i < length; i++){
                Object key = list.get(i);
                map.remove(key);
                list.remove(size);
            }
        }
    }

    public void test2(){
        System.out.println("list.toArray().length : " + list.toArray().length);
        System.out.println("list.toArray().toString() : ");
        System.out.println("size : " + size);
        for(int i = 0; i < 6; i++){

            System.out.println("list.get(i) : " + list.get(i));
            System.out.println("map.get(list.get(i))) : " + map.get(list.get(i)));
        }
    }
}
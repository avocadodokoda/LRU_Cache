import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class LRU_Cache {
    Package LRU;
    private Map<Object, Object> nestedMap;
    private Map<Object, Object> innerMap;
    public LRU_Cache() {
        nestedMap = new HashMap<>();
        innerMap = new HashMap<>();

    }
    public class lru {
        public  <K, V> void put(K key, V value){
            int size = 2;
            innerMap.put(key, value);
            if(innerMap.containsKey(key)){
                //データが存在するとき
                int num = 0;
                for(int i = 0; i < size; i++){
                    //何番目に入ってるか
                    if(nestedMap.containsKey(i)){{
                        num = i;
                    }}
                }
                nestedMap.put(-1, nestedMap.get(num));
                for (int i = num; i > 0; i--){
                    nestedMap.put(i - 1, nestedMap.get(i));
                }
                nestedMap.put(0, nestedMap.get(-1));
                nestedMap.remove(-1);
            }else {
                //データが存在しない時
                for (int i = size - 1; i > 0; i--){
                    nestedMap.put(i, nestedMap.get(i-1));
                }
                nestedMap.put(0, key);
            }

        }
        public  <K> Object get(K key){
            int size = 2;
            Object value = innerMap.get(key);
            if(innerMap.containsKey(key)){
                //データが存在するとき
                int num = 0;
                for(int i = 0; i < size; i++){
                    //何番目に入ってるか
                    if(nestedMap.containsKey(i)){{
                        num = i;
                    }}
                }
                nestedMap.put(-1, nestedMap.get(num));
                for (int i = num; i > 0; i--){
                    nestedMap.put(i - 1, nestedMap.get(i));
                }
                nestedMap.put(0, nestedMap.get(-1));
                nestedMap.remove(-1);
            }

            return value;

        }


    }
    public static void main(String[] args){
        int size = 2;//最大サイズ
        Scanner scanner = new Scanner(System.in);
        LRU_Cache lru_Cache = new LRU_Cache();
        Map<Object, Object> nestedMap = lru_Cache.nestedMap;
        Map<Object, Object> innerMap = lru_Cache.innerMap;
        
        
        boolean allNull = true;
        //keyとvalueを入力させる
        for (int i = 0; i < size; i++){
            if(nestedMap.get(i) != null){
                allNull = false;
            }
        }
        if(allNull){
            //最初
            System.out.print("key:"); 
            Object key = scanner.next();
            System.out.print("value:");
            String value = scanner.next();
    
            System.out.println("key:" + key + ", value:" + value);
    
            scanner.close();
            LRU_Cache.lru.put(key, value);

        }else {
            //2回目以降
            System.out.print("getかputを選択してください:");
            String GorP = scanner.next();

            if(GorP.equals("get")){
                System.out.print("keyを入力してください:");
                String key = scanner.next();
                Object value = innerMap.get(key);
                System.out.print("key:" + key + ", value:" + value);
                LRU_Cache.lru.get(key);
            }else if(GorP.equals("put")){
                System.out.print("key:"); 
                Object key = scanner.next();
                System.out.print("value:");
                String value = scanner.next();
        
                System.out.println("key:" + key + ", value:" + value);
                LRU_Cache.lru.put(key, value);
            }else {
                System.out.println("無効な入力です。");
            }
            scanner.close();
           
        }
        System.out.println("現在のデータ");
        for(int i = 0; i < size; i++){
            
            System.out.println(i + ", key:" + nestedMap.get(i) + ", value:" + innerMap.get(nestedMap.get(i)));
        }

    }
}

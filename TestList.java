
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestList{
    public Map<Object, Object> map = new HashMap<>();
    public List<Object> list = new ArrayList<>();
    public static void main(String[] args){
        tttt();
    }
    public static void tttt(){
        TestList instance = new TestList();
        instance.list.add(0, "aaa");
        instance.list.add(1, "bbb");
        instance.list.add(2, "ccc");
        System.out.println(instance.list.get(0));
        System.out.println(instance.list.get(1));
        System.out.println(instance.list.get(2));

    }

}
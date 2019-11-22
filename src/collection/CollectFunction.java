package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * collect:
 */
public class CollectFunction {

    public void method(){
        List<User> users = new ArrayList<>();
        users.add(new User("1",10));
        users.add(new User("2",20));
        users.add(new User("3",30));
        /**
         * @arg1:构造一个新对象处理流中的元素
         * @arg2:单个流元素的处理方式
         * @arg3:将流元素处理的结果汇总
         */
        Map<Integer, User> maps = users.parallelStream().collect(new Supplier<Map>() {
            @Override
            public Map get() {
                return new HashMap();
            }
        }, new BiConsumer<Map, User>() {
            @Override
            public void accept(Map map, User user) {
                map.put(user.getName(), user.getAge());
            }
        }, new BiConsumer<Map, Map>() {
            @Override
            public void accept(Map map, Map map2) {
                map.putAll(map2);
            }
        });
        //简化写法
        users.parallelStream().collect(HashMap::new, (map,user)->{map.put(user.getAge(), user);}, HashMap::putAll);
        users.parallelStream().collect(()->{return new HashMap<>();}, (map,user)->{map.put(user.getAge(), user);}, (map1,map2) -> {map1.putAll(map2);});
    }

    public void listToMap(){
        List<User> users = new ArrayList<>();
        users.add(new User("1",10));
        users.add(new User("2",20));
        users.add(new User("3",30));

        Map<String, Integer> rst = users.parallelStream().collect(Collectors.toMap(User::getName, User::getAge));
    }
}

class User{

    private String name;

    private int age;

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
}
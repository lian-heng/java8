package collection;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionApis {

    private List<Integer> list = Arrays.asList(new Integer[]{1,null,2,2,3,4,5,5,6,7});

    public Stream<Integer> filter(){
        return list.stream().filter(i -> i != null);
    }

    public Stream<Integer> distinct(){
        return list.stream().distinct();
    }

    public Stream<Integer> sorted(){
        //list.stream().sorted((i,j)-> i-j);
        return list.stream().sorted();
    }

    public void sum(){
        Integer integer = filter().mapToInt(i -> i).sum();
        Long l = filter().mapToLong(i -> i).sum();
        Double d = filter().mapToDouble(i -> i).sum();
    }

    public Integer max(){
        return filter().max((i,j) -> i - j).get();
    }

    public Integer min(){
        return filter().min((i,j) -> i - j).get();
    }
}

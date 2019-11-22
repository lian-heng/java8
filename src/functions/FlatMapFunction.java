package functions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * FlatMap:
 * flatMap是将流中的元素转换成一个个的stream再合并至一个stream
 * map是流中的元素转换成另外的类型
 */
public class FlatMapFunction {

    /**
     * eg: 将["Hello", "World"] 转换成 [H, e, l, l, o, w, o, r, l, d]
     */

    //flatMap中的函数返回必须是Stream,List元素类型是String
    public void flatMap(){
        List<String> list = Stream.of("Hello", "World").flatMap(word -> Stream.of(word.split(""))).collect(Collectors.toList());
        System.out.println(list);//[H, e, l, l, o, w, o, r, l, d]
    }
    //flatMap中的函数返回类型与调用链返回值List元素类型匹配
    public void map(){
        List<String[]> list = Stream.of("Hello", "World").map(word -> word.split("")).collect(Collectors.toList());
        System.out.println(list);//[[H, e, l, l, o], [W, o, r, l, d]]
    }
}

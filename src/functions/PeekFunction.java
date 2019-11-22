package functions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * peek:
 * 没有返回值
 *
 * peek的源代码中有下述备注(大意是主要用于测试):
 * This method exists mainly to support debugging, where you want to see the elements as they flow past a certain point in a pipeline.
 */
public class PeekFunction {

    private List<Integer> list = Arrays.asList(new Integer[]{1,2});

    //结果1,2
    public void peek(){
        list.stream().peek(num -> ++num).collect(Collectors.toList());
    }
    //结果2,3
    public void map(){
        list.stream().map(num -> ++num).collect(Collectors.toList());
    }
}

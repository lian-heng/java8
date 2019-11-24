package stream;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream的一些简单的api
 */
public class StreamApi {

    public void stream(){
        Stream stream = Stream.of(1,2);
    }

    //IntStream可以用于生成连续的int数字,例如1到1000
    //一定要用limit,不然就是无限生成
    public void intStream() {
        IntStream intStream = IntStream.iterate(1, i -> ++i).limit(1000);
    }
}
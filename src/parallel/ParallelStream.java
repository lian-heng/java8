package parallel;

import java.util.ArrayList;
import java.util.List;

/**
 * parallelStream:
 * 任务之间是独立的,且代码中不涉及到对同一个对象的更新操作,可以并行处理
 * 并发环境中,顺序不确定,对于依赖顺序的任务,不合适
 * 数据量不大时,顺序执行往往比并行执行更快,准备线程池、创建线程、服务器CPU情况都得考虑
 * 涉及到IO操作且任务之间不互相依赖,并行化是个不错的选择
 */
public class ParallelStream {

    private static final List<Integer> list = new ArrayList<>();

    static{
        for (int i = 0; i < 20; i++){
            list.add(i);
        }
    }

    public static void parallelStream(){
        int count = list.parallelStream().map(Service::doService).reduce((i,j)-> i+j).get();
        System.out.println(count);
    }

    public static void stream(){
        int count = list.stream().map(Service::doService).reduce((i,j)-> i+j).get();
        System.out.println(count);
    }

    public static void main(String [] args){
        long timestamp1 = System.currentTimeMillis();
        parallelStream();
        long timestamp2 = System.currentTimeMillis();
        System.out.println(timestamp2 - timestamp1);
        stream();
        long timestamp3 = System.currentTimeMillis();
        System.out.println(timestamp3 - timestamp2);
        //使用parallelStream的处理效率比stream高
    }

    static class Service{
        //模拟业务,假设该部分业务需要500毫秒的处理时间
        public static int doService(int num){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return num * 2;
        }
    }
}

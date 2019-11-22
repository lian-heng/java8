package stream;

import java.util.function.Supplier;

/**
 * Supplier:
 * 只有真正被使用时才会执行(调用get方法)
 */
public class LazyEvaluate {

    public static boolean service(final int value) {
        System.out.println("evaluating ..." + value);
        return value > 100;
    }

    public void method(final boolean input1, final boolean input2) {
        //实际上input1为false后,第二个参数就没有执行的意义了
        boolean result = input1 && input2;
    }

    public void method(final Supplier<Boolean> input1, final Supplier<Boolean> input2){
        boolean result = input1.get() && input2.get();
    }

    public static void main(String [] args){
        LazyEvaluate lazyEvaluate = new LazyEvaluate();
        //使用Supplier,将函数作为参数传入,第一个函数若为false,第二个函数不会被执行
        lazyEvaluate.method(() -> service(1), () -> service(2));
        //按照传统方式,执行完2个service方法后再继续,造成了潜在的性能浪费
        lazyEvaluate.method(service(1), service(2));
    }
}

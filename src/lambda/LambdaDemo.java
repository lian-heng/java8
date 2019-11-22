package lambda;

/**
 * Lambda表达式:
 */
public class LambdaDemo {

    public void method(){
        //接口中只有一个方法，可用这种方式表示实现
        Inter inter = () -> {/*逻辑代码*/};
        Inter2 inter2 = i -> {/*逻辑代码*/};
        Inter3 inter3 = (i,j) -> String.valueOf(i*j);
    }
}

//添加了FunctionalInterface的接口不允许有多个方法，但允许有一个default方法
@FunctionalInterface //jdk中的Runnable接口就使用了该注解
interface Inter{
    public void method();

    public default void defaultMethod(){

    }
}

@FunctionalInterface
interface Inter2{
    public void method(int i);
}

@FunctionalInterface
interface Inter3{
    public String method(int i, int j);
}
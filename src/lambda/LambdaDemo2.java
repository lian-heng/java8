package lambda;

import java.util.function.Consumer;

/**
 * Lambda表达式:
 */
public class LambdaDemo2 {

    public static void staticMethod(){

    }

    public void method(){

    }

    public void service() {
        new Thread(() -> {
            method();
        });
        new Thread(this::method);//更简洁的写法
        new Thread(LambdaDemo2::staticMethod);//静态方法的简化调用
        //上述2个写法是对下述写法的简化
        new Thread(new Runnable() {
            @Override
            public void run() {
                method();
            }
        });
    }
}
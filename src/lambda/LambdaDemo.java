package lambda;

/**
 * Lambda表达式:
 */
public class LambdaDemo {
    //接口中只有一个方法，可用这种方式表示实现
    Service service = () -> {/*逻辑代码*/};
    Service2 service2 = i -> {/*逻辑代码*/};
    Service3 service3 = (i,j) -> String.valueOf(i*j);
}

interface Service{
    public void service();
}

interface Service2{
    public void service(int i);
}

interface Service3{
    public String service(int i, int j);
}
package optional;

import java.util.Optional;

/**
 * Optional:
 */
public class OptionalDemo {
    //若name不为null，则返回map中的逻辑处理结果
    //若name为null则返回orElse中的逻辑处理结果，注意：即使name不为null也会执行orElse中的方法
    public String orElse(String name){
        return Optional.ofNullable(name).map(str -> "Hello " + str).orElse(service("0"));
    }
    //同上，但name不为null时，并不会执行orElseGet中的逻辑，优先考虑这个方法
    //orElseGet中的逻辑必须有返回值,注意Get关键词
    public String orElseGet(String name){
        return Optional.ofNullable(name).map(str -> "Hello " + str).orElseGet(() -> service("0"));
    }
    //若name不为null，则返回map中的逻辑处理结果
    //若name为null，则抛出异常，注意：即使不为null，也会构造异常对象
    public String orElseThrow(String name) throws Exception {
        return Optional.ofNullable(name).map(str -> "Hello" + str).orElseThrow(() -> new DefineException());
    }
    //若name不为空，则执行ifPresent中的逻辑片段
    public void ifPresent(String name){
        Optional.ofNullable(name).ifPresent(this::service);
    }

    private String service(String name){
        System.out.println("do service");//验证orElse和orElseGet的区别
        return "Hello" + name;
    }

    public class DefineException extends Exception {

        public DefineException() {
            System.out.println("DefineException Constructor");
        }
    }
}
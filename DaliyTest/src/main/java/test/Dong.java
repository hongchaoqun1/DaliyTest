package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hongcq
 * @Description TODO
 * @date 2019/5/20 13:12
 * @ClassName Dong
 */


interface Interface{
    void doSomething();
    void someThingElse(String arg);
}

class RealObject implements Interface{
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void someThingElse(String arg) {
        System.out.println("someThingElse" + arg);
    }
}

class SimpleProxy implements Interface{
    private Interface proxied;

    public SimpleProxy(Interface proxied){
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void someThingElse(String arg) {
        System.out.println("SimpleProxy someThingElse" + arg);
        proxied.someThingElse(arg);
    }
}

class DynamicProxyHandler implements InvocationHandler{
    private Object proxied;

    public DynamicProxyHandler(Object proxied){
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("***proxy:***" + proxy.getClass() + ", method:" + method + ", args:" +args);
        if(args != null){
            for(Object arg : args){
                System.out.println(" "+arg);
            }
        }
        return method.invoke(proxied, args);
    }
}

class Dong{
     public static void consumer(Interface iface){
         iface.doSomething();
         iface.someThingElse("demo");
     }

     public static void main(String[] args){
         RealObject real = new RealObject();
         consumer(real);
         Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                 new Class[]{Interface.class},
                 new DynamicProxyHandler(real));
         consumer(proxy);
     }
}

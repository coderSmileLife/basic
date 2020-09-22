package com.example.demo.multithreading;


import lombok.Data;

/**
 * 可继承 ThreadLocal demo
 */
public class InheritableThreadLocalTest {

    private static ThreadLocal<Integer> tl = new InheritableThreadLocal<>();
    private static ThreadLocal<Hello> tl2 = new InheritableThreadLocal<>();

    public static void main(String[] args) throws Exception {
        tl.set(1);

        Hello hello = new Hello();
        hello.setName("init");
        tl2.set(hello);
        System.out.printf("当前线程名称: %s, main方法内获取线程内数据为: tl = %s，tl2.name = %s%n",
                Thread.currentThread().getName(), tl.get(), tl2.get().getName());
        fc();
        new Thread(() -> {
            Hello hello1 = tl2.get();
            hello1.setName("init2");
            fc();
        }).start();
        Thread.sleep(1000L); //保证下面fc执行一定在上面异步代码之后执行
        fc(); //继续在主线程内执行，验证上面那一步是否对主线程上下文内容造成影响
    }

    private static void fc() {
        System.out.printf("当前线程名称: %s, fc方法内获取线程内数据为: tl = %s，tl2.name = %s%n",
                Thread.currentThread().getName(), tl.get(), tl2.get().getName());
    }
}


@Data
class Hello {

    private String name;

}
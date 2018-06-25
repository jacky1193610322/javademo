package com.chen;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Hello world!
 *
 */

class TestFinal {
    public int a;
}

public class App {

    public static void main(String[] args) {
        ConfigurableBeanFactory context = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //HelloWorldService postProcessor = new HelloWorldService();
        //context.addBeanPostProcessor(postProcessor);
        Foo service = (Foo) context.getBean("helloWorldService");
        Enumeration<URL> urls = null;
        try {
            urls = Foo.class.getClassLoader().getResources("META-INF/spring.schemas");
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                System.out.println(url.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(urls);
        //HelloWorldService service = (HelloWorldService) context1.getBean("helloWorldService");
        //AspectTest aspectTest = (AspectTest) context.getBean("aspectTest");
        //System.out.println(aspectTest);
        //System.out.println(service.getName());

        //TestFinal testFinal = new TestFinal();
        //System.out.println(System.identityHashCode(testFinal.a));
        //testFinal.a = 122342342;
        //System.out.println(System.identityHashCode(testFinal.a));
        //testFinal.a = 234234;
        //System.out.println(System.identityHashCode(testFinal.a));
        //LongAdder

        //String message = service.sayHello();
        //ConcurrentHashMap<String, String> stringStringConcurrentHashMap = new ConcurrentHashMap<String, String>();
        //Map<String, String> stringStringMap = new HashMap<String, String>();
        ////stringStringMap = new LinkedHashMap<String, String>();
        ////stringStringMap.put("chen", "yang");
        ////LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        ////linkedHashMap.put("a", "b");
        ////Hashtable hashtable = new Hashtable();
        ////Set<Entry<String, String>> set = stringStringMap.entrySet();
        ////Iterator iterator = set.iterator();
        ////while (iterator.hasNext()) {
        ////    Map.Entry entry = (Map.Entry) iterator.next();
        ////    System.out.println(entry.getKey());
        ////    System.out.println(entry.getValue());
        ////}
        //for (int i = 0; i < 1000; i++) {
        //    stringStringConcurrentHashMap.put("chenyang" + i, "chenyang");
        //    stringStringMap.put("test" + i, "test");
        //}
        //Boolean.parseBoolean("sadf");
        ////set a new name
        //service.setName("Spring");
        //message = service.sayHello();
        //System.out.println(message);
        //List<Integer> integerList = new LinkedList<Integer>();
        //integerList.iterator();
        //List<? extends Number> numberList = new ArrayList<Number>();
        //numberList = integerList;
        ////integerList.iterator();
        //System.out.println(integerList.getClass());
        //System.out.println(numberList.getClass());
        //((ClassPathXmlApplicationContext) context).close();
    }
}

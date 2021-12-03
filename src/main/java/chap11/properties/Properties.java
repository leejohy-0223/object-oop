package chap11.properties;

import java.util.Hashtable;


/*
 * 1. 불필요한 인터페이스 상속 문제 해결
 * Properties는 Hashtable을 더이상 상속받지 않고, 부모 클래스의 인스턴스를 자식 클래스의 인스턴스로 가지고만 있는다.
 * Properties는 부모 클래스의 퍼블릭 인터페이스(put, get)를 통해서만 Hashtable과 협력하게 된다.
 */
public class Properties {
    private Hashtable<String, String> properties = new Hashtable<>();

    public String setProperty(String key, String value) {
        return properties.put(key, value);
    }

    public String getProperty(String key) {
        return properties.get(key);
    }
}

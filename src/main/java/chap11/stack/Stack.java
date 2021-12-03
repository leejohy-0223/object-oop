package chap11.stack;

import java.util.EmptyStackException;
import java.util.Vector;

/*
 * 1. 불필요한 인터페이스 상속 문제 해결
 * Stack도 마찬가지로, Vector를 상속받지 않고 합성으로 참조한다.
 * 이제 Stack은 오롯이 LIFO의 역할을 할 수 있게 된다.
 * 사용되지 않는, 또는 오류를 발생할 여지가 있는 Vector의 메서드는 사용불가능해진다!
 */
public class Stack<E> {
    private Vector<E> elements = new Vector<>();

    public E push(E item) {
        elements.addElement(item);
        return item;
    }

    public E pop() {
        if (elements.isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }
}

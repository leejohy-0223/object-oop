package chap11.instrumented;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/*
 * 2. 메서드 오버라이딩의 오작용 문제 해결
 * 기존 InstrumentedHashSet의 문제는 부모 메서드 호출 시 그 안에서 자식의 오버라이딩 된 메서드를 호출하는 문제였다.
 *
 * 1) 우선 합성을 통해 HashSet을 외부로 부터 전달받는다.
 * 2) implements를 통해 Set 인터페이스를 구현한다. 이 때 오버라이딩에서는 합성된 부모의 인스턴스를 재 호출한다.(포워딩)
 * 3) 그리고 확장하고자 하는 기능(addCount)은 해당 메서드에 추가로 decorating하면 된다.
 */
public class InstrumentedHashSet<E> implements Set<E>{
    private int addCount = 0;
    private Set<E> set;

    public InstrumentedHashSet(Set<E> set) {
        this.set = set;
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }

    @Override
    public Object[] toArray() {
        return set.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return set.toArray(a);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return set.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return set.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return set.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return set.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return set.retainAll(c);
    }

    @Override
    public void clear() {
        set.clear();
    }

    public int getAddCount() {
        return addCount;
    }
}

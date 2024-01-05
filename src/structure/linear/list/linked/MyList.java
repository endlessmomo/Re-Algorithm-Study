package structure.linear.list.linked;

public interface MyList<E> {
    boolean add(E value);
    void add(int idx, E value);

    boolean remove(E value);
    E remove(int idx);

    E get(int idx);
    void set(int idx, E value);

    boolean contains(E value);
    int indexOf(E value);
    int lastIndexOf(E o);

    int size();
    boolean isEmpty();

    public void clear();
}

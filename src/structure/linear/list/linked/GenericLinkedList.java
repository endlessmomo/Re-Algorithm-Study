package structure.linear.list.linked;

import structure.linear.list.MyList;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class GenericLinkedList<T> implements MyList<T> {

    private static final int DEFAULT_CAPACITY = 5;
    // copy를 위한 배열
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private T[] array;
    private int size;

    public GenericLinkedList() {
        this.array = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public GenericLinkedList(int capacity) {
        if (capacity > 0) {
            this.array = (T[]) new Object[capacity];
        } else if (capacity < 0) {
            throw new IllegalArgumentException("음수의 Capacity는 존재할 수 없습니다.");
        } else {
            this.array = (T[]) new Object[DEFAULT_CAPACITY];
        }
        this.size = 0;
    }

    @Override
    public boolean add(T value) {
        resize();
        this.array[this.size++] = value;
        return true;
    }

    @Override
    public void add(int idx, T value) {
        if (idx < 0 || idx > this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (idx == this.size) {
            add(value);
        } else {
            resize();

            for (int i = this.size; i > idx; i--) {
                this.array[i] = this.array[i - 1];
            }

            array[idx] = value;
            this.size++;
        }
    }

    private void resize() {
        if (this.size == this.array.length) {
            int newCapacity = this.array.length * 2;
            this.array = Arrays.copyOf(this.array, newCapacity);
        } else if (size > DEFAULT_CAPACITY && this.array.length / 2 > this.size) {
            int newCapacity = array.length / 2;
            this.array = Arrays.copyOf(this.array, newCapacity);
        }
    }

    @Override
    public boolean remove(T value) {
        int targetIdx = indexOf(value);

        if (targetIdx == -1)
            return false;

        remove(targetIdx);
        return true;
    }

    @Override
    public T remove(int idx) {
        if (idx < 0 || idx > this.size) {
            throw new IndexOutOfBoundsException();
        }

        T returnData = this.array[idx];

        for (int i = idx; i < this.array.length - 1; i++) {
            this.array[i] = this.array[i + 1];
            this.array[i + 1] = null;
        }

        size--;
        resize();
        return returnData;
    }

    @Override
    public T get(int idx) {
        if (idx < 0 || idx > this.size) {
            throw new IndexOutOfBoundsException();
        }

        return this.array[idx];
    }

    @Override
    public void set(int idx, T value) {
        if (idx < 0 || idx > this.size) {
            throw new IndexOutOfBoundsException();
        }

        this.array[idx] = value;
    }

    // 리스트의 탐색은 순차 조회를 해야하기 때문에 O(N)의 시간이 걸린다.
    @Override
    public boolean contains(T value) {
        for (T val : array) {
            if (val.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T value) {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].equals(value)) {
                return i;
            }
        }

        return -1; // 음수는 탐색 실패 의미
    }

    @Override
    public int lastIndexOf(T value) {
        for (int i = this.array.length - 1; i >= 0; i--) {
            if (this.array[i] != null && this.array[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void clear() {
        this.array = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String[] args) {
        GenericLinkedList<Integer> glist = new GenericLinkedList<>();

        // 배열이 자동으로 확장되는지 확인 : 배열 idx 40
        for (int i = 0; i < 21; i++) {
            glist.add(i / 3);
        }
        System.out.println(glist.toString());

        // 배열이 자동으로 축소되는지 확인 : 배열 idx 10;
        for (int i = 20; i >= 9; i--) {
            glist.remove(i);
        }
        System.out.println(glist.toString());

        System.out.println(glist.lastIndexOf(2));
    }
}

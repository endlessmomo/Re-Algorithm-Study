package structure.linear.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

@SuppressWarnings("unchecked")
public class GenericStack<T extends Object> {
    private int top;
    private final int size;
    private final T[] array;

    public GenericStack(int size) {
        this.top = -1;
        this.size = size;
        this.array = (T[]) new Object[size];
    }

    public boolean push(T data){
        isFull();

        this.array[++top] = data;
        return true;
    }

    public T pop(){
        isEmpty();

        T data = this.array[top];
        this.array[top--] = null;
        return data;
    }

    public T peek() {
        isEmpty();

        return this.array[top];
    }
    public boolean contains(T target){
        isEmpty();

        for(T data : this.array){
            if(data != null && data.equals(target)) {
                return true;
            }
        }
        return false;
    }

    public boolean containAll(List<T> datas){
        isEmpty();

        for(T data : datas) {
            if(!contains(data)) {
                return false;
            }
        }
        return true;
    }
    public String toString(){
        return Arrays.toString(this.array);
    }

    public void isEmpty() {
        if(top == -1){
            throw new IllegalArgumentException("Stack no have data");
        }
    }

    public void isFull() {
        if(top == size - 1) {
            throw new IllegalArgumentException("Stack is Full");
        }
    }

    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>(10);

        int idx = 0;
        while(stack.push(idx)){
            if(idx == 9) {
                break;
            }
            System.out.println(idx++ + " 번째 실행");
        }

        System.out.println(stack.pop());
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.contains(10));
        Stack<Integer> stack1 = new Stack<>();
        System.out.println(stack.containAll(Arrays.asList(1,3,5)));
        System.out.println(stack.containAll(Arrays.asList(1,3,9)));
        System.out.println(stack.toString());

    }
}

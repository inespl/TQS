package stack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ITqsStack<T> extends TqsStack<T>{
    ArrayList<T> stack;
    private int limit = -1;

    public ITqsStack(){
        this.stack = new ArrayList<>();
    }

    public ITqsStack(int limit){
        this.limit = limit;
        this.stack = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return (stack.size() == 0);
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public T pop() {
        if (stack.size() == 0){
            throw new NoSuchElementException();
        }
        else {
            T first_item = stack.get(0);
            stack.remove(0);
            return first_item;
        }
    }

    @Override
    public void push(T item) {
        if (limit == stack.size()) {
            throw new IllegalStateException();
        }
        else {
            stack.add(0, item);
        }
    }

    @Override
    public T peek(){
        if (stack.size() == 0){
            throw new NoSuchElementException();
        }
        else {
            T first_item = stack.get(0);
            return first_item;
        }
    }
}

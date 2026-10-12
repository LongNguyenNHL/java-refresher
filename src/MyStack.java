import java.util.EmptyStackException;

public class MyStack {
    private int[] list = new int[1];
    private int size = 0;

    public int size() {
        return size;
    }
    public void push(int item) {
        if (size >= list.length) {
            int[] newList = new int[size * 2];

            for (int i = 0; i < size; i++) {
                newList[i] = list[i];
            }
            list = newList;
        }
        list[size++] = item;
    }

    public int pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return list[--size];
    }

    public int peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

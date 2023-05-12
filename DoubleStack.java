package coarsework;
import java.lang.reflect.Array;
import java.util.EmptyStackException;

public class DoubleStack<T> {
    private T[] data;
    private int redTop, blueTop;
    private final int capacity;

    public DoubleStack(int capacity, Class<T> clazz) {
    	data = (T[]) Array.newInstance(clazz, capacity);
        this.capacity = capacity;
        redTop = -1;
        blueTop = capacity;
    }

    public boolean isRedEmpty() {
        return redTop == -1;
    }

    public boolean isBlueEmpty() {
        return blueTop == capacity;
    }

    public boolean isFull() {
        return redTop + 1 == blueTop;
    }

    public void redPush(T item) {
        if (isFull()) {
            throw new StackOverflowError("stack full");
        }
        data[++redTop] = item;
    }

    public void bluePush(T item) {
        if (isFull()) {
            throw new StackOverflowError("stack full");
        }
        data[--blueTop] = item;
    }

    public T redPop() {
        if (isRedEmpty()) {
            throw new EmptyStackException();
        }
        return data[redTop--];
    }

    public T bluePop() {
        if (isBlueEmpty()) {
            throw new EmptyStackException();
        }
        return data[blueTop++];
    }

    public T redPeek() {
        if (isRedEmpty()) {
            throw new EmptyStackException();
        }
        return data[redTop];
    }

    public T bluePeek() {
        if (isBlueEmpty()) {
            throw new EmptyStackException();
        }
        return data[blueTop];
    }
    public static void main(String[] args) {
  DoubleStack<Integer> stack = new DoubleStack<>(10, Integer.class);

  stack.redPush(1);
  stack.redPush(2);
  stack.bluePush(3);
  stack.bluePush(4);

  int redTop = stack.redPop();
  int blueTop = stack.bluePop();

  System.out.println("Red top: " + redTop);
  System.out.println("Blue top: " + blueTop);
  System.out.println("Red is empty: " + stack.isRedEmpty());
  System.out.println("Blue is empty: " + stack.isBlueEmpty());
  System.out.println("Is the stack full? " + stack.isFull());
}

}

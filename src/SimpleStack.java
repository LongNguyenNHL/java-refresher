import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class SimpleStack<T> {
    private List<T> list = new ArrayList<>();

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return list.remove(size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public static <T extends Comparable<T>> T max(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        return list.stream().max(Comparable::compareTo).get();
    }

    Predicate<String> lengthGreater5 = s -> s.length() > 5;
    Function<Integer,Integer> square = (x) -> { return x * x;};
    Supplier<List<String>> emptyList = () -> new ArrayList<>();


    List<Integer> numbers = List.of(13, -1, 8, 0, -5, 12);
    public int filter(List<Integer> numbers) {
        return numbers.stream().filter(i -> i > 0).map(i -> i * 2).mapToInt(i -> i).sum();
    }
}

package assig2;

/**
 * Реализация динамического массива (ArrayList) без использования java.util.
 * @param <T> тип элементов, должен реализовывать Comparable
 */
public class MyArrayList<T extends Comparable<T>> implements MyList<T> {

    private Object[] data; // массив данных
    private int size; // текущий размер
    private static final int INITIAL_CAPACITY = 10;

    public MyArrayList() {
        data = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Увеличивает размер массива в 2 раза при необходимости.
     */
    private void ensureCapacity() {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            for (int i = 0; i < size; i++) newData[i] = data[i];
            data = newData;
        }
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    @Override
    public void add(T item) {
        ensureCapacity();
        data[size++] = item;
    }

    @Override
    public void set(int index, T item) {
        checkBounds(index);
        data[index] = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        ensureCapacity();
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        checkBounds(index);
        return (T) data[index];
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    @Override
    public void remove(int index) {
        checkBounds(index);
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    /**
     * Простая реализация сортировки пузырьком.
     */
    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                T a = (T) data[j];
                T b = (T) data[j + 1];
                if (a.compareTo(b) > 0) {
                    data[j] = b;
                    data[j + 1] = a;
                }
            }
        }
    }

    @Override
    public int indexOf(Object obj) {
        for (int i = 0; i < size; i++) {
            if (obj.equals(data[i])) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object obj) {
        for (int i = size - 1; i >= 0; i--) {
            if (obj.equals(data[i])) return i;
        }
        return -1;
    }

    @Override
    public boolean exists(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        for (int i = 0; i < size; i++) arr[i] = data[i];
        return arr;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) data[i] = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Позволяет использовать foreach.
     */
    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<>() {
            private int index = 0;

            public boolean hasNext() {
                return index < size;
            }

            public T next() {
                return (T) data[index++];
            }
        };
    }
}
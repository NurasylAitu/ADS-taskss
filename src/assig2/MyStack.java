package assig2;

public class MyStack<T extends Comparable<T>> {

    private final MyList<T> list;

    /**
     * Конструктор: создаёт пустой стек.
     */
    public MyStack() {
        this.list = new MyLinkedList<>();
    }

    /**
     * Добавляет элемент в стек.
     */
    public void push(T item) {
        list.addLast(item);
    }

    /**
     * Удаляет и возвращает верхний элемент стека.
     */
    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        T item = list.getLast();
        list.removeLast();
        return item;
    }

    /**
     * Возвращает верхний элемент, не удаляя его.
     */
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }

    public void printStack() {
        System.out.print("Stack (top -> bottom): ");
        for (T item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
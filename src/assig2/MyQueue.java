package assig2;

/**
 * Реализация очереди (FIFO — First In, First Out) на основе MyLinkedList.
 * @param <T> тип элементов, должен реализовывать Comparable
 */
public class MyQueue<T extends Comparable<T>> {

    private final MyList<T> list;

    /**
     * Конструктор: создаёт пустую очередь.
     */
    public MyQueue() {
        this.list = new MyLinkedList<>();
    }

    /**
     * Добавляет элемент в конец очереди.
     */
    public void enqueue(T item) {
        list.addLast(item);
    }

    /**
     * Удаляет и возвращает первый элемент (голову очереди).
     * @throws IllegalStateException если очередь пуста
     */
    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    /**
     * Возвращает первый элемент, не удаляя его.
     * @throws IllegalStateException если очередь пуста
     */
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return list.getFirst();
    }

    /**
     * Проверяет, пуста ли очередь.
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * Возвращает количество элементов в очереди.
     */
    public int size() {
        return list.size();
    }

    /**
     * Удаляет все элементы из очереди.
     */
    public void clear() {
        list.clear();
    }

    /**
     * Выводит очередь в консоль.
     */
    public void printQueue() {
        System.out.print("Queue (front -> rear): ");
        for (T item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

package assig2;

/**
 * Реализация минимальной бинарной кучи на основе MyArrayList.
 * В корне всегда находится наименьший элемент.
 * @param <T> тип элементов, должен быть Comparable
 */
public class MyMinHeap<T extends Comparable<T>> {

    private final MyArrayList<T> heap;

    /**
     * Конструктор: создаёт пустую кучу.
     */
    public MyMinHeap() {
        this.heap = new MyArrayList<>();
    }

    /**
     * Добавляет элемент в кучу и восстанавливает свойства мин-кучи.
     */
    public void insert(T item) {
        heap.add(item);
        heapifyUp(heap.size() - 1); // восстанавливаем кучу снизу вверх
    }

    /**
     * Удаляет и возвращает минимальный элемент (корень кучи).
     * @throws IllegalStateException если куча пуста
     */
    public T extractMin() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        T min = heap.get(0);
        // Переносим последний элемент в корень
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(0); // восстанавливаем кучу сверху вниз
        return min;
    }

    /**
     * Возвращает минимальный элемент (корень), не удаляя его.
     */
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    /**
     * Возвращает true, если куча пуста.
     */
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    /**
     * Возвращает количество элементов в куче.
     */
    public int size() {
        return heap.size();
    }

    /**
     * Удаляет все элементы из кучи.
     */
    public void clear() {
        heap.clear();
    }

    /**
     * Восстанавливает свойства кучи снизу вверх (для вставки).
     */
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) >= 0) break;
            swap(index, parent);
            index = parent;
        }
    }

    /**
     * Восстанавливает свойства кучи сверху вниз (для удаления).
     */
    private void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0)
                smallest = left;
            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0)
                smallest = right;

            if (smallest == index) break;
            swap(index, smallest);
            index = smallest;
        }
    }

    /**
     * Обменивает два элемента в массиве.
     */
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Выводит кучу в виде массива.
     */
    public void printHeap() {
        System.out.print("Heap array: ");
        for (T item : heap) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

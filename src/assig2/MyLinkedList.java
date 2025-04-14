package assig2;

/**
 * Реализация двусвязного списка без использования java.util.
 * @param <T> тип элементов, должен быть Comparable
 */
public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {

    /**
     * Узел списка.
     */
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head; // первый элемент списка
    private MyNode tail; // последний элемент списка
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        addLast(item); // по умолчанию добавляем в конец
    }

    @Override
    public void addFirst(T item) {
        MyNode node = new MyNode(item);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode node = new MyNode(item);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            checkBounds(index);
            MyNode nextNode = getNode(index);
            MyNode prevNode = nextNode.prev;

            MyNode node = new MyNode(item);
            node.prev = prevNode;
            node.next = nextNode;
            prevNode.next = node;
            nextNode.prev = node;
            size++;
        }
    }

    @Override
    public T get(int index) {
        checkBounds(index);
        return getNode(index).data;
    }

    @Override
    public T getFirst() {
        if (head == null) throw new IndexOutOfBoundsException("List is empty");
        return head.data;
    }

    @Override
    public T getLast() {
        if (tail == null) throw new IndexOutOfBoundsException("List is empty");
        return tail.data;
    }

    @Override
    public void set(int index, T item) {
        getNode(index).data = item;
    }

    @Override
    public void remove(int index) {
        checkBounds(index);
        removeNode(getNode(index));
    }

    @Override
    public void removeFirst() {
        if (head == null) return;
        removeNode(head);
    }

    @Override
    public void removeLast() {
        if (tail == null) return;
        removeNode(tail);
    }

    /**
     * Удаляет указанный узел, корректно переподключая ссылки.
     */
    private void removeNode(MyNode node) {
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;

        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;

        size--;
    }

    /**
     * Возвращает узел по индексу, оптимизируя обход (с головы или хвоста).
     */
    private MyNode getNode(int index) {
        checkBounds(index);
        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    /**
     * Простая пузырьковая сортировка узлов (обмен значениями).
     */
    @Override
    public void sort() {
        if (size <= 1) return;

        for (int i = 0; i < size - 1; i++) {
            MyNode current = head;
            while (current.next != null) {
                if (current.data.compareTo(current.next.data) > 0) {
                    T tmp = current.data;
                    current.data = current.next.data;
                    current.next.data = tmp;
                }
                current = current.next;
            }
        }
    }

    @Override
    public int indexOf(Object obj) {
        MyNode current = head;
        int index = 0;
        while (current != null) {
            if (obj.equals(current.data)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object obj) {
        MyNode current = tail;
        int index = size - 1;
        while (current != null) {
            if (obj.equals(current.data)) return index;
            current = current.prev;
            index--;
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
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            arr[i] = current.data;
            current = current.next;
        }
        return arr;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<>() {
            private MyNode current = head;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                T val = current.data;
                current = current.next;
                return val;
            }
        };
    }
}
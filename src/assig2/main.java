package assig2;


public class main {
    public static void main(String[] args) {

        // =======================================
        // 🔷 Тестирование MyArrayList
        // =======================================
        MyList<Integer> list = new MyArrayList<>();

        // Добавление элементов
        list.add(10);
        list.add(20);
        list.add(1, 15); // Вставка 15 на позицию 1
        list.set(0, 5);  // Замена первого элемента на 5

        // Вывод всех элементов
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Element " + i + ": " + list.get(i));
        }

        // Удаление элемента на позиции 1
        list.remove(1);
        System.out.println("After removal:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Element " + i + ": " + list.get(i));
        }

        // Проверка существования и индекса
        System.out.println("List contains 20? " + list.exists(20));
        System.out.println("Index of 20: " + list.indexOf(20));



        // =======================================
        // 🔷 Тестирование MyStack (LIFO)
        // =======================================
        MyStack<Integer> stack = new MyStack<>();

        System.out.println("=== Push элементы ===");
        stack.push(10);
        stack.push(20);
        stack.push(30); // Stack: 30 (top), 20, 10
        stack.printStack();

        System.out.println("\n=== Peek верхний элемент ===");
        System.out.println("Top: " + stack.peek()); // 30

        System.out.println("\n=== Pop элементы ===");
        System.out.println("Pop: " + stack.pop()); // 30
        System.out.println("Pop: " + stack.pop()); // 20
        stack.printStack(); // Stack: 10

        System.out.println("\n=== Проверка isEmpty ===");
        System.out.println("Empty? " + stack.isEmpty()); // false

        System.out.println("\n=== Очистка стека ===");
        stack.clear();
        System.out.println("Empty after clear? " + stack.isEmpty()); // true



        // =======================================
        // 🔷 Тестирование MyQueue (FIFO)
        // =======================================
        MyQueue<String> queue = new MyQueue<>();

        System.out.println("=== Enqueue элементы ===");
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C"); // Queue: A (front), B, C (rear)
        queue.printQueue();

        System.out.println("\n=== Peek первый элемент ===");
        System.out.println("Front: " + queue.peek()); // A

        System.out.println("\n=== Dequeue элементы ===");
        System.out.println("Dequeued: " + queue.dequeue()); // A
        System.out.println("Dequeued: " + queue.dequeue()); // B
        queue.printQueue(); // Queue: C

        System.out.println("\n=== Проверка isEmpty ===");
        System.out.println("Empty? " + queue.isEmpty()); // false

        System.out.println("\n=== Очистка очереди ===");
        queue.clear();
        System.out.println("Empty after clear? " + queue.isEmpty()); // true



        // =======================================
        // 🔷 Тестирование MyMinHeap (минимальная куча)
        // =======================================
        MyMinHeap<Integer> heap = new MyMinHeap<>();

        System.out.println("=== Вставка элементов ===");
        heap.insert(25);
        heap.insert(17);
        heap.insert(30);
        heap.insert(10);
        heap.insert(40);
        heap.insert(5); // Минимум должен быть 5
        heap.printHeap();

        System.out.println("\n=== Peek и ExtractMin ===");
        System.out.println("Минимум: " + heap.peek()); // 5
        System.out.println("Извлечён минимум: " + heap.extractMin()); // удаляем 5
        heap.printHeap(); // Обновлённая куча

        System.out.println("\n=== Размер и очистка ===");
        System.out.println("Размер: " + heap.size());
        heap.clear();
        System.out.println("Пусто? " + heap.isEmpty());
    }
}
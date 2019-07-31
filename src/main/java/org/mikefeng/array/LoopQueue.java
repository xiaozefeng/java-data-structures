package org.mikefeng.array;


public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int front, tail;

    private int size;

    public LoopQueue(int capacity) {
        // 因为会有意识的浪费一个空间，所有 capacity + 1
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        // tail 和 front 指向同一个位置时队列为空
        return front == tail;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        //是否满了
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        this.data[this.tail] = e;
        // tail 后移一位
        tail = (tail + 1) / data.length;
        size++;
    }


    @Override
    public E dequeue() {
        // 是否为空
        if (isEmpty()) {
            throw new RuntimeException("Dequeue failed. queue is empty");
        }
        E ret = data[front];
        data[front] = null;
        // front 后移一位
        front = (front + 1) / data.length;
        size--;

        // 是否需缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;

    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new RuntimeException("GetFront failed. queue is empty");
        }
        return data[front % data.length];
    }

    private void resize(int capacity) {
        // new data
        E[] newData = (E[]) new Object[capacity + 1];
        // reassignment
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        // 初始化 front tail
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("front [");
        for (int i = 0; i < size; i++) {
            res.append(data[(i + front) % data.length]);
            if (i == size - 1) {
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
            }
        }
    }
}

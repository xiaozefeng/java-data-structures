package org.mikefeng.array;

/**
 * 自己封装Array
 */
public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.data.length;
    }

    // 尾部添加元素
    public void addLast(E e) {
        add(size, e);
    }

    // 指定位置添加元素
    public void add(int index, E e) {
        if (size == data.length)
            throw new IllegalArgumentException("Add failed. Array is full.");

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Required index >=0 and index <=size.");

        // 将index后的元素后移一位
        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = e;
        size++;
    }

    // get
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed, index is illegal.");

        return data[index];
    }

    // set
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed, index is illegal.");
        data[index] = e;
    }

    // contains
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    // find
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    // remove
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. required index >=0 and index <size");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        size--;
        return ret;
    }


    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    // remove element
    public void removeElement(E e) {
        int index = find(e);
        if (index !=-1)
            remove(index);
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size=%d, capacity=%d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]).append(",");
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }
}


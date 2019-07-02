package org.mikefeng.array;

/**
 * 自己封装Array
 */
public class Array {

    private int[] data;
    private int size;

    public Array(int capacity) {
        this.data = new int[capacity];
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
    public void addLast(int e) {
        add(size, e);
    }

    // 指定位置添加元素
    public void add(int index, int e) {
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
    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed, index is illegal.");

        return data[index];
    }

    // set
    public void set(int index, int e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed, index is illegal.");
        data[index] = e;
    }

    // contains
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (e == data[i]) {
                return true;
            }
        }
        return false;
    }

    // find
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (e == data[i]) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size=%d, capacity=%d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(i).append(",");
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }
}


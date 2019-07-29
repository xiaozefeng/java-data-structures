package org.mikefeng.array;

public class ArrayTest {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(10);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        // 添加两个元素
        arr.add(0, -1);
        arr.add(0, 100);
        System.out.println(arr);

        // 删除3个元素
        arr.removeElement(2);
        arr.removeElement(4);
        arr.removeFirst();
        System.out.println(arr);
    }
}

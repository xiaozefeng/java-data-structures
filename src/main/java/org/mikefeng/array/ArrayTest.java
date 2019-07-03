package org.mikefeng.array;

public class ArrayTest {
    public static void main(String[] args) {
        Array<Integer> arr= new Array<>(100);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        for (int i = 0; i < arr.getSize(); i++) {
            System.out.print(String.format("%d, ", arr.get(i)));
        }

        System.out.println();
        arr.add(1 , 100);
        System.out.println(arr);

        arr.remove(1);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);
    }
}

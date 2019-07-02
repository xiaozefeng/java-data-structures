package org.mikefeng.array;

public class ArrayTest {
    public static void main(String[] args) {
        Array arr= new Array();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        for (int i = 0; i < arr.getSize(); i++) {
            System.out.println(arr.get(i));
        }
    }
}

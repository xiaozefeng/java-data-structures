package org.mikefeng.array;

public interface Stack<E> {

    // 入栈一个元素
    void push(E e);

    // 出栈一个元素
    E pop();

    // 查询是否是空栈
    boolean isEmpty();

    // 查询栈的长度
    int getSize();

    // 查看栈顶的元素
    E peek();
}

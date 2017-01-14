package com.company.homework3;

import java.util.EmptyStackException;
import java.util.Iterator;

public class ArrayStack<T> implements Stack<T> {

    private static final int INITIAL_SIZE = 1;
    private Object[] stack;
    private int sizeStack;

    public ArrayStack() {
        stack = new Object[INITIAL_SIZE];
        sizeStack = 0;
    }

    private void ChangeCapacity(int size)
    {
        Object[] newStack = new Object[size];
        System.arraycopy(stack, 0, newStack, 0, sizeStack);
        stack = newStack;
    }

    @Override
    public T push(T item) {
        if (sizeStack == stack.length) {
            ChangeCapacity(2 * sizeStack);
        }
        stack[sizeStack++] = item;
        return item;
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        if (sizeStack < stack.length / 4) {
            ChangeCapacity(stack.length / 2);
        }
        return (T) stack[--sizeStack];
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return (T) stack[sizeStack - 1];
    }

    @Override
    public boolean isEmpty() {
        return sizeStack == 0;
    }

    @Override
    public long getSize() {
        return sizeStack;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    class StackIterator implements Iterator<T> {
        private int num = 0;

        public T next() {
            return (T) stack[num++];
        }

        public boolean hasNext() {
            return num < sizeStack;
        }
    }
}

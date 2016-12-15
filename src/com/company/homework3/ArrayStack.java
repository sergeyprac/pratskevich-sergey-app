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

    @Override
    public T push(T item) {
        if (sizeStack == stack.length) {
            Object[] newStack = new Object[2 * sizeStack];
            System.arraycopy(stack, 0, newStack, 0, sizeStack);
            stack = newStack;
        }
        stack[sizeStack++] = item;
        return item;
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        if (sizeStack < stack.length / 4) {
            Object[] newStack = new Object[stack.length / 2];
            System.arraycopy(stack, 0, newStack, 0, sizeStack);
            stack = newStack;
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
        return (sizeStack == 0) ? true : false;
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

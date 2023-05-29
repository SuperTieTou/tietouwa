package com.tietouwa.algorithm.listoperation;

public class StackAndQueueByArray<T> {

    private int firstIndex = 0;
    private int lastIndex = 0;

    private Object[] arr;

    private boolean isRing = false;

    public StackAndQueueByArray(int size) {
        arr = new Object[size];
        isRing = size == 0;
    }

    public void add(T t) {
        checkAdd();
        arr[firstIndex] = t;
        firstIndex++;
        if (firstIndex >= arr.length) {
            firstIndex = 0;
            isRing = !isRing;
        }
    }

    public void addLast(T t) {
        checkAdd();
        lastIndex--;
        if (lastIndex < 0) {
            lastIndex = arr.length - 1;
            isRing = !isRing;
        }
        arr[lastIndex] = t;
    }


    public T get() {
        checkRem();
        firstIndex--;
        if (firstIndex < 0) {
            firstIndex = arr.length - 1;
            isRing = !isRing;
        }
        return getElement(firstIndex);
    }

    public T getLast() {
        checkRem();
        T element = getElement(firstIndex);
        lastIndex++;
        if (lastIndex >= arr.length) {
            lastIndex = 0;
            isRing = !isRing;
        }
        return element;
    }

    @SuppressWarnings("unchecked")
    private T getElement(int index) {
        Object result = arr[index];
        arr[index] = null;
        return (T) result;
    }


    private void checkAdd() {
        if (isRing && firstIndex == lastIndex) {
            throw new IndexOutOfBoundsException("满了");
        }
    }

    private void checkRem() {
        if (!isRing && firstIndex == lastIndex) {
            throw new IndexOutOfBoundsException("没了");
        }
    }

    public static void main(String[] args) {
        StackAndQueueByArray<String> arr = new StackAndQueueByArray<>(5);
        arr.add("1");
        arr.addLast("5");
        arr.add("2");
        arr.addLast("4");
        arr.add("3");

        System.out.println();
    }
}

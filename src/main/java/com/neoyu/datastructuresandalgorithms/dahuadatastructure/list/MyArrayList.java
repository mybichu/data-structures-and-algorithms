package com.neoyu.datastructuresandalgorithms.dahuadatastructure.list;

import lombok.extern.slf4j.Slf4j;

/**
 * 列表的顺序存储结构
 *
 * @Author: neoyu
 * @Date: 2022/10/31 11:10
 */
@Slf4j
public class MyArrayList<T> extends MyAbstractList<T> {

    private static final int DEFAULT_INIT_CAPACITY = 10;

    private static final int MAX_CAPACITY = 100000000;

    private Object[] elemArray;

    public MyArrayList() {
        elemArray = new Object[DEFAULT_INIT_CAPACITY];
    }

    public MyArrayList(int initSize) {
        if (initSize <= 0) {
            throw new RuntimeException("initSize must larger than 0");
        }
        elemArray = new Object[initSize];
    }

    @Override
    public void clear() {
        int currentSize = size();
        for (int i = 0; i < currentSize; i++) {
            elemArray[i] = null;
        }
        this.size = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size()) {
            return null;
        }
        return (T) this.elemArray[index];

    }

    @Override
    public void add(T elem) {
        ensureCapacityInternal(size() + 1);
        this.elemArray[size()] = elem;
        this.size = this.size + 1;
    }

    public void add(T elem, int index) {
        if (index < 0 || index >= size()) {
            throw new RuntimeException("index error");
        }
        ensureCapacityInternal(size() + 1);
        // 将index以及后面的元素，往后移动一格
        for (int i = 0; i < this.size - index; i++) {
            this.elemArray[this.size - i] = this.elemArray[this.size - i - 1];
        }
        this.elemArray[index] = elem;
        this.size = this.size + 1;
    }

    @Override
    public int indexOf(T elem) {
        if (elem == null) {
            return -1;
        }
        // 遍历查找
        for (int i = 0; i < this.size; i++) {
            if (elem.equals(this.elemArray[i])) {
                return i;
            }
        }
        return -1;
    }

    public int getCapacity() {
        return this.elemArray.length;
    }

    private void ensureCapacityInternal(int needCapacity) {
        int currentCapacity = elemArray.length;
        // 如果当前容量大于所需容量，直接可以使用
        if (currentCapacity > needCapacity) {
            return;
        }
        // 如果当前容量已经到了最大容量，就无法扩容了
        if (currentCapacity >= MAX_CAPACITY) {
            throw new RuntimeException("当前容量已经达到上限,无法再增加");
        }
        // 把当前容量扩容1.5倍之后，如果小于最大容量，就使用扩容后的；如果扩容后超过最大容量，就设置成最大容量
        int featureCapacity = (int) Math.round(currentCapacity * 1.5);
        Object[] newElemArray;
        if (featureCapacity <= MAX_CAPACITY) {
            newElemArray = new Object[featureCapacity];
        } else {
            newElemArray = new Object[MAX_CAPACITY];
        }
        // 将老数组的转移到新数组
        System.arraycopy(this.elemArray, 0, newElemArray, 0, this.elemArray.length);
        // 更换底层数组
        this.elemArray = newElemArray;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            stringBuilder.append(i).append(" : ").append(this.elemArray[i]).append("\n");
        }
        return stringBuilder.toString();
    }
}

package com.neoyu.datastructuresandalgorithms.dahuadatastructure.list;

/**
 * 抽象列表
 *
 * @Author: neoyu
 * @Date: 2022/10/31 11:05
 */

public abstract class MyAbstractList<T> implements MyList<T> {

    protected int size = 0;

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }
}

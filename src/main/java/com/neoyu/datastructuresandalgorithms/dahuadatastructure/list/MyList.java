package com.neoyu.datastructuresandalgorithms.dahuadatastructure.list;

/**
 * 列表的ADT
 *
 * @Author: neoyu
 * @Date: 2022/10/31 10:54
 */

public interface MyList<T> {

    /**
     * 列表是否为空
     *
     * @return 列表为空返回true；否则返回false
     */
    boolean isEmpty();

    /**
     * 清空列表
     */
    void clear();

    /**
     * 获取索引对应的元素
     *
     * @param index 索引
     * @return 当index在索引范围内，返回对应的元素；当index不在[0，size - 1]时，返回null
     */
    T get(int index);

    /**
     * 向列表中添加元素
     *
     * @param elem 新元素
     */
    void add(T elem);

    /**
     * 向列表的index索引位置添加元素
     *
     * @param elem 新元素
     * @param index 待插入的索引位置。当index<0||index>=size(),抛出异常
     */
    void add(T elem, int index);

    /**
     * 获取元素在列表中对应的索引
     *
     * @param elem 元素
     * @return 当元素在列表中时，返回对应的索引；当元素不在列表时，返回-1
     */
    int indexOf(T elem);

    /**
     * 获取列表中元素个数
     *
     * @return 当前列表中元素的个数
     */
    int size();

}

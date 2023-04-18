package com.mj;

import java.util.Iterator;

public class ArrayList {
	/**
	 * 元素的数量
	 */
	private int size;
	/**
	 * 所有元素
	 */
	private int[] elements;
	
	private static final int DEFAULT_CAPACITY = 10;
	
	private static final int ELEMENT_NOT_FOUND = -1;
	
	public ArrayList(int capacity) {
		capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
		elements = new int[capacity];
	}
	
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * 清除所有元素
	 */
	public void clear() {
		
	}
	
	/**
	 * 元素的数量
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * 是否包含某个元素
	 * @param element
	 * @return
	 */
	public boolean contains(int element) {
		return false;
	}
	
	/**
	 * 添加元素到尾部
	 * @param element
	 */
	public void add(int element) {
		
	}
	
	/** 
	 * 获取index位置的元素
	 * @param index
	 * @return
	 */
	public int get(int index) {
		if (index < 0 || index >= size) { 
			throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
		}
		return elements[index];
	}
	
	/** 
	 * 设置index位置的元素
	 * @param index
	 * @param element
	 * @return 原来的元素
	 */
	public int set(int index, int element) {
		if (index < 0 || index >= size) { 
			throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
		}
		int old = elements[index];
		elements[index] = element;
		return old;
	}
	
	/** 
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	public void add(int index, int element) {
		
	}
	
	/**
	 * 删除index位置的元素
	 * @param index
	 * @return
	 */
	public int remove(int index) {
		return 0;
	}
	
	/**
	 * 查看元素的索引
	 * @param element
	 * @return
	 */
	public int indexOf(int element) {
		for (int i = 0; i < size; i++) {
			if (element == elements[i]) return i; 
		}
		return ELEMENT_NOT_FOUND;
	}
}


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
	
	private static final int DEFAULT_CAPACITY = 2;
	
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
		size = 0;
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
		add(size, element);
	}
	
	/** 
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	public void add(int index, int element) {
		rangeCheckForAdd(index);
		ensureCapacity(size + 1);
		for (int i = size - 1; i >= index; i--) {
			elements[i + 1] = elements[i];
		}
		elements[index] = element;
		size++;
	}
	
	/**
	 * 删除index位置的元素
	 * @param index
	 * @return
	 */
	public int remove(int index) {
		rangeCheck(index);
		int old = elements[index];
		for (int i = index; i <= size - 1; i++) {
			elements[i] = elements[i + 1]; 
		}
		size--;
		old = elements[index];
		return old;
	}
	
	/** 
	 * 获取index位置的元素
	 * @param index
	 * @return
	 */
	public int get(int index) {
		rangeCheck(index);
		return elements[index];
	}
	
	/** 
	 * 设置index位置的元素
	 * @param index
	 * @param element
	 * @return 原来的元素
	 */
	public int set(int index, int element) {
		rangeCheck(index);
		int old = elements[index];
		elements[index] = element;
		return old;
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
	
	/**
	 * 确保动态数组容量充足
	 */
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		int[] newElements = new int[newCapacity];
		for(int i = 0; i < size; i++) {
			newElements[i] = elements[i]; 
		}
		elements = newElements;
		System.out.println("原始容量:" + oldCapacity + " 扩容为: " + newCapacity);
	}
	
	/**
	 * 动态数组越界
	 */
	private void outOfBound(int index) {
		throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
	}
	
	/**
	 * 范围检查
	 * @param index
	 */
	private void rangeCheck(int index) {
		if (index < 0 || index >= size) { 
			outOfBound(index);
		}
	}
	
	/**
	 * 添加时范围检查
	 * @param index
	 */
	private void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) { 
			outOfBound(index);
		}
	}
	
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size = ").append(size).append(", [");
		for(int i = 0; i < size; i++) {
			if(i != 0) string.append(", ");
			string.append(elements[i]);
		}
		
		string .append("]");
		return string.toString();
	}
}


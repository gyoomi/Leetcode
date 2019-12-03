/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.MinStack;

import java.util.Stack;

/**
 * The description of class
 *
 * @author Leon
 * @date 2019-12-03 8:52
 */
public class MinStack {

	/**
	 * 数据栈
	 */
	private Stack<Integer> data;

	/**
	 * 辅助栈
	 */
	private Stack<Integer> helper;

	public MinStack() {
		data = new Stack<>();
		helper = new Stack<>();
	}

	// 思路 1：数据栈和辅助栈在任何时候都同步

	public void push(int x) {
		// 数据栈和辅助栈一定同时增加元素
		data.add(x);
		if (helper.isEmpty() || helper.peek() >= x) {
			helper.add(x);
		} else {
			helper.add(helper.peek());
		}
	}

	public void pop() {
		if (!data.isEmpty()) {
			helper.pop();
			data.pop();
		}
	}

	public int top() {
		return data.peek();
	}

	public int getMin() {
		return helper.peek();
	}
}

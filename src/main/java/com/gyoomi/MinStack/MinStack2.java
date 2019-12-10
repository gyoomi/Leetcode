/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.MinStack;

import java.util.Stack;

/**
 * 最小栈
 *
 * @author Leon
 * @date 2019-12-03 8:52
 */
public class MinStack2 {

	/**
	 * 数据栈
	 */
	private Stack<Integer> data;

	/**
	 * 辅助栈
	 */
	private Stack<Integer> helper;

	public MinStack2() {
		data = new Stack<>();
		helper = new Stack<>();
	}

	// 思路 ：数据栈和辅助栈不同步
	// 关键 1：辅助栈的元素空的时候，必须放入新进来的数
	// 关键 2：新来的数小于或者等于辅助栈栈顶元素的时候，才放入（特别注意这里等于要考虑进去）
	// 关键 3：出栈的时候，辅助栈的栈顶元素等于数据栈的栈顶元素，才出栈，即"出栈保持同步"就可以了

	public void push(int x) {
		// 数据栈一定增加，辅助栈在必要的时候才增加
		data.add(x);
		// 关键1 、 关键2
		if (helper.isEmpty() || helper.peek() >= x) {
			helper.add(x);
		}
	}

	public void pop() {
		// 关键 3：data 一定得 pop()。辅助栈看情况 pop()
		if (!data.isEmpty()) {
			// 注意：声明成 int 类型，这里完成了自动拆箱，从 Integer 转成了 int，因此下面的比较可以使用 "==" 运算符
			// 如果把 top 变量声明成 Integer 类型，下面的比较就得使用 equals 方法

			int top = data.pop();
			if (top == helper.peek()) {
				helper.pop();
			}
		}
	}

	public int top() {
		return data.peek();
	}

	public int getMin() {
		return helper.peek();
	}
}

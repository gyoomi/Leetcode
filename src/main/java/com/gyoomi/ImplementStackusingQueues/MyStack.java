/**
 * Copyright © 2019, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.ImplementStackusingQueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The description of class
 *
 * @author Leon
 * @date 2019-12-20 17:11
 */
public class MyStack {

	/**
	 * 队列: 数据队列
	 */
	private Queue<Integer> queue;

	/**
	 * 直接保存栈顶元素
	 */
	private int top;


	public MyStack() {
		queue = new LinkedList();
	}

	public void push(int x) {
		// 1. 更新栈顶元素
		top = x;
		// 2. 将栈顶元素将入到队列尾部
		queue.offer(top);
	}

	public int pop() {
		// 使用一个临时队列来更新
		Queue<Integer> temp = new LinkedList();
		// 因为要返回弹出元素，所以事先保存下来
		int oldTop = top;
		int size = queue.size();
		// 循环更新每个元素，执行到最后时刻栈顶元素也就更新了
		for (int i = 0; i < size - 1; i++) {
			top = ((int) queue.remove());
			temp.offer(top);
		}

		// 更新队列（栈）
		queue = temp;
		return oldTop;
	}

	public int top() {
		return top;
	}

	public boolean empty() {
		return queue.size() == 0;
	}

}

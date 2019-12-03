# 155. Min Stack(最小栈)

设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

>- push(x) -- 将元素 x 推入栈中。
>- pop() -- 删除栈顶的元素。
>- top() -- 获取栈顶元素。
>- getMin() -- 检索栈中的最小元素。

示例:
```text
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
```

解法1：辅助栈和数据栈同步

思路：

“以空间换时间”，使用辅助栈是常见的做法。

特点：编码简单，不用考虑一些边界情况，就有一点不好：辅助栈可能会存一些“不必要”的元素。

代码实现

```java
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

```

复杂度分析:

- 时间复杂度：O(1)，“出栈”、“入栈”、“查看栈顶元素”的操作不论数据规模多大，都只是有限个步骤，因此时间复杂度是：O(1)。
- 空间复杂度：O(N)，这里 N 是读出的数据的个数

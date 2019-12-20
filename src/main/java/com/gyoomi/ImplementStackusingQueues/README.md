# 225. 用队列实现栈

使用队列实现栈的下列操作：

- push(x) -- 元素 x 入栈
- pop() -- 移除栈顶元素
- top() -- 获取栈顶元素
- empty() -- 返回栈是否为空

注意:

- 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 isEmpty 这些操作是合法的。
- 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
- 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。


方法1： 双队列（两个队列，压入 O(1)， 弹出 O(n)）

代码实现

```java
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

```


































## 146. LRU缓存机制

运用你所掌握的数据结构，设计和实现一个  `LRU (最近最少使用) 缓存机制`。它应该支持以下操作： 获取数据 `get` 和 写入数据 `put `。

获取数据 `get(key)` - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 `put(key, value)` - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。

**进阶**:

你是否可以在 O(1) 时间复杂度内完成这两种操作？

**方法 1：有序字典**

**想法**

题目要求实现 `LRU` 缓存机制，需要在 `O(1)` 时间内完成如下操作：

- 获取键 / 检查键是否存在
- 设置键
- 删除最先插入的键

前两个操作可以用标准的哈希表在 `O(1)` 时间内完成。

>有一种叫做有序字典的数据结构，综合了哈希表和链表，在 Python 中为 OrderedDict，在 Java 中为 LinkedHashMap。

下面用这个数据结构来实现。

**代码**

```java

public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

```

**复杂度分析**

- 时间复杂度：对于 `put `和 `get` 操作复杂度是 `O(1)`，因为有序字典中的所有操作：`get/in/set/move_to_end/popitem（get/containsKey/put/remove）`都可以在常数时间内完成。
- 空间复杂度：`O(capacity)`，因为空间只用于有序字典存储最多 `capacity + 1` 个元素。















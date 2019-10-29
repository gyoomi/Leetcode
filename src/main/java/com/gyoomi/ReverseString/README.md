## 344. 反转字符串 Reverse String

编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。

不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。

示例1：

```text
输入：["h","e","l","l","o"]
输出：["o","l","l","e","h"]
```

示例2：

```text
输入：["H","a","n","n","a","h"]
输出：["h","a","n","n","a","H"]
```

**方法1：双指针**

**思路**

翻转，在O(1)的时空下，我们可以采取对称的方法，对数组中的元素进行颠倒。这样左右颠倒后的整个数组其实就已经实现翻转。

**代码实现**

```java
public class Solution {

    public void reverseString(char[] s) {
        if (s.length <= 1) {
            return;
        }

        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
```
























































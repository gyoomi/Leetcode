## 345. 反转字符串中的元音字母

编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

示例 1:

```text
输入: "hello"
输出: "holle"
```

示例 2:

```text
输入: "leetcode"
输出: "leotcede"
```

说明:
元音字母不包含字母"y"。

**方法1：双指针**

**实现代码**

```java
public class Solution {

    public String reverseVowels(String s) {
        // 针对小于2个字符的特殊情况，直接返回
        if (s.length() <= 1) {
            return s;
        }

        // 元音列表
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            // 左边：直到找到一个元音终止
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }
            // 右边：直到找到一个元音终止
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }
            // 这里有四种情况
            // 1. left这边没有找到元音，right这边也没有找到元音。程序直接返回
            // 2. left这边找到元音，但是right这边也没有找到元音。但是不满足 left < right 程序直接返回
            // 3. left这边没有找到元音，但是right这边找到元音。但是不满足 left < right 程序直接返回
            // 4. 左右两边都找到元音，且满足left < right。进行字符交换。然后进入下一轮循环...重复上述动作
            if (left < right) {
                char leftCharVal = chars[left];
                chars[left] = chars[right];
                chars[right] = leftCharVal;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
```




















































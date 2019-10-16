## 58. 最后一个单词的长度

给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

如果不存在最后一个单词，请返回 0 。

说明：一个单词是指由字母组成，但不包含任何空格的字符串。

示例：

```text
输入: "Hello World"
输出: 5
```

**方法1：**

**实现代码**

```java
public class Solution {

    public int lengthOfLastWord(String s) {
        // 考虑特殊情况
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        
        // 正则切割，然后进行判断
        String[] words = s.split(" +");
        return words[words.length - 1].length();
    }

}
```
















































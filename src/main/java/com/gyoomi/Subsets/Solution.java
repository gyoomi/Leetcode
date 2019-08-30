/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.Subsets;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/8/30 15:26
 */
public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {

            ListIterator<List<Integer>> listListIterator = result.listIterator();

            while (listListIterator.hasNext()) {
                List<Integer> list = listListIterator.next();
                List<Integer> tempList = new ArrayList<>(list);
                tempList.add(num);
                listListIterator.add(tempList);
            }
        }
        return result;
    }
}

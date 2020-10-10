package arrayAndString;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _03MergeArray {

    /**
     * 合并区间
     * <p>
     * 给出一个区间的集合，请合并所有重叠的区间。
     * <p>
     * <p>
     * 地址:https://leetcode-cn.com/leetbook/read/array-and-string/c5tv3/
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            throw new NullPointerException();
        }
        //参考官方题解

        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0], right = intervals[i][1];
            if (list.size() == 0 || left > list.get(list.size() - 1)[1]){
                list.add(new int[]{intervals[i][0],intervals[i][1]});
            } else if (left <= list.get(list.size() - 1)[1]) {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1],right);
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    @Test
    public void test() {
//        int[][] ints = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] ints = {{1, 4}, {0, 4}};
//        int[][] ints = {{1, 4}, {0, 2}, {3, 5}};
        int[][] ints = {{2, 3}, {5, 5}, {2, 2}, {3, 4},{3,4}};

        int[][] merge = new _03MergeArray().merge(ints);
        System.out.println(merge);
    }


}

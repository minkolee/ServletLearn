
package thinkinginjava.learn.chapter04;

import java.util.Arrays;

public class Ex10 {

    public static void findVampireNumber(int number) {

        //算法, 用长度为10的数组, 记录一个数字四个数字出现的位数
        //索引0-9,用于存放数字的出现次数的数组
        int[] a = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        //按次序存放4个数字
        int[] b = new int[4];

        //第一步, 将四位数分解放入数组中
        while (number != 0) {
            int i = number % 10;
            a[i]++;

            number = number / 10;
        }
        System.out.println(Arrays.toString(a));


        //第二步, 遍历数组, 如果某个索引不是0, 数组b里放入这个索引, 如果索引大于1, 就重复放, 反正一共四个数字
        int bIndex = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                while (a[i] != 0) {
                    b[bIndex++] = i;
                    a[i]--;
                }
            }
        }

        System.out.println(Arrays.toString(b));

        //第三步, 计算12种组合


    }

    public static void main(String[] args) {
        findVampireNumber(3400);
    }
}

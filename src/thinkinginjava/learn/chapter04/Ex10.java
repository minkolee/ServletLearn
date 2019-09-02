
package thinkinginjava.learn.chapter04;

import java.util.Arrays;

public class Ex10 {

    public static boolean isVampireNumber(int number) {
        boolean result = false;

        int raw = number;
        //算法, 用长度为10的数组, 记录一个数字四个数字出现的位数
        //索引0-9,用于存放数字的出现次数的数组
        int[] a = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        //按次序存放4个数字
        int[] b = new int[4];

        //第一步, 将四位数分解成四个数字放入数组中
        while (number != 0) {
            int i = number % 10;
            a[i]++;
            number = number / 10;
        }
//        System.out.println(Arrays.toString(a));


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
//        System.out.println(Arrays.toString(b));

        //第三步, 计算12种组合
        //这里使用有限状态机的思想, 全排列数组的四个索引  0 1 2 3

        int[][] status = new int[12][4];
        //第一组 01 和 23 分一组
        status[0] = new int[]{0, 1, 2, 3};
        status[1] = new int[]{0, 1, 3, 2};
        status[2] = new int[]{1, 0, 2, 3};
        status[3] = new int[]{1, 0, 3, 2};

        //第二组 02 和 13 分一组
        status[4] = new int[]{0, 2, 1, 3};
        status[5] = new int[]{0, 2, 3, 1};
        status[6] = new int[]{2, 0, 1, 3};
        status[7] = new int[]{2, 0, 3, 1};

        //第三组 03 和 12 分一组
        status[8] = new int[]{0, 3, 1, 2};
        status[9] = new int[]{0, 3, 2, 1};
        status[10] = new int[]{3, 0, 1, 2};
        status[11] = new int[]{3, 0, 2, 1};

        //第四步, 按照状态机循环一个一个计算两位数相乘
        for (int i = 0; i < status.length; i++) {
            int mult1 = b[status[i][0]] * 10 + b[status[i][1]];
            int mult2 = b[status[i][2]] * 10 + b[status[i][3]];

            if (mult1 * mult2 == raw) {
                System.out.println("发现吸血鬼数字: " + raw +"="+mult1+" * "+mult2);
                result = true;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 1000; i <= 9999; i++) {
            isVampireNumber(i);

        }
    }
}

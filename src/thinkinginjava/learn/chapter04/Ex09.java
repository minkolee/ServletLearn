package thinkinginjava.learn.chapter04;

public class Ex09 {
    //这个如果要探测素数, 运行级别是平方级别的, 太可怕了

    public static void getFib(int n) {
        int a = 1, b = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                System.out.print(a + " ");
                continue;
            }
            if (i == 2) {
                System.out.print(b+" ");
                continue;
            }

            //从3开始, 开始计算
            int temp = a + b;
            a = b;
            b = temp;
            System.out.print(b + " ");
        }
    }

    public static void main(String[] args) {
        getFib(10);

    }
}

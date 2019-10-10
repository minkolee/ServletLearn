package designpatterns.interpreter;

import java.util.StringTokenizer;

public class Context {

    //使用了内置的StringTokenizer库, 直接将字符串分割成token, 操作这个tokenizer对象即可
    private StringTokenizer tokenizer;

    //当前的token
    private String currentToken;


    //构造器使用StringTokenizer生成token
    public Context(String sourceCode) {
        tokenizer = new StringTokenizer(sourceCode);
        nextToken();
    }

    //这个是返回下一个token, 同时将内容设置当前token, 可以看成是往前移动了一步
    public String nextToken() {
        if (tokenizer.hasMoreTokens()) {
            currentToken = tokenizer.nextToken();
        } else {
            currentToken = null;
        }
        return currentToken;
    }

    //这个是获取当前token, 相比上一个方法, 不会向前移动
    public String currentToken() {
        return currentToken;
    }

    //这个方法用来跳过一个token ,如果跳过的不是指定的token 就要抛异常. 当前token是要跳过的token,就向前一步
    public void skipToken(String token) throws ParseException {
        if (!token.equals(currentToken)) {
            throw new ParseException("Warning:" + token + " is expected, but" + currentToken + "is found");
        }
        nextToken();
    }

    public int currentNumber() throws ParseException {
        int number = 0;
        try {
            number = Integer.parseInt(currentToken);
        } catch (NumberFormatException e) {
            throw new ParseException("Warning: 数字解析错误" + currentToken);
        }
        return number;
    }

}

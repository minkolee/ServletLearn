package designpatterns.mediator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {


    //这是为了实现界面所需要的各个组件
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    public LoginFrame(String title) {

        //绘制框体和创建组件
        super(title);
        setBackground(Color.lightGray);
        setLayout(new GridLayout(4, 2));
        createColleagues();

        //添加所有组件
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username: "));
        add(textUser);
        add(new Label("Password: "));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);

        //设置初始状态
        colleagueChanged();

        pack();
        show();
    }

    @Override
    public void createColleagues() {
        CheckboxGroup g = new CheckboxGroup();
        //这个猜着就能看懂, 一组两个checkbox, 一个默认选中 , 一个默认不选
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);

        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        //设置密码框的覆盖字符
        textPass.setEchoChar('*');

        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        //设置仲裁者为当前对象
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        //添加事件监听器, 这个应该是套路
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    @Override
    public void colleagueChanged() {
        //如果客户被选中, 禁止两个文本框, OK按钮可以选中
        if (checkGuest.getState()) {
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        } else {
            textUser.setColleagueEnabled(true);
            //这是抽取出来的方法, 用于改变状态
            userpassChanged();
        }
    }

    private void userpassChanged() {
        buttonOk.setEnabled(false);
        //如果用户名中输入了字符就让密码框可以使用. 密码框可用的时候, 如果有字符就让OK键可以用, 否则OK键无法使用
        if (textUser.getText().length() > 0) {
            textPass.setColleagueEnabled(true);
            if (textPass.getText().length() >=4  && textUser.getText().length()>=4) {
                buttonOk.setColleagueEnabled(true);
            } else {
                buttonOk.setColleagueEnabled(false);

            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);

    }
}

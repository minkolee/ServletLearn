package designpatterns.state;

public class DayState implements State {

    private DayState() {

    }

    private static DayState singleton = new DayState();

    public static State getInstance() {
        return singleton;
    }


    @Override
    public void doClock(Context context, int hour) {
        //在非上班时间, 将context对象中的金库对象切换成黑夜的金库
        if (hour <= 9 || hour >= 17) {
            context.changeState(NightState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("白天的金库运行中");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("按下警铃:白天");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("正常通话:白天");
    }

    @Override
    public String toString() {
        return "[白天的金库]";
    }
}

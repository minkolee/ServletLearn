package designpatterns.state;

public class NightState implements State {

    private NightState() {

    }

    private static NightState singleton = new NightState();

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        //在上班时间, 切换成白天的金库
        if (hour >= 9 && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("夜晚的金库运行中");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("按下警铃:夜晚");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("正常通话:夜晚");
    }

    @Override
    public String toString() {
        return "[夜晚的金库]";
    }
}

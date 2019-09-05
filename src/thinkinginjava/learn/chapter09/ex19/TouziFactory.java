package thinkinginjava.learn.chapter09.ex19;

public class TouziFactory implements GameFactory {

    @Override
    public Game getGame() {
        return new Touzi();
    }
}

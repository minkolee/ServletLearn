package thinkinginjava.learn.chapter09.ex19;

public class CoinFactory implements GameFactory {

    @Override
    public Game getGame() {
        return new Coin();
    }
}

package thinkinginjava.learn.chapter09.ex19;

public class Play {

    public static void playGame(GameFactory gameFactory) {
        Game game = gameFactory.getGame();
        game.play();
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            playGame(new CoinFactory());
            playGame(new TouziFactory());
        }


    }

}

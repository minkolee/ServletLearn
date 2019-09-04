package thinkinginjava.learn.chapter08;

public class Covariant {
}

class Grain {

}

class Wheat extends Grain {

}


class Mill {
    Grain getGrain() {
        return new Grain();
    }

}

class WheatMill extends Mill {
    @Override
    Wheat getGrain() {
        return new Wheat();
    }

}

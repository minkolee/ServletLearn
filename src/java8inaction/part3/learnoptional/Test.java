package java8inaction.part3.learnoptional;

import java.util.Optional;

public class Test {

    public static void main(String[] args) {
        Insurance insurance = new Insurance("saner");

        Car car = new Car();

        car.setInsurance(Optional.of(insurance));

        Optional<Car> carOptional = Optional.of(car);

        Optional<String> carToString = carOptional.flatMap(s -> s.getInsurance()).map(x -> x.getName());

        System.out.println(carToString.get());

        Optional<String> test = Optional.of("fdskjlfjlkas");

        test.ifPresent(s -> System.out.println(s));

        String result = test.get();
        System.out.println(result);
    }
}

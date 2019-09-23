package thinkinginjava.learn.chapter20;

import javax.persistence.SecondaryTable;

public class Testable {

    public void execute() {
        System.out.println("Executing....");

    }

    @Test(id = 1, description = "first")
    void testExecute() {

        execute();
    }


}

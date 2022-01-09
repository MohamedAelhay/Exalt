package question.second;

import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {
        Phaser phaser = new Phaser();
        phaser.register();

        SecondQuestionCode secondQuestionCode = new SecondQuestionCode();

        SecondQuestionThread threadOne = new SecondQuestionThread("Test", 1, secondQuestionCode, phaser, "First");
        SecondQuestionThread threadTwo = new SecondQuestionThread("Test", 1, secondQuestionCode, phaser, "Second");
        SecondQuestionThread threadTree = new SecondQuestionThread("Test", 2, secondQuestionCode, phaser, "Third");

        threadOne.start();
        threadTwo.start();
        threadTree.start();

        phaser.arriveAndAwaitAdvance();

        try
        {
            System.out.println("Main Thread a SLEEP");
            Thread.sleep(1000);
            System.out.println("Main Thread a Awake");
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        secondQuestionCode.data.get("Test").forEach(System.out::println);
    }
}

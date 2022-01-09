package question.second;

import java.time.Instant;
import java.util.concurrent.Phaser;

public class SecondQuestionThread extends Thread {
    private SecondQuestionCode secondQuestionCode;

    private int i;
    private String key;

    private Phaser phaser;

    private String threadName;

    SecondQuestionThread(String key, int i, SecondQuestionCode secondQuestionCode, Phaser phaser, String name) {
        this.i = i;
        this.key = key;
        this.secondQuestionCode = secondQuestionCode;
        this.phaser = phaser;
        phaser.register();
        this.threadName = name;
    }

    @Override
    public void run() {
        System.out.println("[ " + getThreadName() +" ] created, blocked by the phaser");
        phaser.arriveAndAwaitAdvance();
        System.out.println("[ " + getThreadName() +" ] starts at: " + Instant.now() );
        secondQuestionCode.setValue(key, i);
    }

    public String getThreadName() {
        return threadName;
    }
}

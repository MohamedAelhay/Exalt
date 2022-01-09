package question.second;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class SecondQuestionCode {

    /**
     * Adding Volatile key word to store data in the main memory
     * Using Synchronized to make only one thread to access the Method at a time while blocking access to this method from other threads
     */
    volatile Map<String, List<Integer>> data = new HashMap<>();

    public synchronized void setValue(String key, int i) {
        List<Integer> values = data.computeIfAbsent(key, k -> new ArrayList<>());

        data.get(key).add(i);
    }
}

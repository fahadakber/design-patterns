package creational;

import com.fahad.creational.singleton.ClassBasedSingleton;
import com.fahad.creational.singleton.EnumSingleton;
import org.junit.jupiter.api.Test;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingletonUnitTest {
    /**
     * Size of the thread pools used.
     */
    private static final int POOL_SIZE = 1_000;

    /**
     * Number of tasks to submit.
     */
    private static final int TASKS_TO_SUBMIT = 1_000_000;

    /**
     * Tests the thread-safety of {@link EnumSingleton}.
     */
    @Test
    public void givenEnumSingleton_whenMultithreadInstancesEquals_thenTrue() {
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
        Set<EnumSingleton> resultSet = Collections.synchronizedSet(new HashSet<>());

        // Submits the instantiation tasks.
        for (int i = 0; i < TASKS_TO_SUBMIT; i++) {
            executor.submit(() -> resultSet.add(EnumSingleton.INSTANCE));
        }

        // Since the instance of the object we inserted into the set is always
        // the same, the size should be one.
        assertEquals(1, resultSet.size());
    }


    /**
     * Tests the thread-safety of {@link ClassBasedSingleton}.
     */
    @Test
    public void givenClassBasedSingleton_whenMultithreadInstancesEquals_thenTrue() {
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
        Set<ClassBasedSingleton> resultSet = Collections.synchronizedSet(new HashSet<>());

        // Submits the instantiation tasks.
        for (int i = 0; i < TASKS_TO_SUBMIT; i++) {
            executor.submit(() -> resultSet.add(ClassBasedSingleton.getInstance()));
        }

        // Since the instance of the object we inserted into the set is always
        // the same, the size should be one.
        assertEquals(1, resultSet.size());
    }

}

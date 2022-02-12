import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

class MainTest {

    @Test
    public void shouldGenerateThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("my Thread");
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

    }

    @Test
    public void shouldGenerateThreadLambda() {
        new Thread(() -> {
            System.out.println("my Thread");
            System.out.println(Thread.currentThread().getName());
        }).start();
    }

    @Test
    public void shouldGenerateThreadLambdaVar() {
        Runnable r = () -> {
            System.out.println("my thread");
            System.out.println(Thread.currentThread().getName());
        };
        new Thread(r).start();
    }


    @Test
    public void shouldGetJavaFilesFromDirectory() {
        File directory = new File("src/main/java");
        FilenameFilter filter = ((File dir, String name) -> name.endsWith(".java"));
        String[] javaFilesArray = directory.list(filter);
        System.out.println(Arrays.asList(javaFilesArray));
    }


    @Test
    public void shouldPrintStreamByLambda() {
        Stream.of(1, 2, 3, 4, 5)
                .forEach(s -> System.out.println(s));
    }

    @Test
    public void shouldPrintStreamByReferenceMethod() {
        Stream.of(1, 2, 3, 4, 5)
                .forEach(System.out::println);
    }

    @Test
    public void shouldPrintStreamWithVar() {
        //   Consumer<Integer> consumer= number-> System.out.println(number);
        Consumer<Integer> consumer = System.out::println;
        Stream.of(1, 2, 3, 4, 5).forEach(consumer);
    }

    @Test
    public void shouldGenerateRandom() {
        Stream.generate(Math::random)
                .limit(10)
                .mapToDouble(m->m*10)
                .mapToLong(Math::round)
                .forEach(System.out::println);
    }

}
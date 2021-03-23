package ru.job4j.stream;
import java.util.List;

public class StreamUsageSec {
        public static class Task {
            private final String name;
            private final long spent;

            public Task(String name, long spent) {
                this.name = name;
                this.spent = spent;
            }
        }

        public static void main(String[] args) {
            List<Task> tasks = List.of(
                    new Task("Bug #1", 10),
                    new Task("Task #2", 20),
                    new Task("Bug #3", 40)
            );
            tasks.stream()
                    //.filter(task -> task.name.contains("Bug"))
                    // если только больше 30, то этот блок не нужен
                    .filter(task -> task.spent > 30)
                    .map(task -> task.name + " " + task.spent)
                    .forEach(System.out::println);
        }
    }


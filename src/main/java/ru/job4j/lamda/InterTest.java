package ru.job4j.lamda;

interface Executable {
    int execute(int x, int y);
}

class Runner {
   public void run(Executable ex) {
        int a = ex.execute(1, 0);
    }
}

public class InterTest {
    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.run(new Executable() {
            @Override
            public int execute(int x, int y) {
                System.out.println(x + y);
              return   x + y;
            }
        });
        runner.run((x, y) -> x + y);
    }
}
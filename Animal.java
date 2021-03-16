public class Animal {
    String name;
    int runLimit;
    int swimLimit;
    static int dogsCounter;
    static int catsCounter;
    static int animalsCounter;

    public Animal() {
    }

    public void info() {
        System.out.println(name + ".");
    }

    public void run(int runDistance) {
        if (runDistance <= runLimit) {
            System.out.printf("%s has ran %s meters.%n", name, runDistance);
        } else System.out.printf("%s has run only %s meters out of %s.%n", name, runLimit, runDistance);
    }

    public void swim(int swimDistance) {
        if (swimDistance <= swimLimit) {
            System.out.printf("%s has swam %s meters.%n", name, swimDistance);
        } else System.out.printf("%s has swam only %s meters out of %s.%n", name, swimLimit, swimDistance);
    }

    public void counter() {
        System.out.printf("Dogs number: %s.%nCats number: %s.%nTotal animals number: %s.%n", dogsCounter, catsCounter, animalsCounter);
    }
}
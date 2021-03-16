public class Lesson_6 {
    public static void main(String[] args) {

        Dog dog1 = new Dog("Sharik");
        dog1.info();
        dog1.run(123);
        dog1.swim(3);
        System.out.println();

        Dog dog2 = new Dog("Barbos");
        dog2.info();
        dog2.run(987);
        dog2.swim(15);
        System.out.println();

        Cat cat1 = new Cat("Vaska");
        cat1.info();
        cat1.run(150);
        cat1.swim(0);
        System.out.println();

        Cat cat2 = new Cat("Matroskin");
        cat2.info();
        cat2.run(777);
        cat2.swim(9);
        System.out.println();
        cat2.counter();
    }
}

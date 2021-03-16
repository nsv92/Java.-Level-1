public class Cat extends Animal {
    public Cat(String name) {
        this.name = name;
        this.runLimit = 500;
        System.out.print("Cat: ");
        catsCounter++;
        animalsCounter++;
    }

    @Override
    public void swim(int swimDistance) {
        if (swimDistance != 0) {
            System.out.printf("Sorry! %s drowned.%n", name);
        } else System.out.printf("%s swam 0 meters because cats cant swim.%n", name);
    }
}

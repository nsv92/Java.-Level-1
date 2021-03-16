public class Dog extends Animal {
    public Dog(String name) {
        this.name = name;
        this.runLimit = 200;
        System.out.print("Cat: ");
        dogsCounter++;
        animalsCounter++;
    }
}

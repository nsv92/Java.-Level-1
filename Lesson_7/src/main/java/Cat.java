public class Cat {
    private String name;
    private int appetite;
    private boolean isCatHungry;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void info() {
        if (isCatHungry) {
            System.out.println("Enough food for " + name);
        } else System.out.println("Not enough food for " + name);
    }

    public void eat(Plate p) {
        if (p.getFood() >= appetite) {
            p.decreaseFood(appetite);
            isCatHungry = true;
        }
    }


}

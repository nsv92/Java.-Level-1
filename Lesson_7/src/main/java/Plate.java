public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }

    public int getFood() {
        return food;
    }

    public void addFood(int i) {
        food +=i;
    }

    public void decreaseFood(int i) {
        food -= i;
    }

    public void plateInfo() {
        System.out.println("Food on the plate: " + food);
    }
}

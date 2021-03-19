public class Lesson_7 {
    public static void main(String[] args) {

        Plate plate = new Plate(0);
        plate.addFood(35);

        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Cat1", 10);
        cats[1] = new Cat("Cat2", 15);
        cats[2] = new Cat("Cat3", 15);
        cats[3] = new Cat("Cat4", 10);
        cats[4] = new Cat("Cat5", 5);

        feedCats(plate, cats);
        catsInfo(cats);
        System.out.println();
        plate.plateInfo();
    }

    public static void feedCats(Plate p, Cat[] cats) {
        for (int i = 0; i < cats.length; i++)   {
            cats[i].eat(p);
        }
    }

    public static void catsInfo(Cat[] cats) {
        for (int i = 0; i < cats.length; i++) {
            cats[i].info();
        }
    }
}

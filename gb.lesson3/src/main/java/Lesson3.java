import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) {

//      1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать
//          это число. При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число,
//          чем загаданное, или меньше. После победы или проигрыша выводится
//          запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
        System.out.println("Задание №1.");
        int replay;
        do {
            guessNumber();
            Scanner sc = new Scanner(System.in);
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            replay = sc.nextInt();
        } while (replay == 1);

//  2. * Создать массив из слов
//      String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
//      "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
//      "pepper", "pineapple", "pumpkin", "potato"}.
//      При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//      сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если слово не угадано,
//      компьютер показывает буквы, которые стоят на своих местах.
//      Играем до тех пор, пока игрок не отгадает слово.
//      Используем только маленькие буквы.
        System.out.println("Задание №2");
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        String randomWord = getRandomWord(words);
        do {
            compareWords(randomWord);
        } while (!compareWords(randomWord));
    }

    //  метод для задания №1
    public static void guessNumber() {

        Random rand = new Random();
        int rNumber = rand.nextInt(9);
        int maxTryCount = 3;
        boolean guess = false;

        for (int tryCount = 0; tryCount < maxTryCount; tryCount++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите число от 0 до 9: ");
            int a = sc.nextInt();
            if (a < 0 || a >= 9) {    /* Подача числа вне диапозона не засчитывается как попытка */
                tryCount -= 1;
                System.out.println("Число должно быть в диапозоне от 0 до 9");
            } else if (a == rNumber) {
                guess = true;
                break;
            } else if (a > rNumber) {
                System.out.println("Загаднное число меньше.");
            } else if (a < rNumber) {
                System.out.println("загданное число больше.");
            }
        }

        if (guess) {
            System.out.println("Вы выиграли!");
        } else System.out.println("Вы проиграли!");
    }

    //  Метод для задания №2, отдает случайное слово из массива слов.
    public static String getRandomWord(String[] list) {
        Random rand = new Random();
        int rNumber = rand.nextInt(list.length - 1);
        return list[rNumber];
    }

    //  Метод для задания №2, получает слово из консоли и сравнивает с загаданным, отдает true false
    public static boolean compareWords(String w) {
        System.out.println("Угадайте загаданное слово (овощь или фрукт)");
        Scanner sc = new Scanner(System.in);
        String inputWord = sc.nextLine();
        inputWord = inputWord.toLowerCase();     /* исключил введение прописных букв */
        if (inputWord.equals(w)) {
            System.out.println("Вы угадали!");
            return true;
        } else {
            System.out.println("Не угадали!");
            /*обратиться к методу подсказки*/
            System.out.println("Посдказка: ");
            System.out.println(hint(w, inputWord));
            return false;
        }
    }

    //  Метод для задания №2, отдает массив - подсказку
    public static char[] hint(String a, String b) {
        char[] hiddenArr = new char[15]; /*создаю массив с 15ю #*/
        for (int i = 0; i < hiddenArr.length; i++) {
            hiddenArr[i] = '#';
        }
        int minLength;
        if (a.length() > b.length()) {
            minLength = b.length();
        } else minLength = a.length();
        for (int j = 0; j < minLength; j++) {
            char x = a.charAt(j);
            char y = b.charAt(j);
            if (x == y) {
                hiddenArr[j] = x;
            }
        }
        return hiddenArr;
    }
}




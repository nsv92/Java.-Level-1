import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson_4 {
    public static void main(String[] args) {
        int fieldSize = 5;  /*Размерность поля*/
        char player = 'X';  /*Символ для проверки победы игрока*/
        char bot = 'O'; /*Символ для проверки победы компьютера*/
        char[][] field = emptyField(fieldSize);  /*Создал переменную поля и записал методом в нее пустое поле*/
        drawField(field);   /*вывел в консоль пустое поле*/

        boolean playerWin = false;
        boolean botWin = false;

        for (int a = 1; a <= fieldSize * fieldSize; a++) {
            if (a % 2 != 0) {
                doPlayerMove(field);
                drawField(field);
                if (fullWinCheck(field, player)) {
                    playerWin = true;
                    break;
                }
            } else {
//              doBotMove(field);   /*ход бота без AI*/
                doBotMoveAI(field);
                drawField(field);
                if (fullWinCheck(field, bot)) {
                    botWin = true;
                    break;
                }
            }
        }
        if (playerWin) {
            System.out.println("You win!");
        } else if (botWin) {
            System.out.println("You lose!");
        } else System.out.println("Draw!");
    }

//    Метод отдает пустое поле
    static char[][] emptyField(int fieldSize) {
        char[][] firstField = new char[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            Arrays.fill(firstField[i], '-');
        }
        return firstField;
    }

//  Метод отдает двумерный массив для подсчета очков
    static int[][] emptyScoreArr(int fieldSize) {
        int[][] firstScoreArr = new int[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            Arrays.fill(firstScoreArr[i], 0);
        }
        return firstScoreArr;
    }

//  Метод рисует поданное в него поле в консоль
    static void drawField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
    }

//  Метод просит пользователя ввести поочереди координаты и возвращает их
    static int getCoordinates(int length, char dimension) {
        Scanner scanner = new Scanner(System.in);
        int coordinate;
        do {
            System.out.printf("Please input %s-value ...%n", dimension);
            coordinate = scanner.nextInt() - 1;
        } while (coordinate < 0 || coordinate >= length);
        return coordinate;
    }

//  Получает из консоли 2 кординаты и ставит Х в массив игрового поля
    static void doPlayerMove(char[][] field) {
        int h, v;
        do {
            h = getCoordinates(field.length, 'h');
            v = getCoordinates(field.length, 'v');
        } while (isOccupied(field, h, v));
        field[v][h] = 'X';
    }

//  Ход бота без AI
//    static void doBotMove(char[][] field) {
//        Random random = new Random();
//        int h, v;
//        do {
//            h = random.nextInt(field.length);
//            v = random.nextInt(field.length);
//        } while (isOccupied(field, h, v));
//        field[v][h] = 'O';
//    }

//  Метод ставит О в строчку с 2мя или более Х, если нет то в рандомную пустую точку
    static void doBotMoveAI(char[][] field) {
        Random random = new Random();
        int h, v;
        if (strPrior(field) > -1) {
            do {
                h = random.nextInt(field.length);
                v = strPrior(field);
            } while (isOccupied(field, h, v));
            field[v][h] = 'O';
        } else {
            do {
                h = random.nextInt(field.length);
                v = random.nextInt(field.length);
            } while (isOccupied(field, h, v));
            field[v][h] = 'O';
        }
    }

//  Проверка на пустутю клетку
    static boolean isFree(char[][] field, int h, int v) {
        return field[v][h] == '-';
    }

//  Проверка на занятую клетку
    static boolean isOccupied(char[][] field, int h, int v) {
        return !isFree(field, h, v);
    }

    //  метод отдает true, если в строке находит победу по 4 элементам
    static boolean stringWin(char[][] field, char symbol) {
        int j = 0;
        int counter = 0;
        while (j < field.length) {
            for (int i = 1; i < field.length - 1; i++) {
                if (field[j][i] == symbol) {
                    counter++;
                }
            }
            if ((counter == 3 & field[j][0] == symbol) || (counter == 3 & field[j][field.length - 1] == symbol)) {
                return true;
            }
            j++;
            counter = 0;
        }
        return false;
    }

    //  метод отдает true, если в строке находит победу по 4 элементам
    static boolean columnWin(char[][] field, char symbol) {
        int j = 0;
        int counter = 0;
        while (j < field.length) {
            for (int i = 1; i < field.length - 1; i++) {
                if (field[i][j] == symbol) {
                    counter++;
                }
            }
            if ((counter == 3 & field[0][j] == symbol) || (counter == 3 & field[field.length - 1][j] == symbol)) {
                return true;
            }
            j++;
            counter = 0;
        }
        return false;
    }

    //  метод отдает true, если в главной диагонале находит победу по 4 элементам
    static boolean diagWin(char[][] field, char symbol) {
        int counter = 0;
        for (int i = 1; i < field.length - 1; i++) {
            if (field[i][i] == symbol) {
                counter++;
            }
        }
        if ((counter == 3 & field[0][0] == symbol) || (counter == 3 & field[field.length - 1][field.length - 1] == symbol)) {
            return true;
        }
        return false;
    }

    //  метод отдает true, если в обратной диагонале находит победу по 4 элементам
    static boolean revDiagWin(char[][] field, char symbol) {
        int counter = 0;
        int j = field.length - 2;
        for (int i = 1; i < field.length - 1; i++) {
            if (field[i][j] == symbol) {
                counter++;
            }
            j--;
        }
        if ((counter == 3 & field[0][field.length-1] == symbol) || (counter == 3 & field[field.length-1][0] == symbol)) {
            return true;
        }
        return false;
    }

    //  Метод поочереди прогоняет все проверки на победу
    static boolean fullWinCheck(char[][] field, char symbol) {
        if (stringWin(field, symbol)) {
            return true;
        } else if (columnWin(field, symbol)) {
            return true;
        } else if (diagWin(field, symbol)) {
            return true;
        } else return revDiagWin(field, symbol);
    }

    //  метод отдает индекс первой строки с 2мя или больше Х
    static int strPrior(char[][] field) {
        int j = 0, X = 0, O = 0;
        while (j < field.length) {
            for (int i = 0; i < field.length; i++) {
                if (field[j][i] == 'X') {
                    X++;
                }
                if (field[j][i] == 'O') {
                    O++;
                }
            }
            if (X >= 2 & X + O < 5) {
                return j;
            }
            j++;
            X = 0;
            O = 0;
        }
        return j = -1;
    }

}


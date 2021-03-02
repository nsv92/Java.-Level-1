package gb.lesson2;

import java.util.Arrays;

public class Lesson2 {

    public static void main(String[] args) {
        task1();
        task2();
        task3(6, 2);
        task4(5);               /* a - размерность квадратного массива */
        task5();
        System.out.println("Задание №6.\nРезультат: " + task6(new int[]{1, 2, 3, 4, 2, 0}));
        task7(new int[]{1, 2, 3, 4, 5}, 2);
    }

    // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    //    С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void task1() {
        byte[] arr = {1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0};
        System.out.println("Задание №1.\nИсходный массив:\t" + Arrays.toString(arr));
        for (byte i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println("Зеркальный массив:\t" + Arrays.toString(arr));
    }

    // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его
    //    значениями 0 3 6 9 12 15 18 21;
    public static void task2() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (i * 3);
        }
        System.out.println("Задание №2.\nПолученный массив:\t" + Arrays.toString(arr));
    }

    // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
    //    и числа меньшие 6 умножить на 2;
    public static void task3(int a, int b) {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Задание №3.\nИсходный массив:\t" + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < a) {
                arr[i] = arr[i] * b;
            }
        }
        System.out.println("Полученный массив:\t" + Arrays.toString(arr));
    }

    //  4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    //      и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну
    //      из диагоналей, если обе сложно). Определить элементы одной из диагоналей можно
    //      по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
    public static void task4(int a) {
        System.out.println("Задание №4.\nПолученный массив:");
        int[][] doubleArr = new int[a][a];
        for (int i = 0; i < doubleArr.length; i++) {
            for (int j = 0; j < doubleArr[i].length; j++) {
                int sum = i + j;
                if (j == i) {
                    doubleArr[i][j] = 1;
                } else if (sum == doubleArr.length - 1) {
                    doubleArr[i][j] = 1;
                } else {
                    doubleArr[i][j] = 0;
                }
                System.out.print("\t" + doubleArr[i][j] + ",");
            }
            System.out.println();
        }
    }

    //  5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void task5() {
        int[] arr = {0, 14, 536, 2, 64, 100500, 12, 134, 89, 999, 512, -25};
        int max = arr[0], min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= max) {
                max = arr[i];
            } else {
                min = arr[i];
            }
        }
        System.out.println("Задание №5.\nМаксимум: " + max + "\nМинимум: " + min);
    }

    //  6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    //     метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой
    //     части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    //     checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
    public static boolean task6(int[] arr) {
        int sum = 0, suml = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            suml += arr[i];
            if (sum / suml == 2 && sum % suml == 0) {
                return true;
            }
        }
        return false;
    }

    //  7. **** Написать метод, которому на вход подается одномерный массив и число n
    //     (может быть положительным, или отрицательным), при этом метод должен сместить все элементы
    //     массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться
    //     вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
    //     при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.

//  7е задание сделал не полностью, для заданного int[] и n элемнеты массива смещаются правильно,
//  при изменении входных параметров начинаются проблемы с границами массива. Доделывать не стал,
//  потому что полтора дня потратил на этот велосипед с квадратными колесами.
//  В task7_1 для себя разобрал правильное решение из интернета.
    public static void task7(int[] arr, int n) {
        System.out.println("Задание №7.\n\tИсходный массив:\t" + Arrays.toString(arr));
        if (n % arr.length == 0) {
            System.out.println("Полученный массив: " + Arrays.toString(arr));
        }
        else if (n > arr.length) {
            n = n % arr.length;
        }
            int x = 0, y = 0, z = 0;
            for (int i = 0; i < arr.length * n - n; i += n) {
                if(i == 0) {
                    z = arr[i];
                    arr[i] = arr[arr.length-n];
                    x = arr[i + n];
                    arr[i + n] = z;
                } else if ((i + n) < arr.length) {
                    y = x;
                    x = arr[i + n];
                    arr[i + n] = y;
                } else if ((i + n) >= arr.length) {
//                    i = i + n - arr.length;
                    y = x;
                    x = arr[i + n - arr.length];
                    arr [i + n - arr.length] = y;
                }
            }
            System.out.println("\tПолученный массив:\t" + Arrays.toString(arr));
        }


//  Разобрал для себяё решение последнего задание из интернета
    public static void task7_1 (int[] incomingArray, int shift) {
        if(shift != 0){
            // Любой сдвиг больше длины массива можно оптимизировать до меньшего сдвига
            // через деление по модулю

            int finalShift;
            if (shift > incomingArray.length){
                shift = Math.abs(shift % incomingArray.length);
            }
            else {
                finalShift = shift;
            }

            // в зависимости от знака сдвига движение будет происходить
            // слева направо при положительном сдвиге
            // справа налево при отрицательном
            if (shift > 0) {
                for (int n = 0; n < shift; n++) {
                    // убираем первый элемент в буфер, а на его место ставим хвостовой элемент
                    int buffer = incomingArray[0];
                    incomingArray[0] = incomingArray[incomingArray.length - 1];

                    // циклично сдвигаем весь массив
                    for (int j = 1; j < incomingArray.length - 1; j++) {
                        incomingArray[incomingArray.length - j] = incomingArray[incomingArray.length - j - 1];
                    }

                    // ставим буферный элемент в 1 ячейку
                    incomingArray[1] = buffer;
                }
            }
            else if (shift < 0) {
                for (int i = 0; i > shift; i--) {
                    int buffer = incomingArray[incomingArray.length - 1];
                    incomingArray[incomingArray.length - 1] = incomingArray[0];

                    for (int j = 1; j < incomingArray.length - 1; j++) {
                        incomingArray[j - 1] = incomingArray[j];
                    }

                    incomingArray[incomingArray.length - 2] = buffer;
                }
            }
        }

        System.out.println(Arrays.toString(incomingArray));
    }
}









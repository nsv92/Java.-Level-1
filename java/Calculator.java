import java.util.Stack;

public class Calculator {
//    Приритеты: sqrt - 4, х / - 3, + -  - 2, ( - 1, int - 0, ) - -1.

    public static String stringToPolish(String in) {
        String polish = "";
        Stack<Character> stack = new Stack<>();
        int p;
        for (int i = 0; i < in.length(); i++) {
            p = getPriority(in.charAt(i));

            if (p == 4) {
                polish += ' ';
                String stringForSqrt = new String();
                i++;
                while (i < in.length() && getPriority(in.charAt(i)) == 0) {
                    stringForSqrt += in.charAt(i);
                    i++;
                    if (i == in.length()) {
                        break;
                    }
                }
                i--;
                double operand = Double.parseDouble(stringForSqrt);
                double sqrtResult = Math.sqrt(operand);
                stringForSqrt = Double.toString(sqrtResult);
                for (int j = 0; j < stringForSqrt.length(); j++) {
                    polish += stringForSqrt.charAt(j);
                }
                polish += " 1 *";   /*костыль, что бы убрать шибку по длинне стринга в конце*/
            }


            if (p == 0) {
                polish += in.charAt(i);
            }
            if (p == 1) {
                stack.push(in.charAt(i));
            }
            if (p > 1 && p != 4) {
                polish += ' '; /*статвит пробел для разделения символов*/
                while (!stack.empty()) {
                    if (getPriority(stack.peek()) >= p) {
                        polish += stack.pop();
                    } else break;
                }
                stack.push(in.charAt(i));
            }
            if (p == -1) {
                polish += ' ';
                while (getPriority(stack.peek()) != 1) { /* переносит из стэка все до ( */
                    polish += stack.pop();
                }
                stack.pop(); /* удалил из стека ( */
            }
        }
        while (!stack.empty()) {
            polish += stack.pop();  /* убал все в polish из заполненного стэка*/
        }
        return polish;
    }


    public static double polishToAnswer(String stp) {
        String operand = new String();
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < stp.length(); i++) {
            if (stp.charAt(i) == ' ') continue; /* пропустил пробел*/
            if (getPriority(stp.charAt(i)) == 0) {
                while (stp.charAt(i) != ' ' && getPriority(stp.charAt(i)) == 0) {
                    operand += stp.charAt(i++);
                }
                if (i == stp.length()) {
                    break;
                }
                stack.push(Double.parseDouble(operand));
                operand = new String();
            }
            if (getPriority(stp.charAt(i)) > 0) {
                double y = stack.pop(), x = stack.pop();
                if (stp.charAt(i) == '+') {
                    stack.push(x + y);
                }
                if (stp.charAt(i) == '-') {
                    stack.push(x - y);
                }
                if (stp.charAt(i) == '*') {
                    stack.push(x * y);
                }
                if (stp.charAt(i) == '/') {
                    stack.push(x / y);
                }
            }
        }

        return stack.pop();
    }

    public static int getPriority(char c) {
        if (c == '√') return 4;
        if (c == '*' || c == '/') return 3;
        if (c == '+' || c == '-') return 2;
        if (c == '(') return 1;
        if (c == ')') return -1;
        return 0;
    }
}

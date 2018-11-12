package hw_4.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedList;

public class Calc {

    private static boolean isDelim(char c) {
        return c == ' ';
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^' || c == 's';
    }

    private static int priority(char op) {
        switch (op) {
            case 's':
                return 1;
            case '+':
            case '-':
                return 2;
            case '*':
            case '/':
            case '%':
                return 3;
            case '^':
                return 4;
            default:
                return -1;
        }
    }

    private static void processOperator(LinkedList<Double> st, char op) {
        double r = st.removeLast(); // выдёргиваем из упорядоченного листа последний элемент
        double l = 0;
        if (op != 's') l = st.removeLast(); // также
        switch (op) { // выполняем действие между l и r в зависимости от оператора в кейсе и результат валим в st
            case '+':
                st.add(l + r);
                break;
            case '-':
                st.add(l - r);
                break;
            case '*':
                st.add(l * r);
                break;
            case '/':
                st.add(l / r);
                break;
            case '%':
                st.add(l % r);
                break;
            case '^':
                st.add(Math.pow(l,r));
                break;
            case 's':
                st.add(Math.sin(Math.toRadians(r)));
                break;
        }
    }

    public static Double eval(String s) {
        LinkedList<Double> st = new LinkedList<>(); // сюда наваливают цифры
        LinkedList<Character> op = new LinkedList<>(); // сюда опрераторы и st и op в порядке поступления
        for (int i = 0; i < s.length(); i++) { // парсим строку с выражением и вычисляем
            char c = s.charAt(i);
            if (isDelim(c))
                continue;
            if (c == '(')
                op.add('(');
            else if (c == ')') {
                while (op.getLast() != '(')
                    processOperator(st, op.removeLast());
                op.removeLast();
            } else if (isOperator(c)) {
                while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
                    processOperator(st, op.removeLast());
                op.add(c);
            } else {
                String operand = "";
                while (i < s.length() && Character.isDigit(s.charAt(i)))
                    operand += s.charAt(i++);
                --i;
                st.add(Double.parseDouble(operand));
            }
        }
        while (!op.isEmpty())
            processOperator(st, op.removeLast());

        return formatDouble(st.get(0));
    }

    private static Double formatDouble(Double d){
        NumberFormat fmtr = new DecimalFormat("###.####");
        String f = fmtr.format(d);
        String ff = f.replace(',','.');
        return Double.parseDouble(ff);
    }
}
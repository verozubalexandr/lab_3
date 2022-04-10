package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //task1();
        //task2();
        //task3();
        //task4();
        //task5();
        //task6();
    }


    /**
     * Дана строка, изображающая арифметическое выражение вида «<цифра>±<цифра>±…±<цифра>»,
     * где на месте знака операции «±» находится символ «+» или «−» (например, «4+7−2−8»).
     * Вывести значение данного выражения (целое число).
     */
    public static void task1() {
        //init
        System.out.print("Enter task -> ");
        String inputTask = enterString();
        int resultValue = 0;
        inputTask = inputTask.replaceAll("[+]", " ");
        inputTask = inputTask.replaceAll("-", " -");

        //count
        for (String part : inputTask.split("\\s")) {
            resultValue += Integer.parseInt(part);
        }

        //result
        System.out.println("Result -> " + resultValue);
    }


    /**
     * Дана непустая строка S и целое число N (> 0).
     * Вывести строку, содержащую символы строки S,
     * между которыми вставлено по N символов «*» (звездочка).
     */
    public static void task2() {
        //init
        System.out.print("Enter some text -> ");
        String inputString = enterString();
        int counter = 0;
        final int ASTERISKS_NUMBER = (int) (Math.random() * 5 + 1);
        final char ASTERISK = '*';
        char[] outCharArray = new char[inputString.length() + ASTERISKS_NUMBER * (inputString.length() - 1)];

        //create char array
        for (int i = 0; i < outCharArray.length - (ASTERISKS_NUMBER + 1); i += (ASTERISKS_NUMBER + 1)) {
            outCharArray[i] = inputString.charAt(counter);
            for (int j = i + 1; j <= i + ASTERISKS_NUMBER; j++)
                outCharArray[j] = ASTERISK;
            counter++;
        }
        outCharArray[outCharArray.length - 1] = inputString.charAt(counter);

        //result
        String outString = new String(outCharArray);
        System.out.println("Input string -> " + inputString);
        System.out.println("N -> " + ASTERISKS_NUMBER);
        System.out.println("Output string -> " + outString);
    }


    /**
     * Дана строка, состоящая из слов кириллицей, разделенных пробелами (одним или несколькими).
     * Найти длину самого длинного слова.
     */
    public static void task3() {
        //init
        System.out.print("Enter some text -> ");
        String inputString = enterString();
        String[] wordsArray = inputString.split("\\s");
        int maxWordIndex = 0;
        int maxWordLength = wordsArray[maxWordIndex].length();

        //search max length
        for (int i = maxWordIndex + 1; i < wordsArray.length; i++) {
            if (maxWordLength < wordsArray[i].length()) {
                maxWordLength = wordsArray[i].length();
                maxWordIndex = i;
            }
        }

        //result
        System.out.println("Max length -> " + maxWordLength);
        System.out.println("Max length(word) -> " + wordsArray[maxWordIndex]);
    }


    /**
     * Дана строка, содержащая полное имя файла.
     * Выделить из этой строки название последнего каталога (без символов «\»).
     * Если файл содержится в корневом каталоге, то вывести символ «\».
     */
    public static void task4() {
        //C:\Users\OneDrive\Изображения\img.jpg  <--> example filepath
        //init
        System.out.print("Enter filepath -> ");
        String inputFilepath = enterString();
        String[] wordsArray = inputFilepath.split("\\\\");

        //find+print last directory
        if (wordsArray.length == 2) {
            System.out.println("Last directory -> \\");
        } else {
            System.out.println("Last directory -> " + wordsArray[wordsArray.length - 2]);
        }
    }


    /**
     * Дано зашифрованное предложение заданное кириллицей (способ шифрования описан в задании 63)
     * и кодовое смещение K (0 < K < 10). Расшифровать предложение.
     */
    public static void task5() {
        //init
        System.out.print("Enter message -> ");
        String inputString = enterString();
        byte foundLower = 0;
        final int CHANGE_INDEX = (int) (Math.random()*9 + 1);
        char[] lowerCaseArray = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к',
                'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х',
                'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
        char[] upperCaseArray = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'Й', 'К',
                'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х',
                'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};
        char[] stringToArray = inputString.toCharArray();

        //decrypting
        for (int i = 0; i < stringToArray.length; i++) {
            for (int j = 0; j < lowerCaseArray.length; j++) {
                if (stringToArray[i] == lowerCaseArray[j]) {
                    if (j - CHANGE_INDEX < 0) {
                        stringToArray[i] = lowerCaseArray[lowerCaseArray.length - (CHANGE_INDEX - (lowerCaseArray.length - (lowerCaseArray.length - (j + 1)) - 1) - 1) - 1];
                    } else {
                        stringToArray[i] = lowerCaseArray[j - CHANGE_INDEX];
                    }
                    foundLower = 1;
                    break;
                }
            }
            if (foundLower == 0) {
                for (int j = 0; j < upperCaseArray.length; j++) {
                    if (stringToArray[i] == upperCaseArray[j]) {
                        if (j - CHANGE_INDEX < 0) {
                            stringToArray[i] = upperCaseArray[upperCaseArray.length - (CHANGE_INDEX - (upperCaseArray.length - (upperCaseArray.length - (j + 1)) - 1) - 1) - 1];
                        } else {
                            stringToArray[i] = upperCaseArray[j - CHANGE_INDEX];
                        }
                        break;
                    }
                }
            }
            foundLower = 0;
        }

        //result
        String outputString1 = new String(stringToArray);
        System.out.println("K -> " + CHANGE_INDEX);
        System.out.println("Output message -> " + outputString1);
    }


    /**
     * Дано предложение, зашифрованное по правилу, описанному в задании 66. Расшифровать это предложение.
     * (ргамамроП)
     */
    public static void task6() {
        //init
        System.out.print("Enter message -> ");
        String inputString = enterString();
        char[] stringToArray = inputString.toCharArray();
        char[] outputCharArray = new char[stringToArray.length];
        int indexOddCounter = stringToArray.length - 1;
        int indexEvenCounter = 0;

        //decrypting
        for (int i = 0; i < stringToArray.length; i += 2) {
            outputCharArray[i] = stringToArray[indexOddCounter];
            if (i + 1 <= stringToArray.length - 1) {
                outputCharArray[i + 1] = stringToArray[indexEvenCounter];
                indexEvenCounter++;
                indexOddCounter--;
            }
        }

        //result
        String outputString = new String(outputCharArray);
        System.out.println("Result -> " + outputString);
    }


    //add text to string
    private static String enterString() {
        Scanner scan = new Scanner(System.in);
        String sourceString = scan.nextLine();
        return sourceString;
    }
}


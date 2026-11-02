package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println(" Задание 1");
        task1();
        System.out.println("\nЗадание 2");
        task2();
        System.out.println("\nЗадание 3");
        task3();
        System.out.println("\nЗадание 4");
        task4();
        System.out.println("\nЗадание 5");
        task5();
    }

    static void task1() {
        File file = new File("game.txt");
        try (FileWriter fw = new FileWriter(file)) {
            fw.write("Моя любимая игра: Cyberpunk 2077\n");
            fw.write("Жанр: RPG\n");
            fw.write("Платформа: PC\n");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        System.out.println("Имя файла: " + file.getName());
        System.out.println("Размер файла: " + file.length() + " байт");
        System.out.println("Путь: " + file.getAbsolutePath());

        System.out.println("Содержимое файла:");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
    }

    static void task2() {
        File file = new File("numbers.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 10 целых чисел:");

        try (FileWriter fw = new FileWriter(file)) {
            for (int i = 0; i < 10; i++) {
                if (scanner.hasNextInt()) {
                    fw.write(scanner.nextInt() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        int sumNegative = 0;
        System.out.println("Числа из файла:");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                int num = Integer.parseInt(line.trim());
                System.out.print(num + " ");
                if (num < 0) {
                    sumNegative += num;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
        System.out.println("\nСумма отрицательных чисел: " + sumNegative);
    }

    static void task3() {
        File fileF = new File("f.txt");
        File fileG = new File("g.txt");
        File fileH = new File("h.txt");
        Random rand = new Random();

        try (FileWriter fw = new FileWriter(fileF)) {
            for (int i = 0; i < 20; i++) {
                fw.write((rand.nextInt(200) - 100) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileF));
             FileWriter fwG = new FileWriter(fileG);
             FileWriter fwH = new FileWriter(fileH)) {

            String line;
            while ((line = br.readLine()) != null) {
                int num = Integer.parseInt(line.trim());
                if (num % 10 == 0) {
                    fwG.write(num + "\n");
                } else {
                    fwH.write(num + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("Файлы f.txt, g.txt, h.txt созданы и заполнены.");
    }

    static void task4() {
        File file = new File("time.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 15 значений времени в секундах:");

        try (FileWriter fw = new FileWriter(file)) {
            for (int i = 0; i < 15; i++) {
                if (scanner.hasNextDouble()) {
                    fw.write(scanner.nextDouble() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        double sum = 0;
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                sum += Double.parseDouble(line.trim());
                count++;
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        if (count > 0) {
            System.out.println("Среднее время: " + (sum / count));
        }
    }

    static void task5() {
        File file = new File("int_numbers.txt");
        Random rand = new Random();

        try (FileWriter fw = new FileWriter(file)) {
            for (int i = 0; i < 10; i++) {
                fw.write((rand.nextInt(100) - 50) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        int countLessThanMinus10 = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                int num = Integer.parseInt(line.trim());
                if (num < -10) {
                    countLessThanMinus10++;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        System.out.println("Количество чисел меньше -10: " + countLessThanMinus10);
    }
}
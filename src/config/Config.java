package config;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Config<T> {

    static Scanner sc = new Scanner(System.in);

    public static int getIntegerInput() {
        String choiceString = "";
        while (!choiceString.matches("\\d+")) {
            choiceString = sc.nextLine();
            if (!choiceString.matches("\\d+")) {
                System.out.println("Please enter a valid input");
            }
        }

        return Integer.parseInt(choiceString);
    }

    public static String getStringInput() {
        String input = " ";
        while (input.trim().isEmpty() || input.contains(" ")) {
            input = sc.nextLine();
            if (input.trim().isEmpty() || input.contains(" ")) {
                System.out.println("Please enter a valid input");
            }
        }

        return input;
    }

    public void write(T element, String path) {
        try (
                FileOutputStream fos = new FileOutputStream(path);
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(element);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public T read(String path) {
        T obj = null;
        try (
                FileInputStream fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            obj = (T) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }

}

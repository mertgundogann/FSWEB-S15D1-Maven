package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nSeçiminizi yapın:");
            System.out.println("0 - Uygulamayı durdur");
            System.out.println("1 - Eleman ekle");
            System.out.println("2 - Eleman çıkar");
            System.out.print("Seçiminiz: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Eklenmesini istediğiniz elemanları giriniz (virgülle ayırabilirsiniz): ");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    break;
                case 2:
                    System.out.print("Çıkarılmasını istediğiniz elemanları giriniz (virgülle ayırabilirsiniz): ");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    break;
                case 0:
                    System.out.println("Uygulama kapatılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
            printSorted();
        } while (choice != 0);

        scanner.close();
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (!trimmedItem.isEmpty() && !checkItemIsInList(trimmedItem)) {
                groceryList.add(trimmedItem);
            }
        }
        System.out.println("Eleman(lar) eklendi.");
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (checkItemIsInList(trimmedItem)) {
                groceryList.remove(trimmedItem);
            }
        }
        System.out.println("Eleman(lar) çıkarıldı.");
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("\nSıralanmış Alışveriş Listesi: " + groceryList);
    }


}

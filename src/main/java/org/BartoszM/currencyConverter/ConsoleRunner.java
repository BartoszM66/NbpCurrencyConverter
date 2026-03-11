package org.BartoszM.currencyConverter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final CurrencyService currencyService;

    public ConsoleRunner(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Override
    public void run(String... args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("=================================");
        System.out.println("   WITAJ W KALKULATORZE WALUT   ");
        System.out.println("=================================");

        while (true){
            System.out.println("\nWybierz operację:");
            System.out.println("1 - Przelicz walutę obcą na PLN");
            System.out.println("2 - Przelicz PLN na walutę obcą");
            System.out.println("0 - Wyjście z programu");
            System.out.print("Twój wybór: ");

            String choice = scanner.nextLine();

            if (choice.equals("0")) {
                System.out.println("Zamykam aplikację. Do widzenia!");
                System.exit(0);
            }

            if (choice.equals("1") || choice.equals("2")) {
                try {
                    System.out.print("Podaj 3-literowy kod waluty (np. EUR, USD, CHF): ");
                    String code = scanner.nextLine().toUpperCase();

                    System.out.print("Podaj kwotę: ");
                    double amount = Double.parseDouble(scanner.nextLine().replace(",", "."));
                    if (choice.equals("1")) {
                        double result = currencyService.convertForeignToPln(code, amount);

                        System.out.printf("Wynik: %.2f %s to %.2f PLN%n", amount, code, result);
                    } else {
                        double result = currencyService.convertPlnToForeign(code, amount);
                        System.out.printf("Wynik: %.2f PLN to %.2f %s%n", amount, result, code);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("BŁĄD: Podałeś nieprawidłową kwotę! Używaj cyfr.");
                } catch (Exception e) {
                    System.out.println("BŁĄD NBP: Prawdopodobnie podałeś zły kod waluty. (" + e.getMessage() + ")");
                }
            } else {
                System.out.println("Nieznana opcja, spróbuj ponownie.");
            }
        }
    }
}

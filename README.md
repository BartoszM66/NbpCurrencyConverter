# NBP Currency Converter CLI 💱

Interaktywna aplikacja konsolowa (CLI) napisana w Spring Boot, służąca do przeliczania walut w czasie rzeczywistym. Projekt demonstruje umiejętność integracji z zewnętrznym, publicznym API (Narodowy Bank Polski) oraz przetwarzania formatu JSON na obiekty Javy (Deserializacja/DTO).

## 🚀 Technologie
* **Java 17+**
* **Spring Boot 3** (wykorzystanie `CommandLineRunner` do interfejsu CLI)
* **RestTemplate** (klient HTTP do komunikacji z zewnętrznym serwerem)
* **Lombok** (czysty kod)
* **API NBP** (dane pobierane na żywo)

## ⚙️ Funkcjonalności
* Pobieranie aktualnych średnich kursów walut (tabela A) bezpośrednio z serwerów NBP.
* Przeliczanie obcej waluty na PLN.
* Przeliczanie PLN na obcą walutę.
* Odporność na błędy:
    * Walidacja wprowadzanych kwot (zabezpieczenie przed wpisaniem liter).
    * Obsługa błędów 404 z NBP (np. gdy użytkownik poda nieistniejący kod waluty).

## 🛠️ Jak uruchomić?
1. Sklonuj repozytorium: `git clone [TUTAJ_LINK_DO_TWOJEGO_GITHUB]`
2. Otwórz projekt w IDE (np. IntelliJ IDEA) lub uruchom z konsoli za pomocą Mavena: `mvn spring-boot:run`
3. Aplikacja uruchomi się bezpośrednio w terminalu/konsoli systemowej. Postępuj zgodnie z instrukcjami na ekranie.

## 💻 Przykładowe użycie
```text
======================================
  WITAJ W KALKULATORZE WALUT NBP 💰  
======================================

Wybierz operację:
1 - Przelicz walutę obcą na PLN
2 - Przelicz PLN na walutę obcą
0 - Wyjście z programu
Twój wybór: 1
Podaj 3-literowy kod waluty (np. EUR, USD, CHF): EUR
Podaj kwotę: 150
Wynik: 150,00 EUR to 647,25 PLN
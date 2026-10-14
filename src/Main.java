

import java.util.Scanner;

// завдання 1

// Базовий клас
class Worker {
    protected String name;
    protected double salary;

    public Worker(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void Show() {
        System.out.println("Ім'я: " + name);
        System.out.println("Зарплата: " + salary + " грн");
    }
}

// Кадри
class Personnel extends Worker {
    private int employeeCount;

    public Personnel(String name, double salary, int employeeCount) {
        super(name, salary);
        this.employeeCount = employeeCount;
    }

    @Override
    public void Show() {
        System.out.println("\nПрацівник відділу кадрів:");
        super.Show();
        System.out.println("Кількість працівників: " + employeeCount);
    }
}

// Інженер
class Engineer extends Worker {
    private String specialization;

    public Engineer(String name, double salary, String specialization) {
        super(name, salary);
        this.specialization = specialization;
    }

    @Override
    public void Show() {
        System.out.println("\nІнженер:");
        super.Show();
        System.out.println("Спеціалізація: " + specialization);
    }
}

// Адміністрація
class Administration extends Worker {
    private String position;

    public Administration(String name, double salary, String position) {
        super(name, salary);
        this.position = position;
    }

    @Override
    public void Show() {
        System.out.println("\nАдміністрація:");
        super.Show();
        System.out.println("Посада: " + position);
    }
}


// завдання 2

// Абстрактний клас
abstract class Currency {
    protected double amount;
    protected double rate;

    public Currency(double amount, double rate) {
        this.amount = amount;
        this.rate = rate;
    }

    public abstract double toUAH();

    public abstract void print();
}

// Долар
class Dollar extends Currency {

    public Dollar(double amount, double rate) {
        super(amount, rate);
    }

    @Override
    public double toUAH() {
        return amount * rate;
    }

    @Override
    public void print() {
        System.out.println("Долари: " + amount);
        System.out.println("У гривнях: " + toUAH());
    }

    @Override
    public String toString() {
        return "Dollar: " + amount + " USD";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Dollar)) return false;

        Dollar other = (Dollar) obj;

        return Double.compare(amount, other.amount) == 0
                && Double.compare(rate, other.rate) == 0;
    }
}

// Євро
class Euro extends Currency {

    public Euro(double amount, double rate) {
        super(amount, rate);
    }

    @Override
    public double toUAH() {
        return amount * rate;
    }

    @Override
    public void print() {
        System.out.println("Євро: " + amount);
        System.out.println("У гривнях: " + toUAH());
    }

    @Override
    public String toString() {
        return "Euro: " + amount + " EUR";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Euro)) return false;

        Euro other = (Euro) obj;

        return Double.compare(amount, other.amount) == 0
                && Double.compare(rate, other.rate) == 0;
    }
}


// завдання 3

// Інтерфейс замість абстрактного класу
interface CurrencyInterface {
    double toUAH();
    void print();
}

// Долар через інтерфейс
class DollarInterface implements CurrencyInterface {
    private double amount;
    private double rate;

    public DollarInterface(double amount, double rate) {
        this.amount = amount;
        this.rate = rate;
    }

    @Override
    public double toUAH() {
        return amount * rate;
    }

    @Override
    public void print() {
        System.out.println("Долари: " + amount);
        System.out.println("У гривнях: " + toUAH());
    }

    @Override
    public String toString() {
        return "Dollar: " + amount + " USD";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DollarInterface)) return false;

        DollarInterface other = (DollarInterface) obj;

        return Double.compare(amount, other.amount) == 0
                && Double.compare(rate, other.rate) == 0;
    }
}

// Євро через інтерфейс
class EuroInterface implements CurrencyInterface {
    private double amount;
    private double rate;

    public EuroInterface(double amount, double rate) {
        this.amount = amount;
        this.rate = rate;
    }

    @Override
    public double toUAH() {
        return amount * rate;
    }

    @Override
    public void print() {
        System.out.println("Євро: " + amount);
        System.out.println("У гривнях: " + toUAH());
    }

    @Override
    public String toString() {
        return "Euro: " + amount + " EUR";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EuroInterface)) return false;

        EuroInterface other = (EuroInterface) obj;

        return Double.compare(amount, other.amount) == 0
                && Double.compare(rate, other.rate) == 0;
    }
}




public class Main {

    static Scanner sc = new Scanner(System.in);

    // Введення цілого числа
    public static int readInt() {
        return Integer.parseInt(sc.nextLine().trim());
    }

    // Введення дробового числа
    public static double readDouble() {
        return Double.parseDouble(
                sc.nextLine().trim().replace(",", ".")
        );
    }

    // Завдання 1
    public static void task1() {
        System.out.println("\nзавдання 1 ");

        System.out.print(" кількість працівників: ");
        int n = readInt();

        if (n <= 0) {
            System.out.println("Кількість має бути додатною.");
            return;
        }

        Worker[] workers = new Worker[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nПрацівник №" + (i + 1));
            System.out.println("1 - Кадри");
            System.out.println("2 - Інженер");
            System.out.println("3 - Адміністрація");

            System.out.print("Оберіть тип: ");
            int type = readInt();

            if (type < 1 || type > 3) {
                System.out.println("Невірний тип!");
                i--;
                continue;
            }

            System.out.print("Ім'я: ");
            String name = sc.nextLine();

            System.out.print("Зарплата: ");
            double salary = readDouble();

            switch (type) {
                case 1:
                    System.out.print("Кількість працівників у відділі: ");
                    int count = readInt();

                    workers[i] = new Personnel(name, salary, count);
                    break;

                case 2:
                    System.out.print("Спеціалізація: ");
                    String specialization = sc.nextLine();

                    workers[i] = new Engineer(
                            name, salary, specialization
                    );
                    break;

                case 3:
                    System.out.print("Посада: ");
                    String position = sc.nextLine();

                    workers[i] = new Administration(
                            name, salary, position
                    );
                    break;
            }
        }

        System.out.println("\nсписок працівників");

        for (Worker worker : workers) {
            worker.Show();
        }
    }

    // Завдання 2
    public static void task2() {
        System.out.println("\nзавдання 2");

        System.out.print("Введіть курс долара: ");
        double dollarRate = readDouble();

        System.out.print("Введіть курс євро: ");
        double euroRate = readDouble();

        if (dollarRate <= 0 || euroRate <= 0) {
            System.out.println("Курс має бути додатним.");
            return;
        }

        System.out.print("Введіть кількість доларів: ");
        double dollars = readDouble();

        System.out.print("Введіть кількість євро: ");
        double euros = readDouble();

        Currency[] currencies = {
                new Dollar(dollars, dollarRate),
                new Euro(euros, euroRate)
        };

        System.out.println("\nрезультат");

        for (Currency currency : currencies) {
            System.out.println("--------------------");

            currency.print();

            System.out.println("toUAH(): " + currency.toUAH());
            System.out.println("toString(): " + currency.toString());
        }

        System.out.println("\nперевірка");

        Dollar dollarCopy = new Dollar(dollars, dollarRate);
        Dollar dollarOther = new Dollar(dollars + 1, dollarRate);

        Euro euroCopy = new Euro(euros, euroRate);
        Euro euroOther = new Euro(euros + 1, euroRate);

        System.out.println("Однакові долари: "
                + currencies[0].equals(dollarCopy));

        System.out.println("Різні долари: "
                + currencies[0].equals(dollarOther));

        System.out.println("Однакові євро: "
                + currencies[1].equals(euroCopy));

        System.out.println("Різні євро: "
                + currencies[1].equals(euroOther));
    }

    // Завдання 3
    public static void task3() {
        System.out.println("\n=== ЗАВДАННЯ 3 ===");

        System.out.print(" курс долара: ");
        double dollarRate = readDouble();

        System.out.print(" курс євро: ");
        double euroRate = readDouble();

        if (dollarRate <= 0 || euroRate <= 0) {
            System.out.println("Курс має бути додатним.");
            return;
        }

        System.out.print(" кількість доларів: ");
        double dollars = readDouble();

        System.out.print(" кількість євро: ");
        double euros = readDouble();

        CurrencyInterface[] currencies = {
                new DollarInterface(dollars, dollarRate),
                new EuroInterface(euros, euroRate)
        };

        System.out.println("\nрезультат");

        for (CurrencyInterface currency : currencies) {
            System.out.println("--------------------");

            currency.print();

            System.out.println("toUAH(): " + currency.toUAH());
            System.out.println("toString(): " + currency.toString());
        }

        System.out.println("\n=== ПЕРЕВІРКА equals() ===");

        DollarInterface dollarCopy =
                new DollarInterface(dollars, dollarRate);

        DollarInterface dollarOther =
                new DollarInterface(dollars + 1, dollarRate);

        EuroInterface euroCopy =
                new EuroInterface(euros, euroRate);

        EuroInterface euroOther =
                new EuroInterface(euros + 1, euroRate);

        System.out.println("Однакові долари: "
                + currencies[0].equals(dollarCopy));

        System.out.println("Різні долари: "
                + currencies[0].equals(dollarOther));

        System.out.println("Однакові євро: "
                + currencies[1].equals(euroCopy));

        System.out.println("Різні євро: "
                + currencies[1].equals(euroOther));
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("1 - Завдання 1 ");
            System.out.println("2 - Завдання 2 ");
            System.out.println("3 - Завдання 3 ");


            System.out.print(" вибір: ");
            int choice = readInt();

            switch (choice) {
                case 1:
                    task1();
                    break;

                case 2:
                    task2();
                    break;

                case 3:
                    task3();
                    break;

                case 0:
                    System.out.println("Програму завершено.");
                    return;

                default:
                    System.out.println("Невірний вибір!");
            }
        }
    }
}

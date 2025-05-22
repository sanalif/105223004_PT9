public class Main {
    public static void main(String[] args) {
        // Array of Employee (Polymorphism)
        Employee[] employees = {
            new SoftwareEngineer(),
            new DataScientist(),
            new Intern()
        };

        System.out.println("=== Gaji Bulanan Tanpa Bonus ===");
        for (Employee emp : employees) {
            System.out.println(emp.getClass().getSimpleName() + ": " + emp.calculateSalary());
        }

        System.out.println("\n=== Gaji Bulanan Dengan Bonus ===");
        // Memanggil method overload langsung dari objek (bukan polymorphic)
        for (Employee emp : employees) {
            System.out.println(emp.getClass().getSimpleName() + ": " + emp.calculateSalary(true));
        }
    }
}

// Superclass
class Employee {
    public double calculateSalary() {
        return 0.0;
    }

    public double calculateSalary(boolean withBonus) {
        if (withBonus) {
            return calculateSalary() + 0; // default: tidak ada bonus
        } else {
            return calculateSalary();
        }
    }
}

// Subclass: SoftwareEngineer
class SoftwareEngineer extends Employee {
    @Override
    public double calculateSalary() {
        return 10_000_000; // Contoh gaji bulanan
    }

    @Override
    public double calculateSalary(boolean withBonus) {
        if (withBonus) {
            return calculateSalary() + 2000000;
        } else {
            return calculateSalary();
        }
    }
}

// Subclass: DataScientist
class DataScientist extends Employee {
    @Override
    public double calculateSalary() {
        return 12000000;
    }

    @Override
    public double calculateSalary(boolean withBonus) {
        if (withBonus) {
            return calculateSalary() + 2500000;
        } else {
            return calculateSalary();
        }
    }
}

// Subclass: Intern
class Intern extends Employee {
    @Override
    public double calculateSalary() {
        return 3_000_000;
    }

    @Override
    public double calculateSalary(boolean withBonus) {
        if (withBonus) {
            return calculateSalary() + 500000;
        } else {
            return calculateSalary();
        }
    }
}

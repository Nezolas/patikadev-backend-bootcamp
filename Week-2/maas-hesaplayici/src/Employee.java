
public class Employee {
    String name;
    double salary;
    int workHours;
    int hireYear;

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public double tax() {
        if (salary > 1000) {
            return salary * 0.03;
        } else {
            return 0;
        }
    }

    public double bonus() {
        if (workHours > 40) {
            int extraHours = workHours - 40;
            return extraHours * 30;
        } else {
            return 0;
        }
    }

    public double raiseSalary() {
        int yearsWorked = 2021 - hireYear;
        if (yearsWorked < 10) {
            return salary * 0.05;
        } else if (yearsWorked < 20) {
            return salary * 0.10;
        } else {
            return salary * 0.15;
        }
    }
    public String toString() {
        double tSalary = salary - tax() + bonus();
        double totalSalary = tSalary + raiseSalary();
        System.out.println("Adı: " + name + "\n" + "Maaşı: " + salary + "\n" + "Çalışma Saati: " + workHours + "\n" + "Başlangıç Yılı: " + hireYear + "\n" + "Vergi: " + tax() + "\n" + "Bonus: " + bonus() + "\n" + "Maaş Artışı: " + raiseSalary() + "\n" + "Vergi ve Bonuslar ile birlikte maaş: " + tSalary + "\n" + "Toplam Maaş: " + totalSalary);
        return "done";
    }
    }

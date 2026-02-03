
import java.io.*;
import java.util.*;

public class ExpenseManager {
    ArrayList<Expense> expenses = new ArrayList<>();
    double budget = 0;

    public void addExpense(Scanner sc) {
        System.out.print("Date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        System.out.print("Category: ");
        String category = sc.nextLine();
        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Note: ");
        String note = sc.nextLine();

        expenses.add(new Expense(date, category, amount, note));
        checkBudget();
    }

    public void viewExpenses() {
        System.out.println("\n--- All Expenses ---");
        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    public void categoryReport() {
        HashMap<String, Double> report = new HashMap<>();
        for (Expense e : expenses) {
            report.put(e.category, report.getOrDefault(e.category, 0.0) + e.amount);
        }

        System.out.println("\n--- Category-wise Report ---");
        for (String key : report.keySet()) {
            System.out.println(key + ": " + report.get(key));
        }
    }

    public void setBudget(Scanner sc) {
        System.out.print("Enter monthly budget: ");
        budget = sc.nextDouble();
        sc.nextLine();
    }

    private void checkBudget() {
        double total = 0;
        for (Expense e : expenses) total += e.amount;
        if (budget > 0 && total > budget) {
            System.out.println("⚠ Budget Alert: You exceeded your budget!");
        }
    }

    public void saveExpenses() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/expenses.dat"))) {
            oos.writeObject(expenses);
            System.out.println("Expenses saved.");
        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }

    public void loadExpenses() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/expenses.dat"))) {
            expenses = (ArrayList<Expense>) ois.readObject();
        } catch (Exception e) {
            expenses = new ArrayList<>();
        }
    }
}

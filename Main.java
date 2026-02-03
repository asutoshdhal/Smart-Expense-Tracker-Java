
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();
        manager.loadExpenses();

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Smart Expense Tracker ====");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Category-wise Report");
            System.out.println("4. Set Monthly Budget");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> manager.addExpense(sc);
                case 2 -> manager.viewExpenses();
                case 3 -> manager.categoryReport();
                case 4 -> manager.setBudget(sc);
                case 5 -> manager.saveExpenses();
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}

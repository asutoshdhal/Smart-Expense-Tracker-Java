
import java.io.Serializable;

public class Expense implements Serializable {
    String date;
    String category;
    double amount;
    String note;

    public Expense(String date, String category, double amount, String note) {
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.note = note;
    }

    @Override
    public String toString() {
        return date + " | " + category + " | " + amount + " | " + note;
    }
}

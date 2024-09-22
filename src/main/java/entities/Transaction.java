package entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionId", nullable = false)
    private int transactionId;
    @Column(name="amount")
    private double amount;
    @Column(name="description")
    private String description;
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date timestamp;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category categoryId;
    @ManyToOne
    @JoinColumn(name = "sourceAccountId")
    private Account sourceAccountId;
    @ManyToOne
    @JoinColumn(name = "destinationAccountId")
    private Account destinationAccountId;

    public Transaction(double amount, String description, Date timestamp, Category categoryId, Account sourceAccountId, Account destinationAccountId) {
        this.amount = amount;
        this.description = description;
        this.timestamp = timestamp;
        this.categoryId = categoryId;
        this.sourceAccountId = sourceAccountId;
        this.destinationAccountId = destinationAccountId;
    }

    public Transaction() {
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Account getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(Account sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public Account getDestinationAccountId() {
        return destinationAccountId;
    }

    public void setDestinationAccountId(Account destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                ", categoryId=" + categoryId +
                ", sourceAccountId=" + sourceAccountId +
                ", destinationAccountId=" + destinationAccountId +
                '}';
    }
}

package entity;
import jakarta.persistence.*;

@Entity
@Table(name="ACCOUNT")
public class Account {
	@Id
	@Column(name="number")
	private int number;

	@Column(name="balance")
	@Convert(converter = BalanceConverter.class)
	private double balance;

	@Version
	@Column(name="version")
	private int version;



	public Account() {
		super();
	}
	public Account(int number, double balance) {
		super();
		this.number = number;
		this.balance = balance;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}

package jp.co.example.entity;

public class MonthSum {

	private String monthDate;
	private Integer monthIncome;
	private Integer monthSpending;
	private Integer monthIncomeSpendingDifference;
	private Integer monthIncomeSum;
	private Integer monthSpendingSum;
	private Integer monthIncomeSpendingDifferenceSum;

	public MonthSum() {}

	public MonthSum(String monthDate,Integer monthIncome,Integer monthSpending,Integer monthIncomeSpendingDifference,Integer monthIncomeSum,Integer monthSpendingSum,Integer monthIncomeSpendingDifferenceSum) {
		this.monthDate = monthDate;
		this.monthIncome = monthIncome;
		this.monthSpending =monthSpending;
		this.monthIncomeSpendingDifference = monthIncomeSpendingDifference;
		this.monthIncomeSum = monthIncomeSum;
		this.monthSpendingSum =monthSpendingSum;
		this.monthIncomeSpendingDifferenceSum = monthIncomeSpendingDifferenceSum;
	}

	public String getMonthDate() {
		return this.monthDate;
	}
	public void setMonthDate(String monthDate) {
		this.monthDate = monthDate;
	}

	public Integer getMonthIncome() {
		return this.monthIncome;
	}
	public void setMonthIncome(Integer monthIncome) {
		this.monthIncome = monthIncome;
	}

	public Integer getMonthSpending() {
		return this.monthSpending;
	}
	public void setMonthSpending(Integer monthSpending) {
		this.monthSpending = monthSpending;
	}

	public Integer getMonthIncomeSpendingDifference() {
		return this.monthIncomeSpendingDifference;
	}
	public void setMonthIncomeSpendingDifference(Integer monthIncomeSpendingDifference) {
		this.monthIncomeSpendingDifference = monthIncomeSpendingDifference;
	}

	public Integer getMonthIncomeSum() {
		return this.monthIncomeSum;
	}
	public void setMonthIncomeSum(Integer monthIncomeSum) {
		this.monthIncomeSum = monthIncomeSum;
	}

	public Integer getMonthSpendingSum() {
		return this.monthSpendingSum;
	}
	public void setMonthSpendingSum(Integer monthSpendingSum) {
		this.monthSpendingSum = monthSpendingSum;
	}

	public Integer getMonthIncomeSpendingDifferenceSum() {
		return this.monthIncomeSpendingDifferenceSum;
	}
	public void setMonthIncomeSpendingDifferenceSum(Integer monthIncomeSpendingDifferenceSum) {
		this.monthIncomeSpendingDifferenceSum = monthIncomeSpendingDifferenceSum;
	}
}

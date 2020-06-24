package jp.co.example.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class InputMoneyForm {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date date;

	@NotNull
	private Integer itemId;

	@NotNull
	@Min(0)
	private Integer amount;

	public InputMoneyForm() {

	}

	public InputMoneyForm(Date date,Integer itemId,Integer amount) {
		this.setDate(date);
		this.setItemsId(itemId);
		this.setAmount(amount);
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getDate() {
		return this.date;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getItemsId() {
		return this.itemId;
	}
	public void setItemsId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getAmount() {
		return this.amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}


}

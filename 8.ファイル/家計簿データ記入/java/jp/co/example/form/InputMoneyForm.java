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

	@NotNull(message = "項目がない状態でデータの記入はできません。項目の追加ページから項目の追加をお願いします。")
	private Integer itemsId;

	@NotNull
	@Min(0)
	private Integer amount;

	public InputMoneyForm() {

	}

	public InputMoneyForm(Date date,Integer itemsId,Integer amount) {
		this.setDate(date);
		this.setItemsId(itemsId);
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
		return this.itemsId;
	}
	public void setItemsId(Integer itemsId) {
		this.itemsId = itemsId;
	}
	public Integer getAmount() {
		return this.amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}


}

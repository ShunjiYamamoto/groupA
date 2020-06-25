package jp.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.entity.Item;
import jp.co.example.entity.User;
import jp.co.example.form.DeleteItemForm;
import jp.co.example.form.InputItemForm;
import jp.co.example.form.ReInputItemForm;
import jp.co.example.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	@Autowired
	HttpSession session;

	@RequestMapping("/displayItemOutgo")
	public String displayItemOutgo(@ModelAttribute("deleteForm") DeleteItemForm deleteForm, @ModelAttribute("reInputForm") ReInputItemForm reInputForm, @ModelAttribute("inputForm") InputItemForm inputForm, Model model) {
		session.setAttribute("incomeOutgo", 2);
		displayList(model);
		return "item";
	}

	@RequestMapping("/displayItemIncome")
	public String displayItemIncome(@ModelAttribute("deleteForm") DeleteItemForm deleteForm, @ModelAttribute("reInputForm") ReInputItemForm reInputForm, @ModelAttribute("inputForm") InputItemForm inputForm, Model model) {
		session.setAttribute("incomeOutgo", 1);
		displayList(model);
		return "item";
	}

	@RequestMapping("/inputItem")
	public String inputItem(@ModelAttribute("deleteForm") DeleteItemForm deleteForm, @ModelAttribute("reInputForm") ReInputItemForm reInputForm, @Validated @ModelAttribute("inputForm") InputItemForm inputForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			displayList(model);
			return "item";
		}

		User user = (User) session.getAttribute("user");
		Item newItem = new Item(user.getUsersId(), inputForm.getItemName(), (Integer) session.getAttribute("incomeOutgo"));

		if(itemService.checkDuplicationItem(newItem)) {
			model.addAttribute("inputMsg", "その項目は既に登録済みです");
			displayList(model);
			return "item";
		}

		itemService.inputItem(newItem);

		displayList(model);
		return "item";
	}

	@RequestMapping("/confirmDeleteItem")
	public String confirmDeleteItem(@ModelAttribute("deleteForm") DeleteItemForm deleteForm, @ModelAttribute("reInputForm") ReInputItemForm reInputForm, @ModelAttribute("inputForm") InputItemForm inputForm, Model model) {
		if(deleteForm.getItems().length == 0) {
			model.addAttribute("deleteMsg", "項目が選択されていません");
			displayList(model);
			return "item";
		}

		User user = (User) session.getAttribute("user");
		List<Item> itemList = itemService.findItem(user.getUsersId(), (Integer) session.getAttribute("incomeOutgo"));
		List<Item> confirmDeleteItemList = new ArrayList<Item>();
		Integer[] deleteItems = deleteForm.getItems();

		for(int num : deleteItems) {
			confirmDeleteItemList.add(itemList.get(num));
		}

		model.addAttribute("confirmDeleteItemList", confirmDeleteItemList);
		session.setAttribute("deleteItems", deleteItems);

		return "confirmDeleteItem";
	}

	@RequestMapping("/deleteItem")
	public String deleteItem(@ModelAttribute("deleteForm") DeleteItemForm deleteForm, @ModelAttribute("reInputForm") ReInputItemForm reInputForm, @ModelAttribute("inputForm") InputItemForm inputForm, Model model) {
		User user = (User) session.getAttribute("user");
		List<Item> itemList = itemService.findItem(user.getUsersId(), (Integer) session.getAttribute("incomeOutgo"));

		for(int num : (Integer[]) session.getAttribute("deleteItems")) {
			itemService.deleteItem(itemList.get(num).getItemsId());
		}

		displayList(model);
		return "item";
	}

	@RequestMapping("/reInputItem")
	public String reInputItem(@ModelAttribute("deleteForm") DeleteItemForm deleteForm, @ModelAttribute("reInputForm") ReInputItemForm reInputForm, @ModelAttribute("inputForm") InputItemForm inputForm, Model model) {
		itemService.reInputItem(reInputForm.getItemsId());

		displayList(model);
		return "item";
	}

	public void displayList(Model model) {
		User user = (User) session.getAttribute("user");
		List<Item> itemList = itemService.findItem(user.getUsersId(), (Integer) session.getAttribute("incomeOutgo"));
		List<Item> deleteItemList = itemService.findDeleteItem(user.getUsersId(), (Integer) session.getAttribute("incomeOutgo"));
		model.addAttribute("itemList", itemList);
		model.addAttribute("deleteItemList", deleteItemList);
	}

}

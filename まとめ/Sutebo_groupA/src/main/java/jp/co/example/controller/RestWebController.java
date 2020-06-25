/*package jp.co.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.example.entity.Money;
import jp.co.example.model.Event;
import jp.co.example.service.MoneyService;

@RestController
@RequestMapping("/api/event")
public class RestWebController {

    @Autowired
    private MoneyService moneyService;


    *//**
		* カレンダーに表示するEvent情報を取得
		* @return Event情報をjsonエンコードした文字列
		*//*
			@GetMapping(value = "/all")
			public String getEvents() {
			 String jsonMsg = null;
			 try {
			     List<Event> events = new ArrayList<Event>();
			     Event event = new Event();

			     Integer testId = 1;

			     List<Money> money = moneyService.findMoneyForCalendar(testId);

			     for (int i = 0; i < money.size(); i++){

			     String str = money.get(i).getAmount().toString();
			     String day= money.get(i).getInputDate().toString();

			     System.out.println(day);

			     event = new Event();
			     event.setTitle("\\"+str);
			     event.setStart(day);
			     events.add(event);

			     }

			//            event = new Event();
			//            event.setTitle(str2);
			//            event.setStart(day2);
			//            events.add(event);

			     // FullCalendarにエンコード済み文字列を渡す
			     ObjectMapper mapper = new ObjectMapper();
			     jsonMsg =  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(events);
			 } catch (IOException ioex) {
			     System.out.println(ioex.getMessage());
			 }
			 return jsonMsg;
			}

			}*/
package jp.co.example.model;

import org.apache.jasper.tagplugins.jstl.core.Url;

/**
 * FullCalendar用Event Object
 *
 * @see https://fullcalendar.io/docs/event_data/Event_Object/
 */
public class Event {

    private String title;
    private Url url;

    /**
     * カレンダーの開始日付
     */
    private String start;

    /**
     * カレンダーの終了日付
     */
    private String end;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getStart() {
        return start;
    }
    public void setStart(String start) {
        this.start = start;
    }
    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }
	public Url getUrl() {
		return url;
	}
	public void setUrl(Url url) {
		this.url = url;
	}


}


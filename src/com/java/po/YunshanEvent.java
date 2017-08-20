package com.java.po;

/**
 * YunshanEvent 事件类
 * @author iiip
 *
 */
public class YunshanEvent {
	
	private Integer eventId;
	private String eventName;
	private String eventDatetime;
	private String eventSummary;
	private String generalName;
	private String eventImageUrl;
	
	public YunshanEvent() {
		super();
	}

	public YunshanEvent(Integer eventId, String eventName,
			String eventDatetime, String eventSummary, String generalName,String eventImageUrl) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventDatetime = eventDatetime;
		this.eventSummary = eventSummary;
		this.generalName = generalName;
		this.eventImageUrl = eventImageUrl;
	}



	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDatetime() {
		return eventDatetime;
	}

	public void setEventDatetime(String eventDatetime) {
		this.eventDatetime = eventDatetime;
	}

	public String getEventSummary() {
		return eventSummary;
	}

	public void setEventSummary(String eventSummary) {
		this.eventSummary = eventSummary;
	}

	public String getGeneralName() {
		return generalName;
	}

	public void setGeneralName(String generalName) {
		this.generalName = generalName;
	}

	public String getEventImageUrl() {
		return eventImageUrl;
	}

	public void setEventImageUrl(String eventImageUrl) {
		this.eventImageUrl = eventImageUrl;
	}

}

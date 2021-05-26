package modelo;

public class Item {
	private String itemId;
	private String userId;
	private String title;
	private String body;
	public Item(String itemId, String userId, String title, String body) {
		super();
		this.itemId = itemId;
		this.userId = userId;
		this.title = title;
		this.body = body;
	}
	public String itemId() {
		return itemId;
	}
	public String userId() {
		return userId;
	}
	public String title() {
		return title;
	}
	public String body() {
		return body;
	}
	

	
}

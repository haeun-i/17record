package com.example.demo.domain;
import javax.persistence.*;

@Entity
public class Item {

	@Id
	@Column(name = "item_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;

	@Column(name = "item_image", unique = true)
	private String itemImage; // 아이템 사진 경로저장 
	
	@Column(name = "item_name", nullable = false, unique = true)
	private String itemName;

	@Column(name = "item_price", nullable = false, unique = true)
	private int itemPrice;

	@Column(name = "item_stock", nullable = false, unique = true)
	private int itemStock;

	@Column(name = "item_content", nullable = false)
	private String itemContent;

	@OneToOne
	@JoinColumn(name = "artist_id")
	private Artist artist;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemStock() {
		return itemStock;
	}

	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}

	public String getItemContent() {
		return itemContent;
	}

	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
}
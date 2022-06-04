package com.example.demo.domain;
import javax.persistence.*;

@Entity
public class Item {

	@Id
	@Column(name = "item_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(name = "item_name", nullable = false, unique = true)
	private String itemName;

	@Column(name = "item_price", nullable = false, unique = true)
	private String itemPrice;

	@Column(name = "item_stock", nullable = false, unique = true)
	private String itemStock;

	@Column(name = "item_content", nullable = false)
	private String itemContent;

	@OneToOne
	@JoinColumn(name = "locker_id")
	private Artist artist;
}
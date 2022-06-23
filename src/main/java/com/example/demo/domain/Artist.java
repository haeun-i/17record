package com.example.demo.domain;
import javax.persistence.*;

@Entity
public class Artist {

	@Id
	@Column(name = "artist_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long artistId;

	@Column(name = "artist_name", nullable = false, unique = true)
	private String artistName;

	@Column(name = "category", nullable = false)
	private String category;

	public Long getArtistId() {
		return artistId;
	}

	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	

	
}
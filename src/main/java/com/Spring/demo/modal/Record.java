package com.Spring.demo.modal;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "records")
public class Record {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "article_date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date date;
	@Column(name = "author")
	private String author;

	@Column(name = "preference")
	private String preference;

	@Column(name = "status")
	private boolean status;

	@Column(name = "published_on_connect")
	private boolean publishedOnConnect;

	@Column(name = "action")
	private String action;

	// New fields from RecordDTO
	@Column(name = "public_url")
	private String publicUrl;


	@Column(name = "access_category")
	private String accessCategory;

	@Column(name = "free_view_expiry")
	private LocalDate freeViewExpiry;

	@Column(name = "description")
	private String description;

	// You may need to store file paths or other identifiers instead of the actual files
	@Column(name = "feature_image_path")
	private String featureImagePath;

	@Column(name = "pdf_image_path")
	private String pdfImagePath;

	// Getter and setter for status field to display "Active" or "Inactive"

	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getStatus() {
		return "<span style='background-color: #47b349'>Active</span>";
	}

	public String getPublishedOnConnect() {
		return "<span style='background-color: #47b349'>Published</span>" ;
	}


	// Constructors, getters, and setters
}

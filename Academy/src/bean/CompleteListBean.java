package bean;

import java.sql.Date;

public class CompleteListBean {
	String id;
	int playlist_num;
	String category;
	String lecture_level;
	String lecture_image;
	String chapter_subject;
	Date complete_date;
	public Date getComplete_date() {
		return complete_date;
	}
	public void setComplete_date(Date complete_date) {
		this.complete_date = complete_date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPlaylist_num() {
		return playlist_num;
	}
	public void setPlaylist_num(int playlist_num) {
		this.playlist_num = playlist_num;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLecture_level() {
		return lecture_level;
	}
	public void setLecture_level(String lecture_level) {
		this.lecture_level = lecture_level;
	}
	public String getLecture_image() {
		return lecture_image;
	}
	public void setLecture_image(String lecture_image) {
		this.lecture_image = lecture_image;
	}
	public String getChapter_subject() {
		return chapter_subject;
	}
	public void setChapter_subject(String chapter_subject) {
		this.chapter_subject = chapter_subject;
	}
}

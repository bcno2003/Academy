package bean;

import java.sql.Date;

public class QAboardBean {
	int qaboard_num;
	int playlist_num;
	String lecture_level;
	String qaboard_name;
	String qaboard_content;
	Date qaboard_date;
	public int getQaboard_num() {
		return qaboard_num;
	}
	public void setQaboard_num(int qaboard_num) {
		this.qaboard_num = qaboard_num;
	}
	public int getPlaylist_num() {
		return playlist_num;
	}
	public void setPlaylist_num(int playlist_num) {
		this.playlist_num = playlist_num;
	}
	public String getLecture_level() {
		return lecture_level;
	}
	public void setLecture_level(String lecture_level) {
		this.lecture_level = lecture_level;
	}
	public String getQaboard_name() {
		return qaboard_name;
	}
	public void setQaboard_name(String qaboard_name) {
		this.qaboard_name = qaboard_name;
	}
	public String getQaboard_content() {
		return qaboard_content;
	}
	public void setQaboard_content(String qaboard_content) {
		this.qaboard_content = qaboard_content;
	}
	public Date getQaboard_date() {
		return qaboard_date;
	}
	public void setQaboard_date(Date qaboard_date) {
		this.qaboard_date = qaboard_date;
	}
	
}

package bean;

public class playListBean {
	
	int order_num; // DAO에서 ROWNUM으로 재정의한 플레이 번호 DB에서는 안씀.
	int playlist_num;
	String category;
	String lecture_level;
	String lecture_image;
	String chapter_subject;
	String chapter_url;
	String chapter_objectives;
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
	public String getChapter_url() {
		return chapter_url;
	}
	public void setChapter_url(String chapter_url) {
		this.chapter_url = chapter_url;
	}
	public String getChapter_objectives() {
		return chapter_objectives;
	}
	public void setChapter_objectives(String chapter_objectives) {
		this.chapter_objectives = chapter_objectives;
	}
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	
}

package entity;

public class Audio {
  private int id;
  //��������
  private String name;
  //��·��
  private String music;
  //��Ƶ·��
  private String video;
  //ͼƬ·��
  private String image;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMusic() {
	return music;
}
public void setMusic(String music) {
	this.music = music;
}
public String getVideo() {
	return video;
}
public void setVideo(String video) {
	this.video = video;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
@Override
public String toString() {
	return "Audio [id=" + id + ", name=" + name + ", music=" + music
			+ ", video=" + video + ", image=" + image + "]";
}
public Audio(int id, String name, String music, String video, String image) {
	super();
	this.id = id;
	this.name = name;
	this.music = music;
	this.video = video;
	this.image = image;
}
public Audio(String name, String music, String video, String image) {
	super();
	this.name = name;
	this.music = music;
	this.video = video;
	this.image = image;
}
public Audio() {
	super();
}
}

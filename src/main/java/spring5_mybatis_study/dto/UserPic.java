package spring5_mybatis_study.dto;

public class UserPic {
	private int id;
	private String name;
	private byte[] pic;
	private String bio;

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

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return String.format("UserPic [id=%s, name=%s, pic=%s, bio=%s]", id, name, pic.length, bio);
	}

}

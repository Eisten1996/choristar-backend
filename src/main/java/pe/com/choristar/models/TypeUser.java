package pe.com.choristar.models;

public class TypeUser {

	private String nameTypeUser;
	private String description;

	public TypeUser() {
		// TODO Auto-generated constructor stub
	}

	public TypeUser(String nameTypeUser, String description) {
		this.nameTypeUser = nameTypeUser;
		this.description = description;
	}

	public String getNameTypeUser() {
		return nameTypeUser;
	}

	public void setNameTypeUser(String nameTypeUser) {
		this.nameTypeUser = nameTypeUser;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

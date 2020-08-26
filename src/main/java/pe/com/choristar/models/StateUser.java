package pe.com.choristar.models;

public class StateUser {

	private String nameUser;
	private String description;

	public StateUser() {
		// TODO Auto-generated constructor stub
	}

	public StateUser(String nameUser, String description) {
		this.nameUser = nameUser;
		this.description = description;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

package pe.com.choristar.models;

public class TypeService {

	private String service;
	private String description;

	public TypeService() {
		// TODO Auto-generated constructor stub
	}

	public TypeService(String service, String description) {
		this.service = service;
		this.description = description;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

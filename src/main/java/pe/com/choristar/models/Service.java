package pe.com.choristar.models;

import java.util.Date;

public class Service {

	private String stateService;
	private Date dateHire;
	private Double price;
	private TypeService typeService;

	public Service() {
		// TODO Auto-generated constructor stub
	}

	public Service(String stateService, Date dateHire, Double price, TypeService typeService) {
		this.stateService = stateService;
		this.dateHire = dateHire;
		this.price = price;
		this.typeService = typeService;
	}

	public String getStateService() {
		return stateService;
	}

	public void setStateService(String stateService) {
		this.stateService = stateService;
	}

	public Date getDateHire() {
		return dateHire;
	}

	public void setDateHire(Date dateHire) {
		this.dateHire = dateHire;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

}

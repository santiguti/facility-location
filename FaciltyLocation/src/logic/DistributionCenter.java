package logic;


public class DistributionCenter {
	private String idLocal;
	private double latitude;
	private double longitude;
	private double totalCost;
	
	public DistributionCenter(String idLocal, double latitude, double longitude, double totalCost) {
		this.idLocal = idLocal;
		this.latitude = latitude;
		this.longitude = longitude;
		this.totalCost=totalCost;
	}
	

	public String getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(String idLocal) {
		this.idLocal = idLocal;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
}

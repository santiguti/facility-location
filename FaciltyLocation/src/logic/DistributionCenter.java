package logic;


public class DistributionCenter {
	private String _idLocal;
	private double _latitude;
	private double _longitude;
	private double _totalCost;

	public DistributionCenter(String idLocal, double latitude, double longitude, double totalCost) {
		_idLocal = idLocal;
		_latitude = latitude;
		_longitude = longitude;
		_totalCost=totalCost;
	}
	public void assignTotalCost(ListCustomer custumers) {
			for(Customer customer : custumers.getCustomers()) {
				int distance= Haversine.calculateDistance(getLongitude(),getLatitude(),
						customer.getLongitude(), customer.getLatitude());
			setTotalCost(getTotalCost()+distance);
		}
	}
	public String getIdLocal() {
		return _idLocal;
	}

	public double getLatitude() {
		return _latitude;
	}

	public double getLongitude() {
		return _longitude;
	}

	public double getTotalCost() {
		return _totalCost;
	}

	public void setTotalCost(double totalCost) {
		_totalCost = totalCost;
	}

}

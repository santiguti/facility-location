package logic;


public class Customer {
	private String _name;
	private double _latitude;
	private double _longitude;
	
	public Customer(String name, double latitude, double longitude) {
		_name = name;
		_latitude = latitude;
		_longitude = longitude;
	}

	public String getName() {
		return _name;
	}

	public double getLatitude() {
		return _latitude;
	}

	public double getLongitude() {
		return _longitude;
	}


		
	
}

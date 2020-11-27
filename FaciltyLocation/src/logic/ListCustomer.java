package logic;

import java.util.ArrayList;



public class ListCustomer {
	ArrayList<Customer> _customers;

	public ListCustomer() {
		this._customers =new ArrayList<Customer>();
	}
	
	public void addCustomer(String name, double latitude, double longitude) {
		_customers.add(new Customer(name, latitude, longitude));
	}
	
	public int size() {
		return _customers.size();	
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Customer> getCenters() {
		return (ArrayList<Customer>) _customers.clone();
	}
	
	
}

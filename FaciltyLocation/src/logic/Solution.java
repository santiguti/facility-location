package logic;

import java.util.ArrayList;

import logic.data.DistributionCenter;


public class Solution {
	//esta seria la solucion final que se mostraria
	private ArrayList<DistributionCenter> _centers;
	
	public Solution() {
		_centers = new ArrayList<DistributionCenter>();
	}
	
	public void addCenter(DistributionCenter center) {
		_centers.add(center);
	}
	
	public DistributionCenter getCenter(int c) {
		return _centers.get(c);	
	}
	
	public int size() {
		return _centers.size();	
	}
	
	public boolean include(DistributionCenter center) {
		return _centers.contains(center);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<DistributionCenter> getListCenters() {
		return (ArrayList<DistributionCenter>) _centers.clone();
	}
	
	
}

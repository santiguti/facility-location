package logic;

import java.util.ArrayList;


public class Solution {
	//esta seria la solucion final que se mostraria
	private ArrayList<DistributionCenter> _centers;
	
	public Solution() {
		_centers = new ArrayList<DistributionCenter>();
	}
	
	public void addCenter(DistributionCenter center) {
		_centers.add(center);
	}
	public int size() {
		return _centers.size();	
	}
	
	
}

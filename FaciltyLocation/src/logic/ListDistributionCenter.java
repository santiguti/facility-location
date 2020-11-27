package logic;

import java.util.ArrayList;


public class ListDistributionCenter {
	
	ArrayList<DistributionCenter> _centers;

	public ListDistributionCenter() {
		this._centers =new ArrayList<DistributionCenter>();
	}
	
	public void addDistributionCenter(String idLocal, double latitude,
			double longitude,double totalCost) {
		_centers.add(new DistributionCenter(idLocal, latitude, longitude, totalCost));	
	}

	public int size() {
		return _centers.size();	
	}
		@SuppressWarnings("unchecked")
	public ArrayList<DistributionCenter> getCenters() {
		return (ArrayList<DistributionCenter>) _centers.clone();
	}

}

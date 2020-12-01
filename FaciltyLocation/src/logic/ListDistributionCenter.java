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

	//	asignar costo total de atender a todos los clientes a cada centro de distribucion
	//  este metodo no estoy muy segura de donde iria
	public void assignTotalCost(ListCustomer custumers) {
		for(DistributionCenter center : _centers) {
			center.assignTotalCost(custumers);
		}
	}

	public int size() {
		return _centers.size();	
	}
	@SuppressWarnings("unchecked")
	public ArrayList<DistributionCenter> getCenters() {
		return (ArrayList<DistributionCenter>) _centers.clone();
	}

}

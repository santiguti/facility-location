package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Solver {
	//clase encargada de resolver el algoritmo goloso
	private Comparator<DistributionCenter> _comparador;
	private ListDistributionCenter _centers;
	private int _k;
	
//	private void assignTotalCost(DistributionCenter center, Customer customer) {
//		usar haversine
//		asignar costo total de atender a los clientes a los centros de distribucion
//      este metodo no estoy muy segura de donde iria
//	}
	
	public Solver(int k, Comparator<DistributionCenter> comparador, ListDistributionCenter listCenters){
		this._k =k;
		this._comparador = comparador;
		this._centers=listCenters;
		
	}
	
	public Solution solve()
	{
		Solution ret = new Solution();
		for(DistributionCenter center: orderedCenters())
		{
			if( ret.size() <= _k )//si no se pasa de los k centros posibles a abrir lo agrego como solucion
				ret.addCenter(center);
		}
		
		return ret;
	}
// ordena los centros de menor a mayor costo, segun el costo total de atender a todos los clientes
	private ArrayList<DistributionCenter> orderedCenters() {
		ArrayList<DistributionCenter> ret = _centers.getCenters();
		Collections.sort(ret, _comparador); 
		
		return ret;
	}
	
}

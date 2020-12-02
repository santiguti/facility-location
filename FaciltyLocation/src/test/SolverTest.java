package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import logic.data.ListCustomer;
import logic.data.ListDistributionCenter;
import logic.Solution;
import logic.Solver;

public class SolverTest {
	ListCustomer customers;
	ListDistributionCenter centers;
	
	@Before
	public void initialize() {
		customers= ListCustomer.readJSON("ListCustomer.JSON");
		
		centers= ListDistributionCenter.readJSON("ListDistributionCenters.JSON");
		
		centers.calculateTotalCost(customers);
 		
	}

	@Test (expected = IllegalArgumentException.class)
	public void solverByCostTest() {
		
		Solver solver= new Solver(centers, (uno, otro) -> uno.getTotalCost() - otro.getTotalCost());
		Solution solution =solver.solve(10);

		assertEquals(solution.getListCenters().get(0).getIdLocal(), "Local1");
		assertEquals(solution.getListCenters().get(1).getIdLocal(), "Local3");

	}
	
	@Test 
	public void solverByCostRightTest() {
		Solver solver= new Solver(centers, (uno, otro) -> uno.getTotalCost() - otro.getTotalCost());
		Solution solution =solver.solve(2);

		assertEquals(solution.getListCenters().get(0).getIdLocal(), "Local1");
		assertEquals(solution.getListCenters().get(1).getIdLocal(), "Local3");
	}


}

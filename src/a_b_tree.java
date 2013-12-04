
public class a_b_tree {
	
	public static void main(String[] argv){
		float alpha = Float.NEGATIVE_INFINITY;
		float beta = Float.POSITIVE_INFINITY;
		
		node E1 = new node("E1",0, null, null, null);
		node E2 = new node("E2",-2, null, null, null);
		node E3 = new node("E3",4, null, null, null);
		node E4 = new node("E4",8, null, null, null);
		node E5 = new node("E5",6, null, null, null);
		node E6 = new node("E6",1, null, null, null);
		node E7 = new node("E7",3, null, null, null);
		node E8 = new node("E8",-1, null, null, null);
		node E9 = new node("E9",0, null, null, null);
		node E10 = new node("E10",2, null, null, null);
		node E11 = new node("E11",5, null, null, null);
		node E12 = new node("E12",4, null, null, null);
		node E13 = new node("E13",-2, null, null, null);
		node E14 = new node("E14",3, null, null, null);
		node D1 = new node("D1",Float.POSITIVE_INFINITY, E1, E2, null);
		node D2 = new node("D2",Float.POSITIVE_INFINITY, E3, E4, null);
		node D3 = new node("D3",Float.POSITIVE_INFINITY, E5, E6, null);
		node D4 = new node("D4",Float.POSITIVE_INFINITY, E7, null, null);
		node D5 = new node("D5",Float.POSITIVE_INFINITY, E8, E9, null);
		node D6 = new node("D6",Float.POSITIVE_INFINITY, E10, E11, null);
		node D7 = new node("D7",Float.POSITIVE_INFINITY, E12, null, null);
		node D8 = new node("D8",Float.POSITIVE_INFINITY, E13, E14, null);
		node C1 = new node("C1",Float.NEGATIVE_INFINITY, D1, D2, null);
		node C2 = new node("C2",Float.NEGATIVE_INFINITY, D3, null, null);
		node C3 = new node("C3",Float.NEGATIVE_INFINITY, D4, D5, null);
		node C4 = new node("C4",Float.NEGATIVE_INFINITY, D6, null, null);
		node C5 = new node("C5",Float.NEGATIVE_INFINITY, D7, D8, null);
		node B1 = new node("B1",Float.POSITIVE_INFINITY, C1, C2, C3);
		node B2 = new node("B2",Float.POSITIVE_INFINITY, C4, C5, null);
		node A1 = new node("A1",Float.NEGATIVE_INFINITY, B1, B2, null);
		
		maxValue(A1, alpha, beta);
		System.out.println("\nFinished Expanding");
		System.out.println("Value of MaxNode A1 is " + A1.value);
		
	}

	public static float maxValue(node currentNode, float alpha, float beta){
		if (currentNode.child1 == null && currentNode.child2 == null && currentNode.child3 == null){
			return currentNode.value;
		}
		
		System.out.println("Expanding MaxNode " + currentNode.name + ": Alpha = " + alpha + " Beta = " + beta);
		currentNode.setValue(Float.NEGATIVE_INFINITY);
		
		if (currentNode.child1 != null){
			currentNode.setValue(Math.max(currentNode.value, minValue(currentNode.child1, alpha, beta)));
			alpha = Math.max(currentNode.value, alpha);
			if (currentNode.value >= beta){
				if (currentNode.child2 != null)
					System.out.println("Skipping expansion of node " + currentNode.child2.name + " because it can't make beta lower");
				if (currentNode.child3 != null)
					System.out.println("Skipping expansion of node " + currentNode.child3.name + " because it can't make beta lower");
				return currentNode.value;
			}
		}
	
		if (currentNode.child2 != null){
			System.out.println("Expanding MaxNode " + currentNode.name + ": Alpha = " + alpha + " Beta = " + beta);
			currentNode.setValue(Math.max(currentNode.value, minValue(currentNode.child2, alpha, beta)));
			alpha = Math.max(currentNode.value, alpha);
			if (currentNode.value >= beta){
				if (currentNode.child3 != null)
					System.out.println("Skipping expansion of node " + currentNode.child3.name + " because it can't make beta lower");
				return currentNode.value;
			}
		}
		
		if (currentNode.child3 != null){
			System.out.println("Expanding MaxNode " + currentNode.name + ": Alpha = " + alpha + " Beta = " + beta);
			currentNode.setValue(Math.max(currentNode.value, minValue(currentNode.child3, alpha, beta)));
			alpha = Math.max(currentNode.value, alpha);
			if (currentNode.value >= beta){
				return currentNode.value;
			}
		}
		
		return currentNode.value;
	}
	
	public static float minValue(node currentNode, float alpha, float beta){
		if (currentNode.child1 == null && currentNode.child2 == null && currentNode.child3 == null){
			return currentNode.value;
		}
		
		System.out.println("Expanding MinNode " + currentNode.name + ": Alpha = " + alpha + " Beta = " + beta);
		currentNode.setValue(Float.POSITIVE_INFINITY);
		
		if (currentNode.child1 != null){
			currentNode.setValue(Math.min(currentNode.value, maxValue(currentNode.child1, alpha, beta)));
			beta = Math.min(currentNode.value, beta);
			if (currentNode.value <= alpha){
				if (currentNode.child2 != null)
					System.out.println("Skipping expansion of node " + currentNode.child2.name + " because it can't make alpha higher");
				if (currentNode.child3 != null)
					System.out.println("Skipping expansion of node " + currentNode.child3.name + " because it can't make alpha higher");
				return currentNode.value;
			}
		}
		
		if (currentNode.child2 != null){
			System.out.println("Expanding MinNode " + currentNode.name + ": Alpha = " + alpha + " Beta = " + beta);
			currentNode.setValue(Math.min(currentNode.value, maxValue(currentNode.child2, alpha, beta)));
			beta = Math.min(currentNode.value, beta);
			if (currentNode.value <= alpha){
				if (currentNode.child3 != null)
					System.out.println("Skipping expansion of node " + currentNode.child3.name + " because it can't make alpha higher");
				return currentNode.value;
			}
		}
		
		if (currentNode.child3 != null){
			System.out.println("Expanding MinNode " + currentNode.name + ": Alpha = " + alpha + " Beta = " + beta);
			currentNode.setValue(Math.min(currentNode.value, maxValue(currentNode.child3, alpha, beta)));
			beta = Math.min(currentNode.value, beta);
			if (currentNode.value <= alpha){
				return currentNode.value;
			}
		}
	
		return currentNode.value;
	}
}

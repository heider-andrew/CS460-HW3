public class node {
	float value;
	String name;
	node child1;
	node child2;
	node child3;
	
	public node(String name, float value, node child1, node child2, node child3){
		this.value = value;
		this.child1 = child1;
		this.child2 = child2;
		this.child3 = child3;
		this.name = name;
	}
	
	public void setValue(float value){
		this.value = value;
	}
}

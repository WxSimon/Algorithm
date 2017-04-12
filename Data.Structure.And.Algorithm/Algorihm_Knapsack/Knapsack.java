package Algorihm_Knapsack;

/**
 * 背包问题:
 * 		 假设每个物品A.B...具有两个属性 1.重量(W) 2.价值(W)
 * 		 在给定的T重量呢如何获得最多价值
 * @author Wang
 *
 */
public class Knapsack {
	private int weight;
	private int value;
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public  Knapsack(int weight,int value){
		this.weight = weight;
		this.value = value;
	}
	@Override
	public String toString() {
		return "Knapsack [weight=" + weight + ", value=" + value + "]";
	}
	
}

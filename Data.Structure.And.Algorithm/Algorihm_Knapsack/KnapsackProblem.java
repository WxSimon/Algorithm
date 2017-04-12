package Algorihm_Knapsack;

import java.util.ArrayList;

/**
 * 背包问题求解
 * @author Wang
 *
 */
public class KnapsackProblem {
	//所有的背包
	private Knapsack[] bags;
	//总重量
	private int totalWeight;
	//背包数量
	private int n;
	// 前 n 个背包，总承重为 totalWeight 的最优值矩阵 
	//Eg:bestvalues[8][12]:前8个背包中总承重为12的最大价值
	//	 bestvalues[3][12]:前3个背包中总承重为12的最大价值
	private int[][] bestvalues;
	//前 n 个背包，总承重为 totalWeight 的最优值
	private int bestValue;
	//前 n 个背包，总承重为 totalWeight 的最优解的物品组成
	private ArrayList<Knapsack> bestSolution;
	
	public KnapsackProblem(Knapsack[] bags,int totalWeight){
		this.bags = bags;
		this.totalWeight = totalWeight;
		this.n = bags.length;
		if(bestvalues==null){
			bestvalues = new int[n+1][totalWeight+1];
		}
	}
	public void save(){
		//就是在totalWeight中依次(totalWeight=1,2,3..)最优的背包组成
 		for (int i = 0; i <= totalWeight; i++) {
   			for (int j = 0; j <= n; j++) {
				if(i==0 || j==0){ 
					bestvalues[j][i] =0;
				}
				else{
					//假如当前的重量比当前背包的重量小
					//意思就是当前背包的重量已经超过了总重量
					//那么最优矩阵就是在这个背包前一个了
					if(i<bags[j-1].getWeight()){
						bestvalues[j][i] = bestvalues[j-1][i];
					}
					else{
						int iweight = bags[j-1].getWeight();
						int ivalue = bags[j-1].getValue();
						bestvalues[j][i] = Math.max(bestvalues[j-1][i],ivalue+bestvalues[j-1][i-iweight]);
					}
				}
			}
		}
		if(bestSolution==null){
			bestSolution = new ArrayList<Knapsack>();
		}
		//找到最优价值是由那几个背包组成
		int tempWeight = totalWeight;
		for (int i = n; i >=1; i--) {
			if(bestvalues[i][tempWeight]>bestvalues[i-1][tempWeight]){
				bestSolution.add(bags[i-1]);
				tempWeight -=bags[i-1].getWeight();
			}
			if(tempWeight == 0){break;}
		}
		bestValue = bestvalues[n][totalWeight];
	}
	
	public static void main(String[] args) {
		Knapsack[] bags = new Knapsack[] {  
//                new Knapsack(2,13),
//                new Knapsack(1,10),  
//                new Knapsack(3,24), 
//                new Knapsack(2,15),  
//                new Knapsack(4,28), 
//                new Knapsack(5,33),  
//                new Knapsack(3,20),
//                new Knapsack(1, 8)  
				new Knapsack(2, 10),
				new Knapsack(3, 15),
				new Knapsack(2, 6),
				new Knapsack(2, 7),
				new Knapsack(4, 10)
        };  
		   int totalWeight = 5;  
		   KnapsackProblem kp = new KnapsackProblem(bags, totalWeight); 
		   kp.save();
		   System.out.println("最高的价值为:"+kp.bestValue);
		   for (int i = 0; i <=kp.n; i++) {
			for (int j = 0; j <=kp.totalWeight; j++) {
				System.out.println("前 "+i+"个背包装  "+j+" 重量的最大的价值为:"+kp.bestvalues[i][j]);
			}
		}
		   for (Knapsack knapsack : kp.bestSolution) {
			System.out.println(knapsack.toString());
		}
	}
}

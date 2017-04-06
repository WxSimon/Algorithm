package com.simon.mianshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Test {
		public static void main(String[] args) {
			// 总数
			int count;
			// 能带走的总重量
			int takeCountWeight;

			Scanner sc = new Scanner(System.in);
			List<wuping> list = new ArrayList<wuping>();
			count = sc.nextInt();
			if (count != 0) {
				// 输入价值
				for (int i = 0; i < count; i++) {
					wuping w = new wuping();
					w.setCost(sc.nextInt());
					list.add(w);
				}
				// 输入重量
				for (int i = 0; i < count; i++) {
					list.get(i).setWeight(sc.nextInt());
				}
				takeCountWeight = sc.nextInt();
				System.out.println(MaxCost(list, takeCountWeight));
			}
		}

		// 计算最大价值
		private static int MaxCost(List<wuping> list, int takeCountWeight) {
			if (list != null) {
				LinkedHashMap<Integer, jiazhi> map = new LinkedHashMap<Integer, jiazhi>();
				for (wuping wuping : list) {
					jiazhi j = new jiazhi();
					j.setCost(wuping.getCost());
					j.setJisuan((wuping.getWeight() / wuping.getCost()));
					map.put(wuping.getWeight(), j);
				}
				Set<Entry<Integer, jiazhi>> entrySet = map.entrySet();
				ArrayList<Entry<Integer, jiazhi>> mapList = new ArrayList<Entry<Integer, jiazhi>>(
						entrySet);
				Collections.sort(mapList, new Comparator<Entry<Integer, jiazhi>>() {
					public int compare(Entry<Integer, jiazhi> o1,
							Entry<Integer, jiazhi> o2) {
						return o1.getValue().getJisuan()
								- o2.getValue().getJisuan();
					};
				});
				int currentWeight = 0;
				int totalCost = 0;
				for (int i = 0; i < mapList.size(); i++) {
					if (currentWeight < takeCountWeight) {
						currentWeight += mapList.get(i).getKey();
						if (currentWeight <= takeCountWeight) {
							totalCost += mapList.get(i).getValue().getCost();
						} else {
							currentWeight -= mapList.get(i).getKey();
						}
					}
				}
				return totalCost;
			}
			else{
				return 0;
			}
		}

	}

	class wuping {
		int cost;
		int weight;

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}
	}

	class jiazhi {
		int cost;
		int jisuan;

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}

		public int getJisuan() {
			return jisuan;
		}

		public void setJisuan(int jisuan) {
			this.jisuan = jisuan;
		}

}

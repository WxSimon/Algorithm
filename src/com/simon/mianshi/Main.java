package com.simon.mianshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class Main {
	public static int main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] s1 =s.split(",");
		int[] i = new int[s1.length];
		for (int j = 0; j < i.length; j++) {
			i[j] =Integer.parseInt(s1[j]);
		}
		int cost = sc.nextInt();
		for (int j = 0; j < i.length; j++) {
			if(i[j]>cost){
				return -1;
			}
		}
		return 0;
	}
}


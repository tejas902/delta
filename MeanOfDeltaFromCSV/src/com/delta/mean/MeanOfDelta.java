package com.delta.mean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MeanOfDelta {

	
	public static double compute(String exp, double a) {
		double res = 0;
		int len = exp.length();
		String s = exp.substring(0, len-1);
		String[] s1 = s.split(" ");
		double c = Double.parseDouble(s1[0]);
		double n = Double.parseDouble(s1[2]);
		double nx = n * a;
		if(s1[1].equalsIgnoreCase("+")) {
			res = c + nx;
		}else {
			res = c - nx;
		}
		
		return res;
	}

	public static void main(String[] args) {

		int count = 0;
		int sum = 0;
		Double delta = 0.0;
		List<Double> deltaSquare = new ArrayList<Double>();
		BufferedReader br = null;

		try {
			if (args[0] != null && args[1]!= null) {
				br = new BufferedReader(new FileReader(args[0]));
				String exp = args[1];
								
				String line = null;
				while ((line = br.readLine()) != null) {

					String[] data = line.split(",");

					if (!data[0].equalsIgnoreCase("x")) {
						double x = Integer.parseInt(data[0]);
						double y = Integer.parseInt(data[1]);
						double y1 = compute(exp,x);
						double ds = y1-y;
						deltaSquare.add(ds * ds);
						count++;
					}
				}

				
				for (Double delSqr : deltaSquare) {
					delSqr = sum + delSqr;
					delta = delSqr;

				}

				double meanDelta = (double) (delta / count);
				System.out.println("final Result is: " + meanDelta);

				br.close();
			}
		} catch (Exception e) {

		}

	}



}

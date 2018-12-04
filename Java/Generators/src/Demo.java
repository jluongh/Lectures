import java.util.ArrayList;

public class Demo {
	public static void main(String[] args) {

		// // Print ints from 1-1000 using loop over RangeGenerator
		// for (Integer i : new RangeGenerator(1, 1000, 1)) {
		// System.out.println(i);
		// }
		//
		// System.out.println("----------------------------------------");
		//
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for (Integer i = 0; i < 1000; i++) {
			ints.add(i);
		}

		Iterable<Integer> filter = new FilterGenerator<Integer>(i -> i % 2 == 1, ints);
		Iterable<Double> map = new MapGenerator<Integer, Double>(i -> Math.sqrt(i), filter);
		Iterable<Double> skip = new SkipGenerator<Double>(2, map);
		Iterable<Double> take = new TakeWhileGenerator<Double>(i -> i < 5, skip);

//		for (Integer i : filter) {
//			System.out.println(i);
//		}
		
//		for (Double d : map) {
//			System.out.println(d);
//		}

//		 System.out.println("----------------------------------------");
//
		for (Double d : take) {
			System.out.println(d);
		}

		
		// for (Integer i : new SkipGenerator<Integer>(5, new RangeGenerator(1, 1000,
		// 5))) {
		// System.out.println(i);
		// }

		// for (Integer i : new FilterGenerator<Integer>(i -> i % 2 == 1, new
		// RangeGenerator(1, 1000, 5))) {
		// System.out.println(i);
		// }

//		 for (Integer i : new TakeWhileGenerator<Integer>(i -> i < 26 || i > 26,
//		 new RangeGenerator(1, 1000, 5))) {
//		 System.out.println(i);
//		 }

		// for (Double i : new MapGenerator<Integer, Double>(i -> Math.sqrt(i), new
		// RangeGenerator(1, 10, 1))) {
		// System.out.println(i);
		// }
		System.out.println("DONE");
	}
}

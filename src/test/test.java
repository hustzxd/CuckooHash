package test;

import java.util.Random;

public class test {
	public static void main(String[] args) {

		int space = 1000;
		CuckooHashMap2.CuckooHashMap.DEFAULT_INITIAL_CAPACITY = space;

		int test_counter = 100;
		float average_1 = 0;
		float average_2 = 0;
		long insert_time1 = 0;
		long insert_time2 = 0;
		long find_time1 = 0;
		long find_time2 = 0;
		
		System.out.println();
		long startMili;
		long endMili;
			CuckooHashMap.CuckooHashMap<Integer, String> map1 = 
					new CuckooHashMap.CuckooHashMap<Integer, String>();
			for (int i = 0; i < num; i++) {
				Integer key = new Random().nextInt(num * 100);
				String val = "Value_" + i;
				startMili = System.currentTimeMillis();
				map1.put(key, val);
				endMili = System.currentTimeMillis();
				insert_time1 +=(endMili-startMili);
			}
			for(int i =0 ;i<num;i++){
				startMili = System.currentTimeMillis();
				map1.get(new Random().nextInt(num * 100));
				endMili = System.currentTimeMillis();
				find_time1 += (endMili - startMili);
			}
			average_1 += (map1.size() / (float) num);
		}
		average_1 = 1 - average_1 / test_counter;
//		find_time1 /= (float)test_counter;
		System.out.println("slot = 1:");

		
		System.out.println();
		
			CuckooHashMap2.CuckooHashMap<Integer, String> map2 = 
					new CuckooHashMap2.CuckooHashMap<Integer, String>();
			for (int i = 0; i < num; i++) {
				Integer key = new Random().nextInt(num * 100);
				String val = "Value_" + i;
				startMili = System.currentTimeMillis();
				map2.put(key, val);
				endMili = System.currentTimeMillis();
				insert_time2 += (endMili-startMili);
			}
			average_2 += (map2.size() / (float) num);
			for(int i =0 ;i<num;i++){
				startMili = System.currentTimeMillis();
				map2.get(new Random().nextInt(num * 100));
				endMili = System.currentTimeMillis();
				find_time2 += (endMili - startMili);
			}
		}
		average_2 = 1 - average_2 / test_counter;
		System.out.println("slot = 4:");
	}
}

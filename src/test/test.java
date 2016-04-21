package test;

import java.util.Random;

public class test {
	public static void main(String[] args) {

		int space = 1000;
		CuckooHashMap.CuckooHashMap.DEFAULT_INITIAL_CAPACITY = space;
		CuckooHashMap2.CuckooHashMap.DEFAULT_INITIAL_CAPACITY = space;
		int num = (int) (space * 0.9);

		int test_counter = 100;
		float average_1 = 0;
		float average_2 = 0;
		long insert_time1 = 0;
		long insert_time2 = 0;
		long find_time1 = 0;
		long find_time2 = 0;
		
		System.out.println("总空间： " + space);
		System.out.println("插入数据个数： " + num);
		System.out.println("测试次数： " + test_counter);
		System.out.println();
		long startMili;
		long endMili;
		for (int j = 0; j < test_counter; j++) {
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
		System.out.println("平均冲突率: " + average_1);
		System.out.println("插入时间： " + (insert_time1) + " ms");
		System.out.println("查找时间： "+find_time1+" ms");

		
		System.out.println();
		
		for (int j = 0; j < test_counter; j++) {
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
		System.out.println("平均冲突率: " + average_2);
		System.out.println("插入时间：" + (insert_time2) + " ms");
		System.out.println("查找时间： "+find_time2+" ms");
	}
}

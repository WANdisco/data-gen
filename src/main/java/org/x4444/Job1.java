package org.x4444;

import spark.api.java.JavaRDD;
import spark.api.java.JavaSparkContext;
import spark.api.java.function.Function;

public class Job1 {

	public static void main(String[] args) {
		//String df = "/home/alexp/data1/file1";
		String df = args[0];
		String sparkHome = System.getenv("SPARK_HOME");
		String master = System.getenv("MASTER");
		String jar = args[1];

		System.out.println("master: " + master);
		System.out.println("sparkHome: " + sparkHome);
		JavaSparkContext sc = new JavaSparkContext(master, "Job1", sparkHome,
				jar);
		JavaRDD<String> rdd = sc.textFile(df);

		long verizonCnt = rdd.filter(new Function<String, Boolean>() {

			@Override
			public Boolean call(String s) throws Exception {
				return s.contains("Verizon");
			}
		}).count();
		System.out.println("Verizon: " + verizonCnt);

		long attCnt = rdd.filter(new Function<String, Boolean>() {

			@Override
			public Boolean call(String s) throws Exception {
				return s.contains("ATT");
			}
		}).count();
		System.out.println("ATT: " + attCnt);
	}
}

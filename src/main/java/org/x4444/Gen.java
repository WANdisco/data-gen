package org.x4444;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Gen {

	static Random r = new Random();
	static String[] comp = new String[] { "Verizon", "ATT", "Sprint",
			"Verizon", "ATT", "Verizon", "ATT", "Verizon", "Verizon" };
	static char sep = (char) 1;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		String file;
		if (args.length == 0) {
			file = "file1";
		} else {
			file = args[0];
		}
		PrintWriter pw = new PrintWriter(file);
		try {
			for (int j = 0; j < 100000000; j++) {
				sb.setLength(0);

				for (int i = 0; i < 10; i++) {
					int d1 = r.nextInt(10);
					sb.append(d1);
				}
				sb.append(sep);

				int cidx = r.nextInt(comp.length);
				String c = comp[cidx];
				sb.append(c);
				pw.println(sb.toString());
			}
		} finally {
			pw.flush();
			pw.close();
		}
	}
}

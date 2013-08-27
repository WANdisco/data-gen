package org.x4444;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.IOUtils;

public class Table2 {

  static Random r = new Random();
  static List<String> words;
  static {
    words = readFile("words.txt");
  }
  
  static List<String> words20;
  static {
    words20 = readFile("words20.txt");
  }

  static String[] locations = new String[] { "Unknown", "Location_33101",
      "Location_33102", "Location_30453", "Location_33104", "Location_33105",
      "Location_33106", "Location_33107", "Location_33108", "Location_33109" };

  static char sep = (char) 1;

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    String file;
    if (args.length == 0) {
      file = "table2";
    } else {
      file = args[0];
    }
    PrintWriter pw = new PrintWriter(file);
    try {
      for (int j = 0; j < 1000000; j++) {
        sb.setLength(0);

        // col1
        sb.append(getStringCol(words)).append(sep);
        // col2
        sb.append(getStringCol(words)).append(sep);
        // col3
        sb.append(getStringCol(words)).append(sep);
        // col4
        sb.append(getLocation()).append(sep);
        // col5
        sb.append(getStringCol(words20)).append(sep);
        // col6
        sb.append(getStringCol(words20)).append(sep);
        // dt
        sb.append(getDt());

        pw.println(sb.toString());
      }
    } finally {
      pw.flush();
      pw.close();
    }
  }

  static int getIntCol() {
    return r.nextInt(2000000);
  }

  static String getStringCol(List<String> li) {
    int idx = r.nextInt(li.size());
    String w = li.get(idx);
    return w;
  }

  static String getLocation() {
    int idx = r.nextInt(locations.length);
    String w = locations[idx];
    return w;
  }

  static long now = 1373221800000L;

  static String getDt() {
    long v = now - r.nextInt(1000);
    return Long.toString(v);
  }

  static String getNumString(int len) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; i++) {
      int d1 = r.nextInt(10);
      sb.append(d1);
    }
    return sb.toString();
  }

  static List<String> readFile(String name) {
    try {
      InputStream is = Table2.class.getResourceAsStream(name);
      @SuppressWarnings("unchecked")
      List<String> lines = IOUtils.readLines(is);
      is.close();
      return lines;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}

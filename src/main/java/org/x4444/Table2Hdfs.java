package org.x4444;

import java.util.List;

public class Table2Hdfs extends AbsTableHdfs {

  List<String> words;
  List<String> words20;

  String[] locations = new String[] { "Unknown", "Location_33101",
      "Location_33102", "Location_30453", "Location_33104", "Location_33105",
      "Location_33106", "Location_33107", "Location_33108", "Location_33109" };

  public Table2Hdfs() {
    words = readFile("/words.txt");
    words20 = readFile("/words20.txt");
    defaultFilePathStr = "table2";
  }

  public static void main(String[] args) throws Exception {
    Table2Hdfs o = new Table2Hdfs();
    o.runToolRunner(args);
  }

  @Override
  protected void fillLine(StringBuilder sb) {
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
  }

  protected String getLocation() {
    int idx = r.nextInt(locations.length);
    String w = locations[idx];
    return w;
  }
}

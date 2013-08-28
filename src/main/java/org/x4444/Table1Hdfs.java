package org.x4444;

import java.util.List;

public class Table1Hdfs extends AbsTableHdfs {

  List<String> words20;

  public Table1Hdfs() {
    words20 = readFile("/words20.txt");
    defaultFilePatStr = "table1";
  }

  public static void main(String[] args) throws Exception {
    Table1Hdfs o = new Table1Hdfs();
    o.runToolRunner(args);
  }

  @Override
  protected void fillLine(StringBuilder sb) {
    // col1
    sb.append(getIntCol()).append(sep);
    // col2
    sb.append(getIntCol()).append(sep);
    // col3
    sb.append(getIntCol()).append(sep);
    // col4
    sb.append(getStringCol(words20)).append(sep);
    // col5
    sb.append(getStringCol(words20)).append(sep);
    // col6
    sb.append(getStringCol(words20)).append(sep);
    // col7
    sb.append(getIntCol()).append(sep);
    // col8
    sb.append(getIntCol()).append(sep);
    // dt
    sb.append(getDt());
  }
}

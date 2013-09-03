package org.x4444;

import java.util.List;

public class TableBHdfs extends AbsTableHdfs {

  List<String> words20;

  public TableBHdfs() {
    words20 = readFile("/words20.txt");
    defaultFilePathStr = "tableA";
  }

  public static void main(String[] args) throws Exception {
    TableBHdfs o = new TableBHdfs();
    o.runToolRunner(args);
  }

  @Override
  protected void fillLine(StringBuilder sb) {
    sb.append("A").append(sep);
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

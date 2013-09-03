package org.x4444;

import java.util.List;

public class Table51 extends AbsTableHdfs {

  List<String> words20;

  public Table51() {
    words20 = readFile("/words20.txt");
    defaultFilePathStr = "Table51";
    defaultRowN=100000;
  }

  public static void main(String[] args) throws Exception {
    Table51 o = new Table51();
    o.runToolRunner(args);
  }

  @Override
  protected void fillLine(StringBuilder sb) {
    // Table51_col1 - join
    sb.append(getStringCol(words20)).append(sep);
    // Table51_col3 - join
    sb.append(getStringCol(words20)).append(sep);
    // Col51_1_1
    sb.append(getStringCol(words20)).append(sep);
  }
}

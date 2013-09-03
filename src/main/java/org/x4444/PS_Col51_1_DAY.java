package org.x4444;

import java.util.List;

public class PS_Col51_1_DAY extends AbsTableHdfs {

  List<String> words20;

  public PS_Col51_1_DAY() {
    words20 = readFile("/words20.txt");
    defaultFilePathStr = "PS_Col51_1_DAY";
  }

  public static void main(String[] args) throws Exception {
    PS_Col51_1_DAY o = new PS_Col51_1_DAY();
    o.runToolRunner(args);
  }

  @Override
  protected void fillLine(StringBuilder sb) {
    // Table31_col1
    sb.append(getStringCol(words20)).append(sep);
    // Table51_col2 - join
    sb.append(getStringCol(words20)).append(sep);
    for (int i = 0; i < 18; i++) {
      // col1-col18
      sb.append(getIntCol()).append(sep);
    }
    // Col51_1_2
    sb.append(getStringCol(words20)).append(sep);
    // Col51_1_3
    sb.append(getStringCol(words20)).append(sep);
    // test_Col51
    sb.append(getIntCol()).append(sep);
    // CELL_SAC - join
    sb.append(getStringCol(words20)).append(sep);
  }
}

package org.x4444;

import java.util.List;

public class Tab2 extends AbsTableHdfs {

  List<String> words20;

  public Tab2() {
    words20 = readFile("/words20.txt");
    defaultFilePathStr = "tab2";
  }

  public static void main(String[] args) throws Exception {
    Tab2 o = new Tab2();
    o.runToolRunner(args);
  }

  @Override
  protected void fillLine(StringBuilder sb) {
    // 1-4
    for (int i = 0; i < 4; i++) {
      sb.append(getStringCol(words20)).append(sep);
    }
    // 5-6
    sb.append(getLongCol()).append(sep);
    sb.append(getLongCol()).append(sep);

    // 7-8
    sb.append(getStringCol(words20)).append(sep);
    sb.append(getStringCol(words20)).append(sep);

    // 9
    sb.append(getDoubleCol()).append(sep);

    // 10-25
    for (int i = 0; i < 16; i++) {
      sb.append(getStringCol(words20)).append(sep);
    }
    // 26-27
    sb.append(getDoubleCol()).append(sep);
    sb.append(getDoubleCol()).append(sep);

    // 28
    sb.append(getStringCol(words20)).append(sep);

    // 29
    sb.append(getIntCol()).append(sep);
  }
}

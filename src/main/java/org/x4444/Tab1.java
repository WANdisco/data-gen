package org.x4444;

import java.util.List;

public class Tab1 extends AbsTableHdfs {

  List<String> words20;

  public Tab1() {
    words20 = readFile("/words20.txt");
    defaultFilePathStr = "tab1";
  }

  public static void main(String[] args) throws Exception {
    Tab1 o = new Tab1();
    o.runToolRunner(args);
  }

  @Override
  protected void fillLine(StringBuilder sb) {
    // 1 timestamp
    sb.append(getTimestamp()).append(sep);
    // 2-4
    for (int i = 0; i < 3; i++) {
      sb.append(getStringCol(words20)).append(sep);
    }
    // 5-6
    sb.append(getIntCol()).append(sep);
    sb.append(getIntCol()).append(sep);
    // 7-15
    for (int i = 0; i < 9; i++) {
      sb.append(getStringCol(words20)).append(sep);
    }
    // 16-17
    sb.append(getIntCol()).append(sep);
    sb.append(getIntCol()).append(sep);
    // 18
    sb.append(getStringCol(words20)).append(sep);
    // 19-20
    sb.append(getIntCol()).append(sep);
    sb.append(getIntCol()).append(sep);
    // 21-25
    for (int i = 0; i < 5; i++) {
      sb.append(getStringCol(words20)).append(sep);
    }
    // 26
    sb.append(getLongCol()).append(sep);
    // col_27
    sb.append(getDoubleCol()).append(sep);
    // 28-31
    for (int i = 0; i < 4; i++) {
      sb.append(getStringCol(words20)).append(sep);
    }
    // 32-43
    for (int i = 0; i < 12; i++) {
      sb.append(getDoubleCol()).append(sep);
    }
    // 44-47
    for (int i = 0; i < 4; i++) {
      sb.append(getLongCol()).append(sep);
    }
    // 48-69
    for (int i = 0; i < 22; i++) {
      sb.append(getDoubleCol()).append(sep);
    }

    // 70-71
    for (int i = 0; i < 2; i++) {
      sb.append(getLongCol()).append(sep);
    }

    // 72-84
    for (int i = 0; i < 13; i++) {
      sb.append(getDoubleCol()).append(sep);
    }

    // 85-99
    for (int i = 0; i < 15; i++) {
      sb.append(getLongCol()).append(sep);
    }

    // 100- 103
    for (int i = 0; i < 4; i++) {
      sb.append(getDoubleCol()).append(sep);
    }

    // 104-106
    for (int i = 0; i < 3; i++) {
      sb.append(getLongCol()).append(sep);
    }

    // 107
    sb.append(getDoubleCol()).append(sep);

    // 108-119
    for (int i = 0; i < 11; i++) {
      sb.append(getLongCol()).append(sep);
    }
    sb.append(getLongCol());
  }
}

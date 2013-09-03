package org.x4444;


public class TableAHdfs extends AbsTableHdfs {

  char c = 65;

  public TableAHdfs() {
    defaultFilePathStr = "tableB";
    defaultRowN = 10;
  }

  public static void main(String[] args) throws Exception {
    TableAHdfs o = new TableAHdfs();
    o.runToolRunner(args);
  }

  @Override
  protected void fillLine(StringBuilder sb) {
    String s = Character.toString(c);
    c++;
    sb.append(s).append(sep);
    // col1
    sb.append("Letter " + s);
  }
}

package org.x4444;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public abstract class AbsTableHdfs extends Configured implements Tool {

  protected Random r = new Random();
  protected long now = 1373221800000L;
  protected int maxInt = 2000000;
  protected String defaultFilePathStr = "testtable";
  protected long defaultRowN = 1000000L;
  FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss.SSS");

  static final char sep = (char) 1;

  protected AbsTableHdfs() {
  }

  protected int getIntCol() {
    return r.nextInt(maxInt);
  }

  protected long getLongCol() {
    return r.nextLong();
  }

  protected double getDoubleCol() {
    return r.nextDouble() * 1000000D;
  }

  protected String getStringCol(List<String> list) {
    int idx = r.nextInt(list.size());
    String w = list.get(idx);
    return w;
  }

  protected String getDt() {
    long v = now - r.nextInt(1000);
    return Long.toString(v);
  }

  protected String getNumString(int len) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; i++) {
      int d1 = r.nextInt(10);
      sb.append(d1);
    }
    return sb.toString();
  }

  protected String getTimestamp() {
    long v = now - r.nextInt(1000);
    String d = fdf.format(v);
    return d;
  }

  protected List<String> readFile(String name) {
    try {
      InputStream is = AbsTableHdfs.class.getResourceAsStream(name);
      @SuppressWarnings("unchecked")
      List<String> lines = IOUtils.readLines(is);
      is.close();
      return lines;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int run(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    String filePathStr;
    if (args.length == 0) {
      filePathStr = defaultFilePathStr;
    } else {
      filePathStr = args[0];
    }

    long rows = defaultRowN;
    if (args.length >= 2) {
      rows = Long.parseLong(args[1]);
    }
    System.err.println("file: " + filePathStr);
    System.err.println("rows: " + rows);

    Path filePath = new Path(filePathStr);

    Configuration conf = getConf();
    System.out.println(conf);
    assert conf != null;
    URI uri = FileSystem.getDefaultUri(conf);
    System.out.println(uri);
    assert uri.toString().startsWith("hdfs://");
    FileSystem fs = FileSystem.get(conf);
    fs.delete(filePath, true);
    System.out.println("deleted: " + filePathStr);
    FSDataOutputStream os = FileSystem.create(fs, filePath,
        FsPermission.getDefault());
    OutputStream oss = os.getWrappedStream();

    try {
      for (int j = 0; j < rows; j++) {
        sb.setLength(0);
        fillLine(sb);
        sb.append('\n');

        oss.write(sb.toString().getBytes());
      }
    } finally {
      oss.flush();
      os.flush();
      os.close();
    }
    return 0;
  }

  protected abstract void fillLine(StringBuilder sb);

  protected void runToolRunner(String[] args) throws Exception {
    long t = System.currentTimeMillis();
    ToolRunner.run(this, args);
    t = System.currentTimeMillis() - t;
    System.out.println("Time taken: " + t / 1000 + " sec");
  }
}

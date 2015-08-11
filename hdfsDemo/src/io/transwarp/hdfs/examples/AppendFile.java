package io.transwarp.hdfs.examples;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class AppendFile {
	public static void main(String[] args) throws IOException {
		Path p = new Path("/tmp/yarn-site.xml");
		Configuration conf = new Configuration();
		FileSystem fs = p.getFileSystem(conf);
		fs.setReplication(p, (short) 1);
		OutputStream out = fs.append(p);
		InputStream in = new BufferedInputStream(new FileInputStream(
				"conf/hdfs-site.xml"));
		IOUtils.copyBytes(in, out, conf);
		fs.close();
		IOUtils.closeStream(in);
	}
}

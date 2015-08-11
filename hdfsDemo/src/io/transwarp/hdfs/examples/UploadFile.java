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

public class UploadFile {
	public static void main(String[] args) throws IOException {
		Configuration conf = new Configuration();
		String localFile = "conf/yarn-site.xml";
		InputStream in = new BufferedInputStream(new FileInputStream(localFile));
		Path p = new Path( "/tmp/yarn-site.xml");
		FileSystem fs = p.getFileSystem(conf);
		OutputStream out = fs.create(p);
		IOUtils.copyBytes(in, out, conf);
		fs.close();
		IOUtils.closeStream(in);
	}
}

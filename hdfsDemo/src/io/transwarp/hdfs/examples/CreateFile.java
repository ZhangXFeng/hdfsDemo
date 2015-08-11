package io.transwarp.hdfs.examples;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class CreateFile {
	public static void main(String[] args) throws IOException {
		String rootPath = "hdfs://nameservice1";
		Path p = new Path(rootPath + "/tmp/newFile/file.txt");
		Configuration conf = new Configuration();
		FileSystem fs = p.getFileSystem(conf);
		fs.create(p);
		fs.close();
	}
}

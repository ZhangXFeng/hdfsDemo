package io.transwarp.hdfs.examples;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class Delete {
	public static void main(String[] args) {
		String rootPath = "hdfs://nameservice1";
		Path p = new Path(rootPath + "/tmp/newFile/file.txt");
		Configuration conf = new Configuration();
		try {
			FileSystem fs = p.getFileSystem(conf);
			boolean b = fs.delete(p, true);
			System.out.println(b);
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package io.transwarp.hdfs.examples;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;

public class CreateDir {
	public static void main(String[] args) throws IOException {
		String rootPath = "hdfs://nameservice1"; 
		Path p = new Path(rootPath + "/tmp/user/newDir3");
		
		Configuration conf = new Configuration();
		FileSystem fs = p.getFileSystem(conf);
		boolean b = fs.mkdirs(p);
		System.out.println(b);
		fs.close();
	}
}

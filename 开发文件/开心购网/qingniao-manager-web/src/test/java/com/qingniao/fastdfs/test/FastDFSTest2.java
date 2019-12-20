package com.qingniao.fastdfs.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import com.qingniao.utils.FastDFSClient;

public class FastDFSTest2 {

	public static void main(String[] args) throws Exception {
		
		FastDFSClient fastDFSClient = new FastDFSClient("D:\\8101-project\\qingniao-manager-web\\src\\main\\resources\\resource\\client.conf");
		String file = fastDFSClient.uploadFile("E:/BluceLee/2.jpg");
		System.out.println(file);
		
	}
}

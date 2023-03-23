package com.ldsg.jwsystem.utils;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.web.multipart.MultipartFile;

import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class FileUtils {

	public static String uploadFile(MultipartFile uploadFile, String savePath) throws IllegalStateException, IOException {
		// 存储目录是否存在，不存在就创建
		File uploadDir = new File(savePath);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		// 文件名称
		String fileName = uploadFile.getOriginalFilename();
		// 文件全路径
		File filePath = new File(uploadDir, fileName);
		// 上传文件
		uploadFile.transferTo(filePath);
		return filePath.getAbsolutePath();
	}
	
	public static String encodeDownloadFilename(String filename, String agent) throws IOException {
		if (agent.contains("Firefox")) { // 火狐浏览器
			filename = "=?UTF-8?B?" + new BASE64Encoder().encode(filename.getBytes("utf-8")) + "?=";
			filename = filename.replaceAll("\r\n", "");
		} else { // IE及其他浏览器
			filename = URLEncoder.encode(filename, "utf-8");
			filename = filename.replace("+", " ");
		}
		return filename;
	}
}

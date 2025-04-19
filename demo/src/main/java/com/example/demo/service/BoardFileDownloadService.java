package com.example.demo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class BoardFileDownloadService {

	public void boardFileDownload(String fileName, String originName, String filePath, HttpServletResponse response)
			throws Exception {

		String uploadDir = filePath;
		File file = new File(uploadDir + fileName);

		if (file.exists()) {
			response.setContentType("application/octet-stream");

			String encodedFileName = URLEncoder.encode(originName, "UTF-8").replaceAll("\\+", "%20");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedFileName + "\"");
			response.setHeader("Content-Transfer-Encoding", "binary");

			FileInputStream fis = new FileInputStream(file);
			OutputStream os = response.getOutputStream();

			byte[] buffer = new byte[1024];
			int bytesRead;

			while ((bytesRead = fis.read(buffer)) != -1) {
				os.write(buffer, 0, bytesRead);
			}

			fis.close();
			os.close();

		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}

	}
}
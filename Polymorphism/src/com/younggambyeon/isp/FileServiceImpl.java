package com.younggambyeon.isp;

public class FileServiceImpl implements FileService {

	@Override
	public void readFile(String filePath) {
		System.out.println(filePath + " 의 파일을 읽었습니다.");
	}

}

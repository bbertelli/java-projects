package br.com.atmdigital.crmapi.service;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	public void upload(MultipartFile file, String fileName) throws Exception;
	
	public File download(String fileName) throws FileNotFoundException;
	

}

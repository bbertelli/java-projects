package br.com.atmdigital.crmapi.service.impl;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.atmdigital.crmapi.common.service.AbstractServiceImpl;
import br.com.atmdigital.crmapi.service.FileService;
import br.com.atmdigital.crmapi.utils.AudioUtils;
import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class FilesServiceImpl extends AbstractServiceImpl implements FileService {

	@Value("${uri.upload}")
	private String uriUpload;

	@Value("${uri.upload}")
	private String uriDownLoad;
	
	@Autowired
	private AudioUtils audioUtils;

	public void upload(MultipartFile file, String fileName) throws Exception {

		File dest = new File(FilenameUtils.getFullPathNoEndSeparator(uriUpload) + File.separator + fileName + "." + FilenameUtils.getExtension(file.getOriginalFilename()));

		if (dest.exists()) {
			dest.delete();
		}

		dest.createNewFile();

		FileUtils.writeByteArrayToFile(dest, file.getBytes());
		
		audioUtils.converter(fileName);

	}

	@Override
	public File download(String fileName) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		File file = new File(FilenameUtils.getFullPathNoEndSeparator(uriDownLoad) + File.separator + fileName);
		
		if (!file.exists())
		  throw new FileNotFoundException();
			
		return file;
	}

}

package br.com.atmdigital.crmapi.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AudioUtils {

	@Value("${uri.upload}")
	private String uriAudio;
	
	private String buildFileName(String inputFileName , String extension){
		return FilenameUtils.getBaseName(inputFileName) + "." + extension;
	}
	
	public String converter(String inputFileName) throws Exception {
		
		inputFileName = FilenameUtils.getName(inputFileName);
		
		String _3gpFile = FilenameUtils.getFullPathNoEndSeparator(uriAudio) + File.separator + buildFileName(inputFileName, "3gp");
		String wavFile = FilenameUtils.getFullPathNoEndSeparator(uriAudio) + File.separator + buildFileName(inputFileName, "wav");
		String rawFile = FilenameUtils.getFullPathNoEndSeparator(uriAudio) + File.separator + buildFileName(inputFileName, "raw");

		String exeQuery = " ffmpeg -i " + _3gpFile + " -c:v null " + wavFile;
		Runtime.getRuntime().exec(exeQuery);
			
		File fileWave = new File(wavFile);
		
		while (!fileWave.exists()) {
			Thread.sleep(1000);
		}
		
		
		exeQuery = " sox " + wavFile + " -r 16000 -b 8 " + rawFile ;
		
		File fileraw = new File(rawFile);
		Runtime.getRuntime().exec(exeQuery);
		while (!fileraw.exists()) {
			Thread.sleep(2000);
		}
		
		FileUtils.forceDelete(new File(wavFile));
		
		return rawFile;
	}

}

package br.com.atmdigital.crmapi.rest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.atmdigital.crmapi.service.FileService;

/**
 * 
 * @author Bruno Bertelli
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/private/audio")
public class RESTAudioController {

	Logger LOGGER = LogManager.getLogger(RESTAudioController.class);

	@Autowired
	private FileService fileService;

	@Value("${uri.upload}")
	private String uriUpload;

	@Value("${uri.upload}")
	private String uriDownLoad;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseEntity<String> uploadFileHandler(@RequestParam("file") MultipartFile file, @RequestParam("idVisita") String idVisita) {

		try {
			fileService.upload(file,idVisita);
			return ResponseEntity.ok(StringUtils.EMPTY);

		} catch (Exception e) {
			LOGGER.error(e);
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> download(@RequestParam("fileName") String fileName) {

		File file = null;
		InputStream targetStream = null;
		try {

			file = fileService.download(fileName);
			targetStream = FileUtils.openInputStream(file);
			
			return ResponseEntity.ok().contentLength(file.length()).contentType(
                    MediaType.parseMediaType("application/octet-stream"))
			.body(new InputStreamResource(targetStream));
		} catch (FileNotFoundException e) {
			return new ResponseEntity<InputStreamResource>(HttpStatus.NOT_FOUND);
		} catch (IOException e) {
			return new ResponseEntity<InputStreamResource>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

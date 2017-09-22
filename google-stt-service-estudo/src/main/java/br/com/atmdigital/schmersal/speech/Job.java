package br.com.atmdigital.schmersal.speech;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import com.google.cloud.speech.spi.v1beta1.SpeechClient;
import com.google.cloud.speech.v1beta1.RecognitionAudio;
import com.google.cloud.speech.v1beta1.RecognitionConfig;
import com.google.cloud.speech.v1beta1.RecognitionConfig.AudioEncoding;
import com.google.cloud.speech.v1beta1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1beta1.SpeechRecognitionResult;
import com.google.cloud.speech.v1beta1.SyncRecognizeResponse;
import com.google.protobuf.ByteString;

/**
 * 
 * Classe responsavel por efetuar tr4adução do audio.
 */
public class Job {

	final static Logger _logger = Logger.getLogger(Job.class);

	public static void main(String[] args) {

		_logger.info("Start aplication Recognize.......");
		SpeechClient speech = null;
		try {

			// Instantiates a client
			boolean execute = true;
			String input = args[0];
			String outPut = args[1];
			Integer time = Integer.valueOf(args[2]);

			FilenameFilter filter = new FilenameFilter() {
				public boolean accept(File directory, String fileName) {
					return fileName.endsWith(".raw");
				}
			};
			StringBuilder text = new StringBuilder();
			speech = SpeechClient.create();

			File out = new File(outPut);

			if (!out.exists())
				out.mkdirs();

			while (execute) {

				try {

					text.setLength(0);
					Thread.sleep(time);

					File inputFile = new File(input);

					if (!inputFile.isDirectory()) {
						continue;
					}

					_logger.info("Watching files ...");
					File[] files = inputFile.listFiles(filter);

					if (null != files) {

						for (File f : files) {

							_logger.info("Found File " + f.getName());

							// The path to the audio file to transcribe
							// Reads the audio file into memory
							Path path = Paths.get(f.getPath());
							byte[] data = Files.readAllBytes(path);
							ByteString audioBytes = ByteString.copyFrom(data);

							// Builds the sync recognize request
							RecognitionConfig config = RecognitionConfig.newBuilder()
									.setEncoding(AudioEncoding.LINEAR16).setSampleRate(16000).setLanguageCode("pt-BR")
									.build();

							RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(audioBytes).build();

							try {
								SyncRecognizeResponse response = speech.syncRecognize(config, audio);
								List<SpeechRecognitionResult> results = response.getResultsList();
								for (SpeechRecognitionResult result : results) {
									List<SpeechRecognitionAlternative> alternatives = result.getAlternativesList();
									for (SpeechRecognitionAlternative alternative : alternatives) {
										if (text.length() == 0)
											text.append(alternative.getTranscript());
									}
								}

								if (text.length() > 0) {
									_logger.info("Write File " + f.getName());
									try {
										ClientRest.send(FilenameUtils.getBaseName(f.getName()), text.toString());
									} catch (BusinessException e) {
										_logger.error(e);
									}
								}

							} finally {
								FileUtils.forceDelete(f);
							}
						}
					}
				} catch (Exception e) {
					_logger.error(e);
					try {

						speech.close();
						speech = SpeechClient.create();
					} catch (Exception e1) {
						_logger.error(e);
					}
				}
			}
		} catch (Exception e) {
			_logger.error(e);
		} finally {
			_logger.info("Finished App ...");
		}

	}

}

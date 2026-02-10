package org.demo.documentation.other.fileConverter.converters.jave;

import lombok.extern.slf4j.Slf4j;
import org.cxbox.core.exception.BusinessException;
import org.springframework.stereotype.Service;
import ws.schild.jave.Encoder;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.encode.AudioAttributes;
import ws.schild.jave.encode.EncodingAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.function.Supplier;

@Service
@Slf4j
public class TempFileAudioTranscoder {
	public void transcodeToMp3(Supplier<InputStream> inputSupplier,
							   OutputStream out,
							   String fromExt,   // like ".wav" ".wma" ".mp4"
							   String toExt,     // usually ".mp3"
							   AudioAttributes audioAttrs) {

		Path inTmp = null;
		Path outTmp = null;

		try {
			inTmp = Files.createTempFile("jave2-in-", fromExt);
			outTmp = Files.createTempFile("jave2-out-", toExt);


			try (InputStream in = inputSupplier.get();
				 OutputStream fileOut = Files.newOutputStream(inTmp, StandardOpenOption.TRUNCATE_EXISTING)) {
				in.transferTo(fileOut);
			}


			String toFormat = stripDot(toExt); // "mp3"

			EncodingAttributes attrs = new EncodingAttributes();
			attrs.setOutputFormat(toFormat);
			attrs.setAudioAttributes(audioAttrs);

			new Encoder().encode(new MultimediaObject(inTmp.toFile()), outTmp.toFile(), attrs); // File target required [web:163]


			try (InputStream encoded = Files.newInputStream(outTmp, StandardOpenOption.READ)) {
				encoded.transferTo(out);
				out.flush();
			}

		} catch (Exception e) {
			throw new BusinessException(e).addPopup("Error while converting " + fromExt + " -> " + toExt);
		} finally {
			deleteTempFile(outTmp);
			deleteTempFile(inTmp);
		}
	}

	public static AudioAttributes defaultMp3Audio() {
		AudioAttributes audio = new AudioAttributes();
		audio.setCodec("libmp3lame");
		audio.setBitRate(128_000);
		audio.setChannels(2);
		audio.setSamplingRate(44_100);
		return audio;
	}

	private static String stripDot(String ext) {
		return ext != null && ext.startsWith(".") ? ext.substring(1) : ext;
	}

	private void deleteTempFile(Path path) {
		if (path != null) {
			try {
				Files.deleteIfExists(path);
			} catch (IOException ignored) {
				log.warn("Could not delete temp file {}", path);
			}
		}
	}
}

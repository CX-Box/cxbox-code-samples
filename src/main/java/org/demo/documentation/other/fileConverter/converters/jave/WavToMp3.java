package org.demo.documentation.other.fileConverter.converters.jave;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cxbox.core.dto.rowmeta.converter.Converter;
import org.cxbox.core.dto.rowmeta.converter.ConverterIdentifier;
import org.cxbox.core.file.dto.FileDownloadDto;
import org.demo.documentation.other.fileConverter.FileConverterServiceExt;
import org.springframework.stereotype.Service;

import java.io.OutputStream;

@Slf4j
@Service
@RequiredArgsConstructor
public class WavToMp3 implements Converter {

	public static ConverterIdentifier WAV_TO_MP3 = ConverterIdentifier.of(FileConverterServiceExt.WAV, FileConverterServiceExt.MP3);

	@Override
	public ConverterIdentifier converter() {
		return WAV_TO_MP3;
	}

	private final TempFileAudioTranscoder tempFileAudioTranscoder;

	@Override
	public void convert(FileDownloadDto data, OutputStream out, String from, String to) {
		tempFileAudioTranscoder.transcodeToMp3(data.getContent(), out, from, to, TempFileAudioTranscoder.defaultMp3Audio());
	}

}

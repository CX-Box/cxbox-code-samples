package org.demo.documentation.other.fileConverter;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.dto.rowmeta.converter.AutoConversion;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.demo.documentation.other.fileConverter.FileConverterServiceExt.*;

@Service
public class Myexample6151MetaBuilder extends FieldMetaBuilder<Myexample6151DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<Myexample6151DTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(
				Myexample6151DTO_.fileName,
				Myexample6151DTO_.fileNameId
		);
		fields.setEnabled(
				Myexample6151DTO_.fileNameNAF,
				Myexample6151DTO_.fileNameNAFId
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<Myexample6151DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.setFileAccept(Myexample6151DTO_.fileName,
				List.of(PNG, PDF, JPG, JPEG, MP3, WAV, M4A),
				cb ->
						cb.text("autoConversion: NEVER")
								.addAll(ALL_REGISTERED_CONVERTERS)
								.autoConversion(AutoConversion.NEVER)
		);

		fields.setFileAccept(Myexample6151DTO_.fileNameNAF,
				List.of(PNG, PDF, JPG, JPEG, MP3, WAV, M4A),
				cb ->
						cb.text("autoConversion: NOT_ACCEPTED_FILE ")
								.addAll(ALL_REGISTERED_CONVERTERS)
								.autoConversion(AutoConversion.NOT_ACCEPTED_FILE)
		);
	}

}

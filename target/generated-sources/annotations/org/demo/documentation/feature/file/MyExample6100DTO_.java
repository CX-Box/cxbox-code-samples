package org.demo.documentation.feature.file;

import java.lang.String;
import org.cxbox.api.data.dto.DataResponseDTO_;
import org.cxbox.constgen.DtoField;
import org.demo.documentation.feature.file.enums.CustomFieldDictionaryEnum;

public class MyExample6100DTO_ extends DataResponseDTO_ {
  public static final DtoField<MyExample6100DTO, String> customField = new DtoField<>("customField", org.demo.documentation.feature.file.MyExample6100DTO::getCustomField, java.lang.String.class);

  public static final DtoField<MyExample6100DTO, CustomFieldDictionaryEnum> customFieldDictionary = new DtoField<>("customFieldDictionary", org.demo.documentation.feature.file.MyExample6100DTO::getCustomFieldDictionary, org.demo.documentation.feature.file.enums.CustomFieldDictionaryEnum.class);

  public static final DtoField<MyExample6100DTO, String> customFieldFile = new DtoField<>("customFieldFile", org.demo.documentation.feature.file.MyExample6100DTO::getCustomFieldFile, java.lang.String.class);

  public static final DtoField<MyExample6100DTO, String> customFieldFileId = new DtoField<>("customFieldFileId", org.demo.documentation.feature.file.MyExample6100DTO::getCustomFieldFileId, java.lang.String.class);
}

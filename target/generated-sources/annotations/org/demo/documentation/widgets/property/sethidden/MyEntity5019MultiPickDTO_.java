package org.demo.documentation.widgets.property.sethidden;

import java.lang.String;
import org.cxbox.api.data.dto.DataResponseDTO_;
import org.cxbox.constgen.DtoField;
import org.demo.documentation.widgets.property.sethidden.enums.CustomFieldDictionaryEnum1;

public class MyEntity5019MultiPickDTO_ extends DataResponseDTO_ {
  public static final DtoField<MyEntity5019MultiPickDTO, String> customField = new DtoField<>("customField", org.demo.documentation.widgets.property.sethidden.MyEntity5019MultiPickDTO::getCustomField, java.lang.String.class);

  public static final DtoField<MyEntity5019MultiPickDTO, CustomFieldDictionaryEnum1> customFieldDictionary = new DtoField<>("customFieldDictionary", org.demo.documentation.widgets.property.sethidden.MyEntity5019MultiPickDTO::getCustomFieldDictionary, org.demo.documentation.widgets.property.sethidden.enums.CustomFieldDictionaryEnum1.class);
}

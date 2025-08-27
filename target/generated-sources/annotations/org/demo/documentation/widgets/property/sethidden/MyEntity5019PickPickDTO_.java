package org.demo.documentation.widgets.property.sethidden;

import java.lang.String;
import org.cxbox.api.data.dto.DataResponseDTO_;
import org.cxbox.constgen.DtoField;
import org.demo.documentation.widgets.property.sethidden.enums.CustomFieldDictionaryEnum2;

public class MyEntity5019PickPickDTO_ extends DataResponseDTO_ {
  public static final DtoField<MyEntity5019PickPickDTO, String> customField = new DtoField<>("customField", org.demo.documentation.widgets.property.sethidden.MyEntity5019PickPickDTO::getCustomField, java.lang.String.class);

  public static final DtoField<MyEntity5019PickPickDTO, CustomFieldDictionaryEnum2> customFieldDictionary = new DtoField<>("customFieldDictionary", org.demo.documentation.widgets.property.sethidden.MyEntity5019PickPickDTO::getCustomFieldDictionary, org.demo.documentation.widgets.property.sethidden.enums.CustomFieldDictionaryEnum2.class);
}

package org.demo.documentation.widgets.property.sethidden;

import java.lang.Long;
import java.lang.String;
import org.cxbox.api.data.dto.DataResponseDTO_;
import org.cxbox.constgen.DtoField;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.demo.documentation.widgets.property.sethidden.enums.CustomFieldDictionaryEnum;

public class MyExample5019DTO_ extends DataResponseDTO_ {
  public static final DtoField<MyExample5019DTO, String> customField = new DtoField<>("customField", org.demo.documentation.widgets.property.sethidden.MyExample5019DTO::getCustomField, java.lang.String.class);

  public static final DtoField<MyExample5019DTO, CustomFieldDictionaryEnum> customFieldDictionary = new DtoField<>("customFieldDictionary", org.demo.documentation.widgets.property.sethidden.MyExample5019DTO::getCustomFieldDictionary, org.demo.documentation.widgets.property.sethidden.enums.CustomFieldDictionaryEnum.class);

  public static final DtoField<MyExample5019DTO, MultivalueField> customFieldMV = new DtoField<>("customFieldMV", org.demo.documentation.widgets.property.sethidden.MyExample5019DTO::getCustomFieldMV, org.cxbox.core.dto.multivalue.MultivalueField.class);

  public static final DtoField<MyExample5019DTO, String> customFieldMVDisplayedKey = new DtoField<>("customFieldMVDisplayedKey", org.demo.documentation.widgets.property.sethidden.MyExample5019DTO::getCustomFieldMVDisplayedKey, java.lang.String.class);

  public static final DtoField<MyExample5019DTO, String> customFieldPickList = new DtoField<>("customFieldPickList", org.demo.documentation.widgets.property.sethidden.MyExample5019DTO::getCustomFieldPickList, java.lang.String.class);

  public static final DtoField<MyExample5019DTO, Long> customFieldPickListId = new DtoField<>("customFieldPickListId", org.demo.documentation.widgets.property.sethidden.MyExample5019DTO::getCustomFieldPickListId, java.lang.Long.class);
}

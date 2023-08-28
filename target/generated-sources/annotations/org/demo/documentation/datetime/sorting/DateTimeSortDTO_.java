package org.demo.documentation.datetime.sorting;

import java.time.LocalDateTime;
import org.cxbox.api.data.dto.DataResponseDTO_;
import org.cxbox.constgen.DtoField;

public class DateTimeSortDTO_ extends DataResponseDTO_ {
  public static final DtoField<DateTimeSortDTO, LocalDateTime> customField = new DtoField<>("customField", org.demo.documentation.datetime.sorting.DateTimeSortDTO::getCustomField);
}

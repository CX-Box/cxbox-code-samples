package org.demo.documentation.widgets.pie1d.data;

import java.time.LocalDateTime;

public record CustomPrj(
		Long clientId,
		String clientName,
		Long sum,
		CustomFieldStatusEnum status,
		LocalDateTime saleDate
) {

}
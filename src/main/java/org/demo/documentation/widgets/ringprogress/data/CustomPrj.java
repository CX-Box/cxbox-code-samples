package org.demo.documentation.widgets.ringprogress.data;

import java.time.LocalDateTime;

public record CustomPrj(
		Long clientId,
		String clientName,
		Long sum,
		CustomFieldStatusEnum status,
		LocalDateTime saleDate
) {

}
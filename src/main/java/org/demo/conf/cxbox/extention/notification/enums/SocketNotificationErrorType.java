package org.demo.conf.cxbox.extention.notification.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape = Shape.NATURAL)
public enum SocketNotificationErrorType {

	SystemError, BusinessError;
}

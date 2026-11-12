package org.demo.documentation.additional.uploaderror;

import lombok.experimental.UtilityClass;
import org.cxbox.core.exception.BusinessException;

/**
 * Errors of the file upload for the sample "Upload errors" (CXBOX-1038): the file controller fails for a file whose name
 * starts with one of the prefixes, the message of the error names the file. So each file of one upload gets an answer of
 * its own, and the window of the upload progress shows it on the line of the file.
 */
@UtilityClass
public class MyExample3701UploadErrors {

	/**
	 * {@link BusinessException}: the answer is 418 with {@code error.popup}
	 */
	public static final String BUSINESS_ERROR_PREFIX = "upload-error-business";

	/**
	 * Any other exception: the answer is 500 with {@code errorMessage}
	 */
	public static final String SERVER_ERROR_PREFIX = "upload-error-server";

	public static void check(String fileName) {
		if (fileName == null) {
			return;
		}
		if (fileName.startsWith(BUSINESS_ERROR_PREFIX)) {
			throw new BusinessException().addPopup("File " + fileName + " is rejected: the size is over the limit of the sample");
		}
		if (fileName.startsWith(SERVER_ERROR_PREFIX)) {
			throw new IllegalStateException("File " + fileName + " is not saved: the file storage is not available");
		}
	}

}

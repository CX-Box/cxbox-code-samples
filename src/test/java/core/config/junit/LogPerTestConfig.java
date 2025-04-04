package core.config.junit;

import static java.lang.String.format;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;
import io.qameta.allure.Allure;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//TODO>>refacor draft. add java doc
public class LogPerTestConfig implements BeforeEachCallback, AfterEachCallback {

	public static final String API_NO_LOGIN_LOGGER = "API_NO_LOGIN_LOGGER";

	public static final Logger log_api_no_login = LoggerFactory.getLogger(API_NO_LOGIN_LOGGER);

	private static final String API_LOGIN_ONLY_LOGGER = "API_LOGIN_ONLY_LOGGER";

	public static final Logger log_api_login_only = LoggerFactory.getLogger(API_LOGIN_ONLY_LOGGER);

	private static String sanitizeFileName(String input) {
		return input.replaceAll("[^a-zA-Z0-9-_\\.]", "_");
	}

	@NotNull
	private static FileAppender<ILoggingEvent> getILoggingEventFileAppender(String perTestFileName) {
		var logFile = new File("target/log/", perTestFileName + UUID.randomUUID() + ".log");

		var context = (LoggerContext) LoggerFactory.getILoggerFactory();

		// Create encoder
		var encoder = new PatternLayoutEncoder();
		encoder.setContext(context);
		encoder.setPattern("%date [%thread] %-5level %logger{36} - %msg%n " + logFile.getName());
		encoder.start();

		// Create file appender
		var fileAppender = new FileAppender<ILoggingEvent>();
		fileAppender.setContext(context);
		fileAppender.setName(perTestFileName);
		fileAppender.setFile(logFile.getAbsolutePath());
		fileAppender.setEncoder(encoder);
		fileAppender.setAppend(true);

		return fileAppender;
	}

	@NotNull
	private static String getPerTestUniqueAppenderName(ExtensionContext context) {
		return API_NO_LOGIN_LOGGER + sanitizeFileName(format(
				"-%s",
				context.getUniqueId()
		));
	}

	@Override
	public void beforeEach(ExtensionContext context) {
		var perTestFileName = getPerTestUniqueAppenderName(context);
		var logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(API_NO_LOGIN_LOGGER);
		var fileAppender = getILoggingEventFileAppender(perTestFileName);
		var appender = logger.getAppender(perTestFileName);
		if (appender == null) {
			logger.addAppender(fileAppender);
			fileAppender.start();
		}

		log_api_no_login.trace("starting test: {}. uuid: {}", context.getDisplayName(), context.getUniqueId());
		log_api_login_only.trace("starting test: {}. uuid: {}", context.getDisplayName(), context.getUniqueId());
	}

	@Override
	@SneakyThrows
	public void afterEach(ExtensionContext context) {
		var perTestFileName = getPerTestUniqueAppenderName(context);
		log_api_no_login.trace("ending test: {}. uuid: {}", context.getDisplayName(), context.getUniqueId());
		log_api_login_only.trace("ending test: {}. uuid: {}", context.getDisplayName(), context.getUniqueId());

		var logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(API_NO_LOGIN_LOGGER);
		var appender = logger.getAppender(perTestFileName);

		if (appender != null) {
			logger.detachAppender(perTestFileName);
			appender.stop();
			var file = ((FileAppender<?>) appender).getFile();
			var logFile = Path.of(file);
			if (context.getExecutionException().isPresent()) {
				Allure.addAttachment("Network logs (except login)", Files.newInputStream(logFile));
			}
		}

	}


}

package com.senspond.myapp;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {AppConfig.class})
public class MessageTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageTest.class);
	private static final String MESSAGE_CODE = "test.message1";
	private static final String DEFAULT_LOCALE_MESSAGE = "\uC548\uB155\uD558\uC138\uC694";
	private static final String KOREA_LOCALE_MESSAGE = "\uC548\uB155\uD558\uC138\uC694";
	private static final String ENGLISH_LOCALE_MESSAGE = "\u0048\u0065\u006C\u006C\u006F";
	private static final String JAPANESE_LOCALE_MESSAGE = "\u3053\u3093\u306B\u3061\u306F";
	private static final String CHINESE_LOCALE_MESSAGE = "\u4F60\u597D";

	@Autowired
	private MessageSource messageSource;

	@Test
	public void getDefaultMessageTest() {
		String message = messageSource.getMessage(MESSAGE_CODE, null, Locale.getDefault());
		LOGGER.debug("Default locale message: {}", message);
		assertEquals(DEFAULT_LOCALE_MESSAGE, message);
	}

	@Test
	public void getMessageByLocaleTest() {
		// korea
		String message = messageSource.getMessage(MESSAGE_CODE, null, Locale.KOREAN);
		LOGGER.debug("Korean message: {}", message);
		assertEquals(KOREA_LOCALE_MESSAGE, message);

		// english
		message = messageSource.getMessage(MESSAGE_CODE, null, Locale.ENGLISH);
		LOGGER.debug("English message: {}", message);
		assertEquals(ENGLISH_LOCALE_MESSAGE, message);

		// japanese
		message = messageSource.getMessage(MESSAGE_CODE, null, Locale.JAPANESE);
		LOGGER.debug("Japanese message: {}", message);
		assertEquals(JAPANESE_LOCALE_MESSAGE, message);

		// chinese
		message = messageSource.getMessage(MESSAGE_CODE, null, Locale.CHINESE);
		LOGGER.debug("Chinese message: {}", message);
		assertEquals(CHINESE_LOCALE_MESSAGE, message);
	}
}
package net.narusas.jstl.validate.rules;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class RuleTestBase {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T extends Annotation> FieldAnnotaion<T> getFieldAnnotation(Class<?> clazz, String fieldName, Class<T> annotationClass) {
		try {
			Field f = clazz.getDeclaredField(fieldName);
			return new FieldAnnotaion(f, (T)f.getAnnotation(annotationClass));
		} catch (SecurityException e) {
			throw new IllegalArgumentException(e);
		} catch (NoSuchFieldException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setCacheSeconds(5);
		messageSource.setBasenames("classpath:config/validationMessage");
		return messageSource;
	}
}
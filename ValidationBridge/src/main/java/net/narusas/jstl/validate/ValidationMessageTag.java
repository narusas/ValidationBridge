package net.narusas.jstl.validate;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.MessageSource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

@Getter
@Setter
@Slf4j
public class ValidationMessageTag extends RequestContextAwareTag {
	private static final long serialVersionUID = -7693555292571201866L;

	@Autowired
	MessageSource messageSource;

	RulesInspector inspector = new RulesInspector();
	FieldCollector fieldCollector = new FieldCollector();

	Object ruleBean;
	Class<?> ruleClass;

	@Override
	public int doStartTagInternal() throws JspException {
		if (messageSource == null) {
			log.debug("Autowiring the bean");
			WebApplicationContext wac = getRequestContext()
					.getWebApplicationContext();
			AutowireCapableBeanFactory acbf = wac
					.getAutowireCapableBeanFactory();
			acbf.autowireBean(this);
		}
		log.info("MessageSource:{}", messageSource);

		if (ruleBean != null) {
			ruleClass = ruleBean.getClass();
		}
		List<FieldNode> fieldNodes = fieldCollector.collect(ruleClass);


		try {
			JspWriter writer = pageContext.getOut();
			writer.write(StringUtils.join(inspector.collectMessage(fieldNodes, messageSource),
					','));
			return SKIP_BODY;
		} catch (IOException e) {
			log.warn(e.getMessage(), e);
			throw new JspException(e);
		}
	}
}

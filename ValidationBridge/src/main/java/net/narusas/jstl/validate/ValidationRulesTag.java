package net.narusas.jstl.validate;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
@Slf4j
public class ValidationRulesTag extends TagSupport {
	private static final long serialVersionUID = -4152100215979478617L;

	RulesInspector inspector = new RulesInspector();
	FieldCollector fieldCollector = new FieldCollector();

	Object ruleBean;
	Class<?> ruleClass;

	@Override
	public int doStartTag() throws JspException {
		if (ruleBean != null) {
			ruleClass = ruleBean.getClass();
		}

		List<FieldNode> fieldNodes = fieldCollector.collect(ruleClass);

		try {
			pageContext.getOut().write(StringUtils.join(inspector.collectRules(fieldNodes), ','));
			return SKIP_BODY;
		} catch (IOException e) {
			log.warn(e.getMessage(), e);
			throw new JspException(e);
		}
	}
}

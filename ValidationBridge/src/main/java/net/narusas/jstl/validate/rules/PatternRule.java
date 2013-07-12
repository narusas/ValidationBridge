package net.narusas.jstl.validate.rules;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;

import net.narusas.jstl.validate.ConvertRule;

public class PatternRule extends ConvertRule {


	private String regexp;
	private Flag[] flags;
	

	public PatternRule(Pattern annotation, Class<?> type) {
		super(annotation.message());
		regexp= annotation.regexp();
		flags = annotation.flags();
	}

	@Override
	public String toRuleString() {
			return "regex: /"+regexp+"/"+addFlags(flags);
	}

	/*
	 * <pre>
	Java							Javascript
	Pattern.Flag.CANON_EQ;
	Pattern.Flag.CASE_INSENSITIVE;   -> i
	Pattern.Flag.COMMENTS;
	Pattern.Flag.DOTALL;			-> g
	Pattern.Flag.MULTILINE;			-> m
	Pattern.Flag.UNICODE_CASE;
	Pattern.Flag.UNIX_LINES;
	</pre>
	 */
	private String addFlags(Flag[] flagList) {
		if (flagList == null || flagList.length ==0){
			return "";
		}
		StringBuffer buf = new StringBuffer();
		for (Flag flag : flagList) {
			if (flag == Flag.CASE_INSENSITIVE){
				buf.append("i");
			}
			else if (flag == Flag.DOTALL){
				buf.append("g");
			}
			else if (flag == Flag.MULTILINE){
				buf.append("m");
			}
		}
		return buf.toString();
	}

	@Override
	public String toMessageString() {
//		return ruleName + ": '" + getMessageFromSource(message, new Entry[]{new Entry("integer", integerPart), new Entry("fraction", fractionPart)}) + "'";
		return null;
	}

}

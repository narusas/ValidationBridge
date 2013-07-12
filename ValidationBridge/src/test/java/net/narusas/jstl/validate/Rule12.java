package net.narusas.jstl.validate;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class Rule12 {
	@NotNull
	String name;

	@NotNull
	Date created;
}

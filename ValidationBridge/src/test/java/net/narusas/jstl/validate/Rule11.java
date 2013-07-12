package net.narusas.jstl.validate;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Rule11 {
	@Min(1000)
	int no;
	
	@NotNull
	Date licensedTime;
	
	@Valid
	Rule12 authority;
	
}

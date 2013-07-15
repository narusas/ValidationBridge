package net.narusas.jstl.validate;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Rule11 implements Serializable{
	private static final long serialVersionUID = -5825584600198309868L;

	@Min(1000)
	int no;
	
	@NotNull
	Date licensedTime;
	
	@Valid
	Rule12 authority;
	
}

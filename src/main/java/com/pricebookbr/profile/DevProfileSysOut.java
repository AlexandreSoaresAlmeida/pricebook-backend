package com.pricebookbr.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class DevProfileSysOut {

	public DevProfileSysOut() {
		System.out.println("#################################");
		System.out.println("#################################");
		System.out.println("##             DEV            ##");
		System.out.println("#################################");
		System.out.println("#################################");
	}
}
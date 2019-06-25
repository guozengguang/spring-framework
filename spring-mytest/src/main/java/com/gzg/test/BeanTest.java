package com.gzg.test;

import com.gzg.bean.lookup.User;

/**
 * @author guozengguang
 * @date 2019-06-18 10:15
 */
public abstract class BeanTest {
	public void showMe() {
		this.getBean().showMe();
	}

	public abstract User getBean();
}

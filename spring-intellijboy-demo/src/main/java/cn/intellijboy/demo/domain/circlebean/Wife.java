/*
 * Copyright (c) 2019-2029, <a href="https://wwww.intellijboy.cn">https://wwww.intellijboy.cn</a> (liuburu@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * <a href="https://www.apache.org/licenses/LICENSE-2.0">https://www.apache.org/licenses/LICENSE-2.0</a>
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package cn.intellijboy.demo.domain.circlebean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 妻子类
 *
 * @author intellijboy
 * @since 1.0
 */
@Component
public class Wife {
	
	@Autowired
	private Husband husband;

	// public Wife(Husband husband) {
	// 	this.husband = husband;
	// }

	public Husband getHusband() {
		return husband;
	}

	public void setHusband(Husband husband) {
		this.husband = husband;
	}
}


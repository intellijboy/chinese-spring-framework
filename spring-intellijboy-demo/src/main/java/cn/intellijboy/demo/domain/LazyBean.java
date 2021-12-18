/**
 * Copyright (c) 2019-2029, wwww.intellijboy.cn (liuburu@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package cn.intellijboy.demo.domain;

import cn.intellijboy.demo.helper.BeaninitStatus;
import lombok.Data;

/**
 * 描述：懒加载Bean
 *
 * @author IntelliJBoy
 * @since jdk1.8
 */
@Data
public class LazyBean {


	public LazyBean() {
		BeaninitStatus.isloaded = true;
		System.out.println("懒加载Bean初始化");
	}

}

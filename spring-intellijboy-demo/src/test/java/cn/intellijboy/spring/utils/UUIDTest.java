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
package cn.intellijboy.spring.utils;

import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * 描述：id生成测试
 *
 * @author IntelliJBoy
 * @since jdk1.8
 */
public class UUIDTest {

	@Test
	public void genUUId() {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		System.out.println(uuid.length());
		System.out.println(uuid);
	}
}

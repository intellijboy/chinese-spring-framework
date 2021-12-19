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
import org.springframework.core.ResolvableType;

import java.util.HashMap;
import java.util.List;

/**
 * 描述：泛型解析工具类测试
 *
 * @author IntelliJBoy
 * @since jdk1.8
 */
public class ResolvableTest {

	private HashMap<String, List<Integer>> customizedMap;

	@Test
	public void testGenericResolve() throws NoSuchFieldException {
		ResolvableType resolvableType = ResolvableType.forField(ResolvableTest.class.getDeclaredField("customizedMap"));
		System.out.println("resolvableType.getGeneric(0).resolve():" + resolvableType.getGeneric(0).resolve());
		System.out.println("resolvableType.getGeneric(1).resolve():" + resolvableType.getGeneric(1).resolve());
		System.out.println("resolvableType.getGeneric(1):" + resolvableType.getGeneric(1));
		System.out.println("resolvableType.getSuperType():" + resolvableType.getSuperType());
		System.out.println("resolvableType.asMap():" + resolvableType.asMap());
		System.out.println("resolvableType.resolveGeneric(1, 0):" + resolvableType.resolveGeneric(1, 0));
	}
}

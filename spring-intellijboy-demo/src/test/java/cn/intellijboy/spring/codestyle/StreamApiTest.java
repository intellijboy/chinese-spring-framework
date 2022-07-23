/**
 * Copyright (c) 2019-2029, https://wwww.intellijboy.cn (liuburu@qq.com).
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

package cn.intellijboy.spring.codestyle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：Stream Api测试
 *
 * @author kiwipeach
 * @since 1.0.0
 */
public class StreamApiTest {

	private List<Person> personList = new ArrayList<Person>();

	@BeforeEach
	public void initData() {
		Person person1 = new Person("aaa", 18);
		Person person2 = new Person("bbb", 20);
		Person person3 = new Person("ccc", 30);
		Person person4 = new Person("ddd", 18);
		personList.add(person1);
		personList.add(person2);
		personList.add(person3);
		personList.add(person4);
	}

	/**
	 * 默认stream api格式化单行的还是保持单行
	 */
	@Test
	public void test1() {
		personList.stream().filter(person -> person.getAge() > 18).forEach(System.out::println);
	}
}

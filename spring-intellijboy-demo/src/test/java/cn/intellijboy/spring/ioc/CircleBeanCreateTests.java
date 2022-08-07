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

package cn.intellijboy.spring.ioc;

import cn.intellijboy.demo.domain.circlebean.Husband;
import cn.intellijboy.demo.domain.circlebean.Wife;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * bean循环创建测试
 *
 * @author intellijboy
 * @since 1.0
 */
public class CircleBeanCreateTests {


	@Configuration
	@ComponentScan(basePackages = {"cn.intellijboy.demo.domain.circlebean"})
	public class CircleAutowireConfiguration {

	}

	@Test
	public void testBeanCreate() {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(CircleAutowireConfiguration.class);
		Wife wife = annotationConfigApplicationContext.getBean(Wife.class);
		Husband husband = annotationConfigApplicationContext.getBean(Husband.class);
		Assertions.assertSame(wife, husband.getWife());
	}

}

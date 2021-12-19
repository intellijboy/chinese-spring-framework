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
package cn.intellijboy.demo;

import cn.intellijboy.demo.domain.Employ;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：spring注解容器
 *
 * @author IntelliJBoy
 * @since jdk1.8
 */
@Configurable
public class SpringAnotationTest {

	AnnotationConfigApplicationContext context;

	@BeforeEach
	public void initIOC() {
		context = new AnnotationConfigApplicationContext(SpringAnotationTest.class, MyBeanConfigurable.class);
		context.start();
	}

	@AfterEach
	public void destoryIOC() {
		context.close();
	}


	@DisplayName("获取配置类中的注解Bean")
	@Test
	public void getAnotationBean() {
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Employ.class);
		rootBeanDefinition.setLazyInit(false);
		Map<String, String> propertyValues = new HashMap<>();
		propertyValues.put("empno", "1000");
		propertyValues.put("ename", "自定义Bean");
		MutablePropertyValues properties = new MutablePropertyValues(propertyValues);
		rootBeanDefinition.setPropertyValues(properties);
		context.registerBeanDefinition("definitionBean", rootBeanDefinition);

		Employ definitionBean = context.getBean("definitionBean", Employ.class);
		Assertions.assertEquals("1000", definitionBean.getEmpno());
		Assertions.assertEquals("自定义Bean", definitionBean.getEname());

		Employ intellijboy = context.getBean("intellijboy", Employ.class);
		Assertions.assertEquals("10086", intellijboy.getEmpno());
		Assertions.assertEquals("intellijboy", intellijboy.getEname());
	}

	@Configurable
	class MyBeanConfigurable {

		@Bean(name = "intellijboy")
		public Employ intellijboy() {
			return new Employ().setEmpno("10086").setEname("intellijboy");
		}
	}


}

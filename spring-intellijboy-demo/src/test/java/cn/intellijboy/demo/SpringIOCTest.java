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
import cn.intellijboy.demo.domain.LazyBean;
import cn.intellijboy.demo.factory.CustomFactoryBean;
import cn.intellijboy.demo.helper.BeaninitStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 描述：测试spring容器
 *
 * @author IntelliJBoy
 * @since jdk1.8
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SpringIOCTest {

	ApplicationContext context;

	@BeforeAll
	@DisplayName("获取IOC容器")
	public void initIoc() {
		context = new ClassPathXmlApplicationContext("spring-ioc.xml");
	}

	@Test
	@DisplayName("获取Bean")
	public void getBeanTest() {
		Employ employ = context.getBean("singletonBean", Employ.class);
		Assertions.assertEquals("1001", employ.getEmpno());
		Assertions.assertEquals("intellijboy", employ.getEname());
		Assertions.assertEquals("高级开发工程师", employ.getJob());
		Assertions.assertEquals(36000.00, employ.getComm());
		Assertions.assertEquals(15500, employ.getSal());
		Assertions.assertEquals("100", employ.getMgr());
	}

	@Test
	@DisplayName("单例Bean")
	public void singletonBeanTest() {
		Employ singletonBean1 = context.getBean("singletonBean", Employ.class);
		Employ singletonBean2 = context.getBean("singletonBean", Employ.class);
		Assertions.assertSame(singletonBean1, singletonBean2);
	}

	@Test
	@DisplayName("多例Bean")
	public void prototypeBeanTest() {
		Employ prototypeBean1 = context.getBean("prototypeBean", Employ.class);
		Employ prototypeBeab2 = context.getBean("prototypeBean", Employ.class);
		Assertions.assertNotSame(prototypeBean1, prototypeBeab2);
	}

	@Test
	@DisplayName("静态工厂Bean")
	public void staticFactoryBeanTest() {
		Employ staticFactoryBean1 = context.getBean("staticFactoryBean", Employ.class);
		Employ staticFactoryBean2 = context.getBean("staticFactoryBean", Employ.class);
		Assertions.assertSame(staticFactoryBean1, staticFactoryBean2);
	}


	@Test
	@DisplayName("静态工厂Bean")
	public void methodFactoryBeanTest() {
		Employ staticFactoryBean1 = context.getBean("methodFactory", Employ.class);
		Employ staticFactoryBean2 = context.getBean("methodFactory", Employ.class);
		Assertions.assertSame(staticFactoryBean1, staticFactoryBean2);
	}

	@Test
	@DisplayName("实现 FactoryBean<Employ> 接口获取Bean")
	public void factoryBeanTest() {
		Employ staticFactoryBean1 = context.getBean("customFactoryBean", Employ.class);
		Employ staticFactoryBean2 = context.getBean("customFactoryBean", Employ.class);
		CustomFactoryBean customFactoryBean = context.getBean("&customFactoryBean", CustomFactoryBean.class);
		Employ staticFactoryBean3 = customFactoryBean.getObject();
		Assertions.assertSame(staticFactoryBean1, staticFactoryBean2);
		Assertions.assertNotSame(staticFactoryBean2, staticFactoryBean3);
	}

	@Test
	@DisplayName("懒加载Bean")
	public void lazyBeanTest() {
		Assertions.assertSame(BeaninitStatus.isloaded, false);
		LazyBean lazyBean1 = context.getBean("lazyBean", LazyBean.class);
		Assertions.assertSame(BeaninitStatus.isloaded, true);
		LazyBean lazyBean2 = context.getBean("lazyBean", LazyBean.class);
		Assertions.assertSame(BeaninitStatus.isloaded, true);
		Assertions.assertSame(lazyBean1, lazyBean2);
	}



}

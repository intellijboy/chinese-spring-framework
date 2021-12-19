https://blog.csdn.net/SeanTandol/article/details/109805694

# Spring两大特性实现原理
## IOC实现原理
## AOP实现原理

# Bean的生命周期
- 实例化Bean对象，这个时候Bean的对象是非常低级的，基本不能够被我们使用，因为连最基本的属性都没有设置，可以理解为连Autowired注解都是没有解析的；
- 填充属性，当做完这一步，Bean对象基本是完整的了，可以理解为Autowired注解已经解析完毕，依赖注入完成了；
- 如果Bean实现了BeanNameAware接口，则调用setBeanName方法；
- 如果Bean实现了BeanClassLoaderAware接口，则调用setBeanClassLoader方法；
- 如果Bean实现了BeanFactoryAware接口，则调用setBeanFactory方法；
- 调用BeanPostProcessor的postProcessBeforeInitialization方法；
- 如果Bean实现了InitializingBean接口，调用afterPropertiesSet方法；
- 如果Bean定义了init-method方法，则调用Bean的init-method方法；
- 调用BeanPostProcessor的postProcessAfterInitialization方法；当进行到这一步，Bean已经被准备就绪了，一直停留在应用的上下文中，直到被销毁；
- 如果应用的上下文被销毁了，如果Bean实现了DisposableBean接口，则调用destroy方法，如果Bean定义了destory-method声明了销毁方法也会被调用。


# 基于配置文件和基于注解的实现方式
## 基于XML配置
## 基于注解配置

# 循环依赖的处理方式

# eanFactory与FactoryBean区别
## BeanFactory
概念：是Spring工厂的顶级接口，定义了容器的核心方法，如getBean()、containsBean()。它的实现类有DefaultListableBeanFactory、ApplicationContext
作为容器进行bean的管理
使用场景：
从容器中获取Bean
检索容器是否包含Bean
判断Bean是否为单例
## FactoryBean
概念：是一个Bean，可以对继承的对象进行封装，它能够生产一个对象，并不一定是它本身
作用：对Bean进行封装，如对数据库源DataSource的相关默认参数进行设置，又不需要改变DataSource的代码
使用：
getObject(‘name’)返回工厂中的实例
getObject(’&name’)返回工厂本身的实例
使用场景：
AOP中通过ProxyFactoryBean该Bean创建代理对象
## 两者区别
两者都是工厂，但FactoryBean本质还是一个Bean，由BeanFactory管理
BeanFactory是Spring的顶层接口，FactoryBean更类似于用户自定义的工厂接口
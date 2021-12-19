# 1. BeanFactory接口

![image-20211220002218504](images/image-20211220002218504.png)

## 各个类的分工职责

- `BeanFactory`：用于访问Spring bean容器的根接口

![image-20211220003535306](images/image-20211220003535306.png)

- `AutowireCapableBeanFactory`:这个工厂接口继承自BeanFacotory，它扩展了自动装配的功能，根据类定义BeanDefinition装配Bean、执行前、后处理器等

![image-20211220003557797](images/image-20211220003557797.png)

- `HierarchicalBeanFactory`: 提供父容器的访问功能.至于父容器的设置,需要找`ConfigurableBeanFactory`的`setParentBeanFactory`(接口把设置跟获取给拆开了!).

![image-20211220003613389](images/image-20211220003613389.png)

- `ListableBeanFactory`: 定义了一些容器Bean列表查询相关的接口

![image-20211220003632694](images/image-20211220003632694.png)

- 
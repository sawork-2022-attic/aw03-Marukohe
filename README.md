# WebPOS

The demo shows a simple POS system in MVC architecture, which replaces the shell interface in aw02 with a pos web ui (https://github.com/bshbsh404/simple-pos-ui
).

![](screenshot.png)

To run

```shell
mvn clean spring-boot:run
```

Currently, it just lists the products for sale with a cart with one item (just for demonstration). 

Please read the tutorial at  https://www.baeldung.com/spring-boot-crud-thymeleaf and make the POS system robust and fully functional. You can also refer to other articles, for instance https://www.baeldung.com/tag/thymeleaf/ .



And please elaborate your understanding in MVC architecture via this homework in your README.md.

## MVC理解
MVC指的是Model, View和Controller。  
Model：数据模型，用来存储数据  
View：视图界面，用于向用户呈现UI界面并与用户交互  
Controller：控制器，可以监听数据模型的改变，控制视图行为，并处理用户的交互逻辑  
MVC具有低耦合性，高重用性的优点，但随着项目规模的扩大，控制器的代码会变得非常复杂，难以维护。

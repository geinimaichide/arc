# arc

项目案例是对三层架构的总结

大多数公司仍采用如下分包结构：

order
  controller
    OrderController
  service
    impl
      OrderServiceImpl
    interfaces
      OrderService
  dao
    impl
      OrderDaoImpl
    interfaces
      OrderDao
  model
    Order
    
   
分包结构结果僵化，业务代码会分散到各处，不集中。   


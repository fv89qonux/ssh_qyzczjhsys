## 本项目实现的最终作用是基于SSH企业固定资产设备租借还管理系统
## 分为2个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 修改个人密码
 - 借用统计
 - 管理员登录
 - 系统用户管理
 - 设备借用审核
 - 设备借用登记
 - 设备厂商添加
 - 设备厂商管理
 - 设备归还管理
 - 设备报废管理
 - 设备查询
 - 设备检测管理
 - 设备添加
 - 设备管理
 - 设备维修管理
### 第2个角色为用户角色，实现了如下功能：
 - 修改个人密码
 - 借用历史查询
 - 发起借用申请
 - 用户登录
 - 申请结果查看
## 数据库设计如下：
# 数据库设计文档

**数据库名：** ssh_qyzczjhsys

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [t_admin](#t_admin) | 管理员表 |
| [t_baofei](#t_baofei) |  |
| [t_jiance](#t_jiance) |  |
| [t_jieyong](#t_jieyong) |  |
| [t_leixing](#t_leixing) |  |
| [t_shebei](#t_shebei) |  |
| [t_shenqing](#t_shenqing) |  |
| [t_weixiu](#t_weixiu) |  |
| [t_xuesheng](#t_xuesheng) |  |

**表名：** <a id="t_admin">t_admin</a>

**说明：** 管理员表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | UserId |   int   | 10 |   0    |    N     |  Y   |       | 用户ID  |
|  2   | username |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户名  |
|  3   | userPw |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |

**表名：** <a id="t_baofei">t_baofei</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | sbid |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  3   | wxsj |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | wxnr |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | wxr |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | wxje |   double   | 23 |   0    |    Y     |  N   |   NULL    |   |
|  7   | zt |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  8   | bz |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 备注  |

**表名：** <a id="t_jiance">t_jiance</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | sbid |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  3   | wxsj |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | wxnr |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | wxr |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | wxje |   double   | 23 |   0    |    Y     |  N   |   NULL    |   |
|  7   | zt |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  8   | bz |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 备注  |

**表名：** <a id="t_jieyong">t_jieyong</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | xsid |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  3   | sbid |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  4   | jysj |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | ghsj |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | sfsh |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  7   | pcje |   double   | 23 |   0    |    Y     |  N   |   NULL    |   |
|  8   | bz |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 备注  |
|  9   | zt |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_leixing">t_leixing</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | miaoshu |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 描述  |
|  3   | qianzhui |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |

**表名：** <a id="t_shebei">t_shebei</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | lxid |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  3   | bh |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | miaoshu |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 描述  |
|  5   | goumaishijian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | zt |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  7   | del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |
|  8   | fujian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 附件  |

**表名：** <a id="t_shenqing">t_shenqing</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | xsid |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  3   | sbid |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  4   | sqsj |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | spsj |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | spyj |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  7   | zt |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_weixiu">t_weixiu</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | sbid |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  3   | wxsj |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | wxnr |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | wxr |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | wxje |   double   | 23 |   0    |    Y     |  N   |   NULL    |   |
|  7   | zt |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  8   | bz |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 备注  |

**表名：** <a id="t_xuesheng">t_xuesheng</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | xingming |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 姓名  |
|  3   | xingbie |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | xuehao |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 学号  |
|  5   | loginName |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | loginPw |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  7   | del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |


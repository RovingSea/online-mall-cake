# 注意事项

- 接口服务器路径：www.ccsu1204branch.com/omc/api

# 无权限接口

## 商品

### 查询商品种类

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/common/type/all

请求方式：GET

Content-Type：application/json

接口地址（后端写）：/common/type/all
```

#### 请求参数

```
无
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": [
		{
			"id": 1,
			"name": "蛋糕"
		},
		{
			"id": 2,
			"name": "面包"
		},
		{
			"id": 3,
			"name": "冰淇淋"
		},
		{
			"id": 4,
			"name": "下午茶"
		},
		{
			"id": 5,
			"name": "设计师礼品"
		}
	]
}
```

### 默认查询商品

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/common/goods/select/page

请求方式：POST

Content-Type：application/json

接口地址（后端写）：/select/page
```

#### 请求参数

```json
{
	"whichPage": 1,
	"eachPageSize": 8
}
```

#### 成功样例

```
Base64数据太长了，ApiPost调试不出来
```

### 根据商品类型分页查询

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/common/goods/select/page/type

请求方式：POST

Content-Type：application/json

接口地址（后端写）：/common/goods/select/page/type
```

#### 请求参数

```json
{
	"whichPage": 1,
	"eachPageSize": 8,
	"typeId": 3
}
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": {
		"databaseDataSize": 2,
		"totalPage": 1,
		"currentPage": 1,
		"size": 8,
		"data": [
			{
				"id": 7,
				"name": "轻蛋糕（猫山王奶油）",
				"image1": "https://oss.51cocoa.com//upload/images/20211018/7f7a465515db98755ff5f7f0d94f6455.jpg",
				"image2": "https://oss.51cocoa.com//upload/images/20211018/0e018a26ea360faa07c5b7bcb33b3404.jpg",
				"price": 39,
				"intro": "牛乳烤的戚风坯，覆一层低温奶油，奶油蛋糕中的奶油蛋糕。",
				"stock": 999,
				"typeName": "下午茶"
			},
			{
				"id": 8,
				"name": "苏门答腊咖啡盒装（10包入）",
				"image1": "https://oss.51cocoa.com//upload/images/ff9693a8b8fbf6ccfd14fe760527c5ed.jpg",
				"image2": "https://oss.51cocoa.com//upload/images/d32591bbd92e51637422a0e47de442a9.jpg",
				"price": 39,
				"intro": "重烘焙，“湿刨法”苏门答腊咖啡豆，浓厚，几乎没有酸涩口感",
				"stock": 999,
				"typeName": "下午茶"
			}
		]
	}
}
```

### 根据商品名称模糊分页查询

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/common/goods/fuzzy/get/page

请求方式：POST

Content-Type：application/json

接口地址（后端写）：/common/goods/fuzzy/get/page
```

#### 请求参数

```json
{
	"whichPage": 1,
	"eachPageSize": 8,
	"name": "蛋"
}
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": {
		"databaseDataSize": 1,
		"totalPage": 1,
		"currentPage": 1,
		"size": 8,
		"data": [
			{
				"id": 7,
				"name": "轻蛋糕（猫山王奶油）",
				"image1": "https://oss.51cocoa.com//upload/images/20211018/7f7a465515db98755ff5f7f0d94f6455.jpg",
				"image2": "https://oss.51cocoa.com//upload/images/20211018/0e018a26ea360faa07c5b7bcb33b3404.jpg",
				"price": 39,
				"intro": "牛乳烤的戚风坯，覆一层低温奶油，奶油蛋糕中的奶油蛋糕。",
				"stock": 999,
				"typeName": "下午茶"
			}
		]
	}
}
```

### 查看商品详情信息

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/common/goods/get

请求方式：POST

Content-Type：application/json

接口地址（后端写）：/common/goods/get
```

#### 请求参数

```json
{
	"id": 6
}
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": {
		"id": 6,
		"name": "Milk Gelato 原味牛乳冰淇淋",
		"image1": "https://oss.51cocoa.com//upload/images/8353be78e8839f0ad0a1ab5a159859a2.jpg",
		"image2": "https://oss.51cocoa.com/public/images/fa/27/3a/f71193fbbed915f5ff7dd09606f7bbc9.jpg?1473058903#w",
		"price": 45,
		"intro": "纯正牛乳，牛乳香，单纯；Gelato10自研，新西兰乳脂奶油；融入鲜奶，单纯之能及。",
		"stock": 999,
		"typeName": "冰淇淋"
	}
}
```

### 查询所有推荐商品

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/common/goods/get/page/recommend

请求方式：GET

Content-Type：none

接口地址（后端写）：/common/goods/get/recommend
```

#### 请求参数

```json
无
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": {
		"databaseDataSize": 5,
		"totalPage": 1,
		"currentPage": 1,
		"size": 8,
		"data": [
			{
				"id": 1,
				"username": "shao",
				"password": "123",
				"name": null,
				"email": "123",
				"phone": null,
				"address": null,
				"isAdmin": false,
				"isValidate": false
			},
			{
				"id": 2,
				"username": "shao1",
				"password": "123",
				"name": null,
				"email": "123",
				"phone": null,
				"address": null,
				"isAdmin": false,
				"isValidate": false
			},
			{
				"id": 3,
				"username": "test1",
				"password": "123",
				"name": null,
				"email": "test1",
				"phone": null,
				"address": null,
				"isAdmin": false,
				"isValidate": false
			},
			{
				"id": 4,
				"username": "bitian",
				"password": "bitian",
				"name": "feibitian",
				"email": "bitian",
				"phone": "feibitian",
				"address": "feibitian",
				"isAdmin": false,
				"isValidate": false
			},
			{
				"id": 5,
				"username": "wu",
				"password": "123",
				"name": "haixin",
				"email": "123",
				"phone": "1376253",
				"address": "feibitian",
				"isAdmin": true,
				"isValidate": true
			}
		]
	}
}
```

### 查询所有热销商品

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/common/goods/get/page/hot

请求方式：GET

Content-Type：none

接口地址（后端写）：/common/goods/get/hot
```

#### 请求参数

```json
无
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": {
		"databaseDataSize": 10,
		"totalPage": 1,
		"currentPage": 1,
		"size": 8,
		"data": [
			{
				"id": 11,
				"name": "test",
				"image1": "test",
				"image2": "test",
				"price": null,
				"intro": null,
				"stock": 999,
				"typeName": "蛋糕",
				"isHot": true,
				"isNew": true
			}
		]
	}
}
```

### 查询所有新品

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/common/goods/get/page/new

请求方式：GET

Content-Type：none

接口地址（后端写）：/common/goods/get/new
```

#### 请求参数

```json
无
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": {
		"databaseDataSize": 10,
		"totalPage": 1,
		"currentPage": 1,
		"size": 8,
		"data": [
			{
				"id": 7,
				"name": "轻蛋糕（猫山王奶油）",
				"image1": "https://oss.51cocoa.com//upload/images/20211018/7f7a465515db98755ff5f7f0d94f6455.jpg",
				"image2": "https://oss.51cocoa.com//upload/images/20211018/0e018a26ea360faa07c5b7bcb33b3404.jpg",
				"price": 39,
				"intro": "牛乳烤的戚风坯，覆一层低温奶油，奶油蛋糕中的奶油蛋糕。",
				"stock": 999,
				"typeName": "下午茶",
				"isHot": false,
				"isNew": true
			},
			{
				"id": 11,
				"name": "test",
				"image1": "test",
				"image2": "test",
				"price": null,
				"intro": null,
				"stock": 999,
				"typeName": "蛋糕",
				"isHot": true,
				"isNew": true
			}
		]
	}
}
```

## 用户

### 注册

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/common/register

请求方式：POST

Content-Type：application/json

接口地址（后端写）：/register
```

#### 请求参数

```json
{
	"username": "bitian",
	"password": "bitian",
	"email": "bitian",
	"phone": "feibitian",
	"address": "feibitian",
	"name": "feibitian"
}
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": "注册成功"
}
```

### 登录

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/common/login

请求方式：POST

Content-Type：application/json

接口地址（后端写）：/login
```

#### 请求参数

```json
{
	"username": "bitian",
	"password": "bitian"
}
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": {
		"token": "eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJSSsosyUzMU9JRSq0oULIyNDMxMDIytTQzqgUA37c3NSEAAAA.50Hp6ircEWB-kzc4UL8q2qLE1uTFZOYgAt-IRs-sHQK6VtmbgzaXFBbLzxrBMV-MUczCDpuB9VsnMMLxjMgR-w"
	}
}
```

## 管理员

### 身份认证

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/common/isAdmin

请求方式：GET

Content-Type：none

Header:authentication

接口地址（后端写）：/isAdmin
```

#### 请求头

authentication 即登陆成功后返回的 token 值

```apl
Header:authentication
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": "成功"
}
```

# 有权限接口

## 用户

### 查看个人信息

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/user/current

请求方式：GET

Content-Type：none

Header:authentication

接口地址（后端写）：/user/current
```

#### 请求头

```
Header:authentication
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": {
		"id": 5,
		"username": "wu",
		"password": "123",
		"name": null,
		"email": "123",
		"phone": null,
		"address": null,
		"validate": false,
		"admin": true
	}
}
```

### 更新个人信息

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/user/update

请求方式：POST

Content-Type：none

Header:authentication

接口地址（后端写）：/user/update
```

#### 请求头

```
Header:authentication
```

#### 请求参数

```json
{
	"id": 5,
	"username": "wu",
	"password": "123123",
	"email": "123123451@qq",
	"phone": "1376253",
	"address": "feibitian",
	"name": "haixin",
	"isAdmin": true,
	"isValidate": true
}
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": "更新成功"
}
```

### 将商品加入购物车

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/user/goods/add/shoppingCart

请求方式：POST

Content-Type：application/json

Header:authentication

接口地址（后端写）：/user/goods/add/shoppingCart
```

#### 请求头

```
authentication
```

#### 请求参数

```json
{
	"goodsId": 9
}
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": true
}
```

### 增加或减少购物车中的某个商品的数量

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/user/shoppingCart/change

请求方式：POST

Content-Type：application/json

Header:authentication

接口地址（后端写）：/user/shoppingCart/plus/one
```

#### 请求头

```
authentication
```

#### 请求参数

```json
{
	"id": 30,
	"changeNum": -1
}
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": true
}
```

###

### 查看我的购物车

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/user/shoppingCart/mine

请求方式：GET

Content-Type：none

Header:authentication

接口地址（后端写）：/user/shoppingCart/mine
```

#### 请求头

```
authentication
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": [
		{
			"goodsId": 8,
			"shoppingCartId": 16,
			"image1": "https://oss.51cocoa.com//upload/images/ff9693a8b8fbf6ccfd14fe760527c5ed.jpg",
			"goodsName": "苏门答腊咖啡盒装（10包入）",
			"price": 39,
			"amount": 1
		}
	]
}
```

### 清空购物车（生成订单）

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/user/shoppingCart/empty

请求方式：GET

Content-Type：none

Header:authentication

接口地址（后端写）：/user/shoppingCart/empty
```

#### 请求头

```
authentication
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": 2
}
```

### 提交订单

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/user/order/submit

请求方式：POST

Content-Type：application/json

Header:authentication

接口地址（后端写）：/user/order/submit
```

#### 请求头

```
authentication
```

#### 请求参数

```json
{
	"id": 4,
	"userId": 5,
	"payType": 1,
	"total": 999,
	"amount": 2,
	"name": "shao",
	"phone": "1555",
	"address": "beijing"
}
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": true
}
```

### 查看付款订单

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/user/orderItem/mine/paid

请求方式：GET

Content-Type：none

Header:authentication

接口地址（后端写）：/user/orderItem/mine/paid
```

#### 请求头

```
authentication
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": [
		{
			"status": 1,
			"goodsId": 7,
			"goodsName": "轻蛋糕（猫山王奶油）",
			"orderItemId": 2,
			"orderId": 2,
			"amount": 1,
			"price": 39
		}
	]
}
```

### 查看未付款订单

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/user/orderItem/mine/unpaid

请求方式：GET

Content-Type：none

Header:authentication

接口地址（后端写）：/user/orderItem/mine/unpaid
```

#### 请求头

```
authentication
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": [
		{
			"status": 0,
			"goodsId": 7,
			"goodsName": "轻蛋糕（猫山王奶油）",
			"orderItemId": 2,
			"orderId": 2,
			"amount": 1,
			"price": 39
		}
	]
}
```

### 查看所有订单

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/user/orderItem/mine

请求方式：GET

Content-Type：none

Header:authentication

接口地址（后端写）：/user/orderItem/mine
```

#### 请求头

```
authentication
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": [
		{
			"status": 1,
			"goodsId": 7,
			"goodsName": "轻蛋糕（猫山王奶油）",
			"orderItemId": 1,
			"orderId": 1,
			"amount": 11,
			"price": 39
		},
		{
			"status": 0,
			"goodsId": 7,
			"goodsName": "轻蛋糕（猫山王奶油）",
			"orderItemId": 2,
			"orderId": 2,
			"amount": 1,
			"price": 39
		}
	]
}
```

### 根据订单项 id 查看订单情况

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/user/orderItem/get/order/info

请求方式：GET

Content-Type：none

Header:authentication

接口地址（后端写）：/user/orderItem/get/order/info
```

#### 请求头

```
authentication
```

#### 请求参数

```json
{
	"id": 1
}
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": {
		"id": 1,
		"goodsId": 7,
		"orderItemId": 0,
		"goodsName": "轻蛋糕（猫山王奶油）",
		"price": 39,
		"name": "shao",
		"address": "beijing",
		"phone": "1555",
		"payType": 1,
		"datetime": "2021-12-23 01:15:54"
	}
}
```

## 管理员

### 增加商品

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/admin/goods/add

请求方式：POST

Content-Type：application/json

Header:authentication

接口地址（后端写）：/admin/goods/add
```

#### 请求头

```
authentication
```

#### 请求参数

```json
{
	"name": 4,
	"image1": 5,
	"image2": 1,
	"price": 20,
	"intro": "好吃的不得了",
	"stock": 99,
	"typeId": 1
}
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": true
}
```

### 删除商品

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/admin/goods/delete

请求方式：POST

Content-Type：application/json

Header:authentication

接口地址（后端写）：/admin/goods/delete
```

#### 请求头

```
authentication
```

#### 请求参数

```json
{
	"id": 4
}
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": true
}
```

### 更改商品

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/admin/goods/update

请求方式：POST

Content-Type：application/json

Header:authentication

接口地址（后端写）：/admin/goods/update
```

#### 请求头

```
authentication
```

#### 请求参数

```json
{
	"name": 4,
	"image1": 5,
	"image2": 1,
	"price": 20,
	"intro": "好吃的不得了",
	"stock": 99,
	"typeId": 1
}
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": true
}
```

### 将某个商品加入热销

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/admin/goods/be/hot

请求方式：POST

Content-Type：application/json

Header:authentication

接口地址（后端写）：/admin/goods/be/hot
```

#### 请求头

```
authentication
```

#### 请求参数

```json
{
	"id": 4
}
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": true
}
```

### 将某个商品加入新品

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/admin/goods/be/new

请求方式：POST

Content-Type：application/json

Header:authentication

接口地址（后端写）：/admin/goods/be/new
```

#### 请求头

```
authentication
```

#### 请求参数

```json
{
	"id": 4
}
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": true
}
```

### 删除某个用户

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/admin/user/delete

请求方式：POST

Content-Type：application/json

Header:authentication

接口地址（后端写）：/admin/user/delete
```

#### 请求头

```
authentication
```

#### 请求参数

```json
{
	"id": 5
}
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": true
}
```

### 更新某个用户

###

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/admin/goods/be/new

请求方式：POST

Content-Type：application/json

Header:authentication

接口地址（后端写）：/admin/goods/be/new
```

#### 请求头

```
authentication
```

#### 请求参数

```json
{
	"id": 4
}
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": true
}
```

### 分页查询所有用户

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/admin/user/page/all

请求方式：GET

Content-Type：application/json

Header:authentication

接口地址（后端写）：/admin/user/page/all
```

#### 请求头

```
authentication
```

#### 请求参数

```json
{
	"id": 4
}
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": {
		"databaseDataSize": 7,
		"totalPage": 1,
		"currentPage": 1,
		"size": 8,
		"data": [
			{
				"id": 1,
				"username": "shao",
				"password": "123",
				"name": "VuJson",
				"email": "b20190202408@stu.ccsu.edu.cn",
				"phone": "15387507459",
				"address": "长沙大学知行一栋502",
				"isAdmin": true,
				"isValidate": true
			},
			{
				"id": 2,
				"username": "wu",
				"password": "123",
				"name": "Masker",
				"email": "b20190201422@stu.ccsu.edu.cn",
				"phone": "13762539019",
				"address": "长沙大学知行一栋502",
				"isAdmin": true,
				"isValidate": true
			},
			{
				"id": 4,
				"username": "test1",
				"password": "123",
				"name": null,
				"email": "test1",
				"phone": null,
				"address": null,
				"isAdmin": false,
				"isValidate": false
			},
			{
				"id": 5,
				"username": "3",
				"password": "3",
				"name": "3",
				"email": "3",
				"phone": "3",
				"address": null,
				"isAdmin": false,
				"isValidate": true
			},
			{
				"id": 6,
				"username": "11",
				"password": "11",
				"name": null,
				"email": "11",
				"phone": "11",
				"address": "11",
				"isAdmin": false,
				"isValidate": false
			},
			{
				"id": 7,
				"username": "11122",
				"password": "2",
				"name": null,
				"email": "22",
				"phone": "2",
				"address": "22",
				"isAdmin": false,
				"isValidate": false
			},
			{
				"id": 8,
				"username": "bitian",
				"password": "bitian",
				"name": "feibitian",
				"email": "bitian",
				"phone": "feibitian",
				"address": "feibitian",
				"isAdmin": false,
				"isValidate": false
			}
		]
	}
}
```

### 分页查询所有推荐

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/common/goods/get/page/recommend

请求方式：GET

Content-Type：application/json

Header:authentication

接口地址（后端写）：/common/goods/get/page/recommend
```

#### 请求参数

```json
{
	"whichPage": 1,
	"eachPageSize": 8
}
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": {
		"databaseDataSize": 15,
		"totalPage": 2,
		"currentPage": 1,
		"size": 8,
		"data": [
			{
				"id": 1,
				"name": "烤芝士条可颂",
				"image1": "https://oss.51cocoa.com//upload/images/20210927/4c3e39f74720846d940cc590e7e80e11.jpg",
				"image2": "https://oss.51cocoa.com//upload/images/20210927/f9d4f2b9924b9c6ba9985a37dfb0a714.jpg",
				"price": 16.8,
				"intro": "整块巴斯克芝士条，与切开的一只松软可颂，其貌不扬的烤芝士条可颂。",
				"stock": 999,
				"typeName": "设计师礼品",
				"isHot": true,
				"isNew": false
			},
			{
				"id": 1,
				"name": "烤芝士条可颂",
				"image1": "https://oss.51cocoa.com//upload/images/20210927/4c3e39f74720846d940cc590e7e80e11.jpg",
				"image2": "https://oss.51cocoa.com//upload/images/20210927/f9d4f2b9924b9c6ba9985a37dfb0a714.jpg",
				"price": 16.8,
				"intro": "整块巴斯克芝士条，与切开的一只松软可颂，其貌不扬的烤芝士条可颂。",
				"stock": 999,
				"typeName": "下午茶",
				"isHot": true,
				"isNew": false
			},
			{
				"id": 1,
				"name": "烤芝士条可颂",
				"image1": "https://oss.51cocoa.com//upload/images/20210927/4c3e39f74720846d940cc590e7e80e11.jpg",
				"image2": "https://oss.51cocoa.com//upload/images/20210927/f9d4f2b9924b9c6ba9985a37dfb0a714.jpg",
				"price": 16.8,
				"intro": "整块巴斯克芝士条，与切开的一只松软可颂，其貌不扬的烤芝士条可颂。",
				"stock": 999,
				"typeName": "冰淇淋",
				"isHot": true,
				"isNew": false
			},
			{
				"id": 1,
				"name": "烤芝士条可颂",
				"image1": "https://oss.51cocoa.com//upload/images/20210927/4c3e39f74720846d940cc590e7e80e11.jpg",
				"image2": "https://oss.51cocoa.com//upload/images/20210927/f9d4f2b9924b9c6ba9985a37dfb0a714.jpg",
				"price": 16.8,
				"intro": "整块巴斯克芝士条，与切开的一只松软可颂，其貌不扬的烤芝士条可颂。",
				"stock": 999,
				"typeName": "面包",
				"isHot": true,
				"isNew": false
			},
			{
				"id": 1,
				"name": "烤芝士条可颂",
				"image1": "https://oss.51cocoa.com//upload/images/20210927/4c3e39f74720846d940cc590e7e80e11.jpg",
				"image2": "https://oss.51cocoa.com//upload/images/20210927/f9d4f2b9924b9c6ba9985a37dfb0a714.jpg",
				"price": 16.8,
				"intro": "整块巴斯克芝士条，与切开的一只松软可颂，其貌不扬的烤芝士条可颂。",
				"stock": 999,
				"typeName": "蛋糕",
				"isHot": true,
				"isNew": false
			},
			{
				"id": 3,
				"name": "南瓜吐司面包",
				"image1": "https://oss.51cocoa.com//upload/images/72b013fdd73ee378762bf501709d4688.jpg",
				"image2": "https://oss.51cocoa.com//upload/images/9b30f0130caffe548b1bd82ea6ab486b.jpg",
				"price": 12,
				"intro": "新鲜南瓜烤的金黄吐司，南瓜的天然口感、香气与颜色",
				"stock": 999,
				"typeName": "面包",
				"isHot": false,
				"isNew": true
			},
			{
				"id": 4,
				"name": "Framboise Cake 蔓生",
				"image1": "https://oss.51cocoa.com//upload/images/da2e471b7883e61ca578446a2954a575.jpg",
				"image2": "https://oss.51cocoa.com//upload/images/8b854c3eec87cdb965917dbe0db04b68.jpg",
				"price": 198,
				"intro": "树莓奶油与浆果慕斯蛋糕，覆盆子冻干粉喷洒，恰到好处的一抹红晕",
				"stock": 999,
				"typeName": "蛋糕",
				"isHot": false,
				"isNew": true
			},
			{
				"id": 6,
				"name": "Milk Gelato 原味牛乳冰淇淋",
				"image1": "https://oss.51cocoa.com//upload/images/8353be78e8839f0ad0a1ab5a159859a2.jpg",
				"image2": "https://oss.51cocoa.com/public/images/fa/27/3a/f71193fbbed915f5ff7dd09606f7bbc9.jpg?1473058903#w",
				"price": 45,
				"intro": "纯正牛乳，牛乳香，单纯；Gelato10自研，新西兰乳脂奶油；融入鲜奶，单纯之能及。",
				"stock": 999,
				"typeName": "冰淇淋",
				"isHot": false,
				"isNew": true
			}
		]
	}
}
```

### 分页查询所有热销

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/common/goods/get/page/hot

请求方式：GET

Content-Type：application/json

Header:authentication

接口地址（后端写）：/common/goods/get/page/hot
```

#### 请求参数

```json
{
	"whichPage": 1,
	"eachPageSize": 8
}
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": {
		"databaseDataSize": 4,
		"totalPage": 1,
		"currentPage": 1,
		"size": 8,
		"data": [
			{
				"id": 1,
				"name": "烤芝士条可颂",
				"image1": "https://oss.51cocoa.com//upload/images/20210927/4c3e39f74720846d940cc590e7e80e11.jpg",
				"image2": "https://oss.51cocoa.com//upload/images/20210927/f9d4f2b9924b9c6ba9985a37dfb0a714.jpg",
				"price": 16.8,
				"intro": "整块巴斯克芝士条，与切开的一只松软可颂，其貌不扬的烤芝士条可颂。",
				"stock": 999,
				"typeName": "面包",
				"isHot": true,
				"isNew": false
			},
			{
				"id": 7,
				"name": "轻蛋糕（猫山王奶油）",
				"image1": "https://oss.51cocoa.com//upload/images/20211018/7f7a465515db98755ff5f7f0d94f6455.jpg",
				"image2": "https://oss.51cocoa.com//upload/images/20211018/0e018a26ea360faa07c5b7bcb33b3404.jpg",
				"price": 39,
				"intro": "牛乳烤的戚风坯，覆一层低温奶油，奶油蛋糕中的奶油蛋糕。",
				"stock": 999,
				"typeName": "下午茶",
				"isHot": true,
				"isNew": true
			},
			{
				"id": 13,
				"name": "Wall&Tree 东方栗融",
				"image1": "https://oss.51cocoa.com//upload/images/c6fe7041d4fd7dc24e5eb5411df6851e.jpg",
				"image2": "https://oss.51cocoa.com//upload/images/6d45ef676c936660b8c54134ebf9f32b.jpg",
				"price": 490,
				"intro": "明长城时期种植的栗树，直径超过1米，枝繁叶茂，正值壮年。",
				"stock": 20,
				"typeName": "蛋糕",
				"isHot": true,
				"isNew": true
			},
			{
				"id": 15,
				"name": "Mille-feuille 重组",
				"image1": "https://oss.51cocoa.com//upload/images/b2e40f0e2dd10f743cf1e9ff1254bd06.jpg",
				"image2": "https://oss.51cocoa.com//upload/images/9334c92cda4c238a62c083a939ac2ece.jpg",
				"price": 968,
				"intro": "探讨，设计研发符合人类进步的食物",
				"stock": 20,
				"typeName": "蛋糕",
				"isHot": true,
				"isNew": true
			}
		]
	}
}
```

### 分页查询所有新品

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/common/goods/get/page/new

请求方式：GET

Content-Type：application/json

Header:authentication

接口地址（后端写）：/common/goods/get/page/new
```

#### 请求参数

```json
{
	"whichPage": 1,
	"eachPageSize": 8
}
```

#### 成功样例

```json
{
	"code": 1,
	"msg": "成功",
	"response": {
		"databaseDataSize": 11,
		"totalPage": 2,
		"currentPage": 1,
		"size": 8,
		"data": [
			{
				"id": 3,
				"name": "南瓜吐司面包",
				"image1": "https://oss.51cocoa.com//upload/images/72b013fdd73ee378762bf501709d4688.jpg",
				"image2": "https://oss.51cocoa.com//upload/images/9b30f0130caffe548b1bd82ea6ab486b.jpg",
				"price": 12,
				"intro": "新鲜南瓜烤的金黄吐司，南瓜的天然口感、香气与颜色",
				"stock": 999,
				"typeName": "面包",
				"isHot": false,
				"isNew": true
			},
			{
				"id": 4,
				"name": "Framboise Cake 蔓生",
				"image1": "https://oss.51cocoa.com//upload/images/da2e471b7883e61ca578446a2954a575.jpg",
				"image2": "https://oss.51cocoa.com//upload/images/8b854c3eec87cdb965917dbe0db04b68.jpg",
				"price": 198,
				"intro": "树莓奶油与浆果慕斯蛋糕，覆盆子冻干粉喷洒，恰到好处的一抹红晕",
				"stock": 999,
				"typeName": "蛋糕",
				"isHot": false,
				"isNew": true
			},
			{
				"id": 6,
				"name": "Milk Gelato 原味牛乳冰淇淋",
				"image1": "https://oss.51cocoa.com//upload/images/8353be78e8839f0ad0a1ab5a159859a2.jpg",
				"image2": "https://oss.51cocoa.com/public/images/fa/27/3a/f71193fbbed915f5ff7dd09606f7bbc9.jpg?1473058903#w",
				"price": 45,
				"intro": "纯正牛乳，牛乳香，单纯；Gelato10自研，新西兰乳脂奶油；融入鲜奶，单纯之能及。",
				"stock": 999,
				"typeName": "冰淇淋",
				"isHot": false,
				"isNew": true
			},
			{
				"id": 7,
				"name": "轻蛋糕（猫山王奶油）",
				"image1": "https://oss.51cocoa.com//upload/images/20211018/7f7a465515db98755ff5f7f0d94f6455.jpg",
				"image2": "https://oss.51cocoa.com//upload/images/20211018/0e018a26ea360faa07c5b7bcb33b3404.jpg",
				"price": 39,
				"intro": "牛乳烤的戚风坯，覆一层低温奶油，奶油蛋糕中的奶油蛋糕。",
				"stock": 999,
				"typeName": "下午茶",
				"isHot": true,
				"isNew": true
			},
			{
				"id": 9,
				"name": "设计师八音盒",
				"image1": "https://oss.51cocoa.com//upload/images/6672222e335515095405cbbe78b5ff8b.jpg",
				"image2": "https://oss.51cocoa.com/public/images/11/43/77/e9d9ecc930089bec9bb9a178a5b524e2.jpg?1501141154#w",
				"price": 80,
				"intro": "拧紧发条，上满弦，它就是一个魔法",
				"stock": 999,
				"typeName": "设计师礼品",
				"isHot": false,
				"isNew": true
			},
			{
				"id": 10,
				"name": "Rum Cheese Cake 朗姆芝士",
				"image1": "https://oss.51cocoa.com//upload/images/bede904459eb5a81538b3dfa4d4617e7.jpg",
				"image2": "https://oss.51cocoa.com//upload/images/fdcac1a582f7d730c2cb0d5026a1bc34.jpg",
				"price": 298,
				"intro": "香滑的乳酪与打开的一瓶波多黎各朗姆酒;酒香，微苦，清新的柠檬",
				"stock": 20,
				"typeName": "蛋糕",
				"isHot": false,
				"isNew": true
			},
			{
				"id": 11,
				"name": "The Nut Job Big 布莱克",
				"image1": "https://oss.51cocoa.com//upload/images/1d4847308fd92ff10cd9e428b69d730c.jpg",
				"image2": "https://oss.51cocoa.com//upload/images/92148c2ca2af5291bb0a0ec3aa2565c9.jpg",
				"price": 198,
				"intro": "比利时黑巧克力与中国榛子，淡苦与干脆，浓香丰满",
				"stock": 20,
				"typeName": "蛋糕",
				"isHot": false,
				"isNew": true
			},
			{
				"id": 12,
				"name": "A cake with a view 茉莉花",
				"image1": "https://oss.51cocoa.com//upload/images/d114513e1f54fef0bb599c1d443772d0.jpg",
				"image2": "https://oss.51cocoa.com//upload/images/e853511a636a6a7c4974866841dde1f4.jpg",
				"price": 268,
				"intro": "就是茉莉花的味道;新开的茉莉",
				"stock": 20,
				"typeName": "蛋糕",
				"isHot": false,
				"isNew": true
			}
		]
	}
}
```

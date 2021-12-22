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
	"whichPage" : 1,
    "eachPageSize" : 8
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
	"whichPage" : 1,
    "eachPageSize" : 8,
	"typeId" : 3
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
				"typeId": 4
			},
			{
				"id": 8,
				"name": "苏门答腊咖啡盒装（10包入）",
				"image1": "https://oss.51cocoa.com//upload/images/ff9693a8b8fbf6ccfd14fe760527c5ed.jpg",
				"image2": "https://oss.51cocoa.com//upload/images/d32591bbd92e51637422a0e47de442a9.jpg",
				"price": 39,
				"intro": "重烘焙，“湿刨法”苏门答腊咖啡豆，浓厚，几乎没有酸涩口感",
				"stock": 999,
				"typeId": 4
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
	"whichPage" : 1,
    "eachPageSize" : 8,
	"name" : "蛋"
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
				"typeId": 4
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
	"id" : 6
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
		"typeId": 3
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
    "username" : 'bitian',
    "password" : 'bitian',
    "email" : 'bitian',
    "phone" : 'feibitian',
    "address" : 'feibitian',
    "name" : 'feibitian'
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
    "username" : 'bitian',
    "password" : 'bitian'
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

authentication即登陆成功后返回的token值

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
接口状态：出bug

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
    "username" : 'bitian',
    "password" : 'bitian',
    "email" : 'bitian',
    "phone" : 'feibitian',
    "address" : 'feibitian',
    "name" : 'feibitian'
}
```

#### 成功样例

```json

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
    "userId" : 5,
    "goodsId" : 9
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

### 将购物车中的商品加一

### 

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/user/shoppingCart/plus/one

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
    "id" : 1
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

请求方式：POST

Content-Type：application/json

Header:authentication

接口地址（后端写）：/user/shoppingCart/mine
```

#### 请求头

```
authentication
```

#### 请求参数

```json
{
    "userId" : 5
}
```

#### 成功样例

```json

```



### 

### 清空购物车

### 

```apl

```

#### 请求头

```

```

#### 请求参数

```json

```

#### 成功样例

```json

```



### 



# 管理员


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

#### 返回样例

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

### 查询商品

```apl
接口状态：已完成

接口URL：http://www.ccsu1204branch.com/omc/api/common/type/all

请求方式：POST

Content-Type：application/json

接口地址（后端写）：/common/type/all
```

#### 请求参数

```
{
	"from" : 0,
    "eachPageSize" : 8,
    "amount" : 80,
	"typeId" : 1
}
```

#### 返回样例

### 查看商品详情信息



## 用户

### 注册

### 登录

# 有权限接口

# 用户

## 登录

## 注册

## 个人信息

## 更新信息

## 将商品加入购物车

## 将购物车中的商品加一

## 查看我的购物车

## 清空购物车



# 管理员


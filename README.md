## 说明
>**这是本人学习SpringBoot过程所写的demo,学习过程以SpringBoot + MyBatis-Plus + Tomcat(SpringBoot已内置)形式,由于本人是长期iOS开发一枚,也没有Spring前置知识,所以也不会过于扯这方面的知识点.Java方面由于本人有Object-C、Swfit、HTML5、JS等基础,所以在code方面没什么压力.**

**最紧要开心 RESTful APIs**


**简介**：<p>测试</p>


**HOST**:localhost:9090

**联系人**:Jan.

**Version**:1.0

**接口路径**：/v2/api-docs


# hello-controller

## addUser


**接口描述**:


**接口地址**:`/addUser`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|account| account  | query | false |string  |    |
|system OS| 系统类型  | header | false |string  |    |
|token| 登陆获取令牌  | header | false |string  |    |

**200响应示例**:

```json
{
	"code": 0,
	"msg": "",
	"request_id": "",
	"data": {
		"account": "",
		"age": 0,
		"nickName": "",
		"pwd": "",
		"uid": "",
		"userHeadImg": "",
		"userName": ""
	}
}
```

**200响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code| 返回状态码；200:成功  |integer(int32)  | integer(int32)   |
|msg| 描述信息  |string  |    |
|request_id|   |string  |    |
|data| 结果数据  |User  | User   |



**schema属性说明**




**User**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|account | 账号   |string  |    |
|age | 年龄   |integer(int32)  |    |
|nickName |    |string  |    |
|pwd | 密码   |string  |    |
|uid |    |string  |    |
|userHeadImg | 头像   |string  |    |
|userName | 用户名   |string  |    |

**404响应示例**:

```json

```

**404响应参数**:


暂无







**409响应示例**:

```json

```

**409响应参数**:


暂无







**422响应示例**:

```json

```

**422响应参数**:


暂无







**500响应示例**:

```json

```

**500响应参数**:


暂无







**503响应示例**:

```json

```

**503响应参数**:


暂无








**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |返回说明«User»|
| 404 | 找不到资源  |Responses|
| 409 | 业务逻辑异常  |Responses|
| 422 | 参数校验异常  |Responses|
| 500 | 服务器内部错误  |Responses|
| 503 | Hystrix异常  |Responses|
## deleteUserByUid


**接口描述**:


**接口地址**:`/delete`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|system OS| 系统类型  | header | false |string  |    |
|token| 登陆获取令牌  | header | false |string  |    |
|uid| uid  | query | false |integer  |    |

**404响应示例**:

```json

```

**404响应参数**:


暂无







**409响应示例**:

```json

```

**409响应参数**:


暂无







**422响应示例**:

```json

```

**422响应参数**:


暂无







**500响应示例**:

```json

```

**500响应参数**:


暂无







**503响应示例**:

```json

```

**503响应参数**:


暂无








**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 404 | 找不到资源  |Responses|
| 409 | 业务逻辑异常  |Responses|
| 422 | 参数校验异常  |Responses|
| 500 | 服务器内部错误  |Responses|
| 503 | Hystrix异常  |Responses|
## getAll


**接口描述**:


**接口地址**:`/getAll`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|system OS| 系统类型  | header | false |string  |    |
|token| 登陆获取令牌  | header | false |string  |    |

**200响应示例**:

```json
{
	"code": 0,
	"msg": "",
	"request_id": "",
	"data": [
		{
			"account": "",
			"age": 0,
			"nickName": "",
			"pwd": "",
			"uid": "",
			"userHeadImg": "",
			"userName": ""
		}
	]
}
```

**200响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code| 返回状态码；200:成功  |integer(int32)  | integer(int32)   |
|msg| 描述信息  |string  |    |
|request_id|   |string  |    |
|data| 结果数据  |array  | User   |



**schema属性说明**




**User**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|account | 账号   |string  |    |
|age | 年龄   |integer(int32)  |    |
|nickName |    |string  |    |
|pwd | 密码   |string  |    |
|uid |    |string  |    |
|userHeadImg | 头像   |string  |    |
|userName | 用户名   |string  |    |

**404响应示例**:

```json

```

**404响应参数**:


暂无







**409响应示例**:

```json

```

**409响应参数**:


暂无







**422响应示例**:

```json

```

**422响应参数**:


暂无







**500响应示例**:

```json

```

**500响应参数**:


暂无







**503响应示例**:

```json

```

**503响应参数**:


暂无








**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |返回说明«List«User»»|
| 404 | 找不到资源  |Responses|
| 409 | 业务逻辑异常  |Responses|
| 422 | 参数校验异常  |Responses|
| 500 | 服务器内部错误  |Responses|
| 503 | Hystrix异常  |Responses|
## login


**接口描述**:


**接口地址**:`/login`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|account| account  | query | false |string  |    |
|pwd| pwd  | query | false |string  |    |
|system OS| 系统类型  | header | false |string  |    |
|token| 登陆获取令牌  | header | false |string  |    |

**200响应示例**:

```json
{
	"code": 0,
	"msg": "",
	"request_id": "",
	"data": ""
}
```

**200响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code| 返回状态码；200:成功  |integer(int32)  | integer(int32)   |
|msg| 描述信息  |string  |    |
|request_id|   |string  |    |
|data| 结果数据  |string  |    |







**404响应示例**:

```json

```

**404响应参数**:


暂无







**409响应示例**:

```json

```

**409响应参数**:


暂无







**422响应示例**:

```json

```

**422响应参数**:


暂无







**500响应示例**:

```json

```

**500响应参数**:


暂无







**503响应示例**:

```json

```

**503响应参数**:


暂无








**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |返回说明«string»|
| 404 | 找不到资源  |Responses|
| 409 | 业务逻辑异常  |Responses|
| 422 | 参数校验异常  |Responses|
| 500 | 服务器内部错误  |Responses|
| 503 | Hystrix异常  |Responses|
## update


**接口描述**:


**接口地址**:`/update`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|uid| uid  | query | true |integer  |    |
|headImg| headImg  | query | false |string  |    |
|system OS| 系统类型  | header | false |string  |    |
|token| 登陆获取令牌  | header | false |string  |    |
|userName| userName  | query | false |string  |    |

**404响应示例**:

```json

```

**404响应参数**:


暂无







**409响应示例**:

```json

```

**409响应参数**:


暂无







**422响应示例**:

```json

```

**422响应参数**:


暂无







**500响应示例**:

```json

```

**500响应参数**:


暂无







**503响应示例**:

```json

```

**503响应参数**:


暂无








**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 404 | 找不到资源  |Responses|
| 409 | 业务逻辑异常  |Responses|
| 422 | 参数校验异常  |Responses|
| 500 | 服务器内部错误  |Responses|
| 503 | Hystrix异常  |Responses|

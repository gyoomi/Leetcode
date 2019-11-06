## 175. 组合两个表

表1: Person

```text
+-------------+---------+
| 列名         | 类型     |
+-------------+---------+
| PersonId    | int     |
| FirstName   | varchar |
| LastName    | varchar |
+-------------+---------+
PersonId 是上表主键
```

表2: Address

```text
+-------------+---------+
| 列名         | 类型    |
+-------------+---------+
| AddressId   | int     |
| PersonId    | int     |
| City        | varchar |
| State       | varchar |
+-------------+---------+
AddressId 是上表主键
```

编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：`FirstName, LastName, City, State`

```mysql
SELECT
	t1.FirstName,
	t1.LastName,
	t2.City,
	t2.State 
FROM
	Person t1
	LEFT JOIN Address t2 ON t2.PersonId = t1.PersonId
```


















































# Kotlin

## 1.变量和函数

### 变量

在Kotlin中，变量声明的语法与Java有所不同。Kotlin中的变量声明可以使用关键字“var”或“val”。

- 使用 var 声明的变量是可变的，可以被重新赋值。例如：

    ```kotlin
    var a: Int = 1
    a = 2
    ```

- 使用 val 声明的变量是不可变的，一旦被初始化就不能再被重新赋值。例如：

    ```kotlin
    val b: Int = 3
    // 下面这行代码会导致编译错误
    // b = 4
    ```

- 变量类型的声明是可选的，可以通过类型推断来推断变量的类型。例如：

    ```kotlin
    var a = 1 // 变量类型被推断为 Int
    val b = "Hello" // 变量类型被推断为 String
    ```

- 如果变量类型可以被推断出来，也可以使用“:”符号显式地声明变量类型。例如：

    ```kotlin
    var a: Int = 1
    val b: String = "Hello"
    ```

- Kotlin还支持使用“_”作为数字变量中的分隔符，可以提高可读性。例如：

    ```kotlin
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010
    ```

通过上述语法，我们可以非常方便地声明并使用变量。需要注意的是，Kotlin在声明变量时可以使用类型推断，这在某些情况下可以简化代码，但也可能导致类型错误，因此需要根据具体情况选择是否使用。

### 函数

在 Kotlin 中，函数的语法规则如下：

1. 函数声明以关键字 fun 开始，后跟函数名和参数列表。参数列表用括号括起来，可以包含零个或多个参数，参数之间用逗号分隔。

    ```Kotlin
    fun functionName(param1: Type1, param2: Type2): ReturnType {
        // function body
    }
    ```

2. Kotlin 中的函数可以返回一个值，返回值的类型在函数声明中用冒号分隔符指定。

    ```Kotlin
    fun functionName(param1: Type1, param2: Type2): ReturnType {
        // function body
        return result
    }
    ```

3. 如果函数没有返回值，则返回类型可以省略，或者使用 Unit 类型。

    ```Kotlin
    fun functionName(param1: Type1, param2: Type2) {
        // function body
    }
    ```

    或者

    ```Kotlin
    fun functionName(param1: Type1, param2: Type2): Unit {
        // function body
    }
    ```

4. 函数的参数可以有默认值，如果函数调用时没有传递相应的参数，则使用默认值。

    ```Kotlin
    fun functionName(param1: Type1, param2: Type2 = defaultValue) {
        // function body
    }
    ```

5. 函数可以使用命名参数来提高可读性和可维护性。

    ```Kotlin
    functionName(param1 = value1, param2 = value2)
    ```

6. 函数可以使用可变数量的参数，可以接收任意数量的参数。

    ```Kotlin
    fun functionName(vararg param: Type) {
        // function body
    }
    ```

7. Kotlin 中的函数可以是顶层函数，也可以是类中的成员函数，也可以是类的扩展函数。

8. 函数可以被重载，即在同一作用域中可以定义多个同名函数，但它们的参数类型或数量必须不同。

总之，Kotlin 中的函数语法规则与许多其他编程语言类似，但也有一些特殊的语法和规则，如可选参数、命名参数、可变数量参数等，这些特性可以提高代码的可读性和可维护性。

### 语法糖

单表达式函数（Single Expression Function），是 Kotlin 的语法糖之一。

在单表达式函数中，可以直接使用等号“=”来代替花括号“{}”，同时省略 return 关键字。这个语法糖适用于函数体只有一行代码的情况，可以使代码更加简洁和易读。

例如，下面是使用常规函数语法定义的 largerNumber2 函数：

```kotlin
fun largerNumber2(num1: Int, num2: Int): Int {
    return max(num1, num2)
}
```

而使用单表达式函数语法糖可以将代码简化为：

```kotlin
fun largerNumber2(num1: Int, num2: Int) = max(num1, num2)
```

这样可以省略大括号和 return 关键字，使代码更加简洁明了。

需要注意的是，单表达式函数只适用于函数体只有一行代码的情况，如果函数体包含多行代码，还是需要使用常规函数语法来定义函数。

## 2.程序控制逻辑

### if条件语句

- if具有返回值

    在 Kotlin 中，if 表达式是有返回值的，它可以返回一个值并将其赋给一个变量。下面是一个例子：

    ```kotlin
    fun largerNumber(num1: Int, num2: Int): Int {
        return if (num1 > num2) {
            num1
    } else {
            num2
        }
    }
    ```
    
    或者：
    
    ```kotlin
    fun largerNumber(num1: Int, num2: Int) = if (num1 > num2) {
        num1
    } else {
        num2
    }
    ```
    
    甚至：
    
    ```kotlin
    fun largerNumber(num1: Int, num2: Int) = if (num1 > num2) num1 else num2
    ```

### when条件语句

- 精确匹配

    编写一个查询考试成绩的功能，输入一个学生的姓名，返回该学生考试的分数。先用上一小节学习的if语句来实现这个功能：

    ```kotlin
    fun getScore(name: String) = if (name == "Tom") {
        86
    } else if (name == "Jim") {
        77
    } else if (name == "Jack") {
        95
    } else if (name == "Lily") {
        100
    } else {
        0
    }
    ```

    这里定义了一个`getScore()`函数，这个函数接收一个学生姓名参数，然后通过if判断找到该学生对应的考试分数并返回。可以看到，这里再次使用了单行代码函数的语法糖，正如我所说，它真的很常用。

    当判断条件非常多的时候，就是应该考虑使用when语句的时候，将代码改成如下写法：

    ```kotlin
    fun getScore(name: String) = when (name) {
        "Tom" -> 86
        "Jim" -> 77
        "Jack" -> 95
        "Lily" -> 100
    }
    ```

    当执行逻辑只有一行代码时，{ }可以省略。

- 类型匹配
    定义一个checkNumber()函数，如下所示：

    ```kotlin
    fun checkNumber(num: Number) {
        when (num) {
            is Int -> println("number is Int")
            is Double -> println("number is Double")
            else -> println("number not support")
        }
    }
    ```

    上述代码中，`is`关键字就是类型匹配的核心，它相当于Java中的`instanceof`关键字。

    Kotlin中判断字符串或对象是否相等可以直接使用==关键字，而不用像Java那样调用equals()方法。

### for循环语句

Kotlin可以使用如下代码表示一个区间：

```kotlin
val range = 0..10
```

上述代码表示创建了一个0到10的区间，并且两端都是闭区间，这意味着0到10这两个端点都是包含在区间中的，用数学的方式表达出来就是[0, 10]。

Kotlin中可以使用until关键字来创建一个左闭右开的区间，如下所示：

```kotlin
val range = 0 until 10
```

上述代码表示创建了一个0到10的左闭右开区间，它的数学表达方式是[0, 10)。



有了区间之后，我们就可以通过for-in循环来遍历这个区间，比如在main()函数中编写如下代码：

```kotlin
for (i in 0..10) {
    println(i)	//代码会打印从0到10的所有整数
}
```

而如果想跳过其中的一些元素，可以使用step关键字:

```kotlin
fun main() {
    for (i in 0 until 10 step 2) {
        println(i)	//每次执行循环都会在区间范围内递增2，相当于fori循环中i = i + 2的效果。
    }
}
```

如果你想创建一个**降序**的区间，可以使用downTo关键字，用法如下：

```kotlin
fun main() {
	for (i in 10 downTo 1) {
		println(i)
	}
}
```

## 3.Lambda编程

### 1.集合的创建与遍历

#### List集合

```kotlin
val list = ArrayList<String>()
list.add("Apple")
list.add("Banana")
list.add("Orange")
list.add("Pear")
list.add("Grape")
```

这种初始化集合的方式比较烦琐，为此Kotlin专门提供了一个内置的`listOf()`函数来简化初始化集合的写法，如下所示：

```kotlin
val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
```

尝试一下使用for-in循环来遍历这个水果集合，在main()函数中编写如下代码：

```kotlin
fun main() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    for (fruit in list) {
        println(fruit)
    }
}
/*
输出：
Apple
Banana
Orange
Pear
Grape
*/
```

注意，`listOf()`函数创建的是一个不可变的集合。不可变的集合指的就是该集合**只能用于读取**，我们无法对集合进行添加、修改或删除操作。

#### mutableList集合

确实需要创建一个可变的集合,使用`mutableListOf()`函数就可以了，示例如下：

```kotlin
fun main() {
    val list = mutableListOf("Apple", "Banana", "Orange", "Pear", "Grape")
    list.add("Watermelon")
    for (fruit in list) {
        println(fruit)
    }
}
```

对比：

```kotlin
val mutableList = mutableListOf(1, 2, 3) // 创建可变列表
mutableList.add(4) // 可以添加元素
mutableList.removeAt(0) // 可以删除元素
mutableList[0] = 5 // 可以更新元素

val list = listOf(1, 2, 3) // 创建不可变列表
// list.add(4) // 不可以添加元素（编译错误）
// list.removeAt(0) // 不可以删除元素（编译错误）
// list[0] = 5 // 不可以更新元素（编译错误）
```

#### Set集合和List集合区别：

```kotlin
val set = setOf(1, 2, 3, 2) // 创建Set集合
println(set) // 输出：[1, 2, 3]，重复的2被去除了

val list = listOf(1, 2, 3, 2) // 创建List集合
println(list) // 输出：[1, 2, 3, 2]，元素顺序与添加顺序相同

val mutableSet = mutableSetOf(1, 2, 3, 2) // 创建可变Set集合
mutableSet.add(4) // 添加元素
mutableSet.remove(2) // 删除元素
println(mutableSet) // 输出：[1, 3, 4]

val mutableList = mutableListOf(1, 2, 3, 2) // 创建可变List集合
mutableList.add(4) // 添加元素
mutableList.removeAt(0) // 删除元素
mutableList[1] = 5 // 更新元素
println(mutableList) // 输出：[2, 5, 3, 4]
```

#### Map集合

初始化：

- 类Java：

    ```kotlin
    val map = HashMap<String, Int>()
    map.put("Apple", 1)
    map.put("Banana", 2)
    map.put("Orange", 3)
    map.put("Pear", 4)
    map.put("Grape", 5)
    ```

- Kotlin推荐使用一种类似于数组下标的语法结构进行初始化：

    ```kotlin
    val map = HashMap<String, Int>()
    map["Apple"] = 1
    map["Banana"] = 2
    map["Orange"] = 3
    map["Pear"] = 4
    map["Grape"] = 5
    ```

- Kotlin提供了一对mapOf()和mutableMapOf()函数来继续简化Map的用法:

    ```kotlin
    val map = mapOf("Apple" to 1, "Banana" to 2, "Orange" to 3, "Pear" to 4, "Grape" to 5)
    ```

    这里的键值对组合看上去好像是使用to这个关键字来进行关联的，但其实to并不是关键字，而
    是一个infix函数，我们会在本书第9章的Kotlin课堂中深入探究infix函数的相关内容。

### 2.集合的函数式API

```kotlin
val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
var maxLengthFruit = ""
for (fruit in list) {
	if (fruit.length > maxLengthFruit.length) {
		maxLengthFruit = fruit
	}
}
println("max length fruit is " + maxLengthFruit)
```

简写成:

```kotlin
val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
val maxLengthFruit = list.maxBy { it.length }
println("max length fruit is " + maxLengthFruit)
```

Lambda表达式的语法结构：

```kotlin
{参数名1: 参数类型, 参数名2: 参数类型 -> 函数体}
```

将Lambda表达式的语法结构传入到maxBy函数中了，如下所示：

```kotlin
val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
val lambda = { fruit: String -> fruit.length }
val maxLengthFruit = list.maxBy(lambda)
```

不需要专门定义一个lambda变量，而是可以直接将lambda表达式传入maxBy函数当中，因此第一步简化如下所示：

```kotlin
val maxLengthFruit = list.maxBy({ fruit: String -> fruit.length })
```

Kotlin规定，当Lambda参数是函数的最后一个参数时，可以将Lambda表达式移到函数括号的外面，如下所示：

```kotlin
val maxLengthFruit = list.maxBy() { fruit: String -> fruit.length }
```

如果Lambda参数是函数的唯一一个参数的话，还可以将函数的括号省略：

```kotlin
val maxLengthFruit = list.maxBy { fruit: String -> fruit.length }
```

由于Kotlin有类型推导机制，Lambda表达式中的参数列表其实在大多数情况下不必声明参数类型，因此代码可以进一步简化成：

```kotlin
val maxLengthFruit = list.maxBy { fruit -> fruit.length }
```

最后，当Lambda表达式的参数列表中**只有一个参数时，也不必声明参数名**，而是可以使用**it关键字来代替**，那么代码就变成了：

```kotlin
val maxLengthFruit = list.maxBy { it.length }
```

#### 几个集合中比较常用的函数式API

##### 集合中的map函数

最常用的一种函数式API，它用于将集合中的每个元素都映射成一个另外的值，映射的规则在Lambda表达式中指定，最终生成一个新的集合。比如，这里我们希望让所有的水果名都变成大写模式，就可以这样写：

```kotlin
fun main() {
    val list = listOf("Apple", "Banana", "Orange", "Pear","Grape", "Watermelon")
    val newList = list.map { it.toUpperCase() }
    for (fruit in newList) {
        println(fruit)
    }
}
```

在map函数的Lambda表达式中指定将单词转换成了大写模式,运行一下代码:

![image-20230404182514663](https://cdn.jsdelivr.net/gh/ChengYang1998/blogImage@main/PicGo/image-20230404182514663.png)

##### filter函数

用来过滤集合中的数据的，它可以单独使用，也可以配合刚才的map函数一起使用。

​	比如我们只想保留5个字母以内的水果，就可以借助filter函数来实现，代码如下所示：

```kotlin
fun main() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
    val newList = list.filter { it.length <= 5 }
        .map { it.toUpperCase() }
    for (fruit in newList) {
        println(fruit)
    }
}
```

​	可以看到，这里同时使用了filter和map函数，并通过Lambda表示式将水果单词长度限制在5个字母以内。重新运行一下代码，结果如图所示:

![image-20230404182721630](https://cdn.jsdelivr.net/gh/ChengYang1998/blogImage@main/PicGo/image-20230404182721630.png)

​	上述代码中我们是先调用了filter函数再调用map函数。如果你改成先调用map函数再调用filter函数，也能实现同样的效果，但是效率就会差很多，因为这样相当于要对集合中所有的元素都进行一次映射转换后再进行过滤，这是完全不必要的。而**先过滤再映射转换**，就会明显高效得多。

##### any和all函数

- any函数用于判断集合中是否至少存在一个元素满足指定条件。

- all函数用于判断集合中是否所有元素都满足指定条件。
- 返回 `Boolean`

实例：

```kotlin
fun main() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
    //集合中是否存在5个字母以内的单词
    val anyResult = list.any { it.length <= 5 }
    //是否所有单词都在5个字母以内
    val allResult = list.all { it.length <= 5 }
    println("anyResult is " + anyResult + ", allResult is " + allResult)
}
```

### 3.Java函数式API的使用

在Kotlin代码中调用了一个Java方法，并且该方法**只接收一个Java单抽象方法接口参数**，就可以使用函数式API。

Java单抽象方法接口指的是接口中**只有一个待实现方法**，如果接口中有多个待实现方法，则无法使用函数式API。

Java原生API中有一个最为常见的单抽象方法接口——Runnable接口。这个接口中只有一个待实现的run()方法，定义如下：

```java
public interface Runnable {
	void run();
}
```

​	对于任何一个Java方法，只要它接收Runnable参数，就可以使用函数式API。

​	Runnable接口主要还是结合线程来一起使用的，因此通过Java的线程类Thread来学习一下。

​	Thread类的构造方法中接收了一个Runnable参数，我们可以使用如下Java代码创建并执行一个子线程：

```java
new Thread(new Runnable() {

    @Override
    public void run() {
        System.out.println("Thread is running");
    }
}).start();
```

​	这里使用了匿名类的写法，我们创建了一个Runnable接口的匿名类实例，并将它传给了Thread类的构造方法，最后调用Thread类的start()方法执行这个线程。

​	将这段代码翻译成Kotlin版本，写法将如下所示：

```kotlin
Thread(object : Runnable {
    override fun run() {
        println("Thread is running")
    }
}).start()
```

函数式编程对代码进行精简，如下所示：

```kotlin
Thread(Runnable {
    println("Thread is running")
}).start()
```

举个例子，Android中有一个极为常用的点击事件接口OnClickListener，其定义如下：

```java
public interface OnClickListener {
	void onClick(View v);
}
```

这又是一个单抽象方法接口。假设现在我们拥有一个按钮button的实例，然后使用Java代码去注册这个按钮的点击事件，需要这么写：

```java
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //do something
    }
});
```

用Kotlin代码:

```kotlin
button.setOnClickListener {
    //do something
}
```

## 4.空指针检查

>   在大型项目中，想要完全规避空指针异常几乎是不可能的事情，Kotlin科学地解决了这个问题

```java
public void doStudy(Study study) {
	study.readBooks();
	study.doHomework();
}
```

这段Java代码安全吗？不一定，因为这要取决于调用方传入的参数是什么，如果我们向doStudy()方法传入了一个null参数，那么毫无疑问这里就会发生空指针异常。因此，更加稳妥的做法是在调用参数的方法之前先进行一个判空处理。

```kotlin
fun doStudy(study: Study) {
	study.readBooks()
	study.doHomework()
}
```

看上去和刚才的Java版本并没有什么区别，但实际上它是**没有空指针风险**的，因为Kotlin**默认所有的参数和变量都不可为空**，所以这里传入的Study参数也一定不会为空，我们可以放心地调用它的任何函数。如果你尝试向doStudy()函数传入一个null参数，则会提示如图错误：

![image-20230406104529406](https://cdn.jsdelivr.net/gh/ChengYang1998/blogImage@main/PicGo/image-20230406104529406.png)

​	也就是说，Kotlin将空指针异常的检查提前到了编译时期，如果我们的程序存在空指针异常的风险，那么在编译的时候会直接报错，修正之后才能成功运行，这样就可以保证程序在运行时期不会出现空指针异常了。

​	Kotlin提供了另外一套可为空的类型系统，只不过在使用可为空的类型系统时，我们需要在编译时期就将所有潜在的空指针异常都处理掉，否则代码将无法编译通过。

​	可为空的类型系统就是在类名的后面加上一个问号。比如，Int表示不可为空的整型，而Int?就表示可为空的整型；String表示不可为空的字符串，而String?就表示可为空的字符串。
​	回到刚才的doStudy()函数，如果希望传入的参数可以为空，那么就应该将参数的类型由Study改成Study?，如图所示：

![image-20230406105105937](https://cdn.jsdelivr.net/gh/ChengYang1998/blogImage@main/PicGo/image-20230406105105937.png)

​	然而，在doStudy()函数中调用参数的readBooks()和doHomework()方法时，却出现了一个红色下滑线的错误提示。由于我们将参数改成了可为空的Study?类型，此时调用参数的readBooks()和doHomework()方法都可能造成空指针异常，因此Kotlin在这种情况下不允许编译通过。

​	只要把空指针异常都处理掉就可以了，比如做个判断处理。

```kotlin
fun doStudy(study: Study?) {
    if (study != null) {
        study.readBooks()
        study.doHomework()
    }
}
```

现在代码就可以正常编译通过了，并且还能保证完全不会出现空指针异常。

### 判空辅助工具

#### 1.最常用的操作符 ?. 

```kotlin
if (a != null) {
	a.doSomething()
}
```

简化成：

```kotlin
a?.doSomething()
```

#### 2.非常常用的 ?: 操作符

这个操作符的左右两边都接收一个表达式，如果左边表达式的结果不为空就返回左边表达式的结果，否则就返回右边表达式的结果。

```kotlin
val c = if (a ! = null) {
	a
} else {
	b
}
```

使用 ?: 操作符就可以简化成：

```kotlin
val c = a ?: b
```



演示：

```kotlin
fun getTextLength(text: String?): Int {
	if (text != null) {
		return text.length
	}
	return 0
}
```

可以借助操作符让它变得简单，如下所示：

```kotlin
fun getTextLength(text: String?) = text?.length ?: 0
```

#### 3.非空断言工具 !!

```kotlin
var content: String? = "hello"
fun main() {
    if (content != null) {
        printUpperCase()
    }
}

fun printUpperCase() {
    val upperCase = content.toUpperCase()
    println(upperCase)
}
```

​	这里定义了一个可为空的全局变量content，然后在main()函数里先进行一次判空操作，当content不为空的时候才会调用printUpperCase()函数，printUpperCase()函数里，将content转换为大写模式，最后打印出来。

​	看上去好像逻辑没什么问题，但是这段代码一定是无法运行的。因为printUpperCase()函数并不知道外部已经对content变量进行了非空检查，在调用
toUpperCase()方法时，还认为这里存在空指针风险，从而无法编译通过。

​	在这种情况下，如果我们想要强行通过编译，可以使用非空断言工具，写法是在对象的后面加上!!，如下所示：

```kotlin
fun printUpperCase() {
    val upperCase = content!!.toUpperCase()
    println(upperCase)
}
```

这是一种有风险的写法，意在告诉Kotlin，我非常确信这里的对象不会为空，所以不用你来帮我做空指针检查了，如果出现问题，你可以直接抛出空指针异常，后果由我自己承担。

#### 4.let函数

>   这个函数提供了函数式API的编程接口，并将原始调用对象作为参数传递到Lambda表达式中

```kotlin
obj.let { obj2 ->
// 编写具体的业务逻辑
}
```

这里调用了obj对象的let函数，然后Lambda表达式中的代码就会立即执行，并且这个obj对象本身还会作为参数传递到Lambda表达式中。

比如：

```kotlin
fun doStudy(study: Study?) {
	study?.readBooks()
	study?.doHomework()
}
```

此时，每次调用study对象的方法时都要进行一次if判断。

结合使用 ?.操作符 和 let函数 来对代码进行优化：

```kotlin
fun doStudy(study: Study?) {
    study?.let { 
        it.readBooks()
        it.doHomework()
    }?: run {
    // 对空进行处理，或者直接返回
	}
}
```

>   在这个过程中，是将需要处理的对象作为`let`函数的参数传入,其他线程无法修改该对象，因为该对象在`let`函数的作用域内，只有该作用域内的代码才能访问和修改该对象。

let函数是可以处理全局变量的判空问题的，而if判断语句则无法做到这一点。比如我们将doStudy()函数中的参数变成一个全局变量，使用let函数仍然可以正常工作，但使用if判断语句则会提示错误:

![image-20230406111900482](https://cdn.jsdelivr.net/gh/ChengYang1998/blogImage@main/PicGo/image-20230406111900482.png)

​	之所以这里会报错，是因为全局变量的值随时都有可能被其他线程所修改，即使做了判空处理，仍然无法保证if语句中的study变量没有空指针风险。

## 5.小技巧

### 1.字符串内嵌表达式

Kotlin中字符串内嵌表达式的语法规则：

```kotlin
"hello, ${obj.name}. Nice to meet you!"
```

可以看到，Kotlin允许我们在字符串里嵌入`${}`这种语法结构的表达式，并在运行时使用表达式执行的结果替代这一部分内容。

另外，当表达式中仅有一个变量的时候，还可以将两边的大括号省略，如下所示：

```kotlin
"hello, $name. Nice to meet you!" 
```

拼接字符串的写法:

```kotlin
val brand = "Samsung" 
val price = 1299.99 
println("Cellphone(brand=" + brand + ", price=" + price + ")") 
```

而使用字符串内嵌表达式的写法就变得非常简单了，如下所示：

```kotlin
val brand = "Samsung" 
val price = 1299.99 
println("Cellphone(brand=$brand, price=$price)") 
```

### 2.函数的参数默认值

>   可以在定义函数的时候给任意参数设定一个默认值，这样当调用此函数时就不会强制要求调用方为此参数传值，在没有传值的情况下会自动使用参数的默认值。

给参数设定默认值的方式:

```kotlin
fun printParams(num: Int, str: String = "hello") {
	println("num is $num , str is $str")
}
```

可以看到，这里我们给printParams()函数的第二个参数设定了一个默认值，这样当调用printParams()函数时，可以选择给第二个参数传值，也可以选择不传，**在不传的情况下就会自动使用默认值**。

​	如果想让第一个参数使用默认值该怎么办呢？模仿刚才的写法肯定是行不通的，因为编译器会认为我们想把字符串赋值给第一个num参数，从而报类型不匹配的错误，如图所示:

<img src="https://cdn.jsdelivr.net/gh/ChengYang1998/blogImage@main/PicGo/image-20230406114001661.png" alt="image-20230406114001661" style="zoom:80%;" />

Kotlin提供了另外一种神奇的机制，就是可以通过键值对的方式来传参，从而不必像传统写法那样按照参数定义的顺序来传参。比如调用printParams()函数，我们还可以这样写：

```kotlin
printParams(str = "world", num = 123)
```

>   此时哪个参数在前哪个参数在后都无所谓，Kotlin可以准确地将参数匹配上

而使用这种键值对的传参方式之后，我们就可以省略num参数了，代码如下：

```kotlin
fun printParams(num: Int = 100, str: String) {
	println("num is $num , str is $str")
}
fun main() {
	printParams(str = "world")
}
```



这个功能可以在很大程度上替代次构造函数的作用:

```kotlin
class Student(val sno: String, val grade: Int, name: String, age: Int) :
    Person(name, age) {
    constructor(name: String, age: Int) : this("", 0, name, age) {
    }
    constructor() : this("", 0) {
    }
}
```

这个类名为`Student`，它继承自`Person`类，有四个主要的属性：`sno`、`grade`、`name`和`age`，其中`sno`和`grade`是用`val`修饰的不可变属性，`name`和`age`是可变属性。

该类有三个构造函数，其中一个是主构造函数，另外两个是次要构造函数。

主构造函数有四个参数：`sno`、`grade`、`name`和`age`，其中`sno`和`grade`是用`val`修饰的不可变属性，`name`和`age`是普通参数。主构造函数的实现中调用了`Person`类的构造函数来初始化`name`和`age`属性。

第一个次要构造函数有两个参数：`name`和`age`，它调用了主构造函数，传入了空字符串和0作为`sno`和`grade`的默认值。

第二个次要构造函数没有参数，它也调用了主构造函数，传入了空字符串和0作为`sno`和`grade`的默认值。

这种写法在Kotlin中其实是不必要的，因为我们完全可以通过只编写一个主构造函数，然后给参数设定默认值的方式来实现，代码如下所示：

```kotlin
class Student(val sno: String = "", val grade: Int = 0, name: String = "", age: Int = 0) :
    Person(name, age)
```

在给主构造函数的每个参数都设定了默认值之后，我们就可以使用任何传参组合的方式来对Student类进行实例化，当然也包含了刚才两种次构造函数的使用场景。



## 6.标准函数和静态方法

>   Kotlin的标准函数指的是Standard.kt文件中定义的函数，任何Kotlin代码都可以自由地调用所有的标准函数。

### 1.with函数

with函数接收两个参数：第一个参数可以是一个任意类型的对象，第二个参数是一个Lambda表达式。with函数会在Lambda表达式中提供第一个参数对象的上下文，并使用Lambda表达式中的最后一行代码作为返回值返回。示例代码如下：

```kotlin
val result = with(obj) {
// 这里是obj的上下文
    "value" // with函数的返回值
}
```

它可以在连续调用同一个对象的多个方法时让代码变得更加精简。

比如有一个水果列表，现在我们想吃完所有水果，并将结果打印出来，就可以这样写：

```kotlin
val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
val builder = StringBuilder()
builder.append("Start eating fruits.\n")
for (fruit in list) {
    builder.append(fruit).append("\n")
}
builder.append("Ate all fruits.")
val result = builder.toString()
println(result)
```

这段代码的逻辑很简单，就是使用StringBuilder来构建吃水果的字符串，最后将结果打印出来。如果运行一下上述代码，那么一定会得到如图所示的打印结果。

![image-20230406133410614](https://cdn.jsdelivr.net/gh/ChengYang1998/blogImage@main/PicGo/image-20230406133410614.png)

仔细观察上述代码，会发现连续调用了多次builder对象的方法。其实这个时候就可以考虑使用with函数来让代码变得更加精简，如下所示：

```kotlin
val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
val result = with(StringBuilder()) {
    append("Start eating fruits.\n")
    for (fruit in list) {
        append(fruit).append("\n")
    }
    append("Ate all fruits.")
    toString()
}
println(result)
```

### 2.run函数

-   run函数通常不会直接调用，而是要在某个对象的基础上调用。
-   run函数只接收一个Lambda参数，并且会在Lambda表达式中提供调用对象的上下文。

```kotlin
val result = obj.run {
	// 这里是obj的上下文
	"value" // run函数的返回值
}
```

使用run函数来修改一下吃水果的这段代码，如下所示：

```kotlin
val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
val result = StringBuilder().run {
    append("Start eating fruits.\n")
    for (fruit in list) {
        append(fruit).append("\n")
    }
    append("Ate all fruits.")
    toString()
}
println(result)
```

总体来说变化非常小，只是将调用with函数并传入StringBuilder对象改成了调用
StringBuilder对象的run方法，其他都没有任何区别。

### 3.apply函数

。apply函数和run函数也是极其类似的，都要在某个对象上调用，并且只接收一个Lambda参数，也会在Lambda表达式中提供调用对象的上下文，但是apply函数无法指定返回值，而是会自动返回调用对象本身。示例代码如下：

```kotlin
val result = obj.apply {
	// 这里是obj的上下文
}
// result == obj
```

再使用apply函数来修改一下吃水果的这段代码，如下所示：

```kotlin
val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
val result = StringBuilder().apply {
    append("Start eating fruits.\n")
    for (fruit in list) {
        append(fruit).append("\n")
    }
    append("Ate all fruits.")
}
println(result.toString())
```

注意这里的代码变化，由于apply函数无法指定返回值，只能返回调用对象本身，因此这里的result实际上是一个StringBuilder对象，所以我们在最后打印的时候还要再调用它的toString()方法才行。



### 函数总结：

| 函数  | 类型     | Lambda 接收者 | 引用对象方式 | 返回值                  |
| ----- | -------- | ------------- | ------------ | ----------------------- |
| let   | 扩展函数 | 调用对象      | 使用 `it`    | Lambda 表达式的结果     |
| with  | 普通函数 | 传入对象      | 直接访问     | Lambda 表达式的结果     |
| run   | 扩展函数 | 调用对象      | 直接访问     | Lambda 表达式的结果     |
| apply | 扩展函数 | 调用对象      | 直接访问     | 调用 `apply` 的对象本身 |

### 定义静态方法

>   静态方法在某些编程语言里面又叫作类方法，指的就是那种不需要创建实例就能调用的方法，所有主流的编程语言都会支持静态方法这个特性。

在Java中定义一个静态方法非常简单，只需要在方法上声明一个static关键字就可以了。

```java
public class Util {
    public static void doAction() {
        System.out.println("do action");
    }
}
```

这是一个非常简单的工具类,上述代码中的doAction()方法就是一个静态方法。调用静态方法并不需要创建类的实例，而是可以直接以Util.doAction()这种写法来调用。因而静态方法非常适合用于编写一些工具类的功能，因为工具类通常没有创建实例的必要，基本是全局通用的。

但是和绝大多数主流编程语言不同的是，Kotlin却极度弱化了静态方法这个概念，想要在Kotlin中定义一个静态方法反倒不是一件容易的事。

像工具类这种功能，在Kotlin中就非常推荐使用单例类的方式来实现，比如上述的Util工具类，如果使用Kotlin来实现的话就可以这样写：

```kotlin
object Util {
    fun doAction() {
        println("do action")
    }
}
```

虽然这里的doAction()方法并不是静态方法，但是我们可以使用Util.doAction()的方式来调用，这就是单例类所带来的便利性。

不过，使用单例类的写法会将整个类中的所有方法全部变成类似于静态方法的调用方式，而如果只是希望让类中的某一个方法变成静态方法的调用方式就可以使用companion object，示例如下：

```kotlin
class Util {
    fun doAction1() {
        println("do action1")
    }
    companion object {
        fun doAction2() {
            println("do action2")
        }
    }
}
```

类中直接定义了一个doAction1()方法，又在companion object中定义了一个doAction2()方法。现在这两个方法就有了本质的区别，因为doAction1()方法是一定要**先创建Util类的实例**才能调用的，而doAction2()方法可以**直接使用Util.doAction2()**的方式调用。

不过，doAction2()方法其实也并不是静态方法，companion object这个关键字实际上会在Util类的内部创建一个伴生类，而doAction2()方法就是定义在这个伴生类里面的实例方法。只是Kotlin会保证Util类始终只会存在一个伴生类对象，因此调用Util.doAction2()方法实际上就是调用了Util类中伴生对象的doAction2()方法。

由此可以看出，Kotlin确实没有直接定义静态方法的关键字，但是提供了一些语法特性来支持类似于静态方法调用的写法，这些语法特性基本可以满足我们平时的开发需求了。

而真正的静态方法， Kotlin仍然提供了两种实现方式：

-   方法加上@JvmStatic注解（@JvmStatic注解只能加在单例类或companion object中的方法上，如果你尝试加在一个普通方法上，会直接提示语法错误。）

-   **顶层方法**

    顶层方法指的是那些没有定义在任何类中的方法，比如我们在上一节中编写的main()方法。Kotlin编译器会将所有的顶层方法全部编译成静态方法，因此只要你定义了一个顶层方法，那么它就一定是静态方法。

    创建一个Kotlin文件，在这个文件中定义的任何方法都会是顶层方法。

    调用这个方法：不用管包名路径，也不用创建实例，直接键入method()即可。

    在Java代码中调用：Kotlin文件.method()








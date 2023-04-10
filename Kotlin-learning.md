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

### 3.使用Intent传递对象

#### 1.Serializable方式

```kotlin
class Person : Serializable {
	var name = ""
	var age = 0
}
```

实现接口即可,同Java。

### 2.Parcelable方式

```kotlin
@Parcelize
class Person(var name: String, var age: Int) : Parcelable
```

Kotlin给我们提供了更加简便的用法，但**前提是要传递的所有数据都必须封装在对象的主构造函数中**才行。

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

## 7.对变量延迟初始化

MainActivity中适配器的代码：

```kotlin
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var adapter: MsgAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        ...
        adapter = MsgAdapter(msgList)
        ...
    }
    override fun onClick(v: View?) {
        ...
        adapter?.notifyItemInserted(msgList.size - 1)
        ...
    }
}
```

这里将adapter设置为了全局变量，但是它的初始化工作是在onCreate()方法中进行的，因此不得不先将adapter赋值为null，同时把它的类型声明成MsgAdapter?。

​	虽然我们会在onCreate()方法中对adapter进行初始化，同时能确保onClick()方法必然在onCreate()方法之后才会调用，但是在onClick()方法中调用adapter的任何方法时仍然要进行判空处理才行，否则编译肯定无法通过。

​	当代码中有了越来越多的全局变量实例时，这个问题就会变得越来越明显。

​	这个问题其实是有解决办法的，就是对全局变量进行**延迟初始化**。

​	延迟初始化使用的是`lateinit`关键字，它可以告诉Kotlin编译器，我会在晚些时候对这个变量进行初始化，这样就不用在一开始的时候将它赋值为null了。

使用延迟初始化的方式对上述代码进行优化，如下所示：

```kotlin
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var adapter: MsgAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        ...
        adapter = MsgAdapter(msgList)
        ...
    }
    override fun onClick(v: View?) {
        ...
        adapter.notifyItemInserted(msgList.size - 1)
        ...
    }
}
```

另外，还可以通过代码来判断一个全局变量是否已经完成了初始化，这样在某些时候能够有效地避免重复对某一个变量进行初始化操作，示例代码如下：

```kotlin
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var adapter: MsgAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        ...
        if (!::adapter.isInitialized) {
            adapter = MsgAdapter(msgList)
        }
        ...
    }
}
```

`::adapter.isInitialized`可用于判断adapter变量是否已经初始化。

## 8.使用密封类优化代码

>   密封类通常可以结合RecyclerView适配器中的ViewHolder一起使用，很多时候
>   帮助写出更加规范和安全的代码

密封类具体的作用，一个简单的例子。新建一个Kotlin文件，文件名叫Result.kt，然后在这个文件中编写如下代码：

```kotlin
interface Result
class Success(val msg: String) : Result
class Failure(val error: Exception) : Result
```

定义了一个Result接口，用于表示某个操作的执行结果，接口中不用编写任何内容。然后定义了两个类去实现Result接口：一个Success类用于表示成功时的结果，一个Failure类用于表示失败时的结果，这样就把准备工作做好了。

接下来再定义一个getResultMsg()方法，用于获取最终执行结果的信息，代码如下所示：

```kotlin
fun getResultMsg(result: Result) = when (result) {
    is Success -> result.msg
    is Failure -> result.error.message
    else -> throw IllegalArgumentException()
}
```

getResultMsg()方法中接收一个Result参数。我们通过when语句来判断：

如果Result属于Success，那么就返回成功的消息；

如果Result属于Failure，那么就返回错误信息。

​	但讨厌的是，接下来不得不再编写一个else条件，否则Kotlin编译器会认为这里缺少条件分支，代码将无法编译通过。但实际上Result的执行结果只可能是Success或者Failure，这个else条件是永远走不到的，所以我们在这里直接抛出了一个异常，只是为了满足Kotlin编译器的语法检查而已。

​	另外，编写else条件还有一个潜在的风险。如果我们现在新增了一个Unknown类并实现Result接口，用于表示未知的执行结果，但是忘记在getResultMsg()方法中添加相应的条件分支，编译器在这种情况下是不会提醒我们的，而是会在运行的时候进入else条件里面，从而抛出异常并导致程序崩溃。

>   Kotlin的密封类可以很好地解决这个问题

密封类的关键字是sealed class

我们将Result接口改造成密封类的写法：

```kotlin
sealed class Result
class Success(val msg: String) : Result()
class Failure(val error: Exception) : Result()
```

>   由于密封类是一个可继承的类，因此在继承它的时候需要在后面加上一对括号

此时在getResultMsg()方法中的else条件已经不再需要了，如下所示：

```kotlin
fun getResultMsg(result: Result) = when (result) {
    is Success -> result.msg
    is Failure -> "Error is ${result.error.message}"
}
```

因为当在when语句中传入一个密封类变量作为条件时，Kotlin编译器会自动检查该密封类有哪些子类，并**强制要求你将每一个子类所对应的条件全部处理**。这样就可以保证，即使没有编写else条件，也不可能会出现漏写条件分支的情况。而如果我们现在新增一个Unknown类，并也让它继承自Result，此时getResultMsg()方法就一定会报错，必须增加一个Unknown的条件分支才能让代码编译通过。

>密封类及其所有子类只能定义在同一个文件的顶层位置，不能嵌套在其他类中，这是被密封类底层的实现机制所限制的。



如何结合MsgAdapter中的ViewHolder一起使用，并顺便优化一下MsgAdapter中的代码:

## 9.扩展函数

>   扩展函数表示即使在不修改某个类的源码的情况下，仍然可以打开这个类，向该类添加新的函数。

语法结构:

```kotlin
fun ClassName.methodName(param1: Int, param2: Int): Int {
    return 0
}
```

定义扩展函数只需要在函数名的前面加上一个ClassName.的语法结构，就表示将该函数添加到指定类当中了。

一段字符串中可能包含字母、数字和特殊符号等字符，现在我们希望统计字符串中字母的数量:

```kotlin
object StringUtil {
    fun lettersCount(str: String): Int {
        var count = 0
        for (char in str) {
            if (char.isLetter()) {
                count++
            }
        }
        return count
    }
}
```

尝试使用扩展函数的方式来优化:

由于我们希望向String类中添加一个扩展函数，因此需要先创建一个String.kt文件。

文件名虽然并没有固定的要求，但是建议向哪个类中添加扩展函数，就定义一个同名的Kotlin文件，这样便于以后查找。当然，扩展函数也是可以定义在任何一个现有类当中的，并不一定非要创建新文件。不过通常来说，最好将它定义成顶层方法，这样可以让扩展函数拥有全局的访问域。
现在在String.kt文件中编写如下代码：

```kotlin
fun String.lettersCount(): Int {
    var count = 0
    for (char in this) {
        if (char.isLetter()) {
            count++
        }
    }
    return count
}
```

现在lettersCount()方法定义成了String类的扩展函数，那么函数中就自动拥有了String实例的上下文。

因此lettersCount()函数就不再需要接收一个字符串参数了，而是直接遍历this即可，因为现在this就代表着字符串本身。
定义好了扩展函数之后，统计某个字符串中的字母数量只需要这样写即可：

```kotlin
val count = "ABC123xyz!@#".lettersCount() 
```

看上去就好像是String类中自带了lettersCount()方法一样。



## 10.运算符重载

| 语法糖表达式 | 实际调用函数        |
| ------------ | ------------------- |
| a + b        | a.plus(b)           |
| a - b        | a.minus(b)          |
| a * b        | a.times(b)          |
| a / b        | a.div(b)            |
| a % b        | a.rem(b)            |
| a++          | a.inc()             |
| a--          | a.dec()             |
| +a           | a.unaryPlus()       |
| -a           | a.unaryMinus()      |
| !a           | a.not()             |
| a == b       | a.equals(b)         |
| a > b        | a.compareTo(b) > 0  |
| a < b        | a.compareTo(b) < 0  |
| a >= b       | a.compareTo(b) >= 0 |
| a <= b       | a.compareTo(b) <= 0 |
| a..b         | a.rangeTo(b)        |
| a[b]         | a.get(b)            |
| a[b] = c     | a.set(b, c)         |
| a in b       | b.contains(a)       |

>   Kotlin语法糖。Java中有许多语言内置的运算符关键字，如+ - * / % ++ --。而Kotlin允许我们将所有的运算符甚至其他的关键字进行重载，从而拓展这些运算符和关键字的用法。

运算符重载:使用的是 `operator` 关键字。

在指定函数的前面加上operator关键字，就可以实现运算符重载的功能了。

但问题在于这个指定函数是什么？这是运算符重载里面比较复杂的一个问题，因为不同的运算符对应的重载函数也是不同的。比如说加号运算符对应的是plus()函数，减号运算符对应的是minus()函数。

以加号运算符为例，如果想要实现让两个对象相加的功能，那么它的语法结构如下：

```kotlin
class Obj {
    operator fun plus(obj: Obj): Obj {
// 处理相加的逻辑
    }
}
```

在上述语法结构中，关键字operator和函数名plus都是固定不变的，而接收的参数和函数返回值可以根据你的逻辑自行设定。那么上述代码就表示一个Obj对象可以与另一个Obj对象相加，最终返回一个新的Obj对象。对应的调用方式如下：

```kotlin
val obj1 = Obj()
val obj2 = Obj()
val obj3 = obj1 + obj2
```

这种`obj1 + obj2`的语法看上去好像很神奇，但其实这就是Kotlin给我们提供的一种语法糖，它会在编译的时候被转换成`obj1.plus(obj2)`的调用方式。

演示：

定义Money类的结构，这里我准备让Money的主构造函数接收一个value参数，用于表示钱的金额。创建Money.kt文件，代码如下所示：

```kotlin
class Money(val value: Int)
```

使用运算符重载来实现让两个Money对象相加的功能：

```kotlin
class Money(val value: Int) {
    operator fun plus(money: Money): Money {
        val sum = value + money.value
        return Money(sum)
    }
}
```

测试：

```kotlin
val money1 = Money(5)
val money2 = Money(10)
val money3 = money1 + money2
println(money3.value)	//15
```

对同一个运算符进行多重重载,Money对象能够直接和数字相加：

```kotlin
class Money(val value: Int) {
    operator fun plus(money: Money): Money {
        val sum = value + money.value
        return Money(sum)
    }
    operator fun plus(newValue: Int): Money {
        val sum = value + newValue
        return Money(sum)
    }
}
```

那么现在，Money对象就拥有了和数字相加的能力：



## 11.高阶函数

### 1.定义高阶函数

>如果一个函数接收另一个函数作为参数，或者返回值的类型是另一个函数，那么该函数就称为高阶函数。

函数类型。我们知道，编程语言中有整型、布尔型等字段类型，而Kotlin又增加了一个函数类型的概念。

如果我们将这种函数类型添加到一个函数的参数声明或者返回值声明当中，那么这就是一个高阶函数了。

接下来我们就学习一下如何定义一个函数类型。不同于定义一个普通的字段类型，函数类型的语法规则是有点特殊的，基本规则如下：

```kotlin
(String, Int) -> Unit
```

既然是定义一个函数类型，那么最关键的就是要声明该函数接收什么参数，以及它的返回值是什么。

因此，->左边的部分就是用来声明该函数接收什么参数的，**多个参数之间使用逗号隔开，如果不接收任何参数，写一对空括号**就可以了。而->右边的部分用于声明该函数的返回值是什么类型，如果**没有返回值就使用Unit**，它大致相当于Java中的void。

将上述函数类型添加到某个函数的参数声明或者返回值声明上，那么这个函数就是一个高阶函数了，如下所示：

```kotlin
fun example(func: (String, Int) -> Unit) {
    func("hello", 123)
}
```

这段代码定义了一个名为example的函数，它的参数是一个类型为 `(String, Int) -> Unit` 的函数变量 `func`，这个函数类型表示接受两个参数 `String` 和 `Int`，没有返回值。

在函数体内，我们调用了 `func` 函数，并将参数设置为 `"hello"` 和 `123`，这样就可以将这两个参数传递给传递给 `func` 函数。

这个函数可以用来演示 Kotlin 中的高阶函数，也就是函数可以作为参数传递的特性。

高阶函数可以让我们更加灵活地处理函数，可以将函数作为参数传递给其他函数，也可以将函数作为返回值返回。这种方式可以帮助我们将代码模块化，使得代码更加易于维护和扩展。

在实际应用中，高阶函数可以用来实现各种设计模式，如策略模式、观察者模式等，也可以用来处理集合数据、进行异步操作等。

例如，在Android开发中，我们经常需要处理异步任务，可以通过高阶函数来将异步任务和UI线程分离开来，避免UI卡顿问题。另外，Android中的RecyclerView也使用了高阶函数来实现数据绑定和布局管理等功能。

>简单概括一下的话，那就是高阶函数允许让函数类型的参数来决定函数的执行逻辑。即使是同一个高阶函数，只要传入不同的函数类型参数，那么它的执行逻辑和最终的返回结果就可能是完全不同的。

#### 函数引用的写法

定义一个叫作num1AndNum2()的高阶函数，并让它接收两个整型和一个函数类型的参数。我们会在num1AndNum2()函数中对传入的两个整型参数进行某种运算，并返回最终的运算结果，但是具体进行什么运算是由传入的函数类型参数决定的。
新建一个HigherOrderFunction.kt文件，然后在这个文件中编写如下代码：

```kotlin
fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    val result = operation(num1, num2)
    return result
}
```

num1AndNum2()函数的前两个参数没有什么需要解释的，第三个参数是一个接收两个整型参数并且返回值也是整型的函数类型参数。在num1AndNum2()函数中，我们没有进行任何具体的运算操作，而是将num1和num2参数传给了第三个函数类型参数，并获取它的返回值，最终将得到的返回值返回。

现在高阶函数已经定义好了，那么我们该如何调用它呢？由于num1AndNum2()函数接收一个函数类型的参数，因此我们还得先定义与其函数类型相匹配的函数才行。在HigherOrderFunction.kt文件中添加如下代码：

```kotlin
fun plus(num1: Int, num2: Int): Int {
    return num1 + num2
}
fun minus(num1: Int, num2: Int): Int {
    return num1 - num2
}
```

这里定义了两个函数，并且这两个函数的参数声明和返回值声明都和num1AndNum2()函数中的函数类型参数是完全匹配的。其中，plus()函数将两个参数相加并返回，minus()函数将两个参数相减并返回，分别对应了两种不同的运算操作。

有了上述函数之后，我们就可以调用num1AndNum2()函数了，在main()函数中编写如下代码：

```kotlin
fun main() {
    val num1 = 100
    val num2 = 80
    val result1 = num1AndNum2(num1, num2, ::plus)
    val result2 = num1AndNum2(num1, num2, ::minus)
    println("result1 is $result1")
    println("result2 is $result2")
}
```

>注意这里调用num1AndNum2()函数的方式，第三个参数使用了::plus和::minus这种写法。
>
>这是一种函数引用方式的写法，表示将plus()和minus()函数作为参数传递给num1AndNum2()函数。
>
>而由于num1AndNum2()函数中使用了传入的函数类型参数来决定具体的运算逻辑，因此这里实际上就是分别使用了plus()和minus()函数来对两个数字进行运算。

#### Lambda表达式调用高阶函数

上述代码如果使用Lambda表达式的写法来实现的话，代码如下所示：

```kotlin
fun main() {
    val num1 = 100
    val num2 = 80
    val result1 = num1AndNum2(num1, num2) { n1, n2 ->
        n1 + n2
    }
    val result2 = num1AndNum2(num1, num2) { n1, n2 ->
        n1 - n2
    }
    println("result1 is $result1")
    println("result2 is $result2")
}
```

apply函数可以为Lambda表达式提供一个指定的上下文，使得代码更加精简，比如StringBuilder。

现在使用高阶函数来模仿实现类似的功能。

```kotlin
fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}
```

这是一个扩展函数，用于为StringBuilder类添加一个build方法，该方法接收一个Lambda表达式作为参数，Lambda表达式的类型为StringBuilder.() -> Unit。

在Lambda表达式中，可以直接调用StringBuilder对象的方法，因为Lambda表达式中的this指向的是调用build方法的StringBuilder对象本身。

在build方法中，首先调用Lambda表达式，即执行传入的代码块，然后返回this，也就是当前的StringBuilder对象。

这个高阶函数的作用与apply函数类似，都可以为Lambda表达式提供一个指定的上下文，并且使用Lambda表达式来连续调用同一个对象的多个方法。

现在就可以使用自己创建的build函数来简化StringBuilder构建字符串的方式了。这里仍然用吃水果这个功能来举例：

```kotlin
fun main() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val result = StringBuilder().build {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
    }
    println(result.toString())
}
```

### 2.内联函数的作用

举例num1AndNum2()函数:

```kotlin
fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    val result = operation(num1, num2)
    return result
}
fun main() {
    val num1 = 100
    val num2 = 80
    val result = num1AndNum2(num1, num2) { n1, n2 ->
        n1 + n2
    }
}
```

可以看到，上述代码中调用了`num1AndNum2()`函数，并通过Lambda表达式指定对传入的两个整型参数进行求和。

这段代码在Kotlin中非常好理解，因为这是高阶函数最基本的用法。可是Kotlin的代码最终还是要编译成Java字节码的，但Java中并没有高阶函数的概念。

Kotlin的编译器会将这些高阶函数的语法转换成Java支持的语法结构，上述的Kotlin代码大致会被转换成如下Java代码：

```java
public static int num1AndNum2(int num1, int num2, Function operation) {
    int result = (int) operation.invoke(num1, num2);
    return result;
}
public static void main() {
    int num1 = 100;
    int num2 = 80;
    int result = num1AndNum2(num1, num2, new Function() {
        @Override
        public Integer invoke(Integer n1, Integer n2) {
            return n1 + n2;
        }
    });
}
```

可以看到，在这里num1AndNum2()函数的第三个参数变成了一个Function接口，这是一种Kotlin内置的接口，里面有一个待实现的invoke()函数。而num1AndNum2()函数其实就是调用了Function接口的invoke()函数，并把num1和num2参数传了进去。

在调用num1AndNum2()函数的时候，之前的Lambda表达式在这里变成了Function接口的匿名类实现，然后在invoke()函数中实现了n1 + n2的逻辑，并将结果返回。

原来我们一直使用的Lambda表达式在底层被转换成了匿名类的实现方式。这就表明，我们每调用一次Lambda表达式，都会创建一个新的匿名类实例，当然也会造成额外的内存和性能开销。
为了解决这个问题，Kotlin提供了内联函数的功能，它可以将使用Lambda表达式带来的运行时开销完全消除。



内联函数的用法，只需要在定义高阶函数时加上inline关键字的声明即可:

```kotlin
inline fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    val result = operation(num1, num2)
    return result
}
```

Kotlin编译器会将内联函数中的代码在编译的时候自动替换到调用它的地方，这样也就不存在运行时的开销了。

内联函数的代码替换过程：

首先，Kotlin编译器会将Lambda表达式中的代码替换到函数类型参数调用的地方：

![image-20230408152100632](https://cdn.jsdelivr.net/gh/ChengYang1998/blogImage@main/PicGo/image-20230408152100632.png)

再将内联函数中的全部代码替换到函数调用的地方：

![image-20230408152153453](https://cdn.jsdelivr.net/gh/ChengYang1998/blogImage@main/PicGo/image-20230408152153453.png)

最终的代码就被替换成了：

![image-20230408152206640](https://cdn.jsdelivr.net/gh/ChengYang1998/blogImage@main/PicGo/image-20230408152206640.png)

正是如此，内联函数才能完全消除Lambda表达式所带来的运行时开销。

### 3.noinline与crossinline

> 一个高阶函数中如果接收了两个或者更多函数类型的参数，这时我们给函数加上了inline关键字，那么Kotlin编译器会自动将所有引用的Lambda表达式全部进行内联。
> 但是，如果只想内联其中的一个Lambda表达式该怎么办呢？

使用noinline关键字了，如下所示：

```kotlin
inline fun inlineTest(block1: () -> Unit, noinline block2: () -> Unit) {
}
```

可以看到，这里使用inline关键字声明了inlineTest()函数，原本block1和block2这两个函数类型参数所引用的Lambda表达式都会被内联。但是我们在block2参数的前面又加上了一个noinline关键字，那么现在就只会对block1参数所引用的Lambda表达式进行内联了。这就是noinline关键字的作用。

> 为什么Kotlin还要提供一个noinline关键字来排除内联功能呢？

因为内联的函数类型参数在编译的时候会被进行代码替换，因此它没有真正的参数属性。非内联的函数类型参数可以自由地传递给其他任何函数，因为它就是一个真实的参数，而内联的函数类型参数只允许传递给另外一个内联函数，这也是它最大的局限性。

另外，内联函数和非内联函数还有一个重要的区别，那就是**内联函数所引用的Lambda表达式中是可以使用return关键字来进行函数返回的**，而非内联函数只能进行局部返回。

例子：

```kotlin
fun printString(str: String, block: (String) -> Unit) {
    println("printString begin")
    block(str)
    println("printString end")
}
fun main() {
    println("main start")
    val str = ""
    printString(str) { s ->
        println("lambda start")
        if (s.isEmpty()) return@printString
        println(s)
        println("lambda end")
    }
    println("main end")
}
```

这里定义了一个叫作`printString()`的高阶函数,用于在Lambda表达式中打印传入的字符串参数。但是如果字符串参数为空，那么就不进行打印。

> 注意，Lambda表达式中是不允许直接使用return关键字的，这里使用了return@printString的写法，表示进行局部返回退出当前printString()函数，并且不再执行Lambda表达式的剩余部分代码。

![image-20230408153136355](https://cdn.jsdelivr.net/gh/ChengYang1998/blogImage@main/PicGo/image-20230408153136355.png)

可以看到，除了Lambda表达式中return@printString语句之后的代码没有打印，其他的日志是正常打印的，说明return@printString确实只能进行局部返回。

但是如果将`printString()`函数声明成一个内联函数，那么情况就不一样了，如下所示：

```kotlin
inline fun printString(str: String, block: (String) -> Unit) {
    println("printString begin")
    block(str)
    println("printString end")
}
fun main() {
    println("main start")
    val str = ""
    printString(str) { s ->
        println("lambda start")
        if (s.isEmpty()) return
        println(s)
        println("lambda end")
    }
    println("main end")
}
```

现在printString()函数变成了内联函数，我们就可以在Lambda表达式中使用return关键字了。此时的return代表的是返回外层的调用函数，也就是main()函数。

打印结果如图所示：

![image-20230408153459843](https://cdn.jsdelivr.net/gh/ChengYang1998/blogImage@main/PicGo/image-20230408153459843.png)

可以看到，不管是main()函数还是printString()函数，确实都在return关键字之后停止执行了，和我们所预期的结果一致。



#### 使用内联函数可能出现的错误

将高阶函数声明成内联函数是一种良好的编程习惯，事实上，绝大多数高阶函数是可以直接声明成内联函数的，但是也有少部分例外的情况。观察下面的代码示例：

```kotlin
inline fun runRunnable(block: () -> Unit) {
    val runnable = Runnable {
        block()
    }
    runnable.run()
}
```

这段代码在没有加上inline关键字声明的时候绝对是可以正常工作的，但是在加上inline关键字之后就会提示如图错误：

![image-20230408153649145](https://cdn.jsdelivr.net/gh/ChengYang1998/blogImage@main/PicGo/image-20230408153649145.png)

这个错误出现的原因解释起来可能会稍微有点复杂。首先，在runRunnable()函数中，我们创建了一个Runnable对象，并在Runnable的Lambda表达式中调用了传入的函数类型参数。而Lambda表达式在编译的时候会被转换成匿名类的实现方式，也就是说，上述代码实际上是在匿名类中调用了传入的函数类型参数。

而内联函数所引用的Lambda表达式允许使用return关键字进行函数返回，但是由于我们是在匿名类中调用的函数类型参数，此时是不可能进行外层调用函数返回的，最多只能对匿名类中的函数调用进行返回，因此这里就提示了上述错误。

也就是说，如果我们在高阶函数中创建了另外的Lambda或者匿名类的实现，并且在这些实现中调用函数类型参数，此时再将高阶函数声明成内联函数，就一定会提示错误。
那么是不是在这种情况下就真的无法使用内联函数了呢？也不是，比如借助crossinline关键字就可以很好地解决这个问题：

```kotlin
inline fun runRunnable(crossinline block: () -> Unit) {
    val runnable = Runnable {
        block()
    }
    runnable.run()
}
```

可以看到，这里在函数类型参数的前面加上了crossinline的声明，代码就可以正常编译通过了。

之所以会提示图所示的错误，就是因为内联函数的Lambda表达式中允许使用return关键字，和高阶函数的匿名类实现中不允许使用return关键字之间造成了冲突。

而crossinline关键字就像一个契约，它用于保证在内联函数的Lambda表达式中一定不会使用return关键字，这样冲突就不存在了，问题也就巧妙地解决了。

声明了crossinline之后，我们就无法在调用runRunnable函数时的Lambda表达式中使用return关键字进行函数返回了，但是仍然可以使用return@runRunnable的写法进行局部返回。

总体来说，除了在return关键字的使用上有所区别之外，crossinline保留了内联函数的其他所有特性。

## 12.高阶函数的应用

### 1.简化SharedPreferences的用法

写法：

```kotlin
getSharedPreferences("data", Context.MODE_PRIVATE).edit {
    putString("name", "Tom")
    putInt("age", 28)
    putBoolean("married", false)
}
```



原理：

回顾一下SharedPreferences原来的用法。向SharedPreferences中存储数据的过程大致可以分为以下3步：

1. 调用SharedPreferences的edit()方法获取SharedPreferences.Editor对象；
2. 向SharedPreferences.Editor对象中添加数据；
3. 调用apply()方法将添加的数据提交，完成数据存储操作。

对应的代码示例如下：

```kotlin
val editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()
editor.putString("name", "Tom")
editor.putInt("age", 28)
editor.putBoolean("married", false)
editor.apply()
```

尝试使用高阶函数简化SharedPreferences的用法：

新建一个SharedPreferences.kt文件，然后在里面加入如下代码：

```kotlin
fun SharedPreferences.open(block: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.block()
    editor.apply()
}
```

首先，我们通过扩展函数的方式向SharedPreferences类中添加了一个open函数，并且它还接收一个函数类型的参数，因此open函数自然就是一个高阶函数了。

由于open函数内拥有SharedPreferences的上下文，因此这里可以直接调用edit()方法来获取SharedPreferences.Editor对象。

另外open函数接收的是一个`SharedPreferences.Editor`的函数类型参数，因此这里需要调用`editor.block()`对函数类型参数进行调用，我们就可以在函数类型参数的具体实现中添加数据了。最后还要调用`editor.apply()`方法来提交数据，从而完成数据存储操作。

定义好了open函数之后，以后在项目中使用SharedPreferences存储数据就会更加方便了，写法如下所示：

```kotlin
getSharedPreferences("data", Context.MODE_PRIVATE).open {
    putString("name", "Tom")
    putInt("age", 28)
    putBoolean("married", false)
}
```

可以看到，我们可以直接在SharedPreferences对象上调用open函数，然后在Lambda表达式中完成数据的添加操作。注意，现在Lambda表达式拥有的是
SharedPreferences.Editor的上下文环境，因此这里可以直接调用相应的put方法来添加数据。最后我们也不再需要调用apply()方法来提交数据了，因为open函数会自动完成提交操作。

其实Google提供的KTX扩展库中已经包含了上述SharedPreferences的简化用法，这个扩展库会在Android Studio创建项目的时候自动引入build.gradle的dependencies中。

![image-20230408155414040](https://cdn.jsdelivr.net/gh/ChengYang1998/blogImage@main/PicGo/image-20230408155414040.png)



### 2.简化ContentValues的用法

ContentValues主要用于结合SQLiteDatabase的API存储和修改数据库中的数据

KTX库中提供了contentValuesOf()方法，用法如下所示：

```kotlin
val values = contentValuesOf("name" to "Game of Thrones", "author" to "George Martin","pages" to 720, "price" to 20.85)
db.insert("Book", null, values)
```



原理：

示例如下：

```kotlin
val values = ContentValues()
values.put("name", "Game of Thrones")
values.put("author", "George Martin")
values.put("pages", 720)
values.put("price", 20.85)
db.insert("Book", null, values)
```

简化：

新建一个ContentValues.kt文件，然后在里面定义一个cvOf()方法，如下所示：

```kotlin
fun cvOf(vararg pairs: Pair<String, Any?>): ContentValues {
}
```

这个方法的作用是构建一个`ContentValues`对象，有几点我需要解释一下。首先，`cvOf()`方法接收了一个Pair参数，也就是使用A to B语法结构创建出来的参数类型，但是我们在参数前面加上了一个`vararg`关键字。

其实**vararg对应的就是Java中的可变参数列表**，我们允许向这个方法传入0个、1个、2个甚至任意多个Pair类型的参数，这些参数都会被赋值到使用vararg声明的这一个变量上面，然后使用for-in循环可以将传入的所有参数遍历出来。

再来看声明的Pair类型。由于Pair是一种键值对的数据结构，因此需要通过泛型来指定它的键和值分别对应什么类型的数据。ContentValues的所有键都是字符串类型的，这里可以直接将Pair键的泛型指定成String。但ContentValues的值却可以有多种类型（字符串型、整型、浮点型，甚至是null），所以我们需要将Pair值的泛型指定成Any?。这是因为Any是Kotlin中所有类的共同基类，相当于Java中的Object，而Any?则表示允许传入空值。

为cvOf()方法实现功能逻辑，核心思路就是先创建一个ContentValues对
象，然后遍历pairs参数列表，取出其中的数据并填入ContentValues中，最终将
ContentValues对象返回即可。

Pair参数的值是Any?类型的，使用when语句一一进行条件判断，并覆盖ContentValues所支持的所有数据类型。代码：

```kotlin
fun cvOf(vararg pairs: Pair<String, Any?>): ContentValues {
    val cv = ContentValues()
    for (pair in pairs) {
        val key = pair.first
        val value = pair.second
        when (value) {
            is Int -> cv.put(key, value)
            is Long -> cv.put(key, value)
            is Short -> cv.put(key, value)
            is Float -> cv.put(key, value)
            is Double -> cv.put(key, value)
            is Boolean -> cv.put(key, value)
            is String -> cv.put(key, value)
            is Byte -> cv.put(key, value)
            is ByteArray -> cv.put(key, value)
            null -> cv.putNull(key)
        }
    }
    return cv
}
```

我们使用for-in循环遍历了pairs参数列表，在循环中取出了key和value，并使用when语句来判断value的类型。注意，这里将ContentValues所支持的所有数据类型全部覆盖了进去，然后将参数中传入的键值对逐个添加到ContentValues中，最终将ContentValues返回。

> 这里还使用了Kotlin中的Smart Cast功能。比如when语句进入Int条件分支后，这个条件下面的value会被自动转换成Int类型，而不再是Any?类型。

有了这个cvOf()方法之后，我们使用ContentValues时就会变得更加简单了，比如向数据库中插入一条数据就可以这样写：

```kotlin
val values = cvOf("name" to "Game of Thrones", "author" to "George Martin",
    "pages" to 720, "price" to 20.85)
db.insert("Book", null, values)
```

借助apply函数，cvOf()方法的实现将会变得更加优雅：

```kotlin
fun cvOf(vararg pairs: Pair<String, Any?>) = ContentValues().apply {
    for (pair in pairs) {
        val key = pair.first
        val value = pair.second
        when (value) {
            is Int -> put(key, value)
            is Long -> put(key, value)
            is Short -> put(key, value)
            is Float -> put(key, value)
            is Double -> put(key, value)
            is Boolean -> put(key, value)
            is String -> put(key, value)
            is Byte -> put(key, value)
            is ByteArray -> put(key, value)
            null -> putNull(key)
        }
    }
}
```

由于apply函数的返回值就是它的调用对象本身，因此这里我们可以使用单行代码函数的语法糖，用等号替代返回值的声明。另外，apply函数的Lambda表达式中会自动拥有ContentValues的上下文，所以这里可以直接调用ContentValues的各种put方法。

## 13.泛型

### 泛型定义

- 定义一个泛型类：

    ```kotlin
    class MyClass<T> {
        fun method(param: T): T {
            return param
        }
    }
    ```

    在调用MyClass类和method()方法的时候，就可以将泛型指定成具体的类型，如下所示：

    ```kotlin
    val myClass = MyClass<Int>()
    val result = myClass.method(123)
    ```

- 定义一个泛型方法

    只需要将定义泛型的语法结构写在方法名前面：

    ```kotlin
    class MyClass {
        fun <T> method(param: T): T {
            return param
        }
    }
    ```

    此时的调用方式：

    ```kotlin
    val myClass = MyClass()
    val result = myClass.method<Int>(123)
    ```

    或者：

    ```kotlin
    val myClass = MyClass()
    val result = myClass.method(123)	//类型推导
    ```

    

    Kotlin中可以对泛型的类型进行限制，这个限制也被称为泛型约束。在定义泛型时，可以通过`where`关键字指定泛型的类型必须满足的约束条件。

    常见的泛型约束条件有以下几种：

    - 继承某个类或接口，使用`:`符号来指定，例如`<T : List<String>>`表示T必须是`List<String>`的子类或实现类。

        ```kotlin
        class MyClass {
        	fun <T : Number> method(param: T): T {
        		return param
        	}
        }
        ```

        这种写法就表明，我们只能将method()方法的泛型指定成数字类型，比如Int、Float、Double等。但是如果你指定成字符串类型，就肯定会报错，因为它不是一个数字。

        另外，在默认情况下，所有的泛型都是可以指定成可空类型的，这是因为在不手动指定上界的时候，泛型的上界默认是`Any?`。而如果想要让泛型的类型不可为空，只需要将泛型的上界手动指定成`Any`就可以了。

    - 多个约束条件，使用逗号`,`分隔开，例如`<T : List<String>, U : CharSequence>`表示T必须是`List<String>`的子类或实现类，U必须是`CharSequence`的子类或实现类。

    - 使用`where`关键字指定，例如`<T> where T : List<String>, T : Comparable<T>>`表示T必须同时满足`List<String>`和`Comparable<T>`两个约束条件。

    泛型约束可以帮助我们在编写代码时更好地控制泛型的类型，避免出现不合法的使用。同时，也可以在一定程度上提高代码的复用性和可读性。

### 泛型应用

build函数：

```kotlin
fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}
```

通过本小节所学的泛型知识对build函数进行扩展，让它实现和apply函数完全一样的功能。

使用`<T>`将build函数定义成泛型函数，再将原来所有强制指定StringBuilder的地方都替换成T就可以了。

新建一个build.kt文件，并编写如下代码：

```kotlin
fun <T> T.build(block: T.() -> Unit): T {
    block()
    return this
}
```

现在完全可以像使用apply函数一样去使用build函数了，比如说这里我们使用
build函数简化Cursor的遍历：

```kotlin
contentResolver.query(uri, null, null, null, null)?.build {
    while (moveToNext()) {
        ...
    }
    close()
}
```



## 14.Kotlin委托

委托是一种设计模式，它的基本理念是：**操作对象自己不会去处理某段逻辑，而是会把工作委托给另外一个辅助对象去处理。**

这个概念对于Java程序员来讲可能相对比较陌生，因为Java对于委托并没有语言层级的实现，而像C#等语言就对委托进行了原生的支持。



### 类委托

核心思想：**将一个类的具体实现委托给另一个类去完成**。



一个类可以有父类同时委托方法给其他类。当一个类同时继承自父类并委托给其他类时，该类会先调用自身的方法，如果自身没有实现，再去调用委托对象的方法，最后再去调用父类的方法。这个调用顺序被称为“覆盖顺序”。



例如，假设我们有一个名为RealPrinter的类，它实现了Printer接口，我们可以将其定义为：

```kotlin
class RealPrinter(val message: String) : Printer {
    override fun print() {
        println(message)
    }
}
```

现在我们有一个需要打印消息的类，我们可以通过类委托的方式将打印操作委托给RealPrinter：

```kotlin
class MessagePrinter(val message: String) : Printer by RealPrinter(message)
```

在这个例子中，MessagePrinter将自己的打印职责委托给了RealPrinter，这样在调用MessagePrinter实例的print()方法时，实际上是委托给了RealPrinter来完成打印操作。

需要注意的是，委托对象必须实现委托接口，并且委托对象中实现的方法会覆盖委托类中相同的方法。同时，委托对象中未实现的方法仍然会被委托类中的实现所覆盖。

例如，Set这种数据结构，它和List有点类似，只是它所存储的数据是无序
的，并且不能存储重复的数据。Set是一个接口，如果要使用它的话，需要使用它具体的实现类，比如HashSet。

而借助于委托模式，我们可以轻松实现一个自己的实现类。比如这里定义一个MySet，并让它实现Set接口，代码如下所示：

```kotlin
class MySet<T>(val helperSet: HashSet<T>) : Set<T> {
    override val size: Int
        get() = helperSet.size
    override fun contains(element: T) = helperSet.contains(element)
    override fun containsAll(elements: Collection<T>) = helperSet.containsAll(elements)
    override fun isEmpty() = helperSet.isEmpty()
    override fun iterator() = helperSet.iterator()
}
```

可以看到，MySet的构造函数中接收了一个HashSet参数，这就相当于一个辅助对象。然后在Set接口所有的方法实现中，我们都没有进行自己的实现，而是调用了辅助对象中相应的方法实现，这其实就是一种委托模式。

那么，这种写法的好处是什么呢？既然都是调用辅助对象的方法实现，那还不如直接使用辅助对象得了。

这么说确实没错，但如果我们只是让大部分的方法实现调用辅助对象中的方法，少部分的方法实现由自己来重写，甚至加入一些自己独有的方法，那么MySet就会成为一个全新的数据结构类，这就是委托模式的意义所在。

**弊端**：

如果接口中的待实现方法比较少还好，要是有几十甚至上百个方法的话，每个都去这样调用辅助对象中的相应方法实现，那要写哭了。

那么这个问题有没有什么解决方案呢？在Java中确实没有，但是在Kotlin中可以通过类委托的功能来解决。

Kotlin中委托使用的关键字是by，我们只需要在接口声明的后面使用by关键字，再接上受委托的辅助对象，就可以免去之前所写的一大堆模板式的代码了，如下所示：

```kotlin
class MySet<T>(val helperSet: HashSet<T>) : Set<T> by helperSet {
}
```

这两段代码实现的效果是一模一样的，但是借助了类委托的功能之后，代码明显简化了太多。

另外，如果我们要对某个方法进行重新实现，只需要单独重写那一个方法就可以了，其他的方法仍然可以享受类委托所带来的便利，如下所示：

```kotlin
class MySet<T>(val helperSet: HashSet<T>) : Set<T> by helperSet {
    fun helloWorld() = println("Hello World")
    override fun isEmpty() = false
}
```

这里我们新增了一个helloWorld()方法，并且重写了isEmpty()方法，让它永远返回false。

### 委托属性

在 Kotlin 中，委托属性是一种将属性的 getter/setter 方法委托给另一个对象实现的机制。通过委托属性，我们可以让一个类中的属性的 get/set 方法调用另一个类的 get/set 方法，从而实现属性的重用和简化。

委托属性的基本语法是：`val/var <property-name>: <Type> by <expression>`。其中，`<expression>` 是一个对象表达式或对象引用，这个对象实现了 `ReadOnlyProperty` 或 `ReadWriteProperty` 接口。

举个例子，如果我们有一个 `User` 类，其中有一个 `name` 属性，我们可以使用委托属性的方式将其委托给另一个对象实现。代码如下：

```kotlin
class User {
    var name: String by NameDelegate()
}

class NameDelegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "John Doe"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been set to ${property.name}")
    }
}
```

在上面的代码中，`User` 类中的 `name` 属性被委托给了 `NameDelegate` 类来实现。`NameDelegate` 实现了 `ReadWriteProperty<Any?, String>` 接口，它包含了 `getValue()` 和 `setValue()` 方法。`getValue()` 方法返回一个字符串 "John Doe"，`setValue()` 方法打印出设置的值和属性名。

当我们使用委托属性时，Kotlin 会自动调用委托对象的 `getValue()` 和 `setValue()` 方法。例如，下面的代码展示了如何使用 `User` 类中的 `name` 属性：

```kotlin
val user = User()
println(user.name) // 输出：John Doe
user.name = "Tom" // 输出：Tom has been set to name
```

通过委托属性，我们可以将属性的实现从类中抽离出来，使得代码更加简洁和可读。



## 15.使用infix函数

to并不是Kotlin语言中的一个关键字，之所以我们能够使用A to B这样的语法结构，是因为Kotlin提供了一种高级语法糖特性：infix函数。

String类中有一个startsWith()函数，你一定使用过，它可以用于判断一个字符串是否是以某个指定参数开头的。比如说下面这段代码的判断结果一定会是true：

```kotlin
if ("Hello Kotlin".startsWith("Hello")) {
	// 处理具体的逻辑
}
```

startsWith()函数的用法虽然非常简单，但是借助infix函数，我们可以使用一种更具可读性的语法来表达这段代码。新建一个infix.kt文件，然后编写如下代码：

```kotlin
infix fun String.beginsWith(prefix: String) = startsWith(prefix)
```

首先，除去最前面的infix关键字不谈，这是一个String类的扩展函数。我们给String类添加了一个beginsWith()函数，它也是用于判断一个字符串是否是以某个指定参数开头的，并且它的内部实现就是调用的String类的startsWith()函数。

但是加上了infix关键字之后，beginsWith()函数就变成了一个infix函数，这样除了传统的函数调用方式之外，我们还可以用一种特殊的语法糖格式调用beginsWith()函数，如下所示：

```kotlin
if ("Hello Kotlin" beginsWith "Hello") {
	// 处理具体的逻辑
}
```

从这个例子就能看出，infix函数的语法规则并不复杂，上述代码其实就是调用的" Hello Kotlin "这个字符串的beginsWith()函数，并传入了一个"Hello"字符串作为参数。但是infix函数允许我们将函数调用时的小数点、括号等计算机相关的语法去掉，从而使用一种更接近英语的语法来编写程序，让代码看起来更加具有可读性。



infix函数由于其语法糖格式的特殊性，有两个比较严格的限制：

1. infix函数是不能定义成顶层函数的，它必须是某个类的成员函数，可以使用扩展函数的方式将它定义到某个类当中。
2. infix函数必须接收且只能接收一个参数，至于参数类型是没有限制的。

接下来一个复杂一些的例子。

比如这里有一个集合，如果想要判断集合中是否包括某个指定元素，一般可以这样写：

```kotlin
val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
if (list.contains("Banana")) {
	// 处理具体的逻辑
}
```

借助infix函数让这段代码变得更加具有可读性。在infix.kt文件中添加如下代码：

```kotlin
infix fun <T> Collection<T>.has(element: T) = contains(element)
```

可以看到，我们给Collection接口添加了一个扩展函数，这是因为Collection是Java以及Kotlin所有集合的总接口，因此给Collection添加一个has()函数，那么所有集合的子类就都可以使用这个函数了。

另外，这里还使用了泛型函数的定义方法，从而使得has()函数可以接收任意具体类型的参数。

而这个函数内部的实现逻辑就相当简单了，只是调用了Collection接口中
的contains()函数而已。也就是说，has()函数和contains()函数的功能实际上是一模一样的，只是它多了一个infix关键字，从而拥有了infix函数的语法糖功能。
现在我们就可以使用如下的语法来判断集合中是否包括某个指定的元素：

```kotlin
val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
if (list has "Banana") {
	// 处理具体的逻辑
}
```



mapOf()函数中to的具体实现：

```kotlin
public infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)
```

to()函数的具体实现，非常简单，就是创建并返回了一个Pair对象。也就是说，A toB这样的语法结构实际上得到的是一个包含A、B数据的Pair对象，而mapOf()函数实际上接收的正是一个Pair类型的可变参数列表。

## 16.泛型的高级特性

Kotlin在泛型方面还提供了不少特有的功能。

### 1.对泛型进行实化

> 实际上，Java的泛型功能是通过类型擦除机制来实现的。什么意思呢？就是说泛型对于类型的约束只在编译时期存在，运行的时候仍然会按照JDK 1.5之前的机制来运行，JVM是识别不出来我们在代码中指定的泛型类型的。例如，假设我们创建了一个`List<String>`集合，虽然在编译时期只能向集合中添加字符串类型的元素，但是在运行时期JVM并不能知道它本来只打算包含哪种类型的元素，只能识别出来它是个List。

Kotlin中是可以将内联函数中的泛型进行实化的。

具体该怎么写才能将泛型实化呢？

首先，该函数必须是内联函数才行，也就是要用inline关键字来修饰该函数。

其次，在声明泛型的地方必须加上reified关键字来表示该泛型要进行实化。

示例代码如下：

```kotlin
inline fun <reified T> getGenericType() {
}
```

上述函数中的泛型T就是一个被实化的泛型，因为它满足了内联函数和reified关键字这两个前提条件。

可实现什么样的效果：

这里准备实现一个获取泛型实际类型的功能，代码如下所示：

```kotlin
inline fun <reified T> getGenericType() = T::class.java
```

getGenericType()函数直接返回了当前指定泛型的实际类型。T.class这样的语法在Java中是不合法的，而在Kotlin中，借助泛型实化功能就可以使用T::class.java这样的语法了。

现在我们可以使用如下代码对getGenericType()函数进行测试：

```kotlin
fun main() {
    val result1 = getGenericType<String>()
    val result2 = getGenericType<Int>()
    println("result1 is $result1")
    println("result2 is $result2")
}
```

这里给getGenericType()函数指定了两种不同的泛型，由于getGenericType()函数会将指定泛型的具体类型返回，因此这里我们将返回的结果进行打印。

![image-20230408182223007](https://cdn.jsdelivr.net/gh/ChengYang1998/blogImage@main/PicGo/image-20230408182223007.png)



### 2.泛型实化的应用

泛型实化在Android项目当中具体应用。

```kotlin
val intent = Intent(context, TestActivity::class.java)
context.startActivity(intent)
```

Kotlin的泛型实化功能使得我们拥有了更好的选择。

新建一个reified.kt文件，然后在里面编写如下代码：

```kotlin
inline fun <reified T> startActivity(context: Context) {
	val intent = Intent(context, T::class.java)
	context.startActivity(intent)
}
```

现在，如果我们想要启动TestActivity，只需要这样写就可以了：

```kotlin
startActivity<TestActivity>(context)
```

Kotlin将能够识别出指定泛型的实际类型，并启动相应的Activity。

> 怎么样，是不是觉得代码瞬间精简了好多？这就是泛型实化所带来的神奇功能。

不过，现在的startActivity()函数其实还是有问题的，因为通常在启用Activity的时候还可能会使用Intent附带一些参数，比如下面的写法：

```kotlin
val intent = Intent(context, TestActivity::class.java)
intent.putExtra("param1", "data")
intent.putExtra("param2", 123)
context.startActivity(intent)
```

借助高阶函数就可以轻松搞定。

回到reified.kt文件当中，这里添加一个新的startActivity()函数重载，如下所示：

```kotlin
inline fun <reified T> startActivity(context: Context, block: Intent.() -> Unit) {
	val intent = Intent(context, T::class.java)
	intent.block()
	context.startActivity(intent)
}
```

这次的startActivity()函数中增加了一个函数类型参数，并且它的函数类型是定义在Intent类当中的。在创建完Intent的实例之后，随即调用该函数类型参数，并把Intent的实例传入，这样调用startActivity()函数的时候就可以在Lambda表达式中为Intent传递参数了，如下所示：

```kotlin
startActivity<TestActivity>(context) {
	putExtra("param1", "data")
	putExtra("param2", 123)
}
```

> 这种启动Activity的代码写起来实在是太舒服了，泛型实化和高阶函数使这种语法结构成为了可能，感谢Kotlin提供了如此多优秀的语言特性。



### 3.泛型的协变

如果某个方法接收一个`List<Person>`类型的参数，而我们传入一个`List<Student>`的实例，这样合不合法呢？

看上去好像也挺正确的，但是Java中是不允许这么做的，因为`List<Student>`不能成为`List<Person>`的子类，否则将可能存在类型转换的安全隐患。

为什么会存在类型转换的安全隐患呢？

下面通过一个具体的例子进行说明。这里自定义一个SimpleData类，代码如下所示：

```kotlin
class SimpleData<T> {
    private var data: T? = null
    fun set(t: T?) {
        data = t
    }
    fun get(): T? {
        return data
    }
}
```

SimpleData是一个泛型类，它的内部封装了一个泛型data字段，调用set()方法可以给data字段赋值，调用get()方法可以获取data字段的值。

接着我们假设，如果编程语言允许向某个接收`SimpleData<Person>`参数的方法传入`SimpleData<Student>`的实例，那么如下代码就会是合法的：

```kotlin
fun main() {
    val student = Student("Tom", 19)
    val data = SimpleData<Student>()
    data.set(student)
    handleSimpleData(data) // 实际上这行代码会报错，这里假设它能编译通过
    val studentData = data.get()
}
fun handleSimpleData(data: SimpleData<Person>) {
    val teacher = Teacher("Jack", 35)
    data.set(teacher)
}
```

如何才能让`MyClass<A>`成为`MyClass<B>`的子类型呢？

T只能出现在out位置上，而不能出现在in位置上：

```kotlin
class SimpleData<out T>(val data: T?) {
    fun get(): T? {
        return data
    }
}
```

这里我们对SimpleData类进行了改造，在泛型T的声明前面加上了一个out关键字。这就意味着现在T只能出现在out位置上，而不能出现在in位置上，同时也意味着SimpleData在泛型T上是协变的。

由于泛型T不能出现在in位置上，因此我们也就不能使用set()方法为data参数赋值了，所以这里改成了使用构造函数的方式来赋值。你可能会说，构造函数中的泛型T不也是在in位置上的吗？没错，但是由于这里我们使用了val关键字，所以构造函数中的泛型T仍然是只读的，因此这样写是合法且安全的。另外，即使我们使用了var关键字，但只要给它加上private修饰符，保证这个泛型T对于外部而言是不可修改的，那么就都是合法的写法。

经过了这样的修改之后，下面的代码就可以完美编译通过且没有任何安全隐患了：

```kotlin
fun main() {
    val student = Student("Tom", 19)
    val data = SimpleData<Student>(student)
    handleMyData(data)
    val studentData = data.get()
}
fun handleMyData(data: SimpleData<Person>) {
    val personData = data.get()
}
```

由于SimpleData类已经进行了协变声明，那么`SimpleData<Student>`自然就是`SimpleData<Person>`的子类了，所以这里可以安全地向`handleMyData()`方法中传递参数。

然后在handleMyData()方法中去获取SimpleData封装的数据，虽然这里泛型声明的是Person类型，实际获得的会是一个Student的实例，但由于Person是Student的父类，向上转型是完全安全的，所以这段代码没有任何问题。

学到这里，关于协变的内容你就掌握得差不多了，不过最后还有个例子需要回顾一下。

前面提到，如果某个方法接收一个`List<Person>`类型的参数，而传入的却是一个`List<Student>`的实例，在Java中是不允许这么做的。

在Kotlin中这么做是合法的，因为Kotlin已经默认给许多内置的API加上了协变声明，其中就包括了各种集合的类与接口。

### 4.泛型的逆变

逆变可以在泛型类型的声明中使用in关键字来指定，例如：

```kotlin
interface Comparator<in T> {
    fun compare(a: T, b: T): Int
}
```

逆变功能在Kotlin内置API中的应用，比较典型的例子就是Comparable的使用。Comparable是一个用于比较两个对象大小的接口，其源码定义如下：

```kotlin
interface Comparable<in T> {
	operator fun compareTo(other: T): Int
}
```

如果我们使用`Comparable<Person>`实现了让两个Person对象比较大小的逻辑，那么用这段逻辑去比较两个Student对象的大小也一定是成立的，因此让`Comparable<Person>`成为`Comparable<Student>`的子类合情合理，这也是逆变非常典型的应用。

## 17.协程

> 协程属于Kotlin中非常有特色的一项技术，因为大部分编程语言中是没有协程这个概念的。

协程允许我们在单线程模式下模拟多线程编程的效果，代码执行时的挂起与恢复完全是由编程语言来控制的，和操作系统无关。

### 1.协程的基本用法

#### 基本用法

Kotlin并没有将协程纳入标准库的API当中，而是以依赖库的形式提供的。所以如果我们想要使用协程功能，需要先在app/build.gradle文件当中添加如下依赖库：

```groovy
dependencies {
    ...
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.1.1"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.1.1"
}
```

接下来创建一个CoroutinesTest.kt文件，并定义一个main()函数。

首先我们要面临的第一个问题就是，如何开启一个协程？

最简单的方式就是使用Global.launch函数，如下所示：

```kotlin
fun main() {
    GlobalScope.launch {
        println("codes run in coroutine scope")
    }
}
```

GlobalScope.launch函数可以创建一个协程的作用域，这样传递给launch函数的代码块（Lambda表达式）就是在协程中运行的了，这里我们只是在代码块中打印了一行日志。

**那么现在运行main()函数，日志能成功打印出来吗？如果你尝试一下，会发现没有任何日志输出。**

这是因为，Global.launch函数每次创建的都是一个顶层协程，这种协程当应用程序运行结束时也会跟着一起结束。刚才的日志之所以无法打印出来，就是因为代码块中的代码还没来得及运行，应用程序就结束了。

观察如下代码：

```kotlin
fun main() {
    GlobalScope.launch {
        println("codes run in coroutine scope")
        delay(1500)
        println("codes run in coroutine scope finished")
    }
    Thread.sleep(1000)
}
```

我们在代码块中加入了一个delay()函数，并在之后又打印了一行日志。

delay()函数可以让当前协程延迟指定时间后再运行，但它和Thread.sleep()方法不同。

delay()函数是一个非阻塞式的挂起函数，它只会挂起当前协程，并不会影响其他协程的运行。

而Thread.sleep()方法会阻塞当前的线程，这样运行在该线程下的所有协程都会被阻塞。

注意，delay()函数只能在协程的作用域或其他挂起函数中调用。

这里我们让协程挂起1.5秒，但是主线程却只阻塞了1秒，最终会是什么结果呢？重新运行程序，你会发现代码块中**新增的一条日志并没有打印出来**，因为它还没能来得及运行，应用程序就已经结束了。

借助runBlocking函数：

```kotlin
fun main() {
    runBlocking {
        println("codes run in coroutine scope")
        delay(1500)
        println("codes run in coroutine scope finished")
    }
}
```

![image-20230408195748599](https://cdn.jsdelivr.net/gh/ChengYang1998/blogImage@main/PicGo/image-20230408195748599.png)

runBlocking函数同样会创建一个协程的作用域，但是它可以保证在协程作用域内的所有代码和子协程没有全部执行完之前一直阻塞当前线程。

使用方法：

```kotlin
fun main() {
    val job = GlobalScope.launch {
        println("codes run in coroutine scope")
    }
    runBlocking {
        job.join() // 等待协程执行结束
    }
}
```

> 需要注意的是，runBlocking函数通常只应该在测试环境下使用，在正式环境中使用容易产生一些性能上的问题。

#### 创建多个协程

```kotlin
fun main() {
    runBlocking {
        launch {
            println("launch1")
            delay(1000)
            println("launch1 finished")
        }
        launch {
            println("launch2")
            delay(1000)
            println("launch2 finished")
        }
    }
}
```

![image-20230408212257430](https://cdn.jsdelivr.net/gh/ChengYang1998/blogImage@main/PicGo/image-20230408212257430.png)

注意这里的launch函数和我们刚才所使用的GlobalScope.launch函数不同。

首先它必须在协程的作用域中才能调用，其次它会在当前协程的作用域下创建子协程。

子协程的特点是如果外层作用域的协程结束了，该作用域下的所有子协程也会一同结束。

相比而言，GlobalScope.launch函数创建的永远是顶层协程，这一点和线程比较像，因为线程也没有层级这一说，永远都是顶层的。

两个子协程中的日志是交替打印的，说明它们确实是像多线程那样并发运行的。然而这两个子协程实际却运行在同一个线程当中，只是由编程语言来决定如何在多个协程之间进行调度，让谁运行，让谁挂起。调度的过程完全不需要操作系统参与，这也就使得协程的并发效率会出奇得高。

那么具体会有多高呢？来做下实验，代码如下所示：

```kotlin
fun main() {
    val start = System.currentTimeMillis()
    runBlocking {
        repeat(100000) {
            launch {
                println(".")
            }
        }
    }
    val end = System.currentTimeMillis()
    println(end - start)
}
```

使用repeat函数循环创建了10万个协程，不过在协程当中并没有进行什么有意义的操作，只是象征性地打印了一个点，然后记录一下整个操作的运行耗时。现在重新运行一下程序：

![image-20230408213716093](https://cdn.jsdelivr.net/gh/ChengYang1998/blogImage@main/PicGo/image-20230408213716093.png)

可以看到，这里仅仅耗时了961毫秒，这足以证明协程有多么高效。试想一下，如果开启的是10万个线程，程序或许已经出现OOM异常了。

#### 创建一个新的协程作用域--coroutineScope函数

随着launch函数中的逻辑越来越复杂，可能你需要将部分代码提取到一个单独的函数中。这个时候就产生了一个问题：我们在launch函数中编写的代码是拥有协程作用域的，但是提取到一个单独的函数中就没有协程作用域了，那么我们该如何调用像delay()这样的挂起函数呢？

为此Kotlin提供了一个suspend关键字，使用它可以将任意函数声明成挂起函数，而挂起函数之间都是可以互相调用的，如下所示：

```kotlin
suspend fun printDot() {	//这样就可以在printDot()函数中调用delay()函数了
    println(".")
    delay(1000)
}
```

但是，suspend关键字只能将一个函数声明成挂起函数，是无法给它提供协程作用域的。比如尝试在printDot()函数中调用launch函数，一定是无法调用成功的，因为launch函数要求必须在协程作用域当中才能调用。

这个问题可以借助coroutineScope函数来解决。

coroutineScope函数也是一个挂起函数，因此可以在任何其他挂起函数中调用。它的特点是会继承外部的协程的作用域并创建一个子协程，借助这个特性，我们就可以给任意挂起函数提供协程作用域了。示例写法如下：

```kotlin
suspend fun printDot() = coroutineScope {
    launch {
        println(".")
        delay(1000)
    }
}
```

可以看到，现在我们就可以在printDot()这个挂起函数中调用launch函数了。

另外，coroutineScope函数和runBlocking函数还有点类似，它可以保证其作用域内的所有代码和子协程在全部执行完之前，外部的协程会一直被挂起。

示例代码：

```kotlin
fun main() {
    runBlocking {
        coroutineScope {
            launch {
                for (i in 1..10) {
                    println(i)
                    delay(1000)
                }
            }
        }
        println("coroutineScope finished")
    }
    println("runBlocking finished")
}
```

这里先使用runBlocking函数创建了一个协程作用域，然后调用coroutineScope函数创建了一个子协程。在coroutineScope的作用域中，我们又调用launch函数创建了一个子协程，并通过for循环依次打印数字1到10，每次打印间隔一秒钟。最后在runBlocking和coroutineScope函数的结尾，分别又打印了一行日志。现在重新运行一下程序，结果如图：

![image-20230408220927019](https://cdn.jsdelivr.net/gh/ChengYang1998/blogImage@main/PicGo/image-20230408220927019.png)

控制台会以1秒钟的间隔依次输出数字1到10，然后才会打印coroutineScope函
数结尾的日志，最后打印runBlocking函数结尾的日志。

由此可见，coroutineScope函数确实是将外部协程挂起了，只有当它作用域内的所有代码和协程都执行完毕之后，coroutineScope函数之后的代码才能得到运行。

`coroutineScope`函数和`runBlocking`函数都可以用来创建协程作用域，但是它们的主要区别在于对于所在的协程的影响不同。

`runBlocking`函数会阻塞当前线程，直到它所包含的所有协程执行完成后才会返回。因此，`runBlocking`函数不应该在Android主线程或任何UI线程中使用，因为它会阻塞UI线程，导致应用程序失去响应。

相比之下，`coroutineScope`函数不会阻塞当前线程。它只会暂停当前协程，并且在所有子协程执行完成后才会返回。因此，`coroutineScope`函数更适合在Android中使用，因为它不会阻塞UI线程。

|                  | coroutineScope函数                                           | runBlocking函数                                      |
| ---------------- | ------------------------------------------------------------ | ---------------------------------------------------- |
| 作用             | 创建一个新的协程作用域，以便可以并发运行多个协程             | 阻塞当前线程，等待协程执行完成                       |
| 可以使用的上下文 | **只能在已经有协程作用域的协程中使用**                       | 可以在任何地方使用                                   |
| 返回值           | 协程执行完成后函数返回                                       | 协程执行完成后函数返回                               |
| 可取消性         | 调用cancel()函数只能取消作用域中的所有子协程，无法取消作用域本身 | 可以通过cancel()函数取消作用域本身和其中的所有子协程 |
| 异常处理         | 可以使用try-catch语句捕获协程作用域中的异常                  | 可以使用try-catch语句捕获协程作用域中的异常          |

### 2.更多的作用域构建器

GlobalScope.launch、runBlocking、launch、coroutineScope这几种作用域构建器，它们都可以用于创建一个新的协程作用域。

不过GlobalScope.launch和runBlocking函数是可以在任意地方调用的，coroutineScope函数可以在协程作用域或挂起函数中调用，而launch函数只能在协程作用域中调用。

runBlocking由于会阻塞线程，因此只建议在测试环境下使用。而GlobalScope.launch由于每次创建的都是顶层协程，一般也不太建议使用，除非你非常明确就是要创建顶层协程。

为什么说不太建议使用顶层协程呢？主要还是因为它管理起来成本太高了。举个例子，比如在某个Activity中使用协程发起了一条网络请求，由于网络请求是耗时的，用户在服务器还没来得及响应的情况下就关闭了当前Activity，此时按理说应该取消这条网络请求，或者至少不应该进行回调，因为Activity已经不存在了，回调了也没有意义。

那么协程要怎样取消呢？不管是GlobalScope.launch函数还是launch函数，它们都会返回一个Job对象，只需要调用Job对象的cancel()方法就可以取消协程了，如下所示：

```kotlin
val job = GlobalScope.launch {
	// 处理具体的逻辑
}
job.cancel()
```

但是如果我们每次创建的都是顶层协程，那么当Activity关闭时，就需要逐个调用所有已创建协程的cancel()方法，这样的代码根本无法维护。

#### CoroutineScope()函数

实际项目中比较常用的写法：

```kotlin
val job = Job()
val scope = CoroutineScope(job)
scope.launch {
	// 处理具体的逻辑
}
job.cancel()
```

我们先创建了一个Job对象，然后把它传入CoroutineScope()函数当中。

> 注意这里的CoroutineScope()是个函数，虽然它的命名更像是一个类。

CoroutineScope()函数会返回一个CoroutineScope对象，这种语法结构的设计更像是我们创建了一个CoroutineScope的实例，可能也是Kotlin有意为之的。

有了CoroutineScope对象之后，就可以随时调用它的launch函数来创建一个协程了。

现在所有调用CoroutineScope的launch函数所创建的协程，都会被关联在Job对象的作用域下面。

这样只需要调用一次cancel()方法，就可以将同一作用域内的所有协程全部取消，从而大大降低了协程管理的成本。

> launch函数只能用于执行一段逻辑，却不能获取执行的结果，因为它的返回值是一个Job对象。
>
> 那么有没有什么办法能够创建一个协程并获取它的执行结果呢？

#### async函数

async函数必须在协程作用域当中才能调用，它会创建一个新的子协程并返回一个Deferred对象，如果我们想要获取async函数代码块的执行结果，只需要调用Deferred对象的await()方法即可，代码如下所示：

```kotlin
suspend fun doSomething(): Int {
    delay(1000) // 模拟耗时操作
    return 42
}

fun main() {
    runBlocking {
        val deferredResult = async { doSomething() }
        // 可以在这里执行一些其他的任务
        val result = deferredResult.await() // 等待异步任务完成并获取结果
        println("The result is: $result")
    }
}
```

在上面的示例中，我们通过 `async` 函数启动一个异步任务，并使用 `await` 函数来等待任务完成并获取其返回结果。

当调用`await()`方法时，如果代码块中的代码还没执行完，那么`await()`方法会将当前协程阻塞住，直到可以获得async函数的执行结果。

在 `async` 函数的代码块中，我们调用了 `doSomething()` 函数来模拟一些耗时操作，并返回一个整数值 42。在 `runBlocking` 作用域中，我们首先通过 `async` 函数启动了一个异步任务，然后可以在等待异步任务完成的过程中执行一些其他的任务，最后通过 `await` 函数来获取异步任务的结果并打印输出。

#### withContext()函数

> 一个比较特殊的作用域构建器,大体可以将它理解成async函数的一种简化版写法

```kotlin
fun main() {
    runBlocking {
        val result = withContext(Dispatchers.Default) {
            5 + 5
        }
        println(result)
    }
}
```

调用withContext()函数之后，会立即执行代码块中的代码，同时将外部协程挂起。当代码块中的代码全部执行完之后，会将最后一行的执行结果作为withContext()函数的返回值返回，因此基本上相当于val result = async{ 5 + 5}.await()的写法。唯一不同的是，withContext()函数强制要求我们指定一个线程参数。

> Android中要求网络请求必须在子线程中进行，即使你开启了协程去执行网络请求，假如它是主线程当中的协程，那么程序仍然会出错。

这个时候我们就应该通过线程参数给协程指定一个具体的运行线程。

以下是各个线程参数的简介和使用场景：

| 线程参数               | 简介                                                         | 使用场景                                                     |
| ---------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Dispatchers.Default    | 非常适合执行 CPU 密集型的工作，比如执行一些复杂的计算任务，因为它使用的是一个线程池，线程数与 CPU 核心数相等，同时不会影响主线程的性能 | 执行一些复杂的计算任务，不会阻塞主线程                       |
| Dispatchers.IO         | 非常适合执行 I/O 密集型的工作，比如进行网络请求、读写文件等等，因为它使用的是一个线程池，线程数可以大于 CPU 核心数，能够最大化的利用 I/O 等待时间 | 进行网络请求、读写文件等等操作，能够在不阻塞主线程的情况下完成 |
| Dispatchers.Main       | 专门用来进行 UI 操作，因为只有主线程才能够更新 UI，所以如果需要进行 UI 操作，那么就必须要在主线程中执行 | 执行 UI 操作，更新 UI,这个值只能在Android项目中使用          |
| Dispatchers.Unconfined | 不会指定特定的线程来执行协程体，而是在调用协程体的线程中执行。也就是说，它根本没有办法保证协程体执行的线程 | 一般情况下不会使用到，但在某些情况下可以使用，例如当一个协程体的执行需要在不同线程之间切换，且需要保证某些数据在切换线程之后还能够被正确传递时 |

> 协程的主要用途就是可以大幅度地提升并发编程的运行效率

实际上，Kotlin中的协程还可以对传统回调的写法进行优化，从而让代码变得更加简洁。

### 3.使用协程简化回调的写法

传统回调->使用匿名类：

```kotlin
HttpUtil.sendHttpRequest(address, object : HttpCallbackListener {
    override fun onFinish(response: String) {
// 得到服务器返回的具体内容
    }
    override fun onError(e: Exception) {
// 在这里对异常情况进行处理
    }
})
```

在多少个地方发起网络请求，就需要编写多少次这样的匿名类实现。

借助suspendCoroutine函数就能将传统回调机制的写法大幅简化：

suspendCoroutine函数必须在协程作用域或挂起函数中才能调用，它接收一个Lambda表达式参数，主要作用是将当前协程立即挂起，然后在一个普通的线程中执行Lambda表达式中的代码。Lambda表达式的参数列表上会传入一个Continuation参数，调用它的resume()方法或resumeWithException()可以让协程恢复执行。

借助这个函数来对传统的回调写法进行优化。首先定义一个request()函数，代码如下所示：

```kotlin
suspend fun request(address: String): String {
    return suspendCoroutine { continuation ->
        HttpUtil.sendHttpRequest(address, object : HttpCallbackListener {
            override fun onFinish(response: String) {
                continuation.resume(response)
            }
            override fun onError(e: Exception) {
                continuation.resumeWithException(e)
            }
        })
    }
}
```

可以看到，request()函数是一个挂起函数，并且接收一个address参数。

在request()函数的内部，我们调用了刚刚介绍的suspendCoroutine函数，这样当前协程就会被立刻挂起，而Lambda表达式中的代码则会在普通线程中执行。接着我们在Lambda表达式中调用HttpUtil.sendHttpRequest()方法发起网络请求，并通过传统回调的方式监听请求结果。

如果请求成功就调用Continuation的resume()方法恢复被挂起的协程，并传入服务器响应的数据，该值会成为suspendCoroutine函数的返回值。如果请求失败，就调用Continuation的resumeWithException()恢复被挂起的协程，并传入具体的异常原因。

之后我们要发起多少次网络请求，都不需要再重复进行回调实现了。

```kotlin
suspend fun getBaiduResponse() {
    try {
        val response = request("https://www.baidu.com/")
// 对服务器响应的数据进行处理
    } catch (e: Exception) {
// 对异常情况进行处理
    }
}
```

由于 getBaiduResponse()是一个挂起函数，因此当它调用了request()函数时，当前的协程就会被立刻挂起，然后一直等待网络请求成功或失败后，当前协程才能恢复运行。这样即使不使用回调的写法，我们也能够获得异步网络请求的响应数据，而如果请求失败，则会直接进入catch语句当中。

不过这里，getBaiduResponse()函数被声明成了挂起函数，这样它也只能在协程作用域或其他挂起函数中调用了，使用起来有局限性。suspendCoroutine函数本身就是要结合协程一起使用的。

事实上，suspendCoroutine函数几乎可以用于简化任何回调的写法，比如使用Retrofit来发起网络请求需要这样写：

```kotlin
val appService = ServiceCreator.create<AppService>()
appService.getAppData().enqueue(object : Callback<List<App>> {
    override fun onResponse(call: Call<List<App>>, response: Response<List<App>>) {
// 得到服务器返回的数据
    }
    override fun onFailure(call: Call<List<App>>, t: Throwable) {
// 在这里对异常情况进行处理
    }
})
```

使用suspendCoroutine函数，对上述写法进行大幅度的简化。

由于不同的Service接口返回的数据类型也不同，所以这次不能像刚才那样针对具体的类型进行编程了，而是要使用泛型的方式。定义一个await()函数，代码如下所示：

```kotlin
suspend fun <T> Call<T>.await(): T {
    return suspendCoroutine { continuation ->
        enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val body = response.body()
                if (body != null) continuation.resume(body)
                else continuation.resumeWithException(
                    RuntimeException("response body is null"))
            }
            override fun onFailure(call: Call<T>, t: Throwable) {
                continuation.resumeWithException(t)
            }
        })
    }
}
```

这段代码相比于刚才的request()函数又复杂了一点。首先await()函数仍然是一个挂起函数，然后给它声明了一个泛型T，并将await()函数定义成了Call<T>的扩展函数，这样所有返回值是Call类型的Retrofit网络请求接口就都可以直接调用await()函数了。

接着，await()函数中使用了suspendCoroutine函数来挂起当前协程，并且由于扩展函数的原因，我们现在拥有了Call对象的上下文，那么这里就可以直接调用enqueue()方法让Retrofit发起网络请求。接下来，使用同样的方式对Retrofit响应的数据或者网络请求失败的情况进行处理就可以了。另外还有一点需要注意，在onResponse()回调当中，我们调用body()方法解析出来的对象是可能为空的。如果为空的话，这里的做法是手动抛出一个异常，你也可以根据自己的逻辑进行更加合适的处理。

有了await()函数之后，我们调用所有Retrofit的Service接口都会变得极其简单，比如刚才同样的功能就可以使用如下写法进行实现：

```kotlin
suspend fun getAppData() {
    try {
        val appList = ServiceCreator.create<AppService>().getAppData().await()
// 对服务器响应的数据进行处理
    } catch (e: Exception) {
// 对异常情况进行处理
    }
}
```

没有了冗长的匿名类实现，只需要简单调用一下await()函数就可以让Retrofit发起网络请求，并直接获得服务器响应的数据。

## 18.编写Kotlin工具方法

养成对Kotlin的各种特性进行灵活运用的意识，学会对几个常用API的用法进行简化，从而编写出一些好用的工具方法。

### 1.求N个数的最大最小值

两个数比大小这个功能，除了使用最基本的if语句之外，还可以借助Kotlin内置的max()函数，如下所示：

```kotlin
val a = 10
val b = 15
val larger = max(a, b)
```

>   可是现在如果我们想要在3个数中获取最大的那个数，应该怎么写呢？

由于max()函数只能接收两个参数，因此需要先比较前两个数的大小，然后再拿较大的那个数和剩余的数进行比较，写法如下：
```kotlin
val a = 10
val b = 15
val c = 5
val largest = max(max(a, b), c)
```

我们是可以对max()函数的用法进行简化的。

vararg关键字，它允许方法接收任意多个同等类型的参数。

那么我们就可以新建一个Max.kt文件，并在其中自定义一个max()函数，如下所示：

```kotlin
fun max(vararg nums: Int): Int {
    var maxNum = Int.MIN_VALUE
    for (num in nums) {	//nums 是一个 Int 类型的可变数组
        maxNum = kotlin.math.max(maxNum, num)
    }
    return maxNum
}
```

这里max()函数的参数声明中使用了vararg关键字，也就是说现在它可以接收任意多个整型参数。接着我们使用了一个maxNum变量来记录所有数的最大值，并在一开始将它赋值成了整型范围的最小值。然后使用for-in循环遍历nums参数列表，如果发现当前遍历的数字比maxNum更大，就将maxNum的值更新成这个数，最终将maxNum返回即可。

现在就可以使用如下的写法来实现：

```kotlin
val a = 10
val b = 15
val c = 5
val largest = max(a, b, c)
```

>   如果还想求N个浮点型或长整型数字的最大值，该怎么办呢？

可以定义很多个max()函数的重载，来接收不同类型的参数，Kotlin中内置的max()函数也是这么做的。

Java中规定，所有类型的数字都是可比较的，因此必须实现Comparable接口，这个规则在Kotlin中也同样成立。那么我们就可以借助泛型，将max()函数修改成接收任意多个实现Comparable接口的参数，代码如下所示：

```kotlin
fun <T : Comparable<T>> max(vararg nums: T): T {
    if (nums.isEmpty()) throw RuntimeException("Params can not be empty.")
    var maxNum = nums[0]
    for (num in nums) {
        if (num > maxNum) {
            maxNum = num
        }
    }
    return maxNum
}
```

这段代码中传入的泛型T必须是实现了Comparable接口的泛型，因为在该函数内部需要对泛型T进行比较操作，而Comparable接口是实现了Java中的对象比较机制。

接下来，我们判断nums参数列表是否为空，如果为空的话就主动抛出一个异常，提醒调用者max()函数必须传入参数。紧接着将maxNum的值赋值成nums参数列表中第一个参数的值，然后同样是遍历参数列表，如果发现了更大的值就对maxNum进行更新。

```kotlin
val a = 3.5
val b = 3.8
val c = 4.1
val largest = max(a, b, c)
```

### 2.简化Toast的用法

```kotlin
Toast.makeText(context, "This is Toast", Toast.LENGTH_SHORT).show()
```

很多人因为忘记调用最后的show()方法，导致Toast无法弹出，从而产生bug。

分析一下，Toast的makeText()方法接收3个参数：

-   第一个参数是Toast显示的上下文环境，必不可少；
-   第二个参数是Toast显示的内容，需要由调用方进行指定，可以传入字符串和字符串资源id两种类型；
-   第三个参数是Toast显示的时长，只支持Toast.LENGTH_SHORT和Toast.LENGTH_LONG这两种值，相对来说变化不大。

给String类和Int类各添加一个扩展函数，并在里面封装弹出Toast的具体逻辑。这样以后每次想要弹出Toast提示时，只需要调用它们的扩展函数就可以了。
新建一个Toast.kt文件，并在其中编写如下代码：

```kotlin
fun String.showToast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}
fun Int.showToast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}
```

现在：

```kotlin
"This is Toast".showToast(context)
```

### 3.简化Snackbar的用法

```kotlin
Snackbar.make(view, "This is Snackbar", 			Snackbar.LENGTH_SHORT)
	.setAction("Action") {
		// 处理具体的逻辑
	}
	.show()
```

可以看到，Snackbar中make()方法的第一个参数变成了View，而Toast中makeText()方法的第一个参数是Context，另外Snackbar还可以调用setAction()方法来设置一个额外的点击事件。除了这些区别之外，Snackbar和Toast的其他用法都是相似的。

由于make()方法接收一个View参数，Snackbar会使用这个View自动查找最外层的布局，用于展示Snackbar。因此，我们就可以给View类添加一个扩展函数，并在里面封装显示Snackbar的具体逻辑。新建一个Snackbar.kt文件，并编写如下代码：

```kotlin
fun View.showSnackbar(text: String, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, text, duration).show()
}
fun View.showSnackbar(resId: Int, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, resId, duration).show()
}
```

这段代码应该还是很好理解的，和刚才的showToast()函数比较相似。只是我们将扩展函数添加到了View类当中，并在参数列表上声明了Snackbar要显示的内容以及显示的时长。另外，Snackbar和Toast类似，显示的内容也是支持传入字符串和字符串资源id两种类型的，因此这里我们给showSnackbar()函数进行了两种参数类型的函数重载。

现在：

```kotlin
view.showSnackbar("This is Snackbar")
```

使用高阶函数让showSnackbar()函数再额外接收一个函数类型参数，以此来实现Snackbar的完整功能支持。

修改Snackbar.kt中的代码，如下所示：

```kotlin
fun View.showSnackbar(text: String, actionText: String? = null,
                      duration: Int = Snackbar.LENGTH_SHORT, block: (() -> Unit)? = null) {
    val snackbar = Snackbar.make(this, text, duration)
    if (actionText != null && block != null) {
        snackbar.setAction(actionText) {
            block()
        }
    }
    snackbar.show()
}
fun View.showSnackbar(resId: Int, actionResId: Int? = null,
                      duration: Int = Snackbar.LENGTH_SHORT, block: (() -> Unit)? = null) {
    val snackbar = Snackbar.make(this, resId, duration)
    if (actionResId != null && block != null) {
        snackbar.setAction(actionResId) {
            block()
        }
    }
    snackbar.show()
}
```

这里给两个`showSnackbar()`函数都增加了一个函数类型参数，并且还增加了一个用于传递给setAction()方法的字符串或字符串资源id。这里我们需要将新增的两个参数都设置成可为空的类型，并将默认值都设置成空，然后只有当两个参数都不为空的时候，我们才去调用Snackbar的setAction()方法来设置额外的点击事件。如果触发了点击事件，只需要调用函数类型参数将事件传递给外部的Lambda表达式即可。

现在：

```kotlin
view.showSnackbar("This is Snackbar", "Action") {
	// 处理具体的逻辑
}
```

## 19.Java与Kotlin代码之间的转换

### 1.自动转换

copy

![image-20230410111046691](https://cdn.jsdelivr.net/gh/ChengYang1998/blogImage@main/PicGo/image-20230410111046691.png)

上述方法是将一段Java代码转换成Kotlin代码的方式。另外，还可以直接将一个Java文件以及其中的所有代码一次性转换成Kotlin版本。具体操作方法是，首先在Android Studio中打开该Java文件，然后点击导航栏中的Code→Convert Java File to Kotlin File，如图所示。

![image-20230410111154216](https://cdn.jsdelivr.net/gh/ChengYang1998/blogImage@main/PicGo/image-20230410111154216.png)

>   Kotlin代码又该如何转换成Java代码呢？

很遗憾的是，Android Studio并没有提供类似的转换功能。

因为Kotlin拥有许多Java中并不存在的特性，因此很难执行这样的一键转换。

不过，我们却可以先将Kotlin代码转换成Kotlin字节码，然后再通过反编译的方式将它还原成Java代码。这种反编译出来的代码可能无法像正常编写的Java代码那样直接运行，但是非常有利于帮助我们理解诸多Kotlin特性背后的实现原理。

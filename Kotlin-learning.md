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


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






























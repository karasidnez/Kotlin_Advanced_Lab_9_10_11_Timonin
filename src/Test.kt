var age: Int = 18
    set(value) {
        if ((value > 0) and (value < 110))
            field = value
    }

fun main() {
    println(age) // 18
    age = 45
    println(age) // 45
    age = -345
    println(age) // 45
}
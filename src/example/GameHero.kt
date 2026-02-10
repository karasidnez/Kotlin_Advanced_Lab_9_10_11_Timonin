package example

import kotlin.properties.Delegates

class GameHero(startName: String) {
    var name: String by Delegates.observable(startName ) {
           _, old, new ->
        println("[$old] получил новое имя: $new!")
    }

    var mana: Int by Delegates.observable(100) {
            _, old, new ->
        println("Mana: $old -> $new")
    }

    val ultimate: String by lazy {
        println("Загружаем анимацию способности...")
        "Метеоритный дождь"
    }
}

fun main() {
    println("Создаём профиль пользователя...")
    val user = UserProfile("Алиса", "alice@example.com")

    println("\nИмя: ${user.name}")
    println("Email: ${user.email}")

    println("\nОбращаемся к аватару впервые:")
    println("Файл аватара: ${user.avatar}")

    println("\nОбращаемся к аватару снова (должен быть взят из кэша):")
    println("Файл аватара: ${user.avatar}")

    println("\nМеняем email:")
    user.email = "alice_new@example.org"

    println("\nМеняем имя:")
    user.name = "Алиса К."

    println("Создаём героя...")
    val hero = GameHero("Воин Света")

    println("\nТекущая мана: ${hero.mana}")

    println("\nГерой пытается использовать способность:")
    println("Способность: ${hero.ultimate}")

    println("\nПовторный вызов способности (должна быть мгновенной):")
    println("Способность: ${hero.ultimate}")

    println("\nМеняем имя героя:")
    hero.name = "Тёмный Паладин"

    println("\nГерой восстанавливает ману:")
    hero.mana = 200
}
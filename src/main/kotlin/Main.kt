fun main() {
    val onlineTimeAgo = 3601
    println(agoToText(onlineTimeAgo))

}

fun agoToText(
    onlineTimeAgo: Int) : String = when (onlineTimeAgo) {
        in 0..60 -> "Был(а) в сети только что"
        in 61..(60*60) -> "Был(а) в сети " + onlineTimeAgo/60 + inRussianMinutes(onlineTimeAgo)
        in (60*60) + 1..(24*60*60) -> "Был(а) в сети " + onlineTimeAgo/3600 + inRussianHours(onlineTimeAgo)
        in (24*60*60) + 1..(48*60*60) -> "Был(а) в сети сегодня"
        in (48*60*60) + 1..(72*60*60) -> "Был(а) в сети вчера"
        else -> "Был(а) в сети давно"
    }

fun inRussianMinutes(onlineTimeAgo: Int) : String = when (onlineTimeAgo/60 % 100) {
        in 11..19 -> " минут назад"
        else -> when (onlineTimeAgo/60 % 10) {
            1 -> " минуту назад"
            in 5..9 -> " минут назад"
            0 -> " минут назад"
            else -> " минуты назад"
        }
    }

fun inRussianHours(onlineTimeAgo: Int) : String = when (onlineTimeAgo/3600 % 100) {
    in 11..19 -> " часов назад"
    else -> when (onlineTimeAgo/3600 % 10) {
        1 -> " час назад"
        in 5..9 -> " часов назад"
        0 -> " часов назад"
        else -> " часа назад"
    }
}
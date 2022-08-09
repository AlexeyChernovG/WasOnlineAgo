fun main() {
    val onlineTimeAgo = 1320
    println(agoToText(onlineTimeAgo))

}

fun agoToText(
    onlineTimeAgo: Int) : String = when (onlineTimeAgo) {
        in 0..60 -> "Был онлайн только что"
        in 61..(60*60) -> "Был онлайн " + onlineTimeAgo/60 + inRussian(onlineTimeAgo)
        in (60*60) + 1..(24*60*60) -> "Был онлайн " + onlineTimeAgo/3600 + " часов назад"
        in (24*60*60) + 1..(48*60*60) -> "Был онлайн сегодня"
        in (48*60*60) + 1..(72*60*60) -> "Был онлайн вчера"
        else -> "Был онлайн давно"
    }

fun inRussian(onlineTimeAgo: Int) : String = when (onlineTimeAgo/60 % 100) {
        in 11..19 -> " минут назад"
        else -> when (onlineTimeAgo/60 % 10) {
            1 -> " минуту назад"
            in 5..9 -> " минут назад"
            0 -> " минут назад"
            else -> " минуты назад"
        }
    }
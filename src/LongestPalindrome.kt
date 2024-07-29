fun main(){
    println(longestPalindrome("babad"))

    println("-----------")

    val test = "babad"
    println(test.length)
    println(expandAroundCenter(test, 2, 2))
    println(1 / 2)
}

fun longestPalindrome(s: String): String {
    if (s.isEmpty()) return ""

    var start = 0
    var end = 0

    for (i in s.indices) {
        val len1 = expandAroundCenter(s, i, i)
        val len2 = expandAroundCenter(s, i, i + 1)
        val len = maxOf(len1, len2)
        println("len1: $len1, len2: $len2")
        if (len > end - start) {
            start = i - (len - 1) / 2
            end = i + len / 2
        }
        println("start: $start, end: $end")
    }

    return s.substring(start, end + 1)
}

private fun expandAroundCenter(s: String, left: Int, right: Int): Int {
    var l = left
    var r = right
    while (l >= 0 && r < s.length && s[l] == s[r]) {
        l--
        r++
    }
    return r - l - 1
}
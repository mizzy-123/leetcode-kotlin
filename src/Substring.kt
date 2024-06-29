fun main(){
    println(lengthOfLongestSubstring("pwwkew"))
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("bbbbb"))
}

fun lengthOfLongestSubstring(s: String): Int {
    val n = s.length
    var maxLength = 0
    var left = 0
    val charIndexMap = mutableMapOf<Char, Int>()

    for (right in 0 until n) {
        val currentChar = s[right]

        // Jika karakter sudah ada di map dan indeksnya >= left, perbarui left
        if (charIndexMap.containsKey(currentChar) && charIndexMap[currentChar]!! >= left) {
            left = charIndexMap[currentChar]!! + 1
        }

        // Perbarui atau tambahkan karakter ke dalam map
        charIndexMap[currentChar] = right

        // Hitung panjang substring saat ini dan perbarui maxLength
        maxLength = maxOf(maxLength, right - left + 1)
    }

    return maxLength
}
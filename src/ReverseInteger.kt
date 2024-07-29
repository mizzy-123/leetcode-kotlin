fun main(){
    println(reverse(123))
}

//fun reverse(x: Int): Int {
//    if (x == 0) return 0
//    val stringNumber = x.toString()
//
//    val arrayInt = arrayListOf<Int>()
//    val exceptDigit = arrayListOf<Char>()
//    for (i in stringNumber){
//        if (i.isDigit()){
//            arrayInt.add(i.digitToInt())
//        }else if (i == '-') {
//            exceptDigit.add(i)
//        }
//    }
//
//    if (arrayInt.last() == 0){
//        var index = arrayInt.lastIndex
//        while (index >= 0){
//            if (arrayInt[index] == 0){
//                arrayInt.removeAt(index)
//            } else {
//                break
//            }
//            index--
//        }
//    }
//
//    var lastIndex = arrayInt.lastIndex
//    val tempArrayInt = arrayListOf<Int>()
//    while (lastIndex >= 0){
//        tempArrayInt.add(arrayInt[lastIndex])
//        lastIndex--
//    }
//
//    arrayInt.clear()
//    arrayInt.addAll(tempArrayInt)
//
//    var result = arrayInt.joinToString(separator = "").toInt()
//
//    if (exceptDigit.isNotEmpty() && exceptDigit.contains('-')){
//        result *= -1
//    }
//    return result
//}

fun reverse(x: Int): Int {
    var num = x
    var reversed = 0L // Gunakan Long untuk menangani overflow

    while (num != 0) {
        val digit = num % 10
        num /= 10

        // Periksa apakah membalik digit akan menyebabkan overflow
        if (reversed > Int.MAX_VALUE / 10 || (reversed.equals(Int.MAX_VALUE / 10) && digit > 7)) {
            return 0 // Overflow positif
        }
        if (reversed < Int.MIN_VALUE / 10 || (reversed.equals(Int.MIN_VALUE / 10) && digit < -8)) {
            return 0 // Overflow negatif
        }

        reversed = reversed * 10 + digit
    }

    return reversed.toInt() // Konversi kembali ke Int
}
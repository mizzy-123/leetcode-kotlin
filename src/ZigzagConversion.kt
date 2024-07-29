fun main(){
    println(convert("PAYPALISHIRING", 3))
    println(8 % 4)

    printZigzag("PAYPALISHIRING", 3)
}

fun convert(s: String, numRows: Int): String {
    val totalRow = numRows
    var upDown = false
    val charIndexMap = mutableMapOf<Int, String>()

    if (totalRow == 1) return s

    for (x in 0 until totalRow){
        charIndexMap[x] = ""
    }

    var currentRow = 0
    for (i in s.indices){
        charIndexMap[currentRow] = charIndexMap[currentRow] + s[i]

        if (currentRow == totalRow - 1) {
            upDown = true
        } else if (currentRow == 0) {
            upDown = false
        }

        if (upDown) {
            currentRow--
        } else {
            currentRow++
        }
    }

    val result = StringBuilder()

    for (x in 0 until totalRow){
        result.append(charIndexMap[x])
    }
    return result.toString()
}

fun printZigzag(s: String, numRows: Int) {
    if (numRows == 1) {
        println(s)
        return
    }

    val rows = Array(numRows) { StringBuilder() }
    var currentRow = 0
    var goingDown = false

    for (char in s) {
        rows[currentRow].append(char)
        if (currentRow == 0 || currentRow == numRows - 1) {
            goingDown = !goingDown
        }
        currentRow += if (goingDown) 1 else -1
    }

    for (i in rows.indices){
        println(rows[i])
    }

    // Print the rows in the zigzag pattern
    for (i in rows.indices) {
        for (j in rows[i].indices) {
            if (rows[i][j] == ' ') {
                print("   ")
            } else {
                print(rows[i][j] + "   ")
            }
        }
        println()
    }
}

fun printZigzag2(s: String, numRows: Int) {
    if (numRows == 1) {
        println(s)
        return
    }

    // Membuat array dengan setiap elemen adalah StringBuilder
    val rows = Array(numRows) { StringBuilder() }
    var currentRow = 0
    var goingDown = false

    // Mengisi array dengan karakter sesuai pola zigzag
    for (char in s) {
        rows[currentRow].append(char)
        if (currentRow == 0 || currentRow == numRows - 1) {
            goingDown = !goingDown
        }
        currentRow += if (goingDown) 1 else -1
    }

    // Menemukan panjang baris terpanjang
    val maxRowLength = rows.maxOf { it.length }
    for (i in 0 until numRows) {
        val row = rows[i].toString().padEnd(maxRowLength, ' ')
        println(row.map { if (it == ' ') ' ' else it }.joinToString("   "))
    }
}
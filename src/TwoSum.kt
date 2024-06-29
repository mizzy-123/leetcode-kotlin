fun main() {
    val test: IntArray = intArrayOf(3,3)
    for(x in twoSum(test, 6)){
        println(x)
    }
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val resultNums: ArrayList<Int> = arrayListOf()
    for(x in nums.indices){
        for(i in nums.indices){
            if (i != x){
                val number1 = nums[x]
                val number2 = nums[i]
                val sum = number1 + number2
                if(number1 + number2 == target){
                    resultNums.add(x)
                    resultNums.add(i)
                    return resultNums.toIntArray()
                }
            }
        }
    }
    return resultNums.toIntArray()
}
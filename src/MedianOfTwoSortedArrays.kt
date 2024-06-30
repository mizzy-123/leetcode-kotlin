fun main(){
    val array1 = intArrayOf(1,2)
    val array2 = intArrayOf(3,4)

    println(findMedianSortedArrays(array1, array2))
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val sumNums = nums1.plus(nums2)

    val sortedNums = bubbleSort(sumNums)

    if (sortedNums.size % 2 == 1){
        val getMedian = sortedNums.size/2
        return sortedNums[getMedian].toDouble()
    } else {
        val getMedian = sortedNums.size/2
        val getDataFixMedian = (sortedNums[getMedian-1] + sortedNums[getMedian]).toDouble() / 2
        return getDataFixMedian
    }
}

fun bubbleSort(array: IntArray): IntArray{
    val n = array.size
    var swapped: Boolean
    do {
        swapped = false

        for(i in 1 until n){
            if (array[i-1] > array[i]){
                val temp = array[i-1]
                array[i-1] = array[i]
                array[i] = temp
                swapped = true
            }
        }
    } while(swapped)

    return array
}
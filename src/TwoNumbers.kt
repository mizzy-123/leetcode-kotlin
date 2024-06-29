class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


fun main(){
    // Membuat contoh linked list l1 = [2, 4, 3]
    val l1 = ListNode(2).apply {
        next = ListNode(4).apply {
            next = ListNode(3)
        }
    }

    // Membuat contoh linked list l2 = [5, 6, 4]
    val l2 = ListNode(5).apply {
        next = ListNode(6).apply {
            next = ListNode(4)
        }
    }

    val result = addTwoNumbers(l1, l2)

    // Mencetak hasil linked list
    var current: ListNode? = result
    while (current != null) {
        print("${current.`val`} ")
        current = current.next
    }
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var p = l1
    var q = l2
    var carry = 0
    val dummyHead = ListNode(0)
    var curr = dummyHead

    while (p != null || q != null){
        val x = p?.`val`?: 0
        val y = q?.`val`?: 0
        val sum = carry + x + y
        carry = sum / 10
        curr.next = ListNode(sum % 10)
        curr = curr.next!!
        p = p?.next
        q = q?.next
    }

    if (carry > 0){
        curr.next = ListNode(carry)
    }
    return dummyHead.next
}
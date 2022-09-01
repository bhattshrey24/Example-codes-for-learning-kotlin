package `Data Structres`

import java.util.*
import java.util.ArrayDeque
import kotlin.collections.ArrayList

class GeneralDataStructures {
    fun execute() {
        stackTest()
        normalQueueTest()
        priorityQueueTest()
        linkedListTest()
        hashMapTest()
    }

    private fun stackTest() {
        println("Stack -------------")
        var st = Stack<Int>()
        st.push(10)
        st.push(20)
        st.push(30)
        st.push(30)
        st.push(40)
        st.push(60)
        st.push(65)
        st.push(70)
        println("Stack elements -- ")
        st.forEach { ele ->
            println(ele)
        }
        println("Element at the top = ${st.peek()}")
        st.pop()
        println("Element at the top after pop = ${st.peek()}")
        println("Stack is empty - ${st.isEmpty()}")
        println("Stack elements -- ")
        st.forEach { ele ->
            println(ele)
        }
        println("position of element 20 from top is  - ${st.search(20)} ")
        println("position of element 50 from top is   - ${st.search(50)}")
        println("Does stack contains 20 - ${st.contains(20)}")
    }

    private fun normalQueueTest() { // I guess this is Queue implementation using linkedList
        println("Normal Queue -------------")
        var que = ArrayDeque<Int>()
        que.add(20)
        que.addFirst(10)
        que.add(30)
        que.add(40)
        que.addLast(50)
        println("Queue is -----")
        que.forEach { ele ->
            println(ele)
        }
        println("1st element of que ${que.peekFirst()}")
        println("1st element of que ${que.peekLast()}")
        println("Does Que contains 20 ${que.contains(20)}")
        que.remove()
        println(que.size)
        que.removeFirst()
        que.removeLast()
    }

    private fun priorityQueueTest() {
        println("priorityQueue and Heaps -------------")
        var pq = PriorityQueue<Int>() // Aka min heap
        pq.add(2)
        pq.add(5)
        pq.add(8)
        pq.add(4)
        pq.add(1)
        val sizePq = pq.size - 1
        println("Taking elements out of priority queue aka min heap")
        for (i in 0..sizePq) {
            println(pq.remove())
        }

        val compareByCount = Comparator<Int> { t1, t2 -> t2 - t1 }
        var maxHeap = PriorityQueue<Int>(compareByCount) // Aka min heap
        maxHeap.add(2)
        maxHeap.add(5)
        maxHeap.add(8)
        maxHeap.add(4)
        maxHeap.add(1)
        val sizeMHeap = maxHeap.size - 1
        println("Taking elements out of max heap")
        for (i in 0..sizeMHeap) {
            println(maxHeap.remove())
        }
    }

    private fun linkedListTest() {
        println("linkedList -------------")
        var LL = LinkedList<Int>()
        LL.add(2)
        LL.add(3)
        LL.add(4)
        LL.add(5)
        LL.addFirst(1)
        LL.addLast(6)
        println("Printing Linked List")
        LL.forEach {
            println(it)
        }
        LL.remove()// will remove from start
        println("Printing Linked List after removing from start")
        LL.forEach {
            println(it)
        }
        LL.removeLast()
        println("Printing Linked List after removing from last")
        LL.forEach {
            println(it)
        }
    }

    private fun hashMapTest() {
        println("HashMap -------------")
        val hm = mapOf<String, Int>("Shrey" to 22, "Stuti" to 27,
            "Prasoon" to 29, "Prateek" to 27)
        println("Printing all the Keys")
        for (key in hm.keys) {
            println(key)
        }
        println("Printing all the Values")
        for (value in hm.values) {
            println(value)
        }
        println("Printing keys and values together")
        for (keyAndVal in hm.entries) {
            println("Key : ${keyAndVal.key} , Value : ${keyAndVal.value}")
        }
        println("Does Hm contains Shrey : ${hm.containsKey("Shrey")}")
        println("Does Hm contains 40 : ${hm.containsValue(40)}")

        val stutiAge = hm.get("Stuti")

        val mhm = mutableMapOf<Int, String>()
        mhm.put(22, "Shrey")
        mhm[27] = "Stuti"
    }
}
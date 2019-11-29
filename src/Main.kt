/*   ANOTHER VERSION FOR TASK 3 --- OPTIONAL

typealias SIZE = () -> Unit
typealias ALL = () -> Int
val size={}
val all={1}

OR

val size = Unit
val all = Unit
*/

import FunParams.*


fun main() {

// Task 1

    // Create forEachWord function
    "   please       print each      word       ".forEachWord { word ->
        println(word)
    }

    // create toColor function
    val c = (-0x775FB34F).toColor()
    println(c) // Color(a=136, r=160, g=76, b=177)

    // create bitIsOneAtPosition
    println(4.bitIsOneAtPosition(2))


// Task 2

// create root and node

  val r =  root("root") {
       node("1")
        {
            node("3")
            {
                node("5")
            }
            node("4")
        }
        node("2")
    }

    println(r)

// Task 3

    val size = SIZE
    val all = ALL

    var arr = IntArray(0)
    arr = arr add 3 // create new array and add element at the end
    arr = arr add 7 add 1
    arr = arr add 9 add 6 add 8
    arr = arr insert 5 at 2 // insert 5 into position 2
    arr `remove at` 3 // set to 0 at position 3
    arr `remove at` 1
    arr print 2..5 // 5 0 6 8

    // optional
    println()
    println(arr get size) // 6
    arr print all // 3 0 5 0 6 8
}

class Node(
    val name: String
) {
    val node = mutableListOf<Node>()

    fun node(name: String, init: Node.() -> Unit = {}): Node {
        val newNode = Node(name)
        newNode.init()
        node.add(newNode)
        return newNode
    }

    override fun toString(): String {
        return "Node(name='$name', nods=$node)"
    }
}





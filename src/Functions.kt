import java.lang.Exception
import FunParams.*

fun String.forEachWord(print: (String) -> Unit) {
    this.trim().let {
        var word = it
        for (i in 0..it.length) {
            word = word.replace("  ", " ")
        }
        word.split(" ").forEach(print)
    }
}

fun Int.toColor(): Color {
    val alfa = (this shr 24) and 0xff
    val red = (this shr 16) and 0xff
    val green = (this shr 8) and 0xff
    val blue = (this) and 0xff
    return Color(alfa, red, green, blue)
}

fun Int.bitIsOneAtPosition(position: Int): Boolean {
    if (this <= 0) {
        println("receiver must be > 0")
        return false
    }

    var binary = ""
    var number = this

    while (number > 0) {
        binary = (if ((number % 2) == 0) "0" else "1") + binary
        number /= 2
    }
    println("binary representation of receiver is - <$binary>")
    return if (position > binary.length - 1) {
        println("argument (position) - $position is bigger than receiver binary representation length - ${binary.length - 1}")
        false
    } else binary[position] == '1'
}

infix fun IntArray.add(element: Int): IntArray {
    val newArray: MutableList<Int> = toMutableList()
    newArray.add(element)
    //println(newArray)
    return newArray.toIntArray()
}

infix fun IntArray.insert(element: Int): IntArray {
    return this add element
}

infix fun IntArray.at(position: Int): IntArray {
    val newArray: MutableList<Int> = toMutableList()
    newArray.removeAt(size - 1)
    newArray[position] = last()
    //println(newArray)
    return newArray.toIntArray()
}

infix fun IntArray.`remove at`(position: Int): IntArray {
//   Version 1

//    val newArray: MutableList<Int> = toMutableList()
//    newArray[position]=0
//    println(newArray)
//    return newArray.toIntArray()

//   Version 2

//    val newArray=this
//    newArray[position]=0
//    newArray.print(0..newArray.size-1)
//    println()
//    return newArray

    this[position] = 0
    //  print(0 until size)
    // println()
    return this
}

infix fun IntArray.print(range: IntRange) {
    if (range.last > lastIndex || range.first < 0) {
        throw ArrayIndexOutOfBoundsException("incorrect range")
    } else {
        for (i in range) {
            print("${this[i]} ")
        }
    }
}

infix fun IntArray.get(input: FunParams): Int {
    if (input.equals(SIZE)) {
        return size
    } else {
        throw Exception("wrong parameter")
    }
}

infix fun IntArray.print(input: FunParams) {
    if (input.equals(ALL)) {
        this print (0 until size)
    } else {
        throw Exception("wrong parameter")
    }
}


/*   ANOTHER VERSION FOR TASK 3 --- OPTIONAL

infix fun IntArray.print(input: ALL){
       print(0 until size)
}

infix fun IntArray.get(input: SIZE): Int{
    return this.size
}

  OR

infix fun IntArray.print(input: Unit){
       print(0 until size)
}

infix fun IntArray.get(input: Unit): Int{
    return this.size
}
*/

fun root(name: String, init: Node.() -> Unit): Node {
    val newNode = Node(name)
    newNode.init()
    return newNode
}

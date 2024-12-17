//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val head = Node(1).apply {
        next = Node(2).apply {
            next = Node(3).apply {
                next = Node(4)
            }
        }
    }

    println("Before: ")
    printLinkedList(head)
    val reversed = reverseLinkedList(head)

    println("After: ")
    printLinkedList(reversed)
}

private fun printLinkedList(head: Node?) {
    var current: Node? = head
    while (current != null) {
        print("${current.value} -> ")
        current = current.next
    }
    println()
}

/**
 * Алгоритм разворота связного списка
 *
 * Аналогия с поездом: Вы стоите между вагонами поезда, по одному отцепляете вагоны и ставите вререди себя.
 * В конце будет поезд, движущийся в противоположном направлении. В конце получаем ссылку на последний "вагон",
 * который стал первым.
 *
 * @param head ссылка на первый элемент списка (голову)
 */

private fun reverseLinkedList(head: Node): Node? {
    // Это ссылка на предыдущий элемент
    var prev: Node? = null
    // Это ссылка на текущий элемент
    var current: Node? = head
    // Это временная переменная для хранения ссылки на следующий элемент
    var next: Node?

    while (current != null) {
        // Временно храним следующий элемент
        next = current.next

        // Ссылка на следующий элемент переключается меняется на ссылку предыдующий элемент
        current.next = prev

        // Предыдующий элемент становится текущим
        prev = current

        // Это переход к следующей итерации
        current = next
    }
    return prev
}

data class Node(val value: Int, var next: Node? = null)
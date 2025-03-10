package g0101_0200.s0138_copy_list_with_random_pointer

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Hash_Table #Linked_List
// #Programming_Skills_II_Day_14 #Udemy_Linked_List #Top_Interview_150_Linked_List
// #Big_O_Time_O(N)_Space_O(N) #2022_09_03_Time_274_ms_(80.58%)_Space_40.5_MB_(58.99%)

import com_github_leetcode.random.Node

/*
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */
class Solution {
    fun copyRandomList(head: Node?): Node? {
        if (head == null) {
            return null
        }
        // first pass to have a clone node point to the next node. ie A->B becomes A->clonedNode->B
        var curr: Node? = head
        while (curr != null) {
            val clonedNode = Node(curr.`val`)
            clonedNode.next = curr.next
            curr.next = clonedNode
            curr = clonedNode.next
        }
        curr = head
        // second pass to make the cloned node's random pointer point to the orginal node's randome
        // pointer.
        // ie. A's random pointer becomes ClonedNode's random pointer
        while (curr != null) {
            if (curr.random != null) {
                curr.next?.random = curr.random!!.next
            } else {
                curr.next?.random = null
            }
            curr = curr.next?.next
        }
        curr = head
        // third pass to restore the links and return the head of the cloned nodes' list.
        var newHead: Node? = null
        while (curr != null) {
            var clonedNode: Node
            if (newHead == null) {
                clonedNode = curr.next!!
                newHead = clonedNode
            } else {
                clonedNode = curr.next!!
            }
            curr.next = clonedNode.next
            if (curr.next != null) {
                clonedNode.next = curr.next!!.next
            } else {
                clonedNode.next = null
            }
            curr = curr.next
        }
        return newHead
    }
}

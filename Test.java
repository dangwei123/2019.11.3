1.
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

说明：不允许修改给定的链表。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode newHead=new ListNode(-199);
        newHead.next=head;
        ListNode fast=newHead;
        ListNode slow=newHead;
        do{
            fast=fast.next.next;
            slow=slow.next;
        }while(fast!=null&&fast.next!=null&&fast!=slow);
        if(fast!=slow){
            return null;
        }
        ListNode ptr1=newHead;
        while(ptr1!=slow){
            ptr1=ptr1.next;
            slow=slow.next;
        }
        return slow;
    }
}

2.
给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节
点指的是节点编号的奇偶性，而不是节点的值的奇偶性。请尝试使用原地算法完成。你的算法的空间
复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

示例 1:

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/odd-even-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
      if(head==null){
          return null;
      }
        ListNode before=head;
        ListNode afterHead=head.next;
        ListNode after=afterHead;
        while(before.next!=null&&after.next!=null){
            before.next=after.next;
            before=before.next;
            if(before!=null){
                  after.next=before.next;
                  after=after.next;
             } 
        }
        before.next=afterHead;
        return head;
    }
}

3.
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode newHead=new ListNode(-999);
        newHead.next=head;
        ListNode pre=newHead;
        ListNode cur=head;
       while(cur!=null){
           if(cur.next!=null&&cur.val==cur.next.val){
               while(cur.next!=null&&cur.val==cur.next.val){
                   cur=cur.next;
               }
               pre.next=cur.next;
               cur=cur.next;
           }else{
               pre=cur;
               cur=cur.next;
           }
           
       }
        return newHead.next;
    }
}



//链表分割
import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if(pHead==null){
            return null;
        }
        ListNode cur=pHead;
        ListNode beforeHead=null;
        ListNode before=null;
        ListNode afterHead=null;
        ListNode after=null;
        while(cur!=null){
            ListNode curNext=cur.next;
            cur.next=null;
            if(cur.val<x){
                if(beforeHead==null){
                    beforeHead=cur;
                    before=cur;
                }else{
                    before.next=cur;
                    before=before.next;
                }
            }else{
                if(afterHead==null){
                    afterHead=cur;
                    after=cur;
                }else{
                    after.next=cur;
                    after=after.next;
                }
            }
            cur=curNext;
        }
        if(beforeHead!=null){
            before.next=afterHead;
            return beforeHead;
        }
        return afterHead;
    }
}

//输出倒数第k个节点
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k<=0){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(k-1!=0){
            if(fast.next!=null){
                fast=fast.next;
                k--;
            }else{
                return null;
            }
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}

//判断回文链表
import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Palindrome {
    public boolean isPalindrome(ListNode pHead) {
        // write code here
        if(pHead==null||pHead.next==null){
            return true;
        }
        ListNode fast=pHead;
        ListNode slow=pHead;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode cur=slow.next;
        while(cur!=null){
            ListNode curNext=cur.next;
            cur.next=slow;
            slow=cur;
            cur=curNext;
        }
        while(pHead!=slow){
            if(pHead.val!=slow.val){
                return false;
            }
            if(pHead.next==slow){
                return true;
            }
            pHead=pHead.next;
            slow=slow.next;
        }
        return true;
    }
}
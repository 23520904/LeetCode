/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int mem = 0;
        ListNode l3 = null;
        ListNode cur = new ListNode();
        while(l1 != null || l2 != null){
            int val3 = mem;
            if(l1 != null) val3+= l1.val;
            if(l2 != null) val3+= l2.val;
            mem = 0;
            if (val3 > 9) mem = 1;
            ListNode temp = new ListNode(val3%10);
            cur.next = temp;
            if(l3==null){
                l3 = cur;
            }
            cur= cur.next;
            if(l1!= null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        if (mem == 1) {
            ListNode tmp = new ListNode(1);
            cur.next=tmp;
        }
        return l3.next;
    }
}
/*
807
1 - 7 - 80
2 - 0 - 8


807 expect 7,0,8


*/
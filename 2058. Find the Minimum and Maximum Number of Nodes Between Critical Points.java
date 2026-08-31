class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int minDist=Integer.MAX_VALUE;
        ListNode prev=head;
        ListNode curr=head.next;
        int currPosition=1;
        int prevCriticalIndex=0;
        int firstCriticalIndex=0;

        while(curr.next!=null){
            if((curr.val<prev.val && curr.val<curr.next.val) ||
               (curr.val>prev.val && curr.val>curr.next.val)){
                  
               if(prevCriticalIndex==0){
                  prevCriticalIndex=currPosition;
                  firstCriticalIndex=currPosition;
               }
               else{
                 minDist=Math.min(minDist,currPosition-prevCriticalIndex);
                 prevCriticalIndex=currPosition;
               }
            }
            currPosition++;
            prev=curr;
            curr=curr.next;
        }
        if(minDist==Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }
        int maxDist=prevCriticalIndex-firstCriticalIndex;
        return new int[]{minDist,maxDist};
    }
}

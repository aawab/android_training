
public class Day2Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = -1, end =-1;
        for(int i =0 ; i <nums.length; i++){
            //Check to prevent non-target value indices to be assigned to start or end
            if(target!=nums[i]) continue;
            if(start==-1) start=i;
            end=i;
        }
        //If target wasn't found returns default values -1,-1
        return new int[] {start,end};
    }
}

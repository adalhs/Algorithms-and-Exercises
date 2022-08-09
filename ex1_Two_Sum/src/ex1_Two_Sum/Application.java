package ex1_Two_Sum;

import java.util.Arrays;

public class Application {

	public static void main(String[] args) {
		
		
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.twoSum(nums,  target)));
	}

}

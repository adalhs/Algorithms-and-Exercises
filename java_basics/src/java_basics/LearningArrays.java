package java_basics;

public class LearningArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] nums = new int[100];
		nums[0] = 1000;
		nums[1] = 33;
		nums[99] = 94784;
		
		System.out.println(nums[0]);
		System.out.println(nums[99]);
		
		// Another way to add values to an array,
		// right as we declare it
		String [] words = new String[] {"My", "Name", "is"};
		
		System.out.println(words[2]);
		
		// I am changing the size of an array here,
		// this deletes all data in the array
		words = new String[10];
		
		System.out.println(words[0]);
	}

}

package Solution;

import java.util.Arrays;

public class level2_Hindex {
	public static void main(String[] args) {
		int[] citations = {3,0,1,6,5};
		
        int answer = 0;
        Arrays.sort(citations);
        //System.out.println(Arrays.toString(citations));
        for(int i=0; i<citations.length; i++){
            if(citations[i] >= citations.length-i){
                answer = citations.length-i;
                break;
            }
        }
        System.out.println(answer);
	}
}

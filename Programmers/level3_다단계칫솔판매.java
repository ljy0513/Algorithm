package Solution;

import java.util.Arrays;

public class level3_다단계칫솔판매 {

	public static void main(String[] args) {
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		
		int[] answer = new int[enroll.length];

		for (int i = 0; i < seller.length; i++) {
			int seller_order = find_order(enroll, seller[i]);
			int profit = (int) Math.ceil(amount[i] * 100 * 0.9);
			answer[seller_order] += profit;
			int dstrb = amount[i] * 100 - profit;

			while (true) {
				if(referral[seller_order].equals("-")) break;
				seller_order = find_order(enroll, referral[seller_order]);
				profit = (int) Math.ceil(dstrb * 0.9);
				answer[seller_order] += profit;
				dstrb -= profit;

				if (dstrb < 1 || referral[seller_order].equals("-")) {
					break;
				}
			}

		}
		
		System.out.println(Arrays.toString(answer));

	}
	
	static int find_order (String[] enroll, String seller) {
        int recommend = 0;
        
        for(int i=0; i<enroll.length; i++) {
            if(seller.equals(enroll[i])){
                recommend = i;
                break;
            }
        }
        
        return recommend;
    }

}

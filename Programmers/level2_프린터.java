package Solution;

import java.util.ArrayList;
import java.util.List;

public class level2_프린터 {
	static List<File> list;
	
	public static void main(String[] args) {
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		int answer =0;
		
		list = new ArrayList<>();
		for(int i=0; i<priorities.length; i++) {
			list.add(new File(i,priorities[i]));
		}
		
		int order = 0;
		while(list.size() > 0) {
			File f = list.remove(0);
			
			if(contain(f)) {
				order++;
				if(f.n == location) break;				
			}else {
				list.add(f);
			}
		}
		
		answer = order;
		System.out.println(answer);
	}
	static boolean contain (File f){
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).p > f.p) return false;
		}
		return true;
	}
	
	static class File{
		int n,p;

		public File(int n, int p) {
			super();
			this.n = n;
			this.p = p;
		}
	}

}

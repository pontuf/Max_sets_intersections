import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Main{
	public static String inpu(){
		int a = ThreadLocalRandom.current().nextInt(0, 50);
		int b = ThreadLocalRandom.current().nextInt(0, 50);
		int c = 0;

	    if (a > b){
	    	c = a; 
	    	a = b;
	    	b = c;
	    }	   
	    else if (a == b)
	        b += 1;

	    for (int i = 0; i < 50; i++){
	    	if (i >= a && i <= b)
	            System.out.print("#");
	        else
	            System.out.print(" ");	
	    }
	    
	    System.out.println(); 
	    return String.valueOf(a) + " " + String.valueOf(b);	
	}

	public static void main(String[] args){
		ArrayList<int[]> ints = new ArrayList<int[]>();
		int num = 10;

		for (int i = 0; i < num; i++){
		    String cur = inpu();
		    String[] temp = cur.split(" ");
		    int[] arr = new int[2];
		    arr[0] = Integer.parseInt(temp[1]);
		    arr[1] = Integer.parseInt(temp[0]);

		    ints.add(arr);
		}
		Collections.sort(ints, new Comparator<int[]>() {
    			@Override
    			public int compare(int[] lhs, int[] rhs) {
        		// -1 - less than, 1 - greater than, 0 
        			return lhs[1] > rhs[1] ? 1 : (lhs[1] < rhs[1]) ? -1 : 0;
    			}
		});

		int tim = 0;
		int vacs = 0;
		int max_vacs = -1;
		int left = -1;
		int pers = 0;
		int old = -1;
		int i = 0;

		for (int j = 0; j < num; j++){
		    if (max_vacs > (num - j))
		        break;
		    if (ints.get(j)[0] == old)
		        continue;
		    
		    i = j;
	        while (i < num){
	        	if (ints.get(i)[1] <= ints.get(j)[0])
	            	vacs += 1;    
	            if (ints.get(i)[1] > left)
	                left = ints.get(i)[1];	
	        	i++;
	        }
		        
		                
		    if (vacs > max_vacs) {
		        max_vacs = vacs;
		        tim = 0;
		        pers = 0;
		    }
		    if (vacs == max_vacs){
		    	tim += ints.get(j)[0] - left + 1;
		        pers += 1;
		    }
		        
		        
		    old = ints.get(j)[0];
		    left = -1;
		    vacs = 0;
		}
		System.out.format("%d %d", pers, tim);
	}	
}



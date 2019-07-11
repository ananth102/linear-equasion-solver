import java.util.Arrays;
import java.util.Random;

public class matrix {
	private double[][] stor;
	Random r;
	
	public matrix(int i,int j) {
		stor = new double[i][j];
		r = new Random();
	}
	
	public void scaleRow(int row,double factor) {
		
		for(int i =0;i<stor[0].length;i++) {
			stor[row][i] = stor[row][i]*factor;
		}
	}
	
	public double[][] getMatrix(){
		return stor;
	}
	
	public void randomize() {
		for(int i=0;i<stor.length;i++) {
			for(int j=0;j<stor[0].length;j++) {
				stor[i][j] = r.nextInt(10);
			}
		}
	}
	public void interchange(int a,int b) {
		double[] s = stor[a];
		stor[a] = stor[b];
		stor[b] = s;
	}
	public void addRow(int addTo,int adder,double factor) {
		for(int i =0;i<stor[0].length;i++) {
			stor[addTo][i] = stor[addTo][i]+(stor[adder][i]*factor);
		}
	}
	public String toString() {
		String str = "";
		for (int i = 0; i < stor.length; i++) {
			str+=Arrays.toString(stor[i]);
		}
		return str;
	}
	public double[] getCol(int c) {
		double[] col = new double[stor.length];
		for(int i =0;i<stor.length;i++) {
			col[i] = stor[i][c];
		}
		return col;
	}
	//simple version assuming square matrix
	public void reduceCol(int col) {
		if(col >= getSize()[0])return;
		double[] co = getCol(col);
		if(co[col] == 0 && col != co.length-1) {
			interchange(col, col+1);
		}
		co = getCol(col);
		double scale = 1/co[col];
		
		scaleRow(col,scale);
		
		for(int i=0;i<co.length;i++) {
			double sc = co[i]; //1 divided by the amount
			if(i != col)addRow(i,col,-sc);
		}
	}
	public void reduceSquare() {
		int[] size = getSize();
		int sumTo = size[0] > size[1]? size[0]-1:size[1]-1;  // row > col 
		for(int i=0;i<sumTo;i++) {
			reduceCol(i);
		}
	}
	
	
	
	public int[] getSize() {
		int[] s = new int[2];
		s[0] = stor.length;
		s[1] = stor[0].length;
		return s;
	}
	
	public boolean isConsistent() {
		boolean con = true;
		for (int i = 0; i < stor.length; i++) {
			con = consistentArray(stor[i]);
			if(!con)return false;
		}
		return true;
	}
	
	public boolean consistentArray(double[] arr) {
		if(arr[arr.length-1] == 0)return true;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i] !=0) {
				return true;
			}
		}
		return false;
	}
	public void setEntry(double d,int i,int j) {
		stor[i][j] = d;
	}
	public void setRow(double[] d,int i) {
		stor[i] = d;
	}
	public void setArray(double[][] d) {
		stor = d;
	}
	public void printResult() {
		for (int i = 0; i < stor[0].length-1; i++) {
			
			System.out.println("x"+(i+1)+" is "+ getValues(i));
		}
	}
	public String getResult() {
		String str = "";
		for (int i = 0; i < stor[0].length-1; i++) {
			
			str+=("x"+(i+1)+" is "+ getValues(i)+"\n");
		}
		return str;
	}
	public String[] getResultAsArray() {
		String[] str = new String[stor[0].length];
		for (int i = 0; i < str.length-1; i++) {
			str[i] = ("x"+(i+1)+" is "+ getValues(i));
		}
		return str;
	}
	public boolean noFreeVariable(int i) {
		int len = 0;
		for (int j = 0; j < stor.length-1; j++) {
			if(stor[i][j] != 0)len++;
		}
		if(len <= 1)return true;
		return false;
	}
	public String getValues(int i) {
		
		boolean firstI = false;
		String str = "";
		if(i >= stor.length) {
			str+=(" free");
			return str;
		}
		for(int j=0;j<stor[0].length-1;j++) {
			if(stor[i][j] != 0) {
				if(firstI) {
					double d = -1 * stor[i][j];
					str+=(d+"x"+(j+1)+"+ ");
				}else firstI = true;
			}
		}
		str+=(stor[i][stor[0].length-1]);
		return str;
	}
}

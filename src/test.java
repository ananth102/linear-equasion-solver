
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[0.0, 6.0, 4.0][2.0, 4.0, 6.0][6.0, 3.0, 7.0]
		double[][] s = {
				{5,3,2,7,6},
				{9,7,5,7,5},
				{2,5,4,2,5}
		};
		matrix m = new matrix(3,4);
		m.randomize();
		//m.setArray(s);
		System.out.println(m);
		m.reduceSquare();
		//System.out.println(m);
		m.printResult();
		if(!m.isConsistent())System.out.println("matrix is not consistent");
	}
	
	

}

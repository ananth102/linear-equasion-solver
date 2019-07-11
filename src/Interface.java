import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;  
public class Interface {
	JFrame f;
	JButton compute;
	public Interface(int x,int y) {
		Random r = new Random();
		f = new JFrame();
		f.setSize(500,500);
		compute = new JButton("compute");
		compute.setBounds(200,300,100, 40);
		f.add(compute);
		JTextField[] textfields = new JTextField[x*y];
		int count = 0;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				textfields[count] =  new JTextField("x"+count);
				//int hScale = count/(x);
				//int wScale = j;
				int wid = 30;
				int hight = 30;
				textfields[count].setBounds(50+(int)(j*wid*1.5), 50+(int)(i*wid*1.5), wid, hight);

				f.add(textfields[count]);
				count++;
			}
			
		}
		//JTextField result = new JTextField();
		//result.setBounds(300,400,100,100);
		JButton randomize = new JButton("randomize");
		randomize.setBounds(200, 400, 100, 50);
		JLabel[] results = new JLabel[y];
		for (int i = 0; i < results.length; i++) {
			results[i] = new JLabel("x"+i);
			results[i].setBounds(300, 100+(i*50), 100, 50);
			f.add(results[i]);
		}
		f.add(randomize);
		//f.add(result);
		
		f.setLayout(null);
		f.setVisible(true);
		compute.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent c) {
				// TODO Auto-generated method stub
				matrix a = new matrix(x, y);
				int count = 0;
				for (int i = 0; i < x; i++) {
					for (int j = 0; j < y; j++) {
						a.setEntry(Double.parseDouble(textfields[count].getText()), i, j);
						count++;
					}
				}
				a.reduceSquare();
				//result.setText(a.getResult());
				count = 0;
				String[] re = a.getResultAsArray();
				for (int i = 0; i < results.length; i++) {
					results[i].setText(re[i]
							);
					
				}
			}
		});
		randomize.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int count = 0;
				for (int i = 0; i < x; i++) {
					for (int j = 0; j < y; j++) {
						int entry = r.nextInt(11);
						textfields[count].setText(entry+"");
						count++;
					}
				}
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Interface(4,5);
		
	}

}

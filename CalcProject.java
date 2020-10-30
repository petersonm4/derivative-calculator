import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CalcProject {

	public static void main(String[] args) {
	double start,stop;
	double interval,slope;
	double[] val=new double [1000];
	Scanner input = new Scanner(System.in);
	System.out.println("Enter a start for X");
	start=input.nextDouble();
	System.out.println("Enter a stop for X values");
	stop=input.nextDouble();
	if(stop<start) {
		System.out.println("Start must be before stop");
		System.exit(0);
	}
	else
	System.out.print("Enter file path: ");
	String outputFileName=input.next();
	try (PrintWriter fout = new PrintWriter(new File(outputFileName))) {
		fout.println("	x	f(x)	f'(x)");
		interval=((stop-start)/1000.00);
		for(double i=start; i<stop;i=i+interval) {
			double fpoint=i*i;
		slope=calc(i,fpoint);
		fout.printf("	%.2f",i);
		fout.printf("	%.2f",fpoint);
		fout.printf("	%.2f%n",slope);
		}	
		
	} catch (FileNotFoundException Ex) {
		// TODO Auto-generated catch block
		System.out.println("File Not found");
		System.exit(0);
	}
	
	}
	public static double  calc(double point,double fpoint) { 
		double slope=2*fpoint/point;
	return slope;
}
}
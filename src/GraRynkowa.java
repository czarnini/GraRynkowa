import java.util.ArrayList;

import ru.sscc.spline.Spline;
import ru.sscc.spline.analytic.GSplineCreator;
import ru.sscc.spline.reduction.ReducedMesh;
import ru.sscc.spline.reduction.StrictScatteredMesh;
import ru.sscc.util.CalculatingException;
import ru.sscc.util.data.DoubleVectors;
import ru.sscc.util.data.RealPointers;
import ru.sscc.util.data.RealVector;
import ru.sscc.util.data.RealVectors;

public class GraRynkowa
{
	
	public static void main(String args[]) throws CalculatingException
	  {
		  int[] tmp1 = {	5000,12000,	17000,	18000,	12000,	34000,	56000,	15000,	33000,	55000,	95000,	100000,	25000,	30000,	40000,	50000,	70000,	35000,	50000,	70000,	100000,	150000,0	}; 
		  int[] tmp2 =  { 50,	35,	51,	75,	85,	83,	80,	39,	35,	30,	25,	20,	20,	15,	10,	5,	1,	10,	10,	10,	10,	10,0};
		  double[] tmp3 = {9.37, 8.87,	9.26,	10.26,	11.16,	10.78,	10.44,	8.96,	8.69,	8.45,	8.33,	8.15,	8.19,	7.91,	7.57,	7.22,	6.93,	7.60,	7.54,	7.53,	7.63,	7.99, 0.0	};
		
		  ArrayList<Integer> wolumen = new ArrayList<Integer>();
		  ArrayList<Integer> jakosc = new ArrayList<Integer>();
		  ArrayList<Double> koszt = new ArrayList<Double>();
		  for(int i=0; i<tmp1.length; ++i)
		  {
			  wolumen.add(tmp1[i]);
			  jakosc.add(tmp2[i]);
			  koszt.add(tmp3[i]);
		  }
		  
		int k;
		int testIndex = 8;
		
		RealVectors spr = new DoubleVectors(2, 1);
		spr.set(0, 0, wolumen.get(testIndex));
		spr.set(0, 1, jakosc.get(testIndex));
		
		double shouldBe = koszt.get(testIndex);
		
		wolumen.remove(testIndex);
		jakosc.remove(testIndex);
		koszt.remove(testIndex);
		
		Double [] tmp4= new Double[tmp1.length-1];
		koszt.toArray(tmp4);
		
		tmp3 = new double[tmp4.length];
		
		for(int i=0; i<tmp4.length; ++i)
		{
			tmp3[i]=tmp4[i];
		}
		
		
	
		
		double interError=0;
		RealVectors mesh = new DoubleVectors(2, tmp1.length-1);
	
		for(int i=0; i<tmp1.length-1; ++i)
		{
			mesh.set(i, 0, wolumen.get(i));
			mesh.set(i, 1, jakosc.get(i));
		}
		
		
		
		
		
		RealPointers p = mesh.pointers();
		RealPointers test = spr.pointers();
		ReducedMesh rMesh =  new StrictScatteredMesh(mesh);
		Spline spl = GSplineCreator.createSpline(3, rMesh, tmp3);
		
	      System.out.println("Jest:"+spl.value(test)+"\tPowinno byc:"+shouldBe);

	       
	  }
	
	
}
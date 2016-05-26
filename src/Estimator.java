/**
 * Klasa maj�ca na celu estymowanie warto�ci Kosztu Jednostkowego Zmiennego
 * @author Micha� Bogucki, Marcin Janeczko, Aleksander Tym
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import ru.sscc.spline.Spline;
import ru.sscc.spline.analytic.GSplineCreator;
import ru.sscc.spline.reduction.ReducedMesh;
import ru.sscc.spline.reduction.StrictScatteredMesh;
import ru.sscc.util.CalculatingException;
import ru.sscc.util.data.DoubleVectors;
import ru.sscc.util.data.RealPointers;
import ru.sscc.util.data.RealVectors;

public class Estimator {
	 
	private int wolumen[],jakosc[];
	 private double[] kjz;
	 private Spline spl;
	
	
	Estimator()
	{
		Path file = Paths.get("KJZ.txt");
		try {
			BufferedReader reader = Files.newBufferedReader(file);
			String line = reader.readLine();
		
			wolumen = Arrays.stream( line.substring( 0,line.length()).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
			line = reader.readLine();
			jakosc = Arrays.stream( line.substring( 0,line.length()).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
			line = reader.readLine();
			kjz =Arrays.stream( line.substring( 0,line.length()).split(",")).map(String::trim).mapToDouble(Double::parseDouble).toArray();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		RealVectors mesh = new DoubleVectors(2, wolumen.length);
		for(int i=0; i<wolumen.length; ++i)
		{
			mesh.set(i, 0, wolumen[i]);
			mesh.set(i, 1, jakosc[i]);
		}

	
		ReducedMesh rMesh =  new StrictScatteredMesh(mesh);
		try {
			 spl = GSplineCreator.createSpline(3, rMesh, kjz);
		} catch (CalculatingException e) {
			e.printStackTrace();
		}

		
	}
	
	public double value(int wolumen, int jakosc)
	{
		RealVectors spr = new DoubleVectors(2, 1);
		spr.set(0, 0, wolumen);
		spr.set(0, 1, jakosc);
		RealPointers test = spr.pointers();
		System.out.println("Jest:"+spl.value(test));
		return spl.value(test);
	}
	
	public static void main(String args[])
	{
		Estimator estymator = new Estimator();
		estymator.value(5000, 50);
		
	}

}



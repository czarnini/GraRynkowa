	import java.util.*;

import ru.sscc.spline.analytic.*;
import ru.sscc.spline.*;
import ru.sscc.spline.reduction.*;
import ru.sscc.util.*;
import ru.sscc.util.data.*;

/** The test of 2D Duchon's spline interpolation on the quasi-regular
 * mesh in the square [0,1]x[0,1]. Use:<p>
 * <tt>java GInterpolation nodesPerDirection</tt><p>
 * If parameter is omitted, the default value 10 (10x10 mesh) is used.
 * The program prints a maximum interpolation error at mesh nodes.
 */
public class SplineTest
{
  public static double f(double x, double y)
  {
    return Math.sin(x)+Math.exp(-(x-.5)*(x-.5)-(y-.5)*(y-.5))+Math.cos(y);
  }

  public static void main(String args[]) throws CalculatingException
  {
    int nodes = 4;
    int n = nodes*nodes;

    // Prepare mesh and function
    RealVectors mesh = new DoubleVectors(2, n);
    double[] fun = new double[n];
    int i, j, k = 0;
    double h = 1./nodes, x, y;
    Random rand = new Random(238446234L);

    for (i=0; i<nodes; i++)
      for(j=0; j<nodes; j++, k++) {
        x = (i+rand.nextDouble())*h;
        y = (j+rand.nextDouble())*h;
        mesh.set(k,0,x);
        mesh.set(k,1,y);
        fun[k] = f(x,y);
      }

    // Create interpolating splines for different modes and
    // calculate the interpolation error
    System.out.println("Calculate spline at " + nodes + "x" + nodes +
                       " nodes");
    double interError;
    RealPointers p = mesh.pointers();
    ReducedMesh rMesh = new StrictScatteredMesh(mesh);
    Spline spl;

    for(int mode=0; mode<=3; mode++) {
      spl = GSplineCreator.createSpline(mode, rMesh, fun);
      for(interError=0, k=0; k<n; k++) {
        p.select(k);
        interError = Math.max(interError, Math.abs(spl.value(p)-fun[k]));
      }
      System.out.println("Mode = "+mode+". Interpolation error  "+interError);
    }
  }
}
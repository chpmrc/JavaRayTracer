import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class Sphere extends Shape{

	Vector3d center;
	double radius;
	
	public Sphere(Vector3d center, double radius){
		this.material = Color.blue; // Default material
		this.center = center;
		this.radius = radius;
	}

	public List<Vector3d> intersectWith(Ray r){
		List<Vector3d> intersections = new ArrayList<Vector3d>();
		Vector3d e = r.getOrigin();
		Vector3d d = r.getDirection();
		Vector3d dRev = Vector3d.reverse(d);
		Vector3d centerDist = e.sub(center);
		
		double params[] = new double[2];
		
		// Discriminant
		double delta = (double) (Math.pow(d.dotMul(centerDist), 2) -
				(centerDist.dotMul(centerDist) - Math.pow(radius, 2)));
		
		if (delta >= 0){
			params[0] = (double) (dRev.dotMul(centerDist) + Math.sqrt(delta));
			Vector3d inter1 = r.getPointByParam(params[0]);
			intersections.add(inter1);
			if (delta > 0){
				params[1] = (double) (dRev.dotMul(centerDist) - Math.sqrt(delta));
				Vector3d inter2 = r.getPointByParam(params[1]);
				intersections.add(inter2);
			}
		}
		
		return intersections;
	}
	
	public Vector3d getNormal(Vector3d p){
		// Unit normal
		return p.sub(center).div(radius);
	}
	
	public String toString(){
		return "Sphere: "+center+", "+radius;
	}
}

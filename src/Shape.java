import java.awt.Color;
import java.util.List;


public abstract class Shape {
	
	Color material; // color
	
	public Color getMaterial(){
		return material;
	}
	
	public void setMaterial(Color m){
		material = m;
	}
	
	public abstract List<Vector3d> intersectWith(Ray r);

	public abstract Vector3d getNormal(Vector3d p);
	
}
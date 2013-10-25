/**
 * A ray is defined by the parametric equation of a line
 * where the origin is a point on the ViewPlane and
 * the direction vector is a vector opposed to the back 
 * direction of the camera with magnitude 1.
 * @author Marco
 *
 */
public class Ray {
	Camera c;
	Vector3d origin;
	Vector3d direction;
	
	public Ray(Camera c, Vector3d o, Vector3d d){
		this.c = c;
		origin = o;
		direction = d;
	}
	
	/**
	 * Creates a ray by a set of given coordinates
	 * on the raster image (pixel).
	 * @param i
	 * @param j
	 */
	public static Ray createRay(Camera c, int i, int j){
		ViewPlane vp = c.getViewPlane();
		Image im = c.getImage();
		int nx = im.getWidth();
		int ny = im.getHeight();
		
		double u = vp.getL() + (vp.getR() - vp.getL()) * (i + 0.5f) / nx;
		double v = vp.getB() + (vp.getT() - vp.getB()) * (j + 0.5f) / ny;
		
		Vector3d origin = c.e.sum(c.u.mul(u).sum(c.v.mul(v)));
		Vector3d direction = Vector3d.reverse(c.getW());
		
		Ray r = new Ray(c, origin, direction);
		return r;
	}
	
	public Vector3d getPointByParam(double param){
		return origin.sum(direction.mul(param));
	}
	
	public String toString(){
		return "Ray: "+origin+", "+direction;
	}

	public Camera getCamera() {
		return c;
	}

	public void setCamera(Camera c) {
		this.c = c;
	}

	public Vector3d getOrigin() {
		return origin;
	}

	public void setOrigin(Vector3d origin) {
		this.origin = origin;
	}

	public Vector3d getDirection() {
		return direction;
	}

	public void setDirection(Vector3d direction) {
		this.direction = direction;
	}
	
}


/**
 * A camera is defined by a viewpoint (e),
 * two vectors u and v that help defining a plane
 * and w that defines the backwards direction of the camera.
 * @author Marco
 *
 */
public class Camera {
	Vector3d e;
	Vector3d v;
	Vector3d w;
	Vector3d u;
	ViewPlane viewPlane;
	Image image;

	public Camera(Vector3d position, Vector3d up, Vector3d right, Vector3d back, ViewPlane vp, Image i){
		this.e = position;
		this.v = up;
		this.w = back;
		this.u = right;
		viewPlane = vp;
		image = i;
	}
	
	public ViewPlane getViewPlane(){
		return viewPlane;
	}
	
	public Image getImage(){
		return image;
	}
	
	public Vector3d getW(){
		return w;
	}
	
	public Vector3d getE(){
		return e;
	}
	
	
	
	
}

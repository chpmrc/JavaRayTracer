import java.awt.Color;


public class Light {
	Vector3d position;
	Color intensity;
	
	public Light(Vector3d direction, Color intensity){
		this.position = direction;
		this.intensity = intensity;
	}
	
	public Color getIntensity(){
		return intensity;
	}
	
	public Vector3d getDirection(){
		return position;
	}
}

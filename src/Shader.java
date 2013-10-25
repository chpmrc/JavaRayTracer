import java.awt.Color;


public class Shader {
	Light ambientLight = new Light(new Vector3d(0, 0, 0), new Color(25, 25, 25));
	Color material;
	Light light;
	Shape shape;
	Vector3d intersection;
	
	public Shader(Light l, Shape s, Vector3d i){
		light = l;
		shape = s;
		intersection = i;
		material = s.getMaterial();
	}
	
	public int getLambertian(){
		Vector3d normal = shape.getNormal(intersection); // already normalized
		Vector3d lightDirection = light.position.sub(intersection).normalize();
		double diffuseCoefficient = Math.max(0, normal.dotMul(lightDirection));
		double intensities[] = new double[3];
		
		intensities[0] = light.getIntensity().getRed() / 255;
		intensities[1] = light.getIntensity().getGreen() / 255;
		intensities[2] = light.getIntensity().getBlue() / 255;

		int r = (int) Math.round(ambientLight.getIntensity().getRed() + material.getRed() * intensities[0] * diffuseCoefficient);
		int g = (int) Math.round(ambientLight.getIntensity().getGreen() + material.getGreen() * intensities[1] * diffuseCoefficient);
		int b = (int) Math.round(ambientLight.getIntensity().getBlue() + material.getBlue() * intensities[2] * diffuseCoefficient);
		
		r = (r > 255)? 255 : r;
		g = (g > 255)? 255 : g;
		b = (b > 255)? 255 : b;
		
		return new Color(r, g, b).getRGB();
	}
}

/**
 * A 3D vector is defined by 3 components: x, y and z.
 * @author Marco
 *
 */
public class Vector3d {
	
	double x, y, z;

	public Vector3d(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3d sum(Vector3d v){
		return new Vector3d(this.x + v.x, this.y + v.y, this.z + v.z);
	}
	
	public Vector3d sub(Vector3d v){
		return new Vector3d(this.x - v.x, this.y - v.y, this.z - v.z);
	}
	
	public Vector3d mul(double scalar){
		return new Vector3d(this.x * scalar, this.y * scalar, this.z * scalar);
	}
	
	public Vector3d div(double scalar){
		return new Vector3d(this.x / scalar, this.y / scalar, this.z /scalar);
	}
	
	public double dotMul(Vector3d v){
		return (this.x * v.x + this.y * v.y + this.z * v.z);
	}
	
	public double distanceTo(Vector3d v){
		return (double) Math.sqrt(
					Math.pow(v.x - this.x, 2) +
					Math.pow(v.y - this.y, 2) +
					Math.pow(v.z - this.z, 2)
				);
				
	}
	
	public static Vector3d reverse(Vector3d v){
		return new Vector3d(-v.x, -v.y, -v.z);
	}
	
	public double getMagnitude(){
		return (double) Math.sqrt(
					this.x * this.x +
					this.y * this.y + 
					this.z * this.z
				);
	}
	
	public Vector3d normalize(){
		double m = this.getMagnitude();
		return new Vector3d(this.x / m, this.y / m, this.z / m);
	}
	
	public String toString(){
		return "("+x+", "+y+", "+z+")";
	}
}

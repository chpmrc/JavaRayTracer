/**
 * A ViewPlane is defined by a width and a height
 * @author Marco
 *
 */
public class ViewPlane {
	double l, t, r, b;
	
	public ViewPlane(double left, double right, double bottom, double top){
		l = left;
		t = top;
		r = right;
		b = bottom;
	}

	/**
	 * @return the l
	 */
	public double getL() {
		return l;
	}

	/**
	 * @param l the l to set
	 */
	public void setL(double l) {
		this.l = l;
	}

	/**
	 * @return the t
	 */
	public double getT() {
		return t;
	}

	/**
	 * @param t the t to set
	 */
	public void setT(double t) {
		this.t = t;
	}

	/**
	 * @return the r
	 */
	public double getR() {
		return r;
	}

	/**
	 * @param r the r to set
	 */
	public void setR(double r) {
		this.r = r;
	}

	/**
	 * @return the b
	 */
	public double getB() {
		return b;
	}

	/**
	 * @param b the b to set
	 */
	public void setB(double b) {
		this.b = b;
	}
	
}

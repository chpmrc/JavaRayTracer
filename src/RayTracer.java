import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RayTracer {

	public static void main(String args[]) throws FileNotFoundException, IOException, ParseException {

		String configPath = "C:\\Users\\Marco\\Desktop\\config.json";

		JSONParser parser = new JSONParser();

		JSONObject root = (JSONObject) parser.parse(new FileReader(configPath));
		JSONObject cursor; // We will use this to scan the configuration
		JSONArray jsonObjects;
		
		// Create image
		cursor = (JSONObject) root.get("image");
		int imageWidth = Math.round((long) cursor.get("width"));
		int imageHeight = Math.round((long) cursor.get("height"));
		String outputPath = (String) cursor.get("output");

		Image image = new Image(imageWidth, imageHeight);
		image.fill(Color.black.getRGB());
		
		// Build the scene
		cursor = (JSONObject) root.get("scene");
		
		// Create light
		cursor = (JSONObject) cursor.get("light");
		Vector3d lightOrigin = new Vector3d((double) cursor.get("x"), (double) cursor.get("y"), (double) cursor.get("z"));
		Color lightIntensity = new Color(
				((Long) cursor.get("intensity")).intValue(), 
				((Long) cursor.get("intensity")).intValue(), 
				((Long)  cursor.get("intensity")).intValue());
		Light light = new Light(lightOrigin, lightIntensity);
		
		// Build the objects
		cursor = (JSONObject) root.get("scene");
		jsonObjects = (JSONArray) cursor.get("objects");
		
		List<Shape> objects = new ArrayList<Shape>();
		
		for (int i = 0; i < jsonObjects.size(); i++){
			JSONObject obj = (JSONObject) jsonObjects.get(i);
			String type = (String) obj.get("type");
			JSONObject properties = (JSONObject) obj.get("properties");
			String material = (String) properties.get("material");
			Shape newShape;
			
			switch(type){
				case "sphere" :
					Vector3d center = new Vector3d((double) properties.get("x"), (double) properties.get("y"), (double) properties.get("z"));
					double radius = (double) properties.get("radius");
					newShape = new Sphere(center, radius);
					break;
				default:
					throw new RuntimeException("Invalid shape specified. Check your configuration file.");
			}
			
			switch(material){
			case "red" : 
				newShape.setMaterial(new Color(255, 0, 0));
				break;
			case "green" :
				newShape.setMaterial(new Color(0, 0, 255));
				break;
			case "blue" :
				newShape.setMaterial(new Color(0, 0, 255));
				break;
			}
			
			objects.add(newShape);
		}

		// Setup camer and viewplane
		cursor = (JSONObject) root.get("scene");
		cursor = (JSONObject) cursor.get("camera");
		
		Vector3d cameraOrigin = new Vector3d(0, 0, 0);
		Vector3d cameraRight = new Vector3d(1, 0, 0);
		Vector3d cameraUp = new Vector3d(0, 1, 0);
		Vector3d cameraBack = new Vector3d(0, 0, 1);

		ViewPlane viewPlane = new ViewPlane(
				((Long)cursor.get("l")), 
				((Long)cursor.get("r")), 
				((Long)cursor.get("b")), 
				((Long)cursor.get("t")));

		Camera camera = new Camera(cameraOrigin, cameraUp, cameraRight,
				cameraBack, viewPlane, image);

		List<Vector3d> intersections;
		Shader shader;
		int finalColor;

		// Ray casting
		for (int i = 0; i < imageWidth; i++) {
			for (int j = 0; j < imageHeight; j++) {
				Ray r = Ray.createRay(camera, i, j);

				for (Shape s : objects) {
					// Compute intersection points
					intersections = s.intersectWith(r);
					// Compute shading
					if (intersections.size() > 0) {
						int whichInter = 0;
						if (intersections.get(1).distanceTo(r.getOrigin()) < intersections
								.get(0).distanceTo(r.getOrigin())) {
							whichInter = 1;
						}
						shader = new Shader(light, s,
								intersections.get(whichInter));
						finalColor = shader.getLambertian();

						image.writePixel(i, j, finalColor);
					}
					// Write pixel value to the raster
				}

			}
		}

		image.writeTiff(outputPath);

	}
}

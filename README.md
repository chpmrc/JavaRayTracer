JavaRayTracer
=============

A simple 3D ray tracer made in Java (only supports spheres, no phong shading). Assignment for the course "Computer Graphics" at Sabanci University.

An input as the following:

	{
		"scene" : {
			"camera" : {
				"l" : -500,
				"r" : 500,
				"b" : -200,
				"t" : 200
			},
		
			"light" : {
				"x" : -500.0,
				"y" : 200.0,
				"z" : 1000.0,
				"intensity" : 255
			},
		
			"objects" : [
				{
					"type" : "sphere",
					"properties" : {
						"x" : 0.0,
						"y" : 0.0,
						"z" : -1.0,
						"radius" : 30.0,
						"material" : "red"
					},
				    },

	{
					"type" : "sphere",
					"properties" : {
						"x" : -40.0,
						"y" : 0.0,
						"z" : -1.0,
						"radius" : 60.0,
						"material" : "blue"
					},
				    },{
					"type" : "sphere",
					"properties" : {
						"x" : 0.0,
						"y" : 0.0,
						"z" : -1.0,
						"radius" : 30.0,
						"material" : "red"
					},
				    },{
					"type" : "sphere",
					"properties" : {
						"x" : 0.0,
						"y" : 0.0,
						"z" : -1.0,
						"radius" : 30.0,
						"material" : "red"
					},
				    },

				    {
					"type" : "sphere",
					"properties" : {
						"x" : -40.0,
						"y" : 50.0,
						"z" : -5.0,
						"radius" : 50.0,
						"material" : "blue"
					}
				    },

				    {
					"type" : "sphere",
					"properties" : {
						"x" : 90.0,
						"y" : 0.0,
						"z" : -5.0,
						"radius" : 70.0,
						"material" : "green"
					}
				    }
		]

		},
	
		"image" : {
			"width" : 1000,
			"height" : 400,
			"output" : "output.bmp"  
		}
	
	}
	
would produce this image:

![Imgur](http://i.imgur.com/smCaibT.png)

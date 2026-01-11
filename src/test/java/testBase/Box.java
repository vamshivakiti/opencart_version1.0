package testBase;

public class Box {
double height,width,depth;
	Box(){
		height=width=depth=0;
	}
	Box(double h, double w, double d){
		height=h;
		width=w;
		depth=d;
	}
	
   double volue(){
    	return height*width*depth;
    }
	
}

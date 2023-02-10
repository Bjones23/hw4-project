package model;

public class Truck extends AbstractVehicle {
    private static final String MYIMAGEFILENAME = "truck.gif";
    private static final int MYDEATHTIME = 0;

    public Truck(int theX, int theY, Direction theDir){
       super(theX, theY,theDir,MYIMAGEFILENAME,MYDEATHTIME);



    }


}

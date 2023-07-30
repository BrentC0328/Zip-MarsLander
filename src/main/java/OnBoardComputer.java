public class OnBoardComputer implements BurnStream {
    private int burn;


    @Override
    public int getNextBurn(DescentEvent status){
        int altitude = status.getAltitude();
        int velocity = status.getVelocity();
        int mathmaticLanding = (velocity * velocity) / (altitude*2);

        if (altitude >= 4000 && velocity >= 600){
            burn = mathmaticLanding;
        } else if (altitude > 4000 && velocity > 500){
            burn = 100;
        }
        else if( altitude > 1000 || velocity > 250){
            burn = mathmaticLanding;
        } else if(velocity > 100) {
            burn = 230;
        }else if (velocity > 50){
            burn = 200;
        } else if (velocity > 35){
            burn = 135;
        }else if ( velocity > 5 ){
            burn = 106;
        } else if (velocity >= 3){
            burn = 102;
        }else if (velocity == 2 && altitude < 50){
            burn = 100;
        }else if (velocity > 0){
            burn = 99;
        } else if (velocity <= -3){
            burn = 90;
        } else {
            burn = 101;
        }



        return burn;
    }

}

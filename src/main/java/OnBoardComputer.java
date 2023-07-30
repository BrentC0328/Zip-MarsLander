public class OnBoardComputer implements BurnStream {
    private int burn;


    @Override
    public int getNextBurn(DescentEvent status){
        int altitude = status.getAltitude();
        int velocity = status.getVelocity();
        int mathmaticLanding = (velocity * velocity) / (altitude*2);

        if (altitude >= 6000 && velocity >= 600){
            burn = 200;
        } else if (altitude > 4000 && velocity > 400){
            burn = 100;
        } else if( altitude > 300 || velocity > 160){
            burn = mathmaticLanding;
        } else if (velocity > 50){
            burn = 170;
        } else if ( velocity > 5 ){
            burn = 106;
        } else if (velocity >= 3){
            burn = 102;
        }else if (velocity > 0){
            burn = 99;
        } else if (velocity <= -3){
            burn = 95;
        } else {
            burn = 101;
        }



        return burn;
    }

}

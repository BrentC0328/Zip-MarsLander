public class OnBoardComputer implements BurnStream {


    @Override
    public int getNextBurn(DescentEvent status){
        int altitude = status.getAltitude();
        int velocity = status.getVelocity();

        
        return 0;
    }

}

package Entities.concretes;

public class DefaultAccount extends IndividualAccount{
    private final double interest = 0;
    @Override
    public void setInterest(double interest) {
        super.setInterest(this.interest);
    }
}

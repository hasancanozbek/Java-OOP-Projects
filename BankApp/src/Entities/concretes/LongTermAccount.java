package Entities.concretes;

public class LongTermAccount extends IndividualAccount {
    private final double interest = 0.24;
    @Override
    public void setInterest(double interest) {
        super.setInterest(this.interest);
    }
}

package Entities.concretes;

public class ShortTermAccount extends IndividualAccount {
    private final double interest = 0.17;
    @Override
    public void setInterest(double interest) {
        super.setInterest(this.interest);
    }
}

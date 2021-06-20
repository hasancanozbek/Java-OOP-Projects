package Entities.concretes;

public class SpecialAccount extends IndividualAccount {

    private final double interest = 0.12;
    @Override
    public void setInterest(double interest) {
        super.setInterest(this.interest);
    }
}

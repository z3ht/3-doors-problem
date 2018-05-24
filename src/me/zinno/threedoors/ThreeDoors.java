package me.zinno.threedoors;

public class ThreeDoors {
	
	private long trials;
	
	public ThreeDoors() {
		this(1000);
	}
	
	public ThreeDoors(int trials) {
		setTrials(trials);
	}
	
	public double calculateOriginalChoiceSuccessRate() {
		int successAmount = 0;
		final long currentTrials = this.trials;
		long c = 0;
		while(c++ < currentTrials)
			successAmount += (individualOriginalChoiceSuccessRate()) ? 1 : 0;
		return (double) successAmount/currentTrials;
	}
	
	private boolean individualOriginalChoiceSuccessRate() {
		return Math.random() > Math.max(Math.random(), Math.random());
	}
	
	public long getTrials() {
		return trials;
	}
	
	public void setTrials(long trials) {
		if(trials < 1)
			this.trials = 1;
		else
			this.trials = trials;
	}
	
	public static void main(String[] args) {
		ThreeDoors threeDoors = new ThreeDoors(10000000);
		double originalChoiceSuccessRate = threeDoors.calculateOriginalChoiceSuccessRate();
		System.out.println("Originally Chosen Success: " + originalChoiceSuccessRate * 100 + "%");
		System.out.println("Swapped Success: " + (1 - originalChoiceSuccessRate) * 100 + "%");
	}
	
}

public class TaxFunction {

	private final int NonTaxSingleZeroChild = 54000000;
	private final int NonTaxMarried = 4500000;
	private final int NonTaxEachChild = 4500000; 

	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
		
		int tax = 0;
		
		if (isMarried) {
			tax = (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - (NonTaxMarried + nonTaxableByChild(numberOfChildren))));
		}else {
			tax = (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - NonTaxSingleZeroChild));
		}
		return tax;		 
	}

	private static int nonTaxableByChild(int numberOfChildren){
		int ChildLimit = 3;
		if (numberOfChildren > ChildLimit) {
			return ChildLimit*NonTaxEachChild;
		}
		return numberOfChildren*NonTaxEachChild;
	}
}

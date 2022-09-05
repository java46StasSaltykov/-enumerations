package telran.measure;

public class Length implements Comparable<Length> {
	private final float amount;
	private final LengthUnit unit;

	public Length(float amount, LengthUnit unit) {
		this.amount = amount;
		this.unit = unit;
	}

	@Override
	/**
	 * equals two Length objects according to LengthUnit 10m == 10000mm
	 */
	public boolean equals(Object obj) {
		return compareTo((Length) obj) == 0;
	}

	@Override
	public int compareTo(Length o) {

		return Float.compare(amount, o.convert(unit).amount);
	}

	/**
	 * 
	 * @param unit
	 * @return new Length object with a given LengthUnit convert(LengthUnit.M)
	 *         returns Length in meters
	 */
	public Length convert(LengthUnit unit) {

		return new Length(amount * this.unit.getValue() / unit.getValue(), unit);
	}

	@Override
	/**
	 * returns string with amount and length unit pinned to amount with no space
	 * Example: 20M (string expression of Length object designed 20 meters)
	 */
	public String toString() {
		String amountStr = Float.toString(amount);
		if (amountStr.matches(".*\\.0+")) {
			amountStr = amountStr.replaceAll("\\.0+", "");
		}
		return amountStr + unit.toString();
	}

	public float getAmount() {
		return amount;
	}

	public LengthUnit getUnit() {
		return unit;
	}

}
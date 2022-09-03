package telran.measure;

import java.text.DecimalFormat;

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
		if (((Length) obj).convert(this.unit).amount == amount) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Length o) {
		if (o.convert(this.unit).amount > this.amount) {
			return -1;
		} else if (o.convert(this.unit).amount < this.amount) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * 
	 * @param unit
	 * @return new Length object with a given LengthUnit convert(LengthUnit.M)
	 *         returns Length in meters
	 */
	public Length convert(LengthUnit unit) {
		float converted = amount / (unit.getValue() / this.unit.getValue());
		Length res = new Length(converted, unit);
		return res;
	}

	@Override
	/**
	 * returns string with amount and length unit pinned to amount with no space
	 * Example: 20M (string expression of Length object designed 20 meters)
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.#");
		return df.format(amount) + "" + unit;
	}

	public float getAmount() {
		return amount;
	}

	public LengthUnit getUnit() {
		return unit;
	}

}

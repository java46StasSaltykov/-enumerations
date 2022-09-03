package telran.measure;

public enum LengthUnit {
	MM(1f), CM(10f), IN(25.4f), FT(304.8f), M(1000f), KM(1000000f);

	float value;

	private LengthUnit(float value) {
		this.value = value;
	}

	public float getValue() {
		return value;
	}

	/**
	 * 
	 * @param l1
	 * @param l2
	 * @return Length object with amount of the LengthUnit LengthUnit.M.between (new
	 *         Length(200f, LengthUnit.CM), new Length(1f, LengthUnit.M)) ->
	 *         Length(1, LengthUnit.M)
	 */
	public Length between(Length l1, Length l2) {
		float l1Length = l1.convert(l1.getUnit()).getAmount();
		float l2Length = l2.convert(l1.getUnit()).getAmount();
		float res = l1Length - l2Length > 0 ? Math.round(l1Length - l2Length) : Math.round(l2Length - l1Length);
		Length lengthBetween = new Length(res, LengthUnit.M);
		return lengthBetween;
	}
}

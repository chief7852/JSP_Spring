package kr.or.ddit.enumpkg;

public enum OperatorEnum {
	PLUS("+"), MIN("-"), MULTI("*"), DIV("/"), REMAIN("%");

	OperatorEnum(String operator) {
		this.operator = operator;
	}

	private String operator;

	public String getOperator() {
		return this.operator;
	}

	public static String getOperator(String oper) {
		OperatorEnum[] types = OperatorEnum.values();

		OperatorEnum searched = PLUS;
		for (OperatorEnum tmp : types) {
			if (oper.contains(tmp.name())) {
				searched = tmp;
				break;
			}
		}
		String name = searched.getOperator();
		return name;
	}
}

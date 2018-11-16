package paquete1;

public enum Operaciones {
	SUMA("+") {
		@Override
		public double resultado(double ope1, double ope2) {
			// TODO Auto-generated method stub
			return ope1+ope2;
		}
	}, RESTA("-") {
		@Override
		public double resultado(double ope1, double ope2) {
			// TODO Auto-generated method stub
			return ope1-ope2;
		}
	}, MULTIPLICACION("*") {
		@Override
		public double resultado(double ope1, double ope2) {
			// TODO Auto-generated method stub
			return ope1*ope2;
		}
	}, DIVISION("/") {
		@Override
		public double resultado(double ope1, double ope2) {
			// TODO Auto-generated method stub
			return ope1/ope2;
		}
	};
	
	private String tipo;
	
	Operaciones(String tipo) {
		this.tipo = tipo;
	}
	
	public abstract double resultado(double ope1, double ope2);
}

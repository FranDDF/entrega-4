package cuentaBancaria;

public class PrincipalBanco {

	public static void main(String[] args) {
		CuentaAhorro cta1 = new CuentaAhorro(10000, 110);
		cta1.retirar(1000);
		cta1.retirar(1000);
		cta1.retirar(1000);
		cta1.retirar(1000);
		cta1.retirar(1000);
		cta1.extractoMensual();
		cta1.imprimir();

		

		
		

		
		
		

	}

}

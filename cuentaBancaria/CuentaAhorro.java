package cuentaBancaria;

public class CuentaAhorro extends Cuenta {
	private boolean activa;

	public CuentaAhorro(float saldo, float tasaAnual) {
		super(saldo, tasaAnual);
		estadoDeCuenta();
	}

	public boolean getActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	private void estadoDeCuenta() {
		setActiva(getSaldo() >= 10000);
	}

	@Override
	public void consignar(float cantidad) {
		if (getActiva()) {
			super.consignar(cantidad);
		} else {
			System.out.println("Error: su cuenta se encuentra inactiva.");
		}
	}

	@Override
	public void retirar(float cantidad) {
		if(getActiva()) {
			super.retirar(cantidad);
			System.out.println("Retiro exitoso.");
		}
		else if(getActiva() == false) {
			System.out.println("Error: su cuenta se encuentra inactiva");
		}
	}

	@Override
    public void extractoMensual() {
		super.extractoMensual();
		if(getNumeroRetiros() > 4) {
			setSaldo(getSaldo() - 1000);
		}
		estadoDeCuenta();
    }
	
	public int sumaTrx() {
		return getNumeroRetiros() + getNumeroConsignaciones();
	}
	
	public void imprimir() {
		System.out.println("Comisión mensual: $" + super.comisionMensual());
		if(getNumeroRetiros() > 4) {
			System.out.println("Comisión adicional por más de 4 retiros: $1000");
		}
		System.out.println("Número de transacciones realizadas: " + sumaTrx());
		System.out.println("Saldo final: $" + getSaldo());
	}
	
}

package cuentaBancaria;

public class CuentaCorriente extends Cuenta{
	protected float sobregiro;
	
	public CuentaCorriente(float saldo, float tasaAnual) {
		super(saldo, tasaAnual);
	}
	
	public float getSobregiro() {
		return sobregiro;
	}

	public void setSobregiro(float sobregiro) {
		this.sobregiro = sobregiro;
	}

	@Override
	public void retirar(float cantidad) {
		if(cantidad <= getSaldo()) {
			setSaldo(getSaldo() - cantidad);
			setNumeroRetiros(getNumeroRetiros() + 1);
		}
		else if (cantidad > getSaldo()) {
			setSobregiro(getSaldo() - cantidad);
			setSaldo(0);	
			setNumeroRetiros(getNumeroRetiros() + 1);
		}
	}
	
    @Override
    public void consignar(float cantidad) {
        if(cantidad > 0) {
            if(sobregiro > 0) {
                if(cantidad >= sobregiro) {
                    cantidad -= sobregiro;
                    sobregiro = 0;
                } else {
                    sobregiro -= cantidad;
                    cantidad = 0;
                }
            }
            if(cantidad > 0) {
                super.consignar(cantidad);
            }
        } else {
            System.out.println("Error: la cantidad a consignar debe ser mayor a 0");
        }
    }
	
	@Override
    public void extractoMensual() {
		super.extractoMensual();
    }
	
	public int sumaTrx() {
		return getNumeroRetiros() + getNumeroConsignaciones();
	}
	
	public void imprimir() {
		System.out.println("Saldo: $" + getSaldo());
		System.out.println("Comisión mensual: $" + getComisionMensual());
		System.out.println("Número de transacciones realizadas: " + sumaTrx());
		System.out.println("Sobregiro: " + getSobregiro());
	}
	



	
	
	
	
	
	
	
	
	
}

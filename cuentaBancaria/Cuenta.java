package cuentaBancaria;

public class Cuenta {
	private float saldo;
	private int numeroConsignaciones = 0;
	private int numeroRetiros = 0;
	private float tasaAnual;
	private float comisionMensual = 0.03f;
	
	public Cuenta(float saldo, float tasaAnual) {
		this.saldo = saldo;
		this.tasaAnual = tasaAnual;
	}
	
	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public int getNumeroConsignaciones() {
		return numeroConsignaciones;
	}

	public void setNumeroConsignaciones(int numeroConsignaciones) {
		this.numeroConsignaciones = numeroConsignaciones;
	}

	public int getNumeroRetiros() {
		return numeroRetiros;
	}

	public void setNumeroRetiros(int numeroRetiros) {
		this.numeroRetiros = numeroRetiros;
	}

	public float getTasaAnual() {
		return tasaAnual;
	}

	public void setTasaAnual(float tasaAnual) {
		this.tasaAnual = tasaAnual;
	}

	public float getComisionMensual() {
		return comisionMensual;
	}

	public void setComisionMensual(float comisionMensual) {
		this.comisionMensual = comisionMensual;
	}
	
	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + ", numeroConsignaciones=" + numeroConsignaciones + ", numeroRetiros="
				+ numeroRetiros + ", tasaAnual=" + tasaAnual + ", comisionMensual=" + comisionMensual + "]";
	}

	public void consignar(float cantidad) {
		if(cantidad > 0) {
			setSaldo(getSaldo() + cantidad);
			System.out.println("Consignación exitosa.");
			setNumeroConsignaciones(getNumeroConsignaciones() + 1);
		}
		else {
			System.out.println("La cantidad a consignar debe ser mayor a 0.");
		}
	}
	
	public void retirar(float cantidad) {
		if(cantidad <= getSaldo() && cantidad > 0) {
			setSaldo(getSaldo() - cantidad);
			setNumeroRetiros(getNumeroRetiros() + 1);
		}
		else { 
			System.out.println("Error: el importe a retirar no puede ser mayor al saldo disponible");
		}
	}
	
    public void calcularInteres() {
        float interesMensual = (getTasaAnual() / 12) / 100;
        setSaldo(getSaldo() + getSaldo() * interesMensual);
    }
    
    public float comisionMensual() {
    	return (getSaldo() * getComisionMensual());
    }
	
    public void extractoMensual() {
        setSaldo(getSaldo() - comisionMensual());
        calcularInteres();
    }
}

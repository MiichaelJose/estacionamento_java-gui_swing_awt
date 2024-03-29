package domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Estacionamento {
	
	private String vaga;
	private String placa;
	private Date data;
	private String horaEntrada, hE;
	private String horaSaida, hS;
	private double valorHora;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Estacionamento() {
		
	}
	
	public Estacionamento(Date data) {
		this.data = data;
	}
	
	public Estacionamento(String placa, Date data) {
		this.placa = placa;
		this.data = data;
	}
	
	public Estacionamento(String vaga, String placa, Date data, String horaEntrada, String horaSaida, double valorHora) {
		this.vaga = vaga;
		this.placa = placa;
		this.data = data;
		this.horaSaida = horaSaida;
		this.horaEntrada = horaEntrada;
		this.valorHora = valorHora;
	}
	
	private double getTotal() {
		double result = 0;
		if (horaSaida.equals("Estacionado")) {
			horaSaida = "Estacionado";
		}else {
			hE = horaEntrada.replaceAll(":",".");
			hS = horaSaida.replaceAll(":",".");
			double var = Double.parseDouble(hS);
			double var2 = Double.parseDouble(hE);
			result = (var - var2) * valorHora;
			if (var-var2 < 0.60) {
				result = getValorHora();	
			}
		}
		
		return result;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(data, placa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estacionamento other = (Estacionamento) obj;
		return Objects.equals(data, other.data) && Objects.equals(placa, other.placa);
	}

	@Override
	public String toString() {
		return vaga + "\t" + placa + "\t" + sdf.format(data) + "\t" + horaEntrada
				+ "\t" + horaSaida + "\t" + valorHora +"\t"+String.format("%.2f",getTotal())+"\n"; // "+String.format("%.2f",getTotal())+"
	}
	
	
	public String toCSV() {
		return vaga + ";" + placa + ";" + sdf.format(data) + ";" + horaEntrada
				+ ";" + horaSaida + ";" + valorHora + "\n";
	}
	// GETTERS AND SETTERS
	
	public String getVaga() {
		return vaga;
	}

	public void setVaga(String vaga) {
		this.vaga = vaga;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	
	
}

package br.rogerio.backend.dto;

import java.math.BigDecimal;
import java.util.List;

public class TotalProventoDTO {	
	private BigDecimal total;
	private List<ProventoAnoDTO> anos;
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public List<ProventoAnoDTO> getAnos() {
		return anos;
	}
	public void setAnos(List<ProventoAnoDTO> anos) {
		this.anos = anos;
	}
	public TotalProventoDTO(BigDecimal total, List<ProventoAnoDTO> anos) {
		this.total = total;
		this.anos = anos;
	}			
}

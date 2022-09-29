package br.rogerio.backend.dto;

import br.rogerio.backend.model.Ativo;

public class StatsDTO {
	private long userCount;
	private Ativo ativo;
	public long getUserCount() {
		return userCount;
	}
	public void setUserCount(long userCount) {
		this.userCount = userCount;
	}
	public Ativo getAtivo() {
		return ativo;
	}
	public void setAtivo(Ativo ativo) {
		this.ativo = ativo;
	}
	public StatsDTO(long userCount, Ativo ativo) {
		this.userCount = userCount;
		this.ativo = ativo;
	}

	
}

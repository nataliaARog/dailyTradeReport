package model;

import java.io.Serializable;

public class Report implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String entity;	
	private String incoming;	
	private String outgoing;
	private String instructionDate;
	private String settlementDate;

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getIncoming() {
		if(this.incoming == null) {
			incoming = "0";
		}
		return incoming;
	}

	public void setIncoming(String incoming) {
		this.incoming = incoming;
	}

	public String getOutgoing() {
		if(this.outgoing == null) {
			outgoing = "0";
		}
		return outgoing;
	}

	public void setOutgoing(String outgoing) {
		this.outgoing = outgoing;
	}

	public String getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(String instructionDate) {
		this.instructionDate = instructionDate;
	}

	public String getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}
}

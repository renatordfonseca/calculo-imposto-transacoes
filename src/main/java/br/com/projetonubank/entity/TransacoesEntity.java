package br.com.projetonubank.entity;

public class TransacoesEntity {
	
	private String operation;
    private double unitCost;
    private int quantity;
    
    public TransacoesEntity(String operation, int quantity, double unitCost) {
        this.operation = operation;
        this.quantity = quantity;
        this.unitCost = unitCost;
    }
    
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

package util;

public enum BuyOrSell {

	BUY('B'), SELL('S');
	
	private char buyOrSell = 0;

	BuyOrSell(char buyOrSell) {
        this.buyOrSell = buyOrSell;
    }

	public char getBuyOrSell() {
		return buyOrSell;
	}

	public void setBuyOrSell(char buyOrSell) {
		this.buyOrSell = buyOrSell;
	}	
	
}

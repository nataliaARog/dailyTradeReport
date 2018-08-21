package mockData;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Instruction;
import util.BuyOrSell;

public class InstructionMock {

	private InstructionMock() {
		
	}
	
	public static List<Instruction> getMockInstructions() {
		List<Instruction> instructions = new ArrayList<>();
		Instruction instruction = new Instruction();
		
		instruction.setEntity("foo");
		instruction.setBuySell(BuyOrSell.BUY.getBuyOrSell());
		instruction.setAgreedFx(new BigDecimal("0.55"));
		instruction.setCurrency("AED");
		instruction.setInstructionDate(LocalDate.of(2016, 1, 3));
		instruction.setSettlementDate(LocalDate.of(2016, 1, 5));
		instruction.setUnits(300);
		instruction.setPricePerUnit(new BigDecimal("110.45"));
		instructions.add(instruction);
		
		instruction = new Instruction();		
		instruction.setEntity("foo");
		instruction.setBuySell(BuyOrSell.SELL.getBuyOrSell());
		instruction.setAgreedFx(new BigDecimal("0.55"));
		instruction.setCurrency("AED");
		instruction.setInstructionDate(LocalDate.of(2016, 1, 3));
		instruction.setSettlementDate(LocalDate.of(2016, 1, 5));
		instruction.setUnits(100);
		instruction.setPricePerUnit(new BigDecimal("110.45"));
		instructions.add(instruction);
		
		instruction = new Instruction();		
		instruction.setEntity("bar");
		instruction.setBuySell(BuyOrSell.BUY.getBuyOrSell());
		instruction.setAgreedFx(new BigDecimal("1.50"));
		instruction.setCurrency("EUR");
		instruction.setInstructionDate(LocalDate.of(2016, 1, 10));
		instruction.setSettlementDate(LocalDate.of(2016, 1, 12));
		instruction.setUnits(500);
		instruction.setPricePerUnit(new BigDecimal("200.65"));
		instructions.add(instruction);
		
		instruction = new Instruction();		
		instruction.setEntity("test");
		instruction.setBuySell(BuyOrSell.SELL.getBuyOrSell());
		instruction.setAgreedFx(new BigDecimal("0.75"));
		instruction.setCurrency("CAD");
		instruction.setInstructionDate(LocalDate.of(2016, 1, 20));
		instruction.setSettlementDate(LocalDate.of(2016, 1, 22));
		instruction.setUnits(500);
		instruction.setPricePerUnit(new BigDecimal("120.25"));
		instructions.add(instruction);
		
		return instructions;
	}
	
}

package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import mockData.InstructionMock;
import model.Instruction;
import model.Report;
import util.BuyOrSell;
import util.Formatter;

public class ReportBuilder {

	private static List<Report> execute(List<Instruction> instructions) {
		List<Report> reports = new ArrayList<>();
			
		instructions.stream().forEach(instruction -> {
			Report report = new Report();
			report.setEntity(instruction.getEntity());
			report.setSettlementDate(Formatter.format(ReportBuilderHelper.setSettlementDate(instruction.getSettlementDate(), instruction.getCurrency())));
						
			if(BuyOrSell.BUY.getBuyOrSell() == instruction.getBuySell()) {
				report.setIncoming(Formatter.format(ReportBuilderHelper.calculate(instruction.getPricePerUnit(), instruction.getUnits(), instruction.getAgreedFx())));
								
			} else if(BuyOrSell.SELL.getBuyOrSell() == instruction.getBuySell()) {
				report.setOutgoing(Formatter.format(ReportBuilderHelper.calculate(instruction.getPricePerUnit(), instruction.getUnits(), instruction.getAgreedFx())));
			}
			
			reports.add(report);	
			
		});
		
		return reports;
		
	}
	
	private static void printReports(List<Report> reports) {
		System.out.println("Entity          Outgoing Amount          Incoming Amount          Date");
		
		Collections.reverse(reports);
		
		reports.stream().forEach(r -> {
			System.out.format("%1s%27s%25s%23s",r.getEntity(),r.getOutgoing(),r.getIncoming(),r.getSettlementDate()+"\n");
		});
	}
	
	
	public static void main(String[] args) {		
		printReports(execute(InstructionMock.getMockInstructions()));

	}

}

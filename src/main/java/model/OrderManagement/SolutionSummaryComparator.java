// package model.OrderManagement;

// import java.util.Comparator;

// public class SolutionSummaryComparator implements Comparator<SolutionSummary>
// {

// String sortingRule;

// public SolutionSummaryComparator(String sortingRule) {
// this.sortingRule = sortingRule;
// }

// @Override
// public int compare(SolutionSummary o1, SolutionSummary o2) {
// if (sortingRule.equals("Name")) {
// return
// o1.getSubjectSupplier().getName().compareTo(o2.getSubjectSupplier().getName());
// }

// return (-1) * Double.compare(o1.getSolutionOrderRevenues(),
// o2.getSolutionOrderRevenues());
// }

// }
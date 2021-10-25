package com.sshmygin.detfinautomaton.automaton.deterministic;

import com.sshmygin.detfinautomaton.automaton.FiniteStateAutomaton;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@ToString
public class DeterministicFiniteStateAutomaton extends FiniteStateAutomaton {

    private Map<Integer, List<Integer>> transitionTable;

    public DeterministicFiniteStateAutomaton() {
        super();
    }

    public DeterministicFiniteStateAutomaton(Set<Integer> automatonStateSet,
                                             List<String> alphabet,
                                             Integer beginningState,
                                             Set<Integer> endingStateSet,
                                             Map<Integer, List<Integer>> transitionTable) {
        super(automatonStateSet, alphabet, beginningState, endingStateSet);
        this.transitionTable = transitionTable;
    }

    public boolean wordAcceptable(String word) {

        System.out.println("word: " + word);

        int currentState = this.getBeginningState();
        String[] input = word.split("");

        try {
            for(String symbol: input) {
                int index = getAlphabet().indexOf(symbol);

                int previousState = currentState;
                currentState = transitionTable.get(currentState).get(index);
                System.out.println(previousState + " -> " + currentState);
            }
        } catch (NullPointerException e) {
            return false;
        }
        
        boolean result = false;

        for (int i = 0; i < endingStateSet.size(); i++) {
            if (endingStateSet.contains(currentState)) {
                result = true;
                break;
            }
        }
        return result;
    }
}

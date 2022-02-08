package com.sshmygin.automatons.automaton.nondeterministic;

import com.sshmygin.automatons.automaton.FiniteStateAutomaton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NondeterministicFiniteStateAutomaton extends FiniteStateAutomaton {

    protected Map<Integer, List<List<Integer>>> transitionTable;

    public NondeterministicFiniteStateAutomaton() {
        super();
    }

    public NondeterministicFiniteStateAutomaton(NFSAData data) {
        super(data.getAutomatonStateSet(), data.getAlphabet(), data.getBeginningState(), data.getEndingStateSet());
        this.transitionTable = data.getTransitionTable();
    }

    @Override
    public boolean wordAcceptable(String word) {

        List<Integer> finalStateSet = new ArrayList<>();
        List<Integer> list = List.of(beginningState);
        System.out.println(list);
        String[] wordChars = word.split("");
        process(finalStateSet, list, 0, wordChars);

        System.out.println(finalStateSet);

        boolean result = false;
        for (int state : endingStateSet) {
            if (finalStateSet.contains(state)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void process(List<Integer> finalStateSet, List<Integer> currentStateSet, int wordIndex, String[] wordChars) {

        System.out.println(wordIndex);
        if (currentStateSet.contains(-1)) {
            return;
        }

        if (wordIndex == wordChars.length - 1) {
            finalStateSet.addAll(currentStateSet);
            return;
        }

        for (int state : currentStateSet) {
            int symbolIndex = alphabet.indexOf(wordChars[wordIndex]);
            process(finalStateSet, transitionTable.get(state).get(symbolIndex), wordIndex + 1, wordChars);
        }
    }
}

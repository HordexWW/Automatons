package com.sshmygin.detfinautomaton.automaton.nondeterministic;

import com.sshmygin.detfinautomaton.automaton.FiniteStateAutomaton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NondeterministicFiniteStateAutomaton extends FiniteStateAutomaton {

    private Map<Integer, List<List<Integer>>> transitionTable;

    public NondeterministicFiniteStateAutomaton() {
        super();
    }

    public NondeterministicFiniteStateAutomaton(Set<Integer> automatonStateSet,
                                                List<String> alphabet,
                                                Integer beginningState,
                                                List<Integer> endingStateSet,
                                                Map<Integer, List<List<Integer>>> transitionTable) {
        super(automatonStateSet, alphabet, beginningState, endingStateSet);
        this.transitionTable = transitionTable;
    }

    @Override
    public boolean wordAcceptable(String word) {

        List<Integer> finalStateSet = new ArrayList<>();
        List<Integer> list = List.of(beginningState);
        System.out.println(list);
        String[] wordChars = word.split("");
        process(finalStateSet,list, 0, wordChars);
        return true;
    }

    public void process(List<Integer> finalStateSet, List<Integer> currentStateSet,
                       int wordIndex, String[] wordChars) {


        if (currentStateSet.contains(-1)) {
            return;
        }

        if (wordIndex == wordChars.length) {
            finalStateSet.addAll(currentStateSet);
            return;
        }

        for (int state : currentStateSet) {
            int symbolIndex = alphabet.indexOf(wordChars[wordIndex]);
            process(finalStateSet, transitionTable.get(state).get(symbolIndex), wordIndex + 1, wordChars);
        }

        if (wordIndex != 0)
            return;


        boolean result = false;
        for (int state : endingStateSet) {
            if (finalStateSet.contains(state)) {
                result = true;
                break;
            }
        }

        if (result) {
            System.out.println("Строка принята.");
        } else {
            System.out.println("Строка отвергнута.");
        }

    }
}

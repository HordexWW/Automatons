package com.sshmygin.automatons.automaton;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public abstract class FiniteStateAutomaton {
    protected Set<Integer> automatonStateSet;
    protected List<String> alphabet;
    protected Integer beginningState;
    protected List<Integer> endingStateSet;


    public FiniteStateAutomaton() {
    }


    public FiniteStateAutomaton(Set<Integer> automatonStateSet,
                                List<String> alphabet,
                                Integer beginningState,
                                List<Integer> endingStateSet) {
        this.automatonStateSet = automatonStateSet;
        this.alphabet = alphabet;
        this.beginningState = beginningState;
        this.endingStateSet = endingStateSet;
    }

    public abstract boolean wordAcceptable(String word);
}

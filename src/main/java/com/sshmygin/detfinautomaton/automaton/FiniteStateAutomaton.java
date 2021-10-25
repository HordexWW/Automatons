package com.sshmygin.detfinautomaton.automaton;

import com.sun.jdi.IntegerType;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class FiniteStateAutomaton {
    protected Set<Integer> automatonStateSet;
    protected List<String> alphabet;
    protected Integer beginningState;
    protected Set<Integer> endingStateSet;


    public FiniteStateAutomaton() {
    }


    public FiniteStateAutomaton(Set<Integer> automatonStateSet,
                                List<String> alphabet,
                                Integer beginningState,
                                Set<Integer> endingStateSet) {
        this.automatonStateSet = automatonStateSet;
        this.alphabet = alphabet;
        this.beginningState = beginningState;
        this.endingStateSet = endingStateSet;
    }
}

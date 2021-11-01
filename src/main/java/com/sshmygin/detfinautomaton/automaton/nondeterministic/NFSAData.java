package com.sshmygin.detfinautomaton.automaton.nondeterministic;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class NFSAData {
    private Set<Integer> automatonStateSet;
    private List<String> alphabet;
    private Integer beginningState;
    private List<Integer> endingStateSet;
    private Map<Integer, List<List<Integer>>> transitionTable;
}

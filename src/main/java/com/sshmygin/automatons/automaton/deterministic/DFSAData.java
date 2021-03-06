package com.sshmygin.automatons.automaton.deterministic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DFSAData {
    private Set<Integer> automatonStateSet;
    private List<String> alphabet;
    private Integer beginningState;
    private List<Integer> endingStateSet;
    private Map<Integer, List<Integer>> transitionTable;
}

package com.sshmygin.detfinautomaton.filereader.deterministic;

import java.util.List;

@lombok.Data
public class RawDFSAData {
    private int numOfStates;
    private List<String> alphabet;
    private List<List<Integer>> transitionTable;
    private Integer beginningState;
    private List<Integer> endingStateSet;
}

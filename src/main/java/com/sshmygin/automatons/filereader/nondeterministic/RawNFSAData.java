package com.sshmygin.automatons.filereader.nondeterministic;

import java.util.List;

@lombok.Data
public class RawNFSAData {
    private int numOfStates;
    private List<String> alphabet;
    private List<List<List<Integer>>> transitionTable;
    private Integer beginningState;
    private List<Integer> endingStateSet;
}

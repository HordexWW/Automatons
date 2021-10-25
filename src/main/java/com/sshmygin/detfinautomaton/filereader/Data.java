package com.sshmygin.detfinautomaton.filereader;

import java.util.List;

@lombok.Data
public class Data {
    private int numOfStates;
    private List<String> alphabet;
    private List<List<Integer>> transitionTable;
    private Integer beginningState;
    private List<Integer> endingStateSet;
}

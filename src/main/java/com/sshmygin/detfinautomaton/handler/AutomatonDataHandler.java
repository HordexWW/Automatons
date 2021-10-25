package com.sshmygin.detfinautomaton.handler;

import com.sshmygin.detfinautomaton.automaton.DFSAData;
import com.sshmygin.detfinautomaton.filereader.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AutomatonDataHandler {

    public DFSAData getDFSAData (Data data) {
        DFSAData dfsaData = new DFSAData();
        dfsaData.setAlphabet(data.getAlphabet());

        Set<Integer> automatonStateSet = new HashSet<>();
        for (int i = 0; i < data.getNumOfStates(); i++) {
            automatonStateSet.add(i);
        }
        dfsaData.setAutomatonStateSet(automatonStateSet);

        Map<Integer, List<Integer>> transitionData = new HashMap<>();
        List<List<Integer>> table = data.getTransitionTable();
        for (int i = 0; i < data.getNumOfStates(); i++) {
            List<Integer> listOfTransition = table.get(i);
            transitionData.put(i, listOfTransition);
        }
        dfsaData.setTransitionTable(transitionData);

        dfsaData.setBeginningState(data.getBeginningState());


        HashSet<Integer> endingStateSet = new HashSet<>(data.getEndingStateSet());
        dfsaData.setEndingStateSet(endingStateSet);

        return dfsaData;


    }
}

package com.sshmygin.detfinautomaton.handler;

import com.sshmygin.detfinautomaton.automaton.deterministic.DFSAData;
import com.sshmygin.detfinautomaton.automaton.nondeterministic.NFSAData;
import com.sshmygin.detfinautomaton.filereader.deterministic.RawDFSAData;
import com.sshmygin.detfinautomaton.filereader.nondeterministic.RawNFSAData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AutomatonDataHandler {

    public DFSAData getDFSAData(RawDFSAData data) {
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

        List<Integer> endingStateSet = new ArrayList<>(data.getEndingStateSet());
        dfsaData.setEndingStateSet(endingStateSet);

        return dfsaData;
    }

    public NFSAData getNFSAData(RawNFSAData data) {
        NFSAData nfsaData = new NFSAData();
        nfsaData.setAlphabet(data.getAlphabet());

        Set<Integer> automatonStateSet = new HashSet<>();
        for (int i = 0; i < data.getNumOfStates(); i++) {
            automatonStateSet.add(i);
        }
        nfsaData.setAutomatonStateSet(automatonStateSet);

        Map<Integer, List<List<Integer>>> transitionData = new HashMap<>();
        List<List<List<Integer>>> table = data.getTransitionTable();
        for (int i = 0; i < data.getNumOfStates(); i++) {
            List<List<Integer>> tableRow = data.getTransitionTable().get(i);
            transitionData.put(i, tableRow);
        }
        nfsaData.setTransitionTable(transitionData);

        nfsaData.setBeginningState(data.getBeginningState());

        nfsaData.setEndingStateSet(new ArrayList<>(data.getEndingStateSet()));

        return nfsaData;
    }
}

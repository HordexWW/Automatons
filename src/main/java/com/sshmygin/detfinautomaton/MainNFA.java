package com.sshmygin.detfinautomaton;

import com.sshmygin.detfinautomaton.automaton.nondeterministic.NFSAData;
import com.sshmygin.detfinautomaton.automaton.nondeterministic.NondeterministicFiniteStateAutomaton;
import com.sshmygin.detfinautomaton.filereader.nondeterministic.NFAPropertyReader;
import com.sshmygin.detfinautomaton.filereader.nondeterministic.RawNFSAData;
import com.sshmygin.detfinautomaton.handler.AutomatonDataHandler;

import java.util.ArrayList;
import java.util.List;

public class MainNFA {
    public static void main(String[] args) {
//        String filePath = "/Users/sshmygin/Documents/projects/SSU/DetFinAutomate/src/main/resources/NFAinput.txt";
        String filePath = "/Users/sshmygin/Documents/projects/SSU/DetFinAutomate/src/main/resources/NFAInput2.txt";

        NFAPropertyReader reader = new NFAPropertyReader();
        RawNFSAData rawData = reader.getAutomatonProperties(filePath);

        AutomatonDataHandler dataHandler = new AutomatonDataHandler();
        NFSAData nfsaData = dataHandler.getNFSAData(rawData);

        System.out.println(nfsaData);

        NondeterministicFiniteStateAutomaton automaton = new NondeterministicFiniteStateAutomaton(
                nfsaData.getAutomatonStateSet(),
                nfsaData.getAlphabet(),
                nfsaData.getBeginningState(),
                nfsaData.getEndingStateSet(),
                nfsaData.getTransitionTable()
        );

//        System.out.println(automaton.wordAcceptable(""));

        List<Integer> states = new ArrayList<>(automaton.getEndingStateSet());

        automaton.wordAcceptable("abbbb");

    }
}

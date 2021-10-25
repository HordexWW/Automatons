package com.sshmygin.detfinautomaton;

import com.sshmygin.detfinautomaton.automaton.DFSAData;
import com.sshmygin.detfinautomaton.automaton.deterministic.DeterministicFiniteStateAutomaton;
import com.sshmygin.detfinautomaton.filereader.Data;
import com.sshmygin.detfinautomaton.filereader.TXTPropertyReader;
import com.sshmygin.detfinautomaton.handler.AutomatonDataHandler;

public class Main {
    public static void main(String[] args) {
        String path = "/Users/sshmygin/Documents/projects/SSU/DetFinAutomate/src/main/resources/inputData.txt";

        TXTPropertyReader reader = new TXTPropertyReader();
        Data automatonProperties = reader.getAutomatonProperties(path);

        AutomatonDataHandler automatonDataHandler = new AutomatonDataHandler();
        DFSAData data = automatonDataHandler.getDFSAData(automatonProperties);

        System.out.println(data);

        DeterministicFiniteStateAutomaton automaton = new DeterministicFiniteStateAutomaton(
                data.getEndingStateSet(),
                data.getAlphabet(),
                data.getBeginningState(),
                data.getEndingStateSet(),
                data.getTransitionTable()
                );

        String y1 = "bcabcabca";
        String n1 = "bccc";
        String e1 = "ccc";

        System.out.println(automaton.wordAcceptable(n1));
        System.out.println(automaton.wordAcceptable(y1));
        System.out.println(automaton.wordAcceptable(e1));
        System.out.println(automaton.wordAcceptable("d"));
    }
}

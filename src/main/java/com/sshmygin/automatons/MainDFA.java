package com.sshmygin.automatons;

import com.sshmygin.automatons.automaton.FiniteStateAutomaton;
import com.sshmygin.automatons.automaton.deterministic.DFSAData;
import com.sshmygin.automatons.automaton.deterministic.DeterministicFiniteStateAutomaton;
import com.sshmygin.automatons.filereader.deterministic.RawDFSAData;
import com.sshmygin.automatons.filereader.deterministic.DFSAPropertyReader;
import com.sshmygin.automatons.handler.AutomatonDataHandler;

public class MainDFA {
    public static void main(String[] args) {
        String path = "/Users/sshmygin/Documents/projects/SSU/DetFinAutomate/src/main/resources/inputData.txt";

        DFSAPropertyReader reader = new DFSAPropertyReader();
        RawDFSAData automatonProperties = reader.getAutomatonProperties(path);

        AutomatonDataHandler automatonDataHandler = new AutomatonDataHandler();
        DFSAData data = automatonDataHandler.getDFSAData(automatonProperties);

        System.out.println(data);

        FiniteStateAutomaton automaton = new DeterministicFiniteStateAutomaton(data);

        String y1 = "bcabcabca";
        String n1 = "bccc";
        String e1 = "ccc";

        System.out.println(automaton.wordAcceptable(n1));
        System.out.println(automaton.wordAcceptable(y1));
        System.out.println(automaton.wordAcceptable(e1));
        System.out.println(automaton.wordAcceptable("d"));
    }
}
